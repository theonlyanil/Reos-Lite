export const ReosProtocol = {
  SERVICE_UUID: '0000fff0-0000-1000-8000-00805f9b34fb',
  CHARACTERISTIC_UUID: '0000fff3-0000-1000-8000-00805f9b34fb',

  calculateChecksum(payload: Uint8Array): number {
    let sum = 1;
    for (let i = 2; i <= 13; i++) {
      sum += payload[i];
    }
    return sum & 0xFF;
  },

  calculateShortChecksum(payload: Uint8Array): number {
    let sum = 1;
    for (let i = 2; i <= 10; i++) {
      sum += payload[i];
    }
    return sum & 0xFF;
  },

  getPowerOnPacket(r = 255, g = 255, b = 255, brightness = 208): Uint8Array {
    const payload = new Uint8Array(14);
    payload[0] = 0x0F;
    payload[1] = 0x0A;
    payload[2] = 0x0D;
    payload[3] = 0x00;
    payload[4] = r;
    payload[5] = g;
    payload[6] = b;
    payload[7] = brightness;
    payload[8] = 0x05;
    payload[9] = 0x00;
    payload[10] = 0x00;
    payload[11] = this.calculateShortChecksum(payload);
    payload[12] = 0xFF;
    payload[13] = 0xFF;
    return payload;
  },

  getPowerOffPacket(): Uint8Array {
    return new Uint8Array([0x0f, 0x0a, 0x0d, 0x00, 0x00, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x13, 0xff, 0xff]);
  },

  getColorPacket(r: number, g: number, b: number, brightness: number): Uint8Array {
    const payload = new Uint8Array(17);
    payload[0] = 0x0F;
    payload[1] = 0x0D;
    payload[2] = 0x03;
    payload[3] = 0x00;
    payload[4] = r;
    payload[5] = g;
    payload[6] = b;
    payload[7] = brightness;
    payload[8] = 0x00;
    payload[9] = 0x00;
    payload[10] = 0x01;
    payload[11] = 0x00;
    payload[12] = 0x00;
    payload[13] = 0x00;
    payload[14] = this.calculateChecksum(payload);
    payload[15] = 0xFF;
    payload[16] = 0xFF;
    return payload;
  },

  getWhitePacket(brightness: number, warmth: number): Uint8Array {
    const payload = new Uint8Array(17);
    payload[0] = 0x0F;
    payload[1] = 0x0D;
    payload[2] = 0x03;
    payload[3] = 0x00;
    payload[4] = 255;
    payload[5] = 255;
    payload[6] = 255;
    payload[7] = brightness;
    payload[8] = warmth;
    payload[9] = 0x01;
    payload[10] = 0x01;
    payload[11] = 0x00;
    payload[12] = 0x00;
    payload[13] = 0x00;
    payload[14] = this.calculateChecksum(payload);
    payload[15] = 0xFF;
    payload[16] = 0xFF;
    return payload;
  },

  getSaveSettingsPacket(enableRestoreLastColor = true): Uint8Array {
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
    for (let i = 2; i <= 7; i++) {
      sum += payload[i];
    }
    payload[8] = sum & 0xFF;
    payload[9] = 0xFF;
    payload[10] = 0xFF;
    return payload;
  }
};
