package com.google.b.g;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f5642b = {1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f5643c = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[][] f5644d = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[][] f5645e = new int[20][];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f5646a = new StringBuilder(20);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final o f5647f = new o();
    private final g g = new g();

    static {
        int i = 10;
        System.arraycopy(f5644d, 0, f5645e, 0, 10);
        while (true) {
            int i2 = i;
            if (i2 >= 20) {
                return;
            }
            int[] iArr = f5644d[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            f5645e[i2] = iArr2;
            i = i2 + 1;
        }
    }

    protected p() {
    }

    static int a(com.google.b.c.a aVar, int[] iArr, int i, int[][] iArr2) throws com.google.b.i {
        a(aVar, i, iArr);
        float f2 = 0.48f;
        int i2 = -1;
        int length = iArr2.length;
        int i3 = 0;
        while (i3 < length) {
            float fA = a(iArr, iArr2[i3], 0.7f);
            if (fA < f2) {
                i2 = i3;
            } else {
                fA = f2;
            }
            i3++;
            f2 = fA;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw com.google.b.i.a();
    }

    static boolean a(CharSequence charSequence) throws com.google.b.f {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw com.google.b.f.a();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw com.google.b.f.a();
            }
            i3 += iCharAt2;
        }
        return i3 % 10 == 0;
    }

    static int[] a(com.google.b.c.a aVar) throws com.google.b.i {
        int[] iArr = new int[f5642b.length];
        int i = 0;
        int[] iArrA = null;
        boolean zA = false;
        while (!zA) {
            Arrays.fill(iArr, 0, f5642b.length, 0);
            iArrA = a(aVar, i, false, f5642b, iArr);
            int i2 = iArrA[0];
            i = iArrA[1];
            int i3 = i2 - (i - i2);
            if (i3 >= 0) {
                zA = aVar.a(i3, i2, false);
            }
        }
        return iArrA;
    }

    static int[] a(com.google.b.c.a aVar, int i, boolean z, int[] iArr) throws com.google.b.i {
        return a(aVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(com.google.b.c.a aVar, int i, boolean z, int[] iArr, int[] iArr2) throws com.google.b.i {
        int length = iArr.length;
        int iA = aVar.a();
        int iD = z ? aVar.d(i) : aVar.c(i);
        int i2 = 0;
        boolean z2 = z;
        for (int i3 = iD; i3 < iA; i3++) {
            if (aVar.a(i3) ^ z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (a(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{iD, i3};
                    }
                    iD += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
        }
        throw com.google.b.i.a();
    }

    protected abstract int a(com.google.b.c.a aVar, int[] iArr, StringBuilder sb) throws com.google.b.i;

    @Override // com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f, com.google.b.d {
        return a(i, aVar, a(aVar), map);
    }

    public com.google.b.m a(int i, com.google.b.c.a aVar, int[] iArr, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f, com.google.b.d {
        int length;
        String strA;
        com.google.b.p pVar = map == null ? null : (com.google.b.p) map.get(com.google.b.e.NEED_RESULT_POINT_CALLBACK);
        if (pVar != null) {
            pVar.a(new com.google.b.o((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f5646a;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        if (pVar != null) {
            pVar.a(new com.google.b.o(iA, i));
        }
        int[] iArrA = a(aVar, iA);
        if (pVar != null) {
            pVar.a(new com.google.b.o((iArrA[0] + iArrA[1]) / 2.0f, i));
        }
        int i2 = iArrA[1];
        int i3 = (i2 - iArrA[0]) + i2;
        if (i3 >= aVar.a() || !aVar.a(i2, i3, false)) {
            throw com.google.b.i.a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw com.google.b.f.a();
        }
        if (!a(string)) {
            throw com.google.b.d.a();
        }
        float f2 = (iArr[1] + iArr[0]) / 2.0f;
        float f3 = (iArrA[1] + iArrA[0]) / 2.0f;
        com.google.b.a aVarB = b();
        com.google.b.m mVar = new com.google.b.m(string, null, new com.google.b.o[]{new com.google.b.o(f2, i), new com.google.b.o(f3, i)}, aVarB);
        try {
            com.google.b.m mVarA = this.f5647f.a(i, aVar, iArrA[1]);
            mVar.a(com.google.b.n.UPC_EAN_EXTENSION, mVarA.a());
            mVar.a(mVarA.e());
            mVar.a(mVarA.c());
            length = mVarA.a().length();
        } catch (com.google.b.l e2) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(com.google.b.e.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            boolean z = false;
            for (int i4 : iArr2) {
                if (length == i4) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                throw com.google.b.i.a();
            }
        }
        if ((aVarB == com.google.b.a.EAN_13 || aVarB == com.google.b.a.UPC_A) && (strA = this.g.a(string)) != null) {
            mVar.a(com.google.b.n.POSSIBLE_COUNTRY, strA);
        }
        return mVar;
    }

    boolean a(String str) throws com.google.b.f {
        return a((CharSequence) str);
    }

    int[] a(com.google.b.c.a aVar, int i) throws com.google.b.i {
        return a(aVar, i, false, f5642b);
    }

    abstract com.google.b.a b();
}
