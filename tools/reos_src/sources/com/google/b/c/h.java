package com.google.b.c;

import com.flurry.android.Constants;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.google.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f5467a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f5468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f5469c;

    public h(com.google.b.g gVar) {
        super(gVar);
        this.f5468b = f5467a;
        this.f5469c = new int[32];
    }

    private static int a(int[] iArr) throws com.google.b.i {
        int i;
        int i2;
        int i3 = 0;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (iArr[i7] > i4) {
                i4 = iArr[i7];
                i5 = i7;
            }
            if (iArr[i7] > i6) {
                i6 = iArr[i7];
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i3 < length) {
            int i10 = i3 - i5;
            int i11 = i10 * iArr[i3] * i10;
            if (i11 > i8) {
                i2 = i3;
            } else {
                i11 = i8;
                i2 = i9;
            }
            i3++;
            i9 = i2;
            i8 = i11;
        }
        if (i5 <= i9) {
            int i12 = i9;
            i9 = i5;
            i5 = i12;
        }
        if (i5 - i9 <= length / 16) {
            throw com.google.b.i.a();
        }
        int i13 = i5 - 1;
        int i14 = -1;
        int i15 = i5 - 1;
        while (i15 > i9) {
            int i16 = i15 - i9;
            int i17 = i16 * i16 * (i5 - i15) * (i6 - iArr[i15]);
            if (i17 > i14) {
                i = i15;
            } else {
                i17 = i14;
                i = i13;
            }
            i15--;
            i13 = i;
            i14 = i17;
        }
        return i13 << 3;
    }

    private void a(int i) {
        if (this.f5468b.length < i) {
            this.f5468b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f5469c[i2] = 0;
        }
    }

    @Override // com.google.b.b
    public com.google.b.b a(com.google.b.g gVar) {
        return new h(gVar);
    }

    @Override // com.google.b.b
    public a a(int i, a aVar) throws com.google.b.i {
        int i2 = 1;
        com.google.b.g gVarA = a();
        int iB = gVarA.b();
        if (aVar == null || aVar.a() < iB) {
            aVar = new a(iB);
        } else {
            aVar.b();
        }
        a(iB);
        byte[] bArrA = gVarA.a(i, this.f5468b);
        int[] iArr = this.f5469c;
        for (int i3 = 0; i3 < iB; i3++) {
            int i4 = (bArrA[i3] & Constants.UNKNOWN) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int iA = a(iArr);
        int i5 = bArrA[0] & Constants.UNKNOWN;
        int i6 = bArrA[1] & Constants.UNKNOWN;
        int i7 = i5;
        while (i2 < iB - 1) {
            int i8 = bArrA[i2 + 1] & Constants.UNKNOWN;
            if ((((i6 * 4) - i7) - i8) / 2 < iA) {
                aVar.b(i2);
            }
            i2++;
            i7 = i6;
            i6 = i8;
        }
        return aVar;
    }

    @Override // com.google.b.b
    public b b() throws com.google.b.i {
        com.google.b.g gVarA = a();
        int iB = gVarA.b();
        int iC = gVarA.c();
        b bVar = new b(iB, iC);
        a(iB);
        int[] iArr = this.f5469c;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            byte[] bArrA = gVarA.a((iC * i2) / 5, this.f5468b);
            int i3 = (iB * 4) / 5;
            for (int i4 = iB / 5; i4 < i3; i4++) {
                int i5 = (bArrA[i4] & Constants.UNKNOWN) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
            i = i2 + 1;
        }
        int iA = a(iArr);
        byte[] bArrA2 = gVarA.a();
        for (int i6 = 0; i6 < iC; i6++) {
            int i7 = i6 * iB;
            for (int i8 = 0; i8 < iB; i8++) {
                if ((bArrA2[i7 + i8] & Constants.UNKNOWN) < iA) {
                    bVar.b(i8, i6);
                }
            }
        }
        return bVar;
    }
}
