package com.google.b.i.b;

import com.google.b.c.g;
import com.google.b.c.k;
import com.google.b.i;
import com.google.b.i.a.j;
import com.google.b.o;
import com.google.b.p;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.b.c.b f5757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p f5758b;

    public c(com.google.b.c.b bVar) {
        this.f5757a = bVar;
    }

    private float a(int i, int i2, int i3, int i4) {
        int iE;
        float fE;
        float f2;
        int iF = 0;
        float fB = b(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        if (i5 < 0) {
            fE = i / (i - i5);
            iE = 0;
        } else if (i5 >= this.f5757a.e()) {
            fE = ((this.f5757a.e() - 1) - i) / (i5 - i);
            iE = this.f5757a.e() - 1;
        } else {
            iE = i5;
            fE = 1.0f;
        }
        int i6 = (int) (i2 - (fE * (i4 - i2)));
        if (i6 < 0) {
            f2 = i2 / (i2 - i6);
        } else if (i6 >= this.f5757a.f()) {
            f2 = ((this.f5757a.f() - 1) - i2) / (i6 - i2);
            iF = this.f5757a.f() - 1;
        } else {
            iF = i6;
            f2 = 1.0f;
        }
        return (b(i, i2, (int) ((f2 * (iE - i)) + i), iF) + fB) - 1.0f;
    }

    private float a(o oVar, o oVar2) {
        float fA = a((int) oVar.a(), (int) oVar.b(), (int) oVar2.a(), (int) oVar2.b());
        float fA2 = a((int) oVar2.a(), (int) oVar2.b(), (int) oVar.a(), (int) oVar.b());
        if (Float.isNaN(fA)) {
            return fA2 / 7.0f;
        }
        return Float.isNaN(fA2) ? fA / 7.0f : (fA + fA2) / 14.0f;
    }

    private static int a(o oVar, o oVar2, o oVar3, float f2) throws i {
        int iA = ((com.google.b.c.a.a.a(o.a(oVar, oVar2) / f2) + com.google.b.c.a.a.a(o.a(oVar, oVar3) / f2)) / 2) + 7;
        switch (iA & 3) {
            case 0:
                return iA + 1;
            case 1:
            default:
                return iA;
            case 2:
                return iA - 1;
            case 3:
                throw i.a();
        }
    }

    private static com.google.b.c.b a(com.google.b.c.b bVar, k kVar, int i) throws i {
        return com.google.b.c.i.a().a(bVar, i, i, kVar);
    }

    private static k a(o oVar, o oVar2, o oVar3, o oVar4, int i) {
        float fA;
        float fB;
        float f2;
        float f3;
        float f4 = i - 3.5f;
        if (oVar4 != null) {
            fA = oVar4.a();
            fB = oVar4.b();
            f2 = f4 - 3.0f;
            f3 = f2;
        } else {
            fA = (oVar2.a() - oVar.a()) + oVar3.a();
            fB = (oVar2.b() - oVar.b()) + oVar3.b();
            f2 = f4;
            f3 = f4;
        }
        return k.a(3.5f, 3.5f, f4, 3.5f, f3, f2, 3.5f, f4, oVar.a(), oVar.b(), oVar2.a(), oVar2.b(), fA, fB, oVar3.a(), oVar3.b());
    }

    private float b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (!z) {
            i4 = i3;
            i3 = i4;
            i2 = i;
            i = i2;
        }
        int iAbs = Math.abs(i4 - i2);
        int iAbs2 = Math.abs(i3 - i);
        int i9 = (-iAbs) / 2;
        int i10 = i2 < i4 ? 1 : -1;
        int i11 = i < i3 ? 1 : -1;
        int i12 = 0;
        int i13 = i4 + i10;
        int i14 = i2;
        int i15 = i9;
        int i16 = i;
        while (true) {
            if (i14 == i13) {
                i5 = i12;
                break;
            }
            if ((i12 == 1) != this.f5757a.a(z ? i16 : i14, z ? i14 : i16)) {
                i6 = i12;
            } else {
                if (i12 == 2) {
                    return com.google.b.c.a.a.a(i14, i16, i2, i);
                }
                i6 = i12 + 1;
            }
            int i17 = i15 + iAbs2;
            if (i17 <= 0) {
                i7 = i16;
                i8 = i17;
            } else {
                if (i16 == i3) {
                    i5 = i6;
                    break;
                }
                i7 = i16 + i11;
                i8 = i17 - iAbs;
            }
            i14 += i10;
            i12 = i6;
            i15 = i8;
            i16 = i7;
        }
        if (i5 == 2) {
            return com.google.b.c.a.a.a(i4 + i10, i3, i2, i);
        }
        return Float.NaN;
    }

    protected final float a(o oVar, o oVar2, o oVar3) {
        return (a(oVar, oVar2) + a(oVar, oVar3)) / 2.0f;
    }

    protected final g a(f fVar) throws i, com.google.b.f {
        d dVarB = fVar.b();
        d dVarC = fVar.c();
        d dVarA = fVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw i.a();
        }
        int iA = a(dVarB, dVarC, dVarA, fA);
        j jVarA = j.a(iA);
        int iD = jVarA.d() - 7;
        a aVarA = null;
        if (jVarA.b().length > 0) {
            float fA2 = (dVarC.a() - dVarB.a()) + dVarA.a();
            float fB = (dVarC.b() - dVarB.b()) + dVarA.b();
            float f2 = 1.0f - (3.0f / iD);
            int iA2 = (int) (((fA2 - dVarB.a()) * f2) + dVarB.a());
            int iB = (int) (dVarB.b() + (f2 * (fB - dVarB.b())));
            for (int i = 4; i <= 16; i <<= 1) {
                try {
                    aVarA = a(fA, iA2, iB, i);
                    break;
                } catch (i e2) {
                }
            }
        }
        return new g(a(this.f5757a, a(dVarB, dVarC, dVarA, aVarA, iA), iA), aVarA == null ? new o[]{dVarA, dVarB, dVarC} : new o[]{dVarA, dVarB, dVarC, aVarA});
    }

    public final g a(Map<com.google.b.e, ?> map) throws i, com.google.b.f {
        this.f5758b = map == null ? null : (p) map.get(com.google.b.e.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.f5757a, this.f5758b).a(map));
    }

    protected final a a(float f2, int i, int i2, float f3) throws i {
        int i3 = (int) (f3 * f2);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.f5757a.e() - 1, i + i3);
        if (iMin - iMax < f2 * 3.0f) {
            throw i.a();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.f5757a.f() - 1, i3 + i2);
        if (iMin2 - iMax2 < f2 * 3.0f) {
            throw i.a();
        }
        return new b(this.f5757a, iMax, iMax2, iMin - iMax, iMin2 - iMax2, f2, this.f5758b).a();
    }
}
