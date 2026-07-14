package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.t;
import com.github.mikephil.charting.f.g;
import com.github.mikephil.charting.h.n;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class ScatterChart extends BarLineChartBase<t> implements g {

    public enum a {
        CROSS,
        TRIANGLE,
        CIRCLE,
        SQUARE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static a[] getAllPossibleShapes() {
        return new a[]{a.SQUARE, a.CIRCLE, a.TRIANGLE, a.CROSS};
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.J = new n(this, this.M, this.L);
        this.C = -0.5f;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        if (this.B == BitmapDescriptorFactory.HUE_RED && ((t) this.u).k() > 0) {
            this.B = 1.0f;
        }
        this.D += 0.5f;
        this.B = Math.abs(this.D - this.C);
    }

    @Override // com.github.mikephil.charting.f.g
    public t getScatterData() {
        return (t) this.u;
    }
}
