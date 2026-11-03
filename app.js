// app.js

// app.js: UI controller (ES module)
import { ReosProtocol, applyGamma, NAME_PREFIX } from './protocol.js';
import { BulbManager } from './bulbs.js';

// Active state
let currentTab = 'rgb'; // 'rgb' or 'white'

const manager = new BulbManager({ log: (m, t) => log(m, t), onChange: () => renderBulbs() });

// DOM Elements
const compatBanner = document.getElementById('compatBanner');
const clockEl = document.getElementById('clock');
const statusDot = document.getElementById('statusDot');
const activeCountText = document.getElementById('activeCountText');
const deviceList = document.getElementById('deviceList');
const listPlaceholder = document.getElementById('listPlaceholder');

// Buttons
const btnPair = document.getElementById('btnPair');
const btnAutoConnect = document.getElementById('btnAutoConnect');
const btnDisconnectAll = document.getElementById('btnDisconnectAll');
const btnPowerOn = document.getElementById('btnPowerOn');
const btnPowerOff = document.getElementById('btnPowerOff');
const btnParty = document.getElementById('btnParty');

// Tab Navigation
const tabRgb = document.getElementById('tabRgb');
const tabWhite = document.getElementById('tabWhite');
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
      panelWhite.classList.remove('hidden');
      panelRgb.classList.add('hidden');
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

// Restore UI state from localStorage and start auto-reconnect
const init = () => {
  loadState();
  renderBulbs();
  autoConnect();
};
init();

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

btnAutoConnect.addEventListener('click', () => autoConnect());

async function autoConnect() {
  try {
    await manager.restoreSaved();
  } catch (err) {
    log(`Saved-bulb lookup failed: ${err.message}`, 'error');
  }
}

btnDisconnectAll.addEventListener('click', () => {
  log('Disconnecting all bulbs...', 'warn');
  manager.removeAll();
});

function renderBulbs() {
  const bulbs = [...manager.bulbs.values()];
  deviceList.replaceChildren();

  if (bulbs.length === 0) deviceList.appendChild(listPlaceholder);

  const labels = { connected: 'Connected', connecting: 'Connecting...', searching: 'Searching for bulb...' };
  for (const bulb of bulbs) {
    const row = document.createElement('div');
    row.className = 'device-row';
    row.id = `dev-${bulb.id}`;

    const left = document.createElement('div');
    left.className = 'flex items-center gap-3 min-w-0';
    const dot = document.createElement('span');
    dot.className = 'dot';
    if (bulb.status !== 'connected') dot.style.opacity = '0.35';
    const col = document.createElement('div');
    col.className = 'flex flex-col min-w-0';
    const nameEl = document.createElement('span');
    nameEl.className = 'text-sm font-semibold text-white truncate';
    nameEl.textContent = bulb.name;
    const statusEl = document.createElement('span');
    statusEl.className = 'text-[10px] text-zinc-500';
    statusEl.textContent = labels[bulb.status] || bulb.status;
    col.append(nameEl, statusEl);
    left.append(dot, col);

    const remove = document.createElement('button');
    remove.className = 'link-danger';
    remove.textContent = 'Remove';
    remove.addEventListener('click', () => manager.remove(bulb.id, { forget: true }));

    row.append(left, remove);
    deviceList.appendChild(row);
  }

  const count = manager.connectedCount;
  activeCountText.textContent = `${count} bulb${count !== 1 ? 's' : ''}`;
  statusDot.className = count > 0
    ? 'w-2 h-2 bg-accent-green rounded-full shadow-lg shadow-accent-green/40 animate-pulse'
    : 'w-2 h-2 bg-zinc-600 rounded-full';
  btnPairLabel.textContent = bulbs.length ? 'Add another bulb' : 'Add new bulb';
}

function broadcastPacket(packet) {
  if (manager.broadcast(packet) === 0) log('No bulbs connected. Transmit ignored.', 'warn');
}

// ════════════════════════════════════════════════════════
//  TABS MANAGEMENT
// ════════════════════════════════════════════════════════

tabRgb.addEventListener('click', () => {
  if (currentTab === 'rgb') return;
  currentTab = 'rgb';
  setTabUI('rgb');
  
  // Update Tab Styling using Tailwind
  
  panelRgb.classList.remove('hidden');
  panelWhite.classList.add('hidden');
  
  log('Switched to RGB Color Mode.', 'info');
  applyStateChange(); // Instantly switch bulb channel state
});

tabWhite.addEventListener('click', () => {
  if (currentTab === 'white') return;
  currentTab = 'white';
  setTabUI('white');
  
  // Update Tab Styling using Tailwind
  
  panelWhite.classList.remove('hidden');
  panelRgb.classList.add('hidden');
  
  log('Switched to White Temperature Mode.', 'info');
  stopPartyMode();
  applyStateChange(); // Instantly switch bulb channel state
});

// ════════════════════════════════════════════════════════
//  RGB CONTROLS & PARSING
// ════════════════════════════════════════════════════════

function setTabUI(tab) {
  tabRgb.classList.toggle('active', tab === 'rgb');
  tabWhite.classList.toggle('active', tab === 'white');
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

function rgbToHex(r, g, b) {
  return "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1).toUpperCase();
}

nativeColorInput.addEventListener('input', (event) => {
  stopPartyMode();
  const hex = event.target.value;
  colorHexText.textContent = hex.toUpperCase();
  setOrb(hex);
  applyStateChange();
});

// Quick Colors
presetRed.addEventListener('click', () => {
  stopPartyMode();
  updateColorWheel('#FF3B30');
});
presetGreen.addEventListener('click', () => {
  stopPartyMode();
  updateColorWheel('#34C759');
});
presetBlue.addEventListener('click', () => {
  stopPartyMode();
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
  log('Broadcasting Power OFF packet...', 'info');
  const packet = ReosProtocol.getPowerOffPacket();
  await broadcastPacket(packet);
});

// ════════════════════════════════════════════════════════
//  PARTY MODE (CLIENT-SIDE COLOR CYCLE)
// ════════════════════════════════════════════════════════

let partyIntervalId = null;

btnParty.addEventListener('click', () => {
  togglePartyMode();
});

function togglePartyMode() {
  if (partyIntervalId) {
    stopPartyMode();
    log('Party Mode disabled.', 'info');
  } else {
    log('Party Mode enabled! Cycling HSL spectrum...', 'success');
    btnParty.classList.add('on');
    btnParty.querySelector('span').textContent = 'Party Mode: ON';
    
    let hue = 0;
    partyIntervalId = setInterval(() => {
      hue = (hue + 4) % 360;
      const rgb = hslToRgb(hue / 360, 1, 0.5);
      const bri = parseInt(brightnessSlider.value);
      
      const r = applyGamma(rgb.r);
      const g = applyGamma(rgb.g);
      const b = applyGamma(rgb.b);
      
      // Send HSL cycle using RGB command (Headers: 0x00, 0x01)
      const packet = ReosProtocol.getColorPacket(r, g, b, bri);
      broadcastPacket(packet);
      
      const hex = rgbToHex(rgb.r, rgb.g, rgb.b);
      colorHexText.textContent = hex;
      setOrb(hex);
      nativeColorInput.value = hex;
    }, 200);
  }
}

function stopPartyMode() {
  if (partyIntervalId) {
    clearInterval(partyIntervalId);
    partyIntervalId = null;
    btnParty.classList.remove('on');
    btnParty.querySelector('span').textContent = 'Party Mode: OFF';
  }
}

function hslToRgb(h, s, l) {
  let r, g, b;
  if (s == 0) {
    r = g = b = l;
  } else {
    const hue2rgb = (p, q, t) => {
      if (t < 0) t += 1;
      if (t > 1) t -= 1;
      if (t < 1/6) return p + (q - p) * 6 * t;
      if (t < 1/2) return q;
      if (t < 2/3) return p + (q - p) * (2/3 - t) * 6;
      return p;
    };
    const q = l < 0.5 ? l * (1 + s) : l + s - l * s;
    const p = 2 * l - q;
    r = hue2rgb(p, q, h + 1/3);
    g = hue2rgb(p, q, h);
    b = hue2rgb(p, q, h - 1/3);
  }
  return {
    r: Math.round(r * 255),
    g: Math.round(g * 255),
    b: Math.round(b * 255)
  };
}
