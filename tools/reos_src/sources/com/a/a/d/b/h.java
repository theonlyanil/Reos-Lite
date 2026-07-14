package com.a.a.d.b;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
class h<Z> implements k<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k<Z> f2147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f2149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.a.a.d.c f2150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2152f;

    interface a {
        void b(com.a.a.d.c cVar, h<?> hVar);
    }

    h(k<Z> kVar, boolean z) {
        if (kVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.f2147a = kVar;
        this.f2148b = z;
    }

    void a(com.a.a.d.c cVar, a aVar) {
        this.f2150d = cVar;
        this.f2149c = aVar;
    }

    boolean a() {
        return this.f2148b;
    }

    @Override // com.a.a.d.b.k
    public Z b() {
        return this.f2147a.b();
    }

    @Override // com.a.a.d.b.k
    public int c() {
        return this.f2147a.c();
    }

    @Override // com.a.a.d.b.k
    public void d() {
        if (this.f2151e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f2152f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f2152f = true;
        this.f2147a.d();
    }

    void e() {
        if (this.f2152f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.f2151e++;
    }

    void f() {
        if (this.f2151e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.f2151e - 1;
        this.f2151e = i;
        if (i == 0) {
            this.f2149c.b(this.f2150d, this);
        }
    }
}
