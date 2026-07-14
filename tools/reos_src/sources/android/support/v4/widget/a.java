package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ah;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f994d;
    private int g;
    private int h;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0024a f991a = new C0024a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Interpolator f992b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f995e = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f996f = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] i = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
    private float[] j = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
    private float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: android.support.v4.widget.a$a, reason: collision with other inner class name */
    private static class C0024a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f1000d;
        private float j;
        private int k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f1001e = Long.MIN_VALUE;
        private long i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f1002f = 0;
        private int g = 0;
        private int h = 0;

        private float a(float f2) {
            return ((-4.0f) * f2 * f2) + (4.0f * f2);
        }

        private float a(long j) {
            if (j < this.f1001e) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            if (this.i < 0 || j < this.i) {
                return a.b((j - this.f1001e) / this.f997a, BitmapDescriptorFactory.HUE_RED, 1.0f) * 0.5f;
            }
            return (a.b((j - this.i) / this.k, BitmapDescriptorFactory.HUE_RED, 1.0f) * this.j) + (1.0f - this.j);
        }

        public void a() {
            this.f1001e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f1002f = this.f1001e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void a(float f2, float f3) {
            this.f999c = f2;
            this.f1000d = f3;
        }

        public void a(int i) {
            this.f997a = i;
        }

        public void b() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.b((int) (jCurrentAnimationTimeMillis - this.f1001e), 0, this.f998b);
            this.j = a(jCurrentAnimationTimeMillis);
            this.i = jCurrentAnimationTimeMillis;
        }

        public void b(int i) {
            this.f998b = i;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void d() {
            if (this.f1002f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fA = a(a(jCurrentAnimationTimeMillis));
            long j = jCurrentAnimationTimeMillis - this.f1002f;
            this.f1002f = jCurrentAnimationTimeMillis;
            this.g = (int) (j * fA * this.f999c);
            this.h = (int) (j * fA * this.f1000d);
        }

        public int e() {
            return (int) (this.f999c / Math.abs(this.f999c));
        }

        public int f() {
            return (int) (this.f1000d / Math.abs(this.f1000d));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o) {
                if (a.this.m) {
                    a.this.m = false;
                    a.this.f991a.a();
                }
                C0024a c0024a = a.this.f991a;
                if (c0024a.c() || !a.this.a()) {
                    a.this.o = false;
                    return;
                }
                if (a.this.n) {
                    a.this.n = false;
                    a.this.d();
                }
                c0024a.d();
                a.this.a(c0024a.g(), c0024a.h());
                ah.a(a.this.f993c, this);
            }
        }
    }

    public a(View view) {
        this.f993c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        a(i, i);
        b(i2, i2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    private float a(float f2, float f3, float f4, float f5) {
        float interpolation;
        float fB = b(f2 * f3, BitmapDescriptorFactory.HUE_RED, f4);
        float f6 = f(f3 - f5, fB) - f(f5, fB);
        if (f6 < BitmapDescriptorFactory.HUE_RED) {
            interpolation = -this.f992b.getInterpolation(-f6);
        } else {
            if (f6 <= BitmapDescriptorFactory.HUE_RED) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            interpolation = this.f992b.getInterpolation(f6);
        }
        return b(interpolation, -1.0f, 1.0f);
    }

    private float a(int i, float f2, float f3, float f4) {
        float fA = a(this.f995e[i], f3, this.f996f[i], f2);
        if (fA == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f5 = this.i[i];
        float f6 = this.j[i];
        float f7 = this.k[i];
        float f8 = f5 * f4;
        return fA > BitmapDescriptorFactory.HUE_RED ? b(fA * f8, f6, f7) : -b((-fA) * f8, f6, f7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        C0024a c0024a = this.f991a;
        int iF = c0024a.f();
        int iE = c0024a.e();
        return (iF != 0 && f(iF)) || (iE != 0 && e(iE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float b(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        return f2 < f3 ? f3 : f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    private void b() {
        if (this.f994d == null) {
            this.f994d = new b();
        }
        this.o = true;
        this.m = true;
        if (this.l || this.h <= 0) {
            this.f994d.run();
        } else {
            ah.a(this.f993c, this.f994d, this.h);
        }
        this.l = true;
    }

    private void c() {
        if (this.m) {
            this.o = false;
        } else {
            this.f991a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f993c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private float f(float f2, float f3) {
        if (f3 == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        switch (this.g) {
            case 0:
            case 1:
                if (f2 >= f3) {
                    return BitmapDescriptorFactory.HUE_RED;
                }
                if (f2 >= BitmapDescriptorFactory.HUE_RED) {
                    return 1.0f - (f2 / f3);
                }
                if (this.o && this.g == 1) {
                    return 1.0f;
                }
                return BitmapDescriptorFactory.HUE_RED;
            case 2:
                return f2 < BitmapDescriptorFactory.HUE_RED ? f2 / (-f3) : BitmapDescriptorFactory.HUE_RED;
            default:
                return BitmapDescriptorFactory.HUE_RED;
        }
    }

    public a a(float f2, float f3) {
        this.k[0] = f2 / 1000.0f;
        this.k[1] = f3 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.g = i;
        return this;
    }

    public a a(boolean z) {
        if (this.p && !z) {
            c();
        }
        this.p = z;
        return this;
    }

    public abstract void a(int i, int i2);

    public a b(float f2, float f3) {
        this.j[0] = f2 / 1000.0f;
        this.j[1] = f3 / 1000.0f;
        return this;
    }

    public a b(int i) {
        this.h = i;
        return this;
    }

    public a c(float f2, float f3) {
        this.i[0] = f2 / 1000.0f;
        this.i[1] = f3 / 1000.0f;
        return this;
    }

    public a c(int i) {
        this.f991a.a(i);
        return this;
    }

    public a d(float f2, float f3) {
        this.f995e[0] = f2;
        this.f995e[1] = f3;
        return this;
    }

    public a d(int i) {
        this.f991a.b(i);
        return this;
    }

    public a e(float f2, float f3) {
        this.f996f[0] = f2;
        this.f996f[1] = f3;
        return this;
    }

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.p) {
            return false;
        }
        switch (android.support.v4.view.t.a(motionEvent)) {
            case 0:
                this.n = true;
                this.l = false;
                this.f991a.a(a(0, motionEvent.getX(), view.getWidth(), this.f993c.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.f993c.getHeight()));
                if (!this.o && a()) {
                    b();
                }
                break;
            case 1:
            case 3:
                c();
                break;
            case 2:
                this.f991a.a(a(0, motionEvent.getX(), view.getWidth(), this.f993c.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.f993c.getHeight()));
                if (!this.o) {
                    b();
                }
                break;
        }
        return this.q && this.o;
    }
}
