package com.cube26.iota.smartlite.util;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.android.library.http.HTTPLibrary;
import com.cube26.iota.smartlite.BluetoothLeService;
import com.flurry.android.Constants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.location.places.Place;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f3448a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f3449e;
    private byte[] i;
    private int l;
    private final Context m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f3453f = new byte[256];
    private int g = 0;
    private int h = 0;
    private int j = 100;
    private int k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3450b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Runnable f3451c = new Runnable() { // from class: com.cube26.iota.smartlite.util.a.1
        @Override // java.lang.Runnable
        public void run() {
            b.a("IOTA", "Synstate");
            if (h.t == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= h.v.size()) {
                    return;
                }
                b.a("IOTA", "state" + h.v.get(i2).s());
                if (h.v.get(i2).s() != 2) {
                    b.a("IOTA", "Connecting LeSerive::" + h.v.get(i2).q());
                    h.t.a(i2, h.v.get(i2).q());
                } else if (h.v.get(i2).s() == 2 && h.v.get(i2).n() == null) {
                    b.a("IOTA", "Syncing Devices with current sys time from SynState :: Started");
                    a.this.c(i2);
                }
                i = i2 + 1;
            }
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Runnable f3452d = new Runnable() { // from class: com.cube26.iota.smartlite.util.a.3
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.arg1 = 255;
            message.what = Place.TYPE_SUBLOCALITY_LEVEL_2;
            a.f3448a.sendMessage(message);
        }
    };

    public a(Context context) {
        this.m = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (h.t == null) {
            return;
        }
        b.a("IOTA", "lite port " + i);
        b.a("IOTA", "state" + h.v.get(i).s());
        if (h.v.get(i).s() != 2) {
            b.a("IOTA", "Connecting LeSerive::" + h.v.get(i).q());
            h.t.a(i, h.v.get(i).q());
        }
    }

    private void a(int i, List<BluetoothGattService> list) {
        if (list == null) {
            return;
        }
        Iterator<BluetoothGattService> it = list.iterator();
        while (it.hasNext()) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : it.next().getCharacteristics()) {
                switch ((int) bluetoothGattCharacteristic.getUuid().timestamp()) {
                    case 10752:
                        b.a("IOTA", "Characterstics :: 0x2A00 ");
                        h.v.get(i).a(bluetoothGattCharacteristic);
                        break;
                    case 65521:
                        b.a("IOTA", "Characterstics :: 0xFFF1 ");
                        h.v.get(i).d(bluetoothGattCharacteristic);
                        break;
                    case 65523:
                        b.a("IOTA", "Characterstics :: 0xFFF3 ");
                        h.v.get(i).e(2);
                        h.v.get(i).b(bluetoothGattCharacteristic);
                        break;
                    case 65524:
                        b.a("IOTA", "Characterstics :: 0xFFF4 ");
                        h.v.get(i).c(bluetoothGattCharacteristic);
                        h.t.a(i, bluetoothGattCharacteristic, true);
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, byte[] bArr) {
        String str = String.format("%d.%02d", Byte.valueOf(bArr[11]), Byte.valueOf(bArr[12]));
        b.a("IOTA", " version :: " + str);
        if (i < h.v.size()) {
            h.v.get(i).c(str);
            h.d(i);
        }
        e(i);
    }

    private void b(int i) {
        h.t.a(i, h.v.get(i).w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, byte[] bArr) {
        try {
            h.v.get(i).d(new String(bArr, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        b.a("IOTA", " read serial number ::  " + i);
        byte[] bArr = {15, 5, 17, 0, 0, 0, 18, -1, -1};
        int i2 = 1;
        for (int i3 = 2; i3 < 6; i3++) {
            i2 += bArr[i3];
        }
        bArr[6] = (byte) (i2 & 255);
        h.a(i, bArr);
        BluetoothLeService.f3024a = true;
        f3449e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, byte[] bArr) {
        b.a("IOTA", " read serial number callback ::" + i);
        String str = new String(bArr, 4, 16);
        b.a("IOTA", " lite serial number :: " + str);
        h.v.get(i).b(str);
        b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        b.a("IOTA", "Action Gatt services discovered :: " + i);
        try {
            a(i, h.v.get(i).v().getServices());
        } catch (Exception e2) {
            e2.printStackTrace();
            b.a("IOTA", "AnalyDiscovered exception caught");
        }
        c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, byte[] bArr) {
        if (this.g == 0 && bArr[0] == 15) {
            this.h = (bArr[1] & Constants.UNKNOWN) + 4;
            System.arraycopy(bArr, 0, this.f3453f, 0, bArr.length);
            this.g = bArr.length;
        } else if (this.g != 0 && this.g + bArr.length < 256) {
            System.arraycopy(bArr, 0, this.f3453f, this.g, bArr.length);
            this.g += bArr.length;
        }
        if (this.h == 0 || this.h != this.g) {
            return;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            b.a("IOTA", "i :: " + i2 + " value :: " + ((int) bArr[i2]));
        }
        switch (this.f3453f[2]) {
            case -1:
                Message message = new Message();
                message.what = Place.TYPE_SUBLOCALITY_LEVEL_2;
                if (this.f3453f[4] == 0) {
                    f(i);
                } else if (this.f3453f[4] == 1) {
                    g(i);
                } else if (this.f3453f[4] == 2) {
                    h.q = false;
                    b.a("IOTA", "update successful");
                    message.arg1 = 2;
                    h.C.sendMessage(message);
                } else if (this.f3453f[4] == 3) {
                    h.q = false;
                    message.arg1 = 3;
                    h.C.sendMessage(message);
                }
                break;
        }
        this.g = 0;
        this.h = 0;
    }

    private void e(int i) {
        new JSONObject();
        com.cube26.iota.smartlite.d.a aVar = h.v.get(i);
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList<String> arrayListF = h.f(this.m);
            String str = arrayListF.size() > 0 ? arrayListF.get(0) : "";
            jSONObject.put("activationTime", String.valueOf(System.currentTimeMillis()));
            jSONObject.put(Scopes.EMAIL, String.valueOf(str));
            jSONObject.put("firmwareVersion", String.valueOf(aVar.o()));
            jSONObject.put("macAddress", String.valueOf(aVar.q()));
            jSONObject.put("serialNumber", String.valueOf(aVar.n()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            HTTPLibrary.postAnalyticsEvents(this.m, h.b.f3478b + "save_lite_activation/", com.android.library.http.d.d.a("lite", "", "com.cube26.iota.smartlite", "2.0", "", jSONArray), 2, 10);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, byte[] bArr) {
        b.a("IOTA", " sendUpgradedata :: ");
        b.b("IOTA", " curpack :: " + this.k);
        for (byte b2 : bArr) {
            b.b("IOTA", ((int) b2) + "");
        }
        if (h.v.get(i).f3370c != null) {
            h.v.get(i).f3370c.setWriteType(1);
            h.v.get(i).f3370c.setValue(bArr);
            h.t.b(i, h.v.get(i).f3370c);
        }
        b.a("IOTA", " curpack :: " + this.k + " pkt :: " + this.j);
        if (this.k >= this.j) {
            k(i);
        }
    }

    private void f(int i) {
        b.a("IOTA", " StartUpgrade2 :: ");
        byte[] bArr = {15, 6, -1, 0, 1, 0, 0, 1, -1, -1};
        if (h.v.get(i).f3369b != null) {
            h.v.get(i).f3369b.setValue(bArr);
            h.t.b(i, h.v.get(i).f3369b);
        }
    }

    private void g(int i) {
        h.A = false;
        b.a("IOTA", " write2light :: ");
        f3448a.removeCallbacks(this.f3452d);
        b.a("IOTA", " fcheck :: " + this.f3450b);
        this.j = this.i.length / 20;
        if (this.i.length % 20 != 0) {
            this.j++;
        }
        h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        b.a("IOTA", " sendCurpack ");
        b.a("IOTA", " pkt :: " + this.j + " :: curpack :: " + this.k);
        if (this.j == 0 || h.v.get(i).s() != 2) {
            Message message = new Message();
            message.arg1 = 255;
            message.what = Place.TYPE_SUBLOCALITY_LEVEL_2;
            h.C.sendMessage(message);
            return;
        }
        b.a("IOTA", " pkt :: " + this.j + " :: curpack :: " + this.k);
        if (this.k == this.j - 1) {
            h.A = true;
            byte[] bArr = new byte[this.i.length - (this.k * 20)];
            for (int i2 = 0; i2 < this.i.length - (this.k * 20); i2++) {
                bArr[i2] = (byte) (this.i[(this.k * 20) + i2] & Constants.UNKNOWN);
            }
            h.a((Handler) null, 12345, i, bArr);
        } else {
            byte[] bArr2 = new byte[20];
            for (int i3 = 0; i3 < 20; i3++) {
                bArr2[i3] = (byte) (this.i[(this.k * 20) + i3] & Constants.UNKNOWN);
            }
            h.a((Handler) null, 12345, i, bArr2);
        }
        this.k++;
        Message message2 = new Message();
        message2.what = Place.TYPE_SUBLOCALITY_LEVEL_3;
        message2.arg1 = (this.k * 99) / this.j;
        h.C.sendMessage(message2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i) {
        b.a("IOTA", "localUpgrade ");
        try {
            AssetManager assets = this.m.getAssets();
            InputStream inputStreamOpen = null;
            com.cube26.iota.smartlite.d.a aVar = h.v.get(i);
            if (aVar != null && aVar.c() != null) {
                inputStreamOpen = aVar.c().equalsIgnoreCase("LITE") ? assets.open("cube26_led.hex") : null;
                if (aVar.c().equalsIgnoreCase("LITE1100")) {
                    Log.d("IOTA", " 1100");
                    inputStreamOpen = assets.open("cube_V1.02_1100.hex");
                }
            }
            if (inputStreamOpen == null) {
                Toast.makeText(this.m, "Please reconnect the lite for firmware upgrade!", 0).show();
                return;
            }
            this.i = new byte[inputStreamOpen.available()];
            this.f3450b = 0;
            int i2 = 0;
            while (true) {
                int i3 = inputStreamOpen.read();
                if (i3 == -1) {
                    j(i);
                    return;
                } else {
                    this.i[i2] = (byte) i3;
                    this.f3450b += i3;
                    i2++;
                }
            }
        } catch (Exception e2) {
            f3448a.sendEmptyMessage(Place.TYPE_SUBLOCALITY_LEVEL_4);
            e2.printStackTrace();
        }
    }

    private void j(int i) {
        byte[] bArr = {15, 6, -1, 0, 0, 0, 0, 0, -1, -1};
        f3448a.postDelayed(this.f3452d, 30000L);
        if (h.v.get(i).f3369b != null) {
            h.v.get(i).f3369b.setValue(bArr);
            h.t.b(i, h.v.get(i).f3369b);
        }
    }

    private void k(int i) {
        int i2 = 1;
        b.a("IOTA", "StopUpgrade ");
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        byte[] bArr = {15, 6, -1, 0, 2, (byte) (((this.f3450b + 1) / 256) & 255), (byte) ((this.f3450b + 1) % 256), 0, -1, -1};
        for (int i3 = 2; i3 < 7; i3++) {
            i2 += bArr[i3];
        }
        bArr[7] = (byte) (i2 & 255);
        b.a("IOTA", " fcheck :: " + this.f3450b);
        for (byte b2 : bArr) {
            b.a("IOTA", " value :: " + ((int) b2));
        }
        if (h.v.get(i).f3369b != null) {
            h.v.get(i).f3369b.setValue(bArr);
            h.t.b(i, h.v.get(i).f3369b);
        }
    }

    public Handler a() {
        return f3448a;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        f3448a = new Handler(Looper.myLooper()) { // from class: com.cube26.iota.smartlite.util.a.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 158:
                        if (message.arg1 < h.v.size()) {
                            h.a(message.arg1, message.getData().getByteArray("val"));
                        }
                        break;
                    case Place.TYPE_POLITICAL /* 1012 */:
                        if (message.arg1 < h.v.size()) {
                            a.this.d(message.arg1);
                        }
                        break;
                    case Place.TYPE_POINT_OF_INTEREST /* 1013 */:
                        Intent intent = new Intent();
                        intent.setAction("progress");
                        intent.putExtra(com.android.library.userprofile.util.Constants.SMS_COLUMN_STATUS, "disconnected");
                        intent.putExtra("port", a.f3449e);
                        a.this.m.sendBroadcast(intent);
                        break;
                    case Place.TYPE_POST_BOX /* 1014 */:
                        a.this.b(message.arg1, message.getData().getByteArray("EXTRA_DATA"));
                        break;
                    case Place.TYPE_POSTAL_CODE /* 1015 */:
                        a.this.a(message.arg1, message.getData().getByteArray("EXTRA_DATA"));
                        break;
                    case Place.TYPE_POSTAL_CODE_PREFIX /* 1016 */:
                        if (message.arg1 == h.v.size() - 1) {
                        }
                        break;
                    case Place.TYPE_ROUTE /* 1020 */:
                        a.this.c(message.arg1, message.getData().getByteArray("EXTRA_DATA"));
                        break;
                    case Place.TYPE_SUBLOCALITY /* 1022 */:
                        b.a("IOTA", "ACTION_START_UPGRADE");
                        h.q = true;
                        a.this.j = 0;
                        a.this.k = 0;
                        a.this.i(h.r);
                        break;
                    case Place.TYPE_SUBLOCALITY_LEVEL_1 /* 1023 */:
                        b.a("IOTA", "ACTION_WRITE_CHARACTERSTIC");
                        a.this.h(h.r);
                        break;
                    case Place.TYPE_SUBLOCALITY_LEVEL_5 /* 1027 */:
                        b.a("IOTA", "ACTION_UPGRADE_AVAIL");
                        a.this.d(message.arg1, message.getData().getByteArray("EXTRA_DATA"));
                        break;
                    case 2003:
                        a.f3448a.post(a.this.f3451c);
                        break;
                    case 2004:
                        if (message.arg1 < h.v.size()) {
                            h.a(message.arg1, message.getData().getByteArray("val"));
                        }
                        break;
                    case 5000:
                        if (message.arg1 < h.v.size()) {
                            h.a(message.arg1, message.getData().getByteArray("val"));
                        }
                        break;
                    case 5001:
                        if (message.arg1 < h.v.size()) {
                            h.a(message.arg1, message.getData().getByteArray("val"));
                        }
                        break;
                    case 12345:
                        b.a("IOTA", "SEND_UPGRAD_DATA");
                        a.this.e(message.arg1, message.getData().getByteArray("val"));
                        break;
                    case 14594:
                        a.this.l = message.arg1;
                        a.this.a(a.this.l);
                        break;
                    case 14595:
                        h.v.get(message.arg1).a(message.arg2);
                        h.f3470d.sendEmptyMessage(17);
                        break;
                }
            }
        };
        Looper.loop();
    }
}
