const ReosProtocol = {
  SERVICE_UUID: '0000fff0-0000-1000-8000-00805f9b34fb',
  CHARACTERISTIC_UUID: '0000fff3-0000-1000-8000-00805f9b34fb',

  /**
   * Calculates the Reos checksum for 17-byte packets:
   * 1 + sum of payload bytes from index 2 to 13, modulo 256.
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
  }
};
