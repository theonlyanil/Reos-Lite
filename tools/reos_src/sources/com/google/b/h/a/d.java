package com.google.b.h.a;

/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5680e = -1;

    d(int i, int i2, int i3, int i4) {
        this.f5676a = i;
        this.f5677b = i2;
        this.f5678c = i3;
        this.f5679d = i4;
    }

    boolean a() {
        return a(this.f5680e);
    }

    boolean a(int i) {
        return i != -1 && this.f5678c == (i % 3) * 3;
    }

    void b() {
        this.f5680e = ((this.f5679d / 30) * 3) + (this.f5678c / 3);
    }

    void b(int i) {
        this.f5680e = i;
    }

    int c() {
        return this.f5677b - this.f5676a;
    }

    int d() {
        return this.f5676a;
    }

    int e() {
        return this.f5677b;
    }

    int f() {
        return this.f5678c;
    }

    int g() {
        return this.f5679d;
    }

    int h() {
        return this.f5680e;
    }

    public String toString() {
        return this.f5680e + "|" + this.f5679d;
    }
}
