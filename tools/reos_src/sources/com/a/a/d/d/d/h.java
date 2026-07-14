package com.a.a.d.d.d;

import android.graphics.Bitmap;
import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
class h implements com.a.a.d.e<com.a.a.b.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2317a;

    public h(com.a.a.d.b.a.c cVar) {
        this.f2317a = cVar;
    }

    @Override // com.a.a.d.e
    public k<Bitmap> a(com.a.a.b.a aVar, int i, int i2) {
        return com.a.a.d.d.a.c.a(aVar.f(), this.f2317a);
    }

    @Override // com.a.a.d.e
    public String a() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
