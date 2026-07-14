package android.support.v4.view.a;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f881b;

    static class a extends e {
        a() {
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void a(Object obj, int i) {
            n.a(obj, i);
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void a(Object obj, boolean z) {
            n.a(obj, z);
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void b(Object obj, int i) {
            n.b(obj, i);
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void c(Object obj, int i) {
            n.c(obj, i);
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void d(Object obj, int i) {
            n.d(obj, i);
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void e(Object obj, int i) {
            n.e(obj, i);
        }
    }

    static class b extends a {
        b() {
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void f(Object obj, int i) {
            o.a(obj, i);
        }

        @Override // android.support.v4.view.a.m.e, android.support.v4.view.a.m.c
        public void g(Object obj, int i) {
            o.b(obj, i);
        }
    }

    interface c {
        void a(Object obj, int i);

        void a(Object obj, boolean z);

        void b(Object obj, int i);

        void c(Object obj, int i);

        void d(Object obj, int i);

        void e(Object obj, int i);

        void f(Object obj, int i);

        void g(Object obj, int i);
    }

    static class d extends b {
        d() {
        }
    }

    static class e implements c {
        e() {
        }

        @Override // android.support.v4.view.a.m.c
        public void a(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.m.c
        public void a(Object obj, boolean z) {
        }

        @Override // android.support.v4.view.a.m.c
        public void b(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.m.c
        public void c(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.m.c
        public void d(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.m.c
        public void e(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.m.c
        public void f(Object obj, int i) {
        }

        @Override // android.support.v4.view.a.m.c
        public void g(Object obj, int i) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f880a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 15) {
            f880a = new b();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f880a = new a();
        } else {
            f880a = new e();
        }
    }

    public m(Object obj) {
        this.f881b = obj;
    }

    public void a(int i) {
        f880a.b(this.f881b, i);
    }

    public void a(boolean z) {
        f880a.a(this.f881b, z);
    }

    public void b(int i) {
        f880a.a(this.f881b, i);
    }

    public void c(int i) {
        f880a.e(this.f881b, i);
    }

    public void d(int i) {
        f880a.c(this.f881b, i);
    }

    public void e(int i) {
        f880a.d(this.f881b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            if (this.f881b == null) {
                return mVar.f881b == null;
            }
            return this.f881b.equals(mVar.f881b);
        }
        return false;
    }

    public void f(int i) {
        f880a.f(this.f881b, i);
    }

    public void g(int i) {
        f880a.g(this.f881b, i);
    }

    public int hashCode() {
        if (this.f881b == null) {
            return 0;
        }
        return this.f881b.hashCode();
    }
}
