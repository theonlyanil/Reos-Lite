package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.c.g;
import com.github.mikephil.charting.data.a;
import com.github.mikephil.charting.e.d;
import com.github.mikephil.charting.h.b;
import com.github.mikephil.charting.h.p;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class BarChart extends BarLineChartBase<a> implements com.github.mikephil.charting.f.a {
    private boolean S;
    private boolean T;
    private boolean U;

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.S = false;
        this.T = true;
        this.U = false;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public d a(float f2, float f3) {
        if (!this.A && this.u != 0) {
            return this.K.a(f2, f3);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.J = new b(this, this.M, this.L);
        this.s = new p(this.L, this.n, this.q, this);
        this.K = new com.github.mikephil.charting.e.a(this);
        this.C = -0.5f;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        this.B += 0.5f;
        this.B = ((a) this.u).f() * this.B;
        this.B = (((a) this.u).n() * ((a) this.u).a()) + this.B;
        this.D = this.B - this.C;
    }

    @Override // com.github.mikephil.charting.f.a
    public boolean c() {
        return this.S;
    }

    @Override // com.github.mikephil.charting.f.a
    public boolean d() {
        return this.T;
    }

    @Override // com.github.mikephil.charting.f.a
    public boolean e() {
        return this.U;
    }

    @Override // com.github.mikephil.charting.f.a
    public a getBarData() {
        return (a) this.u;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.f.b
    public int getHighestVisibleXIndex() {
        float f2 = ((a) this.u).f();
        float fA = f2 <= 1.0f ? 1.0f : ((a) this.u).a() + f2;
        float[] fArr = {this.L.g(), this.L.h()};
        a(g.a.LEFT).b(fArr);
        return (int) (fArr[0] >= getXChartMax() ? getXChartMax() / fA : fArr[0] / fA);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.f.b
    public int getLowestVisibleXIndex() {
        float f2 = ((a) this.u).f();
        float fA = f2 <= 1.0f ? 1.0f : ((a) this.u).a() + f2;
        float[] fArr = {this.L.f(), this.L.h()};
        a(g.a.LEFT).b(fArr);
        return (int) (fArr[0] <= getXChartMin() ? BitmapDescriptorFactory.HUE_RED : (fArr[0] / fA) + 1.0f);
    }

    public void setDrawBarShadow(boolean z) {
        this.U = z;
    }

    public void setDrawHighlightArrow(boolean z) {
        this.S = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.T = z;
    }
}
