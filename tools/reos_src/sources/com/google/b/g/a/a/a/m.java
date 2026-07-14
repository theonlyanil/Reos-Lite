package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5562a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f5563b = a.NUMERIC;

    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    int a() {
        return this.f5562a;
    }

    void a(int i) {
        this.f5562a = i;
    }

    void b(int i) {
        this.f5562a += i;
    }

    boolean b() {
        return this.f5563b == a.ALPHA;
    }

    boolean c() {
        return this.f5563b == a.ISO_IEC_646;
    }

    void d() {
        this.f5563b = a.NUMERIC;
    }

    void e() {
        this.f5563b = a.ALPHA;
    }

    void f() {
        this.f5563b = a.ISO_IEC_646;
    }
}
