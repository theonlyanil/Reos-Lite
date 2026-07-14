package com.github.mikephil.charting.e;

import com.github.mikephil.charting.c.g;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class a extends b<com.github.mikephil.charting.f.a> {
    public a(com.github.mikephil.charting.f.a aVar) {
        super(aVar);
    }

    @Override // com.github.mikephil.charting.e.b
    protected int a(float f2) {
        if (!((com.github.mikephil.charting.f.a) this.f4994a).getBarData().b()) {
            return super.a(f2);
        }
        int iB = ((int) b(f2)) / ((com.github.mikephil.charting.f.a) this.f4994a).getBarData().f();
        int iN = ((com.github.mikephil.charting.f.a) this.f4994a).getData().n();
        if (iB < 0) {
            return 0;
        }
        return iB >= iN ? iN - 1 : iB;
    }

    @Override // com.github.mikephil.charting.e.b
    protected int a(int i, float f2, float f3) {
        if (!((com.github.mikephil.charting.f.a) this.f4994a).getBarData().b()) {
            return 0;
        }
        float fB = b(f2);
        int iF = ((com.github.mikephil.charting.f.a) this.f4994a).getBarData().f();
        int i2 = ((int) fB) % iF;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= iF) {
            i2 = iF - 1;
        }
        return i2;
    }

    protected int a(f[] fVarArr, float f2) {
        if (fVarArr == null) {
            return 0;
        }
        int length = fVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (fVarArr[i].a(f2)) {
                return i2;
            }
            i++;
            i2++;
        }
        int iMax = Math.max(fVarArr.length - 1, 0);
        if (f2 <= fVarArr[iMax].f5000b) {
            iMax = 0;
        }
        return iMax;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.e.b
    public d a(float f2, float f3) {
        d dVarA = super.a(f2, f3);
        if (dVarA == null) {
            return dVarA;
        }
        com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) ((com.github.mikephil.charting.f.a) this.f4994a).getBarData().a(dVarA.a());
        if (!bVar.b()) {
            return dVarA;
        }
        float[] fArr = {0.0f, f3};
        ((com.github.mikephil.charting.f.a) this.f4994a).a(bVar.s()).b(fArr);
        return a(dVarA, bVar, dVarA.b(), dVarA.a(), fArr[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected d a(d dVar, com.github.mikephil.charting.data.b bVar, int i, int i2, double d2) {
        BarEntry barEntry = (BarEntry) bVar.c(i);
        if (barEntry == null || barEntry.a() == null) {
            return dVar;
        }
        f[] fVarArrA = a(barEntry);
        int iA = a(fVarArrA, (float) d2);
        return new d(i, i2, iA, fVarArrA[iA]);
    }

    protected f[] a(BarEntry barEntry) {
        float[] fArrA = barEntry.a();
        if (fArrA == null) {
            return null;
        }
        float f2 = -barEntry.d();
        f[] fVarArr = new f[fArrA.length];
        float fAbs = f2;
        float f3 = 0.0f;
        for (int i = 0; i < fVarArr.length; i++) {
            float f4 = fArrA[i];
            if (f4 < BitmapDescriptorFactory.HUE_RED) {
                fVarArr[i] = new f(fAbs, Math.abs(f4) + fAbs);
                fAbs += Math.abs(f4);
            } else {
                fVarArr[i] = new f(f3, f3 + f4);
                f3 += f4;
            }
        }
        return fVarArr;
    }

    protected float b(float f2) {
        float[] fArr = {f2, 0.0f};
        ((com.github.mikephil.charting.f.a) this.f4994a).a(g.a.LEFT).b(fArr);
        float f3 = fArr[0];
        return f3 - (((com.github.mikephil.charting.f.a) this.f4994a).getBarData().a() * ((int) (f3 / (((com.github.mikephil.charting.f.a) this.f4994a).getBarData().a() + ((com.github.mikephil.charting.f.a) this.f4994a).getBarData().f()))));
    }
}
