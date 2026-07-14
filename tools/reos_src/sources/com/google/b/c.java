package com.google.b;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.b.c.b f5428b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f5427a = bVar;
    }

    public int a() {
        return this.f5427a.c();
    }

    public com.google.b.c.a a(int i, com.google.b.c.a aVar) throws i {
        return this.f5427a.a(i, aVar);
    }

    public int b() {
        return this.f5427a.d();
    }

    public com.google.b.c.b c() throws i {
        if (this.f5428b == null) {
            this.f5428b = this.f5427a.b();
        }
        return this.f5428b;
    }

    public boolean d() {
        return this.f5427a.a().d();
    }

    public c e() {
        return new c(this.f5427a.a(this.f5427a.a().e()));
    }

    public String toString() {
        try {
            return c().toString();
        } catch (i e2) {
            return "";
        }
    }
}
