package com.a.a.d.d.d;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class a implements com.a.a.b.a.InterfaceC0037a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2285a;

    public a(com.a.a.d.b.a.c cVar) {
        this.f2285a = cVar;
    }

    @Override // com.a.a.b.a.InterfaceC0037a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f2285a.b(i, i2, config);
    }

    @Override // com.a.a.b.a.InterfaceC0037a
    public void a(Bitmap bitmap) {
        if (this.f2285a.a(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
