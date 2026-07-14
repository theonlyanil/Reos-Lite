package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.library.userprofile.util.Constants;
import com.flurry.android.FlurryEventRecordStatus;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class jb implements ll.a {
    private WeakReference<lf> k;
    private File l;
    private jz<List<iz>> m;
    private boolean n;
    private long o;
    private boolean p;
    private String q;
    private byte r;
    private Long s;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4418f = jb.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f4413a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f4414b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static int f4415c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f4416d = 160000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int f4417e = 50;
    private final AtomicInteger g = new AtomicInteger(0);
    private final AtomicInteger h = new AtomicInteger(0);
    private final AtomicInteger i = new AtomicInteger(0);
    private final kb<lg> j = new kb<lg>() { // from class: com.flurry.sdk.jb.1
        @Override // com.flurry.sdk.kb
        public void a(lg lgVar) {
            if (jb.this.k == null || lgVar.f4681b == jb.this.k.get()) {
                switch (AnonymousClass8.f4442a[lgVar.f4682c.ordinal()]) {
                    case 1:
                        jb.this.a(lgVar.f4681b, lgVar.f4680a.get());
                        break;
                    case 2:
                        jb.this.a(lgVar.f4680a.get());
                        break;
                    case 3:
                        jb.this.b(lgVar.f4680a.get());
                        break;
                    case 4:
                        kc.a().b("com.flurry.android.sdk.FlurrySessionEvent", jb.this.j);
                        jb.this.a(lgVar.f4683d);
                        break;
                }
            }
        }
    };
    private int t = -1;
    private final List<iz> u = new ArrayList();
    private final Map<String, List<String>> v = new HashMap();
    private final Map<String, String> w = new HashMap();
    private final Map<String, iv> x = new HashMap();
    private final List<iw> y = new ArrayList();
    private boolean z = true;
    private int A = 0;
    private final List<iu> B = new ArrayList();
    private int C = 0;
    private int D = 0;
    private boolean E = true;
    private final hm F = new hm();
    private final kb<jg> G = new kb<jg>() { // from class: com.flurry.sdk.jb.9
        @Override // com.flurry.sdk.kb
        public void a(jg jgVar) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.9.1
                @Override // com.flurry.sdk.ly
                public void a() {
                    jb.this.a(true, je.a().d());
                }
            });
        }
    };

    /* JADX INFO: renamed from: com.flurry.sdk.jb$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4442a = new int[lg.a.values().length];

        static {
            try {
                f4442a[lg.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4442a[lg.a.START.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4442a[lg.a.END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4442a[lg.a.FINALIZE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public jb() {
        kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.j);
    }

    @TargetApi(18)
    private void a(boolean z) {
        Exception exc;
        boolean z2;
        int i;
        int intExtra;
        int i2 = -1;
        if (z) {
            this.w.put("boot.time", Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                this.w.put("disk.size.total.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.w.put("disk.size.available.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.w.put("disk.size.total.external", Long.toString(statFs2.getAvailableBlocksLong()));
                this.w.put("disk.size.available.external", Long.toString(statFs2.getAvailableBlocksLong()));
            } else {
                this.w.put("disk.size.total.internal", Long.toString(statFs.getAvailableBlocks()));
                this.w.put("disk.size.available.internal", Long.toString(statFs.getAvailableBlocks()));
                this.w.put("disk.size.total.external", Long.toString(statFs2.getAvailableBlocks()));
                this.w.put("disk.size.available.external", Long.toString(statFs2.getAvailableBlocks()));
            }
            this.w.put("carrier.name", jm.a().c());
            this.w.put("carrier.details", jm.a().d());
        }
        ActivityManager activityManager = (ActivityManager) js.a().c().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        this.w.put("memory.available" + (z ? ".start" : ".end"), Long.toString(memoryInfo.availMem));
        if (Build.VERSION.SDK_INT >= 16) {
            this.w.put("memory.total" + (z ? ".start" : ".end"), Long.toString(memoryInfo.availMem));
        }
        try {
            Intent intentRegisterReceiver = js.a().c().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                int intExtra2 = intentRegisterReceiver.getIntExtra(Constants.SMS_COLUMN_STATUS, -1);
                z2 = intExtra2 == 2 || intExtra2 == 5;
                try {
                    int intExtra3 = intentRegisterReceiver.getIntExtra("level", -1);
                    try {
                        intExtra = intentRegisterReceiver.getIntExtra("scale", -1);
                        i2 = intExtra3;
                    } catch (Exception e2) {
                        i = intExtra3;
                        exc = e2;
                        kg.a(5, f4418f, "Error getting battery status: " + exc);
                        i2 = i;
                        intExtra = -1;
                    }
                } catch (Exception e3) {
                    exc = e3;
                    i = -1;
                }
            } else {
                z2 = false;
                intExtra = -1;
            }
        } catch (Exception e4) {
            exc = e4;
            z2 = false;
            i = -1;
        }
        float f2 = i2 / intExtra;
        this.w.put("battery.charging" + (z ? ".start" : ".end"), Boolean.toString(z2));
        this.w.put("battery.remaining" + (z ? ".start" : ".end"), Float.toString(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, long j) {
        byte[] bArrA;
        if (!this.E) {
            kg.a(3, f4418f, "Analytics disabled, not sending agent report.");
        } else if (z || !this.u.isEmpty()) {
            kg.a(3, f4418f, "generating agent report");
            try {
                bArrA = new ix(js.a().d(), jo.a().e(), this.n, jf.a().e(), this.o, j, this.u, jf.a().h(), this.F.a(false), this.v, ju.a().c(), System.currentTimeMillis()).a();
            } catch (Exception e2) {
                kg.e(f4418f, "Exception while generating report: " + e2);
                bArrA = null;
            }
            if (bArrA == null) {
                kg.e(f4418f, "Error generating report");
            } else {
                kg.a(3, f4418f, "generated report of size " + bArrA.length + " with " + this.u.size() + " reports.");
                hl.a().d().b(bArrA, js.a().d(), "" + jt.a());
            }
            j();
        }
    }

    private synchronized void b(long j) {
        for (iw iwVar : this.y) {
            if (iwVar.a() && !iwVar.b()) {
                iwVar.a(j);
            }
        }
    }

    private void c(Context context) {
        Bundle extras;
        if (!(context instanceof Activity) || (extras = ((Activity) context).getIntent().getExtras()) == null) {
            return;
        }
        kg.a(3, f4418f, "Launch Options Bundle is present " + extras.toString());
        for (String str : extras.keySet()) {
            if (str != null) {
                Object obj = extras.get(str);
                String string = obj != null ? obj.toString() : "null";
                this.v.put(str, new ArrayList(Arrays.asList(string)));
                kg.a(3, f4418f, "Launch options Key: " + str + ". Its value: " + string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        kg.a(4, f4418f, "Loading persistent session report data.");
        List<iz> listA = this.m.a();
        if (listA != null) {
            this.u.addAll(listA);
        } else if (this.l.exists()) {
            kg.a(4, f4418f, "Legacy persistent agent data found, converting.");
            jc jcVarA = ho.a(this.l);
            if (jcVarA != null) {
                boolean zA = jcVarA.a();
                long jB = jcVarA.b();
                if (jB <= 0) {
                    jB = je.a().d();
                }
                this.n = zA;
                this.o = jB;
                n();
                List<iz> listC = jcVarA.c();
                if (listC != null) {
                    this.u.addAll(listC);
                }
            }
            this.l.delete();
            c();
        }
    }

    private void j() {
        this.u.clear();
        this.m.b();
    }

    private String k() {
        return ".flurryagent." + Integer.toString(js.a().d().hashCode(), 16);
    }

    private String l() {
        return ".yflurryreport." + Long.toString(lt.i(js.a().d()), 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        SharedPreferences sharedPreferences = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        this.n = sharedPreferences.getBoolean("com.flurry.sdk.previous_successful_report", false);
        this.o = sharedPreferences.getLong("com.flurry.sdk.initial_run_time", je.a().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        SharedPreferences.Editor editorEdit = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editorEdit.putBoolean("com.flurry.sdk.previous_successful_report", this.n);
        editorEdit.putLong("com.flurry.sdk.initial_run_time", this.o);
        editorEdit.commit();
    }

    private int o() {
        return this.g.incrementAndGet();
    }

    private int p() {
        return this.h.incrementAndGet();
    }

    public synchronized FlurryEventRecordStatus a(String str, String str2, Map<String, String> map, boolean z) {
        FlurryEventRecordStatus flurryEventRecordStatusA;
        flurryEventRecordStatusA = FlurryEventRecordStatus.kFlurryEventFailed;
        if (map != null && !TextUtils.isEmpty(str2)) {
            map.put("\ue8ffsid+Tumblr", str2);
            flurryEventRecordStatusA = a(str, map, false);
            kg.a(5, f4418f, "logEvent status for syndication:" + flurryEventRecordStatusA);
        }
        return flurryEventRecordStatusA;
    }

    public synchronized FlurryEventRecordStatus a(String str, Map<String, String> map, boolean z) {
        FlurryEventRecordStatus flurryEventRecordStatus;
        FlurryEventRecordStatus flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventRecorded;
        if (this.E) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - je.a().e();
            final String strB = lt.b(str);
            if (strB.length() == 0) {
                flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
            } else {
                iv ivVar = this.x.get(strB);
                if (ivVar != null) {
                    ivVar.f4385a++;
                    kg.e(f4418f, "Event count incremented: " + strB);
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
                } else if (this.x.size() < f4413a) {
                    iv ivVar2 = new iv();
                    ivVar2.f4385a = 1;
                    this.x.put(strB, ivVar2);
                    kg.e(f4418f, "Event count started: " + strB);
                    flurryEventRecordStatus = flurryEventRecordStatus2;
                } else {
                    kg.e(f4418f, "Too many different events. Event not counted: " + strB);
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventUniqueCountExceeded;
                }
                if (!this.p || this.y.size() >= f4415c || this.A >= f4416d) {
                    this.z = false;
                } else {
                    final Map<String, String> mapEmptyMap = map == null ? Collections.emptyMap() : map;
                    if (mapEmptyMap.size() > f4414b) {
                        kg.e(f4418f, "MaxEventParams exceeded: " + mapEmptyMap.size());
                        flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventParamsCountExceeded;
                    } else {
                        iw iwVar = new iw(o(), strB, mapEmptyMap, jElapsedRealtime, z);
                        if (iwVar.d() + this.A <= f4416d) {
                            this.y.add(iwVar);
                            this.A = iwVar.d() + this.A;
                            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
                            if (this.E && hl.a().c() != null) {
                                js.a().b(new Runnable() { // from class: com.flurry.sdk.jb.7
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        hl.a().c().a(strB, mapEmptyMap);
                                    }
                                });
                            }
                        } else {
                            this.A = f4416d;
                            this.z = false;
                            kg.e(f4418f, "Event Log size exceeded. No more event details logged.");
                            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventLogCountExceeded;
                        }
                    }
                }
            }
        } else {
            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventAnalyticsDisabled;
            kg.e(f4418f, "Analytics has been disabled, not logging event.");
        }
        return flurryEventRecordStatus;
    }

    synchronized iz a(long j, long j2, long j3, int i) {
        iz izVar;
        ja jaVar = new ja();
        jaVar.a(jo.a().e());
        jaVar.a(j);
        jaVar.b(j2);
        jaVar.c(j3);
        jaVar.a(this.w);
        jaVar.b(je.a().i());
        jaVar.c(je.a().j());
        jaVar.b(je.a().k());
        jaVar.d(ji.a().c());
        jaVar.e(ji.a().d());
        jaVar.a(i);
        jaVar.b(this.t != -1 ? this.t : lr.j());
        jaVar.f(d());
        jaVar.a(jj.a().e());
        jaVar.c(h());
        jaVar.a(this.r);
        jaVar.a(this.s);
        jaVar.c(g());
        jaVar.a(e());
        jaVar.a(this.z);
        jaVar.b(f());
        jaVar.d(this.C);
        try {
            izVar = new iz(jaVar);
        } catch (IOException e2) {
            kg.a(5, f4418f, "Error creating analytics session report: " + e2);
            izVar = null;
        }
        if (izVar == null) {
            kg.e(f4418f, "New session report wasn't created");
        }
        return izVar;
    }

    public void a() {
        this.n = true;
    }

    public synchronized void a(final long j) {
        kc.a().a(this.G);
        js.a().b(new ly() { // from class: com.flurry.sdk.jb.5
            @Override // com.flurry.sdk.ly
            public void a() {
                if (jb.this.E && hl.a().c() != null) {
                    hl.a().c().d();
                }
                if (hl.a().e() != null) {
                    js.a().b(new ly() { // from class: com.flurry.sdk.jb.5.1
                        @Override // com.flurry.sdk.ly
                        public void a() {
                            hl.a().e().d();
                        }
                    });
                }
            }
        });
        if (jf.a().c()) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.6
                @Override // com.flurry.sdk.ly
                public void a() {
                    jb.this.a(false, j);
                }
            });
        }
        lk.a().b("Gender", (ll.a) this);
        lk.a().b("UserId", (ll.a) this);
        lk.a().b("Age", (ll.a) this);
        lk.a().b("LogEvents", (ll.a) this);
    }

    public synchronized void a(Context context) {
        this.t = lr.j();
        if (hl.a().e() != null) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.15
                @Override // com.flurry.sdk.ly
                public void a() {
                    hl.a().e().e();
                }
            });
        }
        if (this.E && hl.a().c() != null) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.16
                @Override // com.flurry.sdk.ly
                public void a() {
                    hl.a().c().c();
                }
            });
        }
    }

    public void a(lf lfVar, Context context) {
        this.k = new WeakReference<>(lfVar);
        lk lkVarA = lk.a();
        this.p = ((Boolean) lkVarA.a("LogEvents")).booleanValue();
        lkVarA.a("LogEvents", (ll.a) this);
        kg.a(4, f4418f, "initSettings, LogEvents = " + this.p);
        this.q = (String) lkVarA.a("UserId");
        lkVarA.a("UserId", (ll.a) this);
        kg.a(4, f4418f, "initSettings, UserId = " + this.q);
        this.r = ((Byte) lkVarA.a("Gender")).byteValue();
        lkVarA.a("Gender", (ll.a) this);
        kg.a(4, f4418f, "initSettings, Gender = " + ((int) this.r));
        this.s = (Long) lkVarA.a("Age");
        lkVarA.a("Age", (ll.a) this);
        kg.a(4, f4418f, "initSettings, BirthDate = " + this.s);
        this.E = ((Boolean) lkVarA.a("analyticsEnabled")).booleanValue();
        lkVarA.a("analyticsEnabled", (ll.a) this);
        kg.a(4, f4418f, "initSettings, AnalyticsEnabled = " + this.E);
        this.l = context.getFileStreamPath(k());
        this.m = new jz<>(context.getFileStreamPath(l()), ".yflurryreport.", 1, new le<List<iz>>() { // from class: com.flurry.sdk.jb.10
            @Override // com.flurry.sdk.le
            public lb<List<iz>> a(int i) {
                return new la(new iz.a());
            }
        });
        c(context);
        a(true);
        if (hl.a().c() != null) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.11
                @Override // com.flurry.sdk.ly
                public void a() {
                    hl.a().c().b();
                }
            });
        }
        js.a().b(new ly() { // from class: com.flurry.sdk.jb.12
            @Override // com.flurry.sdk.ly
            public void a() {
                jb.this.i();
            }
        });
        js.a().b(new ly() { // from class: com.flurry.sdk.jb.13
            @Override // com.flurry.sdk.ly
            public void a() {
                jb.this.m();
            }
        });
        if (jf.a().c()) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.14
                @Override // com.flurry.sdk.ly
                public void a() {
                    jb.this.a(true, je.a().d());
                }
            });
        } else {
            kc.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", this.G);
        }
    }

    @Override // com.flurry.sdk.ll.a
    public void a(String str, Object obj) {
        switch (str) {
            case "LogEvents":
                this.p = ((Boolean) obj).booleanValue();
                kg.a(4, f4418f, "onSettingUpdate, LogEvents = " + this.p);
                break;
            case "UserId":
                this.q = (String) obj;
                kg.a(4, f4418f, "onSettingUpdate, UserId = " + this.q);
                break;
            case "Gender":
                this.r = ((Byte) obj).byteValue();
                kg.a(4, f4418f, "onSettingUpdate, Gender = " + ((int) this.r));
                break;
            case "Age":
                this.s = (Long) obj;
                kg.a(4, f4418f, "onSettingUpdate, Birthdate = " + this.s);
                break;
            case "analyticsEnabled":
                this.E = ((Boolean) obj).booleanValue();
                kg.a(4, f4418f, "onSettingUpdate, AnalyticsEnabled = " + this.E);
                break;
            default:
                kg.a(6, f4418f, "onSettingUpdate internal error!");
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0059  */
    public synchronized void a(String str, String str2, String str3, Throwable th) {
        boolean z;
        int i = 0;
        synchronized (this) {
            if (str == null) {
                z = false;
            } else if ("uncaught".equals(str)) {
                z = true;
            } else {
                z = false;
            }
            this.C++;
            if (this.B.size() < f4417e) {
                iu iuVar = new iu(p(), Long.valueOf(System.currentTimeMillis()).longValue(), str, str2, str3, th);
                this.B.add(iuVar);
                kg.e(f4418f, "Error logged: " + iuVar.c());
            } else if (z) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.B.size()) {
                        break;
                    }
                    iu iuVar2 = this.B.get(i2);
                    if (iuVar2.c() != null && !"uncaught".equals(iuVar2.c())) {
                        this.B.set(i2, new iu(p(), Long.valueOf(System.currentTimeMillis()).longValue(), str, str2, str3, th));
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                kg.e(f4418f, "Max errors logged. No more errors logged.");
            }
        }
    }

    public synchronized void a(String str, Map<String, String> map) {
        for (iw iwVar : this.y) {
            if (iwVar.a(str)) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - je.a().e();
                if (map != null && map.size() > 0 && this.A < f4416d) {
                    int iD = this.A - iwVar.d();
                    HashMap map2 = new HashMap(iwVar.c());
                    iwVar.a(map);
                    if (iwVar.d() + iD > f4416d) {
                        iwVar.b(map2);
                        this.z = false;
                        this.A = f4416d;
                        kg.e(f4418f, "Event Log size exceeded. No more event details logged.");
                    } else if (iwVar.c().size() > f4414b) {
                        kg.e(f4418f, "MaxEventParams exceeded on endEvent: " + iwVar.c().size());
                        iwVar.b(map2);
                    } else {
                        this.A = iD + iwVar.d();
                    }
                }
                iwVar.a(jElapsedRealtime);
                break;
            }
        }
    }

    public synchronized void b() {
        this.D++;
    }

    public synchronized void b(Context context) {
        a(false);
        final long jD = je.a().d();
        final long jF = je.a().f();
        final long jH = je.a().h();
        final int iA = je.a().l().a();
        b(je.a().f());
        if (this.E && hl.a().c() != null) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.2
                @Override // com.flurry.sdk.ly
                public void a() {
                    hl.a().c().a(jD);
                }
            });
        }
        js.a().b(new ly() { // from class: com.flurry.sdk.jb.3
            @Override // com.flurry.sdk.ly
            public void a() {
                jb.this.n();
            }
        });
        if (jf.a().c()) {
            js.a().b(new ly() { // from class: com.flurry.sdk.jb.4
                @Override // com.flurry.sdk.ly
                public void a() {
                    iz izVarA = jb.this.a(jD, jF, jH, iA);
                    jb.this.u.clear();
                    jb.this.u.add(izVarA);
                    jb.this.c();
                }
            });
        }
    }

    public synchronized void c() {
        kg.a(4, f4418f, "Saving persistent agent data.");
        this.m.a(this.u);
    }

    String d() {
        return this.q == null ? "" : this.q;
    }

    List<iw> e() {
        return this.y;
    }

    List<iu> f() {
        return this.B;
    }

    Map<String, iv> g() {
        return this.x;
    }

    int h() {
        return this.D;
    }
}
