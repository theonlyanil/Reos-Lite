package com.flurry.sdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class im {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f4331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f4332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicInteger f4333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static jz<List<in>> f4334d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static im f4335f;
    private static Map<Integer, in> g;
    private final AtomicInteger h;
    private long i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4336e = im.class.getSimpleName();
    private kb<jk> j = new kb<jk>() { // from class: com.flurry.sdk.im.1
        @Override // com.flurry.sdk.kb
        public void a(jk jkVar) {
            kg.a(4, im.this.f4336e, "onNetworkStateChanged : isNetworkEnable = " + jkVar.f4479a);
            if (jkVar.f4479a) {
                js.a().b(new Runnable() { // from class: com.flurry.sdk.im.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        io.a().c();
                    }
                });
            }
        }
    };

    private im() {
        g = new HashMap();
        this.h = new AtomicInteger(0);
        f4333c = new AtomicInteger(0);
        if (f4332b == 0) {
            f4332b = 600000;
        }
        if (f4331a == 0) {
            f4331a = 15;
        }
        n();
        if (f4334d == null) {
            q();
        }
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", this.j);
    }

    public static synchronized im a() {
        if (f4335f == null) {
            f4335f = new im();
        }
        return f4335f;
    }

    public static void a(int i) {
        f4331a = i;
    }

    public static void b() {
        if (f4335f != null) {
            kc.a().b("com.flurry.android.sdk.NetworkStateEvent", f4335f.j);
            g.clear();
            g = null;
            f4335f = null;
        }
    }

    public static void b(int i) {
        f4332b = i;
    }

    private void c(ik ikVar) {
        ikVar.f4320d = true;
        ikVar.a();
        f4333c.incrementAndGet();
        ikVar.g();
        kg.a(3, this.f4336e, ikVar.d() + " report to " + ikVar.e() + " finalized.");
        d();
        g();
    }

    private void g() {
        if (j() || k()) {
            kg.a(3, this.f4336e, "Threshold reached. Sending callback logging reports");
            l();
        }
    }

    private void h() {
        if (j()) {
            kg.a(3, this.f4336e, "Max Callback Attempts threshold reached. Sending callback logging reports");
            l();
        }
    }

    private void i() {
        if (k()) {
            kg.a(3, this.f4336e, "Time threshold reached. Sending callback logging reports");
            l();
        }
    }

    private boolean j() {
        return f4333c.intValue() >= f4331a;
    }

    private boolean k() {
        return System.currentTimeMillis() > this.i;
    }

    private void l() {
        for (in inVar : c()) {
            Iterator<ij> it = inVar.d().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Iterator<ik> it2 = it.next().f4309a.iterator();
                while (it2.hasNext()) {
                    ik next = it2.next();
                    if (next.j) {
                        it2.remove();
                    } else if (!next.f4322f.equals(il.PENDING_COMPLETION)) {
                        next.j = true;
                        z = true;
                    }
                }
            }
            if (z) {
                io.a().a(inVar);
            }
        }
        io.a().c();
        this.i = System.currentTimeMillis() + ((long) f4332b);
        o();
        m();
        f4333c = new AtomicInteger(0);
        d();
    }

    private void m() {
        List<in> listC = c();
        for (int i = 0; i < listC.size(); i++) {
            in inVar = listC.get(i);
            if (inVar.f()) {
                c(inVar.a());
            } else {
                List<ij> listD = inVar.d();
                for (int i2 = 0; i2 < listD.size(); i2++) {
                    ij ijVar = listD.get(i2);
                    if (ijVar.n()) {
                        inVar.e().remove(Long.valueOf(ijVar.e()));
                    } else {
                        Iterator<ik> it = ijVar.f4309a.iterator();
                        while (it.hasNext()) {
                            if (it.next().j) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
    }

    private void n() {
        this.i = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong("timeToSendNextPulseReport", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        SharedPreferences.Editor editorEdit = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editorEdit.putLong("timeToSendNextPulseReport", this.i);
        editorEdit.commit();
    }

    private synchronized int p() {
        return this.h.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
        f4334d = new jz<>(js.a().c().getFileStreamPath(".yflurryanongoingpulsecallbackreporter"), ".yflurryanongoingpulsecallbackreporter", 2, new le<List<in>>() { // from class: com.flurry.sdk.im.6
            @Override // com.flurry.sdk.le
            public lb<List<in>> a(int i) {
                return new la(new in.a());
            }
        });
    }

    public synchronized void a(final ik ikVar) {
        kg.a(3, this.f4336e, ikVar.d() + " report sent successfully to " + ikVar.e());
        ikVar.f4322f = il.COMPLETE;
        ikVar.g = "";
        c(ikVar);
        if (kg.c() <= 3 && kg.d()) {
            js.a().a(new Runnable() { // from class: com.flurry.sdk.im.4
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(js.a().c(), "PulseCallbackReportInfo HTTP Response Code: " + ikVar.f4321e + " for url: " + ikVar.f(), 1).show();
                }
            });
        }
    }

    public synchronized void a(in inVar) {
        try {
            if (inVar == null) {
                kg.a(3, this.f4336e, "Must add valid PulseCallbackAsyncReportInfo");
            } else {
                kg.a(3, this.f4336e, "Adding and sending " + inVar.c() + " report to PulseCallbackManager.");
                if (inVar.d().size() != 0) {
                    if (this.i == 0) {
                        this.i = System.currentTimeMillis() + ((long) f4332b);
                        js.a().b(new Runnable() { // from class: com.flurry.sdk.im.2
                            @Override // java.lang.Runnable
                            public void run() {
                                im.this.o();
                            }
                        });
                    }
                    int iP = p();
                    inVar.a(iP);
                    g.put(Integer.valueOf(iP), inVar);
                    Iterator<ij> it = inVar.d().iterator();
                    while (it.hasNext()) {
                        hl.a().e().b(it.next());
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean a(ik ikVar, String str) {
        boolean z;
        ikVar.h++;
        ikVar.i = System.currentTimeMillis();
        if (ikVar.c() || TextUtils.isEmpty(str)) {
            kg.a(3, this.f4336e, "Maximum number of redirects attempted. Aborting: " + ikVar.d() + " report to " + ikVar.e());
            z = false;
            ikVar.f4322f = il.INVALID_RESPONSE;
            ikVar.g = "";
            c(ikVar);
        } else {
            kg.a(3, this.f4336e, "Report to " + ikVar.e() + " redirecting to url: " + str);
            z = true;
            ikVar.a(str);
            d();
        }
        return z;
    }

    public synchronized void b(ik ikVar) {
        kg.a(3, this.f4336e, "Maximum number of attempts reached. Aborting: " + ikVar.d());
        ikVar.f4322f = il.TIMEOUT;
        ikVar.i = System.currentTimeMillis();
        ikVar.g = "";
        c(ikVar);
    }

    public synchronized void b(in inVar) {
        try {
            if (inVar == null) {
                kg.a(3, this.f4336e, "Must add valid PulseCallbackAsyncReportInfo");
            } else {
                if (this.i == 0) {
                    this.i = System.currentTimeMillis() + ((long) f4332b);
                    js.a().b(new Runnable() { // from class: com.flurry.sdk.im.3
                        @Override // java.lang.Runnable
                        public void run() {
                            im.this.o();
                        }
                    });
                }
                int iP = p();
                inVar.a(iP);
                g.put(Integer.valueOf(iP), inVar);
                Iterator<ij> it = inVar.d().iterator();
                while (it.hasNext()) {
                    for (ik ikVar : it.next().f4309a) {
                        f4333c.incrementAndGet();
                        h();
                    }
                }
                i();
                kg.a(3, this.f4336e, "Restoring " + inVar.c() + " report to PulseCallbackManager. Number of stored completed callbacks: " + f4333c.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean b(ik ikVar, String str) {
        boolean z = false;
        synchronized (this) {
            ikVar.f4322f = il.INVALID_RESPONSE;
            ikVar.i = System.currentTimeMillis();
            if (str == null) {
                str = "";
            }
            ikVar.g = str;
            if (ikVar.b()) {
                kg.a(3, this.f4336e, "Maximum number of attempts reached. Aborting: " + ikVar.d() + " report to " + ikVar.e());
                c(ikVar);
            } else if (ma.h(ikVar.f())) {
                kg.a(3, this.f4336e, "Retrying callback to " + ikVar.d() + " in: " + (ikVar.l.g() / 1000) + " seconds.");
                z = true;
                ikVar.a();
                f4333c.incrementAndGet();
                d();
                g();
            } else {
                kg.a(3, this.f4336e, "Url: " + ikVar.f() + " is invalid.");
                c(ikVar);
            }
        }
        return z;
    }

    public List<in> c() {
        return new ArrayList(g.values());
    }

    public synchronized void c(int i) {
        kg.a(3, this.f4336e, "Removing report " + i + " from PulseCallbackManager");
        g.remove(Integer.valueOf(i));
    }

    public void d() {
        js.a().b(new Runnable() { // from class: com.flurry.sdk.im.5
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                List<in> listC = im.a().c();
                if (im.f4334d == null) {
                    im.q();
                }
                im.f4334d.a(listC);
            }
        });
    }

    public List<in> e() {
        if (f4334d == null) {
            q();
        }
        return f4334d.a();
    }
}
