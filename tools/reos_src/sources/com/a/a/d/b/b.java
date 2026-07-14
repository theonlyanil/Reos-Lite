package com.a.a.d.b;

/* JADX INFO: loaded from: classes.dex */
public enum b {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f2083f;

    b(boolean z, boolean z2) {
        this.f2082e = z;
        this.f2083f = z2;
    }

    public boolean a() {
        return this.f2082e;
    }

    public boolean b() {
        return this.f2083f;
    }
}
