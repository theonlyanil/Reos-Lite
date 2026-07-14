package b.a.a;

/* JADX INFO: loaded from: classes.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f1931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final k f1932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f1933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f1934d = true;

    m(Object obj, k kVar, int i) {
        this.f1931a = obj;
        this.f1932b = kVar;
        this.f1933c = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f1931a == mVar.f1931a && this.f1932b.equals(mVar.f1932b);
    }

    public int hashCode() {
        return this.f1931a.hashCode() + this.f1932b.f1928d.hashCode();
    }
}
