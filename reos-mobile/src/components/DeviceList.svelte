<script lang="ts">
  import type { DeviceInfo } from '../lib/bluetooth';
  import { Lightbulb, Trash2, Plus, RefreshCw, X, Check } from 'lucide-svelte';

  export let devices: DeviceInfo[] = [];
  export let onDisconnect: (id: string) => void;
  export let onDisconnectAll: () => void;

  export let discoveredDevices: DeviceInfo[] = [];
  export let isScanning: boolean = false;
  export let isScanPanelOpen: boolean = false;
  export let selectedDeviceIds: Record<string, boolean> = {};

  export let onStartScan: () => Promise<void>;
  export let onStopScan: () => Promise<void>;
  export let onConnectSelected: () => Promise<void>;

  // Computed: number of selected devices
  $: selectedCount = Object.values(selectedDeviceIds).filter(Boolean).length;

  function toggleSelect(id: string) {
    selectedDeviceIds[id] = !selectedDeviceIds[id];
  }
</script>

<div class="bg-zinc-900/40 rounded-3xl p-5 border border-white/5 backdrop-blur-md space-y-4">
  {#if !isScanPanelOpen}
    <!-- MAIN CONNECTED BULBS VIEW -->
    <div class="flex items-center justify-between">
      <span class="text-[10px] font-black uppercase tracking-widest text-zinc-400">Hardware Links</span>
      {#if devices.length > 0}
        <button 
          on:click={onDisconnectAll}
          class="text-[10px] font-bold uppercase tracking-wider text-rose-400 hover:text-rose-300 transition-colors flex items-center gap-1.5 active:scale-95 duration-200"
        >
          <Trash2 class="w-3.5 h-3.5" /> Disconnect All
        </button>
      {/if}
    </div>

    <button
      on:click={onStartScan}
      class="w-full py-3.5 px-4 rounded-2xl font-black text-xs tracking-wider uppercase bg-gradient-to-r from-indigo-500 to-purple-600 hover:from-indigo-400 hover:to-purple-500 text-white shadow-[0_4px_20px_rgba(99,102,241,0.25)] hover:shadow-[0_4px_24px_rgba(99,102,241,0.4)] active:scale-[0.98] transition-all duration-300 flex items-center justify-center gap-2 cursor-pointer"
    >
      <Plus class="w-4 h-4" />
      Search for Bulbs
    </button>

    {#if devices.length === 0}
      <div class="text-center py-8 px-4 text-zinc-500 text-xs font-semibold border border-dashed border-zinc-800/80 rounded-2xl flex flex-col items-center justify-center gap-2 bg-zinc-950/20">
        <Lightbulb class="w-6 h-6 text-zinc-600" />
        <span>No hardware linked. Tap above to search.</span>
      </div>
    {:else}
      <div class="space-y-2.5">
        {#each devices as dev (dev.deviceId)}
          <div class="flex justify-between items-center bg-zinc-950/60 p-3.5 rounded-2xl border border-white/5 shadow-inner">
            <div class="flex items-center gap-3">
              <div class="w-8 h-8 rounded-xl bg-gradient-to-tr from-indigo-500/20 to-purple-500/20 border border-indigo-500/20 flex items-center justify-center text-indigo-300">
                <Lightbulb class="w-4 h-4 text-indigo-300 fill-indigo-300/10" />
              </div>
              <div class="flex flex-col">
                <span class="text-xs font-bold text-zinc-100">{dev.name}</span>
                <span class="text-[9px] text-zinc-500 font-mono tracking-wider">{dev.deviceId}</span>
              </div>
            </div>
            <button
              on:click={() => onDisconnect(dev.deviceId)}
              class="text-[10px] font-bold uppercase tracking-wider text-rose-400 hover:text-rose-300 px-3 py-1.5 rounded-xl bg-rose-500/5 hover:bg-rose-500/10 border border-rose-500/10 hover:border-rose-500/20 transition-all duration-200 active:scale-95"
            >
              Disconnect
            </button>
          </div>
        {/each}
      </div>
    {/if}
  {:else}
    <!-- DISCOVERY / SELECTION SCAN PANEL -->
    <div class="flex items-center justify-between">
      <div class="flex items-center gap-2">
        {#if isScanning}
          <RefreshCw class="w-3.5 h-3.5 text-indigo-400 animate-spin" />
        {/if}
        <span class="text-[10px] font-black uppercase tracking-widest text-zinc-400">
          {isScanning ? 'Scanning Environment...' : 'Scan Complete'}
        </span>
      </div>
      <button 
        on:click={onStopScan}
        class="text-zinc-500 hover:text-zinc-300 transition-colors p-1"
      >
        <X class="w-4 h-4" />
      </button>
    </div>

    <!-- Discovered Devices Checklist -->
    <div class="space-y-2 max-h-60 overflow-y-auto pr-1">
      {#if discoveredDevices.length === 0}
        <div class="relative overflow-hidden text-center py-10 px-4 text-zinc-500 text-xs font-semibold border border-dashed border-zinc-800/80 rounded-2xl flex flex-col items-center justify-center gap-2 bg-zinc-950/20">
          {#if isScanning}
            <!-- Radar Scan Effect -->
            <div class="absolute inset-0 flex items-center justify-center opacity-30 pointer-events-none">
              <div class="absolute w-24 h-24 rounded-full border border-indigo-500 animate-[ping_1.5s_infinite]"></div>
              <div class="absolute w-16 h-16 rounded-full border border-purple-500 animate-[ping_2s_infinite]"></div>
            </div>
          {/if}
          <Lightbulb class={`w-6 h-6 text-zinc-600 ${isScanning ? 'animate-pulse text-indigo-400' : ''}`} />
          <span>
            {isScanning ? 'Looking for Reos bulbs over Bluetooth...' : 'No bulbs discovered. Try searching again.'}
          </span>
        </div>
      {:else}
        {#each discoveredDevices as dev (dev.deviceId)}
          <!-- svelte-ignore a11y-click-events-have-key-events -->
          <!-- svelte-ignore a11y-no-static-element-interactions -->
          <div 
            on:click={() => toggleSelect(dev.deviceId)}
            class={`flex justify-between items-center p-3.5 rounded-2xl border transition-all duration-300 cursor-pointer active:scale-[0.99] select-none ${
              selectedDeviceIds[dev.deviceId]
                ? 'bg-indigo-500/10 border-indigo-500/40 text-indigo-300 shadow-[0_0_12px_rgba(99,102,241,0.1)]'
                : 'bg-zinc-950/60 border-white/5 text-zinc-400 hover:text-zinc-200'
            }`}
          >
            <div class="flex items-center gap-3">
              <!-- Custom Glassmorphic Checkbox -->
              <div class={`w-5 h-5 rounded-lg border flex items-center justify-center transition-all duration-200 ${
                selectedDeviceIds[dev.deviceId]
                  ? 'bg-indigo-500 border-indigo-400 text-white shadow-[0_0_8px_rgba(99,102,241,0.5)]'
                  : 'bg-zinc-900 border-zinc-700 text-transparent'
              }`}>
                <Check class="w-3 h-3 stroke-[3]" />
              </div>
              <div class="flex flex-col text-left">
                <span class={`text-xs font-bold transition-colors ${selectedDeviceIds[dev.deviceId] ? 'text-zinc-100' : 'text-zinc-400'}`}>{dev.name}</span>
                <span class="text-[9px] text-zinc-500 font-mono tracking-wider">{dev.deviceId}</span>
              </div>
            </div>
          </div>
        {/each}
      {/if}
    </div>

    <!-- Actions Row -->
    <div class="flex gap-2.5 pt-2">
      {#if isScanning}
        <button
          on:click={onStopScan}
          class="flex-1 py-3 rounded-2xl border border-zinc-700/50 bg-zinc-800/30 text-zinc-300 font-bold text-xs tracking-wider uppercase hover:bg-zinc-800/50 active:scale-95 transition-all duration-200 flex items-center justify-center gap-1.5 cursor-pointer"
        >
          Stop Scanning
        </button>
      {:else}
        <button
          on:click={onStartScan}
          class="flex-1 py-3 rounded-2xl border border-zinc-700/50 bg-zinc-850/60 text-zinc-300 font-bold text-xs tracking-wider uppercase hover:bg-zinc-800/80 active:scale-95 transition-all duration-200 flex items-center justify-center gap-1.5 cursor-pointer"
        >
          Scan Again
        </button>
      {/if}

      <button
        on:click={onConnectSelected}
        disabled={selectedCount === 0}
        class={`flex-1 py-3 rounded-2xl font-black text-xs tracking-wider uppercase transition-all duration-300 flex items-center justify-center gap-1.5 cursor-pointer ${
          selectedCount === 0
            ? 'bg-zinc-800 text-zinc-500 border border-zinc-700/30 cursor-not-allowed'
            : 'bg-gradient-to-r from-indigo-500 to-purple-600 hover:from-indigo-400 hover:to-purple-500 text-white shadow-[0_4px_16px_rgba(99,102,241,0.25)] active:scale-[0.98]'
        }`}
      >
        Connect {selectedCount > 0 ? `(${selectedCount})` : ''}
      </button>
    </div>
  {/if}
</div>
