package com.google.b.i.a;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f5719b;

    private b(int i, byte[] bArr) {
        this.f5718a = i;
        this.f5719b = bArr;
    }

    static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length != jVar.c()) {
            throw new IllegalArgumentException();
        }
        j.b bVarA = jVar.a(fVar);
        j.a[] aVarArrB = bVarA.b();
        int iA = 0;
        for (j.a aVar : aVarArrB) {
            iA += aVar.a();
        }
        b[] bVarArr = new b[iA];
        int length = aVarArrB.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            j.a aVar2 = aVarArrB[i];
            int i3 = i2;
            int i4 = 0;
            while (i4 < aVar2.a()) {
                int iB = aVar2.b();
                bVarArr[i3] = new b(iB, new byte[bVarA.a() + iB]);
                i4++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        int length2 = bVarArr[0].f5719b.length;
        int length3 = bVarArr.length - 1;
        while (length3 >= 0 && bVarArr[length3].f5719b.length != length2) {
            length3--;
        }
        int i5 = length3 + 1;
        int iA2 = length2 - bVarA.a();
        int i6 = 0;
        int i7 = 0;
        while (i6 < iA2) {
            int i8 = i7;
            int i9 = 0;
            while (i9 < i2) {
                bVarArr[i9].f5719b[i6] = bArr[i8];
                i9++;
                i8++;
            }
            i6++;
            i7 = i8;
        }
        int i10 = i5;
        while (i10 < i2) {
            bVarArr[i10].f5719b[iA2] = bArr[i7];
            i10++;
            i7++;
        }
        int length4 = bVarArr[0].f5719b.length;
        while (iA2 < length4) {
            int i11 = 0;
            int i12 = i7;
            while (i11 < i2) {
                bVarArr[i11].f5719b[i11 < i5 ? iA2 : iA2 + 1] = bArr[i12];
                i11++;
                i12++;
            }
            iA2++;
            i7 = i12;
        }
        return bVarArr;
    }

    int a() {
        return this.f5718a;
    }

    byte[] b() {
        return this.f5719b;
    }
}
