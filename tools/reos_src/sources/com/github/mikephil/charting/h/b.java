package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.github.mikephil.charting.f.a f5022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected RectF f5023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.github.mikephil.charting.b.b[] f5024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f5025d;

    public b(com.github.mikephil.charting.f.a aVar, com.github.mikephil.charting.a.a aVar2, com.github.mikephil.charting.i.g gVar) {
        super(aVar2, gVar);
        this.f5023b = new RectF();
        this.f5022a = aVar;
        this.g = new Paint(1);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setColor(Color.rgb(0, 0, 0));
        this.g.setAlpha(120);
        this.f5025d = new Paint(1);
        this.f5025d.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a() {
        com.github.mikephil.charting.data.a barData = this.f5022a.getBarData();
        this.f5024c = new com.github.mikephil.charting.b.b[barData.f()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5024c.length) {
                return;
            }
            com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) barData.a(i2);
            this.f5024c[i2] = new com.github.mikephil.charting.b.b(bVar.o() * 4 * bVar.a(), barData.a(), barData.f(), bVar.b());
            i = i2 + 1;
        }
    }

    protected void a(float f2, float f3, float f4, float f5, com.github.mikephil.charting.i.d dVar) {
        this.f5023b.set((f2 - 0.5f) + f5, f3, (0.5f + f2) - f5, f4);
        dVar.a(this.f5023b, this.f5035e.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        com.github.mikephil.charting.data.a barData = this.f5022a.getBarData();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= barData.f()) {
                return;
            }
            com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) barData.a(i2);
            if (bVar.r() && bVar.j() > 0) {
                a(canvas, bVar, i2);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void a(Canvas canvas, com.github.mikephil.charting.data.b bVar, int i) {
        int i2 = 0;
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
        if (bVar.u().size() > 1) {
            while (true) {
                int i3 = i2;
                if (i3 >= bVar2.b()) {
                    return;
                }
                if (this.n.e(bVar2.f4849b[i3 + 2])) {
                    if (!this.n.f(bVar2.f4849b[i3])) {
                        return;
                    }
                    if (this.f5022a.e()) {
                        canvas.drawRect(bVar2.f4849b[i3], this.n.e(), bVar2.f4849b[i3 + 2], this.n.h(), this.f5025d);
                    }
                    this.f5036f.setColor(bVar.f(i3 / 4));
                    canvas.drawRect(bVar2.f4849b[i3], bVar2.f4849b[i3 + 1], bVar2.f4849b[i3 + 2], bVar2.f4849b[i3 + 3], this.f5036f);
                }
                i2 = i3 + 4;
            }
        } else {
            this.f5036f.setColor(bVar.v());
            while (true) {
                int i4 = i2;
                if (i4 >= bVar2.b()) {
                    return;
                }
                if (this.n.e(bVar2.f4849b[i4 + 2])) {
                    if (!this.n.f(bVar2.f4849b[i4])) {
                        return;
                    }
                    if (this.f5022a.e()) {
                        canvas.drawRect(bVar2.f4849b[i4], this.n.e(), bVar2.f4849b[i4 + 2], this.n.h(), this.f5025d);
                    }
                    canvas.drawRect(bVar2.f4849b[i4], bVar2.f4849b[i4 + 1], bVar2.f4849b[i4 + 2], bVar2.f4849b[i4 + 3], this.f5036f);
                }
                i2 = i4 + 4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        BarEntry barEntry;
        float fB;
        float f2;
        int iF = this.f5022a.getBarData().f();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dVarArr.length) {
                return;
            }
            com.github.mikephil.charting.e.d dVar = dVarArr[i2];
            int iB = dVar.b();
            int iA = dVar.a();
            com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) this.f5022a.getBarData().a(iA);
            if (bVar != null && bVar.x()) {
                float fC = bVar.c() / 2.0f;
                com.github.mikephil.charting.i.d dVarA = this.f5022a.a(bVar.s());
                this.g.setColor(bVar.g());
                this.g.setAlpha(bVar.e());
                if (iB >= 0 && iB < (this.f5022a.getXChartMax() * this.f5035e.b()) / iF && (barEntry = (BarEntry) bVar.c(iB)) != null && barEntry.f() == iB) {
                    float fA = this.f5022a.getBarData().a();
                    float f3 = (iB * iF) + iA + (fA / 2.0f) + (iB * fA);
                    if (dVar.c() >= 0) {
                        fB = dVar.d().f4999a;
                        f2 = dVar.d().f5000b;
                    } else {
                        fB = barEntry.b();
                        f2 = BitmapDescriptorFactory.HUE_RED;
                    }
                    a(f3, fB, f2, fC, dVarA);
                    canvas.drawRect(this.f5023b, this.g);
                    if (this.f5022a.c()) {
                        this.g.setAlpha(255);
                        float fA2 = this.f5035e.a() * 0.07f;
                        float[] fArr = new float[9];
                        dVarA.b().getValues(fArr);
                        float fAbs = Math.abs(fArr[4] / fArr[0]);
                        float fC2 = bVar.c() / 2.0f;
                        float f4 = fAbs * fC2;
                        if (fB > (-f2)) {
                        }
                        float fA3 = fB * this.f5035e.a();
                        Path path = new Path();
                        path.moveTo(0.4f + f3, fA3 + fA2);
                        path.lineTo(0.4f + f3 + fC2, (fA3 + fA2) - f4);
                        path.lineTo(f3 + 0.4f + fC2, fA2 + fA3 + f4);
                        dVarA.a(path);
                        canvas.drawPath(path, this.g);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public float[] a(com.github.mikephil.charting.i.d dVar, List<BarEntry> list, int i) {
        return dVar.a(list, i, this.f5022a.getBarData(), this.f5035e.a());
    }

    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        if (b()) {
            List<T> listM = this.f5022a.getBarData().m();
            float fA = com.github.mikephil.charting.i.f.a(4.5f);
            boolean zD = this.f5022a.d();
            for (int i = 0; i < this.f5022a.getBarData().f(); i++) {
                com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) listM.get(i);
                if (bVar.t() && bVar.j() != 0) {
                    a(bVar);
                    boolean zC = this.f5022a.c(bVar.s());
                    float fB = com.github.mikephil.charting.i.f.b(this.i, "8");
                    float f5 = zD ? -fA : fB + fA;
                    float f6 = zD ? fB + fA : -fA;
                    if (zC) {
                        f2 = (-f6) - fB;
                        f3 = (-f5) - fB;
                    } else {
                        f2 = f6;
                        f3 = f5;
                    }
                    com.github.mikephil.charting.i.d dVarA = this.f5022a.a(bVar.s());
                    List<T> listK = bVar.k();
                    float[] fArrA = a(dVarA, (List<BarEntry>) listK, i);
                    if (bVar.b()) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= (fArrA.length - 1) * this.f5035e.b()) {
                                break;
                            }
                            BarEntry barEntry = (BarEntry) listK.get(i3 / 2);
                            float[] fArrA2 = barEntry.a();
                            if (fArrA2 != null) {
                                float[] fArr = new float[fArrA2.length * 2];
                                float f7 = BitmapDescriptorFactory.HUE_RED;
                                float f8 = -barEntry.d();
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < fArr.length) {
                                    float f9 = fArrA2[i5];
                                    if (f9 >= BitmapDescriptorFactory.HUE_RED) {
                                        f7 += f9;
                                        f4 = f7;
                                    } else {
                                        float f10 = f8;
                                        f8 -= f9;
                                        f4 = f10;
                                    }
                                    fArr[i4 + 1] = f4 * this.f5035e.a();
                                    i4 += 2;
                                    i5++;
                                }
                                dVarA.a(fArr);
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= fArr.length) {
                                        break;
                                    }
                                    float f11 = fArrA[i3];
                                    float f12 = fArr[i7 + 1] + (fArrA2[i7 / 2] >= BitmapDescriptorFactory.HUE_RED ? f3 : f2);
                                    if (!this.n.f(f11)) {
                                        break;
                                    }
                                    if (this.n.d(f12) && this.n.e(f11)) {
                                        a(canvas, bVar.y(), fArrA2[i7 / 2], barEntry, i, f11, f12);
                                    }
                                    i6 = i7 + 2;
                                }
                            } else if (!this.n.f(fArrA[i3])) {
                                break;
                            } else if (this.n.d(fArrA[i3 + 1]) && this.n.e(fArrA[i3])) {
                                a(canvas, bVar.y(), barEntry.b(), barEntry, i, fArrA[i3], fArrA[i3 + 1] + (barEntry.b() >= BitmapDescriptorFactory.HUE_RED ? f3 : f2));
                            }
                            i2 = i3 + 2;
                        }
                    } else {
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= fArrA.length * this.f5035e.b() || !this.n.f(fArrA[i9])) {
                                break;
                            }
                            if (this.n.d(fArrA[i9 + 1]) && this.n.e(fArrA[i9])) {
                                Entry entry = (BarEntry) listK.get(i9 / 2);
                                float fB2 = entry.b();
                                a(canvas, bVar.y(), fB2, entry, i, fArrA[i9], fArrA[i9 + 1] + (fB2 >= BitmapDescriptorFactory.HUE_RED ? f3 : f2));
                            }
                            i8 = i9 + 2;
                        }
                    }
                }
            }
        }
    }

    protected boolean b() {
        return ((float) this.f5022a.getBarData().k()) < ((float) this.f5022a.getMaxVisibleCount()) * this.n.p();
    }

    @Override // com.github.mikephil.charting.h.f
    public void c(Canvas canvas) {
    }
}
