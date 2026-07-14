package com.google.b.g;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f5614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StringBuilder f5615f;
    private final int[] g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f5611b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f5610a = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5612c = f5610a[39];

    public c() {
        this(false);
    }

    public c(boolean z) {
        this(z, false);
    }

    public c(boolean z, boolean z2) {
        this.f5613d = z;
        this.f5614e = z2;
        this.f5615f = new StringBuilder(20);
        this.g = new int[9];
    }

    private static char a(int i) throws com.google.b.i {
        for (int i2 = 0; i2 < f5610a.length; i2++) {
            if (f5610a[i2] == i) {
                return f5611b[i2];
            }
        }
        throw com.google.b.i.a();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i4 |= 1 << ((length - 1) - i7);
                    i6++;
                    i5 += i8;
                }
            }
            if (i6 == 3) {
                int i9 = i6;
                for (int i10 = 0; i10 < length && i9 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i2) {
                        i9--;
                        if (i11 * 2 >= i5) {
                            return -1;
                        }
                    }
                }
                return i4;
            }
            if (i6 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    private static String a(CharSequence charSequence) throws com.google.b.f {
        char c2;
        int i;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                char cCharAt2 = charSequence.charAt(i2 + 1);
                switch (cCharAt) {
                    case '$':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.google.b.f.a();
                        }
                        c2 = (char) (cCharAt2 - '@');
                        break;
                    case '%':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            c2 = (char) (cCharAt2 - '&');
                        } else {
                            if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                                throw com.google.b.f.a();
                            }
                            c2 = (char) (cCharAt2 - 11);
                        }
                        break;
                    case '+':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.google.b.f.a();
                        }
                        c2 = (char) (cCharAt2 + ' ');
                        break;
                    case '/':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            c2 = (char) (cCharAt2 - ' ');
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw com.google.b.f.a();
                            }
                            c2 = ':';
                        }
                        break;
                    default:
                        c2 = 0;
                        break;
                }
                sb.append(c2);
                i = i2 + 1;
            } else {
                sb.append(cCharAt);
                i = i2;
            }
            i2 = i + 1;
        }
        return sb.toString();
    }

    private static int[] a(com.google.b.c.a aVar, int[] iArr) throws com.google.b.i {
        int iA = aVar.a();
        int iC = aVar.c(0);
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        for (int i2 = iC; i2 < iA; i2++) {
            if (aVar.a(i2) ^ z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else {
                    if (a(iArr) == f5612c && aVar.a(Math.max(0, iC - ((i2 - iC) / 2)), iC, false)) {
                        return new int[]{iC, i2};
                    }
                    iC += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
        }
        throw com.google.b.i.a();
    }

    @Override // com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f, com.google.b.d {
        int[] iArr = this.g;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f5615f;
        sb.setLength(0);
        int[] iArrA = a(aVar, iArr);
        int iC = aVar.c(iArrA[1]);
        int iA = aVar.a();
        while (true) {
            a(aVar, iC, iArr);
            int iA2 = a(iArr);
            if (iA2 < 0) {
                throw com.google.b.i.a();
            }
            char cA = a(iA2);
            sb.append(cA);
            int i2 = iC;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iC2 = aVar.c(i2);
            if (cA == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (iC2 - iC) - i4;
                if (iC2 != iA && i6 * 2 < i4) {
                    throw com.google.b.i.a();
                }
                if (this.f5613d) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(this.f5615f.charAt(i7));
                    }
                    if (sb.charAt(length) != f5611b[iIndexOf % 43]) {
                        throw com.google.b.d.a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw com.google.b.i.a();
                }
                return new com.google.b.m(this.f5614e ? a(sb) : sb.toString(), null, new com.google.b.o[]{new com.google.b.o((iArrA[1] + iArrA[0]) / 2.0f, i), new com.google.b.o(iC + (i4 / 2.0f), i)}, com.google.b.a.CODE_39);
            }
            iC = iC2;
        }
    }
}
