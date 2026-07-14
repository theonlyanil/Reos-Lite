package com.google.b.f.a;

import com.flurry.android.Constants;
import com.google.b.c.e;
import com.google.b.d;
import com.google.b.f;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b.c f5541a = new com.google.b.c.b.c(com.google.b.c.b.a.h);

    private void a(byte[] bArr, int i, int i2, int i3, int i4) throws d {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & Constants.UNKNOWN;
            }
        }
        try {
            this.f5541a.a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (com.google.b.c.b.d e2) {
            throw d.a();
        }
    }

    public e a(com.google.b.c.b bVar, Map<com.google.b.e, ?> map) throws f, d {
        byte[] bArr;
        byte[] bArrA = new a(bVar).a();
        a(bArrA, 0, 10, 10, 0);
        int i = bArrA[0] & 15;
        switch (i) {
            case 2:
            case 3:
            case 4:
                a(bArrA, 20, 84, 40, 1);
                a(bArrA, 20, 84, 40, 2);
                bArr = new byte[94];
                break;
            case 5:
                a(bArrA, 20, 68, 56, 1);
                a(bArrA, 20, 68, 56, 2);
                bArr = new byte[78];
                break;
            default:
                throw f.a();
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i);
    }
}
