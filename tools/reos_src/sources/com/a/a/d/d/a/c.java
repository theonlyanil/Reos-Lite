package com.a.a.d.d.a;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.a.a.d.b.k<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f2216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2217b;

    public c(Bitmap bitmap, com.a.a.d.b.a.c cVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (cVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.f2216a = bitmap;
        this.f2217b = cVar;
    }

    public static c a(Bitmap bitmap, com.a.a.d.b.a.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, cVar);
    }

    @Override // com.a.a.d.b.k
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap b() {
        return this.f2216a;
    }

    @Override // com.a.a.d.b.k
    public int c() {
        return com.a.a.j.h.a(this.f2216a);
    }

    @Override // com.a.a.d.b.k
    public void d() {
        if (this.f2217b.a(this.f2216a)) {
            return;
        }
        this.f2216a.recycle();
    }
}
