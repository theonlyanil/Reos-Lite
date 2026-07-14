package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k<com.a.a.d.d.d.b> f2330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k<Bitmap> f2331b;

    public a(k<Bitmap> kVar, k<com.a.a.d.d.d.b> kVar2) {
        if (kVar != null && kVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (kVar == null && kVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.f2331b = kVar;
        this.f2330a = kVar2;
    }

    public int a() {
        return this.f2331b != null ? this.f2331b.c() : this.f2330a.c();
    }

    public k<Bitmap> b() {
        return this.f2331b;
    }

    public k<com.a.a.d.d.d.b> c() {
        return this.f2330a;
    }
}
