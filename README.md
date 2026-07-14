# Reos Lite Control Center 💡

A premium, fully client-side, zero-dependency web dashboard utilizing the **Web Bluetooth API** to control **Reos Lite 1100** smart LED bulbs. Built with HTML5, JavaScript, and Tailwind CSS.

---

## 🚀 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/reos-lite-control.git
   cd reos-lite-control
   ```
2. Open `index.html` in your browser via a secure context (`HTTPS` or `localhost`).
   * *Quick local server:* Run `python3 -m http.server 8000` in the directory, then navigate to `http://localhost:8000`.

---

## 🛠️ The Journey: From Zero to One

When we started, there was **zero public documentation** on how to communicate with the Reos Lite BLE smart bulb. Here is how we reverse-engineered the device:

### Phase 1: APK Decompilation
We obtained the official Android application package (`reos.apk`) and decompiled it using `jadx` to inspect the Java codebase.

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
We mapped the Java logic into modular ES6 JavaScript (`protocol.js` and `app.js`), designed a responsive Apple-style dark dashboard using Tailwind CSS, and verified GATT transmission timings.

---

## 📱 Mobile Compatibility (iOS / iPhone)

Apple's iOS forces all browsers (Chrome, Firefox, Edge) to run WebKit's **WKWebView** rendering engine under the hood, which has Web Bluetooth disabled. 

To run this dashboard on an iPhone:
1. Download **Bluefy** (free Web Bluetooth browser) or **WebBLE** from the iOS App Store.
2. Open the app and navigate to your dashboard URL (e.g. `http://your-local-ip:8000`).
3. Pair and control your bulbs!
