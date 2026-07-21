<script lang="ts">
  import { Sun } from 'lucide-svelte';

  export let brightness: number = 208;
  export let onBrightnessChange: (val: number) => void;

  function handleInput(e: Event) {
    const val = parseInt((e.target as HTMLInputElement).value);
    onBrightnessChange(val);
  }

  // Calculate percentage: min is 16, max is 208
  $: pct = Math.round(((brightness - 16) / (208 - 16)) * 100);
</script>

<div class="bg-zinc-900/40 p-5 rounded-3xl border border-white/5 backdrop-blur-md space-y-4">
  <div class="flex justify-between items-center text-xs font-bold">
    <span class="text-zinc-400 uppercase tracking-wider text-[10px]">Master Intensity</span>
    <span class="text-indigo-400 font-mono px-3 py-1 rounded-full text-xs border border-indigo-500/20 bg-indigo-500/5 shadow-[0_0_10px_rgba(99,102,241,0.1)]">
      {pct}% <span class="text-[9px] text-zinc-500 font-bold">({brightness} LM)</span>
    </span>
  </div>

  <div class="relative py-2 flex items-center gap-3">
    <!-- Icon with dynamic opacity & scaling based on brightness -->
    <div 
      class="flex-shrink-0 transition-all duration-200"
      style="opacity: {0.3 + (pct / 100) * 0.7}; transform: scale({0.9 + (pct / 100) * 0.2}); filter: drop-shadow(0 0 {pct / 10}px rgba(129,140,248,{pct / 150}))"
    >
      <Sun class="w-4.5 h-4.5 text-indigo-400" />
    </div>

    <!-- Custom styled slider track -->
    <div class="relative w-full flex items-center">
      <input
        type="range"
        min="16"
        max="208"
        value={brightness}
        on:input={handleInput}
        class="brightness-slider w-full cursor-pointer"
        style="background: linear-gradient(to right, #1e1b4b 0%, #6366f1 {pct}%, #27272a {pct}%)"
      />
    </div>
  </div>
</div>

<style>
  .brightness-slider {
    -webkit-appearance: none;
    appearance: none;
    width: 100%;
    height: 8px;
    border-radius: 9999px;
    outline: none;
    transition: background 0.1s ease;
  }
  .brightness-slider::-webkit-slider-thumb {
    -webkit-appearance: none;
    appearance: none;
    width: 18px;
    height: 18px;
    border-radius: 50%;
    background: #ffffff;
    border: 2.5px solid #09090b;
    box-shadow: 0 0 10px rgba(99, 102, 241, 0.6);
    cursor: pointer;
    transition: transform 0.15s ease;
  }
  .brightness-slider::-webkit-slider-thumb:hover {
    transform: scale(1.15);
  }
  .brightness-slider::-webkit-slider-thumb:active {
    transform: scale(1.25);
  }
</style>
