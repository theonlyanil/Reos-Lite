<script lang="ts">
  import { Power, Sparkles } from 'lucide-svelte';

  export let isPartyOn: boolean = false;
  export let onPowerOn: () => void;
  export let onPowerOff: () => void;
  export let onToggleParty: () => void;
</script>

<div class="space-y-3">
  <!-- Power Buttons Row -->
  <div class="grid grid-cols-2 gap-3.5">
    <button
      on:click={onPowerOn}
      class="relative py-3.5 px-4 rounded-2xl bg-emerald-500/10 hover:bg-emerald-500/15 border border-emerald-500/30 text-emerald-400 font-black text-xs tracking-wider uppercase active:scale-[0.97] transition-all duration-300 flex items-center justify-center gap-2 cursor-pointer shadow-[0_4px_12px_rgba(16,185,129,0.1)] hover:shadow-[0_4px_16px_rgba(16,185,129,0.2)]"
    >
      <Power class="w-4 h-4 text-emerald-400" />
      Power ON
    </button>
    
    <button
      on:click={onPowerOff}
      class="relative py-3.5 px-4 rounded-2xl bg-rose-500/10 hover:bg-rose-500/15 border border-rose-500/30 text-rose-400 font-black text-xs tracking-wider uppercase active:scale-[0.97] transition-all duration-300 flex items-center justify-center gap-2 cursor-pointer shadow-[0_4px_12px_rgba(244,63,94,0.1)] hover:shadow-[0_4px_16px_rgba(244,63,94,0.2)]"
    >
      <Power class="w-4 h-4 text-rose-400 rotate-180" />
      Power OFF
    </button>
  </div>

  <!-- Animated Party Mode Button -->
  <button
    on:click={onToggleParty}
    class={`relative w-full py-4 px-4 rounded-2xl font-black text-xs tracking-wider uppercase transition-all duration-500 border flex items-center justify-center gap-2 active:scale-[0.98] overflow-hidden cursor-pointer ${
      isPartyOn 
        ? 'animate-gradient text-white border-transparent shadow-[0_4px_24px_rgba(168,85,247,0.4)]' 
        : 'bg-purple-500/10 hover:bg-purple-500/15 border-purple-500/30 text-purple-300 shadow-[0_4px_12px_rgba(168,85,247,0.05)]'
    }`}
  >
    {#if isPartyOn}
      <!-- Moving colored overlay for active party mode -->
      <div class="absolute inset-0 bg-gradient-to-r from-red-500 via-purple-500 via-blue-500 to-red-500 opacity-90 -z-10 animate-gradient"></div>
      <Sparkles class="w-4 h-4 text-white animate-spin-slow" />
      <span>Party Light ACTIVE</span>
    {:else}
      <Sparkles class="w-4 h-4 text-purple-400" />
      <span>Initiate Party Mode</span>
    {/if}
  </button>
</div>

<style>
  @keyframes gradient-move {
    0% { background-position: 0% 50%; }
    50% { background-position: 100% 50%; }
    100% { background-position: 0% 50%; }
  }
  
  .animate-gradient {
    background-size: 200% auto;
    animation: gradient-move 3s linear infinite;
  }

  @keyframes spin-slow {
    from { transform: rotate(0deg); }
    to { transform: rotate(360deg); }
  }
  
  .animate-spin-slow {
    animation: spin-slow 4s linear infinite;
  }
</style>
