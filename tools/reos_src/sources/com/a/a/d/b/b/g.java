package com.a.a.d.b.b;

import android.annotation.SuppressLint;
import com.a.a.d.b.k;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.a.a.j.e<com.a.a.d.c, k<?>> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h.a f2099a;

    public g(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.j.e
    public int a(k<?> kVar) {
        return kVar.c();
    }

    @Override // com.a.a.d.b.b.h
    public /* synthetic */ k a(com.a.a.d.c cVar) {
        return (k) super.c(cVar);
    }

    @Override // com.a.a.d.b.b.h
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(b() / 2);
        }
    }

    @Override // com.a.a.d.b.b.h
    public void a(h.a aVar) {
        this.f2099a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.a.a.j.e
    public void a(com.a.a.d.c cVar, k<?> kVar) {
        if (this.f2099a != null) {
            this.f2099a.b(kVar);
        }
    }

    @Override // com.a.a.d.b.b.h
    public /* bridge */ /* synthetic */ k b(com.a.a.d.c cVar, k kVar) {
        return (k) super.b(cVar, kVar);
    }
}
