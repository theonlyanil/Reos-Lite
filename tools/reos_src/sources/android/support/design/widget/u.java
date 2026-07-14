package android.support.design.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f496a;

    interface a {
        void a(u uVar);

        void b(u uVar);

        void c(u uVar);
    }

    static class b implements a {
        b() {
        }

        @Override // android.support.design.widget.u.a
        public void a(u uVar) {
        }

        @Override // android.support.design.widget.u.a
        public void b(u uVar) {
        }

        @Override // android.support.design.widget.u.a
        public void c(u uVar) {
        }
    }

    interface c {
        void a(u uVar);
    }

    interface d {
        u a();
    }

    static abstract class e {

        interface a {
            void a();

            void b();

            void c();
        }

        interface b {
            void a();
        }

        e() {
        }

        abstract void a();

        abstract void a(float f2, float f3);

        abstract void a(int i);

        abstract void a(int i, int i2);

        abstract void a(a aVar);

        abstract void a(b bVar);

        abstract void a(Interpolator interpolator);

        abstract boolean b();

        abstract int c();

        abstract float d();

        abstract void e();

        abstract float f();

        abstract long g();
    }

    u(e eVar) {
        this.f496a = eVar;
    }

    public void a() {
        this.f496a.a();
    }

    public void a(float f2, float f3) {
        this.f496a.a(f2, f3);
    }

    public void a(int i) {
        this.f496a.a(i);
    }

    public void a(int i, int i2) {
        this.f496a.a(i, i2);
    }

    public void a(final a aVar) {
        if (aVar != null) {
            this.f496a.a(new e.a() { // from class: android.support.design.widget.u.2
                @Override // android.support.design.widget.u.e.a
                public void a() {
                    aVar.b(u.this);
                }

                @Override // android.support.design.widget.u.e.a
                public void b() {
                    aVar.a(u.this);
                }

                @Override // android.support.design.widget.u.e.a
                public void c() {
                    aVar.c(u.this);
                }
            });
        } else {
            this.f496a.a((e.a) null);
        }
    }

    public void a(final c cVar) {
        if (cVar != null) {
            this.f496a.a(new e.b() { // from class: android.support.design.widget.u.1
                @Override // android.support.design.widget.u.e.b
                public void a() {
                    cVar.a(u.this);
                }
            });
        } else {
            this.f496a.a((e.b) null);
        }
    }

    public void a(Interpolator interpolator) {
        this.f496a.a(interpolator);
    }

    public boolean b() {
        return this.f496a.b();
    }

    public int c() {
        return this.f496a.c();
    }

    public float d() {
        return this.f496a.d();
    }

    public void e() {
        this.f496a.e();
    }

    public float f() {
        return this.f496a.f();
    }

    public long g() {
        return this.f496a.g();
    }
}
