package com.google.b.g;

/* JADX INFO: loaded from: classes.dex */
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5639a = {1, 1, 2};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f5640b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f5641c = new n();

    o() {
    }

    com.google.b.m a(int i, com.google.b.c.a aVar, int i2) throws com.google.b.i {
        int[] iArrA = p.a(aVar, i2, false, f5639a);
        try {
            return this.f5641c.a(i, aVar, iArrA);
        } catch (com.google.b.l e2) {
            return this.f5640b.a(i, aVar, iArrA);
        }
    }
}
