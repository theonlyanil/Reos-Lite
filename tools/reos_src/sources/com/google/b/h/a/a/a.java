package com.google.b.h.a.a;

import com.google.b.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5660a = b.f5661a;

    private int[] a(c cVar) throws d {
        int iA = cVar.a();
        int[] iArr = new int[iA];
        int i = 0;
        for (int i2 = 1; i2 < this.f5660a.c() && i < iA; i2++) {
            if (cVar.b(i2) == 0) {
                iArr[i] = this.f5660a.c(i2);
                i++;
            }
        }
        if (i != iA) {
            throw d.a();
        }
        return iArr;
    }

    private int[] a(c cVar, c cVar2, int[] iArr) {
        int iA = cVar2.a();
        int[] iArr2 = new int[iA];
        for (int i = 1; i <= iA; i++) {
            iArr2[iA - i] = this.f5660a.d(i, cVar2.a(i));
        }
        c cVar3 = new c(this.f5660a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iC = this.f5660a.c(iArr[i2]);
            iArr3[i2] = this.f5660a.d(this.f5660a.c(0, cVar.b(iC)), this.f5660a.c(cVar3.b(iC)));
        }
        return iArr3;
    }

    private c[] a(c cVar, c cVar2, int i) throws d {
        if (cVar.a() >= cVar2.a()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarA = this.f5660a.a();
        c cVarB = this.f5660a.b();
        while (cVar.a() >= i / 2) {
            if (cVar.b()) {
                throw d.a();
            }
            c cVarA2 = this.f5660a.a();
            int iC = this.f5660a.c(cVar.a(cVar.a()));
            c cVarA3 = cVarA2;
            c cVarB2 = cVar2;
            while (cVarB2.a() >= cVar.a() && !cVarB2.b()) {
                int iA = cVarB2.a() - cVar.a();
                int iD = this.f5660a.d(cVarB2.a(cVarB2.a()), iC);
                cVarA3 = cVarA3.a(this.f5660a.a(iA, iD));
                cVarB2 = cVarB2.b(cVar.a(iA, iD));
            }
            cVar2 = cVar;
            cVar = cVarB2;
            c cVar3 = cVarB;
            cVarB = cVarA3.c(cVarB).b(cVarA).c();
            cVarA = cVar3;
        }
        int iA2 = cVarB.a(0);
        if (iA2 == 0) {
            throw d.a();
        }
        int iC2 = this.f5660a.c(iA2);
        return new c[]{cVarB.c(iC2), cVar.c(iC2)};
    }

    public int a(int[] iArr, int i, int[] iArr2) throws d {
        c cVar = new c(this.f5660a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iB = cVar.b(this.f5660a.a(i2));
            iArr3[i - i2] = iB;
            if (iB != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        c cVarB = this.f5660a.b();
        if (iArr2 != null) {
            c cVarC = cVarB;
            for (int i3 : iArr2) {
                cVarC = cVarC.c(new c(this.f5660a, new int[]{this.f5660a.c(0, this.f5660a.a((iArr.length - 1) - i3)), 1}));
            }
        }
        c[] cVarArrA = a(this.f5660a.a(i, 1), new c(this.f5660a, iArr3), i);
        c cVar2 = cVarArrA[0];
        c cVar3 = cVarArrA[1];
        int[] iArrA = a(cVar2);
        int[] iArrA2 = a(cVar3, cVar2, iArrA);
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            int length = (iArr.length - 1) - this.f5660a.b(iArrA[i4]);
            if (length < 0) {
                throw d.a();
            }
            iArr[length] = this.f5660a.c(iArr[length], iArrA2[i4]);
        }
        return iArrA.length;
    }
}
