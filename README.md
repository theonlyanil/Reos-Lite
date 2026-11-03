# Reos Lite Control Center 💡

A premium, fully client-side, zero-dependency web dashboard utilizing the **Web Bluetooth API** to control **Reos Lite 1100** smart LED bulbs. Built with HTML5, JavaScript, and Tailwind CSS.

---

## 🚀 How to Run

**Hosted:** the web app is deployed to GitHub Pages from `main` (Settings → Pages → Source: *GitHub Actions*).

**Locally:**
```bash
git clone https://github.com/theonlyanil/Reos-Lite.git
cd Reos-Lite
python3 -m http.server 8000   # then open http://localhost:8000
```
Web Bluetooth needs a secure context (`https://` or `localhost`). ES modules also need a server, so opening `index.html` via `file://` won't work.

### Supported browsers

| Platform | Works? |
|---|---|
| Chrome / Edge / Opera on desktop | ✅ |
| Chrome on Android | ✅ |
| iOS (any browser), Safari, Firefox | ❌ no Web Bluetooth. Use Bluefy (below) or the native `reos-mobile` app |

### Pairing several bulbs & auto-connect

* **Add new bulb** opens the browser's chooser, filtered to bulbs named `Lite*` (e.g. `Lite-1A2B` or `Lite1100`) or advertising the control service `fff0`. Browsers only allow *one* pick per chooser, and Chrome requires a fresh tap each time (Android always, desktop sometimes), so tap **Add another bulb** for each additional bulb. Bulbs of one model may share the same advertised name, so rows get a `#xxxx` suffix and a **Blink** button to identify the physical bulb.
* A bulb only talks to one controller: disconnect it from other phones/laptops/the Reos app first, or it won't be listed.
* **Can't see a bulb?** Open *Can't see your bulb?* in the app. *Show all nearby devices* lists every BLE device so you can find a bulb with an unexpected name.
* Paired bulbs are remembered. On every page load the app asks the browser for them (`navigator.bluetooth.getDevices()`) and connects all in parallel. Bulbs that are out of range are picked up automatically once they start advertising (`watchAdvertisements`), and dropped links reconnect with backoff.
* On older Chrome versions, `getDevices` needs `chrome://flags/#enable-web-bluetooth-new-permissions-backend`.
* Changes are queued per bulb ("latest wins"), so dragging a slider never floods a bulb with stale writes.

### Project layout

| Path | Purpose |
|---|---|
| `index.html`, `style.css`, `app.js` | Web dashboard UI |
| `bulbs.js` | Connection manager (pairing registry, reconnect, write queue) |
| `protocol.js` | Packet builders + gamma table. **Single source of truth**, also imported by `reos-mobile` |
| `sw.js`, `manifest.webmanifest` | Installable PWA / offline shell |
| `reos-mobile/` | Capacitor + Svelte native app (Android/iOS) |
| `tools/` | Reverse-engineering notes (APK/decompiled source are git-ignored; bring your own) |

### Mobile app

```bash
cd reos-mobile
npm install
npm run build && npx cap sync android   # then open in Android Studio
```

## 🛠️ The Journey: From Zero to One

When we started, there was **zero public documentation** on how to communicate with the Reos Lite BLE smart bulb. Here is how we reverse-engineered the device:

### Phase 1: APK Decompilation
We obtained the official Android application package (`reos.apk`, not redistributed here) and decompiled it using `jadx` to inspect the Java codebase.

### Phase 2: Protocol Analysis
We traced the Bluetooth GATT code to `com.cube26.iota.smartlite.util.h` and identified:
1. **Control Service:** `0000fff0-0000-1000-8000-00805f9b34fb`
2. **Control Characteristic:** `0000fff3-0000-1000-8000-00805f9b34fb`

We reverse-engineered the 17-byte command packet payload:
*   **Header bytes:** `0x0F, 0x0D` (Length and command header)
*   **Command ID:** `0x03` at index 2
*   **RGB channels:** Red (index 4), Green (index 5), Blue (index 6)
*   **Brightness:** Dimmer value (index 7, ranging from `16` to `208`)
*   **Warmth:** Color temperature (index 8, ranging from `0` to `200`)
*   **Mode Switch Flags:** Bytes 9 and 10 act as a driver mode selector:
    *   `0x00, 0x01` toggles **RGB Mode** (uses index 4, 5, 6 for colors).
    *   `0x01, 0x01` toggles **White Mode** (uses index 8 for warmth shifting, setting RGB channels to `255`).
*   **Checksum:** Index 14 holds the checksum. Sum of bytes from index 2 to 13, plus 1, modulo 256:
    ```javascript
    (1 + sum(payload[2..13])) & 0xFF
    ```
*   **Footer bytes:** `0xFF, 0xFF` at index 15 and 16.

### Phase 3: Web Bluetooth Implementation
We mapped the Java logic into modular ES6 JavaScript (`protocol.js`, `bulbs.js` and `app.js`), designed a responsive Apple-style dark dashboard using Tailwind CSS, and verified GATT transmission timings.

---

## 📱 Mobile Compatibility (iOS / iPhone)

Apple's iOS forces all browsers (Chrome, Firefox, Edge) to run WebKit's **WKWebView** rendering engine under the hood, which has Web Bluetooth disabled. 

To run this dashboard on an iPhone:
1. Download **Bluefy** (free Web Bluetooth browser) or **WebBLE** from the iOS App Store.
2. Open the app and navigate to your dashboard URL (e.g. `http://your-local-ip:8000`).
3. Pair and control your bulbs!
