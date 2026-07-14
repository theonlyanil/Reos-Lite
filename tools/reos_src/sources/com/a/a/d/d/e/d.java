package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.k;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.a.a.d.f<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.f<Bitmap> f2339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.f<com.a.a.d.d.d.b> f2340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2341c;

    public d(com.a.a.d.f<Bitmap> fVar, com.a.a.d.f<com.a.a.d.d.d.b> fVar2) {
        this.f2339a = fVar;
        this.f2340b = fVar2;
    }

    @Override // com.a.a.d.b
    public String a() {
        if (this.f2341c == null) {
            this.f2341c = this.f2339a.a() + this.f2340b.a();
        }
        return this.f2341c;
    }

    @Override // com.a.a.d.b
    public boolean a(k<a> kVar, OutputStream outputStream) {
        a aVarB = kVar.b();
        k<Bitmap> kVarB = aVarB.b();
        return kVarB != null ? this.f2339a.a(kVarB, outputStream) : this.f2340b.a(aVarB.c(), outputStream);
    }
}
