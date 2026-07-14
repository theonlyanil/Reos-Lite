package com.github.mikephil.charting.b;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g extends a<Entry> {
    public g(int i) {
        super(i < 4 ? 4 : i);
    }

    public void a(List<Entry> list) {
        b(list.get(this.f4852e).f(), list.get(this.f4852e).b() * this.f4851d);
        int iCeil = (int) Math.ceil(((this.f4853f - this.f4852e) * this.f4850c) + this.f4852e);
        for (int i = this.f4852e + 1; i < iCeil; i++) {
            Entry entry = list.get(i);
            c(entry.f(), entry.b() * this.f4851d);
        }
        a();
    }

    public void b(float f2, float f3) {
        if (this.f4848a != 0) {
            return;
        }
        float[] fArr = this.f4849b;
        int i = this.f4848a;
        this.f4848a = i + 1;
        fArr[i] = f2;
        float[] fArr2 = this.f4849b;
        int i2 = this.f4848a;
        this.f4848a = i2 + 1;
        fArr2[i2] = f3;
        this.f4849b[this.f4848a] = f2;
        this.f4849b[this.f4848a + 1] = f3;
    }

    public void c(float f2, float f3) {
        if (this.f4848a == 2) {
            float[] fArr = this.f4849b;
            int i = this.f4848a;
            this.f4848a = i + 1;
            fArr[i] = f2;
            float[] fArr2 = this.f4849b;
            int i2 = this.f4848a;
            this.f4848a = i2 + 1;
            fArr2[i2] = f3;
            return;
        }
        float f4 = this.f4849b[this.f4848a - 2];
        float f5 = this.f4849b[this.f4848a - 1];
        float[] fArr3 = this.f4849b;
        int i3 = this.f4848a;
        this.f4848a = i3 + 1;
        fArr3[i3] = f4;
        float[] fArr4 = this.f4849b;
        int i4 = this.f4848a;
        this.f4848a = i4 + 1;
        fArr4[i4] = f5;
        float[] fArr5 = this.f4849b;
        int i5 = this.f4848a;
        this.f4848a = i5 + 1;
        fArr5[i5] = f2;
        float[] fArr6 = this.f4849b;
        int i6 = this.f4848a;
        this.f4848a = i6 + 1;
        fArr6[i6] = f3;
    }
}
