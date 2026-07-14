package com.google.b.d.a;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f5487b;

    private b(int i, byte[] bArr) {
        this.f5486a = i;
        this.f5487b = bArr;
    }

    static b[] a(byte[] bArr, e eVar) {
        e.b bVarG = eVar.g();
        e.a[] aVarArrB = bVarG.b();
        int iA = 0;
        for (e.a aVar : aVarArrB) {
            iA += aVar.a();
        }
        b[] bVarArr = new b[iA];
        int length = aVarArrB.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            e.a aVar2 = aVarArrB[i];
            int i3 = i2;
            int i4 = 0;
            while (i4 < aVar2.a()) {
                int iB = aVar2.b();
                bVarArr[i3] = new b(iB, new byte[bVarG.a() + iB]);
                i4++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        int length2 = bVarArr[0].f5487b.length - bVarG.a();
        int i5 = length2 - 1;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = 0;
            while (i8 < i2) {
                bVarArr[i8].f5487b[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        boolean z = eVar.a() == 24;
        int i9 = z ? 8 : i2;
        int i10 = 0;
        while (i10 < i9) {
            bVarArr[i10].f5487b[length2 - 1] = bArr[i6];
            i10++;
            i6++;
        }
        int length3 = bVarArr[0].f5487b.length;
        int i11 = i6;
        while (length2 < length3) {
            int i12 = 0;
            int i13 = i11;
            while (i12 < i2) {
                int i14 = z ? (i12 + 8) % i2 : i12;
                bVarArr[i14].f5487b[(!z || i14 <= 7) ? length2 : length2 - 1] = bArr[i13];
                i12++;
                i13++;
            }
            length2++;
            i11 = i13;
        }
        if (i11 != bArr.length) {
            throw new IllegalArgumentException();
        }
        return bVarArr;
    }

    int a() {
        return this.f5486a;
    }

    byte[] b() {
        return this.f5487b;
    }
}
