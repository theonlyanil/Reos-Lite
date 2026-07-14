package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.c.f;
import com.github.mikephil.charting.c.g;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.r;
import com.github.mikephil.charting.e.d;
import com.github.mikephil.charting.h.l;
import com.github.mikephil.charting.h.u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class RadarChart extends PieRadarChartBase<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected u f4932a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.github.mikephil.charting.h.r f4933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4935f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private g l;
    private f m;

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4934e = 2.5f;
        this.f4935f = 1.5f;
        this.g = Color.rgb(122, 122, 122);
        this.h = Color.rgb(122, 122, 122);
        this.i = 150;
        this.j = true;
        this.k = 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int a(float f2) {
        float fC = com.github.mikephil.charting.i.f.c(f2 - getRotationAngle());
        float sliceAngle = getSliceAngle();
        for (int i = 0; i < ((r) this.u).n(); i++) {
            if (((i + 1) * sliceAngle) - (sliceAngle / 2.0f) > fC) {
                return i;
            }
        }
        return 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.l = new g(g.a.LEFT);
        this.m = new f();
        this.m.a(0);
        this.f4934e = com.github.mikephil.charting.i.f.a(1.5f);
        this.f4935f = com.github.mikephil.charting.i.f.a(0.75f);
        this.J = new l(this, this.M, this.L);
        this.f4932a = new u(this.L, this.l, this);
        this.f4933d = new com.github.mikephil.charting.h.r(this.L, this.m, this);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] a(Entry entry, d dVar) {
        float sliceAngle = (getSliceAngle() * entry.f()) + getRotationAngle();
        float fB = entry.b() * getFactor();
        PointF centerOffsets = getCenterOffsets();
        PointF pointF = new PointF((float) (((double) centerOffsets.x) + (((double) fB) * Math.cos(Math.toRadians(sliceAngle)))), (float) ((Math.sin(Math.toRadians(sliceAngle)) * ((double) fB)) + ((double) centerOffsets.y)));
        return new float[]{pointF.x, pointF.y};
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        float fA = ((r) this.u).a(g.a.LEFT);
        float fB = ((r) this.u).b(g.a.LEFT);
        this.D = ((r) this.u).l().size() - 1;
        this.B = Math.abs(this.D - this.C);
        float fAbs = Math.abs(fB - (this.l.y() ? 0.0f : fA));
        float fB2 = (fAbs / 100.0f) * this.l.B();
        float fC = this.l.C() * (fAbs / 100.0f);
        this.D = ((r) this.u).l().size() - 1;
        this.B = Math.abs(this.D - this.C);
        if (!this.l.y()) {
            this.l.y = !Float.isNaN(this.l.z()) ? this.l.z() : fA - fC;
            this.l.x = !Float.isNaN(this.l.A()) ? this.l.A() : fB + fB2;
        } else if (fA < BitmapDescriptorFactory.HUE_RED && fB < BitmapDescriptorFactory.HUE_RED) {
            this.l.y = Math.min(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.z()) ? this.l.z() : fA - fC);
            this.l.x = BitmapDescriptorFactory.HUE_RED;
        } else if (fA >= 0.0d) {
            this.l.y = BitmapDescriptorFactory.HUE_RED;
            this.l.x = Math.max(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.A()) ? this.l.A() : fB + fB2);
        } else {
            this.l.y = Math.min(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.z()) ? this.l.z() : fA - fC);
            this.l.x = Math.max(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.A()) ? this.l.A() : fB + fB2);
        }
        this.l.z = Math.abs(this.l.x - this.l.y);
    }

    public float getFactor() {
        RectF rectFK = this.L.k();
        return Math.min(rectFK.width() / 2.0f, rectFK.height() / 2.0f) / this.l.z;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectFK = this.L.k();
        return Math.min(rectFK.width() / 2.0f, rectFK.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return (this.m.q() && this.m.g()) ? this.m.o : com.github.mikephil.charting.i.f.a(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.I.a().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.k;
    }

    public float getSliceAngle() {
        return 360.0f / ((r) this.u).n();
    }

    public int getWebAlpha() {
        return this.i;
    }

    public int getWebColor() {
        return this.g;
    }

    public int getWebColorInner() {
        return this.h;
    }

    public float getWebLineWidth() {
        return this.f4934e;
    }

    public float getWebLineWidthInner() {
        return this.f4935f;
    }

    public f getXAxis() {
        return this.m;
    }

    public g getYAxis() {
        return this.l;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.f.e
    public float getYChartMax() {
        return this.l.x;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.f.e
    public float getYChartMin() {
        return this.l.y;
    }

    public float getYRange() {
        return this.l.z;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void h() {
        if (this.A) {
            return;
        }
        b();
        this.f4932a.a(this.l.y, this.l.x);
        this.f4933d.a(((r) this.u).i(), ((r) this.u).l());
        if (this.F != null && !this.F.e()) {
            this.I.a(this.u);
        }
        i();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A) {
            return;
        }
        this.f4933d.a(canvas);
        if (this.j) {
            this.J.c(canvas);
        }
        this.f4932a.d(canvas);
        this.J.a(canvas);
        if (u()) {
            this.J.a(canvas, this.O);
        }
        this.f4932a.a(canvas);
        this.J.b(canvas);
        this.I.a(canvas);
        b(canvas);
        c(canvas);
    }

    public void setDrawWeb(boolean z) {
        this.j = z;
    }

    public void setSkipWebLineCount(int i) {
        this.k = Math.max(0, i);
    }

    public void setWebAlpha(int i) {
        this.i = i;
    }

    public void setWebColor(int i) {
        this.g = i;
    }

    public void setWebColorInner(int i) {
        this.h = i;
    }

    public void setWebLineWidth(float f2) {
        this.f4934e = com.github.mikephil.charting.i.f.a(f2);
    }

    public void setWebLineWidthInner(float f2) {
        this.f4935f = com.github.mikephil.charting.i.f.a(f2);
    }
}
