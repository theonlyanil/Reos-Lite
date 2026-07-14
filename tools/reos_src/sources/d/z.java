package d;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f6418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f6420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final aa f6421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f6422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile d f6423f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private s f6424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f6425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private r.a f6426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private aa f6427d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Object f6428e;

        public a() {
            this.f6425b = "GET";
            this.f6426c = new r.a();
        }

        private a(z zVar) {
            this.f6424a = zVar.f6418a;
            this.f6425b = zVar.f6419b;
            this.f6427d = zVar.f6421d;
            this.f6428e = zVar.f6422e;
            this.f6426c = zVar.f6420c.b();
        }

        public a a(r rVar) {
            this.f6426c = rVar.b();
            return this;
        }

        public a a(s sVar) {
            if (sVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f6424a = sVar;
            return this;
        }

        public a a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            s sVarE = s.e(str);
            if (sVarE == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return a(sVarE);
        }

        public a a(String str, aa aaVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (aaVar != null && !d.a.b.h.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (aaVar == null && d.a.b.h.b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.f6425b = str;
            this.f6427d = aaVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f6426c.c(str, str2);
            return this;
        }

        public z a() {
            if (this.f6424a == null) {
                throw new IllegalStateException("url == null");
            }
            return new z(this);
        }

        public a b(String str) {
            this.f6426c.b(str);
            return this;
        }

        public a b(String str, String str2) {
            this.f6426c.a(str, str2);
            return this;
        }
    }

    private z(a aVar) {
        this.f6418a = aVar.f6424a;
        this.f6419b = aVar.f6425b;
        this.f6420c = aVar.f6426c.a();
        this.f6421d = aVar.f6427d;
        this.f6422e = aVar.f6428e != null ? aVar.f6428e : this;
    }

    public s a() {
        return this.f6418a;
    }

    public String a(String str) {
        return this.f6420c.a(str);
    }

    public String b() {
        return this.f6419b;
    }

    public List<String> b(String str) {
        return this.f6420c.c(str);
    }

    public r c() {
        return this.f6420c;
    }

    public aa d() {
        return this.f6421d;
    }

    public a e() {
        return new a();
    }

    public d f() {
        d dVar = this.f6423f;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f6420c);
        this.f6423f = dVarA;
        return dVarA;
    }

    public boolean g() {
        return this.f6418a.c();
    }

    public String toString() {
        return "Request{method=" + this.f6419b + ", url=" + this.f6418a + ", tag=" + (this.f6422e != this ? this.f6422e : null) + '}';
    }
}
