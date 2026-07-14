package com.github.mikephil.charting.g;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.k;
import com.github.mikephil.charting.i.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class a extends b<BarLineChartBase<? extends com.github.mikephil.charting.data.c<? extends com.github.mikephil.charting.data.d<? extends Entry>>>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Matrix f5001f;
    private Matrix g;
    private PointF h;
    private PointF i;
    private float j;
    private float k;
    private float l;
    private k<?> m;
    private VelocityTracker n;
    private long o;
    private PointF p;
    private PointF q;

    public a(BarLineChartBase<? extends com.github.mikephil.charting.data.c<? extends com.github.mikephil.charting.data.d<? extends Entry>>> barLineChartBase, Matrix matrix) {
        super(barLineChartBase);
        this.f5001f = new Matrix();
        this.g = new Matrix();
        this.h = new PointF();
        this.i = new PointF();
        this.j = 1.0f;
        this.k = 1.0f;
        this.l = 1.0f;
        this.o = 0L;
        this.p = new PointF();
        this.q = new PointF();
        this.f5001f = matrix;
    }

    private static void a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    private void c(MotionEvent motionEvent) {
        this.g.set(this.f5001f);
        this.h.set(motionEvent.getX(), motionEvent.getY());
        this.m = ((BarLineChartBase) this.f5006e).b(motionEvent.getX(), motionEvent.getY());
    }

    private void d(MotionEvent motionEvent) {
        float x;
        float y;
        this.f5002a = b.a.DRAG;
        this.f5001f.set(this.g);
        c onChartGestureListener = ((BarLineChartBase) this.f5006e).getOnChartGestureListener();
        if (!((BarLineChartBase) this.f5006e).s() || this.m == null || !((BarLineChartBase) this.f5006e).b(this.m.s()).x()) {
            x = motionEvent.getX() - this.h.x;
            y = motionEvent.getY() - this.h.y;
        } else if (this.f5006e instanceof HorizontalBarChart) {
            x = -(motionEvent.getX() - this.h.x);
            y = motionEvent.getY() - this.h.y;
        } else {
            x = motionEvent.getX() - this.h.x;
            y = -(motionEvent.getY() - this.h.y);
        }
        this.f5001f.postTranslate(x, y);
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, x, y);
        }
    }

    private void e(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            c onChartGestureListener = ((BarLineChartBase) this.f5006e).getOnChartGestureListener();
            float fG = g(motionEvent);
            if (fG > 10.0f) {
                PointF pointFA = a(this.i.x, this.i.y);
                if (this.f5003b == 4) {
                    this.f5002a = b.a.PINCH_ZOOM;
                    float f2 = fG / this.l;
                    boolean zV = f2 < 1.0f ? ((BarLineChartBase) this.f5006e).getViewPortHandler().v() : ((BarLineChartBase) this.f5006e).getViewPortHandler().w();
                    float f3 = ((BarLineChartBase) this.f5006e).m() ? f2 : 1.0f;
                    if (!((BarLineChartBase) this.f5006e).n()) {
                        f2 = 1.0f;
                    }
                    if (((BarLineChartBase) this.f5006e).n() || zV) {
                        this.f5001f.set(this.g);
                        this.f5001f.postScale(f3, f2, pointFA.x, pointFA.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, f3, f2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f5003b == 2 && ((BarLineChartBase) this.f5006e).m()) {
                    this.f5002a = b.a.X_ZOOM;
                    float fH = h(motionEvent) / this.j;
                    if ((fH > 1.0f ? 1 : (fH == 1.0f ? 0 : -1)) < 0 ? ((BarLineChartBase) this.f5006e).getViewPortHandler().v() : ((BarLineChartBase) this.f5006e).getViewPortHandler().w()) {
                        this.f5001f.set(this.g);
                        this.f5001f.postScale(fH, 1.0f, pointFA.x, pointFA.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, fH, 1.0f);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f5003b == 3 && ((BarLineChartBase) this.f5006e).n()) {
                    this.f5002a = b.a.Y_ZOOM;
                    float fI = i(motionEvent) / this.k;
                    this.f5001f.set(this.g);
                    this.f5001f.postScale(1.0f, fI, pointFA.x, pointFA.y);
                    if (onChartGestureListener != null) {
                        onChartGestureListener.a(motionEvent, 1.0f, fI);
                    }
                }
            }
        }
    }

    private void f(MotionEvent motionEvent) {
        com.github.mikephil.charting.e.d dVarA = ((BarLineChartBase) this.f5006e).a(motionEvent.getX(), motionEvent.getY());
        if (dVarA == null || dVarA.a(this.f5004c)) {
            return;
        }
        this.f5004c = dVarA;
        ((BarLineChartBase) this.f5006e).a(dVarA);
    }

    private static float g(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private static float h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float i(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public PointF a(float f2, float f3) {
        g viewPortHandler = ((BarLineChartBase) this.f5006e).getViewPortHandler();
        return new PointF(f2 - viewPortHandler.a(), (((BarLineChartBase) this.f5006e).s() && this.m != null && ((BarLineChartBase) this.f5006e).c(this.m.s())) ? -(f3 - viewPortHandler.c()) : -((((BarLineChartBase) this.f5006e).getMeasuredHeight() - f3) - viewPortHandler.d()));
    }

    public void a() {
        this.q = new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    public void b() {
        if (this.q.x == BitmapDescriptorFactory.HUE_RED && this.q.y == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        PointF pointF = this.q;
        pointF.x = ((BarLineChartBase) this.f5006e).getDragDecelerationFrictionCoef() * pointF.x;
        PointF pointF2 = this.q;
        pointF2.y = ((BarLineChartBase) this.f5006e).getDragDecelerationFrictionCoef() * pointF2.y;
        float f2 = (jCurrentAnimationTimeMillis - this.o) / 1000.0f;
        float f3 = this.q.x * f2;
        float f4 = f2 * this.q.y;
        PointF pointF3 = this.p;
        pointF3.x = f3 + pointF3.x;
        PointF pointF4 = this.p;
        pointF4.y = f4 + pointF4.y;
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, this.p.x, this.p.y, 0);
        d(motionEventObtain);
        motionEventObtain.recycle();
        this.f5001f = ((BarLineChartBase) this.f5006e).getViewPortHandler().a(this.f5001f, this.f5006e, false);
        this.o = jCurrentAnimationTimeMillis;
        if (Math.abs(this.q.x) >= 0.01d || Math.abs(this.q.y) >= 0.01d) {
            com.github.mikephil.charting.i.f.a(this.f5006e);
            return;
        }
        ((BarLineChartBase) this.f5006e).i();
        ((BarLineChartBase) this.f5006e).postInvalidate();
        a();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f5002a = b.a.DOUBLE_TAP;
        c onChartGestureListener = ((BarLineChartBase) this.f5006e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent);
            return super.onDoubleTap(motionEvent);
        }
        if (((BarLineChartBase) this.f5006e).o()) {
            PointF pointFA = a(motionEvent.getX(), motionEvent.getY());
            ((BarLineChartBase) this.f5006e).a(((BarLineChartBase) this.f5006e).m() ? 1.4f : 1.0f, ((BarLineChartBase) this.f5006e).n() ? 1.4f : 1.0f, pointFA.x, pointFA.y);
            if (((BarLineChartBase) this.f5006e).w()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + pointFA.x + ", y: " + pointFA.y);
            }
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f5002a = b.a.FLING;
        c onChartGestureListener = ((BarLineChartBase) this.f5006e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, motionEvent2, f2, f3);
        }
        return super.onFling(motionEvent, motionEvent2, f2, f3);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f5002a = b.a.LONG_PRESS;
        c onChartGestureListener = ((BarLineChartBase) this.f5006e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f5002a = b.a.SINGLE_TAP;
        c onChartGestureListener = ((BarLineChartBase) this.f5006e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (!((BarLineChartBase) this.f5006e).t()) {
            return false;
        }
        a(((BarLineChartBase) this.f5006e).a(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
        this.n.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && this.n != null) {
            this.n.recycle();
            this.n = null;
        }
        if (this.f5003b == 0) {
            this.f5005d.onTouchEvent(motionEvent);
        }
        if (((BarLineChartBase) this.f5006e).l() || ((BarLineChartBase) this.f5006e).m() || ((BarLineChartBase) this.f5006e).n()) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    a(motionEvent);
                    a();
                    c(motionEvent);
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.n;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, com.github.mikephil.charting.i.f.b());
                    float yVelocity = velocityTracker.getYVelocity(pointerId);
                    float xVelocity = velocityTracker.getXVelocity(pointerId);
                    if ((Math.abs(xVelocity) > com.github.mikephil.charting.i.f.a() || Math.abs(yVelocity) > com.github.mikephil.charting.i.f.a()) && this.f5003b == 1 && ((BarLineChartBase) this.f5006e).v()) {
                        a();
                        this.o = AnimationUtils.currentAnimationTimeMillis();
                        this.p = new PointF(motionEvent.getX(), motionEvent.getY());
                        this.q = new PointF(xVelocity, yVelocity);
                        com.github.mikephil.charting.i.f.a(this.f5006e);
                    }
                    if (this.f5003b == 2 || this.f5003b == 3 || this.f5003b == 4 || this.f5003b == 5) {
                        ((BarLineChartBase) this.f5006e).i();
                        ((BarLineChartBase) this.f5006e).postInvalidate();
                    }
                    this.f5003b = 0;
                    ((BarLineChartBase) this.f5006e).y();
                    if (this.n != null) {
                        this.n.recycle();
                        this.n = null;
                    }
                    b(motionEvent);
                    break;
                case 2:
                    if (this.f5003b == 1) {
                        ((BarLineChartBase) this.f5006e).x();
                        d(motionEvent);
                    } else if (this.f5003b == 2 || this.f5003b == 3 || this.f5003b == 4) {
                        ((BarLineChartBase) this.f5006e).x();
                        if (((BarLineChartBase) this.f5006e).m() || ((BarLineChartBase) this.f5006e).n()) {
                            e(motionEvent);
                        }
                    } else if (this.f5003b == 0 && Math.abs(a(motionEvent.getX(), this.h.x, motionEvent.getY(), this.h.y)) > 5.0f) {
                        if (!((BarLineChartBase) this.f5006e).r()) {
                            if (((BarLineChartBase) this.f5006e).l()) {
                                this.f5002a = b.a.DRAG;
                                this.f5003b = 1;
                            }
                        } else if (!((BarLineChartBase) this.f5006e).p() && ((BarLineChartBase) this.f5006e).l()) {
                            this.f5003b = 1;
                        } else {
                            this.f5002a = b.a.DRAG;
                            if (((BarLineChartBase) this.f5006e).k()) {
                                f(motionEvent);
                            }
                        }
                    }
                    break;
                case 3:
                    this.f5003b = 0;
                    b(motionEvent);
                    break;
                case 5:
                    if (motionEvent.getPointerCount() >= 2) {
                        ((BarLineChartBase) this.f5006e).x();
                        c(motionEvent);
                        this.j = h(motionEvent);
                        this.k = i(motionEvent);
                        this.l = g(motionEvent);
                        if (this.l > 10.0f) {
                            if (((BarLineChartBase) this.f5006e).q()) {
                                this.f5003b = 4;
                            } else if (this.j > this.k) {
                                this.f5003b = 2;
                            } else {
                                this.f5003b = 3;
                            }
                        }
                        a(this.i, motionEvent);
                    }
                    break;
                case 6:
                    com.github.mikephil.charting.i.f.a(motionEvent, this.n);
                    this.f5003b = 5;
                    break;
            }
            this.f5001f = ((BarLineChartBase) this.f5006e).getViewPortHandler().a(this.f5001f, this.f5006e, true);
        }
        return true;
    }
}
