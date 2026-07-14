package com.google.b.g.a;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static int a(int i, int i2) {
        int i3;
        int i4 = 1;
        if (i - i2 > i2) {
            i3 = i - i2;
        } else {
            i3 = i2;
            i2 = i - i2;
        }
        int i5 = 1;
        while (i > i3) {
            i5 *= i;
            if (i4 <= i2) {
                i5 /= i4;
                i4++;
            }
            i--;
        }
        int i6 = i5;
        while (i4 <= i2) {
            i6 /= i4;
            i4++;
        }
        return i6;
    }

    public static int a(int[] iArr, int i, boolean z) {
        int length = iArr.length;
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            int i4 = iArr[i2] + i3;
            i2++;
            i3 = i4;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = i3;
        int i8 = 0;
        while (i5 < length - 1) {
            int i9 = i6;
            int i10 = i8 | (1 << i5);
            int i11 = 1;
            while (i11 < iArr[i5]) {
                int iA = a((i7 - i11) - 1, (length - i5) - 2);
                if (z && i10 == 0 && (i7 - i11) - ((length - i5) - 1) >= (length - i5) - 1) {
                    iA -= a((i7 - i11) - (length - i5), (length - i5) - 2);
                }
                if ((length - i5) - 1 > 1) {
                    int iA2 = 0;
                    for (int i12 = (i7 - i11) - ((length - i5) - 2); i12 > i; i12--) {
                        iA2 += a(((i7 - i11) - i12) - 1, (length - i5) - 3);
                    }
                    iA -= ((length - 1) - i5) * iA2;
                } else if (i7 - i11 > i) {
                    iA--;
                }
                i9 += iA;
                i11++;
                i10 &= (1 << i5) ^ (-1);
            }
            i5++;
            i7 -= i11;
            i8 = i10;
            i6 = i9;
        }
        return i6;
    }
}
