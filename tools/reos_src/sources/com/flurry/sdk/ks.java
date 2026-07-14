package com.flurry.sdk;

import com.flurry.sdk.kr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ks<ReportInfo extends kr> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4614a = ks.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f4615b = 10000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final jz<List<ReportInfo>> f4617d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4619f;
    private int g;
    private long h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4616c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<ReportInfo> f4618e = new ArrayList();
    private final Runnable i = new ly() { // from class: com.flurry.sdk.ks.1
        @Override // com.flurry.sdk.ly
        public void a() {
            ks.this.b();
        }
    };
    private final kb<jk> j = new kb<jk>() { // from class: com.flurry.sdk.ks.2
        @Override // com.flurry.sdk.kb
        public void a(jk jkVar) {
            if (jkVar.f4479a) {
                ks.this.b();
            }
        }
    };

    public ks() {
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", this.j);
        this.f4617d = a();
        this.h = f4615b;
        this.g = -1;
        js.a().b(new ly() { // from class: com.flurry.sdk.ks.3
            @Override // com.flurry.sdk.ly
            public void a() {
                ks.this.b(ks.this.f4618e);
                ks.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (!this.f4619f) {
            if (this.g >= 0) {
                kg.a(3, f4614a, "Transmit is in progress");
            } else {
                h();
                if (this.f4618e.isEmpty()) {
                    this.h = f4615b;
                    this.g = -1;
                } else {
                    this.g = 0;
                    js.a().b(new ly() { // from class: com.flurry.sdk.ks.8
                        @Override // com.flurry.sdk.ly
                        public void a() {
                            ks.this.f();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:10:0x002f A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0019, B:10:0x002f, B:16:0x003e, B:14:0x0035), top: B:21:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x003e A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0019, B:10:0x002f, B:16:0x003e, B:14:0x0035), top: B:21:0x0001 }] */
    public synchronized void f() {
        ReportInfo reportinfo;
        lt.b();
        if (jl.a().c()) {
            do {
                if (this.g < this.f4618e.size()) {
                    List<ReportInfo> list = this.f4618e;
                    int i = this.g;
                    this.g = i + 1;
                    reportinfo = list.get(i);
                }
            } while (reportinfo.q());
            if (reportinfo == null) {
                g();
            } else {
                a(reportinfo);
            }
        } else {
            kg.a(3, f4614a, "Network is not available, aborting transmission");
        }
        reportinfo = null;
        if (reportinfo == null) {
            g();
        } else {
            a(reportinfo);
        }
    }

    private synchronized void g() {
        h();
        a(this.f4618e);
        if (this.f4619f) {
            kg.a(3, f4614a, "Reporter paused");
            this.h = f4615b;
        } else if (this.f4618e.isEmpty()) {
            kg.a(3, f4614a, "All reports sent successfully");
            this.h = f4615b;
        } else {
            this.h <<= 1;
            kg.a(3, f4614a, "One or more reports failed to send, backing off: " + this.h + "ms");
            js.a().b(this.i, this.h);
        }
        this.g = -1;
    }

    private synchronized void h() {
        Iterator<ReportInfo> it = this.f4618e.iterator();
        while (it.hasNext()) {
            ReportInfo next = it.next();
            if (next.q()) {
                kg.a(3, f4614a, "Url transmitted - " + next.s() + " Attempts: " + next.r());
                it.remove();
            } else if (next.r() > next.d()) {
                kg.a(3, f4614a, "Exceeded max no of attempts - " + next.s() + " Attempts: " + next.r());
                it.remove();
            } else if (System.currentTimeMillis() > next.p() && next.r() > 0) {
                kg.a(3, f4614a, "Expired: Time expired - " + next.s() + " Attempts: " + next.r());
                it.remove();
            }
        }
    }

    private void i() {
        kc.a().b("com.flurry.android.sdk.NetworkStateEvent", this.j);
    }

    protected abstract jz<List<ReportInfo>> a();

    public void a(long j) {
        f4615b = j;
        this.h = f4615b;
    }

    protected abstract void a(ReportInfo reportinfo);

    protected synchronized void a(List<ReportInfo> list) {
        lt.b();
        this.f4617d.a(new ArrayList(list));
    }

    public synchronized void b(ReportInfo reportinfo) {
        if (reportinfo != null) {
            this.f4618e.add(reportinfo);
            js.a().b(new ly() { // from class: com.flurry.sdk.ks.5
                @Override // com.flurry.sdk.ly
                public void a() {
                    ks.this.b();
                }
            });
        }
    }

    protected synchronized void b(List<ReportInfo> list) {
        lt.b();
        List<ReportInfo> listA = this.f4617d.a();
        if (listA != null) {
            list.addAll(listA);
        }
    }

    public void c() {
        js.a().c(this.i);
        i();
    }

    protected synchronized void c(ReportInfo reportinfo) {
        reportinfo.b(true);
        js.a().b(new ly() { // from class: com.flurry.sdk.ks.6
            @Override // com.flurry.sdk.ly
            public void a() {
                ks.this.f();
            }
        });
    }

    public void d() {
        this.f4619f = true;
    }

    protected synchronized void d(ReportInfo reportinfo) {
        reportinfo.a_();
        js.a().b(new ly() { // from class: com.flurry.sdk.ks.7
            @Override // com.flurry.sdk.ly
            public void a() {
                ks.this.f();
            }
        });
    }

    public void e() {
        this.f4619f = false;
        js.a().b(new ly() { // from class: com.flurry.sdk.ks.4
            @Override // com.flurry.sdk.ly
            public void a() {
                ks.this.b();
            }
        });
    }
}
