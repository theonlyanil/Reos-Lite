package com.google.b.d;

import com.google.b.c;
import com.google.b.c.b;
import com.google.b.c.g;
import com.google.b.d.a.d;
import com.google.b.e;
import com.google.b.f;
import com.google.b.i;
import com.google.b.k;
import com.google.b.m;
import com.google.b.n;
import com.google.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o[] f5481a = new o[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f5482b = new d();

    private static int a(int[] iArr, b bVar) throws i {
        int iE = bVar.e();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < iE && bVar.a(i, i2)) {
            i++;
        }
        if (i == iE) {
            throw i.a();
        }
        int i3 = i - iArr[0];
        if (i3 == 0) {
            throw i.a();
        }
        return i3;
    }

    private static b a(b bVar) throws i {
        int[] iArrC = bVar.c();
        int[] iArrD = bVar.d();
        if (iArrC == null || iArrD == null) {
            throw i.a();
        }
        int iA = a(iArrC, bVar);
        int i = iArrC[1];
        int i2 = iArrD[1];
        int i3 = iArrC[0];
        int i4 = ((iArrD[0] - i3) + 1) / iA;
        int i5 = ((i2 - i) + 1) / iA;
        if (i4 <= 0 || i5 <= 0) {
            throw i.a();
        }
        int i6 = iA / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        b bVar2 = new b(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = i7 + (i9 * iA);
            for (int i11 = 0; i11 < i4; i11++) {
                if (bVar.a((i11 * iA) + i8, i10)) {
                    bVar2.b(i11, i9);
                }
            }
        }
        return bVar2;
    }

    @Override // com.google.b.k
    public m a(c cVar) throws i, f, com.google.b.d {
        return a(cVar, (Map<e, ?>) null);
    }

    @Override // com.google.b.k
    public m a(c cVar, Map<e, ?> map) throws i, f, com.google.b.d {
        com.google.b.c.e eVarA;
        o[] oVarArrE;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g gVarA = new com.google.b.d.b.a(cVar.c()).a();
            eVarA = this.f5482b.a(gVarA.d());
            oVarArrE = gVarA.e();
        } else {
            eVarA = this.f5482b.a(a(cVar.c()));
            oVarArrE = f5481a;
        }
        m mVar = new m(eVarA.b(), eVarA.a(), oVarArrE, com.google.b.a.DATA_MATRIX);
        List<byte[]> listC = eVarA.c();
        if (listC != null) {
            mVar.a(n.BYTE_SEGMENTS, listC);
        }
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
