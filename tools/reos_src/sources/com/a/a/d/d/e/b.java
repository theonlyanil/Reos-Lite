package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
public class b implements k<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f2332a;

    public b(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f2332a = aVar;
    }

    @Override // com.a.a.d.b.k
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a b() {
        return this.f2332a;
    }

    @Override // com.a.a.d.b.k
    public int c() {
        return this.f2332a.a();
    }

    @Override // com.a.a.d.b.k
    public void d() {
        k<Bitmap> kVarB = this.f2332a.b();
        if (kVarB != null) {
            kVarB.d();
        }
        k<com.a.a.d.d.d.b> kVarC = this.f2332a.c();
        if (kVarC != null) {
            kVarC.d();
        }
    }
}
