package com.a.a.h;

/* JADX INFO: loaded from: classes.dex */
public class h implements c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f2472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f2474c;

    public h() {
        this(null);
    }

    public h(d dVar) {
        this.f2474c = dVar;
    }

    private boolean j() {
        return this.f2474c == null || this.f2474c.a(this);
    }

    private boolean k() {
        return this.f2474c == null || this.f2474c.b(this);
    }

    private boolean l() {
        return this.f2474c != null && this.f2474c.c();
    }

    @Override // com.a.a.h.c
    public void a() {
        this.f2472a.a();
        this.f2473b.a();
    }

    public void a(c cVar, c cVar2) {
        this.f2472a = cVar;
        this.f2473b = cVar2;
    }

    @Override // com.a.a.h.d
    public boolean a(c cVar) {
        return j() && (cVar.equals(this.f2472a) || !this.f2472a.h());
    }

    @Override // com.a.a.h.c
    public void b() {
        if (!this.f2473b.f()) {
            this.f2473b.b();
        }
        if (this.f2472a.f()) {
            return;
        }
        this.f2472a.b();
    }

    @Override // com.a.a.h.d
    public boolean b(c cVar) {
        return k() && cVar.equals(this.f2472a) && !c();
    }

    @Override // com.a.a.h.d
    public void c(c cVar) {
        if (cVar.equals(this.f2473b)) {
            return;
        }
        if (this.f2474c != null) {
            this.f2474c.c(this);
        }
        if (this.f2473b.g()) {
            return;
        }
        this.f2473b.d();
    }

    @Override // com.a.a.h.d
    public boolean c() {
        return l() || h();
    }

    @Override // com.a.a.h.c
    public void d() {
        this.f2473b.d();
        this.f2472a.d();
    }

    @Override // com.a.a.h.c
    public void e() {
        this.f2472a.e();
        this.f2473b.e();
    }

    @Override // com.a.a.h.c
    public boolean f() {
        return this.f2472a.f();
    }

    @Override // com.a.a.h.c
    public boolean g() {
        return this.f2472a.g() || this.f2473b.g();
    }

    @Override // com.a.a.h.c
    public boolean h() {
        return this.f2472a.h() || this.f2473b.h();
    }

    @Override // com.a.a.h.c
    public boolean i() {
        return this.f2472a.i();
    }
}
