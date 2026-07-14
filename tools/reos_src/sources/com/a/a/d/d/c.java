package com.a.a.d.d;

import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
public class c<T> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f2277a;

    public c(T t) {
        if (t == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f2277a = t;
    }

    @Override // com.a.a.d.b.k
    public final T b() {
        return this.f2277a;
    }

    @Override // com.a.a.d.b.k
    public final int c() {
        return 1;
    }

    @Override // com.a.a.d.b.k
    public void d() {
    }
}
