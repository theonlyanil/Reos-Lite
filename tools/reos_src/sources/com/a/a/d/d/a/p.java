package com.a.a.d.d.a;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class p implements com.a.a.g.b<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f2264a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.d.c.c<Bitmap> f2267d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.c.o f2266c = new com.a.a.d.c.o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2265b = new b();

    public p(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.f2264a = new q(cVar, aVar);
        this.f2267d = new com.a.a.d.d.c.c<>(this.f2264a);
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Bitmap> a() {
        return this.f2267d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<InputStream, Bitmap> b() {
        return this.f2264a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<InputStream> c() {
        return this.f2266c;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Bitmap> d() {
        return this.f2265b;
    }
}
