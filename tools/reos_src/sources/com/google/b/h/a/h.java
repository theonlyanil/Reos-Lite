package com.google.b.h.a;

import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
final class h extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5698a;

    h(c cVar, boolean z) {
        super(cVar);
        this.f5698a = z;
    }

    private void a(d[] dVarArr, a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int iG = dVar.g() % 30;
                int iH = dVar.h();
                if (iH <= aVar.c()) {
                    if (!this.f5698a) {
                        iH += 2;
                    }
                    switch (iH % 3) {
                        case 0:
                            if ((iG * 3) + 1 != aVar.d()) {
                                dVarArr[i] = null;
                            }
                            break;
                        case 1:
                            if (iG / 3 != aVar.b() || iG % 3 != aVar.e()) {
                                dVarArr[i] = null;
                            }
                            break;
                        case 2:
                            if (iG + 1 != aVar.a()) {
                                dVarArr[i] = null;
                            }
                            break;
                    }
                } else {
                    dVarArr[i] = null;
                }
            }
        }
    }

    int a(a aVar) {
        int i;
        int i2;
        int iH;
        d[] dVarArrB = b();
        c();
        a(dVarArrB, aVar);
        c cVarA = a();
        o oVarE = this.f5698a ? cVarA.e() : cVarA.f();
        o oVarG = this.f5698a ? cVarA.g() : cVarA.h();
        int iB = b((int) oVarE.b());
        int iB2 = b((int) oVarG.b());
        float fC = (iB2 - iB) / aVar.c();
        int i3 = -1;
        int i4 = iB;
        int i5 = 0;
        int i6 = 1;
        while (i4 < iB2) {
            if (dVarArrB[i4] == null) {
                i = i5;
                i2 = i6;
                iH = i3;
            } else {
                d dVar = dVarArrB[i4];
                int iH2 = dVar.h() - i3;
                if (iH2 == 0) {
                    i = i5 + 1;
                    i2 = i6;
                    iH = i3;
                } else if (iH2 == 1) {
                    int iMax = Math.max(i6, i5);
                    iH = dVar.h();
                    i2 = iMax;
                    i = 1;
                } else if (iH2 < 0 || dVar.h() >= aVar.c() || iH2 > i4) {
                    dVarArrB[i4] = null;
                    i = i5;
                    i2 = i6;
                    iH = i3;
                } else {
                    int i7 = i6 > 2 ? iH2 * (i6 - 2) : iH2;
                    boolean z = i7 >= i4;
                    for (int i8 = 1; i8 <= i7 && !z; i8++) {
                        z = dVarArrB[i4 - i8] != null;
                    }
                    if (z) {
                        dVarArrB[i4] = null;
                        i = i5;
                        i2 = i6;
                        iH = i3;
                    } else {
                        i2 = i6;
                        iH = dVar.h();
                        i = 1;
                    }
                }
            }
            i4++;
            i3 = iH;
            i6 = i2;
            i5 = i;
        }
        return (int) (((double) fC) + 0.5d);
    }

    int b(a aVar) {
        c cVarA = a();
        o oVarE = this.f5698a ? cVarA.e() : cVarA.f();
        o oVarG = this.f5698a ? cVarA.g() : cVarA.h();
        int iB = b((int) oVarE.b());
        int iB2 = b((int) oVarG.b());
        float fC = (iB2 - iB) / aVar.c();
        d[] dVarArrB = b();
        int iH = -1;
        int i = 0;
        int i2 = 1;
        for (int i3 = iB; i3 < iB2; i3++) {
            if (dVarArrB[i3] != null) {
                d dVar = dVarArrB[i3];
                dVar.b();
                int iH2 = dVar.h() - iH;
                if (iH2 == 0) {
                    i++;
                } else if (iH2 == 1) {
                    int iMax = Math.max(i2, i);
                    iH = dVar.h();
                    i2 = iMax;
                    i = 1;
                } else if (dVar.h() >= aVar.c()) {
                    dVarArrB[i3] = null;
                } else {
                    iH = dVar.h();
                    i = 1;
                }
            }
        }
        return (int) (((double) fC) + 0.5d);
    }

    void c() {
        for (d dVar : b()) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    int[] d() throws com.google.b.f {
        a aVarE = e();
        if (aVarE == null) {
            return null;
        }
        b(aVarE);
        int[] iArr = new int[aVarE.c()];
        for (d dVar : b()) {
            if (dVar != null) {
                int iH = dVar.h();
                if (iH >= iArr.length) {
                    throw com.google.b.f.a();
                }
                iArr[iH] = iArr[iH] + 1;
            }
        }
        return iArr;
    }

    a e() {
        d[] dVarArrB = b();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArrB) {
            if (dVar != null) {
                dVar.b();
                int iG = dVar.g() % 30;
                int iH = dVar.h();
                if (!this.f5698a) {
                    iH += 2;
                }
                switch (iH % 3) {
                    case 0:
                        bVar2.a((iG * 3) + 1);
                        break;
                    case 1:
                        bVar4.a(iG / 3);
                        bVar3.a(iG % 3);
                        break;
                    case 2:
                        bVar.a(iG + 1);
                        break;
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] < 1 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(dVarArrB, aVar);
        return aVar;
    }

    boolean f() {
        return this.f5698a;
    }

    @Override // com.google.b.h.a.g
    public String toString() {
        return "IsLeft: " + this.f5698a + '\n' + super.toString();
    }
}
