package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class n implements com.a.a.g.b<com.a.a.d.c.g, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f2255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.e<File, Bitmap> f2256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.f<Bitmap> f2257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.c.h f2258d;

    public n(com.a.a.g.b<InputStream, Bitmap> bVar, com.a.a.g.b<ParcelFileDescriptor, Bitmap> bVar2) {
        this.f2257c = bVar.d();
        this.f2258d = new com.a.a.d.c.h(bVar.c(), bVar2.c());
        this.f2256b = bVar.a();
        this.f2255a = new m(bVar.b(), bVar2.b());
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Bitmap> a() {
        return this.f2256b;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<com.a.a.d.c.g, Bitmap> b() {
        return this.f2255a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<com.a.a.d.c.g> c() {
        return this.f2258d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Bitmap> d() {
        return this.f2257c;
    }
}
