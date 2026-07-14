package com.google.b.c.b;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5449a;

    public c(a aVar) {
        this.f5449a = aVar;
    }

    private int[] a(b bVar) throws d {
        int i = 0;
        int iA = bVar.a();
        if (iA == 1) {
            return new int[]{bVar.a(1)};
        }
        int[] iArr = new int[iA];
        for (int i2 = 1; i2 < this.f5449a.c() && i < iA; i2++) {
            if (bVar.b(i2) == 0) {
                iArr[i] = this.f5449a.c(i2);
                i++;
            }
        }
        if (i != iA) {
            throw new d("Error locator degree does not match number of roots");
        }
        return iArr;
    }

    private int[] a(b bVar, int[] iArr) {
        int iC;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iC2 = this.f5449a.c(iArr[i]);
            int i2 = 1;
            int i3 = 0;
            while (i3 < length) {
                if (i != i3) {
                    int iC3 = this.f5449a.c(iArr[i3], iC2);
                    iC = this.f5449a.c(i2, (iC3 & 1) == 0 ? iC3 | 1 : iC3 & (-2));
                } else {
                    iC = i2;
                }
                i3++;
                i2 = iC;
            }
            iArr2[i] = this.f5449a.c(bVar.b(iC2), this.f5449a.c(i2));
            if (this.f5449a.d() != 0) {
                iArr2[i] = this.f5449a.c(iArr2[i], iC2);
            }
        }
        return iArr2;
    }

    private b[] a(b bVar, b bVar2, int i) throws d {
        if (bVar.a() >= bVar2.a()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b bVarA = this.f5449a.a();
        b bVarB = this.f5449a.b();
        while (bVar.a() >= i / 2) {
            if (bVar.b()) {
                throw new d("r_{i-1} was zero");
            }
            b bVarA2 = this.f5449a.a();
            int iC = this.f5449a.c(bVar.a(bVar.a()));
            b bVarA3 = bVarA2;
            b bVarA4 = bVar2;
            while (bVarA4.a() >= bVar.a() && !bVarA4.b()) {
                int iA = bVarA4.a() - bVar.a();
                int iC2 = this.f5449a.c(bVarA4.a(bVarA4.a()), iC);
                bVarA3 = bVarA3.a(this.f5449a.a(iA, iC2));
                bVarA4 = bVarA4.a(bVar.a(iA, iC2));
            }
            b bVarA5 = bVarA3.b(bVarB).a(bVarA);
            if (bVarA4.a() >= bVar.a()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            bVar2 = bVar;
            bVar = bVarA4;
            b bVar3 = bVarB;
            bVarB = bVarA5;
            bVarA = bVar3;
        }
        int iA2 = bVarB.a(0);
        if (iA2 == 0) {
            throw new d("sigmaTilde(0) was zero");
        }
        int iC3 = this.f5449a.c(iA2);
        return new b[]{bVarB.c(iC3), bVar.c(iC3)};
    }

    public void a(int[] iArr, int i) throws d {
        b bVar = new b(this.f5449a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            int iB = bVar.b(this.f5449a.a(this.f5449a.d() + i2));
            iArr2[(iArr2.length - 1) - i2] = iB;
            if (iB != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        b[] bVarArrA = a(this.f5449a.a(i, 1), new b(this.f5449a, iArr2), i);
        b bVar2 = bVarArrA[0];
        b bVar3 = bVarArrA[1];
        int[] iArrA = a(bVar2);
        int[] iArrA2 = a(bVar3, iArrA);
        for (int i3 = 0; i3 < iArrA.length; i3++) {
            int length = (iArr.length - 1) - this.f5449a.b(iArrA[i3]);
            if (length < 0) {
                throw new d("Bad error location");
            }
            iArr[length] = a.b(iArr[length], iArrA2[i3]);
        }
    }
}
