package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g extends b {
    public g(com.github.mikephil.charting.f.a aVar, com.github.mikephil.charting.a.a aVar2, com.github.mikephil.charting.i.g gVar) {
        super(aVar, aVar2, gVar);
        this.i.setTextAlign(Paint.Align.LEFT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.b, com.github.mikephil.charting.h.f
    public void a() {
        com.github.mikephil.charting.data.a barData = this.f5022a.getBarData();
        this.f5024c = new com.github.mikephil.charting.b.f[barData.f()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5024c.length) {
                return;
            }
            com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) barData.a(i2);
            this.f5024c[i2] = new com.github.mikephil.charting.b.f(bVar.o() * 4 * bVar.a(), barData.a(), barData.f(), bVar.b());
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.h.b
    protected void a(float f2, float f3, float f4, float f5, com.github.mikephil.charting.i.d dVar) {
        this.f5023b.set(f3, (f2 - 0.5f) + f5, f4, (0.5f + f2) - f5);
        dVar.b(this.f5023b, this.f5035e.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.b
    protected void a(Canvas canvas, com.github.mikephil.charting.data.b bVar, int i) {
        com.github.mikephil.charting.i.d dVarA = this.f5022a.a(bVar.s());
        this.f5025d.setColor(bVar.d());
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        List<T> listK = bVar.k();
        com.github.mikephil.charting.b.b bVar2 = this.f5024c[i];
        bVar2.a(fB, fA);
        bVar2.a(bVar.c());
        bVar2.c(i);
        bVar2.a(this.f5022a.c(bVar.s()));
        bVar2.a((List<BarEntry>) listK);
        dVarA.a(bVar2.f4849b);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bVar2.b() || !this.n.g(bVar2.f4849b[i3 + 3])) {
                return;
            }
            if (this.n.h(bVar2.f4849b[i3 + 1])) {
                if (this.f5022a.e()) {
                    canvas.drawRect(this.n.f(), bVar2.f4849b[i3 + 1], this.n.g(), bVar2.f4849b[i3 + 3], this.f5025d);
                }
                this.f5036f.setColor(bVar.f(i3 / 4));
                canvas.drawRect(bVar2.f4849b[i3], bVar2.f4849b[i3 + 1], bVar2.f4849b[i3 + 2], bVar2.f4849b[i3 + 3], this.f5036f);
            }
            i2 = i3 + 4;
        }
    }

    protected void a(Canvas canvas, String str, float f2, float f3) {
        canvas.drawText(str, f2, f3, this.i);
    }

    @Override // com.github.mikephil.charting.h.b
    public float[] a(com.github.mikephil.charting.i.d dVar, List<BarEntry> list, int i) {
        return dVar.b(list, i, this.f5022a.getBarData(), this.f5035e.a());
    }

    @Override // com.github.mikephil.charting.h.b, com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        float f2;
        if (!b()) {
            return;
        }
        List<T> listM = this.f5022a.getBarData().m();
        float fA = com.github.mikephil.charting.i.f.a(5.0f);
        boolean zD = this.f5022a.d();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5022a.getBarData().f()) {
                return;
            }
            com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) listM.get(i2);
            if (bVar.t() && bVar.j() != 0) {
                boolean zC = this.f5022a.c(bVar.s());
                a(bVar);
                float fB = com.github.mikephil.charting.i.f.b(this.i, "10") / 2.0f;
                com.github.mikephil.charting.d.f fVarY = bVar.y();
                com.github.mikephil.charting.i.d dVarA = this.f5022a.a(bVar.s());
                List<T> listK = bVar.k();
                float[] fArrA = a(dVarA, (List<BarEntry>) listK, i2);
                if (bVar.b()) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= (fArrA.length - 1) * this.f5035e.b()) {
                            break;
                        }
                        BarEntry barEntry = (BarEntry) listK.get(i4 / 2);
                        float[] fArrA2 = barEntry.a();
                        if (fArrA2 != null) {
                            float[] fArr = new float[fArrA2.length * 2];
                            float f3 = BitmapDescriptorFactory.HUE_RED;
                            float f4 = -barEntry.d();
                            int i5 = 0;
                            int i6 = 0;
                            while (i5 < fArr.length) {
                                float f5 = fArrA2[i6];
                                if (f5 >= BitmapDescriptorFactory.HUE_RED) {
                                    f3 += f5;
                                    f2 = f3;
                                } else {
                                    float f6 = f4;
                                    f4 -= f5;
                                    f2 = f6;
                                }
                                fArr[i5] = f2 * this.f5035e.a();
                                i5 += 2;
                                i6++;
                            }
                            dVarA.a(fArr);
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= fArr.length) {
                                    break;
                                }
                                float f7 = fArrA2[i8 / 2];
                                String strA = fVarY.a(f7, barEntry, i2, this.n);
                                float fA2 = com.github.mikephil.charting.i.f.a(this.i, strA);
                                float f8 = zD ? fA : -(fA2 + fA);
                                float f9 = zD ? -(fA2 + fA) : fA;
                                if (zC) {
                                    f8 = (-f8) - fA2;
                                    f9 = (-f9) - fA2;
                                }
                                float f10 = fArr[i8];
                                if (f7 < BitmapDescriptorFactory.HUE_RED) {
                                    f8 = f9;
                                }
                                float f11 = f10 + f8;
                                float f12 = fArrA[i4 + 1];
                                if (!this.n.g(f12)) {
                                    break;
                                }
                                if (this.n.c(f11) && this.n.h(f12)) {
                                    a(canvas, strA, f11, f12 + fB);
                                }
                                i7 = i8 + 2;
                            }
                        } else {
                            if (!this.n.g(fArrA[i4 + 1])) {
                                break;
                            }
                            if (this.n.c(fArrA[i4]) && this.n.h(fArrA[i4 + 1])) {
                                String strA2 = fVarY.a(barEntry.b(), barEntry, i2, this.n);
                                float fA3 = com.github.mikephil.charting.i.f.a(this.i, strA2);
                                float f13 = zD ? fA : -(fA3 + fA);
                                float f14 = zD ? -(fA3 + fA) : fA;
                                if (zC) {
                                    f13 = (-f13) - fA3;
                                    f14 = (-f14) - fA3;
                                }
                                float f15 = fArrA[i4];
                                if (barEntry.b() < BitmapDescriptorFactory.HUE_RED) {
                                    f13 = f14;
                                }
                                a(canvas, strA2, f15 + f13, fArrA[i4 + 1] + fB);
                            }
                        }
                        i3 = i4 + 2;
                    }
                } else {
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= fArrA.length * this.f5035e.b() || !this.n.g(fArrA[i10 + 1])) {
                            break;
                        }
                        if (this.n.c(fArrA[i10]) && this.n.h(fArrA[i10 + 1])) {
                            BarEntry barEntry2 = (BarEntry) listK.get(i10 / 2);
                            float fB2 = barEntry2.b();
                            String strA3 = fVarY.a(fB2, barEntry2, i2, this.n);
                            float fA4 = com.github.mikephil.charting.i.f.a(this.i, strA3);
                            float f16 = zD ? fA : -(fA4 + fA);
                            float f17 = zD ? -(fA4 + fA) : fA;
                            if (zC) {
                                f16 = (-f16) - fA4;
                                f17 = (-f17) - fA4;
                            }
                            float f18 = fArrA[i10];
                            if (fB2 < BitmapDescriptorFactory.HUE_RED) {
                                f16 = f17;
                            }
                            a(canvas, strA3, f18 + f16, fArrA[i10 + 1] + fB);
                        }
                        i9 = i10 + 2;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.h.b
    protected boolean b() {
        return ((float) this.f5022a.getBarData().k()) < ((float) this.f5022a.getMaxVisibleCount()) * this.n.q();
    }
}
