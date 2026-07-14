package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.e;
import com.github.mikephil.charting.f.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class BubbleChart extends BarLineChartBase<e> implements c {
    public BubbleChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.J = new com.github.mikephil.charting.h.c(this, this.M, this.L);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        if (this.B == BitmapDescriptorFactory.HUE_RED && ((e) this.u).k() > 0) {
            this.B = 1.0f;
        }
        this.C = -0.5f;
        this.D = ((e) this.u).n() - 0.5f;
        if (this.J != null) {
            for (T t : ((e) this.u).m()) {
                float fC = t.c();
                float fB = t.b();
                if (fC < this.C) {
                    this.C = fC;
                }
                if (fB > this.D) {
                    this.D = fB;
                }
            }
        }
        this.B = Math.abs(this.D - this.C);
    }

    @Override // com.github.mikephil.charting.f.c
    public e getBubbleData() {
        return (e) this.u;
    }
}
