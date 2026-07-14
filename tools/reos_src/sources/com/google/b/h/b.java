package com.google.b.h;

import com.google.b.d;
import com.google.b.e;
import com.google.b.f;
import com.google.b.h.a.j;
import com.google.b.i;
import com.google.b.k;
import com.google.b.m;
import com.google.b.n;
import com.google.b.o;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b implements k {
    private static int a(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return 0;
        }
        return (int) Math.abs(oVar.a() - oVar2.a());
    }

    private static int a(o[] oVarArr) {
        return Math.max(Math.max(a(oVarArr[0], oVarArr[4]), (a(oVarArr[6], oVarArr[2]) * 17) / 18), Math.max(a(oVarArr[1], oVarArr[5]), (a(oVarArr[7], oVarArr[3]) * 17) / 18));
    }

    private static m[] a(com.google.b.c cVar, Map<e, ?> map, boolean z) throws i, f, d {
        ArrayList arrayList = new ArrayList();
        com.google.b.h.b.b bVarA = com.google.b.h.b.a.a(cVar, map, z);
        for (o[] oVarArr : bVarA.b()) {
            com.google.b.c.e eVarA = j.a(bVarA.a(), oVarArr[4], oVarArr[5], oVarArr[6], oVarArr[7], b(oVarArr), a(oVarArr));
            m mVar = new m(eVarA.b(), eVarA.a(), oVarArr, com.google.b.a.PDF_417);
            mVar.a(n.ERROR_CORRECTION_LEVEL, eVarA.d());
            c cVar2 = (c) eVarA.e();
            if (cVar2 != null) {
                mVar.a(n.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(mVar);
        }
        return (m[]) arrayList.toArray(new m[arrayList.size()]);
    }

    private static int b(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(oVar.a() - oVar2.a());
    }

    private static int b(o[] oVarArr) {
        return Math.min(Math.min(b(oVarArr[0], oVarArr[4]), (b(oVarArr[6], oVarArr[2]) * 17) / 18), Math.min(b(oVarArr[1], oVarArr[5]), (b(oVarArr[7], oVarArr[3]) * 17) / 18));
    }

    @Override // com.google.b.k
    public m a(com.google.b.c cVar) throws i, f, d {
        return a(cVar, (Map<e, ?>) null);
    }

    @Override // com.google.b.k
    public m a(com.google.b.c cVar, Map<e, ?> map) throws i, f, d {
        m[] mVarArrA = a(cVar, map, false);
        if (mVarArrA == null || mVarArrA.length == 0 || mVarArrA[0] == null) {
            throw i.a();
        }
        return mVarArrA[0];
    }

    @Override // com.google.b.k
    public void a() {
    }
}
