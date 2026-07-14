package d;

/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f6231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f6232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f6235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final r f6236f;
    private final ac g;
    private ab h;
    private ab i;
    private final ab j;
    private volatile d k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private z f6237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private x f6238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f6240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private q f6241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private r.a f6242f;
        private ac g;
        private ab h;
        private ab i;
        private ab j;

        public a() {
            this.f6239c = -1;
            this.f6242f = new r.a();
        }

        private a(ab abVar) {
            this.f6239c = -1;
            this.f6237a = abVar.f6231a;
            this.f6238b = abVar.f6232b;
            this.f6239c = abVar.f6233c;
            this.f6240d = abVar.f6234d;
            this.f6241e = abVar.f6235e;
            this.f6242f = abVar.f6236f.b();
            this.g = abVar.g;
            this.h = abVar.h;
            this.i = abVar.i;
            this.j = abVar.j;
        }

        private void a(String str, ab abVar) {
            if (abVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (abVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (abVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (abVar.j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private void d(ab abVar) {
            if (abVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int i) {
            this.f6239c = i;
            return this;
        }

        public a a(ab abVar) {
            if (abVar != null) {
                a("networkResponse", abVar);
            }
            this.h = abVar;
            return this;
        }

        public a a(ac acVar) {
            this.g = acVar;
            return this;
        }

        public a a(q qVar) {
            this.f6241e = qVar;
            return this;
        }

        public a a(r rVar) {
            this.f6242f = rVar.b();
            return this;
        }

        public a a(x xVar) {
            this.f6238b = xVar;
            return this;
        }

        public a a(z zVar) {
            this.f6237a = zVar;
            return this;
        }

        public a a(String str) {
            this.f6240d = str;
            return this;
        }

        public a a(String str, String str2) {
            this.f6242f.c(str, str2);
            return this;
        }

        public ab a() {
            if (this.f6237a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f6238b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f6239c < 0) {
                throw new IllegalStateException("code < 0: " + this.f6239c);
            }
            return new ab(this);
        }

        public a b(ab abVar) {
            if (abVar != null) {
                a("cacheResponse", abVar);
            }
            this.i = abVar;
            return this;
        }

        public a b(String str, String str2) {
            this.f6242f.a(str, str2);
            return this;
        }

        public a c(ab abVar) {
            if (abVar != null) {
                d(abVar);
            }
            this.j = abVar;
            return this;
        }
    }

    private ab(a aVar) {
        this.f6231a = aVar.f6237a;
        this.f6232b = aVar.f6238b;
        this.f6233c = aVar.f6239c;
        this.f6234d = aVar.f6240d;
        this.f6235e = aVar.f6241e;
        this.f6236f = aVar.f6242f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    public z a() {
        return this.f6231a;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String strA = this.f6236f.a(str);
        return strA != null ? strA : str2;
    }

    public x b() {
        return this.f6232b;
    }

    public int c() {
        return this.f6233c;
    }

    public boolean d() {
        return this.f6233c >= 200 && this.f6233c < 300;
    }

    public String e() {
        return this.f6234d;
    }

    public q f() {
        return this.f6235e;
    }

    public r g() {
        return this.f6236f;
    }

    public ac h() {
        return this.g;
    }

    public a i() {
        return new a();
    }

    public ab j() {
        return this.h;
    }

    public d k() {
        d dVar = this.k;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f6236f);
        this.k = dVarA;
        return dVarA;
    }

    public String toString() {
        return "Response{protocol=" + this.f6232b + ", code=" + this.f6233c + ", message=" + this.f6234d + ", url=" + this.f6231a.a() + '}';
    }
}
