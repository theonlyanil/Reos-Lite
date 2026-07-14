package com.google.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f5776a;

    static {
        f5776a = System.getProperty("surefire.test.class.path") != null;
    }

    l() {
    }

    l(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return null;
    }
}
