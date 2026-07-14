package com.google.b.g;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f5634a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f5635b = new StringBuilder();

    m() {
    }

    private static Map<com.google.b.n, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(com.google.b.n.class);
        enumMap.put(com.google.b.n.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    int a(com.google.b.c.a aVar, int[] iArr, StringBuilder sb) throws com.google.b.i {
        int[] iArr2 = this.f5634a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iA = aVar.a();
        int iD = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 2 && iD < iA; i2++) {
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
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iD = aVar.d(aVar.c(iD));
            }
        }
        if (sb.length() != 2) {
            throw com.google.b.i.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 != i) {
            throw com.google.b.i.a();
        }
        return iD;
    }

    com.google.b.m a(int i, com.google.b.c.a aVar, int[] iArr) throws com.google.b.i {
        StringBuilder sb = this.f5635b;
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
