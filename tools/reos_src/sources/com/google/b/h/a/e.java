package com.google.b.h.a;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5681a = {';', '<', '>', '@', '[', '\\', ']', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', '.', '$', '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f5682b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', '\r', '\t', ',', ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Charset f5683c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger[] f5684d = new BigInteger[16];

    private enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        f5684d[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        f5684d[1] = bigIntegerValueOf;
        for (int i = 2; i < f5684d.length; i++) {
            f5684d[i] = f5684d[i - 1].multiply(bigIntegerValueOf);
        }
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i == 901) {
            int i3 = 0;
            long j = 0;
            int[] iArr2 = new int[6];
            boolean z = false;
            int i4 = iArr[i2];
            int i5 = i2 + 1;
            while (i5 < iArr[0] && !z) {
                int i6 = i3 + 1;
                iArr2[i3] = i4;
                j = (j * 900) + ((long) i4);
                int i7 = i5 + 1;
                i4 = iArr[i5];
                if (i4 == 900 || i4 == 901 || i4 == 902 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922) {
                    z = true;
                    i5 = i7 - 1;
                    i3 = i6;
                } else if (i6 % 5 != 0 || i6 <= 0) {
                    i3 = i6;
                    i5 = i7;
                } else {
                    for (int i8 = 0; i8 < 6; i8++) {
                        byteArrayOutputStream.write((byte) (j >> ((5 - i8) * 8)));
                    }
                    j = 0;
                    i3 = 0;
                    i5 = i7;
                }
            }
            if (i5 == iArr[0] && i4 < 900) {
                iArr2[i3] = i4;
                i3++;
            }
            for (int i9 = 0; i9 < i3; i9++) {
                byteArrayOutputStream.write((byte) iArr2[i9]);
            }
            i2 = i5;
        } else if (i == 924) {
            int i10 = 0;
            long j2 = 0;
            boolean z2 = false;
            while (i2 < iArr[0] && !z2) {
                int i11 = i2 + 1;
                int i12 = iArr[i2];
                if (i12 < 900) {
                    i10++;
                    j2 = (j2 * 900) + ((long) i12);
                    i2 = i11;
                } else if (i12 == 900 || i12 == 901 || i12 == 902 || i12 == 924 || i12 == 928 || i12 == 923 || i12 == 922) {
                    i2 = i11 - 1;
                    z2 = true;
                } else {
                    i2 = i11;
                }
                if (i10 % 5 == 0 && i10 > 0) {
                    for (int i13 = 0; i13 < 6; i13++) {
                        byteArrayOutputStream.write((byte) (j2 >> ((5 - i13) * 8)));
                    }
                    j2 = 0;
                    i10 = 0;
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i2;
    }

    private static int a(int[] iArr, int i, com.google.b.h.c cVar) throws com.google.b.f {
        if (i + 2 > iArr[0]) {
            throw com.google.b.f.a();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        cVar.a(Integer.parseInt(a(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iA = a(iArr, i, sb);
        cVar.a(sb.toString());
        if (iArr[iA] != 923) {
            if (iArr[iA] != 922) {
                return iA;
            }
            cVar.a(true);
            return iA + 1;
        }
        int i3 = iA + 1;
        int[] iArr3 = new int[iArr[0] - i3];
        int i4 = 0;
        int i5 = i3;
        boolean z = false;
        while (i5 < iArr[0] && !z) {
            int i6 = i5 + 1;
            int i7 = iArr[i5];
            if (i7 < 900) {
                iArr3[i4] = i7;
                i4++;
                i5 = i6;
            } else {
                switch (i7) {
                    case 922:
                        cVar.a(true);
                        i5 = i6 + 1;
                        z = true;
                        break;
                    default:
                        throw com.google.b.f.a();
                }
            }
        }
        cVar.a(Arrays.copyOf(iArr3, i4));
        return i5;
    }

    private static int a(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) * 2];
        int[] iArr3 = new int[(iArr[0] - i) * 2];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 >= 900) {
                switch (i4) {
                    case 900:
                        iArr2[i2] = 900;
                        i2++;
                        i = i3;
                        break;
                    case 901:
                    case 902:
                    case 922:
                    case 923:
                    case 924:
                    case 928:
                        i = i3 - 1;
                        z = true;
                        break;
                    case 913:
                        iArr2[i2] = 913;
                        i = i3 + 1;
                        iArr3[i2] = iArr[i3];
                        i2++;
                        break;
                    default:
                        i = i3;
                        break;
                }
            } else {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
                i = i3;
            }
        }
        a(iArr2, iArr3, i2, sb);
        return i;
    }

    static com.google.b.c.e a(int[] iArr, String str) throws com.google.b.f {
        int iA;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charsetForName = f5683c;
        int i = 2;
        int i2 = iArr[1];
        com.google.b.h.c cVar = new com.google.b.h.c();
        while (i < iArr[0]) {
            switch (i2) {
                case 900:
                    iA = a(iArr, i, sb);
                    break;
                case 901:
                case 924:
                    iA = a(i2, iArr, charsetForName, i, sb);
                    break;
                case 902:
                    iA = b(iArr, i, sb);
                    break;
                case 913:
                    iA = i + 1;
                    sb.append((char) iArr[i]);
                    break;
                case 922:
                case 923:
                    throw com.google.b.f.a();
                case 925:
                    iA = i + 1;
                    break;
                case 926:
                    iA = i + 2;
                    break;
                case 927:
                    iA = i + 1;
                    charsetForName = Charset.forName(com.google.b.c.d.a(iArr[i]).name());
                    break;
                case 928:
                    iA = a(iArr, i, cVar);
                    break;
                default:
                    iA = a(iArr, i - 1, sb);
                    break;
            }
            if (iA >= iArr.length) {
                throw com.google.b.f.a();
            }
            i = iA + 1;
            i2 = iArr[iA];
        }
        if (sb.length() == 0) {
            throw com.google.b.f.a();
        }
        com.google.b.c.e eVar = new com.google.b.c.e(null, sb.toString(), null, str);
        eVar.a(cVar);
        return eVar;
    }

    private static String a(int[] iArr, int i) throws com.google.b.f {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(f5684d[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) != '1') {
            throw com.google.b.f.a();
        }
        return string.substring(1);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0147  */
    private static void a(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        a aVar = a.ALPHA;
        a aVar2 = a.ALPHA;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            char c2 = 0;
            switch (aVar) {
                case ALPHA:
                    if (i3 < 26) {
                        c2 = (char) (i3 + 65);
                    } else if (i3 == 26) {
                        c2 = ' ';
                    } else if (i3 == 27) {
                        aVar = a.LOWER;
                    } else if (i3 == 28) {
                        aVar = a.MIXED;
                    } else if (i3 == 29) {
                        a aVar3 = aVar;
                        aVar = a.PUNCT_SHIFT;
                        aVar2 = aVar3;
                    } else if (i3 == 913) {
                        sb.append((char) iArr2[i2]);
                    } else if (i3 == 900) {
                        aVar = a.ALPHA;
                    }
                    break;
                case LOWER:
                    if (i3 < 26) {
                        c2 = (char) (i3 + 97);
                    } else if (i3 == 26) {
                        c2 = ' ';
                    } else if (i3 == 27) {
                        a aVar4 = aVar;
                        aVar = a.ALPHA_SHIFT;
                        aVar2 = aVar4;
                    } else if (i3 == 28) {
                        aVar = a.MIXED;
                    } else if (i3 == 29) {
                        a aVar5 = aVar;
                        aVar = a.PUNCT_SHIFT;
                        aVar2 = aVar5;
                    } else if (i3 == 913) {
                        sb.append((char) iArr2[i2]);
                    } else if (i3 == 900) {
                        aVar = a.ALPHA;
                    }
                    break;
                case MIXED:
                    if (i3 < 25) {
                        c2 = f5682b[i3];
                    } else if (i3 == 25) {
                        aVar = a.PUNCT;
                    } else if (i3 == 26) {
                        c2 = ' ';
                    } else if (i3 == 27) {
                        aVar = a.LOWER;
                    } else if (i3 == 28) {
                        aVar = a.ALPHA;
                    } else if (i3 == 29) {
                        a aVar6 = aVar;
                        aVar = a.PUNCT_SHIFT;
                        aVar2 = aVar6;
                    } else if (i3 == 913) {
                        sb.append((char) iArr2[i2]);
                    } else if (i3 == 900) {
                        aVar = a.ALPHA;
                    }
                    break;
                case PUNCT:
                    if (i3 < 29) {
                        c2 = f5681a[i3];
                    } else if (i3 == 29) {
                        aVar = a.ALPHA;
                    } else if (i3 == 913) {
                        sb.append((char) iArr2[i2]);
                    } else if (i3 == 900) {
                        aVar = a.ALPHA;
                    }
                    break;
                case ALPHA_SHIFT:
                    if (i3 < 26) {
                        c2 = (char) (i3 + 65);
                        aVar = aVar2;
                    } else if (i3 == 26) {
                        c2 = ' ';
                        aVar = aVar2;
                    } else if (i3 == 900) {
                        aVar = a.ALPHA;
                    } else {
                        aVar = aVar2;
                    }
                    break;
                case PUNCT_SHIFT:
                    if (i3 < 29) {
                        c2 = f5681a[i3];
                        aVar = aVar2;
                    } else if (i3 == 29) {
                        aVar = a.ALPHA;
                    } else if (i3 == 913) {
                        sb.append((char) iArr2[i2]);
                        aVar = aVar2;
                    } else if (i3 == 900) {
                        aVar = a.ALPHA;
                    } else {
                        aVar = aVar2;
                    }
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    private static int b(int[] iArr, int i, StringBuilder sb) throws com.google.b.f {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
                i = i3;
            } else if (i4 == 900 || i4 == 901 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922) {
                i = i3 - 1;
                z = true;
            } else {
                i = i3;
            }
            if (i2 % 15 == 0 || i4 == 902 || z) {
                if (i2 > 0) {
                    sb.append(a(iArr2, i2));
                    i2 = 0;
                }
            }
        }
        return i;
    }
}
