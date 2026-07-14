package com.google.b.i.a;

/* JADX INFO: loaded from: classes.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5728f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f[] f5727e = {M, L, H, Q};

    f(int i) {
        this.f5728f = i;
    }

    public static f a(int i) {
        if (i < 0 || i >= f5727e.length) {
            throw new IllegalArgumentException();
        }
        return f5727e[i];
    }
}
