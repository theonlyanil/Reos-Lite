package com.google.b.i.a;

import com.flurry.android.Constants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b.c f5722a = new com.google.b.c.b.c(com.google.b.c.b.a.f5445e);

    private com.google.b.c.e a(a aVar, Map<com.google.b.e, ?> map) throws com.google.b.f, com.google.b.d {
        j jVarB = aVar.b();
        f fVarA = aVar.a().a();
        b[] bVarArrA = b.a(aVar.c(), jVarB, fVarA);
        int iA = 0;
        for (b bVar : bVarArrA) {
            iA += bVar.a();
        }
        byte[] bArr = new byte[iA];
        int length = bVarArrA.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            b bVar2 = bVarArrA[i];
            byte[] bArrB = bVar2.b();
            int iA2 = bVar2.a();
            a(bArrB, iA2);
            int i3 = i2;
            int i4 = 0;
            while (i4 < iA2) {
                bArr[i3] = bArrB[i4];
                i4++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        return d.a(bArr, jVarB, fVarA, map);
    }

    private void a(byte[] bArr, int i) throws com.google.b.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & Constants.UNKNOWN;
        }
        try {
            this.f5722a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.google.b.c.b.d e2) {
            throw com.google.b.d.a();
        }
    }

    public com.google.b.c.e a(com.google.b.c.b bVar, Map<com.google.b.e, ?> map) throws com.google.b.f, com.google.b.d {
        com.google.b.f fVar;
        com.google.b.d e2;
        a aVar = new a(bVar);
        try {
            return a(aVar, map);
        } catch (com.google.b.d e3) {
            e2 = e3;
            fVar = null;
            try {
                aVar.d();
                aVar.a(true);
                aVar.b();
                aVar.a();
                aVar.e();
                com.google.b.c.e eVarA = a(aVar, map);
                eVarA.a(new i(true));
                return eVarA;
            } catch (com.google.b.d | com.google.b.f e4) {
                if (fVar != null) {
                    throw fVar;
                }
                if (e2 != null) {
                    throw e2;
                }
                throw e4;
            }
        } catch (com.google.b.f e5) {
            fVar = e5;
            e2 = null;
            aVar.d();
            aVar.a(true);
            aVar.b();
            aVar.a();
            aVar.e();
            com.google.b.c.e eVarA2 = a(aVar, map);
            eVarA2.a(new i(true));
            return eVarA2;
        }
    }
}
