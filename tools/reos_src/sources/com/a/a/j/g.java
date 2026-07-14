package com.a.a.j;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f2514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f2515b;

    public g() {
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }

    public void a(Class<?> cls, Class<?> cls2) {
        this.f2514a = cls;
        this.f2515b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2514a.equals(gVar.f2514a) && this.f2515b.equals(gVar.f2515b);
    }

    public int hashCode() {
        return (this.f2514a.hashCode() * 31) + this.f2515b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f2514a + ", second=" + this.f2515b + '}';
    }
}
