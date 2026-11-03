// Reos Lite protocol: single source of truth, shared by the web app and reos-mobile.

/** Gamma table sampled from the vendor app (Array R). Index = 0..255 input. */
export const GAMMA_TABLE = [
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 
  4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 
  11, 11, 12, 12, 13, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 
  21, 21, 22, 22, 23, 24, 24, 25, 25, 26, 27, 27, 28, 29, 29, 30, 31, 32, 32, 33, 34, 
  35, 35, 36, 37, 38, 39, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 50, 51, 52, 
  54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 66, 67, 68, 69, 70, 72, 73, 74, 75, 77, 
  78, 79, 81, 82, 83, 85, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 
  107, 109, 110, 112, 114, 115, 117, 119, 120, 122, 124, 126, 127, 129, 131, 133, 135, 
  137, 138, 140, 142, 144, 146, 148, 150, 152, 154, 156, 158, 160, 162, 164, 167, 169, 
  171, 173, 175, 177, 180, 182, 184, 186, 189, 191, 193, 196, 198, 200, 203, 205, 208, 
  210, 213, 215, 218, 220, 223, 225, 228, 231, 233, 236, 239, 241, 244, 247, 249, 252, 255
];

/** @param {number} val 0..255 @returns {number} */
export function applyGamma(val) {
  return GAMMA_TABLE[Math.max(0, Math.min(255, Math.round(val)))];
}

export const NAME_PREFIX = 'Lite-';

export const ReosProtocol = {
  SERVICE_UUID: '0000fff0-0000-1000-8000-00805f9b34fb',
  CHARACTERISTIC_UUID: '0000fff3-0000-1000-8000-00805f9b34fb',

  /**
   * Calculates the Reos checksum for 17-byte packets:
   * 1 + sum of payload bytes from index 2 to 13, modulo 256.
   * @param {Uint8Array} payload
   * @returns {number}
   */
  calculateChecksum(payload) {
    let sum = 1;
    for (let i = 2; i <= 13; i++) {
      sum += payload[i];
    }
    return sum & 0xFF;
  },

  /**
   * Calculates the checksum for 14-byte short packets (like Power ON/OFF):
   * 1 + sum of payload bytes from index 2 to 10, modulo 256.
   * @param {Uint8Array} payload
   * @returns {number}
   */
  calculateShortChecksum(payload) {
    let sum = 1;
    for (let i = 2; i <= 10; i++) {
      sum += payload[i];
    }
    return sum & 0xFF;
  },

  /**
   * Returns the 14-byte Power ON command sequence parameterized by active R, G, B, and Brightness.
   * Matches Android app's bArr16: {15, 10, 13, 0, R, G, B, Bri, 5, 0, 0, Checksum, -1, -1}
   */
  getPowerOnPacket(r = 255, g = 255, b = 255, brightness = 208) {
    const payload = new Uint8Array(14);
    payload[0] = 0x0F;
    payload[1] = 0x0A;
    payload[2] = 0x0D; // Command 13 (Power Command)
    payload[3] = 0x00;
    payload[4] = r;
    payload[5] = g;
    payload[6] = b;
    payload[7] = brightness;
    payload[8] = 0x05; // Mode 5 = ON
    payload[9] = 0x00;
    payload[10] = 0x00;
    payload[11] = this.calculateShortChecksum(payload);
    payload[12] = 0xFF;
    payload[13] = 0xFF;
    return payload;
  },

  /**
   * Returns the 14-byte Power OFF command sequence.
   */
  getPowerOffPacket() {
    return new Uint8Array([0x0f, 0x0a, 0x0d, 0x00, 0x00, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x13, 0xff, 0xff]);
  },

  /**
   * LITE1100 RGB Color packet.
   * Forces index 9 = 0x00, index 10 = 0x01.
   * @param {number} r @param {number} g @param {number} b @param {number} brightness
   * @returns {Uint8Array}
   */
  getColorPacket(r, g, b, brightness) {
    const payload = new Uint8Array(17);
    payload[0] = 0x0F;
    payload[1] = 0x0D;
    payload[2] = 0x03;
    payload[3] = 0x00;
    payload[4] = r;
    payload[5] = g;
    payload[6] = b;
    payload[7] = brightness;
    payload[8] = 0x00; // Warmth is 0 in RGB mode
    payload[9] = 0x00; // RGB Mode control headers
    payload[10] = 0x01;
    payload[11] = 0x00;
    payload[12] = 0x00;
    payload[13] = 0x00;
    payload[14] = this.calculateChecksum(payload);
    payload[15] = 0xFF;
    payload[16] = 0xFF;
    return payload;
  },

  /**
   * LITE1100 White Light packet.
   * Forces R=255, G=255, B=255, index 9 = 0x01, index 10 = 0x01.
   * @param {number} brightness @param {number} warmth
   * @returns {Uint8Array}
   */
  getWhitePacket(brightness, warmth) {
    const payload = new Uint8Array(17);
    payload[0] = 0x0F;
    payload[1] = 0x0D;
    payload[2] = 0x03;
    payload[3] = 0x00;
    payload[4] = 255; // R (Always 255 for White Mode)
    payload[5] = 255; // G
    payload[6] = 255; // B
    payload[7] = brightness;
    payload[8] = warmth; // 0 to 200
    payload[9] = 0x01;  // White Mode control headers
    payload[10] = 0x01;
    payload[11] = 0x00;
    payload[12] = 0x00;
    payload[13] = 0x00;
    payload[14] = this.calculateChecksum(payload);
    payload[15] = 0xFF;
    payload[16] = 0xFF;
    return payload;
  },

  /**
   * Save-settings packet (restore last colour on power-up).
   * @param {boolean} [enableRestoreLastColor]
   * @returns {Uint8Array}
   */
  getSaveSettingsPacket(enableRestoreLastColor = true) {
    const payload = new Uint8Array(11);
    payload[0] = 0x0F;
    payload[1] = 0x07;
    payload[2] = 0x05;
    payload[3] = 0x00;
    payload[4] = 0x00;
    payload[5] = 0x01;
    payload[6] = enableRestoreLastColor ? 0x00 : 0x01;
    payload[7] = 0x01;
    let sum = 1;
    for (let i = 2; i <= 7; i++) sum += payload[i];
    payload[8] = sum & 0xFF;
    payload[9] = 0xFF;
    payload[10] = 0xFF;
    return payload;
  }
};
