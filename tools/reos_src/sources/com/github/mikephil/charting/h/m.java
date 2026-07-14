package com.github.mikephil.charting.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    protected com.github.mikephil.charting.i.g n;
    protected int o = 0;
    protected int p = 0;

    public m(com.github.mikephil.charting.i.g gVar) {
        this.n = gVar;
    }

    public void a(com.github.mikephil.charting.f.b bVar, int i) {
        int lowestVisibleXIndex = bVar.getLowestVisibleXIndex();
        int highestVisibleXIndex = bVar.getHighestVisibleXIndex();
        this.o = Math.max(((lowestVisibleXIndex / i) * i) - (lowestVisibleXIndex % i == 0 ? i : 0), 0);
        this.p = Math.min(((highestVisibleXIndex / i) * i) + i, (int) bVar.getXChartMax());
    }

    protected boolean b(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }
}
