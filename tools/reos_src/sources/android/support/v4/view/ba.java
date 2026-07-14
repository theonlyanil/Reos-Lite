package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final g f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<View> f907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f908c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f909d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f910e = -1;

    static class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakHashMap<View, Runnable> f911a = null;

        /* JADX INFO: renamed from: android.support.v4.view.ba$a$a, reason: collision with other inner class name */
        class RunnableC0023a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            WeakReference<View> f912a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ba f913b;

            private RunnableC0023a(ba baVar, View view) {
                this.f912a = new WeakReference<>(view);
                this.f913b = baVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = this.f912a.get();
                if (view != null) {
                    a.this.d(this.f913b, view);
                }
            }
        }

        a() {
        }

        private void a(View view) {
            Runnable runnable;
            if (this.f911a == null || (runnable = this.f911a.get(view)) == null) {
                return;
            }
            view.removeCallbacks(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ba baVar, View view) {
            Object tag = view.getTag(2113929216);
            be beVar = tag instanceof be ? (be) tag : null;
            Runnable runnable = baVar.f908c;
            Runnable runnable2 = baVar.f909d;
            baVar.f908c = null;
            baVar.f909d = null;
            if (runnable != null) {
                runnable.run();
            }
            if (beVar != null) {
                beVar.a(view);
                beVar.b(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.f911a != null) {
                this.f911a.remove(view);
            }
        }

        private void e(ba baVar, View view) {
            Runnable runnableC0023a = this.f911a != null ? this.f911a.get(view) : null;
            if (runnableC0023a == null) {
                runnableC0023a = new RunnableC0023a(baVar, view);
                if (this.f911a == null) {
                    this.f911a = new WeakHashMap<>();
                }
                this.f911a.put(view, runnableC0023a);
            }
            view.removeCallbacks(runnableC0023a);
            view.post(runnableC0023a);
        }

        @Override // android.support.v4.view.ba.g
        public long a(ba baVar, View view) {
            return 0L;
        }

        @Override // android.support.v4.view.ba.g
        public void a(ba baVar, View view, float f2) {
            e(baVar, view);
        }

        @Override // android.support.v4.view.ba.g
        public void a(ba baVar, View view, long j) {
        }

        @Override // android.support.v4.view.ba.g
        public void a(ba baVar, View view, be beVar) {
            view.setTag(2113929216, beVar);
        }

        @Override // android.support.v4.view.ba.g
        public void a(ba baVar, View view, bg bgVar) {
        }

        @Override // android.support.v4.view.ba.g
        public void a(ba baVar, View view, Interpolator interpolator) {
        }

        @Override // android.support.v4.view.ba.g
        public void b(ba baVar, View view) {
            e(baVar, view);
        }

        @Override // android.support.v4.view.ba.g
        public void b(ba baVar, View view, float f2) {
            e(baVar, view);
        }

        @Override // android.support.v4.view.ba.g
        public void b(ba baVar, View view, long j) {
        }

        @Override // android.support.v4.view.ba.g
        public void c(ba baVar, View view) {
            a(view);
            d(baVar, view);
        }

        @Override // android.support.v4.view.ba.g
        public void c(ba baVar, View view, float f2) {
            e(baVar, view);
        }
    }

    static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WeakHashMap<View, Integer> f915b = null;

        static class a implements be {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            ba f916a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f917b;

            a(ba baVar) {
                this.f916a = baVar;
            }

            @Override // android.support.v4.view.be
            public void a(View view) {
                this.f917b = false;
                if (this.f916a.f910e >= 0) {
                    ah.a(view, 2, (Paint) null);
                }
                if (this.f916a.f908c != null) {
                    Runnable runnable = this.f916a.f908c;
                    this.f916a.f908c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                be beVar = tag instanceof be ? (be) tag : null;
                if (beVar != null) {
                    beVar.a(view);
                }
            }

            @Override // android.support.v4.view.be
            public void b(View view) {
                if (this.f916a.f910e >= 0) {
                    ah.a(view, this.f916a.f910e, (Paint) null);
                    this.f916a.f910e = -1;
                }
                if (Build.VERSION.SDK_INT >= 16 || !this.f917b) {
                    if (this.f916a.f909d != null) {
                        Runnable runnable = this.f916a.f909d;
                        this.f916a.f909d = null;
                        runnable.run();
                    }
                    Object tag = view.getTag(2113929216);
                    be beVar = tag instanceof be ? (be) tag : null;
                    if (beVar != null) {
                        beVar.b(view);
                    }
                    this.f917b = true;
                }
            }

            @Override // android.support.v4.view.be
            public void c(View view) {
                Object tag = view.getTag(2113929216);
                be beVar = tag instanceof be ? (be) tag : null;
                if (beVar != null) {
                    beVar.c(view);
                }
            }
        }

        b() {
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public long a(ba baVar, View view) {
            return bb.a(view);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void a(ba baVar, View view, float f2) {
            bb.a(view, f2);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void a(ba baVar, View view, long j) {
            bb.a(view, j);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void a(ba baVar, View view, be beVar) {
            view.setTag(2113929216, beVar);
            bb.a(view, new a(baVar));
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void a(ba baVar, View view, Interpolator interpolator) {
            bb.a(view, interpolator);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void b(ba baVar, View view) {
            bb.b(view);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void b(ba baVar, View view, float f2) {
            bb.b(view, f2);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void b(ba baVar, View view, long j) {
            bb.b(view, j);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void c(ba baVar, View view) {
            bb.c(view);
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void c(ba baVar, View view, float f2) {
            bb.c(view, f2);
        }
    }

    static class c extends d {
        c() {
        }
    }

    static class d extends b {
        d() {
        }

        @Override // android.support.v4.view.ba.b, android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void a(ba baVar, View view, be beVar) {
            bc.a(view, beVar);
        }
    }

    static class e extends c {
        e() {
        }

        @Override // android.support.v4.view.ba.a, android.support.v4.view.ba.g
        public void a(ba baVar, View view, bg bgVar) {
            bd.a(view, bgVar);
        }
    }

    static class f extends e {
        f() {
        }
    }

    interface g {
        long a(ba baVar, View view);

        void a(ba baVar, View view, float f2);

        void a(ba baVar, View view, long j);

        void a(ba baVar, View view, be beVar);

        void a(ba baVar, View view, bg bgVar);

        void a(ba baVar, View view, Interpolator interpolator);

        void b(ba baVar, View view);

        void b(ba baVar, View view, float f2);

        void b(ba baVar, View view, long j);

        void c(ba baVar, View view);

        void c(ba baVar, View view, float f2);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f906a = new f();
            return;
        }
        if (i >= 19) {
            f906a = new e();
            return;
        }
        if (i >= 18) {
            f906a = new c();
            return;
        }
        if (i >= 16) {
            f906a = new d();
        } else if (i >= 14) {
            f906a = new b();
        } else {
            f906a = new a();
        }
    }

    ba(View view) {
        this.f907b = new WeakReference<>(view);
    }

    public long a() {
        View view = this.f907b.get();
        if (view != null) {
            return f906a.a(this, view);
        }
        return 0L;
    }

    public ba a(float f2) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.a(this, view, f2);
        }
        return this;
    }

    public ba a(long j) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.a(this, view, j);
        }
        return this;
    }

    public ba a(be beVar) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.a(this, view, beVar);
        }
        return this;
    }

    public ba a(bg bgVar) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.a(this, view, bgVar);
        }
        return this;
    }

    public ba a(Interpolator interpolator) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.a(this, view, interpolator);
        }
        return this;
    }

    public ba b(float f2) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.b(this, view, f2);
        }
        return this;
    }

    public ba b(long j) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.b(this, view, j);
        }
        return this;
    }

    public void b() {
        View view = this.f907b.get();
        if (view != null) {
            f906a.b(this, view);
        }
    }

    public ba c(float f2) {
        View view = this.f907b.get();
        if (view != null) {
            f906a.c(this, view, f2);
        }
        return this;
    }

    public void c() {
        View view = this.f907b.get();
        if (view != null) {
            f906a.c(this, view);
        }
    }
}
