package com.google.b.i.b;

import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
public final class d extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5760b;

    d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    private d(float f2, float f3, float f4, int i) {
        super(f2, f3);
        this.f5759a = f4;
        this.f5760b = i;
    }

    boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f5759a);
        return fAbs <= 1.0f || fAbs <= this.f5759a;
    }

    d b(float f2, float f3, float f4) {
        int i = this.f5760b + 1;
        return new d(((this.f5760b * a()) + f3) / i, ((this.f5760b * b()) + f2) / i, ((this.f5760b * this.f5759a) + f4) / i, i);
    }

    public float c() {
        return this.f5759a;
    }

    int d() {
        return this.f5760b;
    }
}
