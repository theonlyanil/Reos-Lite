<script lang="ts">
  import Header from './components/Header.svelte';
  import DeviceList from './components/DeviceList.svelte';
  import RgbPanel from './components/RgbPanel.svelte';
  import WhitePanel from './components/WhitePanel.svelte';
  import BrightnessSlider from './components/BrightnessSlider.svelte';
  import PowerControls from './components/PowerControls.svelte';
  import LogConsole from './components/LogConsole.svelte';

  import { Palette, Sun } from 'lucide-svelte';
  import { onMount } from 'svelte';

  import { Capacitor } from '@capacitor/core';
  import { Preferences } from '@capacitor/preferences';
  import { bleManager, type DeviceInfo, type LogEntry } from './lib/bluetooth';
  import { ReosProtocol } from './lib/protocol';
  import { applyGamma } from './lib/gamma';

  let devices: DeviceInfo[] = [];
  let logs: LogEntry[] = [];

  let currentTab: 'rgb' | 'white' = 'rgb';
  let hexColor = '#FF0055';
  let warmth = 100;
  let brightness = 208;
  let isPartyOn = false;
  let partyInterval: any = null;

  let isConsoleOpen = false;
  let isStateLoaded = false;

  async function ensureStateLoaded() {
    if (isStateLoaded) return;
    try {
      const { value } = await Preferences.get({ key: 'reos_state' });
      if (value) {
        const state = JSON.parse(value);
        if (state.currentTab) currentTab = state.currentTab;
        if (state.hexColor) hexColor = state.hexColor;
        if (state.warmth) warmth = state.warmth;
        if (state.brightness) brightness = state.brightness;
      }
    } catch (e) {
      console.error('Failed to load state', e);
    } finally {
      isStateLoaded = true;
    }
  }

  onMount(async () => {
    await ensureStateLoaded();
  });

  async function saveState() {
    try {
      const state = { currentTab, hexColor, warmth, brightness };
      await Preferences.set({
        key: 'reos_state',
        value: JSON.stringify(state)
      });
    } catch (e) {
      console.error('Failed to save state', e);
    }
  }

  function addLog(message: string, type: LogEntry['type'] = 'info') {
    const time = new Date().toTimeString().split(' ')[0];
    const newEntry: LogEntry = {
      id: Math.random().toString(36).substring(2, 9),
      timestamp: time,
      message,
      type
    };
    logs = [...logs, newEntry];
    if (type === 'error' || type === 'warn') {
      isConsoleOpen = true;
    }
  }

  let discoveredDevices: DeviceInfo[] = [];
  let isScanning = false;
  let isScanPanelOpen = false;
  let selectedDeviceIds: Record<string, boolean> = {};

  async function handleStartScan() {
    if (Capacitor.getPlatform() === 'web') {
      try {
        await bleManager.scanAndConnect(
          (device) => {
            if (!devices.some(d => d.deviceId === device.deviceId)) {
              devices = [...devices, device];
            }
            setTimeout(async () => {
              await ensureStateLoaded();
              await applyStateChange();
            }, 600);
          },
          addLog
        );
      } catch (err) {
        console.error('Web scan failed', err);
      }
      return;
    }

    discoveredDevices = [];
    selectedDeviceIds = {};
    isScanning = true;
    isScanPanelOpen = true;
    try {
      await bleManager.startScan(
        (device) => {
          if (!devices.some(d => d.deviceId === device.deviceId) && !discoveredDevices.some(d => d.deviceId === device.deviceId)) {
            discoveredDevices = [...discoveredDevices, device];
          }
        },
        addLog
      );
    } catch (err) {
      isScanning = false;
      isScanPanelOpen = false;
    }
  }

  async function handleStopScan() {
    isScanning = false;
    await bleManager.stopScan(addLog);
  }

  async function handleConnectSelected() {
    const targets = discoveredDevices.filter(d => selectedDeviceIds[d.deviceId]);
    if (targets.length === 0) return;

    await handleStopScan();
    isScanPanelOpen = false;

    addLog(`Initiating pairing sequence for ${targets.length} bulb(s)...`, 'info');
    for (const dev of targets) {
      await bleManager.connectToDevice(
        dev.deviceId,
        dev.name,
        (connectedDev) => {
          if (!devices.some(d => d.deviceId === connectedDev.deviceId)) {
            devices = [...devices, connectedDev];
          }
          setTimeout(async () => {
            await ensureStateLoaded();
            await applyStateChange();
            triggerPersistentSave();
          }, 600);
        },
        addLog
      );
    }
  }

  function handleDisconnect(deviceId: string) {
    bleManager.disconnect(deviceId, addLog);
    devices = devices.filter(d => d.deviceId !== deviceId);
  }

  function handleDisconnectAll() {
    devices.forEach(d => bleManager.disconnect(d.deviceId, addLog));
    devices = [];
  }

  function hexToRgb(hex: string) {
    const result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result ? {
      r: parseInt(result[1], 16),
      g: parseInt(result[2], 16),
      b: parseInt(result[3], 16)
    } : null;
  }

  async function applyStateChange() {
    if (currentTab === 'rgb') {
      const rgb = hexToRgb(hexColor);
      if (rgb) {
        const r = applyGamma(rgb.r);
        const g = applyGamma(rgb.g);
        const b = applyGamma(rgb.b);
        const packet = ReosProtocol.getColorPacket(r, g, b, brightness);
        await bleManager.writePacket(devices, packet, addLog);
      }
    } else {
      const packet = ReosProtocol.getWhitePacket(brightness, warmth);
      await bleManager.writePacket(devices, packet, addLog);
    }
  }

  let saveSettingsTimeout: any = null;

  function triggerPersistentSave() {
    if (saveSettingsTimeout) clearTimeout(saveSettingsTimeout);
    saveSettingsTimeout = setTimeout(async () => {
      if (devices.length > 0) {
        const packet = ReosProtocol.getSaveSettingsPacket(true);
        await bleManager.writePacket(devices, packet, addLog);
        // Repeat once: write-without-response can be dropped by the bulb
        await new Promise(r => setTimeout(r, 300));
        await bleManager.writePacket(devices, packet, addLog);
      }
    }, 600);
  }

  async function handleColorChange(hex: string) {
    stopParty();
    hexColor = hex;
    await applyStateChange();
    await saveState();
    triggerPersistentSave();
  }

  async function handleWarmthChange(val: number) {
    stopParty();
    warmth = val;
    await applyStateChange();
    await saveState();
    triggerPersistentSave();
  }

  async function handleBrightnessChange(val: number) {
    brightness = val;
    await applyStateChange();
    await saveState();
    triggerPersistentSave();
  }

  function handlePowerOn() {
    stopParty();
    if (currentTab === 'rgb') {
      const rgb = hexToRgb(hexColor);
      if (rgb) {
        const packet = ReosProtocol.getPowerOnPacket(applyGamma(rgb.r), applyGamma(rgb.g), applyGamma(rgb.b), brightness);
        bleManager.writePacket(devices, packet, addLog);
        triggerPersistentSave();
      }
    } else {
      const packet = ReosProtocol.getPowerOnPacket(255, 255, 255, brightness);
      bleManager.writePacket(devices, packet, addLog);
      setTimeout(() => {
        applyStateChange();
        triggerPersistentSave();
      }, 300);
    }
  }

  function handlePowerOff() {
    stopParty();
    const packet = ReosProtocol.getPowerOffPacket();
    bleManager.writePacket(devices, packet, addLog);
  }

  function toggleParty() {
    if (isPartyOn) {
      stopParty();
    } else {
      isPartyOn = true;
      let hue = 0;
      partyInterval = setInterval(() => {
        hue = (hue + 5) % 360;
        const rgb = hslToRgb(hue / 360, 1, 0.5);
        const packet = ReosProtocol.getColorPacket(applyGamma(rgb.r), applyGamma(rgb.g), applyGamma(rgb.b), brightness);
        bleManager.writePacket(devices, packet, addLog);
      }, 200);
    }
  }

  function stopParty() {
    if (partyInterval) {
      clearInterval(partyInterval);
      partyInterval = null;
    }
    isPartyOn = false;
  }

  function hslToRgb(h: number, s: number, l: number) {
    let r, g, b;
    if (s == 0) {
      r = g = b = l;
    } else {
      const hue2rgb = (p: number, q: number, t: number) => {
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
    return { r: Math.round(r * 255), g: Math.round(g * 255), b: Math.round(b * 255) };
  }
</script>

<div class="h-full flex flex-col bg-zinc-950 text-zinc-100 select-none relative overflow-hidden font-sans">
  <!-- Subtle ambient background glows -->
  <div class="absolute -top-40 -left-40 w-96 h-96 rounded-full bg-indigo-500/10 blur-[100px] pointer-events-none"></div>
  <div class="absolute top-1/2 -right-40 w-96 h-96 rounded-full bg-purple-500/5 blur-[100px] pointer-events-none"></div>

  <Header deviceCount={devices.length} />

  <main class="flex-1 overflow-y-auto p-5 space-y-5 pb-16 z-10">
    <DeviceList
      {devices}
      {discoveredDevices}
      {isScanning}
      {isScanPanelOpen}
      bind:selectedDeviceIds={selectedDeviceIds}
      onDisconnect={handleDisconnect}
      onDisconnectAll={handleDisconnectAll}
      onStartScan={handleStartScan}
      onStopScan={handleStopScan}
      onConnectSelected={handleConnectSelected}
    />

    <!-- Modern sliding tab selector -->
    <div class="flex p-1.5 bg-zinc-900/40 border border-white/5 backdrop-blur-md rounded-2xl">
      <button
        on:click={() => { currentTab = 'rgb'; applyStateChange(); saveState(); }}
        class={`flex-1 py-2.5 text-xs font-black uppercase tracking-wider rounded-xl transition-all duration-300 flex items-center justify-center gap-2 cursor-pointer ${
          currentTab === 'rgb' 
            ? 'bg-gradient-to-r from-indigo-500/20 to-purple-600/20 text-white border border-indigo-500/30 shadow-[0_0_12px_rgba(99,102,241,0.15)]' 
            : 'text-zinc-400 hover:text-zinc-200 border border-transparent'
        }`}
      >
        <Palette class="w-3.5 h-3.5" />
        RGB Spectrum
      </button>
      <button
        on:click={() => { currentTab = 'white'; applyStateChange(); saveState(); }}
        class={`flex-1 py-2.5 text-xs font-black uppercase tracking-wider rounded-xl transition-all duration-300 flex items-center justify-center gap-2 cursor-pointer ${
          currentTab === 'white' 
            ? 'bg-gradient-to-r from-indigo-500/20 to-purple-600/20 text-white border border-indigo-500/30 shadow-[0_0_12px_rgba(99,102,241,0.15)]' 
            : 'text-zinc-400 hover:text-zinc-200 border border-transparent'
        }`}
      >
        <Sun class="w-3.5 h-3.5" />
        White Spectrum
      </button>
    </div>

    <!-- Active Panel Section with subtle scale/fade transition -->
    <div class="transition-all duration-300">
      {#if currentTab === 'rgb'}
        <RgbPanel {hexColor} onColorChange={handleColorChange} />
      {:else}
        <WhitePanel {warmth} onWarmthChange={handleWarmthChange} />
      {/if}
    </div>

    <BrightnessSlider {brightness} onBrightnessChange={handleBrightnessChange} />

    <PowerControls
      {isPartyOn}
      onPowerOn={handlePowerOn}
      onPowerOff={handlePowerOff}
      onToggleParty={toggleParty}
    />

    <LogConsole {logs} isOpen={isConsoleOpen} onToggle={() => isConsoleOpen = !isConsoleOpen} onClear={() => logs = []} />
  </main>
</div>
