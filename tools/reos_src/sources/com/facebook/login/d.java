package com.facebook.login;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    NATIVE_ONLY(true, true, false, false, false, true),
    KATANA_ONLY(false, true, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false),
    DEVICE_AUTH(false, false, false, true, false, false);

    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;

    d(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = z5;
        this.l = z6;
    }

    boolean a() {
        return this.g;
    }

    boolean b() {
        return this.h;
    }

    boolean c() {
        return this.i;
    }

    boolean d() {
        return this.j;
    }

    boolean e() {
        return this.k;
    }

    boolean f() {
        return this.l;
    }
}
