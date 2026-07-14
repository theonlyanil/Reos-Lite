package com.a.a.d.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.a.a.d.b.k;
import com.a.a.d.d.a.j;

/* JADX INFO: loaded from: classes.dex */
public class b implements c<Bitmap, j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f2350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2351b;

    public b(Resources resources, com.a.a.d.b.a.c cVar) {
        this.f2350a = resources;
        this.f2351b = cVar;
    }

    @Override // com.a.a.d.d.f.c
    public k<j> a(k<Bitmap> kVar) {
        return new com.a.a.d.d.a.k(new j(this.f2350a, kVar.b()), this.f2351b);
    }

    @Override // com.a.a.d.d.f.c
    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
