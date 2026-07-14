package com.google.b.f.a;

import com.google.b.c.e;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final NumberFormat f5538a = new DecimalFormat("000000000");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final NumberFormat f5539b = new DecimalFormat("000");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f5540c = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private static int a(int i, byte[] bArr) {
        int i2 = i - 1;
        return ((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0 ? 0 : 1;
    }

    private static int a(byte[] bArr) {
        return a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int iA = 0;
        for (int i = 0; i < bArr2.length; i++) {
            iA += a(bArr2[i], bArr) << ((bArr2.length - i) - 1);
        }
        return iA;
    }

    static e a(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(144);
        switch (i) {
            case 2:
            case 3:
                String strE = i == 2 ? new DecimalFormat("0000000000".substring(0, c(bArr))).format(d(bArr)) : e(bArr);
                String str = f5539b.format(a(bArr));
                String str2 = f5539b.format(b(bArr));
                sb.append(a(bArr, 10, 84));
                if (!sb.toString().startsWith("[)>\u001e01\u001d")) {
                    sb.insert(0, strE + (char) 29 + str + (char) 29 + str2 + (char) 29);
                } else {
                    sb.insert(9, strE + (char) 29 + str + (char) 29 + str2 + (char) 29);
                }
                break;
            case 4:
                sb.append(a(bArr, 1, 93));
                break;
            case 5:
                sb.append(a(bArr, 1, 77));
                break;
        }
        return new e(bArr, sb.toString(), null, String.valueOf(i));
    }

    private static String a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        StringBuilder sb = new StringBuilder();
        int i5 = i;
        int i6 = 0;
        int i7 = 0;
        int i8 = -1;
        while (i5 < i + i2) {
            char cCharAt = f5540c[i7].charAt(bArr[i5]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i8 = 1;
                    int i9 = i7;
                    i3 = i5;
                    i4 = cCharAt - 65520;
                    i6 = i9;
                    break;
                case 65525:
                    i8 = 2;
                    i6 = i7;
                    i3 = i5;
                    i4 = 0;
                    break;
                case 65526:
                    i8 = 3;
                    i6 = i7;
                    i3 = i5;
                    i4 = 0;
                    break;
                case 65527:
                    i3 = i5;
                    i8 = -1;
                    i4 = 0;
                    break;
                case 65528:
                    i3 = i5;
                    i8 = -1;
                    i4 = 1;
                    break;
                case 65529:
                    i8 = -1;
                    int i10 = i7;
                    i3 = i5;
                    i4 = i10;
                    break;
                case 65530:
                default:
                    sb.append(cCharAt);
                    int i11 = i5;
                    i4 = i7;
                    i3 = i11;
                    break;
                case 65531:
                    int i12 = i5 + 1;
                    int i13 = bArr[i12] << 24;
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 18);
                    int i16 = i14 + 1;
                    int i17 = i15 + (bArr[i16] << 12);
                    int i18 = i16 + 1;
                    int i19 = i17 + (bArr[i18] << 6);
                    int i20 = i18 + 1;
                    sb.append(f5538a.format(i19 + bArr[i20]));
                    i4 = i7;
                    i3 = i20;
                    break;
            }
            int i21 = i8 - 1;
            if (i8 == 0) {
                i4 = i6;
            }
            i8 = i21;
            int i22 = i4;
            i5 = i3 + 1;
            i7 = i22;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int b(byte[] bArr) {
        return a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    private static int c(byte[] bArr) {
        return a(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static int d(byte[] bArr) {
        return a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static String e(byte[] bArr) {
        return String.valueOf(new char[]{f5540c[0].charAt(a(bArr, new byte[]{39, 40, 41, 42, 31, 32})), f5540c[0].charAt(a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), f5540c[0].charAt(a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), f5540c[0].charAt(a(bArr, new byte[]{21, 22, 23, 24, 13, 14})), f5540c[0].charAt(a(bArr, new byte[]{15, 16, 17, 18, 7, 8})), f5540c[0].charAt(a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }
}
