package com.flurry.sdk;

import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class jf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4452a = jf.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static jf f4453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f4454c = v();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<jn, byte[]> f4455d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kb<lg> f4456e = new kb<lg>() { // from class: com.flurry.sdk.jf.1
        @Override // com.flurry.sdk.kb
        public void a(lg lgVar) {
            switch (AnonymousClass4.f4462a[lgVar.f4682c.ordinal()]) {
                case 1:
                    if (jf.this.c()) {
                        js.a().b(new ly() { // from class: com.flurry.sdk.jf.1.1
                            @Override // com.flurry.sdk.ly
                            public void a() {
                                jf.this.j();
                            }
                        });
                    }
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f4457f = a.NONE;
    private jp g;
    private String h;
    private byte[] i;

    /* JADX INFO: renamed from: com.flurry.sdk.jf$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4462a;

        static {
            try {
                f4463b[a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4463b[a.ADVERTISING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4463b[a.DEVICE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4463b[a.HASHED_IMEI.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4463b[a.REPORTED_IDS.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            f4462a = new int[lg.a.values().length];
            try {
                f4462a[lg.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    enum a {
        NONE,
        ADVERTISING,
        DEVICE,
        HASHED_IMEI,
        REPORTED_IDS,
        FINISHED
    }

    private jf() {
        kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.f4456e);
        js.a().b(new ly() { // from class: com.flurry.sdk.jf.2
            @Override // com.flurry.sdk.ly
            public void a() {
                jf.this.i();
            }
        });
    }

    public static synchronized jf a() {
        if (f4453b == null) {
            f4453b = new jf();
        }
        return f4453b;
    }

    private String a(DataInput dataInput) throws IOException {
        if (1 != dataInput.readInt()) {
            return null;
        }
        return dataInput.readUTF();
    }

    private void a(String str, DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(1);
        dataOutput.writeUTF(str);
    }

    private void a(String str, File file) throws Throwable {
        DataOutputStream dataOutputStream;
        try {
            try {
                dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                try {
                    a(str, dataOutputStream);
                    lt.a(dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    kg.a(6, f4452a, "Error when saving deviceId", th);
                    lt.a(dataOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                lt.a(dataOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }

    private boolean a(String str) {
        return (TextUtils.isEmpty(str) || c(str.toLowerCase(Locale.US))) ? false : true;
    }

    private String b(DataInput dataInput) throws IOException {
        if (46586 != dataInput.readUnsignedShort() || 2 != dataInput.readUnsignedShort()) {
            return null;
        }
        dataInput.readUTF();
        return dataInput.readUTF();
    }

    public static void b() {
        f4453b = null;
    }

    private void b(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File fileStreamPath = js.a().c().getFileStreamPath(u());
        if (ls.a(fileStreamPath)) {
            a(str, fileStreamPath);
        }
    }

    private boolean c(String str) {
        return this.f4454c.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        while (!a.FINISHED.equals(this.f4457f)) {
            switch (this.f4457f) {
                case NONE:
                    this.f4457f = a.ADVERTISING;
                    break;
                case ADVERTISING:
                    this.f4457f = a.DEVICE;
                    break;
                case DEVICE:
                    this.f4457f = a.HASHED_IMEI;
                    break;
                case HASHED_IMEI:
                    this.f4457f = a.REPORTED_IDS;
                    break;
                case REPORTED_IDS:
                    this.f4457f = a.FINISHED;
                    break;
            }
            try {
                switch (this.f4457f) {
                    case ADVERTISING:
                        j();
                        break;
                    case DEVICE:
                        k();
                        break;
                    case HASHED_IMEI:
                        l();
                        break;
                    case REPORTED_IDS:
                        x();
                        break;
                }
            } catch (Exception e2) {
                kg.a(4, f4452a, "Exception during id fetch:" + this.f4457f + ", " + e2);
            }
        }
        kc.a().a(new jg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        lt.b();
        if (m()) {
            this.g = n();
            if (c()) {
                x();
                kc.a().a(new jh());
            }
        }
    }

    private void k() {
        lt.b();
        this.h = o();
    }

    private void l() {
        if (js.a().c().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return;
        }
        w();
    }

    private boolean m() {
        return lu.a(js.a().c());
    }

    private jp n() {
        return lu.b(js.a().c());
    }

    private String o() {
        String strP = p();
        return !TextUtils.isEmpty(strP) ? strP : q();
    }

    private String p() {
        String string = Settings.Secure.getString(js.a().c().getContentResolver(), "android_id");
        if (a(string)) {
            return "AND" + string;
        }
        return null;
    }

    private String q() throws Throwable {
        String strS = s();
        if (TextUtils.isEmpty(strS)) {
            strS = t();
            if (TextUtils.isEmpty(strS)) {
                strS = r();
            }
            b(strS);
        }
        return strS;
    }

    private String r() {
        return "ID" + Long.toString(Double.doubleToLongBits(Math.random()) + ((System.nanoTime() + (lt.i(lq.c(js.a().c())) * 37)) * 37), 16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.flurry.sdk.jf] */
    private String s() throws Throwable {
        DataInputStream dataInputStream;
        String strA = null;
        File fileStreamPath = js.a().c().getFileStreamPath(u());
        if (fileStreamPath != null) {
            ?? Exists = fileStreamPath.exists();
            try {
                if (Exists != 0) {
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                        try {
                            strA = a(dataInputStream);
                            lt.a((Closeable) dataInputStream);
                            Exists = dataInputStream;
                        } catch (Throwable th) {
                            th = th;
                            kg.a(6, f4452a, "Error when loading deviceId", th);
                            lt.a((Closeable) dataInputStream);
                            Exists = dataInputStream;
                        }
                    } catch (Throwable th2) {
                        Exists = 0;
                        th = th2;
                        lt.a((Closeable) Exists);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return strA;
    }

    private String t() throws Throwable {
        String[] list;
        DataInputStream dataInputStream;
        Throwable th;
        String strB = null;
        File filesDir = js.a().c().getFilesDir();
        if (filesDir != null && (list = filesDir.list(new FilenameFilter() { // from class: com.flurry.sdk.jf.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(".flurryagent.");
            }
        })) != null && list.length != 0) {
            File fileStreamPath = js.a().c().getFileStreamPath(list[0]);
            if (fileStreamPath != null && fileStreamPath.exists()) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        try {
                            strB = b(dataInputStream);
                            lt.a((Closeable) dataInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            kg.a(6, f4452a, "Error when loading deviceId", th);
                            lt.a((Closeable) dataInputStream);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        lt.a((Closeable) dataInputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    dataInputStream = null;
                }
            }
        }
        return strB;
    }

    private String u() {
        return ".flurryb.";
    }

    private Set<String> v() {
        HashSet hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        return Collections.unmodifiableSet(hashSet);
    }

    private void w() {
        String deviceId;
        TelephonyManager telephonyManager = (TelephonyManager) js.a().c().getSystemService("phone");
        if (telephonyManager == null || (deviceId = telephonyManager.getDeviceId()) == null || deviceId.trim().length() <= 0) {
            return;
        }
        try {
            byte[] bArrF = lt.f(deviceId);
            if (bArrF == null || bArrF.length != 20) {
                kg.a(6, f4452a, "sha1 is not 20 bytes long: " + Arrays.toString(bArrF));
            } else {
                this.i = bArrF;
            }
        } catch (Exception e2) {
            kg.a(6, f4452a, "Exception in generateHashedImei()");
        }
    }

    private void x() {
        String strD = d();
        if (strD != null) {
            kg.a(3, f4452a, "Fetched advertising id");
            this.f4455d.put(jn.AndroidAdvertisingId, lt.e(strD));
        }
        String strF = f();
        if (strF != null) {
            kg.a(3, f4452a, "Fetched device id");
            this.f4455d.put(jn.DeviceId, lt.e(strF));
        }
        byte[] bArrG = g();
        if (bArrG != null) {
            kg.a(3, f4452a, "Fetched hashed IMEI");
            this.f4455d.put(jn.Sha1Imei, bArrG);
        }
    }

    public boolean c() {
        return a.FINISHED.equals(this.f4457f);
    }

    public String d() {
        if (this.g == null) {
            return null;
        }
        return this.g.a();
    }

    public boolean e() {
        return this.g == null || !this.g.b();
    }

    public String f() {
        return this.h;
    }

    public byte[] g() {
        return this.i;
    }

    public Map<jn, byte[]> h() {
        return Collections.unmodifiableMap(this.f4455d);
    }
}
