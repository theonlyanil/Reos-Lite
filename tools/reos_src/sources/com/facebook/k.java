package com.facebook;

/* JADX INFO: loaded from: classes.dex */
public class k extends RuntimeException {
    public k() {
    }

    public k(String str) {
        super(str);
    }

    public k(String str, Throwable th) {
        super(str, th);
    }

    public k(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public k(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }
}
