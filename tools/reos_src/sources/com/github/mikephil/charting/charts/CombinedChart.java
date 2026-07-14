package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.e;
import com.github.mikephil.charting.data.j;
import com.github.mikephil.charting.data.l;
import com.github.mikephil.charting.data.t;
import com.github.mikephil.charting.f.c;
import com.github.mikephil.charting.f.d;
import com.github.mikephil.charting.f.f;
import com.github.mikephil.charting.f.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class CombinedChart extends BarLineChartBase<j> implements com.github.mikephil.charting.f.a, c, d, f, g {
    protected a[] S;
    private boolean T;
    private boolean U;
    private boolean V;

    public enum a {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.T = false;
        this.U = true;
        this.V = false;
        this.S = new a[]{a.BAR, a.BUBBLE, a.LINE, a.CANDLE, a.SCATTER};
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.K = new com.github.mikephil.charting.e.c(this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        super.b();
        if (getBarData() != null || getCandleData() != null || getBubbleData() != null) {
            this.C = -0.5f;
            this.D = ((j) this.u).l().size() - 0.5f;
            if (getBubbleData() != null) {
                for (T t : getBubbleData().m()) {
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
        }
        this.B = Math.abs(this.D - this.C);
        if (this.B != BitmapDescriptorFactory.HUE_RED || getLineData() == null || getLineData().k() <= 0) {
            return;
        }
        this.B = 1.0f;
    }

    @Override // com.github.mikephil.charting.f.a
    public boolean c() {
        return this.T;
    }

    @Override // com.github.mikephil.charting.f.a
    public boolean d() {
        return this.U;
    }

    @Override // com.github.mikephil.charting.f.a
    public boolean e() {
        return this.V;
    }

    @Override // com.github.mikephil.charting.f.a
    public com.github.mikephil.charting.data.a getBarData() {
        if (this.u == 0) {
            return null;
        }
        return ((j) this.u).q();
    }

    @Override // com.github.mikephil.charting.f.c
    public e getBubbleData() {
        if (this.u == 0) {
            return null;
        }
        return ((j) this.u).a();
    }

    @Override // com.github.mikephil.charting.f.d
    public com.github.mikephil.charting.data.g getCandleData() {
        if (this.u == 0) {
            return null;
        }
        return ((j) this.u).s();
    }

    public a[] getDrawOrder() {
        return this.S;
    }

    @Override // com.github.mikephil.charting.f.f
    public l getLineData() {
        if (this.u == 0) {
            return null;
        }
        return ((j) this.u).b();
    }

    @Override // com.github.mikephil.charting.f.g
    public t getScatterData() {
        if (this.u == 0) {
            return null;
        }
        return ((j) this.u).r();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(j jVar) {
        this.u = null;
        this.J = null;
        super.setData(jVar);
        this.J = new com.github.mikephil.charting.h.e(this, this.M, this.L);
        this.J.a();
    }

    public void setDrawBarShadow(boolean z) {
        this.V = z;
    }

    public void setDrawHighlightArrow(boolean z) {
        this.T = z;
    }

    public void setDrawOrder(a[] aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        this.S = aVarArr;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.U = z;
    }
}
