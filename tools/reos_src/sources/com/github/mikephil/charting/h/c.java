package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.github.mikephil.charting.f.c f5026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f5027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float[] f5028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f5029d;

    public c(com.github.mikephil.charting.f.c cVar, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(aVar, gVar);
        this.f5027b = new float[4];
        this.f5028c = new float[2];
        this.f5029d = new float[3];
        this.f5026a = cVar;
        this.f5036f.setStyle(Paint.Style.FILL);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(com.github.mikephil.charting.i.f.a(1.5f));
    }

    protected float a(float f2, float f3, float f4) {
        return (f3 == BitmapDescriptorFactory.HUE_RED ? 1.0f : (float) Math.sqrt(f2 / f3)) * f4;
    }

    @Override // com.github.mikephil.charting.h.f
    public void a() {
    }

    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        for (T t : this.f5026a.getBubbleData().m()) {
            if (t.r() && t.j() > 0) {
                a(canvas, t);
            }
        }
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.f fVar) {
        com.github.mikephil.charting.i.d dVarA = this.f5026a.a(fVar.s());
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        List listK = fVar.k();
        Entry entryC = fVar.c(this.o);
        Entry entryC2 = fVar.c(this.p);
        int iMax = Math.max(fVar.a(entryC), 0);
        int iMin = Math.min(fVar.a(entryC2) + 1, listK.size());
        this.f5027b[0] = 0.0f;
        this.f5027b[2] = 1.0f;
        dVarA.a(this.f5027b);
        float fMin = Math.min(Math.abs(this.n.h() - this.n.e()), Math.abs(this.f5027b[2] - this.f5027b[0]));
        for (int i = iMax; i < iMin; i++) {
            BubbleEntry bubbleEntry = (BubbleEntry) listK.get(i);
            this.f5028c[0] = ((bubbleEntry.f() - iMax) * fB) + iMax;
            this.f5028c[1] = bubbleEntry.b() * fA;
            dVarA.a(this.f5028c);
            float fA2 = a(bubbleEntry.a(), fVar.d(), fMin) / 2.0f;
            if (this.n.g(this.f5028c[1] + fA2) && this.n.h(this.f5028c[1] - fA2) && this.n.e(this.f5028c[0] + fA2)) {
                if (!this.n.f(this.f5028c[0] - fA2)) {
                    return;
                }
                this.f5036f.setColor(fVar.f(bubbleEntry.f()));
                canvas.drawCircle(this.f5028c[0], this.f5028c[1], fA2, this.f5036f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        com.github.mikephil.charting.data.e bubbleData = this.f5026a.getBubbleData();
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        for (com.github.mikephil.charting.e.d dVar : dVarArr) {
            com.github.mikephil.charting.data.f fVar = (com.github.mikephil.charting.data.f) bubbleData.a(dVar.a());
            if (fVar != null && fVar.x()) {
                Entry entryC = fVar.c(this.o);
                Entry entryC2 = fVar.c(this.p);
                int iA = fVar.a(entryC);
                int iMin = Math.min(fVar.a(entryC2) + 1, fVar.j());
                BubbleEntry bubbleEntry = (BubbleEntry) bubbleData.a(dVar);
                if (bubbleEntry != null && bubbleEntry.f() == dVar.b()) {
                    com.github.mikephil.charting.i.d dVarA = this.f5026a.a(fVar.s());
                    this.f5027b[0] = 0.0f;
                    this.f5027b[2] = 1.0f;
                    dVarA.a(this.f5027b);
                    float fMin = Math.min(Math.abs(this.n.h() - this.n.e()), Math.abs(this.f5027b[2] - this.f5027b[0]));
                    this.f5028c[0] = ((bubbleEntry.f() - iA) * fB) + iA;
                    this.f5028c[1] = bubbleEntry.b() * fA;
                    dVarA.a(this.f5028c);
                    float fA2 = a(bubbleEntry.a(), fVar.d(), fMin) / 2.0f;
                    if (this.n.g(this.f5028c[1] + fA2) && this.n.h(this.f5028c[1] - fA2) && this.n.e(this.f5028c[0] + fA2)) {
                        if (!this.n.f(this.f5028c[0] - fA2)) {
                            return;
                        }
                        if (dVar.b() >= iA && dVar.b() < iMin) {
                            int iF = fVar.f(bubbleEntry.f());
                            Color.RGBToHSV(Color.red(iF), Color.green(iF), Color.blue(iF), this.f5029d);
                            float[] fArr = this.f5029d;
                            fArr[2] = fArr[2] * 0.5f;
                            this.g.setColor(Color.HSVToColor(Color.alpha(iF), this.f5029d));
                            this.g.setStrokeWidth(fVar.a());
                            canvas.drawCircle(this.f5028c[0], this.f5028c[1], fA2, this.g);
                        }
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        com.github.mikephil.charting.data.e bubbleData = this.f5026a.getBubbleData();
        if (bubbleData != null && bubbleData.k() < ((int) Math.ceil(this.f5026a.getMaxVisibleCount() * this.n.p()))) {
            List<T> listM = bubbleData.m();
            float fB = com.github.mikephil.charting.i.f.b(this.i, "1");
            for (int i = 0; i < listM.size(); i++) {
                com.github.mikephil.charting.data.k<?> kVar = (com.github.mikephil.charting.data.f) listM.get(i);
                if (kVar.t() && kVar.j() != 0) {
                    a(kVar);
                    float fB2 = this.f5035e.b();
                    float fA = this.f5035e.a();
                    float f2 = fB2 == 1.0f ? fA : fB2;
                    int iA = kVar.A();
                    this.i.setColor(Color.argb(Math.round(f2 * 255.0f), Color.red(iA), Color.green(iA), Color.blue(iA)));
                    List<? extends Entry> listK = kVar.k();
                    Entry entryC = kVar.c(this.o);
                    Entry entryC2 = kVar.c(this.p);
                    int iA2 = kVar.a(entryC);
                    float[] fArrA = this.f5026a.a(kVar.s()).a(listK, fB2, fA, iA2, Math.min(kVar.a(entryC2) + 1, kVar.j()));
                    for (int i2 = 0; i2 < fArrA.length; i2 += 2) {
                        float f3 = fArrA[i2];
                        float f4 = fArrA[i2 + 1];
                        if (!this.n.f(f3)) {
                            break;
                        }
                        if (this.n.e(f3) && this.n.d(f4)) {
                            BubbleEntry bubbleEntry = (BubbleEntry) listK.get((i2 / 2) + iA2);
                            a(canvas, kVar.y(), bubbleEntry.a(), bubbleEntry, i, f3, f4 + (0.5f * fB));
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
