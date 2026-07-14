package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.c.c;
import com.github.mikephil.charting.c.f;
import com.github.mikephil.charting.data.a;
import com.github.mikephil.charting.e.d;
import com.github.mikephil.charting.h.g;
import com.github.mikephil.charting.h.q;
import com.github.mikephil.charting.h.t;
import com.github.mikephil.charting.i.e;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalBarChart extends BarChart {
    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase
    public d a(float f2, float f3) {
        if (!this.A && this.u != 0) {
            return this.K.a(f3, f2);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.q = new e(this.L);
        this.r = new e(this.L);
        this.J = new g(this, this.M, this.L);
        this.K = new com.github.mikephil.charting.e.e(this);
        this.o = new t(this.L, this.l, this.q);
        this.p = new t(this.L, this.m, this.r);
        this.s = new q(this.L, this.n, this.q, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void f() {
        this.r.a(this.m.y, this.m.z, this.B, this.C);
        this.q.a(this.l.y, this.l.z, this.B, this.C);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.f.b
    public int getHighestVisibleXIndex() {
        float f2 = ((a) this.u).f();
        float fA = f2 <= 1.0f ? 1.0f : ((a) this.u).a() + f2;
        float[] fArr = {this.L.f(), this.L.e()};
        a(com.github.mikephil.charting.c.g.a.LEFT).b(fArr);
        return (int) (fArr[1] >= getXChartMax() ? getXChartMax() / fA : fArr[1] / fA);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.f.b
    public int getLowestVisibleXIndex() {
        float f2 = ((a) this.u).f();
        float fA = f2 <= 1.0f ? 1.0f : ((a) this.u).a() + f2;
        float[] fArr = {this.L.f(), this.L.h()};
        a(com.github.mikephil.charting.c.g.a.LEFT).b(fArr);
        return (int) ((fArr[1] <= BitmapDescriptorFactory.HUE_RED ? 0.0f : fArr[1] / fA) + 1.0f);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x01e1  */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void i() {
        float fB;
        float fMin;
        float fMin2;
        float fB2 = BitmapDescriptorFactory.HUE_RED;
        if (this.F == null || !this.F.q()) {
            fB = 0.0f;
            fMin = 0.0f;
            fMin2 = 0.0f;
        } else if (this.F.f() == c.EnumC0083c.RIGHT_OF_CHART || this.F.f() == c.EnumC0083c.RIGHT_OF_CHART_CENTER) {
            fMin = Math.min(this.F.f4860a, this.L.n() * this.F.t()) + (this.F.l() * 2.0f) + BitmapDescriptorFactory.HUE_RED;
            fMin2 = 0.0f;
            fB = 0.0f;
        } else if (this.F.f() == c.EnumC0083c.LEFT_OF_CHART || this.F.f() == c.EnumC0083c.LEFT_OF_CHART_CENTER) {
            fMin = 0.0f;
            fMin2 = Math.min(this.F.f4860a, this.L.n() * this.F.t()) + (this.F.l() * 2.0f) + BitmapDescriptorFactory.HUE_RED;
            fB = 0.0f;
        } else if (this.F.f() == c.EnumC0083c.BELOW_CHART_LEFT || this.F.f() == c.EnumC0083c.BELOW_CHART_RIGHT || this.F.f() == c.EnumC0083c.BELOW_CHART_CENTER) {
            fMin = 0.0f;
            fMin2 = 0.0f;
            fB = 0.0f;
            fB2 = Math.min((this.F.f4862c * 2.0f) + this.F.f4861b, this.L.m() * this.F.t()) + BitmapDescriptorFactory.HUE_RED;
        } else if (this.F.f() == c.EnumC0083c.ABOVE_CHART_LEFT || this.F.f() == c.EnumC0083c.ABOVE_CHART_RIGHT || this.F.f() == c.EnumC0083c.ABOVE_CHART_CENTER) {
            fB = Math.min((this.F.f4862c * 2.0f) + this.F.f4861b, this.L.m() * this.F.t()) + BitmapDescriptorFactory.HUE_RED;
            fMin = 0.0f;
            fMin2 = 0.0f;
        } else {
            fB = 0.0f;
            fMin = 0.0f;
            fMin2 = 0.0f;
        }
        if (this.l.F()) {
            fB += this.l.b(this.o.a());
        }
        if (this.m.F()) {
            fB2 += this.m.b(this.p.a());
        }
        float f2 = this.n.o;
        if (this.n.q()) {
            if (this.n.r() == f.a.BOTTOM) {
                fMin2 += f2;
            } else if (this.n.r() == f.a.TOP) {
                fMin += f2;
            } else if (this.n.r() == f.a.BOTH_SIDED) {
                fMin2 += f2;
                fMin += f2;
            }
        }
        float extraTopOffset = fB + getExtraTopOffset();
        float extraRightOffset = fMin + getExtraRightOffset();
        float extraBottomOffset = fB2 + getExtraBottomOffset();
        float extraLeftOffset = fMin2 + getExtraLeftOffset();
        float fA = com.github.mikephil.charting.i.f.a(this.j);
        this.L.a(Math.max(fA, extraLeftOffset), Math.max(fA, extraTopOffset), Math.max(fA, extraRightOffset), Math.max(fA, extraBottomOffset));
        if (this.t) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            Log.i("MPAndroidChart", "Content: " + this.L.k().toString());
        }
        g();
        f();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void j() {
        float[] fArr = new float[9];
        this.L.o().getValues(fArr);
        this.n.r = (int) Math.ceil((((a) this.u).n() * this.n.p) / (fArr[4] * this.L.j()));
        if (this.n.r < 1) {
            this.n.r = 1;
        }
    }
}
