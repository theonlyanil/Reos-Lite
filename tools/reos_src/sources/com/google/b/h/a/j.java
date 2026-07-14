package com.google.b.h.a;

import com.google.b.o;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.b.h.a.a.a f5700a = new com.google.b.h.a.a.a();

    private static int a(int i) {
        return 2 << i;
    }

    private static int a(f fVar, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        d dVarC = a(fVar, i - i3) ? fVar.a(i - i3).c(i2) : null;
        if (dVarC != null) {
            return z ? dVarC.e() : dVarC.d();
        }
        d dVarA = fVar.a(i).a(i2);
        if (dVarA != null) {
            return z ? dVarA.d() : dVarA.e();
        }
        if (a(fVar, i - i3)) {
            dVarA = fVar.a(i - i3).a(i2);
        }
        if (dVarA != null) {
            return z ? dVarA.e() : dVarA.d();
        }
        int i4 = 0;
        while (a(fVar, i - i3)) {
            i -= i3;
            for (d dVar : fVar.a(i).b()) {
                if (dVar != null) {
                    return (i3 * i4 * (dVar.e() - dVar.d())) + (z ? dVar.e() : dVar.d());
                }
            }
            i4++;
        }
        return z ? fVar.e().a() : fVar.e().b();
    }

    private static int a(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    private static int a(int[] iArr, int[] iArr2, int i) throws com.google.b.d {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f5700a.a(iArr, i, iArr2);
        }
        throw com.google.b.d.a();
    }

    private static com.google.b.c.e a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws com.google.b.f, com.google.b.d {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw com.google.b.d.a();
            }
            for (int i4 = 0; i4 < iArr5.length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return a(iArr, i, iArr2);
            } catch (com.google.b.d e2) {
                if (iArr5.length == 0) {
                    throw com.google.b.d.a();
                }
                for (int i5 = 0; i5 < iArr5.length; i5++) {
                    if (iArr5[i5] < iArr4[i5].length - 1) {
                        iArr5[i5] = iArr5[i5] + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == iArr5.length - 1) {
                        throw com.google.b.d.a();
                    }
                }
                i2 = i3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:59:0x0102  */
    public static com.google.b.c.e a(com.google.b.c.b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) throws com.google.b.i, com.google.b.f, com.google.b.d {
        h hVar;
        d dVarA;
        h hVarA = null;
        h hVar2 = null;
        int i3 = 0;
        c cVar = new c(bVar, oVar, oVar2, oVar3, oVar4);
        f fVar = null;
        while (true) {
            hVar = hVarA;
            if (i3 >= 2) {
                break;
            }
            hVarA = oVar != null ? a(bVar, cVar, oVar, true, i, i2) : hVar;
            h hVarA2 = oVar3 != null ? a(bVar, cVar, oVar3, false, i, i2) : hVar2;
            f fVarA = a(hVarA, hVarA2);
            if (fVarA == null) {
                throw com.google.b.i.a();
            }
            if (i3 != 0 || fVarA.e() == null || (fVarA.e().c() >= cVar.c() && fVarA.e().d() <= cVar.d())) {
                fVarA.a(cVar);
                hVar2 = hVarA2;
                fVar = fVarA;
                hVar = hVarA;
                break;
            }
            i3++;
            hVar2 = hVarA2;
            fVar = fVarA;
            cVar = fVarA.e();
        }
        int iB = fVar.b() + 1;
        fVar.a(0, hVar);
        fVar.a(iB, hVar2);
        boolean z = hVar != null;
        int iMax = i2;
        int iMin = i;
        for (int i4 = 1; i4 <= iB; i4++) {
            int i5 = z ? i4 : iB - i4;
            if (fVar.a(i5) == null) {
                g hVar3 = (i5 == 0 || i5 == iB) ? new h(cVar, i5 == 0) : new g(cVar);
                fVar.a(i5, hVar3);
                int i6 = -1;
                int iC = cVar.c();
                while (true) {
                    int i7 = i6;
                    if (iC <= cVar.d()) {
                        int iA = a(fVar, i5, iC, z);
                        if (iA >= 0 && iA <= cVar.b()) {
                            dVarA = a(bVar, cVar.a(), cVar.b(), z, iA, iC, iMin, iMax);
                            if (dVarA != null) {
                                hVar3.a(iC, dVarA);
                                iMin = Math.min(iMin, dVarA.c());
                                iMax = Math.max(iMax, dVarA.c());
                                i6 = iA;
                            } else {
                                i6 = i7;
                            }
                        } else if (i7 == -1) {
                            i6 = i7;
                        } else {
                            iA = i7;
                            dVarA = a(bVar, cVar.a(), cVar.b(), z, iA, iC, iMin, iMax);
                            if (dVarA != null) {
                                hVar3.a(iC, dVarA);
                                iMin = Math.min(iMin, dVarA.c());
                                iMax = Math.max(iMax, dVarA.c());
                                i6 = iA;
                            } else {
                                i6 = i7;
                            }
                        }
                        iC++;
                    }
                }
            }
        }
        return a(fVar);
    }

    private static com.google.b.c.e a(f fVar) throws com.google.b.i, com.google.b.f, com.google.b.d {
        b[][] bVarArrB = b(fVar);
        a(fVar, bVarArrB);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.c() * fVar.b()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < fVar.c(); i++) {
            for (int i2 = 0; i2 < fVar.b(); i2++) {
                int[] iArrA = bVarArrB[i][i2 + 1].a();
                int iB = (fVar.b() * i) + i2;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iB));
                } else if (iArrA.length == 1) {
                    iArr[iB] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iB));
                    arrayList2.add(iArrA);
                }
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            iArr2[i3] = (int[]) arrayList2.get(i3);
        }
        return a(fVar.d(), iArr, com.google.b.h.a.a(arrayList), com.google.b.h.a.a(arrayList3), iArr2);
    }

    private static com.google.b.c.e a(int[] iArr, int i, int[] iArr2) throws com.google.b.f, com.google.b.d {
        if (iArr.length == 0) {
            throw com.google.b.f.a();
        }
        int i2 = 1 << (i + 1);
        int iA = a(iArr, iArr2, i2);
        a(iArr, i2);
        com.google.b.c.e eVarA = e.a(iArr, String.valueOf(i));
        eVarA.a(Integer.valueOf(iA));
        eVarA.b(Integer.valueOf(iArr2.length));
        return eVarA;
    }

    private static c a(h hVar) throws com.google.b.i, com.google.b.f {
        int[] iArrD;
        if (hVar == null || (iArrD = hVar.d()) == null) {
            return null;
        }
        int iA = a(iArrD);
        int i = 0;
        for (int i2 : iArrD) {
            i += iA - i2;
            if (i2 > 0) {
                break;
            }
        }
        d[] dVarArrB = hVar.b();
        int i3 = i;
        for (int i4 = 0; i3 > 0 && dVarArrB[i4] == null; i4++) {
            i3--;
        }
        int i5 = 0;
        for (int length = iArrD.length - 1; length >= 0; length--) {
            i5 += iA - iArrD[length];
            if (iArrD[length] > 0) {
                break;
            }
        }
        int i6 = i5;
        for (int length2 = dVarArrB.length - 1; i6 > 0 && dVarArrB[length2] == null; length2--) {
            i6--;
        }
        return hVar.a().a(i3, i6, hVar.f());
    }

    private static d a(com.google.b.c.b bVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iA;
        int iA2;
        int iB = b(bVar, i, i2, z, i3, i4);
        int[] iArrA = a(bVar, i, i2, z, iB, i4);
        if (iArrA == null) {
            return null;
        }
        int iA3 = com.google.b.h.a.a(iArrA);
        if (z) {
            i7 = iB;
            iB += iA3;
        } else {
            for (int i8 = 0; i8 < iArrA.length / 2; i8++) {
                int i9 = iArrA[i8];
                iArrA[i8] = iArrA[(iArrA.length - 1) - i8];
                iArrA[(iArrA.length - 1) - i8] = i9;
            }
            i7 = iB - iA3;
        }
        if (a(iA3, i5, i6) && (iA2 = com.google.b.h.a.a((iA = i.a(iArrA)))) != -1) {
            return new d(i7, iB, c(iA), iA2);
        }
        return null;
    }

    private static f a(h hVar, h hVar2) throws com.google.b.i, com.google.b.f {
        a aVarB;
        if ((hVar == null && hVar2 == null) || (aVarB = b(hVar, hVar2)) == null) {
            return null;
        }
        return new f(aVarB, c.a(a(hVar), a(hVar2)));
    }

    private static h a(com.google.b.c.b bVar, c cVar, o oVar, boolean z, int i, int i2) {
        h hVar = new h(cVar, z);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 2) {
                return hVar;
            }
            int i5 = i4 == 0 ? 1 : -1;
            int iA = (int) oVar.a();
            for (int iB = (int) oVar.b(); iB <= cVar.d() && iB >= cVar.c(); iB += i5) {
                d dVarA = a(bVar, 0, bVar.e(), z, iA, iB, i, i2);
                if (dVarA != null) {
                    hVar.a(iB, dVarA);
                    iA = z ? dVarA.d() : dVarA.e();
                }
            }
            i3 = i4 + 1;
        }
    }

    private static void a(f fVar, b[][] bVarArr) throws com.google.b.i {
        int[] iArrA = bVarArr[0][1].a();
        int iB = (fVar.b() * fVar.c()) - a(fVar.d());
        if (iArrA.length != 0) {
            if (iArrA[0] != iB) {
                bVarArr[0][1].a(iB);
            }
        } else {
            if (iB < 1 || iB > 928) {
                throw com.google.b.i.a();
            }
            bVarArr[0][1].a(iB);
        }
    }

    private static void a(int[] iArr, int i) throws com.google.b.f {
        if (iArr.length < 4) {
            throw com.google.b.f.a();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw com.google.b.f.a();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw com.google.b.f.a();
            }
            iArr[0] = iArr.length - i;
        }
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static boolean a(f fVar, int i) {
        return i >= 0 && i <= fVar.b() + 1;
    }

    private static int[] a(com.google.b.c.b bVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (((!z || i3 >= i2) && (z || i3 < i)) || i6 >= iArr.length) {
                break;
            }
            if (bVar.a(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 == iArr.length || (((z && i3 == i2) || (!z && i3 == i)) && i6 == iArr.length - 1)) {
            return iArr;
        }
        return null;
    }

    private static int b(com.google.b.c.b bVar, int i, int i2, boolean z, int i3, int i4) {
        int i5 = 0;
        int i6 = z ? -1 : 1;
        int i7 = i3;
        while (i5 < 2) {
            int i8 = i7;
            while (true) {
                if (((!z || i8 < i) && (z || i8 >= i2)) || z != bVar.a(i8, i4)) {
                    break;
                }
                if (Math.abs(i3 - i8) > 2) {
                    return i3;
                }
                i8 += i6;
            }
            i6 = -i6;
            i5++;
            z = !z;
            i7 = i8;
        }
        return i7;
    }

    private static int b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static a b(h hVar, h hVar2) {
        a aVarE;
        a aVarE2;
        if (hVar == null || (aVarE = hVar.e()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.e();
        }
        if (hVar2 == null || (aVarE2 = hVar2.e()) == null) {
            return aVarE;
        }
        if (aVarE.a() == aVarE2.a() || aVarE.b() == aVarE2.b() || aVarE.c() == aVarE2.c()) {
            return aVarE;
        }
        return null;
    }

    private static int[] b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int length = iArr.length - 1;
        while (true) {
            if ((i & 1) != i2) {
                i2 = i & 1;
                length--;
                if (length < 0) {
                    return iArr;
                }
            }
            iArr[length] = iArr[length] + 1;
            i >>= 1;
        }
    }

    private static b[][] b(f fVar) throws com.google.b.f {
        int iH;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, fVar.c(), fVar.b() + 2);
        for (int i = 0; i < bVarArr.length; i++) {
            for (int i2 = 0; i2 < bVarArr[i].length; i2++) {
                bVarArr[i][i2] = new b();
            }
        }
        int i3 = 0;
        for (g gVar : fVar.a()) {
            if (gVar != null) {
                d[] dVarArrB = gVar.b();
                for (d dVar : dVarArrB) {
                    if (dVar != null && (iH = dVar.h()) >= 0) {
                        if (iH >= bVarArr.length) {
                            throw com.google.b.f.a();
                        }
                        bVarArr[iH][i3].a(dVar.g());
                    }
                }
            }
            i3++;
        }
        return bVarArr;
    }

    private static int c(int i) {
        return b(b(i));
    }
}
