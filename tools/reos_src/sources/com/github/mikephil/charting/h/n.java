package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static /* synthetic */ int[] f5053c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.github.mikephil.charting.f.g f5054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.github.mikephil.charting.b.h[] f5055b;

    public n(com.github.mikephil.charting.f.g gVar, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar2) {
        super(aVar, gVar2);
        this.f5054a = gVar;
        this.f5036f.setStrokeWidth(com.github.mikephil.charting.i.f.a(1.0f));
    }

    static /* synthetic */ int[] b() {
        int[] iArr = f5053c;
        if (iArr == null) {
            iArr = new int[ScatterChart.a.valuesCustom().length];
            try {
                iArr[ScatterChart.a.CIRCLE.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ScatterChart.a.CROSS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ScatterChart.a.SQUARE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ScatterChart.a.TRIANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            f5053c = iArr;
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a() {
        com.github.mikephil.charting.data.t scatterData = this.f5054a.getScatterData();
        this.f5055b = new com.github.mikephil.charting.b.h[scatterData.f()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5055b.length) {
                return;
            }
            this.f5055b[i2] = new com.github.mikephil.charting.b.h(((com.github.mikephil.charting.data.u) scatterData.a(i2)).j() * 2);
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        for (T t : this.f5054a.getScatterData().m()) {
            if (t.r()) {
                a(canvas, t);
            }
        }
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.u uVar) {
        int i = 0;
        com.github.mikephil.charting.i.d dVarA = this.f5054a.a(uVar.s());
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        List<T> listK = uVar.k();
        float fA2 = uVar.a() / 2.0f;
        ScatterChart.a aVarB = uVar.b();
        com.github.mikephil.charting.b.h hVar = this.f5055b[this.f5054a.getScatterData().a(uVar)];
        hVar.a(fB, fA);
        hVar.a((List<Entry>) listK);
        dVarA.a(hVar.f4849b);
        switch (b()[aVarB.ordinal()]) {
            case 1:
                this.f5036f.setStyle(Paint.Style.STROKE);
                while (true) {
                    int i2 = i;
                    if (i2 < hVar.b() && this.n.f(hVar.f4849b[i2])) {
                        if (this.n.e(hVar.f4849b[i2]) && this.n.d(hVar.f4849b[i2 + 1])) {
                            this.f5036f.setColor(uVar.f(i2 / 2));
                            canvas.drawLine(hVar.f4849b[i2] - fA2, hVar.f4849b[i2 + 1], hVar.f4849b[i2] + fA2, hVar.f4849b[i2 + 1], this.f5036f);
                            canvas.drawLine(hVar.f4849b[i2], hVar.f4849b[i2 + 1] - fA2, hVar.f4849b[i2], hVar.f4849b[i2 + 1] + fA2, this.f5036f);
                        }
                        i = i2 + 2;
                    }
                }
                break;
            case 2:
                this.f5036f.setStyle(Paint.Style.FILL);
                Path path = new Path();
                while (i < hVar.b() && this.n.f(hVar.f4849b[i])) {
                    if (this.n.e(hVar.f4849b[i]) && this.n.d(hVar.f4849b[i + 1])) {
                        this.f5036f.setColor(uVar.f(i / 2));
                        path.moveTo(hVar.f4849b[i], hVar.f4849b[i + 1] - fA2);
                        path.lineTo(hVar.f4849b[i] + fA2, hVar.f4849b[i + 1] + fA2);
                        path.lineTo(hVar.f4849b[i] - fA2, hVar.f4849b[i + 1] + fA2);
                        path.close();
                        canvas.drawPath(path, this.f5036f);
                        path.reset();
                    }
                    i += 2;
                }
                break;
            case 3:
                this.f5036f.setStyle(Paint.Style.FILL);
                while (i < hVar.b() && this.n.f(hVar.f4849b[i])) {
                    if (this.n.e(hVar.f4849b[i]) && this.n.d(hVar.f4849b[i + 1])) {
                        this.f5036f.setColor(uVar.f(i / 2));
                        canvas.drawCircle(hVar.f4849b[i], hVar.f4849b[i + 1], fA2, this.f5036f);
                    }
                    i += 2;
                }
                break;
            case 4:
                this.f5036f.setStyle(Paint.Style.FILL);
                while (true) {
                    int i3 = i;
                    if (i3 < hVar.b() && this.n.f(hVar.f4849b[i3])) {
                        if (this.n.e(hVar.f4849b[i3]) && this.n.d(hVar.f4849b[i3 + 1])) {
                            this.f5036f.setColor(uVar.f(i3 / 2));
                            canvas.drawRect(hVar.f4849b[i3] - fA2, hVar.f4849b[i3 + 1] - fA2, hVar.f4849b[i3] + fA2, hVar.f4849b[i3 + 1] + fA2, this.f5036f);
                        }
                        i = i3 + 2;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        for (int i = 0; i < dVarArr.length; i++) {
            com.github.mikephil.charting.data.u uVar = (com.github.mikephil.charting.data.u) this.f5054a.getScatterData().a(dVarArr[i].a());
            if (uVar != null && uVar.x()) {
                int iB = dVarArr[i].b();
                if (iB <= this.f5054a.getXChartMax() * this.f5035e.b()) {
                    float fB = uVar.b(iB);
                    if (fB != Float.NaN) {
                        float[] fArr = {iB, fB * this.f5035e.a()};
                        this.f5054a.a(uVar.s()).a(fArr);
                        a(canvas, fArr, uVar);
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        if (this.f5054a.getScatterData().k() < this.f5054a.getMaxVisibleCount() * this.n.p()) {
            List<T> listM = this.f5054a.getScatterData().m();
            for (int i = 0; i < this.f5054a.getScatterData().f(); i++) {
                com.github.mikephil.charting.data.u uVar = (com.github.mikephil.charting.data.u) listM.get(i);
                if (uVar.t() && uVar.j() != 0) {
                    a(uVar);
                    List<T> listK = uVar.k();
                    float[] fArrA = this.f5054a.a(uVar.s()).a((List<? extends Entry>) listK, this.f5035e.a());
                    float fA = uVar.a();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= fArrA.length * this.f5035e.b() || !this.n.f(fArrA[i3])) {
                            break;
                        }
                        if (this.n.e(fArrA[i3]) && this.n.d(fArrA[i3 + 1])) {
                            Entry entry = (Entry) listK.get(i3 / 2);
                            a(canvas, uVar.y(), entry.b(), entry, i, fArrA[i3], fArrA[i3 + 1] - fA);
                        }
                        i2 = i3 + 2;
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void c(Canvas canvas) {
    }
}
