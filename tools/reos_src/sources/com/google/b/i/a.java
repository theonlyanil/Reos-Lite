package com.google.b.i;

import com.google.b.c;
import com.google.b.c.b;
import com.google.b.c.g;
import com.google.b.d;
import com.google.b.f;
import com.google.b.i;
import com.google.b.i.a.e;
import com.google.b.k;
import com.google.b.m;
import com.google.b.n;
import com.google.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o[] f5712a = new o[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f5713b = new e();

    private static float a(int[] iArr, b bVar) throws i {
        boolean z;
        int iF = bVar.f();
        int iE = bVar.e();
        int i = iArr[0];
        boolean z2 = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < iE && i2 < iF) {
            if (z2 != bVar.a(i3, i2)) {
                int i5 = i4 + 1;
                if (i5 == 5) {
                    break;
                }
                z = !z2;
                i4 = i5;
            } else {
                z = z2;
            }
            i3++;
            i2++;
            z2 = z;
        }
        if (i3 == iE || i2 == iF) {
            throw i.a();
        }
        return (i3 - iArr[0]) / 7.0f;
    }

    private static b a(b bVar) throws i {
        int i;
        int i2;
        int[] iArrC = bVar.c();
        int[] iArrD = bVar.d();
        if (iArrC == null || iArrD == null) {
            throw i.a();
        }
        float fA = a(iArrC, bVar);
        int i3 = iArrC[1];
        int i4 = iArrD[1];
        int i5 = iArrC[0];
        int i6 = iArrD[0];
        if (i5 >= i6 || i3 >= i4) {
            throw i.a();
        }
        if (i4 - i3 != i6 - i5) {
            i6 = (i4 - i3) + i5;
        }
        int iRound = Math.round(((i6 - i5) + 1) / fA);
        int iRound2 = Math.round(((i4 - i3) + 1) / fA);
        if (iRound <= 0 || iRound2 <= 0) {
            throw i.a();
        }
        if (iRound2 != iRound) {
            throw i.a();
        }
        int i7 = (int) (fA / 2.0f);
        int i8 = i3 + i7;
        int i9 = i5 + i7;
        int i10 = (((int) ((iRound - 1) * fA)) + i9) - i6;
        if (i10 <= 0) {
            i = i9;
        } else {
            if (i10 > i7) {
                throw i.a();
            }
            i = i9 - i10;
        }
        int i11 = (((int) ((iRound2 - 1) * fA)) + i8) - i4;
        if (i11 <= 0) {
            i2 = i8;
        } else {
            if (i11 > i7) {
                throw i.a();
            }
            i2 = i8 - i11;
        }
        b bVar2 = new b(iRound, iRound2);
        for (int i12 = 0; i12 < iRound2; i12++) {
            int i13 = i2 + ((int) (i12 * fA));
            for (int i14 = 0; i14 < iRound; i14++) {
                if (bVar.a(((int) (i14 * fA)) + i, i13)) {
                    bVar2.b(i14, i12);
                }
            }
        }
        return bVar2;
    }

    @Override // com.google.b.k
    public m a(c cVar) throws i, f, d {
        return a(cVar, (Map<com.google.b.e, ?>) null);
    }

    @Override // com.google.b.k
    public final m a(c cVar, Map<com.google.b.e, ?> map) throws i, f, d {
        com.google.b.c.e eVarA;
        o[] oVarArrE;
        if (map == null || !map.containsKey(com.google.b.e.PURE_BARCODE)) {
            g gVarA = new com.google.b.i.b.c(cVar.c()).a(map);
            eVarA = this.f5713b.a(gVarA.d(), map);
            oVarArrE = gVarA.e();
        } else {
            eVarA = this.f5713b.a(a(cVar.c()), map);
            oVarArrE = f5712a;
        }
        if (eVarA.e() instanceof com.google.b.i.a.i) {
            ((com.google.b.i.a.i) eVarA.e()).a(oVarArrE);
        }
        m mVar = new m(eVarA.b(), eVarA.a(), oVarArrE, com.google.b.a.QR_CODE);
        List<byte[]> listC = eVarA.c();
        if (listC != null) {
            mVar.a(n.BYTE_SEGMENTS, listC);
        }
        String strD = eVarA.d();
        if (strD != null) {
            mVar.a(n.ERROR_CORRECTION_LEVEL, strD);
        }
        if (eVarA.f()) {
            mVar.a(n.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarA.h()));
            mVar.a(n.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarA.g()));
        }
        return mVar;
    }

    @Override // com.google.b.k
    public void a() {
    }
}
