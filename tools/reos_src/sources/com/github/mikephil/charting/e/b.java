package com.github.mikephil.charting.e;

import com.github.mikephil.charting.c.g;
import com.github.mikephil.charting.f.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b<T extends com.github.mikephil.charting.f.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f4994a;

    public b(T t) {
        this.f4994a = t;
    }

    protected int a(float f2) {
        float[] fArr = {f2, 0.0f};
        this.f4994a.a(g.a.LEFT).b(fArr);
        return Math.round(fArr[0]);
    }

    protected int a(int i, float f2, float f3) {
        List<com.github.mikephil.charting.i.c> listA = a(i);
        return com.github.mikephil.charting.i.f.a(listA, f3, com.github.mikephil.charting.i.f.b(listA, f3, g.a.LEFT) < com.github.mikephil.charting.i.f.b(listA, f3, g.a.RIGHT) ? g.a.LEFT : g.a.RIGHT);
    }

    public d a(float f2, float f3) {
        int iA;
        int iA2 = a(f2);
        if (iA2 == -2147483647 || (iA = a(iA2, f2, f3)) == -2147483647) {
            return null;
        }
        return new d(iA2, iA);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.github.mikephil.charting.data.k] */
    protected List<com.github.mikephil.charting.i.c> a(int i) {
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < this.f4994a.getData().f(); i2++) {
            ?? A = this.f4994a.getData().a(i2);
            if (A.x()) {
                float fB = A.b(i);
                if (fB != Float.NaN) {
                    fArr[1] = fB;
                    this.f4994a.a(A.s()).a(fArr);
                    if (!Float.isNaN(fArr[1])) {
                        arrayList.add(new com.github.mikephil.charting.i.c(fArr[1], i2, A));
                    }
                }
            }
        }
        return arrayList;
    }
}
