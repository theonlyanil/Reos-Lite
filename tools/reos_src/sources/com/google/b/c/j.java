package com.google.b.c;

import com.flurry.android.Constants;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public final class j extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f5471a;

    public j(com.google.b.g gVar) {
        super(gVar);
    }

    private static int a(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bVar.b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, b bVar) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i8 << 3;
                int i10 = i3 - 8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int iA = a(i8, 2, i - 3);
                int iA2 = a(i5, 2, i2 - 3);
                int i11 = 0;
                for (int i12 = -2; i12 <= 2; i12++) {
                    int[] iArr2 = iArr[iA2 + i12];
                    i11 += iArr2[iA + 2] + iArr2[iA - 2] + iArr2[iA - 1] + iArr2[iA] + iArr2[iA + 1];
                }
                a(bArr, i10, i7, i11 / 25, i3, bVar);
            }
        }
    }

    private static int[][] a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i2, i);
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = i8 << 3;
            int i10 = i4 - 8;
            if (i9 <= i10) {
                i10 = i9;
            }
            for (int i11 = 0; i11 < i; i11++) {
                int i12 = i11 << 3;
                int i13 = i3 - 8;
                if (i12 <= i13) {
                    i13 = i12;
                }
                int i14 = 0;
                int i15 = 255;
                int i16 = 0;
                int i17 = 0;
                int i18 = (i10 * i3) + i13;
                while (i17 < 8) {
                    int i19 = 0;
                    while (i19 < 8) {
                        int i20 = bArr[i18 + i19] & Constants.UNKNOWN;
                        int i21 = i14 + i20;
                        int i22 = i20 < i15 ? i20 : i15;
                        if (i20 <= i16) {
                            i20 = i16;
                        }
                        i19++;
                        i15 = i22;
                        i16 = i20;
                        i14 = i21;
                    }
                    if (i16 - i15 > 24) {
                        i5 = i18 + i3;
                        i6 = i17 + 1;
                        while (true) {
                            i7 = i14;
                            if (i6 < 8) {
                                i14 = i7;
                                for (int i23 = 0; i23 < 8; i23++) {
                                    i14 += bArr[i5 + i23] & Constants.UNKNOWN;
                                }
                                i6++;
                                i5 += i3;
                            }
                        }
                    } else {
                        i5 = i18;
                        i6 = i17;
                        i7 = i14;
                    }
                    int i24 = i6 + 1;
                    i18 = i5 + i3;
                    i14 = i7;
                    i17 = i24;
                }
                int i25 = i14 >> 6;
                if (i16 - i15 <= 24) {
                    int i26 = i15 / 2;
                    if (i8 <= 0 || i11 <= 0 || i15 >= (i25 = ((iArr[i8 - 1][i11] + (iArr[i8][i11 - 1] * 2)) + iArr[i8 - 1][i11 - 1]) / 4)) {
                        i25 = i26;
                    }
                }
                iArr[i8][i11] = i25;
            }
        }
        return iArr;
    }

    @Override // com.google.b.c.h, com.google.b.b
    public com.google.b.b a(com.google.b.g gVar) {
        return new j(gVar);
    }

    @Override // com.google.b.c.h, com.google.b.b
    public b b() throws com.google.b.i {
        if (this.f5471a != null) {
            return this.f5471a;
        }
        com.google.b.g gVarA = a();
        int iB = gVarA.b();
        int iC = gVarA.c();
        if (iB < 40 || iC < 40) {
            this.f5471a = super.b();
        } else {
            byte[] bArrA = gVarA.a();
            int i = iB >> 3;
            if ((iB & 7) != 0) {
                i++;
            }
            int i2 = iC >> 3;
            if ((iC & 7) != 0) {
                i2++;
            }
            int[][] iArrA = a(bArrA, i, i2, iB, iC);
            b bVar = new b(iB, iC);
            a(bArrA, i, i2, iB, iC, iArrA, bVar);
            this.f5471a = bVar;
        }
        return this.f5471a;
    }
}
