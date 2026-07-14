package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
final class p extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5573b;

    p(int i, int i2, int i3) throws com.google.b.f {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw com.google.b.f.a();
        }
        this.f5572a = i2;
        this.f5573b = i3;
    }

    int a() {
        return this.f5572a;
    }

    int b() {
        return this.f5573b;
    }

    boolean c() {
        return this.f5572a == 10;
    }

    boolean d() {
        return this.f5573b == 10;
    }
}
