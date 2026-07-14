package d.a.b;

import d.aa;
import d.ab;
import d.ac;
import d.ad;
import d.t;
import d.u;
import d.w;
import d.x;
import d.z;
import e.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ac f6137e = new ac() { // from class: d.a.b.g.1
        @Override // d.ac
        public u a() {
            return null;
        }

        @Override // d.ac
        public long b() {
            return 0L;
        }

        @Override // d.ac
        public e.e c() {
            return new e.c();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w f6138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f6139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f6140c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6141d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ab f6142f;
    private i g;
    private boolean h;
    private final z i;
    private z j;
    private ab k;
    private ab l;
    private s m;
    private e.d n;
    private final boolean o;
    private final boolean p;
    private d.a.b.a q;
    private b r;

    class a implements t.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final z f6150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f6151d;

        a(int i, z zVar) {
            this.f6149b = i;
            this.f6150c = zVar;
        }

        @Override // d.t.a
        public ab a(z zVar) throws IOException {
            this.f6151d++;
            if (this.f6149b > 0) {
                t tVar = g.this.f6138a.w().get(this.f6149b - 1);
                d.a aVarA = b().a().a();
                if (!zVar.a().f().equals(aVarA.a().f()) || zVar.a().g() != aVarA.a().g()) {
                    throw new IllegalStateException("network interceptor " + tVar + " must retain the same host and port");
                }
                if (this.f6151d > 1) {
                    throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                }
            }
            if (this.f6149b < g.this.f6138a.w().size()) {
                a aVar = g.this.new a(this.f6149b + 1, zVar);
                t tVar2 = g.this.f6138a.w().get(this.f6149b);
                ab abVarA = tVar2.a(aVar);
                if (aVar.f6151d != 1) {
                    throw new IllegalStateException("network interceptor " + tVar2 + " must call proceed() exactly once");
                }
                if (abVarA == null) {
                    throw new NullPointerException("network interceptor " + tVar2 + " returned null");
                }
                return abVarA;
            }
            g.this.g.a(zVar);
            g.this.j = zVar;
            if (g.this.a(zVar) && zVar.d() != null) {
                e.d dVarA = e.n.a(g.this.g.a(zVar, zVar.d().b()));
                zVar.d().a(dVarA);
                dVarA.close();
            }
            ab abVarM = g.this.m();
            int iC = abVarM.c();
            if ((iC == 204 || iC == 205) && abVarM.h().b() > 0) {
                throw new ProtocolException("HTTP " + iC + " had non-zero Content-Length: " + abVarM.h().b());
            }
            return abVarM;
        }

        @Override // d.t.a
        public z a() {
            return this.f6150c;
        }

        public d.i b() {
            return g.this.f6139b.a();
        }
    }

    public g(w wVar, z zVar, boolean z, boolean z2, boolean z3, r rVar, n nVar, ab abVar) {
        this.f6138a = wVar;
        this.i = zVar;
        this.f6141d = z;
        this.o = z2;
        this.p = z3;
        this.f6139b = rVar == null ? new r(wVar.o(), a(wVar, zVar)) : rVar;
        this.m = nVar;
        this.f6142f = abVar;
    }

    private static d.a a(w wVar, z zVar) {
        HostnameVerifier hostnameVerifierK;
        SSLSocketFactory sSLSocketFactoryJ;
        d.g gVarL = null;
        if (zVar.g()) {
            sSLSocketFactoryJ = wVar.j();
            hostnameVerifierK = wVar.k();
            gVarL = wVar.l();
        } else {
            hostnameVerifierK = null;
            sSLSocketFactoryJ = null;
        }
        return new d.a(zVar.a().f(), zVar.a().g(), wVar.h(), wVar.i(), sSLSocketFactoryJ, hostnameVerifierK, gVarL, wVar.n(), wVar.d(), wVar.t(), wVar.u(), wVar.e());
    }

    private ab a(final d.a.b.a aVar, ab abVar) throws IOException {
        s sVarB;
        if (aVar == null || (sVarB = aVar.b()) == null) {
            return abVar;
        }
        final e.e eVarC = abVar.h().c();
        final e.d dVarA = e.n.a(sVarB);
        return abVar.i().a(new k(abVar.g(), e.n.a(new e.t() { // from class: d.a.b.g.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f6143a;

            @Override // e.t
            public long a(e.c cVar, long j) throws IOException {
                try {
                    long jA = eVarC.a(cVar, j);
                    if (jA != -1) {
                        cVar.a(dVarA.c(), cVar.b() - jA, jA);
                        dVarA.w();
                        return jA;
                    }
                    if (!this.f6143a) {
                        this.f6143a = true;
                        dVarA.close();
                    }
                    return -1L;
                } catch (IOException e2) {
                    if (!this.f6143a) {
                        this.f6143a = true;
                        aVar.a();
                    }
                    throw e2;
                }
            }

            @Override // e.t
            public e.u a() {
                return eVarC.a();
            }

            @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f6143a && !d.a.j.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f6143a = true;
                    aVar.a();
                }
                eVarC.close();
            }
        }))).a();
    }

    private static d.r a(d.r rVar, d.r rVar2) throws IOException {
        d.r.a aVar = new d.r.a();
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = rVar.a(i);
            String strB = rVar.b(i);
            if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (!j.a(strA) || rVar2.a(strA) == null)) {
                aVar.a(strA, strB);
            }
        }
        int iA2 = rVar2.a();
        for (int i2 = 0; i2 < iA2; i2++) {
            String strA2 = rVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(strA2) && j.a(strA2)) {
                aVar.a(strA2, rVar2.b(i2));
            }
        }
        return aVar.a();
    }

    private String a(List<d.l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            d.l lVar = list.get(i);
            sb.append(lVar.a()).append('=').append(lVar.b());
        }
        return sb.toString();
    }

    public static boolean a(ab abVar) {
        if (abVar.a().b().equals("HEAD")) {
            return false;
        }
        int iC = abVar.c();
        if ((iC >= 100 && iC < 200) || iC == 204 || iC == 304) {
            return j.a(abVar) != -1 || "chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"));
        }
        return true;
    }

    private static boolean a(ab abVar, ab abVar2) {
        Date dateB;
        if (abVar2.c() == 304) {
            return true;
        }
        Date dateB2 = abVar.g().b("Last-Modified");
        return (dateB2 == null || (dateB = abVar2.g().b("Last-Modified")) == null || dateB.getTime() >= dateB2.getTime()) ? false : true;
    }

    private static ab b(ab abVar) {
        return (abVar == null || abVar.h() == null) ? abVar : abVar.i().a((ac) null).a();
    }

    private z b(z zVar) throws IOException {
        z.a aVarE = zVar.e();
        if (zVar.a("Host") == null) {
            aVarE.a("Host", d.a.j.a(zVar.a(), false));
        }
        if (zVar.a("Connection") == null) {
            aVarE.a("Connection", "Keep-Alive");
        }
        if (zVar.a("Accept-Encoding") == null) {
            this.h = true;
            aVarE.a("Accept-Encoding", "gzip");
        }
        List<d.l> listA = this.f6138a.f().a(zVar.a());
        if (!listA.isEmpty()) {
            aVarE.a("Cookie", a(listA));
        }
        if (zVar.a("User-Agent") == null) {
            aVarE.a("User-Agent", d.a.k.a());
        }
        return aVarE.a();
    }

    private ab c(ab abVar) throws IOException {
        if (!this.h || !"gzip".equalsIgnoreCase(this.l.a("Content-Encoding")) || abVar.h() == null) {
            return abVar;
        }
        e.l lVar = new e.l(abVar.h().c());
        d.r rVarA = abVar.g().b().b("Content-Encoding").b("Content-Length").a();
        return abVar.i().a(rVarA).a(new k(rVarA, e.n.a(lVar))).a();
    }

    private boolean j() {
        return this.o && a(this.j) && this.m == null;
    }

    private i k() throws l, o, IOException {
        return this.f6139b.a(this.f6138a.a(), this.f6138a.b(), this.f6138a.c(), this.f6138a.r(), !this.j.b().equals("GET"));
    }

    private void l() throws IOException {
        d.a.e eVarA = d.a.d.f6187b.a(this.f6138a);
        if (eVarA == null) {
            return;
        }
        if (b.a(this.l, this.j)) {
            this.q = eVarA.a(b(this.l));
        } else if (h.a(this.j.b())) {
            try {
                eVarA.b(this.j);
            } catch (IOException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ab m() throws IOException {
        this.g.c();
        ab abVarA = this.g.b().a(this.j).a(this.f6139b.a().d()).a(j.f6153b, Long.toString(this.f6140c)).a(j.f6154c, Long.toString(System.currentTimeMillis())).a();
        if (!this.p) {
            abVarA = abVarA.i().a(this.g.a(abVarA)).a();
        }
        if ("close".equalsIgnoreCase(abVarA.a().a("Connection")) || "close".equalsIgnoreCase(abVarA.a("Connection"))) {
            this.f6139b.c();
        }
        return abVarA;
    }

    public g a(IOException iOException, s sVar) {
        if (!this.f6139b.a(iOException, sVar) || !this.f6138a.r()) {
            return null;
        }
        return new g(this.f6138a, this.i, this.f6141d, this.o, this.p, g(), (n) sVar, this.f6142f);
    }

    public void a() throws l, o, IOException {
        if (this.r != null) {
            return;
        }
        if (this.g != null) {
            throw new IllegalStateException();
        }
        z zVarB = b(this.i);
        d.a.e eVarA = d.a.d.f6187b.a(this.f6138a);
        ab abVarA = eVarA != null ? eVarA.a(zVarB) : null;
        this.r = new b.a(System.currentTimeMillis(), zVarB, abVarA).a();
        this.j = this.r.f6097a;
        this.k = this.r.f6098b;
        if (eVarA != null) {
            eVarA.a(this.r);
        }
        if (abVarA != null && this.k == null) {
            d.a.j.a(abVarA.h());
        }
        if (this.j == null && this.k == null) {
            this.l = new ab.a().a(this.i).c(b(this.f6142f)).a(x.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(f6137e).a();
            return;
        }
        if (this.j == null) {
            this.l = this.k.i().a(this.i).c(b(this.f6142f)).b(b(this.k)).a();
            this.l = c(this.l);
            return;
        }
        try {
            this.g = k();
            this.g.a(this);
            if (j()) {
                long jA = j.a(zVarB);
                if (!this.f6141d) {
                    this.g.a(this.j);
                    this.m = this.g.a(this.j, jA);
                } else {
                    if (jA > 2147483647L) {
                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                    }
                    if (jA == -1) {
                        this.m = new n();
                    } else {
                        this.g.a(this.j);
                        this.m = new n((int) jA);
                    }
                }
            }
        } catch (Throwable th) {
            if (abVarA != null) {
                d.a.j.a(abVarA.h());
            }
            throw th;
        }
    }

    public void a(d.r rVar) throws IOException {
        if (this.f6138a.f() == d.m.f6333a) {
            return;
        }
        List<d.l> listA = d.l.a(this.i.a(), rVar);
        if (listA.isEmpty()) {
            return;
        }
        this.f6138a.f().a(this.i.a(), listA);
    }

    public boolean a(d.s sVar) {
        d.s sVarA = this.i.a();
        return sVarA.f().equals(sVar.f()) && sVarA.g() == sVar.g() && sVarA.b().equals(sVar.b());
    }

    boolean a(z zVar) {
        return h.c(zVar.b());
    }

    public void b() {
        if (this.f6140c != -1) {
            throw new IllegalStateException();
        }
        this.f6140c = System.currentTimeMillis();
    }

    public ab c() {
        if (this.l == null) {
            throw new IllegalStateException();
        }
        return this.l;
    }

    public d.i d() {
        return this.f6139b.a();
    }

    public void e() throws IOException {
        this.f6139b.b();
    }

    public void f() {
        this.f6139b.d();
    }

    public r g() {
        if (this.n != null) {
            d.a.j.a(this.n);
        } else if (this.m != null) {
            d.a.j.a(this.m);
        }
        if (this.l != null) {
            d.a.j.a(this.l.h());
        } else {
            this.f6139b.a((IOException) null);
        }
        return this.f6139b;
    }

    public void h() throws IOException {
        ab abVarM;
        if (this.l != null) {
            return;
        }
        if (this.j == null && this.k == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (this.j != null) {
            if (this.p) {
                this.g.a(this.j);
                abVarM = m();
            } else if (this.o) {
                if (this.n != null && this.n.c().b() > 0) {
                    this.n.f();
                }
                if (this.f6140c == -1) {
                    if (j.a(this.j) == -1 && (this.m instanceof n)) {
                        this.j = this.j.e().a("Content-Length", Long.toString(((n) this.m).b())).a();
                    }
                    this.g.a(this.j);
                }
                if (this.m != null) {
                    if (this.n != null) {
                        this.n.close();
                    } else {
                        this.m.close();
                    }
                    if (this.m instanceof n) {
                        this.g.a((n) this.m);
                    }
                }
                abVarM = m();
            } else {
                abVarM = new a(0, this.j).a(this.j);
            }
            a(abVarM.g());
            if (this.k != null) {
                if (a(this.k, abVarM)) {
                    this.l = this.k.i().a(this.i).c(b(this.f6142f)).a(a(this.k.g(), abVarM.g())).b(b(this.k)).a(b(abVarM)).a();
                    abVarM.h().close();
                    e();
                    d.a.e eVarA = d.a.d.f6187b.a(this.f6138a);
                    eVarA.a();
                    eVarA.a(this.k, b(this.l));
                    this.l = c(this.l);
                    return;
                }
                d.a.j.a(this.k.h());
            }
            this.l = abVarM.i().a(this.i).c(b(this.f6142f)).b(b(this.k)).a(b(abVarM)).a();
            if (a(this.l)) {
                l();
                this.l = c(a(this.q, this.l));
            }
        }
    }

    public z i() throws IOException {
        String strA;
        d.s sVarC;
        if (this.l == null) {
            throw new IllegalStateException();
        }
        d.a.c.b bVarA = this.f6139b.a();
        ad adVarA = bVarA != null ? bVarA.a() : null;
        int iC = this.l.c();
        String strB = this.i.b();
        switch (iC) {
            case 307:
            case 308:
                if (!strB.equals("GET") && !strB.equals("HEAD")) {
                    return null;
                }
            case 300:
            case 301:
            case 302:
            case 303:
                if (!this.f6138a.q() || (strA = this.l.a("Location")) == null || (sVarC = this.i.a().c(strA)) == null) {
                    return null;
                }
                if (!sVarC.b().equals(this.i.a().b()) && !this.f6138a.p()) {
                    return null;
                }
                z.a aVarE = this.i.e();
                if (h.c(strB)) {
                    if (h.d(strB)) {
                        aVarE.a("GET", (aa) null);
                    } else {
                        aVarE.a(strB, (aa) null);
                    }
                    aVarE.b("Transfer-Encoding");
                    aVarE.b("Content-Length");
                    aVarE.b("Content-Type");
                }
                if (!a(sVarC)) {
                    aVarE.b("Authorization");
                }
                return aVarE.a(sVarC).a();
            case 407:
                if ((adVarA != null ? adVarA.b() : this.f6138a.d()).type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            case 401:
                return this.f6138a.m().a(adVarA, this.l);
            case 408:
                boolean z = this.m == null || (this.m instanceof n);
                if (!this.o || z) {
                    return this.i;
                }
                return null;
            default:
                return null;
        }
    }
}
