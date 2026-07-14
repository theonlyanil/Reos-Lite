package com.google.b.c.a;

import com.google.b.i;
import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b f5431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5436f;
    private final int g;

    public b(com.google.b.c.b bVar) throws i {
        this(bVar, 10, bVar.e() / 2, bVar.f() / 2);
    }

    public b(com.google.b.c.b bVar, int i, int i2, int i3) throws i {
        this.f5431a = bVar;
        this.f5432b = bVar.f();
        this.f5433c = bVar.e();
        int i4 = i / 2;
        this.f5434d = i2 - i4;
        this.f5435e = i2 + i4;
        this.g = i3 - i4;
        this.f5436f = i4 + i3;
        if (this.g < 0 || this.f5434d < 0 || this.f5436f >= this.f5432b || this.f5435e >= this.f5433c) {
            throw i.a();
        }
    }

    private o a(float f2, float f3, float f4, float f5) {
        int iA = a.a(a.a(f2, f3, f4, f5));
        float f6 = (f4 - f2) / iA;
        float f7 = (f5 - f3) / iA;
        for (int i = 0; i < iA; i++) {
            int iA2 = a.a((i * f6) + f2);
            int iA3 = a.a((i * f7) + f3);
            if (this.f5431a.a(iA2, iA3)) {
                return new o(iA2, iA3);
            }
        }
        return null;
    }

    private boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f5431a.a(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.f5431a.a(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private o[] a(o oVar, o oVar2, o oVar3, o oVar4) {
        float fA = oVar.a();
        float fB = oVar.b();
        float fA2 = oVar2.a();
        float fB2 = oVar2.b();
        float fA3 = oVar3.a();
        float fB3 = oVar3.b();
        float fA4 = oVar4.a();
        float fB4 = oVar4.b();
        return fA < ((float) this.f5433c) / 2.0f ? new o[]{new o(fA4 - 1.0f, fB4 + 1.0f), new o(fA2 + 1.0f, fB2 + 1.0f), new o(fA3 - 1.0f, fB3 - 1.0f), new o(fA + 1.0f, fB - 1.0f)} : new o[]{new o(fA4 + 1.0f, fB4 + 1.0f), new o(fA2 + 1.0f, fB2 - 1.0f), new o(fA3 - 1.0f, fB3 + 1.0f), new o(fA - 1.0f, fB - 1.0f)};
    }

    public o[] a() throws i {
        int i;
        int i2;
        int i3;
        int i4;
        o oVar;
        o oVar2;
        o oVar3;
        boolean z = false;
        int i5 = this.f5434d;
        int i6 = this.f5435e;
        int i7 = this.g;
        int i8 = this.f5436f;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        while (true) {
            if (!z7) {
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            boolean zA = true;
            boolean z8 = z5;
            boolean z9 = false;
            while (true) {
                if ((!zA && z8) || i6 >= this.f5433c) {
                    break;
                }
                zA = a(i7, i8, i6, false);
                if (zA) {
                    i6++;
                    z8 = true;
                    z9 = true;
                } else if (!z8) {
                    i6++;
                }
            }
            if (i6 >= this.f5433c) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            boolean z10 = z4;
            boolean z11 = z9;
            boolean zA2 = true;
            while (true) {
                if ((!zA2 && z10) || i8 >= this.f5432b) {
                    break;
                }
                zA2 = a(i5, i6, i8, true);
                if (zA2) {
                    i8++;
                    z10 = true;
                    z11 = true;
                } else if (!z10) {
                    i8++;
                }
            }
            if (i8 >= this.f5432b) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            boolean z12 = z3;
            boolean z13 = z11;
            boolean zA3 = true;
            while (true) {
                if ((!zA3 && z12) || i5 < 0) {
                    break;
                }
                zA3 = a(i7, i8, i5, false);
                if (zA3) {
                    i5--;
                    z12 = true;
                    z13 = true;
                } else if (!z12) {
                    i5--;
                }
            }
            if (i5 < 0) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            boolean z14 = z13;
            boolean z15 = z2;
            boolean zA4 = true;
            while (true) {
                if ((!zA4 && z15) || i7 < 0) {
                    break;
                }
                zA4 = a(i5, i6, i7, true);
                if (zA4) {
                    i7--;
                    z15 = true;
                    z14 = true;
                } else if (!z15) {
                    i7--;
                }
            }
            if (i7 < 0) {
                z = true;
                i = i6;
                i2 = i8;
                i3 = i5;
                i4 = i7;
                break;
            }
            if (z14) {
                z6 = true;
            }
            z2 = z15;
            z3 = z12;
            z5 = z8;
            boolean z16 = z10;
            z7 = z14;
            z4 = z16;
        }
        if (z || !z6) {
            throw i.a();
        }
        int i9 = i - i3;
        int i10 = 1;
        o oVarA = null;
        while (true) {
            if (i10 >= i9) {
                oVar = oVarA;
                break;
            }
            oVarA = a(i3, i2 - i10, i3 + i10, i2);
            if (oVarA != null) {
                oVar = oVarA;
                break;
            }
            i10++;
        }
        if (oVar == null) {
            throw i.a();
        }
        int i11 = 1;
        o oVarA2 = null;
        while (true) {
            if (i11 >= i9) {
                oVar2 = oVarA2;
                break;
            }
            oVarA2 = a(i3, i4 + i11, i3 + i11, i4);
            if (oVarA2 != null) {
                oVar2 = oVarA2;
                break;
            }
            i11++;
        }
        if (oVar2 == null) {
            throw i.a();
        }
        int i12 = 1;
        o oVarA3 = null;
        while (true) {
            if (i12 >= i9) {
                oVar3 = oVarA3;
                break;
            }
            oVarA3 = a(i, i4 + i12, i - i12, i4);
            if (oVarA3 != null) {
                oVar3 = oVarA3;
                break;
            }
            i12++;
        }
        if (oVar3 == null) {
            throw i.a();
        }
        o oVarA4 = null;
        for (int i13 = 1; i13 < i9; i13++) {
            oVarA4 = a(i, i2 - i13, i - i13, i2);
            if (oVarA4 != null) {
                break;
            }
        }
        if (oVarA4 == null) {
            throw i.a();
        }
        return a(oVarA4, oVar, oVar3, oVar2);
    }
}
