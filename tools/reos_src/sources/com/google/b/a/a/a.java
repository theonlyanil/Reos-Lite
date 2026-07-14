package com.google.b.a.a;

import com.google.b.c.b;
import com.google.b.c.b.c;
import com.google.b.c.b.d;
import com.google.b.c.e;
import com.google.b.f;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f5373a = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f5374b = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f5375c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f5376d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f5377e = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.google.b.a.a f5378f;

    /* JADX INFO: renamed from: com.google.b.a.a.a$a, reason: collision with other inner class name */
    private enum EnumC0199a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static EnumC0199a a(char c2) {
        switch (c2) {
            case 'B':
                return EnumC0199a.BINARY;
            case 'D':
                return EnumC0199a.DIGIT;
            case 'L':
                return EnumC0199a.LOWER;
            case 'M':
                return EnumC0199a.MIXED;
            case 'P':
                return EnumC0199a.PUNCT;
            default:
                return EnumC0199a.UPPER;
        }
    }

    private static String a(EnumC0199a enumC0199a, int i) {
        switch (enumC0199a) {
            case UPPER:
                return f5373a[i];
            case LOWER:
                return f5374b[i];
            case MIXED:
                return f5375c[i];
            case PUNCT:
                return f5376d[i];
            case DIGIT:
                return f5377e[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private static String a(boolean[] zArr) {
        int i;
        EnumC0199a enumC0199aA;
        int length = zArr.length;
        EnumC0199a enumC0199a = EnumC0199a.UPPER;
        EnumC0199a enumC0199a2 = EnumC0199a.UPPER;
        StringBuilder sb = new StringBuilder(20);
        int i2 = 0;
        EnumC0199a enumC0199a3 = enumC0199a2;
        EnumC0199a enumC0199a4 = enumC0199a;
        while (i2 < length) {
            if (enumC0199a3 != EnumC0199a.BINARY) {
                int i3 = enumC0199a3 == EnumC0199a.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int iA = a(zArr, i2, i3);
                i2 += i3;
                String strA = a(enumC0199a3, iA);
                if (strA.startsWith("CTRL_")) {
                    enumC0199aA = a(strA.charAt(5));
                    if (strA.charAt(6) == 'L') {
                        enumC0199a4 = enumC0199aA;
                    }
                } else {
                    sb.append(strA);
                    enumC0199aA = enumC0199a4;
                }
                enumC0199a3 = enumC0199aA;
            } else {
                if (length - i2 < 5) {
                    break;
                }
                int iA2 = a(zArr, i2, 5);
                int i4 = i2 + 5;
                if (iA2 == 0) {
                    if (length - i4 < 11) {
                        break;
                    }
                    iA2 = a(zArr, i4, 11) + 31;
                    i4 += 11;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= iA2) {
                        i = i4;
                        break;
                    }
                    if (length - i4 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) a(zArr, i4, 8));
                    i5++;
                    i4 += 8;
                }
                i2 = i;
                enumC0199a3 = enumC0199a4;
            }
        }
        return sb.toString();
    }

    private boolean[] b(boolean[] zArr) throws f {
        com.google.b.c.b.a aVar;
        int i;
        int i2 = 8;
        if (this.f5378f.a() <= 2) {
            i2 = 6;
            aVar = com.google.b.c.b.a.f5443c;
        } else if (this.f5378f.a() <= 8) {
            aVar = com.google.b.c.b.a.g;
        } else if (this.f5378f.a() <= 22) {
            i2 = 10;
            aVar = com.google.b.c.b.a.f5442b;
        } else {
            i2 = 12;
            aVar = com.google.b.c.b.a.f5441a;
        }
        int iB = this.f5378f.b();
        int length = zArr.length / i2;
        if (length < iB) {
            throw f.a();
        }
        int i3 = length - iB;
        int[] iArr = new int[length];
        int length2 = zArr.length % i2;
        int i4 = 0;
        while (i4 < length) {
            iArr[i4] = a(zArr, length2, i2);
            i4++;
            length2 += i2;
        }
        try {
            new c(aVar).a(iArr, i3);
            int i5 = (1 << i2) - 1;
            int i6 = 0;
            for (int i7 = 0; i7 < iB; i7++) {
                int i8 = iArr[i7];
                if (i8 == 0 || i8 == i5) {
                    throw f.a();
                }
                if (i8 == 1 || i8 == i5 - 1) {
                    i6++;
                }
            }
            boolean[] zArr2 = new boolean[(iB * i2) - i6];
            int i9 = 0;
            int i10 = 0;
            while (i9 < iB) {
                int i11 = iArr[i9];
                if (i11 == 1 || i11 == i5 - 1) {
                    Arrays.fill(zArr2, i10, (i10 + i2) - 1, i11 > 1);
                    i = (i2 - 1) + i10;
                } else {
                    int i12 = i2 - 1;
                    while (i12 >= 0) {
                        int i13 = i10 + 1;
                        zArr2[i10] = ((1 << i12) & i11) != 0;
                        i12--;
                        i10 = i13;
                    }
                    i = i10;
                }
                i9++;
                i10 = i;
            }
            return zArr2;
        } catch (d e2) {
            throw f.a(e2);
        }
    }

    public e a(com.google.b.a.a aVar) throws f {
        this.f5378f = aVar;
        return new e(null, a(b(a(aVar.d()))), null, null);
    }

    boolean[] a(b bVar) {
        boolean zC = this.f5378f.c();
        int iA = this.f5378f.a();
        int i = zC ? (iA * 4) + 11 : (iA * 4) + 14;
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[a(iA, zC)];
        if (zC) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = i2;
            }
        } else {
            int i3 = i / 2;
            int i4 = ((i + 1) + ((((i / 2) - 1) / 15) * 2)) / 2;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = (i5 / 15) + i5;
                iArr[(i3 - i5) - 1] = (i4 - i6) - 1;
                iArr[i3 + i5] = i6 + i4 + 1;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < iA; i8++) {
            int i9 = zC ? ((iA - i8) * 4) + 9 : ((iA - i8) * 4) + 12;
            int i10 = i8 * 2;
            int i11 = (i - 1) - i10;
            for (int i12 = 0; i12 < i9; i12++) {
                int i13 = i12 * 2;
                for (int i14 = 0; i14 < 2; i14++) {
                    zArr[i7 + i13 + i14] = bVar.a(iArr[i10 + i14], iArr[i10 + i12]);
                    zArr[(i9 * 2) + i7 + i13 + i14] = bVar.a(iArr[i10 + i12], iArr[i11 - i14]);
                    zArr[(i9 * 4) + i7 + i13 + i14] = bVar.a(iArr[i11 - i14], iArr[i11 - i12]);
                    zArr[(i9 * 6) + i7 + i13 + i14] = bVar.a(iArr[i11 - i12], iArr[i10 + i14]);
                }
            }
            i7 = (i9 * 8) + i7;
        }
        return zArr;
    }
}
