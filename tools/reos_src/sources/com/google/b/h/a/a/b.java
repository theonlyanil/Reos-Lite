package com.google.b.h.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5661a = new b(929, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f5663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f5664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f5665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5666f;

    private b(int i, int i2) {
        this.f5666f = i;
        this.f5662b = new int[i];
        this.f5663c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f5662b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f5663c[this.f5662b[i5]] = i5;
        }
        this.f5664d = new c(this, new int[]{0});
        this.f5665e = new c(this, new int[]{1});
    }

    int a(int i) {
        return this.f5662b[i];
    }

    c a() {
        return this.f5664d;
    }

    c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f5664d;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new c(this, iArr);
    }

    int b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return this.f5663c[i];
    }

    int b(int i, int i2) {
        return (i + i2) % this.f5666f;
    }

    c b() {
        return this.f5665e;
    }

    int c() {
        return this.f5666f;
    }

    int c(int i) {
        if (i == 0) {
            throw new ArithmeticException();
        }
        return this.f5662b[(this.f5666f - this.f5663c[i]) - 1];
    }

    int c(int i, int i2) {
        return ((this.f5666f + i) - i2) % this.f5666f;
    }

    int d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f5662b[(this.f5663c[i] + this.f5663c[i2]) % (this.f5666f - 1)];
    }
}
