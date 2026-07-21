<script lang="ts">
  import type { LogEntry } from '../lib/bluetooth';
  import { Terminal, ChevronDown, ChevronUp, Trash2 } from 'lucide-svelte';

  export let logs: LogEntry[] = [];
  export let onClear: () => void;

  let isOpen = false;

  function toggleConsole() {
    isOpen = !isOpen;
  }
</script>

<div class="bg-zinc-950/90 border border-zinc-800/80 rounded-2xl flex flex-col overflow-hidden transition-all duration-300 shadow-lg shadow-black/40">
  <!-- Header Bar -->
  <div 
    role="button"
    tabindex="0"
    on:click={toggleConsole}
    on:keydown={(e) => { if (e.key === 'Enter' || e.key === ' ') { e.preventDefault(); toggleConsole(); } }}
    class="w-full px-4 py-3 flex items-center justify-between bg-zinc-900/40 hover:bg-zinc-900/60 border-b border-zinc-900 transition-colors cursor-pointer outline-none focus:bg-zinc-900/60"
  >
    <div class="flex items-center gap-2 text-zinc-400">
      <Terminal class="w-4 h-4 text-indigo-400" />
      <span class="text-[9px] font-black uppercase tracking-widest">Diagnostic Terminal</span>
      {#if logs.length > 0}
        <span class="px-1.5 py-0.5 rounded-full bg-indigo-500/10 border border-indigo-500/20 text-[8px] font-mono font-bold text-indigo-400">
          {logs.length}
        </span>
      {/if}
    </div>
    
    <div class="flex items-center gap-3">
      {#if isOpen && logs.length > 0}
        <button
          on:click|stopPropagation={onClear}
          class="text-[9px] font-bold uppercase tracking-wider text-zinc-500 hover:text-rose-400 flex items-center gap-1 transition-colors outline-none cursor-pointer"
        >
          <Trash2 class="w-3 h-3" /> Clear
        </button>
      {/if}
      <div>
        {#if isOpen}
          <ChevronDown class="w-4 h-4 text-zinc-500" />
        {:else}
          <ChevronUp class="w-4 h-4 text-zinc-500" />
        {/if}
      </div>
    </div>
  </div>

  <!-- Collapsible Logs Area -->
  {#if isOpen}
    <div class="p-4 max-h-48 overflow-y-auto space-y-1.5 font-mono text-[10px] bg-black/40 flex-1 pr-2 select-text selection:bg-indigo-500 selection:text-white">
      {#if logs.length === 0}
        <div class="text-zinc-600 italic flex items-center gap-1.5">
          <span class="w-1.5 h-1.5 rounded-full bg-zinc-700 animate-pulse"></span>
          Terminal initialized. Ready for BLE packet logs...
        </div>
      {:else}
        {#each logs as log (log.id)}
          <div class="flex items-start gap-1.5 leading-relaxed">
            <span class="text-zinc-600 flex-shrink-0">[{log.timestamp}]</span>
            <span class={`flex-1 break-all ${
              log.type === 'error' 
                ? 'text-rose-400 font-bold' 
                : log.type === 'success' 
                ? 'text-emerald-400' 
                : log.type === 'warn' 
                ? 'text-amber-400' 
                : 'text-indigo-300'
            }`}>
              {log.message}
            </span>
          </div>
        {/each}
      {/if}
    </div>
  {/if}
</div>
