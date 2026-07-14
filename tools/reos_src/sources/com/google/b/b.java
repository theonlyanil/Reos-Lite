package com.google.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f5394a;

    protected b(g gVar) {
        this.f5394a = gVar;
    }

    public abstract b a(g gVar);

    public abstract com.google.b.c.a a(int i, com.google.b.c.a aVar) throws i;

    public final g a() {
        return this.f5394a;
    }

    public abstract com.google.b.c.b b() throws i;

    public final int c() {
        return this.f5394a.b();
    }

    public final int d() {
        return this.f5394a.c();
    }
}
