package com.flurry.sdk;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ig implements ll.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4275a = ig.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f4276b = "https://proton.flurry.com/sdk/v1/config";
    private jz<ie> i;
    private jz<List<in>> j;
    private boolean n;
    private String o;
    private boolean p;
    private boolean q;
    private long s;
    private boolean t;
    private ht u;
    private boolean v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f4277c = new ly() { // from class: com.flurry.sdk.ig.1
        @Override // com.flurry.sdk.ly
        public void a() {
            ig.this.g();
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kb<jg> f4278d = new kb<jg>() { // from class: com.flurry.sdk.ig.4
        @Override // com.flurry.sdk.kb
        public void a(jg jgVar) {
            ig.this.g();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kb<jh> f4279e = new kb<jh>() { // from class: com.flurry.sdk.ig.5
        @Override // com.flurry.sdk.kb
        public void a(jh jhVar) {
            ig.this.g();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kb<jk> f4280f = new kb<jk>() { // from class: com.flurry.sdk.ig.6
        @Override // com.flurry.sdk.kb
        public void a(jk jkVar) {
            if (jkVar.f4479a) {
                ig.this.g();
            }
        }
    };
    private final kk<hs> g = new kk<>("proton config request", new is());
    private final kk<ht> h = new kk<>("proton config response", new it());
    private final Cif k = new Cif();
    private final jx<String, hw> l = new jx<>();
    private final List<in> m = new ArrayList();
    private long r = 10000;

    public ig() {
        this.p = true;
        lk lkVarA = lk.a();
        this.n = ((Boolean) lkVarA.a("ProtonEnabled")).booleanValue();
        lkVarA.a("ProtonEnabled", (ll.a) this);
        kg.a(4, f4275a, "initSettings, protonEnabled = " + this.n);
        this.o = (String) lkVarA.a("ProtonConfigUrl");
        lkVarA.a("ProtonConfigUrl", (ll.a) this);
        kg.a(4, f4275a, "initSettings, protonConfigUrl = " + this.o);
        this.p = ((Boolean) lkVarA.a("analyticsEnabled")).booleanValue();
        lkVarA.a("analyticsEnabled", (ll.a) this);
        kg.a(4, f4275a, "initSettings, AnalyticsEnabled = " + this.p);
        kc.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", this.f4278d);
        kc.a().a("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", this.f4279e);
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", this.f4280f);
        this.i = new jz<>(js.a().c().getFileStreamPath(o()), ".yflurryprotonconfig.", 1, new le<ie>() { // from class: com.flurry.sdk.ig.7
            @Override // com.flurry.sdk.le
            public lb<ie> a(int i) {
                return new ie.a();
            }
        });
        this.j = new jz<>(js.a().c().getFileStreamPath(p()), ".yflurryprotonreport.", 1, new le<List<in>>() { // from class: com.flurry.sdk.ig.8
            @Override // com.flurry.sdk.le
            public lb<List<in>> a(int i) {
                return new la(new in.a());
            }
        });
        js.a().b(new ly() { // from class: com.flurry.sdk.ig.9
            @Override // com.flurry.sdk.ly
            public void a() {
                ig.this.j();
            }
        });
        js.a().b(new ly() { // from class: com.flurry.sdk.ig.10
            @Override // com.flurry.sdk.ly
            public void a() {
                ig.this.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(long j, boolean z, byte[] bArr) {
        if (bArr != null) {
            kg.a(4, f4275a, "Saving proton config response");
            ie ieVar = new ie();
            ieVar.a(j);
            ieVar.a(z);
            ieVar.a(bArr);
            this.i.a(ieVar);
        }
    }

    private boolean a(hr hrVar) {
        if (hrVar != null && hrVar.f4231a != null) {
            for (int i = 0; i < hrVar.f4231a.size(); i++) {
                hq hqVar = hrVar.f4231a.get(i);
                if (hqVar != null && (hqVar.f4226b.equals("") || hqVar.f4225a == -1 || hqVar.f4229e.equals("") || !a(hqVar.f4227c))) {
                    kg.a(3, f4275a, "A callback template is missing required values");
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        if (a(htVar.f4246e) && !htVar.f4246e.f4235e.equals("")) {
            return true;
        }
        kg.a(3, f4275a, "Config response is missing required values.");
        return false;
    }

    private boolean a(List<hw> list) {
        if (list == null) {
            return true;
        }
        for (hw hwVar : list) {
            if (hwVar.f4251a.equals("")) {
                kg.a(3, f4275a, "An event is missing a name");
                return false;
            }
            if ((hwVar instanceof hx) && ((hx) hwVar).f4253c.equals("")) {
                kg.a(3, f4275a, "An event trigger is missing a param name");
                return false;
            }
        }
        return true;
    }

    private synchronized void b(long j) {
        Iterator<in> it = this.m.iterator();
        while (it.hasNext()) {
            if (j == it.next().b()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(String str, Map<String, String> map) {
        ir irVar;
        boolean z;
        kg.a(3, f4275a, "Event triggered: " + str);
        if (!this.p) {
            kg.e(f4275a, "Analytics and pulse have been disabled.");
        } else if (this.u == null) {
            kg.a(3, f4275a, "Config response is empty. No events to fire.");
        } else {
            lt.b();
            if (!TextUtils.isEmpty(str)) {
                List<hw> listA = this.l.a(str);
                if (listA == null || listA.size() == 0) {
                    kg.a(3, f4275a, "No events to fire. Returning.");
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    boolean z2 = map != null;
                    switch (str) {
                        case "flurry.session_start":
                            irVar = ir.SESSION_START;
                            break;
                        case "flurry.session_end":
                            irVar = ir.SESSION_END;
                            break;
                        case "flurry.app_install":
                            irVar = ir.INSTALL;
                            break;
                        default:
                            irVar = ir.APPLICATION_EVENT;
                            break;
                    }
                    HashMap map2 = new HashMap();
                    for (hw hwVar : listA) {
                        boolean z3 = false;
                        if (hwVar instanceof hx) {
                            kg.a(4, f4275a, "Event contains triggers.");
                            String[] strArr = ((hx) hwVar).f4254d;
                            if (strArr == null) {
                                kg.a(4, f4275a, "Template does not contain trigger values. Firing.");
                                z3 = true;
                            } else if (strArr.length == 0) {
                                kg.a(4, f4275a, "Template does not contain trigger values. Firing.");
                                z3 = true;
                            } else if (map == null) {
                                kg.a(4, f4275a, "Publisher has not passed in params list. Not firing.");
                            }
                            String str2 = map.get(((hx) hwVar).f4253c);
                            if (str2 == null) {
                                kg.a(4, f4275a, "Publisher params has no value associated with proton key. Not firing.");
                            } else {
                                int i = 0;
                                while (true) {
                                    if (i >= strArr.length) {
                                        z = z3;
                                    } else if (strArr[i].equals(str2)) {
                                        z = true;
                                    } else {
                                        i++;
                                    }
                                }
                                if (z) {
                                    kg.a(4, f4275a, "Publisher params match proton values. Firing.");
                                } else {
                                    kg.a(4, f4275a, "Publisher params list does not match proton param values. Not firing.");
                                }
                            }
                        }
                        hq hqVar = hwVar.f4252b;
                        if (hqVar == null) {
                            kg.a(3, f4275a, "Template is empty. Not firing current event.");
                        } else {
                            kg.a(3, f4275a, "Creating callback report for partner: " + hqVar.f4226b);
                            HashMap map3 = new HashMap();
                            map3.put("event_name", str);
                            map3.put("event_time_millis", String.valueOf(jCurrentTimeMillis));
                            map2.put(Long.valueOf(hqVar.f4225a), new ij(hqVar.f4226b, hqVar.f4225a, this.k.a(hqVar.f4229e, map3), System.currentTimeMillis() + 259200000, this.u.f4246e.f4232b, hqVar.g, hqVar.f4228d, hqVar.j, hqVar.i, hqVar.h, hqVar.f4230f != null ? this.k.a(hqVar.f4230f, map3) : null));
                        }
                    }
                    if (map2.size() != 0) {
                        in inVar = new in(str, z2, je.a().d(), je.a().g(), irVar, map2);
                        if ("flurry.session_end".equals(str)) {
                            kg.a(3, f4275a, "Storing Pulse callbacks for event: " + str);
                            this.m.add(inVar);
                        } else {
                            kg.a(3, f4275a, "Firing Pulse callbacks for event: " + str);
                            im.a().a(inVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (this.n) {
            lt.b();
            SharedPreferences sharedPreferences = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
            if (sharedPreferences.getBoolean("com.flurry.android.flurryAppInstall", true)) {
                b("flurry.app_install", (Map<String, String>) null);
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putBoolean("com.flurry.android.flurryAppInstall", false);
                editorEdit.apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0052 A[Catch: all -> 0x00ad, TryCatch #0 {, blocks: (B:4:0x0004, B:8:0x000a, B:10:0x0011, B:12:0x001b, B:15:0x002a, B:17:0x002e, B:19:0x0032, B:31:0x00b4, B:33:0x00c4, B:35:0x00d0, B:36:0x00db, B:38:0x00eb, B:20:0x003d, B:22:0x0052, B:24:0x005f, B:25:0x0061, B:39:0x00fd), top: B:41:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x005f A[Catch: all -> 0x00ad, TryCatch #0 {, blocks: (B:4:0x0004, B:8:0x000a, B:10:0x0011, B:12:0x001b, B:15:0x002a, B:17:0x002e, B:19:0x0032, B:31:0x00b4, B:33:0x00c4, B:35:0x00d0, B:36:0x00db, B:38:0x00eb, B:20:0x003d, B:22:0x0052, B:24:0x005f, B:25:0x0061, B:39:0x00fd), top: B:41:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00fd A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0004, B:8:0x000a, B:10:0x0011, B:12:0x001b, B:15:0x002a, B:17:0x002e, B:19:0x0032, B:31:0x00b4, B:33:0x00c4, B:35:0x00d0, B:36:0x00db, B:38:0x00eb, B:20:0x003d, B:22:0x0052, B:24:0x005f, B:25:0x0061, B:39:0x00fd), top: B:41:0x0004 }] */
    public synchronized void g() {
        byte[] bArrH;
        String str;
        if (this.n) {
            lt.b();
            if (this.q && jf.a().c()) {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                final boolean z = !jf.a().e();
                if (this.u == null) {
                    jq.a().a(this);
                    kg.a(3, f4275a, "Requesting proton config");
                    bArrH = h();
                    if (bArrH != null) {
                        kn knVar = new kn();
                        if (TextUtils.isEmpty(this.o)) {
                            str = f4276b;
                        } else {
                            str = this.o;
                        }
                        knVar.a(str);
                        knVar.d(5000);
                        knVar.a(kp.a.kPost);
                        knVar.a("Content-Type", "application/x-flurry;version=2");
                        knVar.a("Accept", "application/x-flurry;version=2");
                        knVar.a("FM-Checksum", Integer.toString(kk.c(bArrH)));
                        knVar.a((lb) new kx());
                        knVar.b(new kx());
                        knVar.a(bArrH);
                        knVar.a((kn.a) new kn.a<byte[], byte[]>() { // from class: com.flurry.sdk.ig.2
                            /* JADX WARN: Code duplicated, block: B:39:0x0146  */
                            @Override // com.flurry.sdk.kn.a
                            public void a(kn<byte[], byte[]> knVar2, final byte[] bArr) {
                                long j;
                                ht htVar;
                                ht htVar2 = null;
                                int iH = knVar2.h();
                                kg.a(3, ig.f4275a, "Proton config request: HTTP status code is:" + iH);
                                if (iH == 400 || iH == 406 || iH == 412 || iH == 415) {
                                    ig.this.r = 10000L;
                                    return;
                                }
                                if (knVar2.f() && bArr != null) {
                                    js.a().b(new ly() { // from class: com.flurry.sdk.ig.2.1
                                        @Override // com.flurry.sdk.ly
                                        public void a() {
                                            ig.this.a(jCurrentTimeMillis, z, bArr);
                                        }
                                    });
                                    try {
                                        htVar = (ht) ig.this.h.d(bArr);
                                    } catch (Exception e2) {
                                        kg.a(5, ig.f4275a, "Failed to decode proton config response: " + e2);
                                        htVar = null;
                                    }
                                    if (!ig.this.a(htVar)) {
                                        htVar = null;
                                    }
                                    if (htVar != null) {
                                        ig.this.r = 10000L;
                                        ig.this.s = jCurrentTimeMillis;
                                        ig.this.t = z;
                                        ig.this.u = htVar;
                                        ig.this.i();
                                        if (!ig.this.v) {
                                            ig.this.v = true;
                                            ig.this.b("flurry.session_start", (Map<String, String>) null);
                                        }
                                        ig.this.f();
                                    }
                                    htVar2 = htVar;
                                }
                                if (htVar2 == null) {
                                    long j2 = ig.this.r << 1;
                                    if (iH == 429) {
                                        List<String> listB = knVar2.b("Retry-After");
                                        if (listB.isEmpty()) {
                                            j = j2;
                                        } else {
                                            String str2 = listB.get(0);
                                            kg.a(3, ig.f4275a, "Server returned retry time: " + str2);
                                            try {
                                                j = Long.parseLong(str2) * 1000;
                                            } catch (NumberFormatException e3) {
                                                kg.a(3, ig.f4275a, "Server returned nonsensical retry time");
                                                j = j2;
                                            }
                                        }
                                    } else {
                                        j = j2;
                                    }
                                    ig.this.r = j;
                                    kg.a(3, ig.f4275a, "Proton config request failed, backing off: " + ig.this.r + "ms");
                                    js.a().b(ig.this.f4277c, ig.this.r);
                                }
                            }
                        });
                        jq.a().a(this, knVar);
                    }
                } else {
                    if (this.t != z) {
                        kg.a(3, f4275a, "Limit ad tracking value has changed, purging");
                        this.u = null;
                    } else if (System.currentTimeMillis() < this.s + (this.u.f4243b * 1000)) {
                        kg.a(3, f4275a, "Cached Proton config valid, no need to refresh");
                        if (!this.v) {
                            this.v = true;
                            b("flurry.session_start", (Map<String, String>) null);
                        }
                    } else if (System.currentTimeMillis() >= this.s + (this.u.f4244c * 1000)) {
                        kg.a(3, f4275a, "Cached Proton config expired, purging");
                        this.u = null;
                        this.l.a();
                    }
                    jq.a().a(this);
                    kg.a(3, f4275a, "Requesting proton config");
                    bArrH = h();
                    if (bArrH != null) {
                        kn knVar2 = new kn();
                        if (TextUtils.isEmpty(this.o)) {
                            str = f4276b;
                        } else {
                            str = this.o;
                        }
                        knVar2.a(str);
                        knVar2.d(5000);
                        knVar2.a(kp.a.kPost);
                        knVar2.a("Content-Type", "application/x-flurry;version=2");
                        knVar2.a("Accept", "application/x-flurry;version=2");
                        knVar2.a("FM-Checksum", Integer.toString(kk.c(bArrH)));
                        knVar2.a((lb) new kx());
                        knVar2.b(new kx());
                        knVar2.a(bArrH);
                        knVar2.a((kn.a) new kn.a<byte[], byte[]>() { // from class: com.flurry.sdk.ig.2
                            /* JADX WARN: Code duplicated, block: B:39:0x0146  */
                            @Override // com.flurry.sdk.kn.a
                            public void a(kn<byte[], byte[]> knVar3, final byte[] bArr) {
                                long j;
                                ht htVar;
                                ht htVar2 = null;
                                int iH = knVar3.h();
                                kg.a(3, ig.f4275a, "Proton config request: HTTP status code is:" + iH);
                                if (iH == 400 || iH == 406 || iH == 412 || iH == 415) {
                                    ig.this.r = 10000L;
                                    return;
                                }
                                if (knVar3.f() && bArr != null) {
                                    js.a().b(new ly() { // from class: com.flurry.sdk.ig.2.1
                                        @Override // com.flurry.sdk.ly
                                        public void a() {
                                            ig.this.a(jCurrentTimeMillis, z, bArr);
                                        }
                                    });
                                    try {
                                        htVar = (ht) ig.this.h.d(bArr);
                                    } catch (Exception e2) {
                                        kg.a(5, ig.f4275a, "Failed to decode proton config response: " + e2);
                                        htVar = null;
                                    }
                                    if (!ig.this.a(htVar)) {
                                        htVar = null;
                                    }
                                    if (htVar != null) {
                                        ig.this.r = 10000L;
                                        ig.this.s = jCurrentTimeMillis;
                                        ig.this.t = z;
                                        ig.this.u = htVar;
                                        ig.this.i();
                                        if (!ig.this.v) {
                                            ig.this.v = true;
                                            ig.this.b("flurry.session_start", (Map<String, String>) null);
                                        }
                                        ig.this.f();
                                    }
                                    htVar2 = htVar;
                                }
                                if (htVar2 == null) {
                                    long j2 = ig.this.r << 1;
                                    if (iH == 429) {
                                        List<String> listB = knVar3.b("Retry-After");
                                        if (listB.isEmpty()) {
                                            j = j2;
                                        } else {
                                            String str2 = listB.get(0);
                                            kg.a(3, ig.f4275a, "Server returned retry time: " + str2);
                                            try {
                                                j = Long.parseLong(str2) * 1000;
                                            } catch (NumberFormatException e3) {
                                                kg.a(3, ig.f4275a, "Server returned nonsensical retry time");
                                                j = j2;
                                            }
                                        }
                                    } else {
                                        j = j2;
                                    }
                                    ig.this.r = j;
                                    kg.a(3, ig.f4275a, "Proton config request failed, backing off: " + ig.this.r + "ms");
                                    js.a().b(ig.this.f4277c, ig.this.r);
                                }
                            }
                        });
                        jq.a().a(this, knVar2);
                    }
                }
            }
        }
    }

    private byte[] h() {
        try {
            hs hsVar = new hs();
            hsVar.f4236a = js.a().d();
            hsVar.f4237b = lq.c(js.a().c());
            hsVar.f4238c = lq.d(js.a().c());
            hsVar.f4239d = jt.a();
            hsVar.f4240e = 3;
            hsVar.f4241f = jo.a().c();
            hsVar.g = !jf.a().e();
            hsVar.h = new hv();
            hsVar.h.f4250a = new hp();
            hsVar.h.f4250a.f4219a = Build.MODEL;
            hsVar.h.f4250a.f4220b = Build.BRAND;
            hsVar.h.f4250a.f4221c = Build.ID;
            hsVar.h.f4250a.f4222d = Build.DEVICE;
            hsVar.h.f4250a.f4223e = Build.PRODUCT;
            hsVar.h.f4250a.f4224f = Build.VERSION.RELEASE;
            hsVar.i = new ArrayList();
            for (Map.Entry<jn, byte[]> entry : jf.a().h().entrySet()) {
                hu huVar = new hu();
                huVar.f4248a = entry.getKey().f4497d;
                if (entry.getKey().f4498e) {
                    huVar.f4249b = new String(entry.getValue());
                } else {
                    huVar.f4249b = lt.b(entry.getValue());
                }
                hsVar.i.add(huVar);
            }
            Location locationE = jj.a().e();
            if (locationE != null) {
                hsVar.j = new hz();
                hsVar.j.f4258a = new hy();
                hsVar.j.f4258a.f4255a = lt.a(locationE.getLatitude(), 3);
                hsVar.j.f4258a.f4256b = lt.a(locationE.getLongitude(), 3);
                hsVar.j.f4258a.f4257c = (float) lt.a(locationE.getAccuracy(), 3);
            }
            String str = (String) lk.a().a("UserId");
            if (!str.equals("")) {
                hsVar.k = new ic();
                hsVar.k.f4266a = str;
            }
            return this.g.a(hsVar);
        } catch (Exception e2) {
            kg.a(5, f4275a, "Proton config request failed with exception: " + e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        List<hq> list;
        List<hw> list2;
        if (this.u == null) {
            return;
        }
        kg.a(5, f4275a, "Processing config response");
        im.a(this.u.f4246e.f4233c);
        im.b(this.u.f4246e.f4234d * 1000);
        io.a().a(this.u.f4246e.f4235e);
        if (this.n) {
            lk.a().a("analyticsEnabled", (Object) Boolean.valueOf(this.u.f4247f.f4268b));
        }
        this.l.a();
        hr hrVar = this.u.f4246e;
        if (hrVar == null || (list = hrVar.f4231a) == null) {
            return;
        }
        for (hq hqVar : list) {
            if (hqVar != null && (list2 = hqVar.f4227c) != null) {
                for (hw hwVar : list2) {
                    if (hwVar != null && !TextUtils.isEmpty(hwVar.f4251a)) {
                        hwVar.f4252b = hqVar;
                        this.l.a(hwVar.f4251a, hwVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        ht htVarD;
        ie ieVarA = this.i.a();
        if (ieVarA != null) {
            try {
                htVarD = this.h.d(ieVarA.c());
            } catch (Exception e2) {
                kg.a(5, f4275a, "Failed to decode saved proton config response: " + e2);
                this.i.b();
                htVarD = null;
            }
            if (!a(htVarD)) {
                htVarD = null;
            }
            if (htVarD != null) {
                kg.a(4, f4275a, "Loaded saved proton config response");
                this.r = 10000L;
                this.s = ieVarA.a();
                this.t = ieVarA.b();
                this.u = htVarD;
                i();
            }
        }
        this.q = true;
        js.a().b(new ly() { // from class: com.flurry.sdk.ig.3
            @Override // com.flurry.sdk.ly
            public void a() {
                ig.this.g();
            }
        });
    }

    private synchronized void k() {
        if (this.p) {
            kg.a(4, f4275a, "Sending " + this.m.size() + " queued reports.");
            for (in inVar : this.m) {
                kg.a(3, f4275a, "Firing Pulse callbacks for event: " + inVar.c());
                im.a().a(inVar);
            }
            n();
        } else {
            kg.e(f4275a, "Analytics disabled, not sending pulse reports.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        kg.a(4, f4275a, "Loading queued report data.");
        List<in> listA = this.j.a();
        if (listA != null) {
            this.m.addAll(listA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        kg.a(4, f4275a, "Saving queued report data.");
        this.j.a(this.m);
    }

    private synchronized void n() {
        this.m.clear();
        this.j.b();
    }

    private String o() {
        return ".yflurryprotonconfig." + Long.toString(lt.i(js.a().d()), 16);
    }

    private String p() {
        return ".yflurryprotonreport." + Long.toString(lt.i(js.a().d()), 16);
    }

    public void a() {
        js.a().c(this.f4277c);
        kc.a().b("com.flurry.android.sdk.NetworkStateEvent", this.f4280f);
        kc.a().b("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", this.f4279e);
        kc.a().b("com.flurry.android.sdk.IdProviderFinishedEvent", this.f4278d);
        im.b();
        lk.a().b("ProtonEnabled", (ll.a) this);
    }

    public synchronized void a(long j) {
        if (this.n) {
            lt.b();
            b(j);
            b("flurry.session_end", (Map<String, String>) null);
            js.a().b(new ly() { // from class: com.flurry.sdk.ig.11
                @Override // com.flurry.sdk.ly
                public void a() {
                    ig.this.m();
                }
            });
        }
    }

    @Override // com.flurry.sdk.ll.a
    public void a(String str, Object obj) {
        switch (str) {
            case "ProtonEnabled":
                this.n = ((Boolean) obj).booleanValue();
                kg.a(4, f4275a, "onSettingUpdate, protonEnabled = " + this.n);
                break;
            case "ProtonConfigUrl":
                this.o = (String) obj;
                kg.a(4, f4275a, "onSettingUpdate, protonConfigUrl = " + this.o);
                break;
            case "analyticsEnabled":
                this.p = ((Boolean) obj).booleanValue();
                kg.a(4, f4275a, "onSettingUpdate, AnalyticsEnabled = " + this.p);
                break;
            default:
                kg.a(6, f4275a, "onSettingUpdate internal error!");
                break;
        }
    }

    public synchronized void a(String str, Map<String, String> map) {
        if (this.n) {
            lt.b();
            b(str, map);
        }
    }

    public synchronized void b() {
        if (this.n) {
            lt.b();
            ii.f4302a = je.a().d();
            this.v = false;
            g();
        }
    }

    public synchronized void c() {
        if (this.n) {
            lt.b();
            b(je.a().d());
            k();
        }
    }

    public synchronized void d() {
        if (this.n) {
            lt.b();
            k();
        }
    }
}
