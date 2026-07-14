package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class v extends u.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f501a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f503c;
    private Interpolator g;
    private u.e.a h;
    private u.e.b i;
    private float j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f504d = new int[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f505e = new float[2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f506f = 200;
    private final Runnable k = new Runnable() { // from class: android.support.design.widget.v.1
        @Override // java.lang.Runnable
        public void run() {
            v.this.h();
        }
    };

    v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f503c) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f502b) / this.f506f;
            if (this.g != null) {
                fUptimeMillis = this.g.getInterpolation(fUptimeMillis);
            }
            this.j = fUptimeMillis;
            if (this.i != null) {
                this.i.a();
            }
            if (SystemClock.uptimeMillis() >= this.f502b + ((long) this.f506f)) {
                this.f503c = false;
                if (this.h != null) {
                    this.h.b();
                }
            }
        }
        if (this.f503c) {
            f501a.postDelayed(this.k, 10L);
        }
    }

    @Override // android.support.design.widget.u.e
    public void a() {
        if (this.f503c) {
            return;
        }
        if (this.g == null) {
            this.g = new AccelerateDecelerateInterpolator();
        }
        this.f502b = SystemClock.uptimeMillis();
        this.f503c = true;
        if (this.h != null) {
            this.h.a();
        }
        f501a.postDelayed(this.k, 10L);
    }

    @Override // android.support.design.widget.u.e
    public void a(float f2, float f3) {
        this.f505e[0] = f2;
        this.f505e[1] = f3;
    }

    @Override // android.support.design.widget.u.e
    public void a(int i) {
        this.f506f = i;
    }

    @Override // android.support.design.widget.u.e
    public void a(int i, int i2) {
        this.f504d[0] = i;
        this.f504d[1] = i2;
    }

    @Override // android.support.design.widget.u.e
    public void a(u.e.a aVar) {
        this.h = aVar;
    }

    @Override // android.support.design.widget.u.e
    public void a(u.e.b bVar) {
        this.i = bVar;
    }

    @Override // android.support.design.widget.u.e
    public void a(Interpolator interpolator) {
        this.g = interpolator;
    }

    @Override // android.support.design.widget.u.e
    public boolean b() {
        return this.f503c;
    }

    @Override // android.support.design.widget.u.e
    public int c() {
        return a.a(this.f504d[0], this.f504d[1], f());
    }

    @Override // android.support.design.widget.u.e
    public float d() {
        return a.a(this.f505e[0], this.f505e[1], f());
    }

    @Override // android.support.design.widget.u.e
    public void e() {
        this.f503c = false;
        f501a.removeCallbacks(this.k);
        if (this.h != null) {
            this.h.c();
        }
    }

    @Override // android.support.design.widget.u.e
    public float f() {
        return this.j;
    }

    @Override // android.support.design.widget.u.e
    public long g() {
        return this.f506f;
    }
}
