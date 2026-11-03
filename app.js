// app.js

// app.js: UI controller (ES module)
import { ReosProtocol, applyGamma, NAME_PREFIX } from './protocol.js';
import { BulbManager } from './bulbs.js';
import { EFFECTS, EFFECT_IDS } from './effects.js';
import { VERSION, RELEASE_DATE } from './version.js';

// Active state
let currentTab = 'rgb'; // 'rgb' or 'white'

const manager = new BulbManager({
  log: (m, t) => {
    log(m, t);
    if (!reconnecting && m.startsWith('Could not reach')) return; // background retries stay in the log, not the status line
    setActivity(m, { tone: t === 'warn' || t === 'error' ? 'warn' : t === 'success' ? 'ok' : '', busy: manager.connectingCount > 0 });
  },
  onChange: () => renderBulbs(),
});

// DOM Elements
const compatBanner = document.getElementById('compatBanner');
const clockEl = document.getElementById('clock');
const statusDot = document.getElementById('statusDot');
const activeCountText = document.getElementById('activeCountText');
const deviceList = document.getElementById('deviceList');
const listPlaceholder = document.getElementById('listPlaceholder');

const bulbsToggle = document.getElementById('bulbsToggle');
const bulbsCard = document.getElementById('bulbsCard');
const controlsCard = document.getElementById('controlsCard');
const btnConnectAll = document.getElementById('btnConnectAll');
const activityLine = document.getElementById('activityLine');
const activityText = document.getElementById('activityText');
const activitySpinner = document.getElementById('activitySpinner');
const appFooter = document.getElementById('appFooter');

// Buttons
const btnPair = document.getElementById('btnPair');
const btnAutoConnect = document.getElementById('btnAutoConnect');
const btnDisconnectAll = document.getElementById('btnDisconnectAll');
const btnPowerOn = document.getElementById('btnPowerOn');
const btnPowerOff = document.getElementById('btnPowerOff');

// Tab Navigation
const tabRgb = document.getElementById('tabRgb');
const tabWhite = document.getElementById('tabWhite');
const tabFx = document.getElementById('tabFx');
const panelFx = document.getElementById('panelFx');
const fxGrid = document.getElementById('fxGrid');
const fxSpeed = document.getElementById('fxSpeed');
const fxSpeedText = document.getElementById('fxSpeedText');
const panelRgb = document.getElementById('panelRgb');
const panelWhite = document.getElementById('panelWhite');

// Color Picker
const colorOrb = document.getElementById('colorOrb');
const colorHexText = document.getElementById('colorHexText');
const nativeColorInput = document.getElementById('nativeColorInput');

// Sliders
const brightnessSlider = document.getElementById('brightnessSlider');
const brightnessValText = document.getElementById('brightnessValText');
const warmthSlider = document.getElementById('warmthSlider');
const warmthValText = document.getElementById('warmthValText');

// Presets
const presetRed = document.getElementById('presetRed');
const presetGreen = document.getElementById('presetGreen');
const presetBlue = document.getElementById('presetBlue');
const presetWarmWhite = document.getElementById('presetWarmWhite');
const presetAllWhite = document.getElementById('presetAllWhite');
const presetDimWhite = document.getElementById('presetDimWhite');

// Logs
const debugLogs = document.getElementById('debugLogs');
const btnClearLogs = document.getElementById('btnClearLogs');
const btnCopyLogs = document.getElementById('btnCopyLogs');

// ════════════════════════════════════════════════════════
//  LOCAL PERSISTENCE (STATE STORE)
// ════════════════════════════════════════════════════════

function saveState() {
  const state = {
    currentTab: currentTab,
    hexColor: nativeColorInput.value,
    warmth: warmthSlider.value,
    brightness: brightnessSlider.value
  };
  try {
    localStorage.setItem('reos_state', JSON.stringify(state));
  } catch (e) {
    console.warn('Could not persist state', e);
  }
}

function loadState() {
  try {
    const saved = localStorage.getItem('reos_state');
    if (!saved) return;
    const state = JSON.parse(saved);
    if (state.hexColor) {
      nativeColorInput.value = state.hexColor;
      colorHexText.textContent = state.hexColor.toUpperCase();
      setOrb(state.hexColor);
    }
    if (state.warmth) {
      warmthSlider.value = state.warmth;
      const val = parseInt(state.warmth);
      let desc = 'Neutral';
      if (val < 90) desc = `Cool White (${val})`;
      else if (val > 110) desc = `Warm White (${val})`;
      else desc = `Neutral White (${val})`;
      warmthValText.textContent = desc;
    }
    if (state.brightness) {
      brightnessSlider.value = state.brightness;
      updateBrightnessLabel(parseInt(state.brightness));
    }
    if (state.currentTab === 'white') {
      currentTab = 'white';
      setTabUI('white');
    }
  } catch (e) {
    console.error('Failed to load state from localStorage', e);
  }
}

// ════════════════════════════════════════════════════════
//  INITIALIZATION & BROWSER COMPATIBILITY
// ════════════════════════════════════════════════════════

if (!navigator.bluetooth) {
  compatBanner.classList.remove('hidden');
  compatBanner.classList.add('flex');
}

// Live Status clock
setInterval(() => {
  const d = new Date();
  clockEl.textContent = d.toTimeString().split(' ')[0];
}, 1000);

log('Diagnostics Console ready. Waiting for connections...', 'info');

// Restore UI state from localStorage and start auto-connect (called at the bottom, after all consts exist)
const init = () => {
  loadState();
  renderBulbs();
  autoConnect(false);
};

// ════════════════════════════════════════════════════════
//  DIAGNOSTIC LOGGER
// ════════════════════════════════════════════════════════

function log(msg, type = 'info') {
  const time = new Date().toTimeString().split(' ')[0];
  const prefix = `[${time}] `;
  let colorClass = 'text-zinc-400';

  if (type === 'success') colorClass = 'text-emerald-400';
  else if (type === 'warn') colorClass = 'text-amber-400';
  else if (type === 'error') colorClass = 'text-red-400';
  else if (type === 'info') colorClass = 'text-sky-400';

  const line = document.createElement('div');
  line.className = `${colorClass} font-mono text-[10.5px]`;
  const head = document.createElement('strong');
  head.textContent = `${prefix}${type.toUpperCase()}: `;
  line.append(head, document.createTextNode(String(msg)));
  debugLogs.appendChild(line);
  debugLogs.scrollTop = debugLogs.scrollHeight;
}

btnClearLogs.addEventListener('click', () => {
  debugLogs.replaceChildren();
  log('Console logs cleared.', 'info');
});

btnCopyLogs.addEventListener('click', () => {
  navigator.clipboard.writeText(debugLogs.innerText)
    .then(() => log('Logs successfully copied to clipboard.', 'success'))
    .catch(e => log(`Failed to copy logs: ${e.message}`, 'error'));
});

// ════════════════════════════════════════════════════════
//  BLUETOOTH CONNECTIVITY
// ════════════════════════════════════════════════════════

const btnPairLabel = btnPair.querySelector('span');
let pairing = false;

// Web Bluetooth shows a single-select chooser, so "pair all" re-opens it after each pick.
// Already-paired bulbs are excluded so only unpaired Lite- bulbs are listed.
btnPair.addEventListener('click', async () => {
  if (pairing) return;
  if (!navigator.bluetooth) {
    log('Web Bluetooth is not available in this browser.', 'error');
    return;
  }
  pairing = true;
  btnPair.disabled = true;
  let added = 0;
  try {
    for (;;) {
      const options = {
        filters: [{ namePrefix: NAME_PREFIX }],
        optionalServices: [ReosProtocol.SERVICE_UUID],
      };
      const names = manager.knownNames();
      if (names.length) options.exclusionFilters = names.map((name) => ({ name }));

      let device;
      try {
        device = await navigator.bluetooth.requestDevice(options);
      } catch (err) {
        if (err.name === 'NotFoundError') {
          log(added ? `Pairing finished. ${added} bulb(s) added.` : 'Pairing cancelled.', 'info');
        } else if (err.name === 'SecurityError' || err.name === 'NotAllowedError') {
          log('Browser needs another tap to open the chooser. Tap "Add another bulb" to continue.', 'info');
        } else {
          log(`Pairing failed: ${err.message}`, 'error');
        }
        break;
      }
      manager.add(device);
      added++;
      log(`Paired ${device.name}. Opening chooser for the next bulb (cancel to finish)...`, 'info');
    }
  } finally {
    pairing = false;
    btnPair.disabled = false;
  }
});

// Live activity line under the bulb buttons: always says what is happening right now.
let activityTimer = null;
function setActivity(text, { tone = '', busy = false, autoHide = 0 } = {}) {
  clearTimeout(activityTimer);
  activityLine.classList.remove('hidden', 'warn', 'ok');
  if (tone) activityLine.classList.add(tone);
  activitySpinner.classList.toggle('off', !busy);
  activityText.textContent = text;
  if (autoHide) activityTimer = setTimeout(() => activityLine.classList.add('hidden'), autoHide);
}

const btnAutoLabel = btnAutoConnect.querySelector('span');
let reconnecting = false;

btnAutoConnect.addEventListener('click', () => autoConnect(true));

async function autoConnect(userInitiated = false) {
  if (reconnecting) return;
  reconnecting = true;
  btnAutoConnect.classList.add('loading');
  btnAutoLabel.textContent = 'Searching...';
  setActivity('Looking up saved bulbs...', { busy: true });
  try {
    const found = await manager.restoreSaved();
    if (found === 0 && manager.bulbs.size === 0) {
      setActivity(
        navigator.bluetooth?.getDevices
          ? 'No saved bulbs in this browser yet. Tap "Add new bulb" to pair one.'
          : 'This browser cannot list saved bulbs. Use a recent Chrome/Edge, then pair again.',
        { tone: 'warn', autoHide: userInitiated ? 0 : 8000 }
      );
      finishReconnect();
    } else if (manager.connectingCount === 0) {
      finishReconnect(); // everything already settled
    }
    // otherwise renderBulbs() calls finishReconnect() once no bulb is still connecting
  } catch (err) {
    log(`Saved-bulb lookup failed: ${err.message}`, 'error');
    setActivity(`Lookup failed: ${err.message}`, { tone: 'warn' });
    finishReconnect();
  }
}

function finishReconnect() {
  if (!reconnecting) return;
  reconnecting = false;
  btnAutoConnect.classList.remove('loading');
  btnAutoLabel.textContent = 'Reconnect saved bulbs';
  const total = manager.bulbs.size;
  const ok = manager.connectedCount;
  if (total === 0) return;
  if (ok === total) setActivity(`All ${total} bulb${total > 1 ? 's' : ''} connected.`, { tone: 'ok', autoHide: 6000 });
  else setActivity(`${ok} of ${total} connected. The rest aren't in range yet; they will connect automatically when they appear.`, { tone: 'warn' });
}

btnConnectAll.addEventListener('click', () => {
  if (manager.bulbs.size === 0) return setActivity('No paired bulbs yet.', { tone: 'warn', autoHide: 4000 });
  manager.resumeAll();
});

btnDisconnectAll.addEventListener('click', () => {
  if (manager.bulbs.size === 0) return;
  manager.pauseAll();
  setActivity('All bulbs disconnected. Tap "Connect all" to bring them back.', { autoHide: 6000 });
});

// Navbar pill toggles the bulbs widget
function setBulbsOpen(open) {
  bulbsCard.classList.toggle('hidden', !open);
  controlsCard.classList.toggle('md:col-span-3', open);
  controlsCard.classList.toggle('md:col-span-5', !open);
  bulbsToggle.setAttribute('aria-expanded', String(open));
  try { localStorage.setItem('reos_bulbs_open', open ? '1' : '0'); } catch (e) { console.warn('Could not persist panel state', e); }
}
bulbsToggle.addEventListener('click', () => setBulbsOpen(bulbsCard.classList.contains('hidden')));
try { if (localStorage.getItem('reos_bulbs_open') === '0') setBulbsOpen(false); } catch (e) { /* storage unavailable */ }

function renderBulbs() {
  const bulbs = [...manager.bulbs.values()];
  deviceList.replaceChildren();

  if (bulbs.length === 0) deviceList.appendChild(listPlaceholder);

  const statusLabel = (bulb) => {
    if (bulb.status === 'connected') return 'Connected';
    if (bulb.status === 'disconnected') return 'Disconnected';
    if (bulb.status === 'connecting') return 'Connecting...';
    return bulb.retries > 1 ? `Not in range, waiting... (try ${bulb.retries})` : 'Searching for bulb...';
  };

  for (const bulb of bulbs) {
    const row = document.createElement('div');
    row.className = 'device-row';
    row.id = `dev-${bulb.id}`;

    const left = document.createElement('div');
    left.className = 'flex items-center gap-3 min-w-0';
    const dot = document.createElement('span');
    dot.className = 'dot';
    if (bulb.status === 'disconnected') dot.classList.add('off');
    else if (bulb.status !== 'connected') dot.classList.add('busy');
    const col = document.createElement('div');
    col.className = 'flex flex-col min-w-0';
    const nameEl = document.createElement('span');
    nameEl.className = 'text-sm font-semibold text-white truncate';
    nameEl.textContent = bulb.name;
    const statusEl = document.createElement('span');
    statusEl.className = 'text-[10px] text-zinc-500';
    statusEl.textContent = statusLabel(bulb);
    col.append(nameEl, statusEl);
    left.append(dot, col);

    const actions = document.createElement('div');
    actions.className = 'row-actions';
    const toggle = document.createElement('button');
    toggle.className = bulb.status === 'disconnected' ? 'mini-action connect' : 'mini-action';
    toggle.textContent = bulb.status === 'disconnected' ? 'Connect' : bulb.status === 'connected' ? 'Disconnect' : 'Stop';
    toggle.addEventListener('click', () => (bulb.status === 'disconnected' ? manager.resume(bulb.id) : manager.pause(bulb.id)));
    const remove = document.createElement('button');
    remove.className = 'link-danger';
    remove.textContent = 'Forget';
    remove.title = 'Remove this bulb and revoke the browser permission';
    remove.addEventListener('click', () => manager.remove(bulb.id, { forget: true }));
    actions.append(toggle, remove);

    row.append(left, actions);
    deviceList.appendChild(row);
  }

  const count = manager.connectedCount;
  activeCountText.textContent = bulbs.length && bulbs.length !== count ? `${count}/${bulbs.length} bulbs` : `${count} bulb${count !== 1 ? 's' : ''}`;
  statusDot.className = count > 0
    ? 'w-2 h-2 bg-accent-green rounded-full shadow-lg shadow-accent-green/40 animate-pulse'
    : 'w-2 h-2 bg-zinc-600 rounded-full';
  btnPairLabel.textContent = bulbs.length ? 'Add another bulb' : 'Add new bulb';

  if (reconnecting && manager.connectingCount === 0) finishReconnect();
}

function broadcastPacket(packet) {
  if (manager.broadcast(packet) === 0) log('No bulbs connected. Transmit ignored.', 'warn');
}

// ════════════════════════════════════════════════════════
//  TABS MANAGEMENT
// ════════════════════════════════════════════════════════

const TABS = {
  rgb: { tab: tabRgb, panel: panelRgb, label: 'Color' },
  white: { tab: tabWhite, panel: panelWhite, label: 'White' },
  fx: { tab: tabFx, panel: panelFx, label: 'Effects' },
};

function switchTab(name) {
  if (currentTab === name) return;
  currentTab = name;
  stopEffect();
  setTabUI(name);
  log(`Switched to ${TABS[name].label} mode.`, 'info');
  applyStateChange(); // Instantly switch bulb channel state
}

tabRgb.addEventListener('click', () => switchTab('rgb'));
tabWhite.addEventListener('click', () => switchTab('white'));
tabFx.addEventListener('click', () => switchTab('fx'));

// ════════════════════════════════════════════════════════
//  RGB CONTROLS & PARSING
// ════════════════════════════════════════════════════════

function setTabUI(tab) {
  for (const [name, t] of Object.entries(TABS)) {
    t.tab.classList.toggle('active', name === tab);
    t.tab.setAttribute('aria-selected', String(name === tab));
    t.panel.classList.toggle('hidden', name !== tab);
  }
}

function setOrb(hex) {
  document.documentElement.style.setProperty('--glow', hex);
}

function hexToRgb(hex) {
  const result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
  return result ? {
    r: parseInt(result[1], 16),
    g: parseInt(result[2], 16),
    b: parseInt(result[3], 16)
  } : null;
}

nativeColorInput.addEventListener('input', (event) => {
  stopEffect();
  const hex = event.target.value;
  colorHexText.textContent = hex.toUpperCase();
  setOrb(hex);
  applyStateChange();
});

// Quick Colors
presetRed.addEventListener('click', () => {
  stopEffect();
  updateColorWheel('#FF3B30');
});
presetGreen.addEventListener('click', () => {
  stopEffect();
  updateColorWheel('#34C759');
});
presetBlue.addEventListener('click', () => {
  stopEffect();
  updateColorWheel('#007AFF');
});

function updateColorWheel(hex) {
  nativeColorInput.value = hex;
  colorHexText.textContent = hex.toUpperCase();
  setOrb(hex);
  applyStateChange();
}

// ════════════════════════════════════════════════════════
//  WHITE TEMPERATURE CONTROLS
// ════════════════════════════════════════════════════════

warmthSlider.addEventListener('input', (event) => {
  const val = parseInt(event.target.value);
  let desc = 'Neutral';
  if (val < 90) desc = `Cool White (${val})`;
  else if (val > 110) desc = `Warm White (${val})`;
  else desc = `Neutral White (${val})`;
  warmthValText.textContent = desc;

  applyStateChange();
});

// Quick White Presets
presetWarmWhite.addEventListener('click', () => {
  warmthSlider.value = 200;
  warmthValText.textContent = 'Warm White (200)';
  brightnessSlider.value = 208;
  updateBrightnessLabel(208);
  applyStateChange();
});

presetAllWhite.addEventListener('click', () => {
  warmthSlider.value = 100;
  warmthValText.textContent = 'Neutral White (100)';
  brightnessSlider.value = 208;
  updateBrightnessLabel(208);
  applyStateChange();
});

presetDimWhite.addEventListener('click', () => {
  warmthSlider.value = 100;
  warmthValText.textContent = 'Neutral White (100)';
  brightnessSlider.value = 60;
  updateBrightnessLabel(60);
  applyStateChange();
});

// ════════════════════════════════════════════════════════
//  BRIGHTNESS SLIDER & STATE DISPATCH
// ════════════════════════════════════════════════════════

brightnessSlider.addEventListener('input', (event) => {
  const val = parseInt(event.target.value);
  updateBrightnessLabel(val);
  applyStateChange();
});

function updateBrightnessLabel(val) {
  // Translate 16..208 range to 0-100% percentage display
  const pct = Math.round(((val - 16) / (208 - 16)) * 100);
  brightnessValText.textContent = `${val} / 208 (${pct}%)`;
}

// Global dispatcher compiling inputs to correct BLE packets and persisting state
function applyStateChange() {
  if (fxId) return; // a running effect owns the bulbs
  const bri = parseInt(brightnessSlider.value);
  saveState();

  if (currentTab === 'rgb') {
    const hex = nativeColorInput.value;
    const rgb = hexToRgb(hex);
    if (rgb) {
      // Gamma Correction
      const r = applyGamma(rgb.r);
      const g = applyGamma(rgb.g);
      const b = applyGamma(rgb.b);
      
      // Generate LITE1100 packet for RGB Mode (Headers: 0x00, 0x01)
      const packet = ReosProtocol.getColorPacket(r, g, b, bri);
      broadcastPacket(packet);
    }
  } else if (currentTab === 'white') {
    const warmth = parseInt(warmthSlider.value);
    
    // Generate LITE1100 packet for White Mode (R=255, G=255, B=255, Headers: 0x01, 0x01)
    const packet = ReosProtocol.getWhitePacket(bri, warmth);
    broadcastPacket(packet);
  }
}

// ════════════════════════════════════════════════════════
//  POWER CONTROL HANDLERS
// ════════════════════════════════════════════════════════

btnPowerOn.addEventListener('click', async () => {
  stopEffect();
  log('Broadcasting Power ON packet with active color state...', 'info');
  const bri = parseInt(brightnessSlider.value);
  
  if (currentTab === 'rgb') {
    const hex = nativeColorInput.value;
    const rgb = hexToRgb(hex);
    if (rgb) {
      const r = applyGamma(rgb.r);
      const g = applyGamma(rgb.g);
      const b = applyGamma(rgb.b);
      // Construct Command 13 (0x0D) Power ON packet parameterized with saved R, G, B
      const packet = ReosProtocol.getPowerOnPacket(r, g, b, bri);
      await broadcastPacket(packet);
    }
  } else {
    // White Mode Power ON
    const packet = ReosProtocol.getPowerOnPacket(255, 255, 255, bri);
    await broadcastPacket(packet);
    applyStateChange();
  }
});

btnPowerOff.addEventListener('click', async () => {
  stopEffect();
  log('Broadcasting Power OFF packet...', 'info');
  const packet = ReosProtocol.getPowerOffPacket();
  await broadcastPacket(packet);
});

// ════════════════════════════════════════════════════════
//  LIGHT EFFECTS (diya, candle, fire, party, ...)
// ════════════════════════════════════════════════════════

let fxId = null;
let fxState = null;
let fxTimer = null;
const fxCards = new Map();

for (const id of EFFECT_IDS) {
  const fx = EFFECTS[id];
  const card = document.createElement('button');
  card.className = 'fx-card';
  card.dataset.fx = id;
  card.setAttribute('aria-pressed', 'false');
  const emoji = document.createElement('span');
  emoji.className = 'fx-emoji';
  emoji.textContent = fx.emoji;
  const name = document.createElement('span');
  name.className = 'fx-name';
  name.textContent = fx.label;
  const blurb = document.createElement('span');
  blurb.className = 'fx-blurb';
  blurb.textContent = fx.blurb;
  card.append(emoji, name, blurb);
  card.addEventListener('click', () => (fxId === id ? stopEffect(true) : startEffect(id)));
  fxGrid.appendChild(card);
  fxCards.set(id, card);
}

function fxSpeedValue() {
  return parseFloat(fxSpeed.value);
}

fxSpeed.addEventListener('input', () => {
  fxSpeedText.textContent = `${fxSpeedValue().toFixed(1)}x`;
});

function startEffect(id) {
  stopEffect();
  fxId = id;
  fxState = EFFECTS[id].init();
  fxCards.get(id).classList.add('on');
  fxCards.get(id).setAttribute('aria-pressed', 'true');
  log(`Effect started: ${EFFECTS[id].label}`, 'success');
  if (manager.connectedCount === 0) log('No bulbs connected yet. The effect will play once one connects.', 'warn');
  runEffectFrame();
}

function runEffectFrame() {
  if (!fxId) return;
  const fx = EFFECTS[fxId];
  const base = hexToRgb(nativeColorInput.value) || { r: 255, g: 255, b: 255 };
  const f = fx.frame(fxState, { speed: fxSpeedValue(), base });
  const max = parseInt(brightnessSlider.value);
  const bri = Math.round(16 + Math.max(0, Math.min(1, f.level)) * (max - 16));
  const r = Math.round(f.r), g = Math.round(f.g), b = Math.round(f.b);
  manager.broadcast(ReosProtocol.getColorPacket(applyGamma(r), applyGamma(g), applyGamma(b), bri));
  setOrb(`rgb(${r}, ${g}, ${b})`);
  fxTimer = setTimeout(runEffectFrame, fx.interval);
}

function stopEffect(announce = false) {
  if (!fxId) return;
  clearTimeout(fxTimer);
  fxTimer = null;
  const card = fxCards.get(fxId);
  card.classList.remove('on');
  card.setAttribute('aria-pressed', 'false');
  if (announce) log(`Effect stopped: ${EFFECTS[fxId].label}`, 'info');
  fxId = null;
  fxState = null;
  setOrb(nativeColorInput.value);
}


appFooter.textContent = `Reos Lite Control Center · v${VERSION} · released ${new Date(RELEASE_DATE + 'T00:00:00').toLocaleDateString(undefined, { day: 'numeric', month: 'short', year: 'numeric' })}`;

init();
