package b.a.a;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Method f1925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final n f1926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Class<?> f1927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f1928d;

    k(Method method, n nVar, Class<?> cls) {
        this.f1925a = method;
        this.f1926b = nVar;
        this.f1927c = cls;
    }

    private synchronized void a() {
        if (this.f1928d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f1925a.getDeclaringClass().getName());
            sb.append('#').append(this.f1925a.getName());
            sb.append('(').append(this.f1927c.getName());
            this.f1928d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        a();
        k kVar = (k) obj;
        kVar.a();
        return this.f1928d.equals(kVar.f1928d);
    }

    public int hashCode() {
        return this.f1925a.hashCode();
    }
}
