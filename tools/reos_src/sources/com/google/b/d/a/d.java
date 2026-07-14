package com.google.b.d.a;

import com.flurry.android.Constants;
import com.google.b.f;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b.c f5500a = new com.google.b.c.b.c(com.google.b.c.b.a.f5446f);

    private void a(byte[] bArr, int i) throws com.google.b.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & Constants.UNKNOWN;
        }
        try {
            this.f5500a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.google.b.c.b.d e2) {
            throw com.google.b.d.a();
        }
    }

    public com.google.b.c.e a(com.google.b.c.b bVar) throws f, com.google.b.d {
        a aVar = new a(bVar);
        b[] bVarArrA = b.a(aVar.b(), aVar.a());
        int length = bVarArrA.length;
        int iA = 0;
        for (b bVar2 : bVarArrA) {
            iA += bVar2.a();
        }
        byte[] bArr = new byte[iA];
        for (int i = 0; i < length; i++) {
            b bVar3 = bVarArrA[i];
            byte[] bArrB = bVar3.b();
            int iA2 = bVar3.a();
            a(bArrB, iA2);
            for (int i2 = 0; i2 < iA2; i2++) {
                bArr[(i2 * length) + i] = bArrB[i2];
            }
        }
        return c.a(bArr);
    }
}
