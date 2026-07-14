package com.google.b.i.b;

import com.google.b.i;
import com.google.b.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b f5751a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5756f;
    private final float g;
    private final p i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f5752b = new ArrayList(5);
    private final int[] h = new int[3];

    b(com.google.b.c.b bVar, int i, int i2, int i3, int i4, float f2, p pVar) {
        this.f5751a = bVar;
        this.f5753c = i;
        this.f5754d = i2;
        this.f5755e = i3;
        this.f5756f = i4;
        this.g = f2;
        this.i = pVar;
    }

    private float a(int i, int i2, int i3, int i4) {
        com.google.b.c.b bVar = this.f5751a;
        int iF = bVar.f();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && bVar.a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < iF && bVar.a(i2, i6) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i6++;
        }
        if (i6 == iF || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i6 < iF && !bVar.a(i2, i6) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i6++;
        }
        if (iArr[2] > i3 || Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 >= i4 * 2 || !a(iArr)) {
            return Float.NaN;
        }
        return a(iArr, i6);
    }

    private static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private a a(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i2);
        float fA2 = a(i, (int) fA, iArr[1] * 2, i3);
        if (!Float.isNaN(fA2)) {
            float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
            for (a aVar : this.f5752b) {
                if (aVar.a(f2, fA2, fA)) {
                    return aVar.b(fA2, fA, f2);
                }
            }
            a aVar2 = new a(fA, fA2, f2);
            this.f5752b.add(aVar2);
            if (this.i != null) {
                this.i.a(aVar2);
            }
        }
        return null;
    }

    private boolean a(int[] iArr) {
        float f2 = this.g;
        float f3 = f2 / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f2 - iArr[i]) >= f3) {
                return false;
            }
        }
        return true;
    }

    a a() throws i {
        a aVarA;
        a aVarA2;
        int i = this.f5753c;
        int i2 = this.f5756f;
        int i3 = i + this.f5755e;
        int i4 = this.f5754d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4 + ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2));
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f5751a.a(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            for (int i9 = i7; i9 < i3; i9++) {
                if (!this.f5751a.a(i9, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 != 2) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else {
                    if (a(iArr) && (aVarA2 = a(iArr, i6, i9)) != null) {
                        return aVarA2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                }
            }
            if (a(iArr) && (aVarA = a(iArr, i6, i3)) != null) {
                return aVarA;
            }
        }
        if (this.f5752b.isEmpty()) {
            throw i.a();
        }
        return this.f5752b.get(0);
    }
}
