package com.github.mikephil.charting.b;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends a<Entry> {
    public e(int i) {
        super(i);
    }

    public void a(List<Entry> list) {
        int iCeil = (int) Math.ceil(((this.f4853f - this.f4852e) * this.f4850c) + this.f4852e);
        for (int i = this.f4852e; i < iCeil; i++) {
            Entry entry = list.get(i);
            b(entry.f(), entry.b() * this.f4851d);
        }
        a();
    }

    protected void b(float f2, float f3) {
        float[] fArr = this.f4849b;
        int i = this.f4848a;
        this.f4848a = i + 1;
        fArr[i] = f2;
        float[] fArr2 = this.f4849b;
        int i2 = this.f4848a;
        this.f4848a = i2 + 1;
        fArr2[i2] = f3;
    }
}
