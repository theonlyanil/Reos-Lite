package com.a.a.h.a;

/* JADX INFO: loaded from: classes.dex */
public class g<R> implements d<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f.a f2428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<R> f2429b;

    g(f.a aVar) {
        this.f2428a = aVar;
    }

    @Override // com.a.a.h.a.d
    public c<R> a(boolean z, boolean z2) {
        if (z || !z2) {
            return e.b();
        }
        if (this.f2429b == null) {
            this.f2429b = new f(this.f2428a);
        }
        return this.f2429b;
    }
}
