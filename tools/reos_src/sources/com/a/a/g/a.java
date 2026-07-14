package com.a.a.g;

import com.a.a.d.c.l;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a<A, T, Z, R> implements f<A, T, Z, R>, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<A, T, Z, R> f2400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.a.a.d.e<File, Z> f2401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.a.d.e<T, Z> f2402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.a.a.d.f<Z> f2403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.a.a.d.d.f.c<Z, R> f2404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.a.a.d.b<T> f2405f;

    public a(f<A, T, Z, R> fVar) {
        this.f2400a = fVar;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Z> a() {
        return this.f2401b != null ? this.f2401b : this.f2400a.a();
    }

    public void a(com.a.a.d.b<T> bVar) {
        this.f2405f = bVar;
    }

    public void a(com.a.a.d.e<T, Z> eVar) {
        this.f2402c = eVar;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<T, Z> b() {
        return this.f2402c != null ? this.f2402c : this.f2400a.b();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<T> c() {
        return this.f2405f != null ? this.f2405f : this.f2400a.c();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Z> d() {
        return this.f2403d != null ? this.f2403d : this.f2400a.d();
    }

    @Override // com.a.a.g.f
    public l<A, T> e() {
        return this.f2400a.e();
    }

    @Override // com.a.a.g.f
    public com.a.a.d.d.f.c<Z, R> f() {
        return this.f2404e != null ? this.f2404e : this.f2400a.f();
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a<A, T, Z, R> clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
