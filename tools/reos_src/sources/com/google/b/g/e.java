package com.google.b.g;

/* JADX INFO: loaded from: classes.dex */
public final class e extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f5621a = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f5622f = new int[4];

    private static void a(StringBuilder sb, int i) throws com.google.b.i {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f5621a[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw com.google.b.i.a();
    }

    @Override // com.google.b.g.p
    protected int a(com.google.b.c.a aVar, int[] iArr, StringBuilder sb) throws com.google.b.i {
        int[] iArr2 = this.f5622f;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iA = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < iA) {
            int iA2 = a(aVar, iArr2, i, f5645e);
            sb.append((char) ((iA2 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iA2 >= 10) {
                i3 |= 1 << (5 - i2);
            }
            i2++;
            i = i4;
        }
        a(sb, i3);
        int i6 = a(aVar, i, true, f5643c)[1];
        int i7 = 0;
        while (i7 < 6 && i6 < iA) {
            sb.append((char) (a(aVar, iArr2, i6, f5644d) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    @Override // com.google.b.g.p
    com.google.b.a b() {
        return com.google.b.a.EAN_13;
    }
}
