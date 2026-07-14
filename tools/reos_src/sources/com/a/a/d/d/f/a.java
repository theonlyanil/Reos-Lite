package com.a.a.d.d.f;

import android.graphics.Bitmap;
import com.a.a.d.b.k;
import com.a.a.d.d.a.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements c<com.a.a.d.d.e.a, com.a.a.d.d.b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c<Bitmap, j> f2349a;

    public a(c<Bitmap, j> cVar) {
        this.f2349a = cVar;
    }

    @Override // com.a.a.d.d.f.c
    public k<com.a.a.d.d.b.b> a(k<com.a.a.d.d.e.a> kVar) {
        com.a.a.d.d.e.a aVarB = kVar.b();
        k<Bitmap> kVarB = aVarB.b();
        return kVarB != null ? this.f2349a.a(kVarB) : aVarB.c();
    }

    @Override // com.a.a.d.d.f.c
    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
