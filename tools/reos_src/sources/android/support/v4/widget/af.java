package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.ah;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class af {
    private static final Interpolator v = new Interpolator() { // from class: android.support.v4.widget.af.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1009b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f1011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f1012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f1013f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private w q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1010c = -1;
    private final Runnable w = new Runnable() { // from class: android.support.v4.widget.af.2
        @Override // java.lang.Runnable
        public void run() {
            af.this.c(0);
        }
    };

    public static abstract class a {
        public int a(View view) {
            return 0;
        }

        public int a(View view, int i, int i2) {
            return 0;
        }

        public void a(int i) {
        }

        public void a(int i, int i2) {
        }

        public void a(View view, float f2, float f3) {
        }

        public void a(View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean a(View view, int i);

        public int b(View view) {
            return 0;
        }

        public int b(View view, int i, int i2) {
            return 0;
        }

        public void b(int i, int i2) {
        }

        public void b(View view, int i) {
        }

        public boolean b(int i) {
            return false;
        }

        public int c(int i) {
            return i;
        }
    }

    private af(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1009b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = w.a(context, v);
    }

    private float a(float f2, float f3, float f4) {
        float fAbs = Math.abs(f2);
        if (fAbs < f3) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (fAbs > f4) {
            return f2 <= BitmapDescriptorFactory.HUE_RED ? -f4 : f4;
        }
        return f2;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float fB = (b(Math.min(1.0f, Math.abs(i) / width)) * i4) + i4;
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fB / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        int iB = b(i3, (int) this.n, (int) this.m);
        int iB2 = b(i4, (int) this.n, (int) this.m);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iB);
        int iAbs4 = Math.abs(iB2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        return (int) (((iB2 != 0 ? iAbs4 / i5 : iAbs2 / i6) * a(i2, iB2, this.r.a(view))) + ((iB != 0 ? iAbs3 / i5 : iAbs / i6) * a(i, iB, this.r.b(view))));
    }

    public static af a(ViewGroup viewGroup, float f2, a aVar) {
        af afVarA = a(viewGroup, aVar);
        afVarA.f1009b = (int) (afVarA.f1009b * (1.0f / f2));
        return afVarA;
    }

    public static af a(ViewGroup viewGroup, a aVar) {
        return new af(viewGroup.getContext(), viewGroup, aVar);
    }

    private void a(float f2, float f3) {
        this.t = true;
        this.r.a(this.s, f2, f3);
        this.t = false;
        if (this.f1008a == 1) {
            c(0);
        }
    }

    private void a(float f2, float f3, int i) {
        f(i);
        float[] fArr = this.f1011d;
        this.f1013f[i] = f2;
        fArr[i] = f2;
        float[] fArr2 = this.f1012e;
        this.g[i] = f3;
        fArr2[i] = f3;
        this.h[i] = e((int) f2, (int) f3);
        this.k |= 1 << i;
    }

    private boolean a(float f2, float f3, int i, int i2) {
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        if (fAbs <= this.f1009b && fAbs2 <= this.f1009b) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.r.b(i2)) {
            return (this.i[i] & i2) == 0 && fAbs > ((float) this.f1009b);
        }
        int[] iArr = this.j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.h();
            c(0);
            return false;
        }
        this.q.a(left, top, i5, i6, a(this.s, i5, i6, i3, i4));
        c(2);
        return true;
    }

    private boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.b(view) > 0;
        boolean z2 = this.r.a(view) > 0;
        if (z && z2) {
            return (f2 * f2) + (f3 * f3) > ((float) (this.f1009b * this.f1009b));
        }
        if (z) {
            return Math.abs(f2) > ((float) this.f1009b);
        }
        return z2 && Math.abs(f3) > ((float) this.f1009b);
    }

    private float b(float f2) {
        return (float) Math.sin((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d));
    }

    private int b(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        if (iAbs > i3) {
            return i <= 0 ? -i3 : i3;
        }
        return i;
    }

    private void b(float f2, float f3, int i) {
        int i2 = a(f2, f3, i, 1) ? 1 : 0;
        if (a(f3, f2, i, 4)) {
            i2 |= 4;
        }
        if (a(f2, f3, i, 2)) {
            i2 |= 2;
        }
        if (a(f3, f2, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.b(i2, i);
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        int iB;
        int iA;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            iB = this.r.b(this.s, i, i3);
            ah.f(this.s, iB - left);
        } else {
            iB = i;
        }
        if (i4 != 0) {
            iA = this.r.a(this.s, i2, i4);
            ah.e(this.s, iA - top);
        } else {
            iA = i2;
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.r.a(this.s, iB, iA, iB - left, iA - top);
    }

    private void c(MotionEvent motionEvent) {
        int iC = android.support.v4.view.t.c(motionEvent);
        for (int i = 0; i < iC; i++) {
            int iB = android.support.v4.view.t.b(motionEvent, i);
            float fC = android.support.v4.view.t.c(motionEvent, i);
            float fD = android.support.v4.view.t.d(motionEvent, i);
            this.f1013f[iB] = fC;
            this.g[iB] = fD;
        }
    }

    private int e(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }

    private void e(int i) {
        if (this.f1011d == null) {
            return;
        }
        this.f1011d[i] = 0.0f;
        this.f1012e[i] = 0.0f;
        this.f1013f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k &= (1 << i) ^ (-1);
    }

    private void f(int i) {
        if (this.f1011d == null || this.f1011d.length <= i) {
            float[] fArr = new float[i + 1];
            float[] fArr2 = new float[i + 1];
            float[] fArr3 = new float[i + 1];
            float[] fArr4 = new float[i + 1];
            int[] iArr = new int[i + 1];
            int[] iArr2 = new int[i + 1];
            int[] iArr3 = new int[i + 1];
            if (this.f1011d != null) {
                System.arraycopy(this.f1011d, 0, fArr, 0, this.f1011d.length);
                System.arraycopy(this.f1012e, 0, fArr2, 0, this.f1012e.length);
                System.arraycopy(this.f1013f, 0, fArr3, 0, this.f1013f.length);
                System.arraycopy(this.g, 0, fArr4, 0, this.g.length);
                System.arraycopy(this.h, 0, iArr, 0, this.h.length);
                System.arraycopy(this.i, 0, iArr2, 0, this.i.length);
                System.arraycopy(this.j, 0, iArr3, 0, this.j.length);
            }
            this.f1011d = fArr;
            this.f1012e = fArr2;
            this.f1013f = fArr3;
            this.g = fArr4;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private void g() {
        if (this.f1011d == null) {
            return;
        }
        Arrays.fill(this.f1011d, BitmapDescriptorFactory.HUE_RED);
        Arrays.fill(this.f1012e, BitmapDescriptorFactory.HUE_RED);
        Arrays.fill(this.f1013f, BitmapDescriptorFactory.HUE_RED);
        Arrays.fill(this.g, BitmapDescriptorFactory.HUE_RED);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private boolean g(int i) {
        if (b(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void h() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(android.support.v4.view.af.a(this.l, this.f1010c), this.n, this.m), a(android.support.v4.view.af.b(this.l, this.f1010c), this.n, this.m));
    }

    public int a() {
        return this.f1008a;
    }

    public void a(float f2) {
        this.n = f2;
    }

    public void a(int i) {
        this.p = i;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.f1010c = i;
        this.r.b(view, i);
        c(1);
    }

    public boolean a(int i, int i2) {
        if (this.t) {
            return a(i, i2, (int) android.support.v4.view.af.a(this.l, this.f1010c), (int) android.support.v4.view.af.b(this.l, this.f1010c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:56:0x010e  */
    public boolean a(MotionEvent motionEvent) {
        View viewD;
        int iA = android.support.v4.view.t.a(motionEvent);
        int iB = android.support.v4.view.t.b(motionEvent);
        if (iA == 0) {
            e();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (iA) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iB2 = android.support.v4.view.t.b(motionEvent, 0);
                a(x, y, iB2);
                View viewD2 = d((int) x, (int) y);
                if (viewD2 == this.s && this.f1008a == 2) {
                    b(viewD2, iB2);
                }
                int i = this.h[iB2];
                if ((this.p & i) != 0) {
                    this.r.a(i & this.p, iB2);
                }
                break;
            case 1:
            case 3:
                e();
                break;
            case 2:
                if (this.f1011d != null && this.f1012e != null) {
                    int iC = android.support.v4.view.t.c(motionEvent);
                    for (int i2 = 0; i2 < iC; i2++) {
                        int iB3 = android.support.v4.view.t.b(motionEvent, i2);
                        if (g(iB3)) {
                            float fC = android.support.v4.view.t.c(motionEvent, i2);
                            float fD = android.support.v4.view.t.d(motionEvent, i2);
                            float f2 = fC - this.f1011d[iB3];
                            float f3 = fD - this.f1012e[iB3];
                            View viewD3 = d((int) fC, (int) fD);
                            boolean z = viewD3 != null && a(viewD3, f2, f3);
                            if (z) {
                                int left = viewD3.getLeft();
                                int iB4 = this.r.b(viewD3, ((int) f2) + left, (int) f2);
                                int top = viewD3.getTop();
                                int iA2 = this.r.a(viewD3, ((int) f3) + top, (int) f3);
                                int iB5 = this.r.b(viewD3);
                                int iA3 = this.r.a(viewD3);
                                if ((iB5 != 0 && (iB5 <= 0 || iB4 != left)) || (iA3 != 0 && (iA3 <= 0 || iA2 != top))) {
                                    b(f2, f3, iB3);
                                    if (this.f1008a != 1 || (z && b(viewD3, iB3))) {
                                    }
                                }
                                c(motionEvent);
                            } else {
                                b(f2, f3, iB3);
                                if (this.f1008a != 1) {
                                }
                                c(motionEvent);
                            }
                            break;
                        }
                    }
                    c(motionEvent);
                }
                break;
            case 5:
                int iB6 = android.support.v4.view.t.b(motionEvent, iB);
                float fC2 = android.support.v4.view.t.c(motionEvent, iB);
                float fD2 = android.support.v4.view.t.d(motionEvent, iB);
                a(fC2, fD2, iB6);
                if (this.f1008a == 0) {
                    int i3 = this.h[iB6];
                    if ((this.p & i3) != 0) {
                        this.r.a(i3 & this.p, iB6);
                    }
                } else if (this.f1008a == 2 && (viewD = d((int) fC2, (int) fD2)) == this.s) {
                    b(viewD, iB6);
                }
                break;
            case 6:
                e(android.support.v4.view.t.b(motionEvent, iB));
                break;
        }
        return this.f1008a == 1;
    }

    public boolean a(View view, int i, int i2) {
        this.s = view;
        this.f1010c = -1;
        boolean zA = a(i, i2, 0, 0);
        if (!zA && this.f1008a == 0 && this.s != null) {
            this.s = null;
        }
        return zA;
    }

    public boolean a(boolean z) {
        boolean z2;
        if (this.f1008a == 2) {
            boolean zG = this.q.g();
            int iB = this.q.b();
            int iC = this.q.c();
            int left = iB - this.s.getLeft();
            int top = iC - this.s.getTop();
            if (left != 0) {
                ah.f(this.s, left);
            }
            if (top != 0) {
                ah.e(this.s, top);
            }
            if (left != 0 || top != 0) {
                this.r.a(this.s, iB, iC, left, top);
            }
            if (zG && iB == this.q.d() && iC == this.q.e()) {
                this.q.h();
                z2 = false;
            } else {
                z2 = zG;
            }
            if (!z2) {
                if (z) {
                    this.u.post(this.w);
                } else {
                    c(0);
                }
            }
        }
        return this.f1008a == 2;
    }

    public int b() {
        return this.o;
    }

    public void b(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int iA = android.support.v4.view.t.a(motionEvent);
        int iB = android.support.v4.view.t.b(motionEvent);
        if (iA == 0) {
            e();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (iA) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iB2 = android.support.v4.view.t.b(motionEvent, 0);
                View viewD = d((int) x, (int) y);
                a(x, y, iB2);
                b(viewD, iB2);
                int i3 = this.h[iB2];
                if ((this.p & i3) != 0) {
                    this.r.a(i3 & this.p, iB2);
                }
                break;
            case 1:
                if (this.f1008a == 1) {
                    h();
                }
                e();
                break;
            case 2:
                if (this.f1008a != 1) {
                    int iC = android.support.v4.view.t.c(motionEvent);
                    while (i2 < iC) {
                        int iB3 = android.support.v4.view.t.b(motionEvent, i2);
                        if (g(iB3)) {
                            float fC = android.support.v4.view.t.c(motionEvent, i2);
                            float fD = android.support.v4.view.t.d(motionEvent, i2);
                            float f2 = fC - this.f1011d[iB3];
                            float f3 = fD - this.f1012e[iB3];
                            b(f2, f3, iB3);
                            if (this.f1008a != 1) {
                                View viewD2 = d((int) fC, (int) fD);
                                if (!a(viewD2, f2, f3) || !b(viewD2, iB3)) {
                                }
                            }
                            c(motionEvent);
                            break;
                        }
                        i2++;
                    }
                    c(motionEvent);
                } else if (g(this.f1010c)) {
                    int iA2 = android.support.v4.view.t.a(motionEvent, this.f1010c);
                    float fC2 = android.support.v4.view.t.c(motionEvent, iA2);
                    float fD2 = android.support.v4.view.t.d(motionEvent, iA2);
                    int i4 = (int) (fC2 - this.f1013f[this.f1010c]);
                    int i5 = (int) (fD2 - this.g[this.f1010c]);
                    b(this.s.getLeft() + i4, this.s.getTop() + i5, i4, i5);
                    c(motionEvent);
                }
                break;
            case 3:
                if (this.f1008a == 1) {
                    a(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                }
                e();
                break;
            case 5:
                int iB4 = android.support.v4.view.t.b(motionEvent, iB);
                float fC3 = android.support.v4.view.t.c(motionEvent, iB);
                float fD3 = android.support.v4.view.t.d(motionEvent, iB);
                a(fC3, fD3, iB4);
                if (this.f1008a == 0) {
                    b(d((int) fC3, (int) fD3), iB4);
                    int i6 = this.h[iB4];
                    if ((this.p & i6) != 0) {
                        this.r.a(i6 & this.p, iB4);
                    }
                } else if (c((int) fC3, (int) fD3)) {
                    b(this.s, iB4);
                }
                break;
            case 6:
                int iB5 = android.support.v4.view.t.b(motionEvent, iB);
                if (this.f1008a == 1 && iB5 == this.f1010c) {
                    int iC2 = android.support.v4.view.t.c(motionEvent);
                    while (true) {
                        if (i2 >= iC2) {
                            i = -1;
                        } else {
                            int iB6 = android.support.v4.view.t.b(motionEvent, i2);
                            if (iB6 != this.f1010c) {
                                if (d((int) android.support.v4.view.t.c(motionEvent, i2), (int) android.support.v4.view.t.d(motionEvent, i2)) == this.s && b(this.s, iB6)) {
                                    i = this.f1010c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        h();
                    }
                }
                e(iB5);
                break;
        }
    }

    public boolean b(int i) {
        return (this.k & (1 << i)) != 0;
    }

    public boolean b(int i, int i2) {
        if (!b(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f2 = this.f1013f[i2] - this.f1011d[i2];
        float f3 = this.g[i2] - this.f1012e[i2];
        if (z && z2) {
            return (f2 * f2) + (f3 * f3) > ((float) (this.f1009b * this.f1009b));
        }
        if (z) {
            return Math.abs(f2) > ((float) this.f1009b);
        }
        return z2 && Math.abs(f3) > ((float) this.f1009b);
    }

    boolean b(View view, int i) {
        if (view == this.s && this.f1010c == i) {
            return true;
        }
        if (view == null || !this.r.a(view, i)) {
            return false;
        }
        this.f1010c = i;
        a(view, i);
        return true;
    }

    public boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View c() {
        return this.s;
    }

    void c(int i) {
        this.u.removeCallbacks(this.w);
        if (this.f1008a != i) {
            this.f1008a = i;
            this.r.a(i);
            if (this.f1008a == 0) {
                this.s = null;
            }
        }
    }

    public boolean c(int i, int i2) {
        return b(this.s, i, i2);
    }

    public int d() {
        return this.f1009b;
    }

    public View d(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public boolean d(int i) {
        int length = this.f1011d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public void e() {
        this.f1010c = -1;
        g();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    public void f() {
        e();
        if (this.f1008a == 2) {
            int iB = this.q.b();
            int iC = this.q.c();
            this.q.h();
            int iB2 = this.q.b();
            int iC2 = this.q.c();
            this.r.a(this.s, iB2, iC2, iB2 - iB, iC2 - iC);
        }
        c(0);
    }
}
