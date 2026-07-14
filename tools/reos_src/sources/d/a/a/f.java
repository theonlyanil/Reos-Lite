package d.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e.f f6001a = e.f.a(":status");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e.f f6002b = e.f.a(":method");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e.f f6003c = e.f.a(":path");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e.f f6004d = e.f.a(":scheme");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e.f f6005e = e.f.a(":authority");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e.f f6006f = e.f.a(":host");
    public static final e.f g = e.f.a(":version");
    public final e.f h;
    public final e.f i;
    final int j;

    public f(e.f fVar, e.f fVar2) {
        this.h = fVar;
        this.i = fVar2;
        this.j = fVar.f() + 32 + fVar2.f();
    }

    public f(e.f fVar, String str) {
        this(fVar, e.f.a(str));
    }

    public f(String str, String str2) {
        this(e.f.a(str), e.f.a(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.h.equals(fVar.h) && this.i.equals(fVar.i);
    }

    public int hashCode() {
        return ((this.h.hashCode() + 527) * 31) + this.i.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.h.a(), this.i.a());
    }
}
