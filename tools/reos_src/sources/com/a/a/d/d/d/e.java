package com.a.a.d.d.d;

import android.graphics.Bitmap;
import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.a.a.d.g<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.g<Bitmap> f2302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2303b;

    public e(com.a.a.d.g<Bitmap> gVar, com.a.a.d.b.a.c cVar) {
        this.f2302a = gVar;
        this.f2303b = cVar;
    }

    @Override // com.a.a.d.g
    public k<b> a(k<b> kVar, int i, int i2) {
        b bVarB = kVar.b();
        Bitmap bitmapB = kVar.b().b();
        Bitmap bitmapB2 = this.f2302a.a(new com.a.a.d.d.a.c(bitmapB, this.f2303b), i, i2).b();
        return !bitmapB2.equals(bitmapB) ? new d(new b(bVarB, bitmapB2, this.f2302a)) : kVar;
    }

    @Override // com.a.a.d.g
    public String a() {
        return this.f2302a.a();
    }
}
