package com.google.b.i.a;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b f5714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f5715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f5716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5717d;

    a(com.google.b.c.b bVar) throws com.google.b.f {
        int iF = bVar.f();
        if (iF < 21 || (iF & 3) != 1) {
            throw com.google.b.f.a();
        }
        this.f5714a = bVar;
    }

    private int a(int i, int i2, int i3) {
        return this.f5717d ? this.f5714a.a(i2, i) : this.f5714a.a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    g a() throws com.google.b.f {
        int iA = 0;
        if (this.f5716c != null) {
            return this.f5716c;
        }
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int iF = this.f5714a.f();
        int i3 = iF - 7;
        for (int i4 = iF - 1; i4 >= i3; i4--) {
            iA = a(8, i4, iA);
        }
        for (int i5 = iF - 8; i5 < iF; i5++) {
            iA = a(i5, 8, iA);
        }
        this.f5716c = g.b(iA3, iA);
        if (this.f5716c != null) {
            return this.f5716c;
        }
        throw com.google.b.f.a();
    }

    void a(boolean z) {
        this.f5715b = null;
        this.f5716c = null;
        this.f5717d = z;
    }

    j b() throws com.google.b.f {
        if (this.f5715b != null) {
            return this.f5715b;
        }
        int iF = this.f5714a.f();
        int i = (iF - 17) / 4;
        if (i <= 6) {
            return j.b(i);
        }
        int i2 = iF - 11;
        int iA = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = iF - 9; i4 >= i2; i4--) {
                iA = a(i4, i3, iA);
            }
        }
        j jVarC = j.c(iA);
        if (jVarC != null && jVarC.d() == iF) {
            this.f5715b = jVarC;
            return jVarC;
        }
        int iA2 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = iF - 9; i6 >= i2; i6--) {
                iA2 = a(i5, i6, iA2);
            }
        }
        j jVarC2 = j.c(iA2);
        if (jVarC2 == null || jVarC2.d() != iF) {
            throw com.google.b.f.a();
        }
        this.f5715b = jVarC2;
        return jVarC2;
    }

    byte[] c() throws com.google.b.f {
        g gVarA = a();
        j jVarB = b();
        c cVarA = c.a(gVarA.b());
        int iF = this.f5714a.f();
        cVarA.a(this.f5714a, iF);
        com.google.b.c.b bVarE = jVarB.e();
        byte[] bArr = new byte[jVarB.c()];
        int i = iF - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            for (int i5 = 0; i5 < iF; i5++) {
                int i6 = z ? (iF - 1) - i5 : i5;
                for (int i7 = 0; i7 < 2; i7++) {
                    if (!bVarE.a(i - i7, i6)) {
                        i2++;
                        i3 <<= 1;
                        if (this.f5714a.a(i - i7, i6)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4++;
                            i2 = 0;
                        }
                    }
                }
            }
            i -= 2;
            z = !z;
        }
        if (i4 != jVarB.c()) {
            throw com.google.b.f.a();
        }
        return bArr;
    }

    void d() {
        if (this.f5716c == null) {
            return;
        }
        c.a(this.f5716c.b()).a(this.f5714a, this.f5714a.f());
    }

    void e() {
        for (int i = 0; i < this.f5714a.e(); i++) {
            for (int i2 = i + 1; i2 < this.f5714a.f(); i2++) {
                if (this.f5714a.a(i, i2) != this.f5714a.a(i2, i)) {
                    this.f5714a.c(i2, i);
                    this.f5714a.c(i, i2);
                }
            }
        }
    }
}
