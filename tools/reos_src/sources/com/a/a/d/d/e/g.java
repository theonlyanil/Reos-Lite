package com.a.a.d.d.e;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.a.a.g.b<com.a.a.d.c.g, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.e<File, a> f2345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.e<com.a.a.d.c.g, a> f2346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.f<a> f2347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.b<com.a.a.d.c.g> f2348d;

    public g(com.a.a.g.b<com.a.a.d.c.g, Bitmap> bVar, com.a.a.g.b<InputStream, com.a.a.d.d.d.b> bVar2, com.a.a.d.b.a.c cVar) {
        c cVar2 = new c(bVar.b(), bVar2.b(), cVar);
        this.f2345a = new com.a.a.d.d.c.c(new e(cVar2));
        this.f2346b = cVar2;
        this.f2347c = new d(bVar.d(), bVar2.d());
        this.f2348d = bVar.c();
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, a> a() {
        return this.f2345a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<com.a.a.d.c.g, a> b() {
        return this.f2346b;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<com.a.a.d.c.g> c() {
        return this.f2348d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<a> d() {
        return this.f2347c;
    }
}
