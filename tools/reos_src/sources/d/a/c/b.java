package d.a.c;

import d.a.a.d;
import d.a.b.o;
import d.a.b.r;
import d.a.h;
import d.a.j;
import d.ab;
import d.ad;
import d.g;
import d.i;
import d.k;
import d.q;
import d.x;
import d.z;
import e.e;
import e.n;
import e.t;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d.b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Socket f6181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile d f6182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f6184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e.d f6185f;
    public int g;
    public boolean i;
    private final ad k;
    private Socket l;
    private q m;
    private x n;
    public final List<Reference<r>> h = new ArrayList();
    public long j = Long.MAX_VALUE;

    public b(ad adVar) {
        this.k = adVar;
    }

    /* JADX WARN: Switch 'out' block B:3:0x0026 for B:7:0x007d already processed. Defaulting to fallback option. */
    private void a(int i, int i2) throws IOException {
        z zVarE = e();
        String str = "CONNECT " + j.a(zVarE.a(), true) + " HTTP/1.1";
        do {
            d.a.b.d dVar = new d.a.b.d(null, this.f6184e, this.f6185f);
            this.f6184e.a().a(i, TimeUnit.MILLISECONDS);
            this.f6185f.a().a(i2, TimeUnit.MILLISECONDS);
            dVar.a(zVarE.c(), str);
            dVar.c();
            ab abVarA = dVar.d().a(zVarE).a();
            long jA = d.a.b.j.a(abVarA);
            if (jA == -1) {
                jA = 0;
            }
            t tVarB = dVar.b(jA);
            j.b(tVarB, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            tVarB.close();
            switch (abVarA.c()) {
                case 200:
                    if (!this.f6184e.c().g() || !this.f6185f.c().g()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return;
                case 407:
                    zVarE = this.k.a().d().a(this.k, abVarA);
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + abVarA.c());
            }
        } while (zVarE != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private void a(int i, int i2, int i3, d.a.a aVar) throws Throwable {
        this.l.setSoTimeout(i2);
        try {
            h.a().a(this.l, this.k.c(), i);
            this.f6184e = n.a(n.b(this.l));
            this.f6185f = n.a(n.a(this.l));
            if (this.k.a().i() != null) {
                a(i2, i3, aVar);
            } else {
                this.n = x.HTTP_1_1;
                this.f6181b = this.l;
            }
            if (this.n != x.SPDY_3 && this.n != x.HTTP_2) {
                this.g = 1;
                return;
            }
            this.f6181b.setSoTimeout(0);
            d dVarA = new d.a(true).a(this.f6181b, this.k.a().a().f(), this.f6184e, this.f6185f).a(this.n).a(this).a();
            dVarA.d();
            this.g = dVarA.b();
            this.f6182c = dVarA;
        } catch (ConnectException e2) {
            throw new ConnectException("Failed to connect to " + this.k.c());
        }
    }

    private void a(int i, int i2, d.a.a aVar) throws Throwable {
        SSLSocket sSLSocket = null;
        if (this.k.d()) {
            a(i, i2);
        }
        d.a aVarA = this.k.a();
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) aVarA.i().createSocket(this.l, aVarA.a().f(), aVarA.a().g(), true);
                try {
                    k kVarA = aVar.a(sSLSocket2);
                    if (kVarA.d()) {
                        h.a().a(sSLSocket2, aVarA.a().f(), aVarA.e());
                    }
                    sSLSocket2.startHandshake();
                    q qVarA = q.a(sSLSocket2.getSession());
                    if (!aVarA.j().verify(aVarA.a().f(), sSLSocket2.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) qVarA.c().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + aVarA.a().f() + " not verified:\n    certificate: " + g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + d.a.d.d.a(x509Certificate));
                    }
                    aVarA.k().a(aVarA.a().f(), qVarA.c());
                    String strB = kVarA.d() ? h.a().b(sSLSocket2) : null;
                    this.f6181b = sSLSocket2;
                    this.f6184e = n.a(n.b(this.f6181b));
                    this.f6185f = n.a(n.a(this.f6181b));
                    this.m = qVarA;
                    this.n = strB != null ? x.a(strB) : x.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        h.a().a(sSLSocket2);
                    }
                } catch (AssertionError e2) {
                    e = e2;
                    if (!j.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    sSLSocket = sSLSocket2;
                    th = th;
                    if (sSLSocket != null) {
                        h.a().a(sSLSocket);
                    }
                    j.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (AssertionError e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private z e() throws IOException {
        return new z.a().a(this.k.a().a()).a("Host", j.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", d.a.k.a()).a();
    }

    @Override // d.i
    public ad a() {
        return this.k;
    }

    public void a(int i, int i2, int i3, List<k> list, boolean z) throws o {
        if (this.n != null) {
            throw new IllegalStateException("already connected");
        }
        d.a.a aVar = new d.a.a(list);
        Proxy proxyB = this.k.b();
        d.a aVarA = this.k.a();
        if (this.k.a().i() == null && !list.contains(k.f6319c)) {
            throw new o(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
        }
        o oVar = null;
        while (this.n == null) {
            try {
                this.l = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? aVarA.c().createSocket() : new Socket(proxyB);
                a(i, i2, i3, aVar);
            } catch (IOException e2) {
                j.a(this.f6181b);
                j.a(this.l);
                this.f6181b = null;
                this.l = null;
                this.f6184e = null;
                this.f6185f = null;
                this.m = null;
                this.n = null;
                if (oVar == null) {
                    oVar = new o(e2);
                } else {
                    oVar.a(e2);
                }
                if (!z) {
                    throw oVar;
                }
                if (!aVar.a(e2)) {
                    throw oVar;
                }
            }
        }
    }

    @Override // d.a.a.d.b
    public void a(d dVar) {
        this.g = dVar.b();
    }

    @Override // d.a.a.d.b
    public void a(d.a.a.e eVar) throws IOException {
        eVar.a(d.a.a.a.REFUSED_STREAM);
    }

    public boolean a(boolean z) {
        if (this.f6181b.isClosed() || this.f6181b.isInputShutdown() || this.f6181b.isOutputShutdown()) {
            return false;
        }
        if (this.f6182c != null || !z) {
            return true;
        }
        try {
            int soTimeout = this.f6181b.getSoTimeout();
            try {
                this.f6181b.setSoTimeout(1);
                if (this.f6184e.g()) {
                    this.f6181b.setSoTimeout(soTimeout);
                    return false;
                }
                this.f6181b.setSoTimeout(soTimeout);
                return true;
            } catch (Throwable th) {
                this.f6181b.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException e2) {
            return true;
        } catch (IOException e3) {
            return false;
        }
    }

    public void b() {
        j.a(this.l);
    }

    public Socket c() {
        return this.f6181b;
    }

    public q d() {
        return this.m;
    }

    public String toString() {
        return "Connection{" + this.k.a().a().f() + ":" + this.k.a().a().g() + ", proxy=" + this.k.b() + " hostAddress=" + this.k.c() + " cipherSuite=" + (this.m != null ? this.m.b() : "none") + " protocol=" + this.n + '}';
    }
}
