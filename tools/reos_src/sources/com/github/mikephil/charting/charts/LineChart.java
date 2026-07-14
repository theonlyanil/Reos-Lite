package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.l;
import com.github.mikephil.charting.f.f;
import com.github.mikephil.charting.h.i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class LineChart extends BarLineChartBase<l> implements f {
    public LineChart(Context context) {
        super(context);
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.J = new i(this, this.M, this.L);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        if (this.B != BitmapDescriptorFactory.HUE_RED || ((l) this.u).k() <= 0) {
            return;
        }
        this.B = 1.0f;
    }

    @Override // com.github.mikephil.charting.f.f
    public l getLineData() {
        return (l) this.u;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.J != null && (this.J instanceof i)) {
            ((i) this.J).b();
        }
        super.onDetachedFromWindow();
    }
}
