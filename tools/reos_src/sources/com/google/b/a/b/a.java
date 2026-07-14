package com.google.b.a.b;

import com.google.b.c.b;
import com.google.b.c.b.c;
import com.google.b.c.b.d;
import com.google.b.i;
import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final int[] g = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5391f;

    /* JADX INFO: renamed from: com.google.b.a.b.a$a, reason: collision with other inner class name */
    static final class C0200a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5393b;

        C0200a(int i, int i2) {
            this.f5392a = i;
            this.f5393b = i2;
        }

        o a() {
            return new o(b(), c());
        }

        int b() {
            return this.f5392a;
        }

        int c() {
            return this.f5393b;
        }

        public String toString() {
            return "<" + this.f5392a + ' ' + this.f5393b + '>';
        }
    }

    public a(b bVar) {
        this.f5386a = bVar;
    }

    private static float a(o oVar, o oVar2) {
        return com.google.b.c.a.a.a(oVar.a(), oVar.b(), oVar2.a(), oVar2.b());
    }

    private static int a(long j, boolean z) throws i {
        int i;
        int i2;
        int i3 = 0;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i4 = i - i2;
        int[] iArr = new int[i];
        for (int i5 = i - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new c(com.google.b.c.b.a.f5444d).a(iArr, i4);
            for (int i6 = 0; i6 < i2; i6++) {
                i3 = iArr[i6] + (i3 << 4);
            }
            return i3;
        } catch (d e2) {
            throw i.a();
        }
    }

    private int a(C0200a c0200a, C0200a c0200a2) {
        float fB = b(c0200a, c0200a2);
        float fB2 = (c0200a2.b() - c0200a.b()) / fB;
        float fC = (c0200a2.c() - c0200a.c()) / fB;
        float fB3 = c0200a.b();
        float fC2 = c0200a.c();
        boolean zA = this.f5386a.a(c0200a.b(), c0200a.c());
        int i = 0;
        float f2 = fB3;
        float f3 = fC2;
        for (int i2 = 0; i2 < fB; i2++) {
            f2 += fB2;
            f3 += fC;
            if (this.f5386a.a(com.google.b.c.a.a.a(f2), com.google.b.c.a.a.a(f3)) != zA) {
                i++;
            }
        }
        float f4 = i / fB;
        if (f4 <= 0.1f || f4 >= 0.9f) {
            return ((f4 > 0.1f ? 1 : (f4 == 0.1f ? 0 : -1)) <= 0) == zA ? 1 : -1;
        }
        return 0;
    }

    private int a(o oVar, o oVar2, int i) {
        int i2 = 0;
        float fA = a(oVar, oVar2);
        float f2 = fA / i;
        float fA2 = oVar.a();
        float fB = oVar.b();
        float fA3 = ((oVar2.a() - oVar.a()) * f2) / fA;
        float fB2 = (f2 * (oVar2.b() - oVar.b())) / fA;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.f5386a.a(com.google.b.c.a.a.a((i3 * fA3) + fA2), com.google.b.c.a.a.a((i3 * fB2) + fB))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private static int a(int[] iArr, int i) throws i {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + (i3 & 1) + ((i3 >> (i - 2)) << 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw i.a();
    }

    private C0200a a() {
        o oVarA;
        o oVarA2;
        o oVarA3;
        o oVarA4;
        o oVarA5;
        o oVarA6;
        o oVarA7;
        o oVarA8;
        try {
            o[] oVarArrA = new com.google.b.c.a.b(this.f5386a).a();
            oVarA = oVarArrA[0];
            oVarA2 = oVarArrA[1];
            oVarA3 = oVarArrA[2];
            oVarA4 = oVarArrA[3];
        } catch (i e2) {
            int iE = this.f5386a.e() / 2;
            int iF = this.f5386a.f() / 2;
            oVarA = a(new C0200a(iE + 7, iF - 7), false, 1, -1).a();
            oVarA2 = a(new C0200a(iE + 7, iF + 7), false, 1, 1).a();
            oVarA3 = a(new C0200a(iE - 7, iF + 7), false, -1, 1).a();
            oVarA4 = a(new C0200a(iE - 7, iF - 7), false, -1, -1).a();
        }
        int iA = com.google.b.c.a.a.a((((oVarA.a() + oVarA4.a()) + oVarA2.a()) + oVarA3.a()) / 4.0f);
        int iA2 = com.google.b.c.a.a.a((((oVarA4.b() + oVarA.b()) + oVarA2.b()) + oVarA3.b()) / 4.0f);
        try {
            o[] oVarArrA2 = new com.google.b.c.a.b(this.f5386a, 15, iA, iA2).a();
            oVarA5 = oVarArrA2[0];
            oVarA6 = oVarArrA2[1];
            oVarA7 = oVarArrA2[2];
            oVarA8 = oVarArrA2[3];
        } catch (i e3) {
            oVarA5 = a(new C0200a(iA + 7, iA2 - 7), false, 1, -1).a();
            oVarA6 = a(new C0200a(iA + 7, iA2 + 7), false, 1, 1).a();
            oVarA7 = a(new C0200a(iA - 7, iA2 + 7), false, -1, 1).a();
            oVarA8 = a(new C0200a(iA - 7, iA2 - 7), false, -1, -1).a();
        }
        return new C0200a(com.google.b.c.a.a.a((((oVarA5.a() + oVarA8.a()) + oVarA6.a()) + oVarA7.a()) / 4.0f), com.google.b.c.a.a.a((((oVarA8.b() + oVarA5.b()) + oVarA6.b()) + oVarA7.b()) / 4.0f));
    }

    private C0200a a(C0200a c0200a, boolean z, int i, int i2) {
        int iB = c0200a.b() + i;
        int iC = c0200a.c();
        while (true) {
            iC += i2;
            if (!a(iB, iC) || this.f5386a.a(iB, iC) != z) {
                break;
            }
            iB += i;
        }
        int i3 = iC - i2;
        int i4 = iB - i;
        while (a(i4, i3) && this.f5386a.a(i4, i3) == z) {
            i4 += i;
        }
        int i5 = i4 - i;
        int i6 = i3;
        while (a(i5, i6) && this.f5386a.a(i5, i6) == z) {
            i6 += i2;
        }
        return new C0200a(i5, i6 - i2);
    }

    private b a(b bVar, o oVar, o oVar2, o oVar3, o oVar4) throws i {
        com.google.b.c.i iVarA = com.google.b.c.i.a();
        int iB = b();
        float f2 = (iB / 2.0f) - this.f5390e;
        float f3 = (iB / 2.0f) + this.f5390e;
        return iVarA.a(bVar, iB, iB, f2, f2, f3, f2, f3, f3, f2, f3, oVar.a(), oVar.b(), oVar2.a(), oVar2.b(), oVar3.a(), oVar3.b(), oVar4.a(), oVar4.b());
    }

    private void a(o[] oVarArr) throws i {
        long j;
        int i;
        if (!a(oVarArr[0]) || !a(oVarArr[1]) || !a(oVarArr[2]) || !a(oVarArr[3])) {
            throw i.a();
        }
        int i2 = this.f5390e * 2;
        int[] iArr = {a(oVarArr[0], oVarArr[1], i2), a(oVarArr[1], oVarArr[2], i2), a(oVarArr[2], oVarArr[3], i2), a(oVarArr[3], oVarArr[0], i2)};
        this.f5391f = a(iArr, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[(this.f5391f + i3) % 4];
            if (this.f5387b) {
                j = j2 << 7;
                i = (i4 >> 1) & 127;
            } else {
                j = j2 << 10;
                i = ((i4 >> 1) & 31) + ((i4 >> 2) & 992);
            }
            j2 = j + ((long) i);
        }
        int iA = a(j2, this.f5387b);
        if (this.f5387b) {
            this.f5388c = (iA >> 6) + 1;
            this.f5389d = (iA & 63) + 1;
        } else {
            this.f5388c = (iA >> 11) + 1;
            this.f5389d = (iA & 2047) + 1;
        }
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.f5386a.e() && i2 > 0 && i2 < this.f5386a.f();
    }

    private boolean a(C0200a c0200a, C0200a c0200a2, C0200a c0200a3, C0200a c0200a4) {
        C0200a c0200a5 = new C0200a(c0200a.b() - 3, c0200a.c() + 3);
        C0200a c0200a6 = new C0200a(c0200a2.b() - 3, c0200a2.c() - 3);
        C0200a c0200a7 = new C0200a(c0200a3.b() + 3, c0200a3.c() - 3);
        C0200a c0200a8 = new C0200a(c0200a4.b() + 3, 3 + c0200a4.c());
        int iA = a(c0200a8, c0200a5);
        return iA != 0 && a(c0200a5, c0200a6) == iA && a(c0200a6, c0200a7) == iA && a(c0200a7, c0200a8) == iA;
    }

    private boolean a(o oVar) {
        return a(com.google.b.c.a.a.a(oVar.a()), com.google.b.c.a.a.a(oVar.b()));
    }

    private o[] a(C0200a c0200a) throws i {
        boolean z = true;
        this.f5390e = 1;
        C0200a c0200a2 = c0200a;
        C0200a c0200a3 = c0200a;
        C0200a c0200a4 = c0200a;
        while (this.f5390e < 9) {
            C0200a c0200aA = a(c0200a4, z, 1, -1);
            C0200a c0200aA2 = a(c0200a3, z, 1, 1);
            C0200a c0200aA3 = a(c0200a2, z, -1, 1);
            C0200a c0200aA4 = a(c0200a, z, -1, -1);
            if (this.f5390e > 2) {
                float fB = (b(c0200aA4, c0200aA) * this.f5390e) / (b(c0200a, c0200a4) * (this.f5390e + 2));
                if (fB < 0.75d || fB > 1.25d || !a(c0200aA, c0200aA2, c0200aA3, c0200aA4)) {
                    break;
                }
            }
            z = !z;
            this.f5390e++;
            c0200a = c0200aA4;
            c0200a2 = c0200aA3;
            c0200a3 = c0200aA2;
            c0200a4 = c0200aA;
        }
        if (this.f5390e != 5 && this.f5390e != 7) {
            throw i.a();
        }
        this.f5387b = this.f5390e == 5;
        return a(new o[]{new o(c0200a4.b() + 0.5f, c0200a4.c() - 0.5f), new o(c0200a3.b() + 0.5f, c0200a3.c() + 0.5f), new o(c0200a2.b() - 0.5f, c0200a2.c() + 0.5f), new o(c0200a.b() - 0.5f, c0200a.c() - 0.5f)}, (this.f5390e * 2) - 3, this.f5390e * 2);
    }

    private static o[] a(o[] oVarArr, float f2, float f3) {
        float f4 = f3 / (2.0f * f2);
        float fA = oVarArr[0].a() - oVarArr[2].a();
        float fB = oVarArr[0].b() - oVarArr[2].b();
        float fA2 = (oVarArr[0].a() + oVarArr[2].a()) / 2.0f;
        float fB2 = (oVarArr[0].b() + oVarArr[2].b()) / 2.0f;
        o oVar = new o((f4 * fA) + fA2, (f4 * fB) + fB2);
        o oVar2 = new o(fA2 - (fA * f4), fB2 - (fB * f4));
        float fA3 = oVarArr[1].a() - oVarArr[3].a();
        float fB3 = oVarArr[1].b() - oVarArr[3].b();
        float fA4 = (oVarArr[1].a() + oVarArr[3].a()) / 2.0f;
        float fB4 = (oVarArr[1].b() + oVarArr[3].b()) / 2.0f;
        return new o[]{oVar, new o((f4 * fA3) + fA4, (f4 * fB3) + fB4), oVar2, new o(fA4 - (fA3 * f4), fB4 - (f4 * fB3))};
    }

    private static float b(C0200a c0200a, C0200a c0200a2) {
        return com.google.b.c.a.a.a(c0200a.b(), c0200a.c(), c0200a2.b(), c0200a2.c());
    }

    private int b() {
        if (this.f5387b) {
            return (this.f5388c * 4) + 11;
        }
        return this.f5388c <= 4 ? (this.f5388c * 4) + 15 : (this.f5388c * 4) + ((((this.f5388c - 4) / 8) + 1) * 2) + 15;
    }

    private o[] b(o[] oVarArr) {
        return a(oVarArr, this.f5390e * 2, b());
    }

    public com.google.b.a.a a(boolean z) throws i {
        o[] oVarArrA = a(a());
        if (z) {
            o oVar = oVarArrA[0];
            oVarArrA[0] = oVarArrA[2];
            oVarArrA[2] = oVar;
        }
        a(oVarArrA);
        return new com.google.b.a.a(a(this.f5386a, oVarArrA[this.f5391f % 4], oVarArrA[(this.f5391f + 1) % 4], oVarArrA[(this.f5391f + 2) % 4], oVarArrA[(this.f5391f + 3) % 4]), b(oVarArrA), this.f5387b, this.f5389d, this.f5388c);
    }
}
