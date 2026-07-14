package com.google.b.a;

import com.google.b.c;
import com.google.b.e;
import com.google.b.f;
import com.google.b.i;
import com.google.b.k;
import com.google.b.m;
import com.google.b.n;
import com.google.b.o;
import com.google.b.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b implements k {
    @Override // com.google.b.k
    public m a(c cVar) throws i, f {
        return a(cVar, null);
    }

    @Override // com.google.b.k
    public m a(c cVar, Map<e, ?> map) throws i, f {
        o[] oVarArrE;
        i iVar;
        com.google.b.c.e eVarA;
        com.google.b.c.e eVarA2;
        o[] oVarArr;
        p pVar;
        f fVar = null;
        com.google.b.a.b.a aVar = new com.google.b.a.b.a(cVar.c());
        try {
            a aVarA = aVar.a(false);
            oVarArrE = aVarA.e();
            try {
                eVarA = new com.google.b.a.a.a().a(aVarA);
                iVar = null;
            } catch (f e2) {
                e = e2;
                iVar = null;
                f fVar2 = e;
                eVarA = null;
                fVar = fVar2;
            } catch (i e3) {
                e = e3;
                iVar = e;
                eVarA = null;
            }
        } catch (f e4) {
            e = e4;
            oVarArrE = null;
        } catch (i e5) {
            e = e5;
            oVarArrE = null;
        }
        if (eVarA == null) {
            try {
                a aVarA2 = aVar.a(true);
                o[] oVarArrE2 = aVarA2.e();
                eVarA2 = new com.google.b.a.a.a().a(aVarA2);
                oVarArr = oVarArrE2;
            } catch (f | i e6) {
                if (iVar != null) {
                    throw iVar;
                }
                if (fVar != null) {
                    throw fVar;
                }
                throw e6;
            }
        } else {
            eVarA2 = eVarA;
            oVarArr = oVarArrE;
        }
        if (map != null && (pVar = (p) map.get(e.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (o oVar : oVarArr) {
                pVar.a(oVar);
            }
        }
        m mVar = new m(eVarA2.b(), eVarA2.a(), oVarArr, com.google.b.a.AZTEC);
        List<byte[]> listC = eVarA2.c();
        if (listC != null) {
            mVar.a(n.BYTE_SEGMENTS, listC);
        }
        String strD = eVarA2.d();
        if (strD != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, strD);
        }
        return mVar;
    }

    @Override // com.google.b.k
    public void a() {
    }
}
