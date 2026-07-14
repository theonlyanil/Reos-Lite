package com.a.a.d.d.a;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements com.a.a.d.g<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.a.a.d.b.a.c f2218a;

    public d(com.a.a.d.b.a.c cVar) {
        this.f2218a = cVar;
    }

    protected abstract Bitmap a(com.a.a.d.b.a.c cVar, Bitmap bitmap, int i, int i2);

    @Override // com.a.a.d.g
    public final com.a.a.d.b.k<Bitmap> a(com.a.a.d.b.k<Bitmap> kVar, int i, int i2) {
        if (!com.a.a.j.h.a(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        Bitmap bitmapB = kVar.b();
        if (i == Integer.MIN_VALUE) {
            i = bitmapB.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmapB.getHeight();
        }
        Bitmap bitmapA = a(this.f2218a, bitmapB, i, i2);
        return bitmapB.equals(bitmapA) ? kVar : c.a(bitmapA, this.f2218a);
    }
}
