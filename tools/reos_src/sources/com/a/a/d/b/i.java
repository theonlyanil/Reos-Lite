package com.a.a.d.b;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class i implements com.a.a.d.b.c.b, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.i f2153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.b.a<?, ?, ?> f2155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f2156d = b.CACHE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f2157e;

    interface a extends com.a.a.h.g {
        void b(i iVar);
    }

    private enum b {
        CACHE,
        SOURCE
    }

    public i(a aVar, com.a.a.d.b.a<?, ?, ?> aVar2, com.a.a.i iVar) {
        this.f2154b = aVar;
        this.f2155c = aVar2;
        this.f2153a = iVar;
    }

    private void a(k kVar) {
        this.f2154b.a((k<?>) kVar);
    }

    private void a(Exception exc) {
        if (!c()) {
            this.f2154b.a(exc);
        } else {
            this.f2156d = b.SOURCE;
            this.f2154b.b(this);
        }
    }

    private boolean c() {
        return this.f2156d == b.CACHE;
    }

    private k<?> d() throws Exception {
        return c() ? e() : f();
    }

    private k<?> e() throws Exception {
        k<?> kVarA;
        try {
            kVarA = this.f2155c.a();
        } catch (Exception e2) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e2);
            }
            kVarA = null;
        }
        return kVarA == null ? this.f2155c.b() : kVarA;
    }

    private k<?> f() throws Exception {
        return this.f2155c.c();
    }

    public void a() {
        this.f2157e = true;
        this.f2155c.d();
    }

    @Override // com.a.a.d.b.c.b
    public int b() {
        return this.f2153a.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        k<?> kVarD;
        Exception exc = null;
        if (this.f2157e) {
            return;
        }
        try {
            kVarD = d();
        } catch (Exception e2) {
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Exception decoding", e2);
            }
            exc = e2;
            kVarD = null;
        }
        if (this.f2157e) {
            if (kVarD != null) {
                kVarD.d();
            }
        } else if (kVarD == null) {
            a(exc);
        } else {
            a(kVarD);
        }
    }
}
