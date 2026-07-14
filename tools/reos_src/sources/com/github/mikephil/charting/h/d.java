package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.data.CandleEntry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.github.mikephil.charting.f.d f5030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.github.mikephil.charting.b.d[] f5031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.github.mikephil.charting.b.c[] f5032c;

    public d(com.github.mikephil.charting.f.d dVar, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(aVar, gVar);
        this.f5030a = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a() {
        com.github.mikephil.charting.data.g candleData = this.f5030a.getCandleData();
        this.f5031b = new com.github.mikephil.charting.b.d[candleData.f()];
        this.f5032c = new com.github.mikephil.charting.b.c[candleData.f()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5031b.length) {
                return;
            }
            com.github.mikephil.charting.data.h hVar = (com.github.mikephil.charting.data.h) candleData.a(i2);
            this.f5031b[i2] = new com.github.mikephil.charting.b.d(hVar.o() * 4);
            this.f5032c[i2] = new com.github.mikephil.charting.b.c(hVar.o() * 4);
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        for (T t : this.f5030a.getCandleData().m()) {
            if (t.r() && t.j() > 0) {
                a(canvas, t);
            }
        }
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.h hVar) {
        com.github.mikephil.charting.i.d dVarA = this.f5030a.a(hVar.s());
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        int iA = this.f5030a.getCandleData().a(hVar);
        List<T> listK = hVar.k();
        int iMax = Math.max(this.o, 0);
        int iMin = Math.min(this.p + 1, listK.size());
        int i = (iMin - iMax) * 4;
        int iCeil = (int) Math.ceil(((iMin - iMax) * fB) + iMax);
        com.github.mikephil.charting.b.c cVar = this.f5032c[iA];
        cVar.a(hVar.a());
        cVar.a(fB, fA);
        cVar.a(iMax);
        cVar.b(iMin);
        cVar.a((List<CandleEntry>) listK);
        dVarA.a(cVar.f4849b);
        com.github.mikephil.charting.b.d dVar = this.f5031b[iA];
        dVar.a(fB, fA);
        dVar.a(iMax);
        dVar.b(iMin);
        dVar.a((List<CandleEntry>) listK);
        dVarA.a(dVar.f4849b);
        this.f5036f.setStrokeWidth(hVar.b());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) listK.get((i3 / 4) + iMax);
            if (b(candleEntry.f(), this.o, iCeil)) {
                if (!hVar.i()) {
                    this.f5036f.setColor(hVar.h() == -1 ? hVar.f(i3) : hVar.h());
                } else if (candleEntry.e() > candleEntry.d()) {
                    this.f5036f.setColor(hVar.c() == -1 ? hVar.f(i3) : hVar.c());
                } else if (candleEntry.e() < candleEntry.d()) {
                    this.f5036f.setColor(hVar.d() == -1 ? hVar.f(i3) : hVar.d());
                } else {
                    this.f5036f.setColor(hVar.h() == -1 ? hVar.f(i3) : hVar.h());
                }
                this.f5036f.setStyle(Paint.Style.STROKE);
                canvas.drawLine(dVar.f4849b[i3], dVar.f4849b[i3 + 1], dVar.f4849b[i3 + 2], dVar.f4849b[i3 + 3], this.f5036f);
                float f2 = cVar.f4849b[i3];
                float f3 = cVar.f4849b[i3 + 1];
                float f4 = cVar.f4849b[i3 + 2];
                float f5 = cVar.f4849b[i3 + 3];
                if (f3 > f5) {
                    if (hVar.c() == -1) {
                        this.f5036f.setColor(hVar.f((i3 / 4) + iMax));
                    } else {
                        this.f5036f.setColor(hVar.c());
                    }
                    this.f5036f.setStyle(hVar.e());
                    canvas.drawRect(f2, f5, f4, f3, this.f5036f);
                } else if (f3 < f5) {
                    if (hVar.d() == -1) {
                        this.f5036f.setColor(hVar.f((i3 / 4) + iMax));
                    } else {
                        this.f5036f.setColor(hVar.d());
                    }
                    this.f5036f.setStyle(hVar.f());
                    canvas.drawRect(f2, f3, f4, f5, this.f5036f);
                } else {
                    this.f5036f.setColor(hVar.h());
                    canvas.drawLine(f2, f3, f4, f5, this.f5036f);
                }
            }
            i2 = i3 + 4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        CandleEntry candleEntry;
        for (int i = 0; i < dVarArr.length; i++) {
            int iB = dVarArr[i].b();
            com.github.mikephil.charting.data.h hVar = (com.github.mikephil.charting.data.h) this.f5030a.getCandleData().a(dVarArr[i].a());
            if (hVar != null && hVar.x() && (candleEntry = (CandleEntry) hVar.c(iB)) != null && candleEntry.f() == iB) {
                float fA = ((candleEntry.a() * this.f5035e.a()) + (candleEntry.c() * this.f5035e.a())) / 2.0f;
                this.f5030a.getYChartMin();
                this.f5030a.getYChartMax();
                float[] fArr = {iB, fA};
                this.f5030a.a(hVar.s()).a(fArr);
                a(canvas, fArr, hVar);
            }
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        if (this.f5030a.getCandleData().k() < this.f5030a.getMaxVisibleCount() * this.n.p()) {
            List<T> listM = this.f5030a.getCandleData().m();
            for (int i = 0; i < listM.size(); i++) {
                com.github.mikephil.charting.data.k<?> kVar = (com.github.mikephil.charting.data.h) listM.get(i);
                if (kVar.t() && kVar.j() != 0) {
                    a(kVar);
                    com.github.mikephil.charting.i.d dVarA = this.f5030a.a(kVar.s());
                    List<T> listK = kVar.k();
                    int iMax = Math.max(this.o, 0);
                    float[] fArrC = dVarA.c(listK, this.f5035e.b(), this.f5035e.a(), iMax, Math.min(this.p + 1, listK.size()));
                    float fA = com.github.mikephil.charting.i.f.a(5.0f);
                    for (int i2 = 0; i2 < fArrC.length; i2 += 2) {
                        float f2 = fArrC[i2];
                        float f3 = fArrC[i2 + 1];
                        if (!this.n.f(f2)) {
                            break;
                        }
                        if (this.n.e(f2) && this.n.d(f3)) {
                            CandleEntry candleEntry = (CandleEntry) listK.get((i2 / 2) + iMax);
                            a(canvas, kVar.y(), candleEntry.a(), candleEntry, i, f2, f3 - fA);
                        }
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void c(Canvas canvas) {
    }
}
