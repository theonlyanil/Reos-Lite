package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.CombinedChart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static /* synthetic */ int[] f5033b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<f> f5034a;

    public e(CombinedChart combinedChart, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(aVar, gVar);
        a(combinedChart, aVar, gVar);
    }

    static /* synthetic */ int[] b() {
        int[] iArr = f5033b;
        if (iArr == null) {
            iArr = new int[CombinedChart.a.valuesCustom().length];
            try {
                iArr[CombinedChart.a.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CombinedChart.a.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CombinedChart.a.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[CombinedChart.a.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[CombinedChart.a.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            f5033b = iArr;
        }
        return iArr;
    }

    @Override // com.github.mikephil.charting.h.f
    public void a() {
        Iterator<f> it = this.f5034a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        Iterator<f> it = this.f5034a.iterator();
        while (it.hasNext()) {
            it.next().a(canvas);
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        Iterator<f> it = this.f5034a.iterator();
        while (it.hasNext()) {
            it.next().a(canvas, dVarArr);
        }
    }

    protected void a(CombinedChart combinedChart, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        this.f5034a = new ArrayList();
        for (CombinedChart.a aVar2 : combinedChart.getDrawOrder()) {
            switch (b()[aVar2.ordinal()]) {
                case 1:
                    if (combinedChart.getBarData() != null) {
                        this.f5034a.add(new b(combinedChart, aVar, gVar));
                    }
                    break;
                case 2:
                    if (combinedChart.getBubbleData() != null) {
                        this.f5034a.add(new c(combinedChart, aVar, gVar));
                    }
                    break;
                case 3:
                    if (combinedChart.getLineData() != null) {
                        this.f5034a.add(new i(combinedChart, aVar, gVar));
                    }
                    break;
                case 4:
                    if (combinedChart.getCandleData() != null) {
                        this.f5034a.add(new d(combinedChart, aVar, gVar));
                    }
                    break;
                case 5:
                    if (combinedChart.getScatterData() != null) {
                        this.f5034a.add(new n(combinedChart, aVar, gVar));
                    }
                    break;
            }
        }
    }

    @Override // com.github.mikephil.charting.h.m
    public void a(com.github.mikephil.charting.f.b bVar, int i) {
        Iterator<f> it = this.f5034a.iterator();
        while (it.hasNext()) {
            it.next().a(bVar, i);
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        Iterator<f> it = this.f5034a.iterator();
        while (it.hasNext()) {
            it.next().b(canvas);
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void c(Canvas canvas) {
        Iterator<f> it = this.f5034a.iterator();
        while (it.hasNext()) {
            it.next().c(canvas);
        }
    }
}
