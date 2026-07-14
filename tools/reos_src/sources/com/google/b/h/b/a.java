package com.google.b.h.b;

import com.google.b.c;
import com.google.b.e;
import com.google.b.i;
import com.google.b.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5701a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5702b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f5703c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f5704d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += iArr[i3];
            i += iArr2[i3];
        }
        if (i2 < i) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2 / i;
        float f4 = f2 * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = ((float) i5) > f6 ? i5 - f6 : f6 - i5;
            if (f7 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f7;
        }
        return f5 / i2;
    }

    public static b a(c cVar, Map<e, ?> map, boolean z) throws i {
        com.google.b.c.b bVarC = cVar.c();
        List<o[]> listA = a(z, bVarC);
        if (listA.isEmpty()) {
            bVarC = bVarC.clone();
            bVarC.a();
            listA = a(z, bVarC);
        }
        return new b(bVarC, listA);
    }

    private static List<o[]> a(boolean z, com.google.b.c.b bVar) {
        int iA;
        float fB;
        ArrayList<o[]> arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int iMax = 0;
        while (iMax < bVar.f()) {
            o[] oVarArrA = a(bVar, iMax, i);
            if (oVarArrA[0] == null && oVarArrA[3] == null) {
                if (!z2) {
                    break;
                }
                for (o[] oVarArr : arrayList) {
                    if (oVarArr[1] != null) {
                        iMax = (int) Math.max(iMax, oVarArr[1].b());
                    }
                    if (oVarArr[3] != null) {
                        iMax = Math.max(iMax, (int) oVarArr[3].b());
                    }
                }
                i = 0;
                iMax += 5;
                z2 = false;
            } else {
                arrayList.add(oVarArrA);
                if (!z) {
                    break;
                }
                if (oVarArrA[2] != null) {
                    iA = (int) oVarArrA[2].a();
                    fB = oVarArrA[2].b();
                } else {
                    iA = (int) oVarArrA[4].a();
                    fB = oVarArrA[4].b();
                }
                iMax = (int) fB;
                i = iA;
                z2 = true;
            }
        }
        return arrayList;
    }

    private static void a(o[] oVarArr, o[] oVarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            oVarArr[iArr[i]] = oVarArr2[i];
        }
    }

    private static int[] a(com.google.b.c.b bVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i4 = 0;
        while (bVar.a(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int i6 = 0;
        int i7 = i;
        boolean z2 = z;
        while (i < i3) {
            if (bVar.a(i, i2) ^ z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (a(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    private static o[] a(com.google.b.c.b bVar, int i, int i2) {
        int iA;
        int iB;
        int iF = bVar.f();
        int iE = bVar.e();
        o[] oVarArr = new o[8];
        a(oVarArr, a(bVar, iF, iE, i, i2, f5703c), f5701a);
        if (oVarArr[4] != null) {
            iA = (int) oVarArr[4].a();
            iB = (int) oVarArr[4].b();
        } else {
            iA = i2;
            iB = i;
        }
        a(oVarArr, a(bVar, iF, iE, iB, iA, f5704d), f5702b);
        return oVarArr;
    }

    private static o[] a(com.google.b.c.b bVar, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        o[] oVarArr = new o[4];
        int[] iArr2 = new int[iArr.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                z = false;
                i5 = i7;
                break;
            }
            int[] iArrA = a(bVar, i4, i7, i2, false, iArr, iArr2);
            if (iArrA != null) {
                int[] iArr3 = iArrA;
                int i8 = i7;
                while (i8 > 0) {
                    int i9 = i8 - 1;
                    int[] iArrA2 = a(bVar, i4, i9, i2, false, iArr, iArr2);
                    if (iArrA2 == null) {
                        i8 = i9 + 1;
                        break;
                    }
                    iArr3 = iArrA2;
                    i8 = i9;
                }
                oVarArr[0] = new o(iArr3[0], i8);
                oVarArr[1] = new o(iArr3[1], i8);
                z = true;
                i5 = i8;
                break;
            }
            i7 += 5;
        }
        int i10 = i5 + 1;
        if (z) {
            int[] iArr4 = {(int) oVarArr[0].a(), (int) oVarArr[1].a()};
            int i11 = 0;
            int i12 = i10;
            while (i12 < i) {
                int[] iArrA3 = a(bVar, iArr4[0], i12, i2, false, iArr, iArr2);
                if (iArrA3 != null && Math.abs(iArr4[0] - iArrA3[0]) < 5 && Math.abs(iArr4[1] - iArrA3[1]) < 5) {
                    i6 = 0;
                } else {
                    if (i11 > 25) {
                        break;
                    }
                    i6 = i11 + 1;
                    iArrA3 = iArr4;
                }
                i12++;
                iArr4 = iArrA3;
                i11 = i6;
            }
            i10 = i12 - (i11 + 1);
            oVarArr[2] = new o(iArr4[0], i10);
            oVarArr[3] = new o(iArr4[1], i10);
        }
        if (i10 - i5 < 10) {
            for (int i13 = 0; i13 < oVarArr.length; i13++) {
                oVarArr[i13] = null;
            }
        }
        return oVarArr;
    }
}
