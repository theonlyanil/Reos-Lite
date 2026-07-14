package com.google.b.h.a;

import java.util.Formatter;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f5696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d[] f5697b;

    g(c cVar) {
        this.f5696a = new c(cVar);
        this.f5697b = new d[(cVar.d() - cVar.c()) + 1];
    }

    final c a() {
        return this.f5696a;
    }

    final d a(int i) {
        d dVar;
        d dVar2;
        d dVarC = c(i);
        if (dVarC != null) {
            return dVarC;
        }
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= 5) {
                return null;
            }
            int iB = b(i) - i3;
            if (iB >= 0 && (dVar2 = this.f5697b[iB]) != null) {
                return dVar2;
            }
            int iB2 = b(i) + i3;
            if (iB2 < this.f5697b.length && (dVar = this.f5697b[iB2]) != null) {
                return dVar;
            }
            i2 = i3 + 1;
        }
    }

    final void a(int i, d dVar) {
        this.f5697b[b(i)] = dVar;
    }

    final int b(int i) {
        return i - this.f5696a.c();
    }

    final d[] b() {
        return this.f5697b;
    }

    final d c(int i) {
        return this.f5697b[b(i)];
    }

    public String toString() {
        int i;
        Formatter formatter = new Formatter();
        d[] dVarArr = this.f5697b;
        int length = dVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            d dVar = dVarArr[i2];
            if (dVar == null) {
                i = i3 + 1;
                formatter.format("%3d:    |   %n", Integer.valueOf(i3));
            } else {
                i = i3 + 1;
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i3), Integer.valueOf(dVar.h()), Integer.valueOf(dVar.g()));
            }
            i2++;
            i3 = i;
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
