package com.google.b.g;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5616a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5617b = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5618c = f5617b[47];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StringBuilder f5619d = new StringBuilder(20);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f5620e = new int[6];

    private static char a(int i) throws com.google.b.i {
        for (int i2 = 0; i2 < f5617b.length; i2++) {
            if (f5617b[i2] == i) {
                return f5616a[i2];
            }
        }
        throw com.google.b.i.a();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int length2 = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3 = iArr[i] + i2;
            i++;
            i2 = i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int iRound = Math.round((iArr[i5] * 9.0f) / i2);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                int i6 = 0;
                while (i6 < iRound) {
                    i6++;
                    i4 = (i4 << 1) | 1;
                }
            } else {
                i4 <<= iRound;
            }
        }
        return i4;
    }

    private static String a(CharSequence charSequence) throws com.google.b.f {
        int i;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 'a' || cCharAt > 'd') {
                sb.append(cCharAt);
                i = i2;
            } else {
                if (i2 >= length - 1) {
                    throw com.google.b.f.a();
                }
                char cCharAt2 = charSequence.charAt(i2 + 1);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.google.b.f.a();
                        }
                        c2 = (char) (cCharAt2 - '@');
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            c2 = (char) (cCharAt2 - '&');
                        } else {
                            if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                                throw com.google.b.f.a();
                            }
                            c2 = (char) (cCharAt2 - 11);
                        }
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            c2 = (char) (cCharAt2 - ' ');
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw com.google.b.f.a();
                            }
                            c2 = ':';
                        }
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.google.b.f.a();
                        }
                        c2 = (char) (cCharAt2 + ' ');
                        break;
                    default:
                        c2 = 0;
                        break;
                }
                sb.append(c2);
                i = i2 + 1;
            }
            i2 = i + 1;
        }
        return sb.toString();
    }

    private static void a(CharSequence charSequence, int i, int i2) throws com.google.b.d {
        int i3 = 1;
        int i4 = i - 1;
        int i5 = 0;
        while (i4 >= 0) {
            int iIndexOf = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3) + i5;
            int i6 = i3 + 1;
            if (i6 > i2) {
                i6 = 1;
            }
            i4--;
            i3 = i6;
            i5 = iIndexOf;
        }
        if (charSequence.charAt(i) != f5616a[i5 % 47]) {
            throw com.google.b.d.a();
        }
    }

    private int[] a(com.google.b.c.a aVar) throws com.google.b.i {
        int iA = aVar.a();
        int iC = aVar.c(0);
        Arrays.fill(this.f5620e, 0);
        int[] iArr = this.f5620e;
        int length = iArr.length;
        boolean z = false;
        int i = iC;
        int i2 = 0;
        for (int i3 = iC; i3 < iA; i3++) {
            if (aVar.a(i3) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (a(iArr) == f5618c) {
                        return new int[]{i, i3};
                    }
                    i += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
        }
        throw com.google.b.i.a();
    }

    private static void b(CharSequence charSequence) throws com.google.b.d {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    @Override // com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f, com.google.b.d {
        int[] iArrA = a(aVar);
        int iC = aVar.c(iArrA[1]);
        int iA = aVar.a();
        int[] iArr = this.f5620e;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f5619d;
        sb.setLength(0);
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
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (iC2 == iA || !aVar.a(iC2)) {
                    throw com.google.b.i.a();
                }
                if (sb.length() < 2) {
                    throw com.google.b.i.a();
                }
                b(sb);
                sb.setLength(sb.length() - 2);
                return new com.google.b.m(a(sb), null, new com.google.b.o[]{new com.google.b.o((iArrA[1] + iArrA[0]) / 2.0f, i), new com.google.b.o(iC + (i4 / 2.0f), i)}, com.google.b.a.CODE_93);
            }
            iC = iC2;
        }
    }
}
