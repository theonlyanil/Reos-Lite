package com.google.b.i.b;

import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5750a;

    a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f5750a = f4;
    }

    boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f5750a);
        return fAbs <= 1.0f || fAbs <= this.f5750a;
    }

    a b(float f2, float f3, float f4) {
        return new a((a() + f3) / 2.0f, (b() + f2) / 2.0f, (this.f5750a + f4) / 2.0f);
    }
}
