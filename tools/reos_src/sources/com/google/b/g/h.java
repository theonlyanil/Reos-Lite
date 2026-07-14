package com.google.b.g;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5630c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5627b = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f5628d = {1, 1, 1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f5629e = {1, 1, 3};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[][] f5626a = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    private static int a(int[] iArr) throws com.google.b.i {
        float f2 = 0.38f;
        int i = -1;
        int length = f5626a.length;
        int i2 = 0;
        while (i2 < length) {
            float fA = a(iArr, f5626a[i2], 0.78f);
            if (fA < f2) {
                i = i2;
            } else {
                fA = f2;
            }
            i2++;
            f2 = fA;
        }
        if (i >= 0) {
            return i;
        }
        throw com.google.b.i.a();
    }

    private void a(com.google.b.c.a aVar, int i) throws com.google.b.i {
        int i2 = this.f5630c * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i2;
        for (int i4 = i - 1; i3 > 0 && i4 >= 0 && !aVar.a(i4); i4--) {
            i3--;
        }
        if (i3 != 0) {
            throw com.google.b.i.a();
        }
    }

    private static void a(com.google.b.c.a aVar, int i, int i2, StringBuilder sb) throws com.google.b.i {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        int i3 = i;
        while (i3 < i2) {
            a(aVar, i3, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            int i6 = i3;
            for (int i7 : iArr) {
                i6 += i7;
            }
            i3 = i6;
        }
    }

    private static int c(com.google.b.c.a aVar) throws com.google.b.i {
        int iA = aVar.a();
        int iC = aVar.c(0);
        if (iC == iA) {
            throw com.google.b.i.a();
        }
        return iC;
    }

    private static int[] c(com.google.b.c.a aVar, int i, int[] iArr) throws com.google.b.i {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iA = aVar.a();
        int i2 = i;
        int i3 = 0;
        boolean z = false;
        while (i < iA) {
            if (aVar.a(i) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (a(iArr2, iArr, 0.78f) < 0.38f) {
                        return new int[]{i2, i};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw com.google.b.i.a();
    }

    @Override // com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i, com.google.b.f {
        boolean z;
        int[] iArrA = a(aVar);
        int[] iArrB = b(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, iArrA[1], iArrB[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(com.google.b.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f5627b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 <= i3) {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (z) {
            return new com.google.b.m(string, null, new com.google.b.o[]{new com.google.b.o(iArrA[1], i), new com.google.b.o(iArrB[0], i)}, com.google.b.a.ITF);
        }
        throw com.google.b.f.a();
    }

    int[] a(com.google.b.c.a aVar) throws com.google.b.i {
        int[] iArrC = c(aVar, c(aVar), f5628d);
        this.f5630c = (iArrC[1] - iArrC[0]) / 4;
        a(aVar, iArrC[0]);
        return iArrC;
    }

    int[] b(com.google.b.c.a aVar) throws com.google.b.i {
        aVar.d();
        try {
            int[] iArrC = c(aVar, c(aVar), f5629e);
            a(aVar, iArrC[0]);
            int i = iArrC[0];
            iArrC[0] = aVar.a() - iArrC[1];
            iArrC[1] = aVar.a() - i;
            return iArrC;
        } finally {
            aVar.d();
        }
    }
}
