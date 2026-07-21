<script lang="ts">
  import { Sun, Flame, Snowflake } from 'lucide-svelte';

  export let warmth: number = 100;
  export let onWarmthChange: (val: number) => void;

  function handleInput(e: Event) {
    const val = parseInt((e.target as HTMLInputElement).value);
    onWarmthChange(val);
  }

  function getDesc(val: number): string {
    if (val < 70) return `Cool Daylight (${val})`;
    if (val < 130) return `Natural White (${val})`;
    return `Warm Candlelight (${val})`;
  }

  // Helper to get color preview based on warmth value
  function getWarmthColor(val: number): string {
    // interpolation from sky-300 (0) -> zinc-100 (100) -> amber-500 (200)
    if (val <= 100) {
      const pct = val / 100;
      const r = Math.round(147 + (244 - 147) * pct);
      const g = Math.round(197 + (245 - 197) * pct);
      const b = Math.round(253 + (246 - 253) * pct);
      return `rgb(${r}, ${g}, ${b})`;
    } else {
      const pct = (val - 100) / 100;
      const r = Math.round(244 + (245 - 244) * pct);
      const g = Math.round(245 + (158 - 245) * pct);
      const b = Math.round(246 + (11 - 246) * pct);
      return `rgb(${r}, ${g}, ${b})`;
    }
  }
</script>

<div class="space-y-5">
  <div class="bg-zinc-900/40 p-5 rounded-3xl border border-white/5 backdrop-blur-md space-y-4">
    <div class="flex justify-between items-center text-xs font-bold">
      <span class="text-zinc-400 uppercase tracking-wider text-[10px]">Temperature tuning</span>
      <span 
        class="font-mono px-3 py-1 rounded-full text-xs border transition-all duration-300 font-bold"
        style="color: {getWarmthColor(warmth)}; border-color: {getWarmthColor(warmth)}33; background-color: {getWarmthColor(warmth)}0D; text-shadow: 0 0 10px {getWarmthColor(warmth)}25"
      >
        {getDesc(warmth)}
      </span>
    </div>

    <!-- Color Temperature Slider Container -->
    <div class="relative py-2 flex items-center gap-3">
      <Snowflake class="w-4 h-4 text-sky-400 flex-shrink-0" />
      <div class="relative w-full flex items-center">
        <input
          type="range"
          min="0"
          max="200"
          value={warmth}
          on:input={handleInput}
          class="warmth-slider w-full cursor-pointer"
        />
      </div>
      <Flame class="w-4 h-4 text-amber-500 flex-shrink-0" />
    </div>
  </div>

  <!-- Styled Presets -->
  <div class="grid grid-cols-3 gap-2.5">
    <button
      on:click={() => onWarmthChange(0)}
      class={`py-3 px-3 rounded-2xl border transition-all duration-300 flex flex-col items-center justify-center gap-1.5 active:scale-95 ${
        warmth === 0 
          ? 'bg-sky-500/10 border-sky-500/40 text-sky-300 shadow-[0_0_12px_rgba(56,189,248,0.15)] font-bold' 
          : 'bg-zinc-900/30 hover:bg-zinc-900/50 border-white/5 text-zinc-400 hover:text-zinc-200'
      }`}
    >
      <Snowflake class="w-4 h-4" />
      <span class="text-[10px] font-black uppercase tracking-wider">Cool (0)</span>
    </button>
    <button
      on:click={() => onWarmthChange(100)}
      class={`py-3 px-3 rounded-2xl border transition-all duration-300 flex flex-col items-center justify-center gap-1.5 active:scale-95 ${
        warmth === 100 
          ? 'bg-white/10 border-white/20 text-white shadow-[0_0_12px_rgba(255,255,255,0.1)] font-bold' 
          : 'bg-zinc-900/30 hover:bg-zinc-900/50 border-white/5 text-zinc-400 hover:text-zinc-200'
      }`}
    >
      <Sun class="w-4 h-4" />
      <span class="text-[10px] font-black uppercase tracking-wider">Neutral (100)</span>
    </button>
    <button
      on:click={() => onWarmthChange(200)}
      class={`py-3 px-3 rounded-2xl border transition-all duration-300 flex flex-col items-center justify-center gap-1.5 active:scale-95 ${
        warmth === 200 
          ? 'bg-amber-500/10 border-amber-500/40 text-amber-300 shadow-[0_0_12px_rgba(245,158,11,0.15)] font-bold' 
          : 'bg-zinc-900/30 hover:bg-zinc-900/50 border-white/5 text-zinc-400 hover:text-zinc-200'
      }`}
    >
      <Flame class="w-4 h-4" />
      <span class="text-[10px] font-black uppercase tracking-wider">Warm (200)</span>
    </button>
  </div>
</div>

<style>
  .warmth-slider {
    -webkit-appearance: none;
    appearance: none;
    width: 100%;
    height: 8px;
    border-radius: 9999px;
    background: linear-gradient(to right, #38bdf8 0%, #f8fafc 50%, #f59e0b 100%);
    outline: none;
  }
  .warmth-slider::-webkit-slider-thumb {
    -webkit-appearance: none;
    appearance: none;
    width: 18px;
    height: 18px;
    border-radius: 50%;
    background: #ffffff;
    border: 2.5px solid #09090b;
    box-shadow: 0 0 10px rgba(255, 255, 255, 0.6);
    cursor: pointer;
    transition: transform 0.15s ease;
  }
  .warmth-slider::-webkit-slider-thumb:hover {
    transform: scale(1.15);
  }
  .warmth-slider::-webkit-slider-thumb:active {
    transform: scale(1.25);
  }
</style>
