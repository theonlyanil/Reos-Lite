package com.google.b.g.a.a;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.b.g.a.b f5584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.b.g.a.b f5585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.b.g.a.c f5586d;

    b(com.google.b.g.a.b bVar, com.google.b.g.a.b bVar2, com.google.b.g.a.c cVar, boolean z) {
        this.f5584b = bVar;
        this.f5585c = bVar2;
        this.f5586d = cVar;
        this.f5583a = z;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    com.google.b.g.a.b a() {
        return this.f5584b;
    }

    com.google.b.g.a.b b() {
        return this.f5585c;
    }

    com.google.b.g.a.c c() {
        return this.f5586d;
    }

    public boolean d() {
        return this.f5585c == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f5584b, bVar.f5584b) && a(this.f5585c, bVar.f5585c) && a(this.f5586d, bVar.f5586d);
    }

    public int hashCode() {
        return (a(this.f5584b) ^ a(this.f5585c)) ^ a(this.f5586d);
    }

    public String toString() {
        return "[ " + this.f5584b + " , " + this.f5585c + " : " + (this.f5586d == null ? "null" : Integer.valueOf(this.f5586d.a())) + " ]";
    }
}
