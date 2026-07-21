<script lang="ts">
  import { Bluetooth, Radio } from 'lucide-svelte';
  export let deviceCount: number = 0;
</script>

<header class="pt-14 pb-4 px-6 bg-zinc-950/75 backdrop-blur-xl border-b border-zinc-800/50 flex justify-between items-center sticky top-0 z-30 transition-all duration-300">
  <div class="flex items-center gap-3">
    <div class="relative flex items-center justify-center">
      {#if deviceCount > 0}
        <div class="absolute inset-0 bg-emerald-500/30 rounded-full blur-md animate-pulse"></div>
        <div class="relative w-9 h-9 rounded-full bg-emerald-500/10 border border-emerald-500/30 flex items-center justify-center text-emerald-400">
          <Bluetooth class="w-4 h-4" />
        </div>
      {:else}
        <div class="relative w-9 h-9 rounded-full bg-zinc-900 border border-zinc-800 flex items-center justify-center text-zinc-500">
          <Bluetooth class="w-4 h-4" />
        </div>
      {/if}
    </div>
    <div>
      <h1 class="text-sm font-black tracking-widest text-transparent bg-clip-text bg-gradient-to-r from-white via-zinc-200 to-zinc-400">REOS SMART</h1>
      <p class="text-[9px] font-bold tracking-wider uppercase text-zinc-500 flex items-center gap-1">
        <Radio class="w-2.5 h-2.5 text-zinc-500 animate-pulse" /> BLE Control Console
      </p>
    </div>
  </div>

  <div class={`px-3.5 py-1 rounded-full text-[10px] font-bold tracking-wider uppercase transition-all duration-300 ${
    deviceCount > 0 
      ? 'bg-emerald-500/10 border border-emerald-500/30 text-emerald-400 shadow-[0_0_12px_rgba(16,185,129,0.15)]' 
      : 'bg-zinc-900 border border-zinc-800 text-zinc-400'
  }`}>
    {deviceCount} {deviceCount === 1 ? 'Bulb' : 'Bulbs'} Connected
  </div>
</header>
