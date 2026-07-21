<script lang="ts">
  import { Sparkles, Palette } from 'lucide-svelte';

  export let hexColor: string = '#FF0055';
  export let onColorChange: (hex: string) => void;

  function handleInput(e: Event) {
    const val = (e.target as HTMLInputElement).value;
    onColorChange(val);
  }

  // Predefined luxury lighting scenes
  const scenes = [
    { name: 'Sunset Glow', hex: '#FF5E3A', style: 'from-orange-500 to-rose-500 text-orange-200' },
    { name: 'Northern Lights', hex: '#1AD6FD', style: 'from-cyan-500 to-emerald-500 text-cyan-200' },
    { name: 'Neon City', hex: '#FF007F', style: 'from-pink-500 to-purple-500 text-pink-200' },
    { name: 'Deep Forest', hex: '#2ECC71', style: 'from-emerald-600 to-teal-700 text-emerald-200' },
    { name: 'Warm Amber', hex: '#FF9500', style: 'from-amber-500 to-yellow-600 text-amber-200' },
    { name: 'Arctic Ice', hex: '#1D62F0', style: 'from-blue-600 to-sky-500 text-blue-200' }
  ];
</script>

<div class="space-y-5">
  <!-- Interactive Glowing Orb -->
  <div class="flex flex-col items-center justify-center p-8 bg-zinc-900/40 rounded-3xl border border-white/5 backdrop-blur-md relative overflow-hidden">
    <!-- Background Glow -->
    <div 
      class="absolute w-44 h-44 rounded-full blur-[50px] opacity-25 transition-all duration-500"
      style="background-color: {hexColor}"
    ></div>

    <!-- Interactive Sphere -->
    <div class="relative flex items-center justify-center">
      <!-- Outer Spectrum ring -->
      <div 
        class="w-36 h-36 rounded-full border border-dashed border-zinc-700/60 p-2 flex items-center justify-center transition-all duration-500"
        style="box-shadow: 0 0 30px {hexColor}25"
      >
        <!-- The Core Orb -->
        <div
          class="w-full h-full rounded-full shadow-2xl transition-all duration-300 transform active:scale-95 cursor-pointer relative overflow-hidden flex flex-col items-center justify-center group"
          style="background: radial-gradient(circle at 30% 30%, {hexColor}FF, {hexColor}B3, #000000); box-shadow: 0 10px 25px -5px {hexColor}55, inset 0 4px 12px rgba(255,255,255,0.4)"
        >
          <!-- Shiny Highlight -->
          <div class="absolute top-1 left-3 w-12 h-6 bg-white/25 rounded-full blur-[1px] rotate-[-15deg]"></div>
          
          <Palette class="w-6 h-6 text-white drop-shadow-[0_2px_4px_rgba(0,0,0,0.5)] opacity-80 group-hover:opacity-100 transition-opacity" />
          
          <!-- Native Color Picker Trigger -->
          <input
            type="color"
            value={hexColor}
            on:input={handleInput}
            class="absolute inset-0 opacity-0 w-full h-full cursor-pointer"
          />
        </div>
      </div>
    </div>

    <div class="mt-4 flex flex-col items-center gap-1">
      <span 
        class="px-3 py-1 rounded-full text-xs font-mono font-bold tracking-widest border transition-all duration-300 uppercase shadow-sm"
        style="color: {hexColor}; border-color: {hexColor}55; background-color: {hexColor}0D"
      >
        {hexColor}
      </span>
      <span class="text-[9px] font-bold uppercase tracking-wider text-zinc-500">Tap orb to pick custom color</span>
    </div>
  </div>

  <!-- Styled Luxury Scene Presets -->
  <div class="space-y-2">
    <div class="flex items-center gap-1.5 px-1">
      <Sparkles class="w-3.5 h-3.5 text-zinc-500" />
      <span class="text-[10px] font-black uppercase tracking-widest text-zinc-400">Ambient Scenes</span>
    </div>
    
    <div class="grid grid-cols-2 gap-2.5">
      {#each scenes as scene}
        <button
          on:click={() => onColorChange(scene.hex)}
          class="relative p-3.5 rounded-2xl bg-zinc-900/30 hover:bg-zinc-900/50 border border-white/5 hover:border-zinc-700/50 transition-all duration-300 flex items-center justify-between text-left active:scale-[0.98] group overflow-hidden"
        >
          <!-- Hover color splash -->
          <div 
            class="absolute -right-6 -bottom-6 w-12 h-12 rounded-full blur-md opacity-0 group-hover:opacity-20 transition-all duration-300"
            style="background-color: {scene.hex}"
          ></div>

          <div class="flex flex-col">
            <span class="text-xs font-bold text-zinc-200 group-hover:text-white transition-colors">{scene.name}</span>
            <span class="text-[9px] font-mono text-zinc-500 font-bold uppercase tracking-wider">{scene.hex}</span>
          </div>

          <div 
            class="w-4 h-4 rounded-full border border-white/20 shadow-md flex-shrink-0"
            style="background-color: {scene.hex}; box-shadow: 0 0 10px {scene.hex}33"
          ></div>
        </button>
      {/each}
    </div>
  </div>
</div>
