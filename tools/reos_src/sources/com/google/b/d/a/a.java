package com.google.b.d.a;

import com.google.b.f;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b f5483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.b.c.b f5484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f5485c;

    a(com.google.b.c.b bVar) throws f {
        int iF = bVar.f();
        if (iF < 8 || iF > 144 || (iF & 1) != 0) {
            throw f.a();
        }
        this.f5485c = b(bVar);
        this.f5483a = a(bVar);
        this.f5484b = new com.google.b.c.b(this.f5483a.e(), this.f5483a.f());
    }

    private static e b(com.google.b.c.b bVar) throws f {
        return e.a(bVar.f(), bVar.e());
    }

    int a(int i, int i2) {
        int i3 = (a(i + (-1), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 1, 1, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 2, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 1, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(1, i2 - 1, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (a(2, i2 - 1, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        return a(3, i2 + (-1), i, i2) ? i9 | 1 : i9;
    }

    com.google.b.c.b a(com.google.b.c.b bVar) {
        int iB = this.f5485c.b();
        int iC = this.f5485c.c();
        if (bVar.f() != iB) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int iD = this.f5485c.d();
        int iE = this.f5485c.e();
        int i = iB / iD;
        int i2 = iC / iE;
        com.google.b.c.b bVar2 = new com.google.b.c.b(i2 * iE, i * iD);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * iD;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * iE;
                for (int i7 = 0; i7 < iD; i7++) {
                    int i8 = ((iD + 2) * i3) + 1 + i7;
                    int i9 = i4 + i7;
                    for (int i10 = 0; i10 < iE; i10++) {
                        if (bVar.a(((iE + 2) * i5) + 1 + i10, i8)) {
                            bVar2.b(i6 + i10, i9);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    e a() {
        return this.f5485c;
    }

    boolean a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0) {
            i6 = i + i3;
            i5 = (4 - ((i3 + 4) & 7)) + i2;
        } else {
            i5 = i2;
            i6 = i;
        }
        if (i5 < 0) {
            i5 += i4;
            i6 += 4 - ((i4 + 4) & 7);
        }
        this.f5484b.b(i5, i6);
        return this.f5483a.a(i5, i6);
    }

    int b(int i, int i2) {
        int i3 = (a(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (a(0, i2 - 1, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        return a(1, i2 + (-1), i, i2) ? i9 | 1 : i9;
    }

    int b(int i, int i2, int i3, int i4) {
        int i5 = (a(i + (-2), i2 + (-2), i3, i4) ? 1 : 0) << 1;
        if (a(i - 2, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(i - 1, i2 - 2, i3, i4)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(i - 1, i2 - 1, i3, i4)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (a(i - 1, i2, i3, i4)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(i, i2 - 2, i3, i4)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(i, i2 - 1, i3, i4)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(i, i2, i3, i4) ? i11 | 1 : i11;
    }

    byte[] b() throws f {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z = false;
        byte[] bArr = new byte[this.f5485c.f()];
        int iF = this.f5483a.f();
        int iE = this.f5483a.e();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i7 = 0;
        int i8 = 4;
        int i9 = 0;
        while (true) {
            if (i8 == iF && i7 == 0 && !z4) {
                bArr[i9] = (byte) a(iF, iE);
                int i10 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i10;
                z4 = true;
            } else if (i8 == iF - 2 && i7 == 0 && (iE & 3) != 0 && !z3) {
                bArr[i9] = (byte) b(iF, iE);
                int i11 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i11;
                z3 = true;
            } else if (i8 == iF + 4 && i7 == 2 && (iE & 7) == 0 && !z2) {
                bArr[i9] = (byte) c(iF, iE);
                int i12 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i12;
                z2 = true;
            } else if (i8 == iF - 2 && i7 == 0 && (iE & 7) == 4 && !z) {
                bArr[i9] = (byte) d(iF, iE);
                int i13 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i13;
                z = true;
            } else {
                int i14 = i7;
                int i15 = i8;
                int i16 = i9;
                int i17 = i15;
                while (true) {
                    if (i17 >= iF || i14 < 0 || this.f5484b.a(i14, i17)) {
                        i = i16;
                    } else {
                        i = i16 + 1;
                        bArr[i16] = (byte) b(i17, i14, iF, iE);
                    }
                    i17 -= 2;
                    i2 = i14 + 2;
                    if (i17 < 0 || i2 >= iE) {
                        break;
                    }
                    i14 = i2;
                    i16 = i;
                }
                int i18 = i17 + 1;
                int i19 = i2 + 3;
                int i20 = i;
                while (true) {
                    if (i18 < 0 || i19 >= iE || this.f5484b.a(i19, i18)) {
                        i3 = i20;
                    } else {
                        i3 = i20 + 1;
                        bArr[i20] = (byte) b(i18, i19, iF, iE);
                    }
                    i18 += 2;
                    i4 = i19 - 2;
                    if (i18 >= iF || i4 < 0) {
                        break;
                    }
                    i19 = i4;
                    i20 = i3;
                }
                i5 = i18 + 3;
                i6 = i4 + 1;
            }
            if (i5 >= iF && i6 >= iE) {
                break;
            }
            i9 = i3;
            i7 = i6;
            i8 = i5;
        }
        if (i3 != this.f5485c.f()) {
            throw f.a();
        }
        return bArr;
    }

    int c(int i, int i2) {
        int i3 = (a(i + (-1), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(0, i2 - 3, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 1, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(1, i2 - 3, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (a(1, i2 - 2, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        return a(1, i2 + (-1), i, i2) ? i9 | 1 : i9;
    }

    int d(int i, int i2) {
        int i3 = (a(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 1, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(1, i2 - 1, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (a(2, i2 - 1, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        return a(3, i2 + (-1), i, i2) ? i9 | 1 : i9;
    }
}
