package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.g;
import com.github.mikephil.charting.f.d;

/* JADX INFO: loaded from: classes.dex */
public class CandleStickChart extends BarLineChartBase<g> implements d {
    public CandleStickChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.J = new com.github.mikephil.charting.h.d(this, this.M, this.L);
        this.C = -0.5f;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        this.D += 0.5f;
        this.B = Math.abs(this.D - this.C);
    }

    @Override // com.github.mikephil.charting.f.d
    public g getCandleData() {
        return (g) this.u;
    }
}
