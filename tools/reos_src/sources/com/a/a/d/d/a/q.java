package com.a.a.d.d.a;

import android.graphics.Bitmap;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class q implements com.a.a.d.e<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f2268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.a.a.d.b.a.c f2269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.a.d.a f2270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2271d;

    public q(com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this(f.f2219a, cVar, aVar);
    }

    public q(f fVar, com.a.a.d.b.a.c cVar, com.a.a.d.a aVar) {
        this.f2268a = fVar;
        this.f2269b = cVar;
        this.f2270c = aVar;
    }

    @Override // com.a.a.d.e
    public com.a.a.d.b.k<Bitmap> a(InputStream inputStream, int i, int i2) {
        return c.a(this.f2268a.a(inputStream, this.f2269b, i, i2, this.f2270c), this.f2269b);
    }

    @Override // com.a.a.d.e
    public String a() {
        if (this.f2271d == null) {
            this.f2271d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.f2268a.a() + this.f2270c.name();
        }
        return this.f2271d;
    }
}
