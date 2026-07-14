# Reos Reverse Engineering Tools 🛠️

This directory contains the original assets, decompilers, and diagnostic tools used to reverse engineer the Reos Lite BLE protocol.

## Contents

### 1. `reos.apk`
The original Android companion application package from which we extracted the firmware control logic.

### 2. `jadx-1.4.7.zip` & `jadx/`
The decompilation environment (JADX) used to extract readable Java class signatures and utility files from the compiled Dalvik bytecode inside `reos.apk`.

### 3. `reos_src/`
The fully decompiled Java source code tree of the official app.
*   **Key File:** `reos_src/sources/com/cube26/iota/smartlite/util/h.java` contains the GATT communication arrays, byte building routines, and checksum calculations.
*   **Color Dialog Picker Logic:** `reos_src/sources/com/cube26/iota/smartlite/c/b.java` handles layout bindings, fragment state, and interface updates.

---

## 🔬 Protocol Reference Notes
During inspection of `h.java`, the following details were confirmed:
*   **Service UUID:** `0000fff0-0000-1000-8000-00805f9b34fb`
*   **Characteristic UUID:** `0000fff3-0000-1000-8000-00805f9b34fb` (Maps to endpoint `.u()`)
*   **Write Mode:** Writable characteristics require `write-without-response`.
