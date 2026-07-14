package com.google.b.d.b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.b.c.g;
import com.google.b.i;
import com.google.b.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b f5511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.b.c.a.b f5512b;

    /* JADX INFO: renamed from: com.google.b.d.b.a$a, reason: collision with other inner class name */
    private static final class C0202a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f5513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f5514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f5515c;

        private C0202a(o oVar, o oVar2, int i) {
            this.f5513a = oVar;
            this.f5514b = oVar2;
            this.f5515c = i;
        }

        o a() {
            return this.f5513a;
        }

        o b() {
            return this.f5514b;
        }

        public int c() {
            return this.f5515c;
        }

        public String toString() {
            return this.f5513a + "/" + this.f5514b + '/' + this.f5515c;
        }
    }

    private static final class b implements Serializable, Comparator<C0202a> {
        private b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0202a c0202a, C0202a c0202a2) {
            return c0202a.c() - c0202a2.c();
        }
    }

    public a(com.google.b.c.b bVar) throws i {
        this.f5511a = bVar;
        this.f5512b = new com.google.b.c.a.b(bVar);
    }

    private static int a(o oVar, o oVar2) {
        return com.google.b.c.a.a.a(o.a(oVar, oVar2));
    }

    private static com.google.b.c.b a(com.google.b.c.b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) throws i {
        return com.google.b.c.i.a().a(bVar, i, i2, 0.5f, 0.5f, i - 0.5f, 0.5f, i - 0.5f, i2 - 0.5f, 0.5f, i2 - 0.5f, oVar.a(), oVar.b(), oVar4.a(), oVar4.b(), oVar3.a(), oVar3.b(), oVar2.a(), oVar2.b());
    }

    private o a(o oVar, o oVar2, o oVar3, o oVar4, int i) {
        float fA = a(oVar, oVar2) / i;
        int iA = a(oVar3, oVar4);
        o oVar5 = new o((((oVar4.a() - oVar3.a()) / iA) * fA) + oVar4.a(), (fA * ((oVar4.b() - oVar3.b()) / iA)) + oVar4.b());
        float fA2 = a(oVar, oVar3) / i;
        int iA2 = a(oVar2, oVar4);
        o oVar6 = new o((((oVar4.a() - oVar2.a()) / iA2) * fA2) + oVar4.a(), (fA2 * ((oVar4.b() - oVar2.b()) / iA2)) + oVar4.b());
        if (a(oVar5)) {
            return (!a(oVar6) || Math.abs(b(oVar3, oVar5).c() - b(oVar2, oVar5).c()) <= Math.abs(b(oVar3, oVar6).c() - b(oVar2, oVar6).c())) ? oVar5 : oVar6;
        }
        if (a(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private o a(o oVar, o oVar2, o oVar3, o oVar4, int i, int i2) {
        float fA = a(oVar, oVar2) / i;
        int iA = a(oVar3, oVar4);
        o oVar5 = new o((((oVar4.a() - oVar3.a()) / iA) * fA) + oVar4.a(), (fA * ((oVar4.b() - oVar3.b()) / iA)) + oVar4.b());
        float fA2 = a(oVar, oVar3) / i2;
        int iA2 = a(oVar2, oVar4);
        o oVar6 = new o((((oVar4.a() - oVar2.a()) / iA2) * fA2) + oVar4.a(), (fA2 * ((oVar4.b() - oVar2.b()) / iA2)) + oVar4.b());
        if (a(oVar5)) {
            return (a(oVar6) && Math.abs(i - b(oVar3, oVar5).c()) + Math.abs(i2 - b(oVar2, oVar5).c()) > Math.abs(i - b(oVar3, oVar6).c()) + Math.abs(i2 - b(oVar2, oVar6).c())) ? oVar6 : oVar5;
        }
        if (a(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private static void a(Map<o, Integer> map, o oVar) {
        Integer num = map.get(oVar);
        map.put(oVar, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    private boolean a(o oVar) {
        return oVar.a() >= BitmapDescriptorFactory.HUE_RED && oVar.a() < ((float) this.f5511a.e()) && oVar.b() > BitmapDescriptorFactory.HUE_RED && oVar.b() < ((float) this.f5511a.f());
    }

    private C0202a b(o oVar, o oVar2) {
        int i;
        int iA = (int) oVar.a();
        int iB = (int) oVar.b();
        int iA2 = (int) oVar2.a();
        int iB2 = (int) oVar2.b();
        boolean z = Math.abs(iB2 - iB) > Math.abs(iA2 - iA);
        if (!z) {
            iB2 = iA2;
            iA2 = iB2;
            iB = iA;
            iA = iB;
        }
        int iAbs = Math.abs(iB2 - iB);
        int iAbs2 = Math.abs(iA2 - iA);
        int i2 = (-iAbs) / 2;
        int i3 = iA < iA2 ? 1 : -1;
        int i4 = iB < iB2 ? 1 : -1;
        int i5 = 0;
        boolean zA = this.f5511a.a(z ? iA : iB, z ? iB : iA);
        int i6 = iA;
        int i7 = i2;
        while (iB != iB2) {
            boolean zA2 = this.f5511a.a(z ? i6 : iB, z ? iB : i6);
            if (zA2 != zA) {
                i5++;
                zA = zA2;
            }
            int i8 = i7 + iAbs2;
            if (i8 > 0) {
                if (i6 == iA2) {
                    i = i5;
                    return new C0202a(oVar, oVar2, i);
                }
                i6 += i3;
                i8 -= iAbs;
            }
            iB += i4;
            i7 = i8;
        }
        i = i5;
        return new C0202a(oVar, oVar2, i);
    }

    public g a() throws i {
        o oVar;
        o oVarA;
        com.google.b.c.b bVarA;
        o oVar2;
        o oVar3;
        o[] oVarArrA = this.f5512b.a();
        o oVar4 = oVarArrA[0];
        o oVar5 = oVarArrA[1];
        o oVar6 = oVarArrA[2];
        o oVar7 = oVarArrA[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(b(oVar4, oVar5));
        arrayList.add(b(oVar4, oVar6));
        arrayList.add(b(oVar5, oVar7));
        arrayList.add(b(oVar6, oVar7));
        Collections.sort(arrayList, new b());
        C0202a c0202a = (C0202a) arrayList.get(0);
        C0202a c0202a2 = (C0202a) arrayList.get(1);
        HashMap map = new HashMap();
        a(map, c0202a.a());
        a(map, c0202a.b());
        a(map, c0202a2.a());
        a(map, c0202a2.b());
        o oVar8 = null;
        o oVar9 = null;
        o oVar10 = null;
        for (Map.Entry entry : map.entrySet()) {
            o oVar11 = (o) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                oVar2 = oVar11;
                oVar11 = oVar10;
                oVar3 = oVar8;
            } else if (oVar8 == null) {
                oVar2 = oVar9;
                o oVar12 = oVar10;
                oVar3 = oVar11;
                oVar11 = oVar12;
            } else {
                oVar2 = oVar9;
                oVar3 = oVar8;
            }
            oVar9 = oVar2;
            oVar8 = oVar3;
            oVar10 = oVar11;
        }
        if (oVar8 == null || oVar9 == null || oVar10 == null) {
            throw i.a();
        }
        o[] oVarArr = {oVar8, oVar9, oVar10};
        o.a(oVarArr);
        o oVar13 = oVarArr[0];
        o oVar14 = oVarArr[1];
        o oVar15 = oVarArr[2];
        if (!map.containsKey(oVar4)) {
            oVar = oVar4;
        } else if (map.containsKey(oVar5)) {
            oVar = !map.containsKey(oVar6) ? oVar6 : oVar7;
        } else {
            oVar = oVar5;
        }
        int iC = b(oVar15, oVar).c();
        int iC2 = b(oVar13, oVar).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i2 = iC2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            oVarA = a(oVar14, oVar13, oVar15, oVar, i, i2);
            if (oVarA == null) {
                oVarA = oVar;
            }
            int iC3 = b(oVar15, oVarA).c();
            int iC4 = b(oVar13, oVarA).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            bVarA = a(this.f5511a, oVar15, oVar14, oVar13, oVarA, iC3, iC4);
        } else {
            oVarA = a(oVar14, oVar13, oVar15, oVar, Math.min(i2, i));
            if (oVarA == null) {
                oVarA = oVar;
            }
            int iMax = Math.max(b(oVar15, oVarA).c(), b(oVar13, oVarA).c()) + 1;
            if ((iMax & 1) == 1) {
                iMax++;
            }
            bVarA = a(this.f5511a, oVar15, oVar14, oVar13, oVarA, iMax, iMax);
        }
        return new g(bVarA, new o[]{oVar15, oVar14, oVar13, oVarA});
    }
}
