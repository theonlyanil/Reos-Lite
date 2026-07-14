package com.google.b.h.a;

import java.util.Formatter;

/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g[] f5693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f5694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5695d;

    f(a aVar, c cVar) {
        this.f5692a = aVar;
        this.f5695d = aVar.a();
        this.f5694c = cVar;
        this.f5693b = new g[this.f5695d + 2];
    }

    private static int a(int i, int i2, d dVar) {
        if (dVar == null || dVar.a()) {
            return i2;
        }
        if (!dVar.a(i)) {
            return i2 + 1;
        }
        dVar.b(i);
        return 0;
    }

    private void a(int i, int i2, d[] dVarArr) {
        d dVar = dVarArr[i2];
        d[] dVarArrB = this.f5693b[i - 1].b();
        d[] dVarArrB2 = this.f5693b[i + 1] != null ? this.f5693b[i + 1].b() : dVarArrB;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrB[i2];
        dVarArr2[3] = dVarArrB2[i2];
        if (i2 > 0) {
            dVarArr2[0] = dVarArr[i2 - 1];
            dVarArr2[4] = dVarArrB[i2 - 1];
            dVarArr2[5] = dVarArrB2[i2 - 1];
        }
        if (i2 > 1) {
            dVarArr2[8] = dVarArr[i2 - 2];
            dVarArr2[10] = dVarArrB[i2 - 2];
            dVarArr2[11] = dVarArrB2[i2 - 2];
        }
        if (i2 < dVarArr.length - 1) {
            dVarArr2[1] = dVarArr[i2 + 1];
            dVarArr2[6] = dVarArrB[i2 + 1];
            dVarArr2[7] = dVarArrB2[i2 + 1];
        }
        if (i2 < dVarArr.length - 2) {
            dVarArr2[9] = dVarArr[i2 + 2];
            dVarArr2[12] = dVarArrB[i2 + 2];
            dVarArr2[13] = dVarArrB2[i2 + 2];
        }
        int length = dVarArr2.length;
        for (int i3 = 0; i3 < length && !a(dVar, dVarArr2[i3]); i3++) {
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).a(this.f5692a);
        }
    }

    private static boolean a(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.a() || dVar2.f() != dVar.f()) {
            return false;
        }
        dVar.b(dVar2.h());
        return true;
    }

    private int f() {
        int iG = g();
        if (iG == 0) {
            return 0;
        }
        for (int i = 1; i < this.f5695d + 1; i++) {
            d[] dVarArrB = this.f5693b[i].b();
            for (int i2 = 0; i2 < dVarArrB.length; i2++) {
                if (dVarArrB[i2] != null && !dVarArrB[i2].a()) {
                    a(i, i2, dVarArrB);
                }
            }
        }
        return iG;
    }

    private int g() {
        h();
        return j() + i();
    }

    private void h() {
        if (this.f5693b[0] == null || this.f5693b[this.f5695d + 1] == null) {
            return;
        }
        d[] dVarArrB = this.f5693b[0].b();
        d[] dVarArrB2 = this.f5693b[this.f5695d + 1].b();
        for (int i = 0; i < dVarArrB.length; i++) {
            if (dVarArrB[i] != null && dVarArrB2[i] != null && dVarArrB[i].h() == dVarArrB2[i].h()) {
                for (int i2 = 1; i2 <= this.f5695d; i2++) {
                    d dVar = this.f5693b[i2].b()[i];
                    if (dVar != null) {
                        dVar.b(dVarArrB[i].h());
                        if (!dVar.a()) {
                            this.f5693b[i2].b()[i] = null;
                        }
                    }
                }
            }
        }
    }

    private int i() {
        if (this.f5693b[this.f5695d + 1] == null) {
            return 0;
        }
        d[] dVarArrB = this.f5693b[this.f5695d + 1].b();
        int i = 0;
        for (int i2 = 0; i2 < dVarArrB.length; i2++) {
            if (dVarArrB[i2] != null) {
                int iH = dVarArrB[i2].h();
                int i3 = i;
                int iA = 0;
                for (int i4 = this.f5695d + 1; i4 > 0 && iA < 2; i4--) {
                    d dVar = this.f5693b[i4].b()[i2];
                    if (dVar != null) {
                        iA = a(iH, iA, dVar);
                        if (!dVar.a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private int j() {
        if (this.f5693b[0] == null) {
            return 0;
        }
        d[] dVarArrB = this.f5693b[0].b();
        int i = 0;
        for (int i2 = 0; i2 < dVarArrB.length; i2++) {
            if (dVarArrB[i2] != null) {
                int iH = dVarArrB[i2].h();
                int i3 = i;
                int iA = 0;
                for (int i4 = 1; i4 < this.f5695d + 1 && iA < 2; i4++) {
                    d dVar = this.f5693b[i4].b()[i2];
                    if (dVar != null) {
                        iA = a(iH, iA, dVar);
                        if (!dVar.a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    g a(int i) {
        return this.f5693b[i];
    }

    void a(int i, g gVar) {
        this.f5693b[i] = gVar;
    }

    public void a(c cVar) {
        this.f5694c = cVar;
    }

    g[] a() {
        a(this.f5693b[0]);
        a(this.f5693b[this.f5695d + 1]);
        int i = 928;
        while (true) {
            int iF = f();
            if (iF <= 0 || iF >= i) {
                break;
            }
            i = iF;
        }
        return this.f5693b;
    }

    int b() {
        return this.f5695d;
    }

    int c() {
        return this.f5692a.c();
    }

    int d() {
        return this.f5692a.b();
    }

    c e() {
        return this.f5694c;
    }

    public String toString() {
        g gVar = this.f5693b[0];
        if (gVar == null) {
            gVar = this.f5693b[this.f5695d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < gVar.b().length; i++) {
            formatter.format("CW %3d:", Integer.valueOf(i));
            for (int i2 = 0; i2 < this.f5695d + 2; i2++) {
                if (this.f5693b[i2] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    d dVar = this.f5693b[i2].b()[i];
                    if (dVar == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(dVar.h()), Integer.valueOf(dVar.g()));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
