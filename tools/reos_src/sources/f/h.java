package f;

import d.ab;
import d.ac;
import d.u;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class h<T> implements f.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<T> f6524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f6525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f6526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.e f6527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f6528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6529f;

    static final class a extends ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        IOException f6532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ac f6533b;

        a(ac acVar) {
            this.f6533b = acVar;
        }

        @Override // d.ac
        public u a() {
            return this.f6533b.a();
        }

        @Override // d.ac
        public long b() {
            return this.f6533b.b();
        }

        @Override // d.ac
        public e.e c() {
            return e.n.a(new e.i(this.f6533b.c()) { // from class: f.h.a.1
                @Override // e.i, e.t
                public long a(e.c cVar, long j) throws IOException {
                    try {
                        return super.a(cVar, j);
                    } catch (IOException e2) {
                        a.this.f6532a = e2;
                        throw e2;
                    }
                }
            });
        }

        @Override // d.ac, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6533b.close();
        }

        void f() throws IOException {
            if (this.f6532a != null) {
                throw this.f6532a;
            }
        }
    }

    static final class b extends ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u f6535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6536b;

        b(u uVar, long j) {
            this.f6535a = uVar;
            this.f6536b = j;
        }

        @Override // d.ac
        public u a() {
            return this.f6535a;
        }

        @Override // d.ac
        public long b() {
            return this.f6536b;
        }

        @Override // d.ac
        public e.e c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    h(n<T> nVar, Object[] objArr) {
        this.f6524a = nVar;
        this.f6525b = objArr;
    }

    private d.e d() throws IOException {
        d.e eVarA = this.f6524a.f6592c.a(this.f6524a.a(this.f6525b));
        if (eVarA == null) {
            throw new NullPointerException("Call.Factory returned null.");
        }
        return eVarA;
    }

    l<T> a(ab abVar) throws IOException {
        ac acVarH = abVar.h();
        ab abVarA = abVar.i().a(new b(acVarH.a(), acVarH.b())).a();
        int iC = abVarA.c();
        if (iC < 200 || iC >= 300) {
            try {
                return l.a(o.a(acVarH), abVarA);
            } finally {
                acVarH.close();
            }
        }
        if (iC == 204 || iC == 205) {
            return l.a((Object) null, abVarA);
        }
        a aVar = new a(acVarH);
        try {
            return l.a(this.f6524a.a(aVar), abVarA);
        } catch (RuntimeException e2) {
            aVar.f();
            throw e2;
        }
    }

    @Override // f.b
    public void a(final d<T> dVar) {
        Throwable th;
        d.e eVarD;
        if (dVar == null) {
            throw new NullPointerException("callback == null");
        }
        synchronized (this) {
            if (this.f6529f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f6529f = true;
            d.e eVar = this.f6527d;
            th = this.f6528e;
            if (eVar == null && th == null) {
                try {
                    eVarD = d();
                    this.f6527d = eVarD;
                } catch (Throwable th2) {
                    th = th2;
                    this.f6528e = th;
                    eVarD = eVar;
                }
            } else {
                eVarD = eVar;
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.f6526c) {
            eVarD.a();
        }
        eVarD.a(new d.f() { // from class: f.h.1
            private void a(l<T> lVar) {
                try {
                    dVar.a(h.this, lVar);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }

            private void a(Throwable th3) {
                try {
                    dVar.a(h.this, th3);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }

            @Override // d.f
            public void a(d.e eVar2, ab abVar) throws IOException {
                try {
                    a(h.this.a(abVar));
                } catch (Throwable th3) {
                    a(th3);
                }
            }

            @Override // d.f
            public void a(d.e eVar2, IOException iOException) {
                try {
                    dVar.a(h.this, iOException);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
    }

    @Override // f.b
    public boolean a() {
        return this.f6526c;
    }

    @Override // f.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<T> clone() {
        return new h<>(this.f6524a, this.f6525b);
    }
}
