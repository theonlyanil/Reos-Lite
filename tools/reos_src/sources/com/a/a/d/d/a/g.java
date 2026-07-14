package com.a.a.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.a.a.g.b<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.e<File, Bitmap> f2224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f2225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2226c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.b<ParcelFileDescriptor> f2227d = com.a.a.d.d.a.b();

    public g(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.f2224a = new com.a.a.d.d.c.c(new q(cVar, aVar));
        this.f2225b = new h(cVar, aVar);
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, Bitmap> a() {
        return this.f2224a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<ParcelFileDescriptor, Bitmap> b() {
        return this.f2225b;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<ParcelFileDescriptor> c() {
        return this.f2227d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<Bitmap> d() {
        return this.f2226c;
    }
}
