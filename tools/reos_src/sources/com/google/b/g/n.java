package com.google.b.g;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5636a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5637b = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f5638c = new StringBuilder();

    n() {
    }

    private static int a(int i) throws com.google.b.i {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f5636a[i2]) {
                return i2;
            }
        }
        throw com.google.b.i.a();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static Map<com.google.b.n, Object> a(String str) {
        String strB;
        if (str.length() != 5 || (strB = b(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(com.google.b.n.class);
        enumMap.put(com.google.b.n.SUGGESTED_PRICE, strB);
        return enumMap;
    }

    private static String b(String str) {
        String str2;
        switch (str.charAt(0)) {
            case '0':
                str2 = "£";
                break;
            case '5':
                str2 = "$";
                break;
            case '9':
                if ("90000".equals(str)) {
                    return null;
                }
                if ("99991".equals(str)) {
                    return "0.00";
                }
                if ("99990".equals(str)) {
                    return "Used";
                }
                str2 = "";
                break;
            default:
                str2 = "";
                break;
        }
        int i = Integer.parseInt(str.substring(1));
        String strValueOf = String.valueOf(i / 100);
        int i2 = i % 100;
        return str2 + strValueOf + '.' + (i2 < 10 ? "0" + i2 : String.valueOf(i2));
    }

    int a(com.google.b.c.a aVar, int[] iArr, StringBuilder sb) throws com.google.b.i {
        int[] iArr2 = this.f5637b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iA = aVar.a();
        int iD = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && iD < iA; i2++) {
            int iA2 = p.a(aVar, iArr2, iD, p.f5645e);
            sb.append((char) ((iA2 % 10) + 48));
            int length = iArr2.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr2[i3] + iD;
                i3++;
                iD = i4;
            }
            if (iA2 >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iD = aVar.d(aVar.c(iD));
            }
        }
        if (sb.length() != 5) {
            throw com.google.b.i.a();
        }
        if (a((CharSequence) sb.toString()) != a(i)) {
            throw com.google.b.i.a();
        }
        return iD;
    }

    com.google.b.m a(int i, com.google.b.c.a aVar, int[] iArr) throws com.google.b.i {
        StringBuilder sb = this.f5638c;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<com.google.b.n, Object> mapA = a(string);
        com.google.b.m mVar = new com.google.b.m(string, null, new com.google.b.o[]{new com.google.b.o((iArr[0] + iArr[1]) / 2.0f, i), new com.google.b.o(iA, i)}, com.google.b.a.UPC_EAN_EXTENSION);
        if (mapA != null) {
            mVar.a(mapA);
        }
        return mVar;
    }
}
