package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.af;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
abstract class l<V extends View> extends z<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.support.v4.widget.w f458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f462f;
    private VelocityTracker g;

    private class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CoordinatorLayout f464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final V f465c;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.f464b = coordinatorLayout;
            this.f465c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f465c == null || l.this.f458b == null) {
                return;
            }
            if (!l.this.f458b.g()) {
                l.this.a(this.f464b, this.f465c);
            } else {
                l.this.a_(this.f464b, this.f465c, l.this.f458b.c());
                ah.a(this.f465c, this);
            }
        }
    }

    public l() {
        this.f460d = -1;
        this.f462f = -1;
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f460d = -1;
        this.f462f = -1;
    }

    private void c() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    int a() {
        return b();
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int iA;
        int iB = b();
        if (i2 == 0 || iB < i2 || iB > i3 || iB == (iA = n.a(i, i2, i3))) {
            return 0;
        }
        a(iA);
        return iB - iA;
    }

    int a(V v) {
        return v.getHeight();
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f2) {
        if (this.f457a != null) {
            v.removeCallbacks(this.f457a);
            this.f457a = null;
        }
        if (this.f458b == null) {
            this.f458b = android.support.v4.widget.w.a(v.getContext());
        }
        this.f458b.a(0, b(), 0, Math.round(f2), 0, 0, i, i2);
        if (!this.f458b.g()) {
            a(coordinatorLayout, v);
            return false;
        }
        this.f457a = new a(coordinatorLayout, v);
        ah.a(v, this.f457a);
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int iA;
        if (this.f462f < 0) {
            this.f462f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f459c) {
            return true;
        }
        switch (android.support.v4.view.t.a(motionEvent)) {
            case 0:
                this.f459c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (c(v) && coordinatorLayout.a(v, x, y)) {
                    this.f461e = y;
                    this.f460d = android.support.v4.view.t.b(motionEvent, 0);
                    c();
                }
                break;
            case 1:
            case 3:
                this.f459c = false;
                this.f460d = -1;
                if (this.g != null) {
                    this.g.recycle();
                    this.g = null;
                }
                break;
            case 2:
                int i = this.f460d;
                if (i != -1 && (iA = android.support.v4.view.t.a(motionEvent, i)) != -1) {
                    int iD = (int) android.support.v4.view.t.d(motionEvent, iA);
                    if (Math.abs(iD - this.f461e) > this.f462f) {
                        this.f459c = true;
                        this.f461e = iD;
                    }
                }
                break;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return this.f459c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, (View) v, a() - i, i2, i3);
    }

    int b(V v) {
        return -v.getHeight();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f462f < 0) {
            this.f462f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (android.support.v4.view.t.a(motionEvent)) {
            case 0:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (!coordinatorLayout.a(v, x, y) || !c(v)) {
                    return false;
                }
                this.f461e = y;
                this.f460d = android.support.v4.view.t.b(motionEvent, 0);
                c();
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                }
                return true;
            case 1:
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                    this.g.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -a(v), 0, af.b(this.g, this.f460d));
                }
                break;
            case 2:
                int iA = android.support.v4.view.t.a(motionEvent, this.f460d);
                if (iA == -1) {
                    return false;
                }
                int iD = (int) android.support.v4.view.t.d(motionEvent, iA);
                int i = this.f461e - iD;
                if (!this.f459c && Math.abs(i) > this.f462f) {
                    this.f459c = true;
                    i = i > 0 ? i - this.f462f : i + this.f462f;
                }
                if (this.f459c) {
                    this.f461e = iD;
                    b(coordinatorLayout, v, i, b(v), 0);
                }
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                }
                return true;
            case 3:
                break;
            default:
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                }
                return true;
        }
        this.f459c = false;
        this.f460d = -1;
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return true;
    }

    boolean c(V v) {
        return false;
    }
}
