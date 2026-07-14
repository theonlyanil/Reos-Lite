package com.google.b.g.a.a;

import com.google.b.e;
import com.google.b.f;
import com.google.b.g.a.a.a.j;
import com.google.b.i;
import com.google.b.m;
import com.google.b.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.google.b.g.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5590a = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5591b = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f5592c = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f5593d = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[][] f5594e = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[][] f5595f = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<b> g = new ArrayList(11);
    private final List<c> h = new ArrayList();
    private final int[] i = new int[2];
    private boolean j = false;

    private static int a(com.google.b.c.a aVar, int i) {
        return aVar.a(i) ? aVar.c(aVar.d(i)) : aVar.d(aVar.c(i));
    }

    private com.google.b.g.a.c a(com.google.b.c.a aVar, int i, boolean z) {
        int i2;
        int iD;
        int i3;
        if (z) {
            int i4 = this.i[0] - 1;
            while (i4 >= 0 && !aVar.a(i4)) {
                i4--;
            }
            i2 = i4 + 1;
            i3 = this.i[0] - i2;
            iD = this.i[1];
        } else {
            i2 = this.i[0];
            iD = aVar.d(this.i[1] + 1);
            i3 = iD - this.i[1];
        }
        int[] iArrB = b();
        System.arraycopy(iArrB, 0, iArrB, 1, iArrB.length - 1);
        iArrB[0] = i3;
        try {
            return new com.google.b.g.a.c(a(iArrB, f5593d), new int[]{i2, iD}, i2, iD, i);
        } catch (i e2) {
            return null;
        }
    }

    static m a(List<b> list) throws i, f {
        String strA = j.a(a.a(list)).a();
        o[] oVarArrC = list.get(0).c().c();
        o[] oVarArrC2 = list.get(list.size() - 1).c().c();
        return new m(strA, null, new o[]{oVarArrC[0], oVarArrC[1], oVarArrC2[0], oVarArrC2[1]}, com.google.b.a.RSS_EXPANDED);
    }

    private List<b> a(List<c> list, int i) throws i {
        while (i < this.h.size()) {
            c cVar = this.h.get(i);
            this.g.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.g.addAll(list.get(i2).a());
            }
            this.g.addAll(cVar.a());
            if (b(this.g)) {
                if (h()) {
                    return this.g;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return a(arrayList, i + 1);
                } catch (i e2) {
                }
            }
            i++;
        }
        throw i.a();
    }

    private List<b> a(boolean z) {
        List<b> listA = null;
        if (this.h.size() > 25) {
            this.h.clear();
        } else {
            this.g.clear();
            if (z) {
                Collections.reverse(this.h);
            }
            try {
                listA = a(new ArrayList(), 0);
            } catch (i e2) {
            }
            if (z) {
                Collections.reverse(this.h);
            }
        }
        return listA;
    }

    private void a(int i) throws i {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        boolean z7 = true;
        int iA = a(f());
        int iA2 = a(g());
        int i2 = (iA + iA2) - i;
        boolean z8 = (iA & 1) == 1;
        boolean z9 = (iA2 & 1) == 0;
        if (iA > 13) {
            z = true;
            z2 = false;
        } else if (iA < 4) {
            z = false;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (iA2 > 13) {
            z3 = false;
            z6 = true;
        } else {
            z3 = iA2 < 4;
        }
        if (i2 == 1) {
            if (z8) {
                if (z9) {
                    throw i.a();
                }
                z5 = z2;
                z7 = z3;
                z4 = true;
            } else {
                if (!z9) {
                    throw i.a();
                }
                z6 = true;
                z7 = z3;
                z4 = z;
                z5 = z2;
            }
        } else if (i2 == -1) {
            if (z8) {
                if (z9) {
                    throw i.a();
                }
                boolean z10 = z3;
                z4 = z;
                z5 = true;
                z7 = z10;
            } else {
                if (!z9) {
                    throw i.a();
                }
                z4 = z;
                z5 = z2;
            }
        } else {
            if (i2 != 0) {
                throw i.a();
            }
            if (z8) {
                if (!z9) {
                    throw i.a();
                }
                if (iA < iA2) {
                    z6 = true;
                    boolean z11 = z3;
                    z4 = z;
                    z5 = true;
                    z7 = z11;
                } else {
                    z4 = true;
                    z5 = z2;
                }
            } else {
                if (z9) {
                    throw i.a();
                }
                z7 = z3;
                z4 = z;
                z5 = z2;
            }
        }
        if (z5) {
            if (z4) {
                throw i.a();
            }
            a(f(), d());
        }
        if (z4) {
            b(f(), d());
        }
        if (z7) {
            if (z6) {
                throw i.a();
            }
            a(g(), d());
        }
        if (z6) {
            b(g(), e());
        }
    }

    private void a(int i, boolean z) {
        boolean zA = false;
        boolean zA2 = false;
        int i2 = 0;
        while (i2 < this.h.size()) {
            c cVar = this.h.get(i2);
            if (cVar.b() > i) {
                zA = cVar.a(this.g);
                break;
            } else {
                i2++;
                zA2 = cVar.a(this.g);
            }
        }
        if (zA || zA2 || a((Iterable<b>) this.g, (Iterable<c>) this.h)) {
            return;
        }
        this.h.add(i2, new c(this.g, i, z));
        a(this.g, this.h);
    }

    private static void a(List<b> list, List<c> list2) {
        boolean z;
        boolean z2;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z2 = false;
                            break;
                        } else if (next2.equals(it3.next())) {
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static boolean a(com.google.b.g.a.c cVar, boolean z, boolean z2) {
        return (cVar.a() == 0 && z && z2) ? false : true;
    }

    private static boolean a(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z;
        boolean z2;
        for (c cVar : iterable2) {
            Iterator<b> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                b next = it.next();
                Iterator<b> it2 = cVar.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (next.equals(it2.next())) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private void b(com.google.b.c.a aVar, List<b> list, int i) throws i {
        int[] iArrB = b();
        iArrB[0] = 0;
        iArrB[1] = 0;
        iArrB[2] = 0;
        iArrB[3] = 0;
        int iA = aVar.a();
        if (i < 0) {
            i = list.isEmpty() ? 0 : list.get(list.size() - 1).c().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        int i2 = i;
        while (i2 < iA) {
            z2 = !aVar.a(i2);
            if (!z2) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2;
        int i4 = 0;
        boolean z3 = z2;
        int i5 = i3;
        for (int i6 = i2; i6 < iA; i6++) {
            if (aVar.a(i6) ^ z3) {
                iArrB[i4] = iArrB[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (z) {
                        c(iArrB);
                    }
                    if (b(iArrB)) {
                        this.i[0] = i5;
                        this.i[1] = i6;
                        return;
                    }
                    if (z) {
                        c(iArrB);
                    }
                    i5 += iArrB[0] + iArrB[1];
                    iArrB[0] = iArrB[2];
                    iArrB[1] = iArrB[3];
                    iArrB[2] = 0;
                    iArrB[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                iArrB[i4] = 1;
                z3 = !z3;
            }
        }
        throw i.a();
    }

    private static boolean b(List<b> list) {
        boolean z;
        for (int[] iArr : f5595f) {
            if (list.size() <= iArr.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    }
                    if (list.get(i).c().a() != iArr[i]) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void c(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(length - i) - 1];
            iArr[(length - i) - 1] = i2;
        }
    }

    private boolean h() {
        b bVar = this.g.get(0);
        com.google.b.g.a.b bVarA = bVar.a();
        com.google.b.g.a.b bVarB = bVar.b();
        if (bVarB == null) {
            return false;
        }
        int i = 2;
        int iB = bVarB.b();
        for (int i2 = 1; i2 < this.g.size(); i2++) {
            b bVar2 = this.g.get(i2);
            iB += bVar2.a().b();
            i++;
            com.google.b.g.a.b bVarB2 = bVar2.b();
            if (bVarB2 != null) {
                iB += bVarB2.b();
                i++;
            }
        }
        return (iB % 211) + ((i + (-4)) * 211) == bVarA.a();
    }

    b a(com.google.b.c.a aVar, List<b> list, int i) throws i {
        boolean z;
        com.google.b.g.a.c cVarA;
        com.google.b.g.a.b bVarA;
        boolean z2 = list.size() % 2 == 0;
        if (this.j) {
            z = !z2;
        } else {
            z = z2;
        }
        int iA = -1;
        boolean z3 = true;
        do {
            b(aVar, list, iA);
            cVarA = a(aVar, i, z);
            if (cVarA == null) {
                iA = a(aVar, this.i[0]);
            } else {
                z3 = false;
            }
        } while (z3);
        com.google.b.g.a.b bVarA2 = a(aVar, cVarA, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw i.a();
        }
        try {
            bVarA = a(aVar, cVarA, z, false);
        } catch (i e2) {
            bVarA = null;
        }
        return new b(bVarA2, bVarA, cVarA, true);
    }

    com.google.b.g.a.b a(com.google.b.c.a aVar, com.google.b.g.a.c cVar, boolean z, boolean z2) throws i {
        int[] iArrC = c();
        iArrC[0] = 0;
        iArrC[1] = 0;
        iArrC[2] = 0;
        iArrC[3] = 0;
        iArrC[4] = 0;
        iArrC[5] = 0;
        iArrC[6] = 0;
        iArrC[7] = 0;
        if (z2) {
            b(aVar, cVar.b()[0], iArrC);
        } else {
            a(aVar, cVar.b()[1], iArrC);
            int i = 0;
            for (int length = iArrC.length - 1; i < length; length--) {
                int i2 = iArrC[i];
                iArrC[i] = iArrC[length];
                iArrC[length] = i2;
                i++;
            }
        }
        float fA = a(iArrC) / 17;
        float f2 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fA - f2) / f2 > 0.3f) {
            throw i.a();
        }
        int[] iArrF = f();
        int[] iArrG = g();
        float[] fArrD = d();
        float[] fArrE = e();
        for (int i3 = 0; i3 < iArrC.length; i3++) {
            float f3 = (1.0f * iArrC[i3]) / fA;
            int i4 = (int) (0.5f + f3);
            if (i4 < 1) {
                if (f3 < 0.3f) {
                    throw i.a();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f3 > 8.7f) {
                    throw i.a();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                iArrF[i5] = i4;
                fArrD[i5] = f3 - i4;
            } else {
                iArrG[i5] = i4;
                fArrE[i5] = f3 - i4;
            }
        }
        a(17);
        int iA = ((z2 ? 0 : 1) + ((cVar.a() * 4) + (z ? 0 : 2))) - 1;
        int i6 = 0;
        int length2 = iArrF.length - 1;
        int i7 = 0;
        while (length2 >= 0) {
            if (a(cVar, z, z2)) {
                i7 += f5594e[iA][length2 * 2] * iArrF[length2];
            }
            int i8 = iArrF[length2] + i6;
            length2--;
            i6 = i8;
        }
        int i9 = 0;
        for (int length3 = iArrG.length - 1; length3 >= 0; length3--) {
            if (a(cVar, z, z2)) {
                i9 += f5594e[iA][(length3 * 2) + 1] * iArrG[length3];
            }
        }
        int i10 = i7 + i9;
        if ((i6 & 1) != 0 || i6 > 13 || i6 < 4) {
            throw i.a();
        }
        int i11 = (13 - i6) / 2;
        int i12 = f5590a[i11];
        return new com.google.b.g.a.b(f5592c[i11] + (com.google.b.g.a.f.a(iArrF, i12, true) * f5591b[i11]) + com.google.b.g.a.f.a(iArrG, 9 - i12, false), i10);
    }

    @Override // com.google.b.g.k
    public m a(int i, com.google.b.c.a aVar, Map<e, ?> map) throws i, f {
        this.g.clear();
        this.j = false;
        try {
            return a(a(i, aVar));
        } catch (i e2) {
            this.g.clear();
            this.j = true;
            return a(a(i, aVar));
        }
    }

    List<b> a(int i, com.google.b.c.a aVar) throws i {
        while (true) {
            try {
                this.g.add(a(aVar, this.g, i));
            } catch (i e2) {
                if (this.g.isEmpty()) {
                    throw e2;
                }
                if (h()) {
                    return this.g;
                }
                boolean z = !this.h.isEmpty();
                a(i, false);
                if (z) {
                    List<b> listA = a(false);
                    if (listA != null) {
                        return listA;
                    }
                    List<b> listA2 = a(true);
                    if (listA2 != null) {
                        return listA2;
                    }
                }
                throw i.a();
            }
        }
    }

    @Override // com.google.b.g.k, com.google.b.k
    public void a() {
        this.g.clear();
        this.h.clear();
    }
}
