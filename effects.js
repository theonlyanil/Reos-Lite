// effects.js: client-side light shows. Each effect is pure: frame(state, ctx) -> {r, g, b, level}
//   ctx = { speed: 0.5..2, base: {r,g,b} }   (base = the colour picked on the Color tab)
//   level 0..1 is scaled by the brightness slider (the slider is the "max").
// `interval` is the ms between frames (BLE writes are throttled by this, ~6-10 Hz is smooth and safe).

const clamp = (v, lo = 0, hi = 1) => Math.max(lo, Math.min(hi, v));
const lerp = (a, b, t) => a + (b - a) * t;
const mix = (c1, c2, t) => ({ r: lerp(c1.r, c2.r, t), g: lerp(c1.g, c2.g, t), b: lerp(c1.b, c2.b, t) });

export function hslToRgb(h, s, l) {
  h = ((h % 1) + 1) % 1;
  if (s === 0) return { r: l * 255, g: l * 255, b: l * 255 };
  const hue2rgb = (p, q, t) => {
    if (t < 0) t += 1;
    if (t > 1) t -= 1;
    if (t < 1 / 6) return p + (q - p) * 6 * t;
    if (t < 1 / 2) return q;
    if (t < 2 / 3) return p + (q - p) * (2 / 3 - t) * 6;
    return p;
  };
  const q = l < 0.5 ? l * (1 + s) : l + s - l * s;
  const p = 2 * l - q;
  return { r: hue2rgb(p, q, h + 1 / 3) * 255, g: hue2rgb(p, q, h) * 255, b: hue2rgb(p, q, h - 1 / 3) * 255 };
}

/** Smooth flame flicker: eased random walk plus occasional gusts. Shared by diya/candle/fire. */
function flicker(state, { speed, calm, gust, floor }) {
  // pull toward a fresh random target, so the flame wobbles instead of strobing
  if (state.target === undefined || Math.random() < 0.35 * speed) {
    state.target = floor + Math.random() * (1 - floor);
  }
  if (Math.random() < gust * speed) state.target = floor * 0.6; // a gust bends the flame
  state.level = (state.level ?? 0.8) + (state.target - (state.level ?? 0.8)) * clamp(calm * speed);
  return clamp(state.level);
}

export const EFFECTS = {
  diya: {
    label: 'Diwali Diya',
    emoji: '🪔',
    blurb: 'Warm flickering flame',
    interval: 110,
    init: () => ({}),
    frame(s, { speed }) {
      const level = flicker(s, { speed, calm: 0.45, gust: 0.04, floor: 0.45 });
      // hotter (more yellow) when bright, deeper amber when it dips
      const c = mix({ r: 255, g: 52, b: 0 }, { r: 255, g: 128, b: 10 }, level);
      return { ...c, level: 0.35 + level * 0.65 };
    },
  },
  candle: {
    label: 'Candle',
    emoji: '🕯️',
    blurb: 'Soft, gentle glow',
    interval: 130,
    init: () => ({}),
    frame(s, { speed }) {
      const level = flicker(s, { speed, calm: 0.3, gust: 0.015, floor: 0.7 });
      return { r: 255, g: 100 + level * 40, b: 12 + level * 14, level: 0.5 + level * 0.5 };
    },
  },
  fire: {
    label: 'Fireplace',
    emoji: '🔥',
    blurb: 'Crackling embers',
    interval: 90,
    init: () => ({}),
    frame(s, { speed }) {
      const level = flicker(s, { speed, calm: 0.6, gust: 0.08, floor: 0.2 });
      const c = mix({ r: 255, g: 12, b: 0 }, { r: 255, g: 110, b: 0 }, level);
      return { ...c, level: 0.25 + level * 0.75 };
    },
  },
  festive: {
    label: 'Festive Lights',
    emoji: '✨',
    blurb: 'Gold, saffron, magenta, green',
    interval: 160,
    init: () => ({ t: 0 }),
    frame(s, { speed }) {
      const palette = [
        { r: 255, g: 150, b: 0 }, // gold
        { r: 255, g: 50, b: 0 }, // saffron
        { r: 255, g: 0, b: 110 }, // magenta
        { r: 0, g: 190, b: 60 }, // green
      ];
      s.t = (s.t + 0.035 * speed) % palette.length;
      const i = Math.floor(s.t);
      const c = mix(palette[i], palette[(i + 1) % palette.length], s.t - i);
      return { ...c, level: 0.8 + 0.2 * Math.sin(s.t * 6) };
    },
  },
  party: {
    label: 'Party',
    emoji: '🎉',
    blurb: 'Full-spectrum colour cycle',
    interval: 200,
    init: () => ({ hue: 0 }),
    frame(s, { speed }) {
      s.hue = (s.hue + 0.011 * speed) % 1;
      return { ...hslToRgb(s.hue, 1, 0.5), level: 1 };
    },
  },
  breathe: {
    label: 'Breathe',
    emoji: '🫧',
    blurb: 'Pulses your chosen colour',
    interval: 120,
    init: () => ({ t: 0 }),
    frame(s, { speed, base }) {
      s.t += 0.07 * speed;
      return { ...base, level: 0.1 + 0.9 * (0.5 - 0.5 * Math.cos(s.t)) };
    },
  },
  aurora: {
    label: 'Aurora',
    emoji: '🌌',
    blurb: 'Drifting green, teal, violet',
    interval: 200,
    init: () => ({ t: 0 }),
    frame(s, { speed }) {
      s.t += 0.02 * speed;
      const hue = 0.33 + 0.27 * (0.5 + 0.5 * Math.sin(s.t)); // green -> violet
      return { ...hslToRgb(hue, 1, 0.5), level: 0.6 + 0.4 * (0.5 + 0.5 * Math.sin(s.t * 2.3 + 1)) };
    },
  },
  ocean: {
    label: 'Ocean',
    emoji: '🌊',
    blurb: 'Rolling blue-teal waves',
    interval: 160,
    init: () => ({ t: 0 }),
    frame(s, { speed }) {
      s.t += 0.05 * speed;
      const wave = 0.5 + 0.5 * Math.sin(s.t);
      const c = mix({ r: 0, g: 40, b: 255 }, { r: 0, g: 210, b: 200 }, wave);
      return { ...c, level: 0.45 + 0.55 * (0.5 + 0.5 * Math.sin(s.t * 0.6 + 2)) };
    },
  },
  storm: {
    label: 'Thunderstorm',
    emoji: '⛈️',
    blurb: 'Dark clouds, lightning flashes',
    interval: 90,
    init: () => ({ flash: 0 }),
    frame(s, { speed }) {
      if (s.flash > 0) {
        s.flash--;
        // flashes stutter on/off like real lightning
        const on = s.flash % 2 === 1;
        return on ? { r: 235, g: 240, b: 255, level: 1 } : { r: 40, g: 20, b: 120, level: 0.25 };
      }
      if (Math.random() < 0.025 * speed) s.flash = 3 + Math.floor(Math.random() * 4);
      return { r: 30, g: 10, b: 110, level: 0.2 + Math.random() * 0.08 };
    },
  },
};

export const EFFECT_IDS = Object.keys(EFFECTS);
