package com.google.b.g;

/* JADX INFO: loaded from: classes.dex */
public final class f extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f5623a = new int[4];

    @Override // com.google.b.g.p
    protected int a(com.google.b.c.a aVar, int[] iArr, StringBuilder sb) throws com.google.b.i {
        int[] iArr2 = this.f5623a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iA = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        while (i2 < 4 && i < iA) {
            sb.append((char) (a(aVar, iArr2, i, f5644d) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        int i5 = a(aVar, i, true, f5643c)[1];
        int i6 = 0;
        while (i6 < 4 && i5 < iA) {
            sb.append((char) (a(aVar, iArr2, i5, f5644d) + 48));
            int i7 = i5;
            for (int i8 : iArr2) {
                i7 += i8;
            }
            i6++;
            i5 = i7;
        }
        return i5;
    }

    @Override // com.google.b.g.p
    com.google.b.a b() {
        return com.google.b.a.EAN_8;
    }
}
