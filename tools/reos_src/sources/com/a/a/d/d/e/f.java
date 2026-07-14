package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.a.a.d.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.g<Bitmap> f2343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.g<com.a.a.d.d.d.b> f2344b;

    public f(com.a.a.d.b.a.c cVar, com.a.a.d.g<Bitmap> gVar) {
        this(gVar, new com.a.a.d.d.d.e(gVar, cVar));
    }

    f(com.a.a.d.g<Bitmap> gVar, com.a.a.d.g<com.a.a.d.d.d.b> gVar2) {
        this.f2343a = gVar;
        this.f2344b = gVar2;
    }

    @Override // com.a.a.d.g
    public k<a> a(k<a> kVar, int i, int i2) {
        k<Bitmap> kVarB = kVar.b().b();
        k<com.a.a.d.d.d.b> kVarC = kVar.b().c();
        if (kVarB != null && this.f2343a != null) {
            k<Bitmap> kVarA = this.f2343a.a(kVarB, i, i2);
            return !kVarB.equals(kVarA) ? new b(new a(kVarA, kVar.b().c())) : kVar;
        }
        if (kVarC == null || this.f2344b == null) {
            return kVar;
        }
        k<com.a.a.d.d.d.b> kVarA2 = this.f2344b.a(kVarC, i, i2);
        return !kVarC.equals(kVarA2) ? new b(new a(kVar.b().b(), kVarA2)) : kVar;
    }

    @Override // com.a.a.d.g
    public String a() {
        return this.f2343a.a();
    }
}
