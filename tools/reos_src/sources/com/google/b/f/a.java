package com.google.b.f;

import com.google.b.c.b;
import com.google.b.d;
import com.google.b.e;
import com.google.b.f;
import com.google.b.f.a.c;
import com.google.b.i;
import com.google.b.k;
import com.google.b.m;
import com.google.b.n;
import com.google.b.o;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o[] f5534a = new o[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f5535b = new c();

    private static b a(b bVar) throws i {
        int[] iArrB = bVar.b();
        if (iArrB == null) {
            throw i.a();
        }
        int i = iArrB[0];
        int i2 = iArrB[1];
        int i3 = iArrB[2];
        int i4 = iArrB[3];
        b bVar2 = new b(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = i2 + (((i5 * i4) + (i4 / 2)) / 33);
            for (int i7 = 0; i7 < 30; i7++) {
                if (bVar.a(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    bVar2.b(i7, i5);
                }
            }
        }
        return bVar2;
    }

    @Override // com.google.b.k
    public m a(com.google.b.c cVar) throws i, f, d {
        return a(cVar, null);
    }

    @Override // com.google.b.k
    public m a(com.google.b.c cVar, Map<e, ?> map) throws i, f, d {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw i.a();
        }
        com.google.b.c.e eVarA = this.f5535b.a(a(cVar.c()), map);
        m mVar = new m(eVarA.b(), eVarA.a(), f5534a, com.google.b.a.MAXICODE);
        String strD = eVarA.d();
        if (strD != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, strD);
        }
        return mVar;
    }

    @Override // com.google.b.k
    public void a() {
    }
}
