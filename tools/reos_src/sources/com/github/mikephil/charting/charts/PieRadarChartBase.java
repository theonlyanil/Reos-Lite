package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.i;
import com.github.mikephil.charting.data.k;
import com.github.mikephil.charting.g.f;
import com.github.mikephil.charting.i.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PieRadarChartBase<T extends i<? extends k<? extends Entry>>> extends Chart<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f4929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f4930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4931d;

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4928a = 270.0f;
        this.f4931d = 270.0f;
        this.f4929b = true;
        this.f4930c = BitmapDescriptorFactory.HUE_RED;
    }

    public float a(float f2, float f3) {
        PointF centerOffsets = getCenterOffsets();
        double d2 = f2 - centerOffsets.x;
        double d3 = f3 - centerOffsets.y;
        float degrees = (float) Math.toDegrees(Math.acos(d3 / Math.sqrt((d2 * d2) + (d3 * d3))));
        if (f2 > centerOffsets.x) {
            degrees = 360.0f - degrees;
        }
        float f4 = degrees + 90.0f;
        return f4 > 360.0f ? f4 - 360.0f : f4;
    }

    public abstract int a(float f2);

    protected PointF a(PointF pointF, float f2, float f3) {
        return new PointF((float) (((double) pointF.x) + (((double) f2) * Math.cos(Math.toRadians(f3)))), (float) (((double) pointF.y) + (((double) f2) * Math.sin(Math.toRadians(f3)))));
    }

    public List<c> a(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.u.f(); i2++) {
            k kVarA = this.u.a(i2);
            float fB = kVarA.b(i);
            if (fB != Float.NaN) {
                arrayList.add(new c(fB, i2, kVarA));
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.H = new f(this);
    }

    public float b(float f2, float f3) {
        PointF centerOffsets = getCenterOffsets();
        return (float) Math.sqrt(Math.pow(f3 > centerOffsets.y ? f3 - centerOffsets.y : centerOffsets.y - f3, 2.0d) + Math.pow(f2 > centerOffsets.x ? f2 - centerOffsets.x : centerOffsets.x - f2, 2.0d));
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void b() {
        this.B = this.u.l().size() - 1;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.H instanceof f) {
            ((f) this.H).b();
        }
    }

    public float getDiameter() {
        RectF rectFK = this.L.k();
        return Math.min(rectFK.width(), rectFK.height());
    }

    public float getMinOffset() {
        return this.f4930c;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.f4931d;
    }

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.f4928a;
    }

    @Override // com.github.mikephil.charting.f.e
    public float getYChartMax() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    @Override // com.github.mikephil.charting.f.e
    public float getYChartMin() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void h() {
        if (this.A) {
            return;
        }
        b();
        if (this.F != null) {
            this.I.a(this.u);
        }
        i();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0251  */
    @Override // com.github.mikephil.charting.charts.Chart
    public void i() {
        float f2;
        float f3;
        float f4;
        float fMax;
        float fMin;
        float fA;
        float fA2;
        float fMin2 = BitmapDescriptorFactory.HUE_RED;
        if (this.F == null || !this.F.q()) {
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
        } else {
            float fMin3 = Math.min(this.F.f4860a, this.L.n() * this.F.t()) + this.F.i() + this.F.r();
            if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART_CENTER) {
                fA = fMin3 + com.github.mikephil.charting.i.f.a(13.0f);
                fA2 = 0.0f;
                fMin = 0.0f;
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART) {
                fA = com.github.mikephil.charting.i.f.a(8.0f) + fMin3;
                float f5 = this.F.f4861b + this.F.f4862c;
                PointF center = getCenter();
                PointF pointF = new PointF((getWidth() - fA) + 15.0f, f5 + 15.0f);
                float fB = b(pointF.x, pointF.y);
                PointF pointFA = a(center, getRadius(), a(pointF.x, pointF.y));
                float fB2 = b(pointFA.x, pointFA.y);
                float fA3 = fB < fB2 ? (fB2 - fB) + com.github.mikephil.charting.i.f.a(5.0f) : 0.0f;
                if (pointF.y < center.y || getHeight() - fA <= getWidth()) {
                    fA = fA3;
                    fA2 = 0.0f;
                    fMin = 0.0f;
                } else {
                    fMin = 0.0f;
                    fA2 = 0.0f;
                }
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART_CENTER) {
                fA = 0.0f;
                fA2 = fMin3 + com.github.mikephil.charting.i.f.a(13.0f);
                fMin = 0.0f;
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART) {
                float fA4 = com.github.mikephil.charting.i.f.a(8.0f) + fMin3;
                float f6 = this.F.f4861b + this.F.f4862c;
                PointF center2 = getCenter();
                PointF pointF2 = new PointF(fA4 - 15.0f, f6 + 15.0f);
                float fB3 = b(pointF2.x, pointF2.y);
                PointF pointFA2 = a(center2, getRadius(), a(pointF2.x, pointF2.y));
                float fB4 = b(pointFA2.x, pointFA2.y);
                float fA5 = fB3 < fB4 ? (fB4 - fB3) + com.github.mikephil.charting.i.f.a(5.0f) : 0.0f;
                if (pointF2.y < center2.y || getHeight() - fA4 <= getWidth()) {
                    fA = 0.0f;
                    fA2 = fA5;
                    fMin = 0.0f;
                } else {
                    fMin = 0.0f;
                    fA2 = fA4;
                    fA = 0.0f;
                }
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_LEFT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_RIGHT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_CENTER) {
                fMin = Math.min(getRequiredLegendOffset() + this.F.f4861b, this.L.m() * this.F.t());
                fA = 0.0f;
                fA2 = 0.0f;
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_LEFT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_RIGHT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_CENTER) {
                fA = 0.0f;
                fA2 = 0.0f;
                fMin = 0.0f;
                fMin2 = Math.min(getRequiredLegendOffset() + this.F.f4861b, this.L.m() * this.F.t());
            } else {
                fMin = 0.0f;
                fA = 0.0f;
                fA2 = 0.0f;
            }
            float requiredBaseOffset = fA2 + getRequiredBaseOffset();
            float requiredBaseOffset2 = fA + getRequiredBaseOffset();
            fMin2 += getRequiredBaseOffset();
            f4 = requiredBaseOffset;
            f3 = requiredBaseOffset2;
            f2 = fMin;
        }
        float fA6 = com.github.mikephil.charting.i.f.a(this.f4930c);
        if (this instanceof RadarChart) {
            com.github.mikephil.charting.c.f xAxis = ((RadarChart) this).getXAxis();
            if (xAxis.q() && xAxis.g()) {
                fMax = Math.max(fA6, xAxis.o);
            } else {
                fMax = fA6;
            }
        } else {
            fMax = fA6;
        }
        float extraTopOffset = fMin2 + getExtraTopOffset();
        float extraRightOffset = f3 + getExtraRightOffset();
        float extraBottomOffset = f2 + getExtraBottomOffset();
        float fMax2 = Math.max(fMax, f4 + getExtraLeftOffset());
        float fMax3 = Math.max(fMax, extraTopOffset);
        float fMax4 = Math.max(fMax, extraRightOffset);
        float fMax5 = Math.max(fMax, Math.max(getRequiredBaseOffset(), extraBottomOffset));
        this.L.a(fMax2, fMax3, fMax4, fMax5);
        if (this.t) {
            Log.i("MPAndroidChart", "offsetLeft: " + fMax2 + ", offsetTop: " + fMax3 + ", offsetRight: " + fMax4 + ", offsetBottom: " + fMax5);
        }
    }

    public boolean j() {
        return this.f4929b;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (!this.E || this.H == null) ? super.onTouchEvent(motionEvent) : this.H.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f2) {
        this.f4930c = f2;
    }

    public void setRotationAngle(float f2) {
        this.f4931d = f2;
        this.f4928a = com.github.mikephil.charting.i.f.c(this.f4931d);
    }

    public void setRotationEnabled(boolean z) {
        this.f4929b = z;
    }
}
