package com.a.a.g;

import com.a.a.d.c.l;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class e<A, T, Z, R> implements f<A, T, Z, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<A, T> f2409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.d.f.c<Z, R> f2410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<T, Z> f2411c;

    public e(l<A, T> lVar, com.a.a.d.d.f.c<Z, R> cVar, b<T, Z> bVar) {
        if (lVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f2409a = lVar;
        if (cVar == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f2410b = cVar;
        if (bVar == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f2411c = bVar;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Z> a() {
        return this.f2411c.a();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<T, Z> b() {
        return this.f2411c.b();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<T> c() {
        return this.f2411c.c();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Z> d() {
        return this.f2411c.d();
    }

    @Override // com.a.a.g.f
    public l<A, T> e() {
        return this.f2409a;
    }

    @Override // com.a.a.g.f
    public com.a.a.d.d.f.c<Z, R> f() {
        return this.f2410b;
    }
}
