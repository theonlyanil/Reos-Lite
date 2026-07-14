package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.p;
import com.github.mikephil.charting.data.q;
import com.github.mikephil.charting.e.d;
import com.github.mikephil.charting.h.k;
import com.github.mikephil.charting.i.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PieChart extends PieRadarChartBase<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f4924a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RectF f4925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f4927f;
    private float[] g;
    private boolean h;
    private boolean i;
    private boolean j;
    private SpannableString k;
    private float l;
    private boolean m;
    private float n;

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4925d = new RectF();
        this.f4926e = true;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = new SpannableString("");
        this.l = 50.0f;
        this.f4924a = 55.0f;
        this.m = true;
        this.n = 1.0f;
    }

    private float b(float f2) {
        return (f2 / ((p) this.u).j()) * 360.0f;
    }

    private void k() {
        this.f4927f = new float[((p) this.u).k()];
        this.g = new float[((p) this.u).k()];
        List<q> listM = ((p) this.u).m();
        int i = 0;
        for (int i2 = 0; i2 < ((p) this.u).f(); i2++) {
            List<Entry> listK = listM.get(i2).k();
            for (int i3 = 0; i3 < listK.size(); i3++) {
                this.f4927f[i] = b(Math.abs(listK.get(i3).b()));
                if (i == 0) {
                    this.g[i] = this.f4927f[i];
                } else {
                    this.g[i] = this.g[i - 1] + this.f4927f[i];
                }
                i++;
            }
        }
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int a(float f2) {
        float fC = f.c(f2 - getRotationAngle());
        for (int i = 0; i < this.g.length; i++) {
            if (this.g[i] > fC) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.J = new k(this, this.M, this.L);
    }

    public boolean a(int i, int i2) {
        if (!u() || i2 < 0) {
            return false;
        }
        for (int i3 = 0; i3 < this.O.length; i3++) {
            if (this.O[i3].b() == i && this.O[i3].a() == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] a(Entry entry, d dVar) {
        PointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float holeRadius = (radius / 10.0f) * 3.6f;
        if (d()) {
            holeRadius = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f2 = radius - holeRadius;
        float rotationAngle = getRotationAngle();
        int iF = entry.f();
        float f3 = this.f4927f[iF] / 2.0f;
        return new float[]{(float) ((((double) f2) * Math.cos(Math.toRadians(((this.g[iF] + rotationAngle) - f3) * this.M.a()))) + ((double) centerCircleBox.x)), (float) (((double) centerCircleBox.y) + (Math.sin(Math.toRadians(((this.g[iF] + rotationAngle) - f3) * this.M.a())) * ((double) f2)))};
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        k();
    }

    public boolean c() {
        return ((k) this.J).b().getXfermode() != null;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.m;
    }

    public boolean f() {
        return this.f4926e;
    }

    public boolean g() {
        return this.i;
    }

    public float[] getAbsoluteAngles() {
        return this.g;
    }

    public PointF getCenterCircleBox() {
        return new PointF(this.f4925d.centerX(), this.f4925d.centerY());
    }

    public SpannableString getCenterText() {
        return this.k;
    }

    public float getCenterTextRadiusPercent() {
        return this.n;
    }

    public RectF getCircleBox() {
        return this.f4925d;
    }

    public float[] getDrawAngles() {
        return this.f4927f;
    }

    public float getHoleRadius() {
        return this.l;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        return this.f4925d == null ? BitmapDescriptorFactory.HUE_RED : Math.min(this.f4925d.width() / 2.0f, this.f4925d.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.I.a().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.f4924a;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void i() {
        super.i();
        if (this.A) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        PointF centerOffsets = getCenterOffsets();
        float fB = ((p) this.u).a().b();
        this.f4925d.set((centerOffsets.x - diameter) + fB, (centerOffsets.y - diameter) + fB, (centerOffsets.x + diameter) - fB, (diameter + centerOffsets.y) - fB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.J != null && (this.J instanceof k)) {
            ((k) this.J).e();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A) {
            return;
        }
        this.J.a(canvas);
        if (u()) {
            this.J.a(canvas, this.O);
        }
        this.J.c(canvas);
        this.J.b(canvas);
        this.I.a(canvas);
        b(canvas);
        c(canvas);
    }

    public void setCenterText(SpannableString spannableString) {
        if (spannableString == null) {
            this.k = new SpannableString("");
        } else {
            this.k = spannableString;
        }
    }

    public void setCenterText(String str) {
        setCenterText(new SpannableString(str));
    }

    public void setCenterTextColor(int i) {
        ((k) this.J).d().setColor(i);
    }

    public void setCenterTextRadiusPercent(float f2) {
        this.n = f2;
    }

    public void setCenterTextSize(float f2) {
        ((k) this.J).d().setTextSize(f.a(f2));
    }

    public void setCenterTextSizePixels(float f2) {
        ((k) this.J).d().setTextSize(f2);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((k) this.J).d().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.m = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.h = z;
    }

    public void setDrawSliceText(boolean z) {
        this.f4926e = z;
    }

    public void setHoleColor(int i) {
        ((k) this.J).b().setXfermode(null);
        ((k) this.J).b().setColor(i);
    }

    public void setHoleColorTransparent(boolean z) {
        if (!z) {
            ((k) this.J).b().setXfermode(null);
        } else {
            ((k) this.J).b().setColor(-1);
            ((k) this.J).b().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
    }

    public void setHoleRadius(float f2) {
        this.l = f2;
    }

    public void setTransparentCircleAlpha(int i) {
        ((k) this.J).c().setAlpha(i);
    }

    public void setTransparentCircleColor(int i) {
        Paint paintC = ((k) this.J).c();
        int alpha = paintC.getAlpha();
        paintC.setColor(i);
        paintC.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f2) {
        this.f4924a = f2;
    }

    public void setUsePercentValues(boolean z) {
        this.i = z;
    }
}
