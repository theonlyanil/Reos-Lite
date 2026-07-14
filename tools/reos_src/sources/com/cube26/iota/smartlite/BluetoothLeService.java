package com.cube26.iota.smartlite;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.util.h;
import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothLeService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3024a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BluetoothGattCallback f3025b = new BluetoothGattCallback() { // from class: com.cube26.iota.smartlite.BluetoothLeService.1
        private void a(int i) {
            Message messageObtain = Message.obtain(h.y.a());
            messageObtain.what = 14594;
            messageObtain.arg1 = i;
            h.y.a().sendMessage(messageObtain);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            int i = 0;
            while (i < h.v.size() && !bluetoothGatt.equals(h.v.get(i).v())) {
                i++;
            }
            if (i != h.v.size()) {
                com.cube26.iota.smartlite.d.a aVar = h.v.get(i);
                if (h.q) {
                    BluetoothLeService.this.a(Place.TYPE_SUBLOCALITY_LEVEL_5, bluetoothGattCharacteristic, i);
                    return;
                }
                if (aVar.k()) {
                    byte[] value = bluetoothGattCharacteristic.getValue();
                    System.arraycopy(value, 0, aVar.l(), aVar.j(), value.length);
                    aVar.d(value.length + aVar.j());
                    CLog.a("IOTA", " schedule response array :: ");
                    byte[] bArrL = aVar.l();
                    if (aVar.j() == aVar.i() && bArrL[aVar.i() - 1] == -1 && bArrL[aVar.i() - 2] == -1) {
                        if (h.f3471e) {
                            BluetoothLeService.this.a(Place.TYPE_SUBPREMISE, i, aVar.l(), h.f3468b);
                        }
                        if (h.f3472f) {
                            BluetoothLeService.this.a(Place.TYPE_SYNTHETIC_GEOCODE, i, aVar.l(), h.f3469c);
                        }
                        aVar.d(false);
                        return;
                    }
                    return;
                }
                byte[] value2 = bluetoothGattCharacteristic.getValue();
                if (i < h.v.size()) {
                    if (value2[2] == 4) {
                        h.J[0] = value2[4];
                        h.J[1] = value2[5];
                        h.J[2] = value2[6];
                        int iArgb = Color.argb(100, (int) value2[4], (int) value2[5], (int) value2[6]);
                        Message messageObtain = Message.obtain(h.y.a());
                        messageObtain.what = 14595;
                        messageObtain.arg1 = i;
                        messageObtain.arg2 = iArgb;
                        h.y.a().sendMessage(messageObtain);
                    }
                    if (value2[2] == 20) {
                        if (value2[4] != 0) {
                            aVar.d(true);
                            aVar.c((value2[4] * 15) + 8);
                            aVar.a(new byte[aVar.i()]);
                            aVar.d(value2.length);
                            System.arraycopy(value2, 0, aVar.l(), 0, value2.length);
                        } else {
                            if (h.f3471e) {
                                BluetoothLeService.this.a(Place.TYPE_SUBPREMISE, i, value2, h.f3468b);
                            }
                            if (h.f3472f) {
                                BluetoothLeService.this.a(Place.TYPE_SYNTHETIC_GEOCODE, i, value2, h.f3469c);
                            }
                        }
                    }
                    if (value2[2] == 17) {
                        BluetoothLeService.this.a(Place.TYPE_ROUTE, i, value2);
                        BluetoothLeService.this.a(Place.TYPE_POINT_OF_INTEREST, bluetoothGattCharacteristic, i);
                        BluetoothLeService.f3024a = false;
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            int i2;
            CLog.a("IOTA", "onCharacteristicRead");
            int iTimestamp = (int) bluetoothGattCharacteristic.getUuid().timestamp();
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= h.v.size() || bluetoothGatt.equals(h.v.get(i2).v())) {
                    break;
                } else {
                    i3 = i2 + 1;
                }
            }
            if (i == 0) {
                if (iTimestamp == 10752) {
                    CLog.a("IOTA", " action data name");
                    BluetoothLeService.this.a(Place.TYPE_POST_BOX, bluetoothGattCharacteristic, i2);
                }
                if (iTimestamp == 65521) {
                    BluetoothLeService.this.a(Place.TYPE_POSTAL_CODE, bluetoothGattCharacteristic, i2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                if (!h.A) {
                    h.y.a().sendEmptyMessageDelayed(Place.TYPE_SUBLOCALITY_LEVEL_1, 30L);
                    return;
                }
                synchronized (h.z) {
                    h.z.notifyAll();
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            CLog.a("IOTA", " onConnectionStateChange :: " + i2);
            int i3 = 0;
            while (i3 < h.v.size() && !bluetoothGatt.equals(h.v.get(i3).v())) {
                i3++;
            }
            if (i3 == h.v.size()) {
                return;
            }
            CLog.a("IOTA", "port :: " + i3);
            com.cube26.iota.smartlite.d.a aVar = h.v.get(i3);
            if (i2 == 2) {
                CLog.a("IOTA", " connected ");
                bluetoothGatt.discoverServices();
                aVar.e(2);
                aVar.e(true);
                aVar.b(0);
                h.l = true;
            } else if (i2 == 0) {
                CLog.a("IOTA", " disconnected");
                if (aVar.m()) {
                    CLog.a("IOTA", "..........STATE_DISCONNECTED");
                    BluetoothLeService.this.a(Place.TYPE_NEIGHBORHOOD, i3);
                    h.w.remove(aVar);
                    aVar.e(0);
                    aVar.e(false);
                } else {
                    bluetoothGatt.close();
                    aVar.e(0);
                    CLog.a("IOTA", " not disconnected by user . so connecting again");
                    aVar.a((BluetoothGatt) null);
                    if (aVar.d() <= 3) {
                        a(i3);
                    } else {
                        aVar.a();
                    }
                }
            } else if (i2 == 1) {
                CLog.a("IOTA", "..........STATE_CONNECTING");
            } else if (i2 == 3) {
                CLog.a("IOTA", "..........STATE_DISCONNECTING");
            }
            if (h.f3470d != null) {
                h.f3470d.sendMessage(Message.obtain(h.f3470d, 17));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            int i2;
            CLog.a("IOTA", "onServicesDiscovered");
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= h.v.size() || bluetoothGatt.equals(h.v.get(i2).v())) {
                    break;
                } else {
                    i3 = i2 + 1;
                }
            }
            if (i != 0) {
                CLog.a("IOTA", "onServicesDiscovered received: " + i);
            } else {
                CLog.a("IOTA", "onServicesDiscovered success");
                BluetoothLeService.this.a(Place.TYPE_POLITICAL, i2);
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f3026c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BluetoothManager f3027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BluetoothAdapter f3028e;

    public class a extends Binder {
        public a() {
        }

        public BluetoothLeService a() {
            return BluetoothLeService.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        Message message = new Message();
        message.obj = null;
        message.what = i;
        message.arg1 = i2;
        h.y.a().sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, byte[] bArr) {
        Message message = new Message();
        message.obj = null;
        message.what = i;
        message.arg1 = i2;
        Bundle bundle = new Bundle();
        bundle.putByteArray("EXTRA_DATA", bArr);
        message.setData(bundle);
        h.y.a().sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, byte[] bArr, Handler handler) {
        Message messageObtain = Message.obtain(handler);
        messageObtain.what = i;
        messageObtain.arg1 = i2;
        Bundle bundle = new Bundle();
        bundle.putByteArray("EXTRA_DATA", bArr);
        messageObtain.setData(bundle);
        handler.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        byte[] value = bluetoothGattCharacteristic.getValue();
        Message message = new Message();
        Bundle bundle = new Bundle();
        message.obj = null;
        message.what = i;
        message.arg1 = i2;
        bundle.putByteArray("EXTRA_DATA", value);
        message.setData(bundle);
        h.y.a().sendMessage(message);
    }

    public void a(int i, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f3028e == null || h.v.get(i).v() == null) {
            return;
        }
        h.v.get(i).v().readCharacteristic(bluetoothGattCharacteristic);
    }

    public void a(int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (this.f3028e == null || h.v.get(i).v() == null || h.v.get(i).v() == null || bluetoothGattCharacteristic == null) {
            return;
        }
        h.v.get(i).v().setCharacteristicNotification(bluetoothGattCharacteristic, z);
    }

    public boolean a() {
        if (this.f3027d == null) {
            this.f3027d = (BluetoothManager) getSystemService("bluetooth");
            if (this.f3027d == null) {
                return false;
            }
        }
        this.f3028e = this.f3027d.getAdapter();
        return this.f3028e != null;
    }

    public boolean a(int i, String str) {
        if (this.f3028e == null || str == null) {
            CLog.a("IOTA", "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        h.v.get(i).e(1);
        if (h.v.get(i).v() == null) {
            CLog.a("IOTA", "new connect :: " + h.v.get(i).q());
            BluetoothDevice remoteDevice = this.f3028e.getRemoteDevice(str);
            if (remoteDevice == null) {
                CLog.a("IOTA", "Device not found.  Unable to connect.");
                return false;
            }
            try {
                h.v.get(i).a(remoteDevice.connectGatt(this, false, this.f3025b));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public void b() {
        for (int i = 0; i < h.v.size(); i++) {
            if (h.v.get(i).v() != null) {
                h.v.get(i).v().close();
                h.v.get(i).a((BluetoothGatt) null);
                h.v.get(i).e(0);
            }
        }
    }

    public void b(int i, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f3028e == null || h.v.get(i).v() == null || bluetoothGattCharacteristic == null) {
            return;
        }
        h.v.get(i).v().writeCharacteristic(bluetoothGattCharacteristic);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f3026c;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        b();
        return super.onUnbind(intent);
    }
}
