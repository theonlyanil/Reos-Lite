package com.github.mikephil.charting.e;

import com.github.mikephil.charting.c.g;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    public e(com.github.mikephil.charting.f.a aVar) {
        super(aVar);
    }

    @Override // com.github.mikephil.charting.e.a, com.github.mikephil.charting.e.b
    protected int a(float f2) {
        if (!((com.github.mikephil.charting.f.a) this.f4994a).getBarData().b()) {
            float[] fArr = {0.0f, f2};
            ((com.github.mikephil.charting.f.a) this.f4994a).a(g.a.LEFT).b(fArr);
            return Math.round(fArr[1]);
        }
        int iB = ((int) b(f2)) / ((com.github.mikephil.charting.f.a) this.f4994a).getBarData().f();
        int iN = ((com.github.mikephil.charting.f.a) this.f4994a).getData().n();
        if (iB < 0) {
            return 0;
        }
        return iB >= iN ? iN - 1 : iB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.e.a, com.github.mikephil.charting.e.b
    public d a(float f2, float f3) {
        d dVarA = super.a(f2, f3);
        if (dVarA == null) {
            return dVarA;
        }
        com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) ((com.github.mikephil.charting.f.a) this.f4994a).getBarData().a(dVarA.a());
        if (!bVar.b()) {
            return dVarA;
        }
        float[] fArr = {f3, 0.0f};
        ((com.github.mikephil.charting.f.a) this.f4994a).a(bVar.s()).b(fArr);
        return a(dVarA, bVar, dVarA.b(), dVarA.a(), fArr[0]);
    }

    @Override // com.github.mikephil.charting.e.a
    protected float b(float f2) {
        float[] fArr = {0.0f, f2};
        ((com.github.mikephil.charting.f.a) this.f4994a).a(g.a.LEFT).b(fArr);
        float f3 = fArr[1];
        return f3 - (((com.github.mikephil.charting.f.a) this.f4994a).getBarData().a() * ((int) (f3 / (((com.github.mikephil.charting.f.a) this.f4994a).getBarData().a() + ((com.github.mikephil.charting.f.a) this.f4994a).getBarData().f()))));
    }
}
