import type { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.reos.lite',
  appName: 'Reos Lite',
  webDir: 'dist',
  server: {
    androidScheme: 'https'
  }
};

export default config;
