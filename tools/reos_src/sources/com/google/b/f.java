package com.google.b;

/* JADX INFO: loaded from: classes.dex */
public final class f extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f5533b = new f();

    private f() {
    }

    private f(Throwable th) {
        super(th);
    }

    public static f a() {
        return f5776a ? new f() : f5533b;
    }

    public static f a(Throwable th) {
        return f5776a ? new f(th) : f5533b;
    }
}
