package com.cube26.iota.smartlite;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.util.h;
import com.cube26.iota.smartlite.util.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AutoScanConnectService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Handler f3010f;
    private static Handler g;
    private static com.cube26.iota.smartlite.a.a h;
    private static ArrayList<String> i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f3011a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f3013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f3014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BluetoothLeService f3015e;
    private ScanCallback k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f3012b = new ArrayList<>();
    private BluetoothAdapter.LeScanCallback j = new BluetoothAdapter.LeScanCallback() { // from class: com.cube26.iota.smartlite.AutoScanConnectService.2
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            if (bluetoothDevice != null) {
                try {
                    AutoScanConnectService.this.a(bluetoothDevice);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    };
    private final ServiceConnection l = new ServiceConnection() { // from class: com.cube26.iota.smartlite.AutoScanConnectService.3
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CLog.a("IOTA", " bleservice on service connected callback");
            h.t = ((BluetoothLeService.a) iBinder).a();
            AutoScanConnectService.this.f3011a = AutoScanConnectService.this.new c();
            AutoScanConnectService.this.f3013c = AutoScanConnectService.this.new b("DeviceScanThread");
            AutoScanConnectService.this.f3014d = AutoScanConnectService.this.new a("ConnectionHandlerThread");
            AutoScanConnectService.this.c();
            AutoScanConnectService.this.f3013c.start();
            AutoScanConnectService.this.f3014d.start();
            if (Build.VERSION.SDK_INT > 22) {
                AutoScanConnectService.this.e();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CLog.a("IOTA", " on service disconnected");
            AutoScanConnectService.this.f3015e = null;
        }
    };
    private int m = 0;

    private class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            CLog.a("IOTA", " connection handler thread on looper prepared ");
            Handler unused = AutoScanConnectService.g = new Handler(getLooper()) { // from class: com.cube26.iota.smartlite.AutoScanConnectService.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    switch (message.what) {
                        case 3:
                            CLog.a("IOTA", " new lite discovered");
                            CLog.a("IOTA", " selected list size :: " + h.v.size());
                            com.cube26.iota.smartlite.d.a aVar = (com.cube26.iota.smartlite.d.a) message.obj;
                            if (h.v.contains(aVar)) {
                                return;
                            }
                            synchronized (h.m) {
                                h.v.add(aVar);
                                break;
                            }
                            CLog.a("IOTA", "adding lite to checked list :: " + aVar.q());
                            CLog.a("IOTA", "selected device size :: " + h.v.size());
                            if (AutoScanConnectService.g != null) {
                                if (h.t == null) {
                                    AutoScanConnectService.g.sendMessage(Message.obtain(AutoScanConnectService.g, 5));
                                    return;
                                } else {
                                    AutoScanConnectService.g.sendMessage(Message.obtain(AutoScanConnectService.g, 4));
                                    return;
                                }
                            }
                            return;
                        case 4:
                            CLog.a("IOTA", "Utility.selectedDeviceList.size() " + h.v.size() + "getAutoConnectEnabledLiteCount()" + AutoScanConnectService.this.f());
                            CLog.a("IOTA", " connect lite message ");
                            int size = h.v.size();
                            h.t.a(size - 1, h.v.get(size - 1).q());
                            if (h.f3470d == null && h.v.size() == AutoScanConnectService.this.f()) {
                                AutoScanConnectService.b();
                                return;
                            }
                            return;
                        case 5:
                            Intent intent = new Intent(AutoScanConnectService.this, (Class<?>) BluetoothLeService.class);
                            AutoScanConnectService.this.startService(intent);
                            AutoScanConnectService.this.bindService(intent, AutoScanConnectService.this.l, 65);
                            if (AutoScanConnectService.g != null) {
                                AutoScanConnectService.g.sendMessage(Message.obtain(AutoScanConnectService.g, 4));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            };
        }
    }

    private class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            CLog.a("IOTA", " device scan thread on looper prepared");
            Handler unused = AutoScanConnectService.f3010f = new Handler(getLooper()) { // from class: com.cube26.iota.smartlite.AutoScanConnectService.b.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    CLog.a("IOTA", " device scan handler ");
                    switch (message.what) {
                        case 1:
                            AutoScanConnectService.this.m = 0;
                            CLog.a("IOTA", " start scan ");
                            try {
                                if (Build.VERSION.SDK_INT <= 22) {
                                    h.s.startLeScan(AutoScanConnectService.this.j);
                                } else {
                                    CLog.a("IOTA", "starting scan");
                                    if (h.u == null) {
                                        h.u = h.s.getBluetoothLeScanner();
                                    }
                                    if (h.u != null) {
                                        h.u.startScan(AutoScanConnectService.this.k);
                                    }
                                }
                            } catch (IllegalStateException e2) {
                                return;
                            } catch (NullPointerException e3) {
                                return;
                            }
                            break;
                        case 2:
                            try {
                                CLog.a("IOTA", " stop scan");
                                if (Build.VERSION.SDK_INT > 22) {
                                    CLog.a("IOTA", "stopping scan");
                                    if (h.u != null) {
                                        h.u.stopScan(AutoScanConnectService.this.k);
                                    }
                                } else {
                                    h.s.stopLeScan(AutoScanConnectService.this.j);
                                }
                            } catch (IllegalStateException e4) {
                                return;
                            } catch (NullPointerException e5) {
                                return;
                            }
                            break;
                    }
                }
            };
            if (AutoScanConnectService.this.g()) {
                AutoScanConnectService.a();
            }
        }
    }

    public class c extends Binder {
        public c() {
        }

        public AutoScanConnectService a() {
            return AutoScanConnectService.this;
        }
    }

    public AutoScanConnectService() {
        h = new com.cube26.iota.smartlite.a.a(this);
    }

    public static void a() {
        CLog.a("IOTA", " start lite scan method");
        i = h.d();
        Message messageObtain = Message.obtain(f3010f, 1);
        if (f3010f != null) {
            f3010f.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluetoothDevice bluetoothDevice) {
        if (h.w.size() + h.v.size() >= 7 || bluetoothDevice.getName() == null) {
            return;
        }
        if (bluetoothDevice.getName().contains("Lite") || bluetoothDevice.getName().equalsIgnoreCase("LITE") || bluetoothDevice.getName().equalsIgnoreCase("Lite1100")) {
            CLog.a("IOTA", " name:: " + bluetoothDevice.getName());
            com.cube26.iota.smartlite.d.a aVar = new com.cube26.iota.smartlite.d.a();
            aVar.d(bluetoothDevice.getName());
            aVar.e(bluetoothDevice.getAddress());
            aVar.a((BluetoothGatt) null);
            aVar.b(true);
            aVar.a(bluetoothDevice.getName());
            if (bluetoothDevice.getName().equalsIgnoreCase("LITE1100")) {
                aVar.a(true);
            }
            CLog.a("IOTA", " adding ble device :: " + bluetoothDevice.getAddress());
            if (i.contains(aVar.q())) {
                CLog.a("IOTA", " adding saved ble device :: " + bluetoothDevice.getAddress());
                aVar.c(true);
            }
            if (a(bluetoothDevice.getAddress())) {
                Message messageObtain = Message.obtain(g, 3);
                messageObtain.obj = aVar;
                if (g != null) {
                    g.sendMessage(messageObtain);
                }
                h.l = true;
                return;
            }
            if (h.w.contains(aVar) || h.w.size() >= 7) {
                return;
            }
            CLog.a("IOTA", " adding ble device to scanned list " + bluetoothDevice.getAddress());
            h.w.add(aVar);
        }
    }

    private boolean a(Context context) {
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return false;
        }
        CLog.a("IOTA", " init ble " + (h.f3470d == null && !h.g(this)));
        if (h.f3470d == null && !h.g(this)) {
            return false;
        }
        CLog.a("IOTA", " init ble ");
        h.s = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        if (Build.VERSION.SDK_INT > 22) {
            h.u = h.s.getBluetoothLeScanner();
        }
        if (h.s == null) {
            return false;
        }
        CLog.a("IOTA", "Binding service as BLE is on");
        return true;
    }

    private boolean a(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences("LiteAutoConnectStatus", 0);
        CLog.a("IOTA", " auto connect status for lite :: " + str + " :: status :: " + sharedPreferences.getBoolean(str, false));
        return sharedPreferences.getBoolean(str, false);
    }

    public static void b() {
        CLog.a("IOTA", " stop lite scan method");
        Message messageObtain = Message.obtain(f3010f, 2);
        if (f3010f != null) {
            f3010f.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.k = new ScanCallback() { // from class: com.cube26.iota.smartlite.AutoScanConnectService.1
            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int i2) {
                super.onScanFailed(i2);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i2, ScanResult scanResult) {
                super.onScanResult(i2, scanResult);
                CLog.a("IOTA", " on scan result callback ");
                try {
                    if (scanResult.getDevice() != null) {
                        AutoScanConnectService.this.a(scanResult.getDevice());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        return getSharedPreferences("LiteAutoConnectStatus", 0).getInt("auto_connect_enabled_lite_count", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return Build.VERSION.SDK_INT <= 22 || checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public void c() {
        CLog.a("IOTA", " init ble thread method");
        if (h.y == null) {
            h.y = new com.cube26.iota.smartlite.util.a(getApplicationContext());
            h.y.start();
        }
        if (h.z == null) {
            h.z = new j();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CLog.a("IOTA", " on bind ");
        return this.f3011a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CLog.a("IOTA", " auto connect on create");
        if (h.m == null) {
            h.m = new Object();
        }
        if (!a(getApplicationContext())) {
            stopSelf();
        }
        Intent intent = new Intent(this, (Class<?>) BluetoothLeService.class);
        startService(intent);
        bindService(intent, this.l, 65);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f3013c != null) {
            this.f3013c.quit();
        }
        if (this.f3014d != null) {
            this.f3014d.quit();
        }
        CLog.a("IOTA", " destroying autoscanconnect service");
        for (int i2 = 0; i2 < h.w.size(); i2++) {
            h.w.remove(i2);
        }
        if (h.m == null) {
            h.m = new Object();
        }
        for (int i3 = 0; i3 < h.v.size(); i3++) {
            synchronized (h.m) {
                h.v.remove(i3);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        CLog.b("IOTA", " on start command");
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        CLog.b("IOTA", " on task removed");
        if (Build.VERSION.SDK_INT == 19) {
            Intent intent2 = new Intent(getApplicationContext(), getClass());
            intent2.setPackage(getPackageName());
            ((AlarmManager) getApplicationContext().getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 1000, PendingIntent.getService(getApplicationContext(), 1, intent2, 1073741824));
        }
    }
}
