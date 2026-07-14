package com.github.mikephil.charting.b;

import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends a<Entry> {
    public h(int i) {
        super(i);
    }

    public void a(List<Entry> list) {
        float size = list.size() * this.f4850c;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                a();
                return;
            } else {
                Entry entry = list.get(i2);
                b(entry.f(), entry.b() * this.f4851d);
                i = i2 + 1;
            }
        }
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
