package com.a.a.d.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
class d implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f2131a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f2132b = new Handler(Looper.getMainLooper(), new b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.a.a.h.g> f2133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f2134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f2135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.a.a.d.c f2136f;
    private final ExecutorService g;
    private final ExecutorService h;
    private final boolean i;
    private boolean j;
    private k<?> k;
    private boolean l;
    private Exception m;
    private boolean n;
    private Set<com.a.a.h.g> o;
    private i p;
    private h<?> q;
    private volatile Future<?> r;

    static class a {
        a() {
        }

        public <R> h<R> a(k<R> kVar, boolean z) {
            return new h<>(kVar, z);
        }
    }

    private static class b implements Handler.Callback {
        private b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (1 != message.what && 2 != message.what) {
                return false;
            }
            d dVar = (d) message.obj;
            if (1 == message.what) {
                dVar.b();
            } else {
                dVar.c();
            }
            return true;
        }
    }

    public d(com.a.a.d.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar) {
        this(cVar, executorService, executorService2, z, eVar, f2131a);
    }

    public d(com.a.a.d.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar, a aVar) {
        this.f2133c = new ArrayList();
        this.f2136f = cVar;
        this.g = executorService;
        this.h = executorService2;
        this.i = z;
        this.f2135e = eVar;
        this.f2134d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j) {
            this.k.d();
            return;
        }
        if (this.f2133c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        this.q = this.f2134d.a(this.k, this.i);
        this.l = true;
        this.q.e();
        this.f2135e.a(this.f2136f, this.q);
        for (com.a.a.h.g gVar : this.f2133c) {
            if (!d(gVar)) {
                this.q.e();
                gVar.a(this.q);
            }
        }
        this.q.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.j) {
            return;
        }
        if (this.f2133c.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        this.n = true;
        this.f2135e.a(this.f2136f, (h<?>) null);
        for (com.a.a.h.g gVar : this.f2133c) {
            if (!d(gVar)) {
                gVar.a(this.m);
            }
        }
    }

    private void c(com.a.a.h.g gVar) {
        if (this.o == null) {
            this.o = new HashSet();
        }
        this.o.add(gVar);
    }

    private boolean d(com.a.a.h.g gVar) {
        return this.o != null && this.o.contains(gVar);
    }

    void a() {
        if (this.n || this.l || this.j) {
            return;
        }
        this.p.a();
        Future<?> future = this.r;
        if (future != null) {
            future.cancel(true);
        }
        this.j = true;
        this.f2135e.a(this, this.f2136f);
    }

    public void a(i iVar) {
        this.p = iVar;
        this.r = this.g.submit(iVar);
    }

    @Override // com.a.a.h.g
    public void a(k<?> kVar) {
        this.k = kVar;
        f2132b.obtainMessage(1, this).sendToTarget();
    }

    public void a(com.a.a.h.g gVar) {
        com.a.a.j.h.a();
        if (this.l) {
            gVar.a(this.q);
        } else if (this.n) {
            gVar.a(this.m);
        } else {
            this.f2133c.add(gVar);
        }
    }

    @Override // com.a.a.h.g
    public void a(Exception exc) {
        this.m = exc;
        f2132b.obtainMessage(2, this).sendToTarget();
    }

    @Override // com.a.a.d.b.i.a
    public void b(i iVar) {
        this.r = this.h.submit(iVar);
    }

    public void b(com.a.a.h.g gVar) {
        com.a.a.j.h.a();
        if (this.l || this.n) {
            c(gVar);
            return;
        }
        this.f2133c.remove(gVar);
        if (this.f2133c.isEmpty()) {
            a();
        }
    }
}
