package com.google.b.c.b;

import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5441a = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5442b = new a(1033, Place.TYPE_SUBLOCALITY_LEVEL_2, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5443c = new a(67, 64, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5444d = new a(19, 16, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5445e = new a(285, 256, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5446f = new a(301, 256, 1);
    public static final a g = f5446f;
    public static final a h = f5443c;
    private final int[] i;
    private final int[] j;
    private final b k;
    private final b l;
    private final int m;
    private final int n;
    private final int o;

    public a(int i, int i2, int i3) {
        this.n = i;
        this.m = i2;
        this.o = i3;
        this.i = new int[i2];
        this.j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.i[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.j[this.i[i6]] = i6;
        }
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    static int b(int i, int i2) {
        return i ^ i2;
    }

    int a(int i) {
        return this.i[i];
    }

    b a() {
        return this.k;
    }

    b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new b(this, iArr);
    }

    int b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return this.j[i];
    }

    b b() {
        return this.l;
    }

    public int c() {
        return this.m;
    }

    int c(int i) {
        if (i == 0) {
            throw new ArithmeticException();
        }
        return this.i[(this.m - this.j[i]) - 1];
    }

    int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.i[(this.j[i] + this.j[i2]) % (this.m - 1)];
    }

    public int d() {
        return this.o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
