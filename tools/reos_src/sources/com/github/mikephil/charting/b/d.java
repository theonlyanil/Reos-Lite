package com.github.mikephil.charting.b;

import com.github.mikephil.charting.data.CandleEntry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends a<CandleEntry> {
    public d(int i) {
        super(i);
    }

    private void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f4849b;
        int i = this.f4848a;
        this.f4848a = i + 1;
        fArr[i] = f2;
        float[] fArr2 = this.f4849b;
        int i2 = this.f4848a;
        this.f4848a = i2 + 1;
        fArr2[i2] = f3;
        float[] fArr3 = this.f4849b;
        int i3 = this.f4848a;
        this.f4848a = i3 + 1;
        fArr3[i3] = f4;
        float[] fArr4 = this.f4849b;
        int i4 = this.f4848a;
        this.f4848a = i4 + 1;
        fArr4[i4] = f5;
    }

    public void a(List<CandleEntry> list) {
        int iCeil = (int) Math.ceil(((this.f4853f - this.f4852e) * this.f4850c) + this.f4852e);
        for (int i = this.f4852e; i < iCeil; i++) {
            CandleEntry candleEntry = list.get(i);
            a(candleEntry.f(), candleEntry.a() * this.f4851d, candleEntry.f(), candleEntry.c() * this.f4851d);
        }
        a();
    }
}
