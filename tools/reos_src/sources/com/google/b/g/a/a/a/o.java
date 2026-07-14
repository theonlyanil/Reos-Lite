package com.google.b.g.a.a.a;

/* JADX INFO: loaded from: classes.dex */
final class o extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5571c;

    o(int i, String str) {
        super(i);
        this.f5569a = str;
        this.f5571c = false;
        this.f5570b = 0;
    }

    o(int i, String str, int i2) {
        super(i);
        this.f5571c = true;
        this.f5570b = i2;
        this.f5569a = str;
    }

    String a() {
        return this.f5569a;
    }

    boolean b() {
        return this.f5571c;
    }

    int c() {
        return this.f5570b;
    }
}
