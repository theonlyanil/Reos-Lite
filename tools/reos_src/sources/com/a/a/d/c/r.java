package com.a.a.d.c;

import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class r<T> implements l<URL, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<d, T> f2210a;

    public r(l<d, T> lVar) {
        this.f2210a = lVar;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<T> a(URL url, int i, int i2) {
        return this.f2210a.a(new d(url), i, i2);
    }
}
