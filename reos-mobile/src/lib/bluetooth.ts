import { BleClient, numbersToDataView } from '@capacitor-community/bluetooth-le';
import { Capacitor } from '@capacitor/core';
import { ReosProtocol } from './protocol';

// Patch Web Bluetooth filters to work around a bug in the Capacitor BLE plugin on Web
if (typeof navigator !== 'undefined' && navigator.bluetooth) {
  if (navigator.bluetooth.requestDevice) {
    const originalRequestDevice = navigator.bluetooth.requestDevice.bind(navigator.bluetooth);
    navigator.bluetooth.requestDevice = function (options) {
      if (options && options.filters) {
        options.filters = options.filters.map((filter: any) => {
          const cleaned = { ...filter } as any;
          if (cleaned.name === undefined) delete cleaned.name;
          if (cleaned.namePrefix === undefined) delete cleaned.namePrefix;
          if (cleaned.services === undefined) delete cleaned.services;
          return cleaned;
        });
      }
      return originalRequestDevice(options);
    };
  }

  if ((navigator.bluetooth as any).requestLEScan) {
    const originalRequestLEScan = (navigator.bluetooth as any).requestLEScan.bind(navigator.bluetooth);
    (navigator.bluetooth as any).requestLEScan = function (options: any) {
      if (options && options.filters) {
        options.filters = options.filters.map((filter: any) => {
          const cleaned = { ...filter } as any;
          if (cleaned.name === undefined) delete cleaned.name;
          if (cleaned.namePrefix === undefined) delete cleaned.namePrefix;
          if (cleaned.services === undefined) delete cleaned.services;
          return cleaned;
        });
      }
      return originalRequestLEScan(options);
    };
  }
}


export interface DeviceInfo {
  deviceId: string;
  name: string;
}

export interface LogEntry {
  id: string;
  timestamp: string;
  message: string;
  type: 'info' | 'success' | 'warn' | 'error';
}

class BluetoothManager {
  private initialized = false;

  async init(): Promise<void> {
    if (this.initialized) return;
    try {
      await BleClient.initialize();
      this.initialized = true;
      if (Capacitor.getPlatform() === 'android') {
        await BleClient.requestLocationPermission();
      }
    } catch (e: any) {
      console.error('BleClient initialize error', e);
    }
  }

  async scanAndConnect(onDeviceFound: (device: DeviceInfo) => void, onLog: (msg: string, type?: LogEntry['type']) => void): Promise<void> {
    await this.init();
    onLog('Initiating Web BLE Scan...', 'info');

    try {
      const device = await BleClient.requestDevice({
        services: [ReosProtocol.SERVICE_UUID]
      });
      onLog(`Discovered bulb: ${device.name || device.deviceId}`, 'success');
      await this.connectToDevice(device.deviceId, device.name || 'Lite-Bulb', onDeviceFound, onLog);
    } catch (err: any) {
      onLog(`Bluetooth Scan cancelled or failed: ${err.message || err}`, 'error');
    }
  }

  async startScan(onDeviceDiscovered: (device: DeviceInfo) => void, onLog: (msg: string, type?: LogEntry['type']) => void): Promise<void> {
    await this.init();
    onLog('Scanning environment for smart bulbs...', 'info');
    try {
      await BleClient.requestLEScan({
        services: [ReosProtocol.SERVICE_UUID]
      }, (result) => {
        const name = result.device.name || result.localName || 'Lite-Bulb';
        onDeviceDiscovered({
          deviceId: result.device.deviceId,
          name: name
        });
      });
    } catch (err: any) {
      onLog(`Bluetooth Scan failed: ${err.message || err}`, 'error');
      throw err;
    }
  }

  async stopScan(onLog: (msg: string, type?: LogEntry['type']) => void): Promise<void> {
    try {
      await BleClient.stopLEScan();
      onLog('Bluetooth scan terminated.', 'info');
    } catch (err: any) {
      console.warn('Error stopping scan:', err);
    }
  }

  async connectToDevice(deviceId: string, name: string, onDeviceFound: (device: DeviceInfo) => void, onLog: (msg: string, type?: LogEntry['type']) => void): Promise<void> {
    try {
      onLog(`Connecting GATT link to ${name}...`, 'info');
      await BleClient.connect(deviceId, (disconnectedDeviceId) => {
        onLog(`Connection lost to bulb (${disconnectedDeviceId})`, 'error');
      });
      onLog(`GATT connected to ${name}. Target write endpoint: fff3`, 'success');
      onDeviceFound({ deviceId, name });
    } catch (err: any) {
      onLog(`Failed to connect to ${name}: ${err.message || err}`, 'error');
    }
  }

  async disconnect(deviceId: string, onLog: (msg: string, type?: LogEntry['type']) => void): Promise<void> {
    try {
      await BleClient.disconnect(deviceId);
      onLog(`Disconnected bulb ${deviceId}`, 'info');
    } catch (err: any) {
      onLog(`Error disconnecting ${deviceId}: ${err.message || err}`, 'warn');
    }
  }

  async writePacket(devices: DeviceInfo[], packet: Uint8Array, onLog: (msg: string, type?: LogEntry['type']) => void): Promise<void> {
    if (devices.length === 0) {
      onLog('No bulbs linked. TX ignored.', 'warn');
      return;
    }

    const dataView = numbersToDataView(Array.from(packet));
    const hex = '[ ' + Array.from(packet).map(b => b.toString(16).padStart(2, '0').toUpperCase()).join(' ') + ' ]';

    for (const dev of devices) {
      try {
        await BleClient.writeWithoutResponse(
          dev.deviceId,
          ReosProtocol.SERVICE_UUID,
          ReosProtocol.CHARACTERISTIC_UUID,
          dataView
        );
      } catch (err: any) {
        onLog(`TX failed on ${dev.name}: ${err.message || err}`, 'error');
      }
    }
    onLog(`TX OK -> ${hex}`, 'success');
  }
}

export const bleManager = new BluetoothManager();
