package com.github.mikephil.charting.e;

import com.github.mikephil.charting.data.i;
import com.github.mikephil.charting.data.j;
import com.github.mikephil.charting.data.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends b<com.github.mikephil.charting.f.b> {
    public c(com.github.mikephil.charting.f.b bVar) {
        super(bVar);
    }

    @Override // com.github.mikephil.charting.e.b
    protected List<com.github.mikephil.charting.i.c> a(int i) {
        List<i> listT = ((j) this.f4994a.getData()).t();
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < listT.size(); i2++) {
            for (int i3 = 0; i3 < listT.get(i2).f(); i3++) {
                k kVarA = listT.get(i2).a(i3);
                if (kVarA.x()) {
                    float fB = kVarA.b(i);
                    if (fB != Float.NaN) {
                        fArr[1] = fB;
                        this.f4994a.a(kVarA.s()).a(fArr);
                        if (!Float.isNaN(fArr[1])) {
                            arrayList.add(new com.github.mikephil.charting.i.c(fArr[1], i3, kVarA));
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
