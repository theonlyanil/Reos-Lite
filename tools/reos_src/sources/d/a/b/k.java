package d.a.b;

import d.ac;
import d.u;

/* JADX INFO: loaded from: classes.dex */
public final class k extends ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.r f6157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.e f6158b;

    public k(d.r rVar, e.e eVar) {
        this.f6157a = rVar;
        this.f6158b = eVar;
    }

    @Override // d.ac
    public u a() {
        String strA = this.f6157a.a("Content-Type");
        if (strA != null) {
            return u.a(strA);
        }
        return null;
    }

    @Override // d.ac
    public long b() {
        return j.a(this.f6157a);
    }

    @Override // d.ac
    public e.e c() {
        return this.f6158b;
    }
}
