// app.js

// Map of connected devices: Device ID -> Device Information
const connectedDevices = new Map();

// Active states
let currentTab = 'rgb'; // 'rgb' or 'white'

// Gamma Correction Table (sampled directly from Array R in the Java source)
const GAMMA_TABLE = [
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 
  4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 
  11, 11, 12, 12, 13, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 
  21, 21, 22, 22, 23, 24, 24, 25, 25, 26, 27, 27, 28, 29, 29, 30, 31, 32, 32, 33, 34, 
  35, 35, 36, 37, 38, 39, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 50, 51, 52, 
  54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 66, 67, 68, 69, 70, 72, 73, 74, 75, 77, 
  78, 79, 81, 82, 83, 85, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 
  107, 109, 110, 112, 114, 115, 117, 119, 120, 122, 124, 126, 127, 129, 131, 133, 135, 
  137, 138, 140, 142, 144, 146, 148, 150, 152, 154, 156, 158, 160, 162, 164, 167, 169, 
  171, 173, 175, 177, 180, 182, 184, 186, 189, 191, 193, 196, 198, 200, 203, 205, 208, 
  210, 213, 215, 218, 220, 223, 225, 228, 231, 233, 236, 239, 241, 244, 247, 249, 252, 255
];

// Helper: Applies Gamma Correction to RGB values
function applyGamma(val) {
  const clamp = Math.max(0, Math.min(255, Math.round(val)));
  return GAMMA_TABLE[clamp];
}

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
  } catch (e) {}
}

function loadState() {
  try {
    const saved = localStorage.getItem('reos_state');
    if (!saved) return;
    const state = JSON.parse(saved);
    if (state.hexColor) {
      nativeColorInput.value = state.hexColor;
      colorHexText.textContent = state.hexColor.toUpperCase();
      colorOrb.style.background = `radial-gradient(circle at 30% 30%, ${state.hexColor}, #000)`;
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
      tabWhite.className = 'flex-grow flex-1 py-2 px-3 text-xs font-bold rounded-lg transition-all text-white bg-zinc-800';
      tabRgb.className = 'flex-grow flex-1 py-2 px-3 text-xs font-bold rounded-lg transition-all text-zinc-400 hover:text-white';
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
window.addEventListener('DOMContentLoaded', () => {
  loadState();
  autoReconnect();
});

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
  line.innerHTML = `<strong>${prefix}${type.toUpperCase()}:</strong> ${msg}`;
  debugLogs.appendChild(line);
  debugLogs.scrollTop = debugLogs.scrollHeight;
}

btnClearLogs.addEventListener('click', () => {
  debugLogs.innerHTML = '';
  log('Console logs cleared.', 'info');
});

btnCopyLogs.addEventListener('click', () => {
  navigator.clipboard.writeText(debugLogs.innerText)
    .then(() => log('Logs successfully copied to clipboard.', 'success'))
    .catch(e => log(`Failed to copy logs: ${e.message}`, 'error'));
});

function getHexRepresentation(uint8) {
  return '[ ' + Array.from(uint8).map(b => b.toString(16).padStart(2, '0').toUpperCase()).join(' ') + ' ]';
}

// ════════════════════════════════════════════════════════
//  BLUETOOTH CONNECTIVITY
// ════════════════════════════════════════════════════════

btnPair.addEventListener('click', async () => {
  log('Triggering Web Bluetooth pairing chooser...', 'info');
  try {
    const device = await navigator.bluetooth.requestDevice({
      filters: [{ namePrefix: 'Lite-' }],
      optionalServices: [ReosProtocol.SERVICE_UUID]
    });
    log(`Selected bulb: ${device.name}`, 'info');
    await connectToDevice(device);
  } catch (err) {
    log(`Chooser cancelled or failed: ${err.message}`, 'error');
  }
});

async function autoReconnect() {
  log('Starting background auto-reconnect checker...', 'info');
  if (!navigator.bluetooth || !navigator.bluetooth.getDevices) {
    log('Background auto-reconnect (getDevices) is not supported. Ensure you are on HTTPS/localhost and that "Experimental Web Platform features" is enabled in chrome://flags.', 'warn');
    return;
  }

  try {
    log('Searching registry for previously paired bulbs...', 'info');
    const devices = await navigator.bluetooth.getDevices();
    log(`Registry lookup complete. Found ${devices.length} paired bulb(s).`, 'success');

    if (devices.length === 0) {
      log('No previously linked bulbs found. Click "Pair Bulb" to add one.', 'info');
      return;
    }

    for (const device of devices) {
      if (device.name && device.name.startsWith('Lite-')) {
        log(`Initiating reconnection to paired bulb: "${device.name}"...`, 'info');
        await connectToDevice(device);
      }
    }
  } catch (err) {
    log(`Registry lookup failed: ${err.message}`, 'error');
  }
}

async function connectToDevice(device) {
  if (connectedDevices.has(device.id)) {
    log(`Bulb ${device.name} is already connected.`, 'warn');
    return;
  }

  log(`Opening GATT Server link to ${device.name}...`, 'info');
  try {
    const server = await device.gatt.connect();
    log(`GATT connection established on ${device.name}.`, 'success');

    log(`Discovering primary service ${ReosProtocol.SERVICE_UUID}...`, 'info');
    const service = await server.getPrimaryService(ReosProtocol.SERVICE_UUID);
    
    log(`Locating control characteristic ${ReosProtocol.CHARACTERISTIC_UUID}...`, 'info');
    const characteristic = await service.getCharacteristic(ReosProtocol.CHARACTERISTIC_UUID);
    log(`Control characteristic linked on ${device.name}.`, 'success');

    const info = { device, server, service, characteristic, name: device.name, id: device.id };
    connectedDevices.set(device.id, info);

    device.addEventListener('gattserverdisconnected', onDeviceDisconnected);

    renderDeviceItem(info);
    updateHeaderStatus();

    log(`Bulb ${device.name} connected successfully and holding current hardware state.`, 'success');
  } catch (err) {
    log(`GATT handshake failed with ${device.name}: ${err.message}`, 'error');
  }
}

btnDisconnectAll.addEventListener('click', () => {
  log('Disconnecting all active BLE links...', 'warn');
  for (const [id, info] of connectedDevices.entries()) {
    try {
      info.server.disconnect();
      log(`Disconnected: ${info.name}`, 'info');
    } catch (e) {}
  }
  connectedDevices.clear();
  deviceList.innerHTML = '';
  deviceList.appendChild(listPlaceholder);
  updateHeaderStatus();
});

function onDeviceDisconnected(event) {
  const device = event.target;
  log(`Bulb connection dropped: ${device.name}`, 'error');
  connectedDevices.delete(device.id);

  const element = document.getElementById(`dev-${device.id}`);
  if (element) element.remove();

  if (connectedDevices.size === 0) {
    deviceList.appendChild(listPlaceholder);
  }
  updateHeaderStatus();
}

function renderDeviceItem(info) {
  const placeholder = document.getElementById('listPlaceholder');
  if (placeholder) placeholder.remove();

  const item = document.createElement('div');
  item.className = 'flex justify-between items-center bg-zinc-900/60 p-3.5 rounded-xl border border-white/5';
  item.id = `dev-${info.id}`;
  item.innerHTML = `
    <div class="flex flex-col gap-0.5">
      <span class="text-xs font-semibold text-white">${info.name}</span>
      <span class="text-[10px] text-zinc-500">Connected ∙ Write Endpoint: fff3</span>
    </div>
    <button class="text-xs font-semibold text-accent-red hover:text-accent-red-hover px-2 py-1 rounded" onclick="disconnectBulb('${info.id}')">Disconnect</button>
  `;
  deviceList.appendChild(item);
}

window.disconnectBulb = function(id) {
  const info = connectedDevices.get(id);
  if (info) {
    info.server.disconnect();
    connectedDevices.delete(id);
    const element = document.getElementById(`dev-${id}`);
    if (element) element.remove();
    log(`Disconnected: ${info.name}`, 'info');
  }
  if (connectedDevices.size === 0) {
    deviceList.appendChild(listPlaceholder);
  }
  updateHeaderStatus();
};

function updateHeaderStatus() {
  const count = connectedDevices.size;
  activeCountText.textContent = `${count} Bulb${count !== 1 ? 's' : ''} Linked`;
  
  if (count > 0) {
    statusDot.className = 'w-2.5 h-2.5 bg-accent-green rounded-full shadow-lg shadow-accent-green/40 animate-pulse';
  } else {
    statusDot.className = 'w-2.5 h-2.5 bg-zinc-600 rounded-full';
  }
}

async function broadcastPacket(packet) {
  if (connectedDevices.size === 0) {
    log('No bulbs connected. Transmit ignored.', 'warn');
    return;
  }

  for (const [id, info] of connectedDevices.entries()) {
    try {
      await info.characteristic.writeValueWithoutResponse(packet);
    } catch (err) {
      log(`Transmit failed on ${info.name}: ${err.message}`, 'error');
    }
  }
  log(`TX OK -> ${getHexRepresentation(packet)}`, 'success');
}

// ════════════════════════════════════════════════════════
//  TABS MANAGEMENT
// ════════════════════════════════════════════════════════

tabRgb.addEventListener('click', () => {
  if (currentTab === 'rgb') return;
  currentTab = 'rgb';
  
  // Update Tab Styling using Tailwind
  tabRgb.className = 'flex-grow flex-1 py-2 px-3 text-xs font-bold rounded-lg transition-all text-white bg-zinc-800';
  tabWhite.className = 'flex-grow flex-1 py-2 px-3 text-xs font-bold rounded-lg transition-all text-zinc-400 hover:text-white';
  
  panelRgb.classList.remove('hidden');
  panelWhite.classList.add('hidden');
  
  log('Switched to RGB Color Mode.', 'info');
  applyStateChange(); // Instantly switch bulb channel state
});

tabWhite.addEventListener('click', () => {
  if (currentTab === 'white') return;
  currentTab = 'white';
  
  // Update Tab Styling using Tailwind
  tabWhite.className = 'flex-grow flex-1 py-2 px-3 text-xs font-bold rounded-lg transition-all text-white bg-zinc-800';
  tabRgb.className = 'flex-grow flex-1 py-2 px-3 text-xs font-bold rounded-lg transition-all text-zinc-400 hover:text-white';
  
  panelWhite.classList.remove('hidden');
  panelRgb.classList.add('hidden');
  
  log('Switched to White Temperature Mode.', 'info');
  stopPartyMode();
  applyStateChange(); // Instantly switch bulb channel state
});

// ════════════════════════════════════════════════════════
//  RGB CONTROLS & PARSING
// ════════════════════════════════════════════════════════

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
  colorOrb.style.background = `radial-gradient(circle at 30% 30%, ${hex}, #000)`;
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
  colorOrb.style.background = `radial-gradient(circle at 30% 30%, ${hex}, #000)`;
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
    btnParty.className = 'w-full flex items-center justify-center gap-2 py-3 px-4 text-xs font-bold text-white bg-accent-purple rounded-xl transition-all shadow-lg shadow-accent-purple/30 active:scale-[0.98]';
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
      colorOrb.style.background = `radial-gradient(circle at 30% 30%, ${hex}, #000)`;
      nativeColorInput.value = hex;
    }, 200);
  }
}

function stopPartyMode() {
  if (partyIntervalId) {
    clearInterval(partyIntervalId);
    partyIntervalId = null;
    btnParty.className = 'w-full flex items-center justify-center gap-2 py-3 px-4 text-xs font-bold text-accent-purple bg-accent-purple/10 hover:bg-accent-purple/15 border border-accent-purple/20 rounded-xl transition-all';
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
