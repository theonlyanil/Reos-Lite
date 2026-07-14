package com.github.mikephil.charting.g;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.c.g;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends b<PieRadarChartBase<?>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PointF f5013f;
    private float g;
    private ArrayList<a> h;
    private long i;
    private float j;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f5015b;

        public a(long j, float f2) {
            this.f5014a = j;
            this.f5015b = f2;
        }
    }

    public f(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
        this.f5013f = new PointF();
        this.g = BitmapDescriptorFactory.HUE_RED;
        this.h = new ArrayList<>();
        this.i = 0L;
        this.j = BitmapDescriptorFactory.HUE_RED;
    }

    private void c() {
        this.h.clear();
    }

    private void c(float f2, float f3) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.h.add(new a(jCurrentAnimationTimeMillis, ((PieRadarChartBase) this.f5006e).a(f2, f3)));
        int size = this.h.size();
        while (true) {
            int i = size;
            if (i - 2 <= 0 || jCurrentAnimationTimeMillis - this.h.get(0).f5014a <= 1000) {
                return;
            }
            this.h.remove(0);
            size = i - 1;
        }
    }

    private float d() {
        if (this.h.isEmpty()) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        a aVar = this.h.get(0);
        a aVar2 = this.h.get(this.h.size() - 1);
        a aVar3 = aVar;
        for (int size = this.h.size() - 1; size >= 0; size--) {
            aVar3 = this.h.get(size);
            if (aVar3.f5015b != aVar2.f5015b) {
                break;
            }
        }
        float f2 = (aVar2.f5014a - aVar.f5014a) / 1000.0f;
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            f2 = 0.1f;
        }
        boolean z = aVar2.f5015b >= aVar3.f5015b;
        boolean z2 = Math.abs(aVar2.f5015b - aVar3.f5015b) > 270.0d ? !z : z;
        if (aVar2.f5015b - aVar.f5015b > 180.0d) {
            aVar.f5015b = (float) (((double) aVar.f5015b) + 360.0d);
        } else if (aVar.f5015b - aVar2.f5015b > 180.0d) {
            aVar2.f5015b = (float) (((double) aVar2.f5015b) + 360.0d);
        }
        float fAbs = Math.abs((aVar2.f5015b - aVar.f5015b) / f2);
        return !z2 ? -fAbs : fAbs;
    }

    public void a() {
        this.j = BitmapDescriptorFactory.HUE_RED;
    }

    public void a(float f2, float f3) {
        this.g = ((PieRadarChartBase) this.f5006e).a(f2, f3) - ((PieRadarChartBase) this.f5006e).getRawRotationAngle();
    }

    public void b() {
        if (this.j == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.j = ((PieRadarChartBase) this.f5006e).getDragDecelerationFrictionCoef() * this.j;
        ((PieRadarChartBase) this.f5006e).setRotationAngle(((PieRadarChartBase) this.f5006e).getRotationAngle() + (((jCurrentAnimationTimeMillis - this.i) / 1000.0f) * this.j));
        this.i = jCurrentAnimationTimeMillis;
        if (Math.abs(this.j) >= 0.001d) {
            com.github.mikephil.charting.i.f.a(this.f5006e);
        } else {
            a();
        }
    }

    public void b(float f2, float f3) {
        ((PieRadarChartBase) this.f5006e).setRotationAngle(((PieRadarChartBase) this.f5006e).a(f2, f3) - this.g);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f5002a = b.a.LONG_PRESS;
        c onChartGestureListener = ((PieRadarChartBase) this.f5006e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f5002a = b.a.SINGLE_TAP;
        c onChartGestureListener = ((PieRadarChartBase) this.f5006e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (!((PieRadarChartBase) this.f5006e).t()) {
            return false;
        }
        float fB = ((PieRadarChartBase) this.f5006e).b(motionEvent.getX(), motionEvent.getY());
        if (fB > ((PieRadarChartBase) this.f5006e).getRadius()) {
            if (this.f5004c == null) {
                ((PieRadarChartBase) this.f5006e).a((com.github.mikephil.charting.e.d[]) null);
            } else {
                ((PieRadarChartBase) this.f5006e).a((com.github.mikephil.charting.e.d) null);
            }
            this.f5004c = null;
        } else {
            float fA = ((PieRadarChartBase) this.f5006e).a(motionEvent.getX(), motionEvent.getY());
            if (this.f5006e instanceof PieChart) {
                fA /= ((PieRadarChartBase) this.f5006e).getAnimator().a();
            }
            int iA = ((PieRadarChartBase) this.f5006e).a(fA);
            if (iA < 0) {
                ((PieRadarChartBase) this.f5006e).a((com.github.mikephil.charting.e.d[]) null);
                this.f5004c = null;
            } else {
                int iA2 = this.f5006e instanceof RadarChart ? com.github.mikephil.charting.i.f.a(((PieRadarChartBase) this.f5006e).a(iA), fB / ((RadarChart) this.f5006e).getFactor(), (g.a) null) : 0;
                if (iA2 < 0) {
                    ((PieRadarChartBase) this.f5006e).a((com.github.mikephil.charting.e.d[]) null);
                    this.f5004c = null;
                } else {
                    a(new com.github.mikephil.charting.e.d(iA, iA2), motionEvent);
                }
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f5005d.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.f5006e).j()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    a(motionEvent);
                    a();
                    c();
                    if (((PieRadarChartBase) this.f5006e).v()) {
                        c(x, y);
                    }
                    a(x, y);
                    this.f5013f.x = x;
                    this.f5013f.y = y;
                    break;
                case 1:
                    if (((PieRadarChartBase) this.f5006e).v()) {
                        a();
                        c(x, y);
                        this.j = d();
                        if (this.j != BitmapDescriptorFactory.HUE_RED) {
                            this.i = AnimationUtils.currentAnimationTimeMillis();
                            com.github.mikephil.charting.i.f.a(this.f5006e);
                        }
                    }
                    ((PieRadarChartBase) this.f5006e).y();
                    this.f5003b = 0;
                    b(motionEvent);
                    break;
                case 2:
                    if (((PieRadarChartBase) this.f5006e).v()) {
                        c(x, y);
                    }
                    if (this.f5003b == 0 && a(x, this.f5013f.x, y, this.f5013f.y) > com.github.mikephil.charting.i.f.a(8.0f)) {
                        this.f5002a = b.a.ROTATE;
                        this.f5003b = 6;
                        ((PieRadarChartBase) this.f5006e).x();
                    } else if (this.f5003b == 6) {
                        b(x, y);
                        ((PieRadarChartBase) this.f5006e).invalidate();
                    }
                    b(motionEvent);
                    break;
            }
        }
        return true;
    }
}
