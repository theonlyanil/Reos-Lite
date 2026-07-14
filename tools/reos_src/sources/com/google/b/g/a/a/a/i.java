package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
abstract class i extends h {
    i(com.google.b.c.a aVar) {
        super(aVar);
    }

    protected abstract int a(int i);

    protected abstract void a(StringBuilder sb, int i);

    protected final void b(StringBuilder sb, int i, int i2) {
        int iA = c().a(i, i2);
        a(sb, iA);
        int iA2 = a(iA);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iA2 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iA2);
    }
}
