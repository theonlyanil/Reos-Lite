// bulbs.js: Web Bluetooth connection manager for Reos Lite bulbs.
//  - tracks every paired bulb and keeps it connected
//  - reconnects with backoff, then waits for the bulb's advertisement (if supported)
//  - per-bulb "latest wins" write queue so fast slider drags never interleave writes
import { ReosProtocol, NAME_PREFIX } from './protocol.js';

const MAX_BACKOFF_MS = 30000;
const QUICK_RETRIES = 3;

/** @typedef {'connecting'|'connected'|'searching'} BulbStatus */

export class BulbManager {
  /**
   * @param {{log:(msg:string,type?:string)=>void, onChange:()=>void}} hooks
   */
  constructor({ log, onChange }) {
    this.log = log;
    this.onChange = onChange;
    /** @type {Map<string, any>} */
    this.bulbs = new Map();
  }

  get connectedCount() {
    let n = 0;
    for (const b of this.bulbs.values()) if (b.status === 'connected') n++;
    return n;
  }

  knownNames() {
    return [...this.bulbs.values()].map((b) => b.name).filter(Boolean);
  }

  /** Start managing a (newly paired or previously permitted) device. */
  add(device) {
    if (this.bulbs.has(device.id)) return this.bulbs.get(device.id);
    const bulb = {
      id: device.id,
      name: device.name || 'Lite bulb',
      device,
      status: 'connecting',
      characteristic: null,
      pending: null,
      sending: false,
      retries: 0,
      connecting: false,
      removed: false,
      timer: null,
      abort: null,
    };
    bulb.onDisconnect = () => this._onDrop(bulb);
    device.addEventListener('gattserverdisconnected', bulb.onDisconnect);
    this.bulbs.set(device.id, bulb);
    this.onChange();
    this._connect(bulb);
    return bulb;
  }

  /** Ask the browser for already-permitted devices and (re)attach to all Lite- bulbs, in parallel. */
  async restoreSaved() {
    if (!navigator.bluetooth?.getDevices) {
      this.log('Saved-bulb lookup (getDevices) is unavailable. Use Chrome/Edge over HTTPS; on older versions enable chrome://flags/#enable-web-bluetooth-new-permissions-backend.', 'warn');
      return 0;
    }
    const devices = (await navigator.bluetooth.getDevices()).filter((d) => d.name?.startsWith(NAME_PREFIX));
    this.log(`Found ${devices.length} saved bulb(s).`, devices.length ? 'success' : 'info');
    devices.forEach((d) => this.add(d));
    return devices.length;
  }

  /** Stop managing one bulb. forget=true also revokes the browser permission. */
  remove(id, { forget = false } = {}) {
    const bulb = this.bulbs.get(id);
    if (!bulb) return;
    bulb.removed = true;
    this._cancelWait(bulb);
    bulb.device.removeEventListener('gattserverdisconnected', bulb.onDisconnect);
    try {
      if (bulb.device.gatt?.connected) bulb.device.gatt.disconnect();
    } catch (err) {
      this.log(`Disconnect error on ${bulb.name}: ${err.message}`, 'warn');
    }
    if (forget && typeof bulb.device.forget === 'function') {
      bulb.device.forget().catch((err) => this.log(`Could not forget ${bulb.name}: ${err.message}`, 'warn'));
    }
    this.bulbs.delete(id);
    this.log(`${forget ? 'Removed' : 'Disconnected'}: ${bulb.name}`, 'info');
    this.onChange();
  }

  removeAll() {
    [...this.bulbs.keys()].forEach((id) => this.remove(id));
  }

  /** Send one packet to every connected bulb. Returns how many bulbs were targeted. */
  broadcast(packet) {
    let n = 0;
    for (const bulb of this.bulbs.values()) {
      if (bulb.status !== 'connected') continue;
      bulb.pending = packet; // overwrite: only the newest state matters
      this._flush(bulb);
      n++;
    }
    return n;
  }

  // ── internals ──────────────────────────────────────────

  async _flush(bulb) {
    if (bulb.sending) return;
    bulb.sending = true;
    try {
      while (bulb.pending && bulb.characteristic) {
        const packet = bulb.pending;
        bulb.pending = null;
        try {
          await bulb.characteristic.writeValueWithoutResponse(packet);
        } catch (err) {
          this.log(`Write failed on ${bulb.name}: ${err.message}`, 'error');
        }
      }
    } finally {
      bulb.sending = false;
    }
  }

  async _connect(bulb) {
    if (bulb.removed || bulb.connecting) return;
    bulb.connecting = true;
    bulb.status = 'connecting';
    this.onChange();
    try {
      const server = await bulb.device.gatt.connect();
      const service = await server.getPrimaryService(ReosProtocol.SERVICE_UUID);
      bulb.characteristic = await service.getCharacteristic(ReosProtocol.CHARACTERISTIC_UUID);
      if (bulb.removed) {
        server.disconnect();
        return;
      }
      bulb.status = 'connected';
      bulb.retries = 0;
      this.log(`Connected: ${bulb.name}`, 'success');
      this.onChange();
    } catch (err) {
      bulb.characteristic = null;
      if (!bulb.removed) {
        this.log(`Could not connect to ${bulb.name}: ${err.message}`, 'warn');
        bulb.status = 'searching';
        this.onChange();
        this._scheduleRetry(bulb);
      }
    } finally {
      bulb.connecting = false;
    }
  }

  _onDrop(bulb) {
    if (bulb.removed) return;
    bulb.characteristic = null;
    bulb.pending = null;
    bulb.status = 'searching';
    this.log(`Connection lost: ${bulb.name}. Reconnecting...`, 'warn');
    this.onChange();
    this._scheduleRetry(bulb);
  }

  _cancelWait(bulb) {
    clearTimeout(bulb.timer);
    bulb.timer = null;
    bulb.abort?.abort();
    bulb.abort = null;
  }

  _scheduleRetry(bulb) {
    this._cancelWait(bulb);
    if (bulb.removed) return;
    const attempt = bulb.retries++;
    const device = bulb.device;

    // After a few quick retries, wait until the bulb is actually advertising nearby.
    if (attempt >= QUICK_RETRIES && typeof device.watchAdvertisements === 'function') {
      const ctrl = new AbortController();
      bulb.abort = ctrl;
      device.addEventListener(
        'advertisementreceived',
        () => {
          ctrl.abort();
          bulb.abort = null;
          this._connect(bulb);
        },
        { once: true, signal: ctrl.signal }
      );
      device.watchAdvertisements({ signal: ctrl.signal }).catch((err) => {
        if (ctrl.signal.aborted || bulb.removed) return;
        this.log(`Advertisement watch unavailable for ${bulb.name} (${err.message}); polling instead.`, 'warn');
        bulb.abort = null;
        bulb.timer = setTimeout(() => this._connect(bulb), MAX_BACKOFF_MS);
      });
      return;
    }

    const delay = Math.min(MAX_BACKOFF_MS, 1000 * 2 ** attempt);
    bulb.timer = setTimeout(() => this._connect(bulb), delay);
  }
}
