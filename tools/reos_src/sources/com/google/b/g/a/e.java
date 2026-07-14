package com.google.b.g.a;

import com.google.b.i;
import com.google.b.m;
import com.google.b.o;
import com.google.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5603a = {1, 10, 34, 70, 126};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5604b = {4, 20, 48, 81};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f5605c = {0, 161, 961, 2015, 2715};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f5606d = {0, 336, 1036, 1516};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f5607e = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f5608f = {2, 4, 6, 8};
    private static final int[][] g = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> h = new ArrayList();
    private final List<d> i = new ArrayList();

    private b a(com.google.b.c.a aVar, c cVar, boolean z) throws i {
        int[] iArrC = c();
        iArrC[0] = 0;
        iArrC[1] = 0;
        iArrC[2] = 0;
        iArrC[3] = 0;
        iArrC[4] = 0;
        iArrC[5] = 0;
        iArrC[6] = 0;
        iArrC[7] = 0;
        if (z) {
            b(aVar, cVar.b()[0], iArrC);
        } else {
            a(aVar, cVar.b()[1] + 1, iArrC);
            int i = 0;
            for (int length = iArrC.length - 1; i < length; length--) {
                int i2 = iArrC[i];
                iArrC[i] = iArrC[length];
                iArrC[length] = i2;
                i++;
            }
        }
        int i3 = z ? 16 : 15;
        float fA = a(iArrC) / i3;
        int[] iArrF = f();
        int[] iArrG = g();
        float[] fArrD = d();
        float[] fArrE = e();
        for (int i4 = 0; i4 < iArrC.length; i4++) {
            float f2 = iArrC[i4] / fA;
            int i5 = (int) (0.5f + f2);
            if (i5 < 1) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                iArrF[i6] = i5;
                fArrD[i6] = f2 - i5;
            } else {
                iArrG[i6] = i5;
                fArrE[i6] = f2 - i5;
            }
        }
        a(z, i3);
        int length2 = iArrF.length - 1;
        int i7 = 0;
        int i8 = 0;
        while (length2 >= 0) {
            int i9 = (i7 * 9) + iArrF[length2];
            int i10 = iArrF[length2] + i8;
            length2--;
            i7 = i9;
            i8 = i10;
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = iArrG.length - 1; length3 >= 0; length3--) {
            i11 = (i11 * 9) + iArrG[length3];
            i12 += iArrG[length3];
        }
        int i13 = i7 + (i11 * 3);
        if (!z) {
            if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
                throw i.a();
            }
            int i14 = (10 - i12) / 2;
            int i15 = f5608f[i14];
            return new b(f.a(iArrF, i15, true) + (f.a(iArrG, 9 - i15, false) * f5604b[i14]) + f5606d[i14], i13);
        }
        if ((i8 & 1) != 0 || i8 > 12 || i8 < 4) {
            throw i.a();
        }
        int i16 = (12 - i8) / 2;
        int i17 = f5607e[i16];
        return new b((f.a(iArrF, i17, false) * f5603a[i16]) + f.a(iArrG, 9 - i17, true) + f5605c[i16], i13);
    }

    private c a(com.google.b.c.a aVar, int i, boolean z, int[] iArr) throws i {
        int iA;
        boolean zA = aVar.a(iArr[0]);
        int i2 = iArr[0] - 1;
        while (i2 >= 0 && (aVar.a(i2) ^ zA)) {
            i2--;
        }
        int i3 = i2 + 1;
        int i4 = iArr[0] - i3;
        int[] iArrB = b();
        System.arraycopy(iArrB, 0, iArrB, 1, iArrB.length - 1);
        iArrB[0] = i4;
        int iA2 = a(iArrB, g);
        int iA3 = iArr[1];
        if (z) {
            iA = (aVar.a() - 1) - i3;
            iA3 = (aVar.a() - 1) - iA3;
        } else {
            iA = i3;
        }
        return new c(iA2, new int[]{i3, iArr[1]}, iA, iA3, i);
    }

    private d a(com.google.b.c.a aVar, boolean z, int i, Map<com.google.b.e, ?> map) {
        try {
            int[] iArrA = a(aVar, 0, z);
            c cVarA = a(aVar, i, z, iArrA);
            p pVar = map == null ? null : (p) map.get(com.google.b.e.NEED_RESULT_POINT_CALLBACK);
            if (pVar != null) {
                float fA = (iArrA[0] + iArrA[1]) / 2.0f;
                if (z) {
                    fA = (aVar.a() - 1) - fA;
                }
                pVar.a(new o(fA, i));
            }
            b bVarA = a(aVar, cVarA, true);
            b bVarA2 = a(aVar, cVarA, false);
            return new d((bVarA.a() * 1597) + bVarA2.a(), bVarA.b() + (bVarA2.b() * 4), cVarA);
        } catch (i e2) {
            return null;
        }
    }

    private static m a(d dVar, d dVar2) {
        String strValueOf = String.valueOf((4537077 * ((long) dVar.a())) + ((long) dVar2.a()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int iCharAt = sb.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                iCharAt *= 3;
            }
            i += iCharAt;
        }
        int i3 = 10 - (i % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        sb.append(i3);
        o[] oVarArrC = dVar.c().c();
        o[] oVarArrC2 = dVar2.c().c();
        return new m(String.valueOf(sb.toString()), null, new o[]{oVarArrC[0], oVarArrC[1], oVarArrC2[0], oVarArrC2[1]}, com.google.b.a.RSS_14);
    }

    private static void a(Collection<d> collection, d dVar) {
        boolean z;
        if (dVar == null) {
            return;
        }
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d next = it.next();
            if (next.a() == dVar.a()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:83:0x00f6 A[PHI: r3 r4
      0x00f6: PHI (r3v5 boolean) = (r3v3 boolean), (r3v19 boolean) binds: [B:36:0x005d, B:25:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x00f6: PHI (r4v4 boolean) = (r4v2 boolean), (r4v9 boolean) binds: [B:36:0x005d, B:25:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    private void a(boolean z, int i) throws i {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        boolean z8 = true;
        int iA = a(f());
        int iA2 = a(g());
        int i2 = (iA + iA2) - i;
        boolean z9 = (iA & 1) == (z ? 1 : 0);
        boolean z10 = (iA2 & 1) == 1;
        if (z) {
            if (iA > 12) {
                z2 = true;
                z3 = false;
            } else if (iA < 4) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iA2 > 12) {
                z4 = false;
                z7 = true;
            } else if (iA2 < 4) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            if (iA > 11) {
                z2 = true;
                z3 = false;
            } else if (iA < 5) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iA2 > 10) {
                z4 = false;
                z7 = true;
            } else if (iA2 < 4) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        if (i2 == 1) {
            if (z9) {
                if (z10) {
                    throw i.a();
                }
                z6 = z3;
                z8 = z4;
                z5 = true;
            } else {
                if (!z10) {
                    throw i.a();
                }
                z7 = true;
                z8 = z4;
                z5 = z2;
                z6 = z3;
            }
        } else if (i2 == -1) {
            if (z9) {
                if (z10) {
                    throw i.a();
                }
                boolean z11 = z4;
                z5 = z2;
                z6 = true;
                z8 = z11;
            } else {
                if (!z10) {
                    throw i.a();
                }
                z5 = z2;
                z6 = z3;
            }
        } else {
            if (i2 != 0) {
                throw i.a();
            }
            if (z9) {
                if (!z10) {
                    throw i.a();
                }
                if (iA < iA2) {
                    z7 = true;
                    boolean z12 = z4;
                    z5 = z2;
                    z6 = true;
                    z8 = z12;
                } else {
                    z5 = true;
                    z6 = z3;
                }
            } else {
                if (z10) {
                    throw i.a();
                }
                z8 = z4;
                z5 = z2;
                z6 = z3;
            }
        }
        if (z6) {
            if (z5) {
                throw i.a();
            }
            a(f(), d());
        }
        if (z5) {
            b(f(), d());
        }
        if (z8) {
            if (z7) {
                throw i.a();
            }
            a(g(), d());
        }
        if (z7) {
            b(g(), e());
        }
    }

    private int[] a(com.google.b.c.a aVar, int i, boolean z) throws i {
        int[] iArrB = b();
        iArrB[0] = 0;
        iArrB[1] = 0;
        iArrB[2] = 0;
        iArrB[3] = 0;
        int iA = aVar.a();
        boolean z2 = false;
        int i2 = i;
        while (i2 < iA) {
            z2 = !aVar.a(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        boolean z3 = z2;
        int i3 = i2;
        int i4 = 0;
        for (int i5 = i2; i5 < iA; i5++) {
            if (aVar.a(i5) ^ z3) {
                iArrB[i4] = iArrB[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (b(iArrB)) {
                        return new int[]{i3, i5};
                    }
                    i3 += iArrB[0] + iArrB[1];
                    iArrB[0] = iArrB[2];
                    iArrB[1] = iArrB[3];
                    iArrB[2] = 0;
                    iArrB[3] = 0;
                    i4--;
                }
                iArrB[i4] = 1;
                z3 = !z3;
            }
        }
        throw i.a();
    }

    private static boolean b(d dVar, d dVar2) {
        int iB = (dVar.b() + (dVar2.b() * 16)) % 79;
        int iA = (dVar.c().a() * 9) + dVar2.c().a();
        if (iA > 72) {
            iA--;
        }
        if (iA > 8) {
            iA--;
        }
        return iB == iA;
    }

    @Override // com.google.b.g.k
    public m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws i {
        a(this.h, a(aVar, false, i, map));
        aVar.d();
        a(this.i, a(aVar, true, i, map));
        aVar.d();
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.h.get(i2);
            if (dVar.d() > 1) {
                int size2 = this.i.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.i.get(i3);
                    if (dVar2.d() > 1 && b(dVar, dVar2)) {
                        return a(dVar, dVar2);
                    }
                }
            }
        }
        throw i.a();
    }

    @Override // com.google.b.g.k, com.google.b.k
    public void a() {
        this.h.clear();
        this.i.clear();
    }
}
