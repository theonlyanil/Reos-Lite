package d;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
final class y implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f6406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    z f6407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d.a.b.g f6408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w f6409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6410e;

    class a implements t.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final z f6413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f6414d;

        a(int i, z zVar, boolean z) {
            this.f6412b = i;
            this.f6413c = zVar;
            this.f6414d = z;
        }

        @Override // d.t.a
        public ab a(z zVar) throws IOException {
            if (this.f6412b >= y.this.f6409d.v().size()) {
                return y.this.a(zVar, this.f6414d);
            }
            a aVar = y.this.new a(this.f6412b + 1, zVar, this.f6414d);
            t tVar = y.this.f6409d.v().get(this.f6412b);
            ab abVarA = tVar.a(aVar);
            if (abVarA == null) {
                throw new NullPointerException("application interceptor " + tVar + " returned null");
            }
            return abVarA;
        }

        @Override // d.t.a
        public z a() {
            return this.f6413c;
        }
    }

    final class b extends d.a.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f f6416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f6417d;

        private b(f fVar, boolean z) {
            super("OkHttp %s", y.this.f6407b.a().toString());
            this.f6416c = fVar;
            this.f6417d = z;
        }

        String a() {
            return y.this.f6407b.a().f();
        }

        @Override // d.a.f
        protected void b() {
            boolean z = true;
            try {
                try {
                    ab abVarA = y.this.a(this.f6417d);
                    try {
                        if (y.this.f6406a) {
                            this.f6416c.a(y.this, new IOException("Canceled"));
                        } else {
                            this.f6416c.a(y.this, abVarA);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (z) {
                            d.a.d.f6186a.log(Level.INFO, "Callback failure for " + y.this.b(), (Throwable) e);
                        } else {
                            this.f6416c.a(y.this, e);
                        }
                    }
                } finally {
                    y.this.f6409d.s().b(this);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            }
        }
    }

    protected y(w wVar, z zVar) {
        this.f6409d = wVar;
        this.f6407b = zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ab a(boolean z) throws IOException {
        return new a(0, this.f6407b, z).a(this.f6407b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        return (this.f6406a ? "canceled call" : "call") + " to " + this.f6407b.a().c("/...");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008e  */
    ab a(z zVar, boolean z) throws Throwable {
        z zVarA;
        boolean z2;
        aa aaVarD = zVar.d();
        if (aaVarD != null) {
            z.a aVarE = zVar.e();
            u uVarA = aaVarD.a();
            if (uVarA != null) {
                aVarE.a("Content-Type", uVarA.toString());
            }
            long jB = aaVarD.b();
            if (jB != -1) {
                aVarE.a("Content-Length", Long.toString(jB));
                aVarE.b("Transfer-Encoding");
            } else {
                aVarE.a("Transfer-Encoding", "chunked");
                aVarE.b("Content-Length");
            }
            zVarA = aVarE.a();
        } else {
            zVarA = zVar;
        }
        this.f6408c = new d.a.b.g(this.f6409d, zVarA, false, false, z, null, null, null);
        int i = 0;
        while (!this.f6406a) {
            try {
                try {
                    this.f6408c.a();
                    this.f6408c.h();
                    ab abVarC = this.f6408c.c();
                    z zVarI = this.f6408c.i();
                    if (zVarI == null) {
                        if (!z) {
                            this.f6408c.e();
                        }
                        return abVarC;
                    }
                    d.a.b.r rVarG = this.f6408c.g();
                    int i2 = i + 1;
                    if (i2 > 20) {
                        rVarG.b();
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    }
                    if (!this.f6408c.a(zVarI.a())) {
                        rVarG.b();
                        rVarG = null;
                    }
                    this.f6408c = new d.a.b.g(this.f6409d, zVarI, false, false, z, rVarG, null, abVarC);
                    i = i2;
                } catch (d.a.b.l e2) {
                    throw e2.getCause();
                } catch (d.a.b.o e3) {
                    d.a.b.g gVarA = this.f6408c.a(e3.a(), (e.s) null);
                    if (gVarA == null) {
                        throw e3.a();
                    }
                    z2 = false;
                    try {
                        this.f6408c = gVarA;
                    } catch (Throwable th) {
                        th = th;
                        if (z2) {
                            this.f6408c.g().b();
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    d.a.b.g gVarA2 = this.f6408c.a(e4, (e.s) null);
                    if (gVarA2 == null) {
                        throw e4;
                    }
                    this.f6408c = gVarA2;
                }
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
                if (z2) {
                    this.f6408c.g().b();
                }
                throw th;
            }
        }
        this.f6408c.e();
        throw new IOException("Canceled");
    }

    @Override // d.e
    public void a() {
        this.f6406a = true;
        if (this.f6408c != null) {
            this.f6408c.f();
        }
    }

    @Override // d.e
    public void a(f fVar) {
        a(fVar, false);
    }

    void a(f fVar, boolean z) {
        synchronized (this) {
            if (this.f6410e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f6410e = true;
        }
        this.f6409d.s().a(new b(fVar, z));
    }
}
