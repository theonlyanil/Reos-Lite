package d;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class w implements e.a, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final n f6388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Proxy f6389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<x> f6390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<k> f6391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<t> f6392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<t> f6393f;
    final ProxySelector g;
    final m h;
    final c i;
    final d.a.e j;
    final SocketFactory k;
    final SSLSocketFactory l;
    final d.a.d.f m;
    final HostnameVerifier n;
    final g o;
    final b p;
    final b q;
    final j r;
    final o s;
    final boolean t;
    final boolean u;
    final boolean v;
    final int w;
    final int x;
    final int y;
    private static final List<x> z = d.a.j.a(x.HTTP_2, x.SPDY_3, x.HTTP_1_1);
    private static final List<k> A = d.a.j.a(k.f6317a, k.f6318b, k.f6319c);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        n f6394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Proxy f6395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<x> f6396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<k> f6397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<t> f6398e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<t> f6399f;
        ProxySelector g;
        m h;
        c i;
        d.a.e j;
        SocketFactory k;
        SSLSocketFactory l;
        d.a.d.f m;
        HostnameVerifier n;
        g o;
        b p;
        b q;
        j r;
        o s;
        boolean t;
        boolean u;
        boolean v;
        int w;
        int x;
        int y;

        public a() {
            this.f6398e = new ArrayList();
            this.f6399f = new ArrayList();
            this.f6394a = new n();
            this.f6396c = w.z;
            this.f6397d = w.A;
            this.g = ProxySelector.getDefault();
            this.h = m.f6333a;
            this.k = SocketFactory.getDefault();
            this.n = d.a.d.d.f6197a;
            this.o = g.f6296a;
            this.p = b.f6256a;
            this.q = b.f6256a;
            this.r = new j();
            this.s = o.f6340a;
            this.t = true;
            this.u = true;
            this.v = true;
            this.w = 10000;
            this.x = 10000;
            this.y = 10000;
        }

        a(w wVar) {
            this.f6398e = new ArrayList();
            this.f6399f = new ArrayList();
            this.f6394a = wVar.f6388a;
            this.f6395b = wVar.f6389b;
            this.f6396c = wVar.f6390c;
            this.f6397d = wVar.f6391d;
            this.f6398e.addAll(wVar.f6392e);
            this.f6399f.addAll(wVar.f6393f);
            this.g = wVar.g;
            this.h = wVar.h;
            this.j = wVar.j;
            this.i = wVar.i;
            this.k = wVar.k;
            this.l = wVar.l;
            this.m = wVar.m;
            this.n = wVar.n;
            this.o = wVar.o;
            this.p = wVar.p;
            this.q = wVar.q;
            this.r = wVar.r;
            this.s = wVar.s;
            this.t = wVar.t;
            this.u = wVar.u;
            this.v = wVar.v;
            this.w = wVar.w;
            this.x = wVar.x;
            this.y = wVar.y;
        }

        public a a(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.w = (int) millis;
            return this;
        }

        public a a(c cVar) {
            this.i = cVar;
            this.j = null;
            return this;
        }

        public a a(t tVar) {
            this.f6399f.add(tVar);
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.l = sSLSocketFactory;
            this.m = null;
            return this;
        }

        public w a() {
            return new w(this);
        }

        public a b(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.x = (int) millis;
            return this;
        }
    }

    static {
        d.a.d.f6187b = new d.a.d() { // from class: d.w.1
            @Override // d.a.d
            public d.a.c.b a(j jVar, d.a aVar, d.a.b.r rVar) {
                return jVar.a(aVar, rVar);
            }

            @Override // d.a.d
            public d.a.e a(w wVar) {
                return wVar.g();
            }

            @Override // d.a.d
            public d.a.i a(j jVar) {
                return jVar.f6312a;
            }

            @Override // d.a.d
            public void a(k kVar, SSLSocket sSLSocket, boolean z2) {
                kVar.a(sSLSocket, z2);
            }

            @Override // d.a.d
            public void a(r.a aVar, String str) {
                aVar.a(str);
            }

            @Override // d.a.d
            public boolean a(j jVar, d.a.c.b bVar) {
                return jVar.b(bVar);
            }

            @Override // d.a.d
            public void b(j jVar, d.a.c.b bVar) {
                jVar.a(bVar);
            }
        };
    }

    public w() {
        this(new a());
    }

    private w(a aVar) {
        this.f6388a = aVar.f6394a;
        this.f6389b = aVar.f6395b;
        this.f6390c = aVar.f6396c;
        this.f6391d = aVar.f6397d;
        this.f6392e = d.a.j.a(aVar.f6398e);
        this.f6393f = d.a.j.a(aVar.f6399f);
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        Iterator<k> it = this.f6391d.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 = z2 || it.next().a();
        }
        if (aVar.l == null && z2) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                this.l = sSLContext.getSocketFactory();
            } catch (GeneralSecurityException e2) {
                throw new AssertionError();
            }
        } else {
            this.l = aVar.l;
        }
        if (this.l == null || aVar.m != null) {
            this.m = aVar.m;
            this.o = aVar.o;
        } else {
            X509TrustManager x509TrustManagerA = d.a.h.a().a(this.l);
            if (x509TrustManagerA == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + d.a.h.a() + ", sslSocketFactory is " + this.l.getClass());
            }
            this.m = d.a.h.a().a(x509TrustManagerA);
            this.o = aVar.o.a().a(this.m).a();
        }
        this.n = aVar.n;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = aVar.y;
    }

    public int a() {
        return this.w;
    }

    @Override // d.e.a
    public e a(z zVar) {
        return new y(this, zVar);
    }

    public int b() {
        return this.x;
    }

    public int c() {
        return this.y;
    }

    public Proxy d() {
        return this.f6389b;
    }

    public ProxySelector e() {
        return this.g;
    }

    public m f() {
        return this.h;
    }

    d.a.e g() {
        return this.i != null ? this.i.f6257a : this.j;
    }

    public o h() {
        return this.s;
    }

    public SocketFactory i() {
        return this.k;
    }

    public SSLSocketFactory j() {
        return this.l;
    }

    public HostnameVerifier k() {
        return this.n;
    }

    public g l() {
        return this.o;
    }

    public b m() {
        return this.q;
    }

    public b n() {
        return this.p;
    }

    public j o() {
        return this.r;
    }

    public boolean p() {
        return this.t;
    }

    public boolean q() {
        return this.u;
    }

    public boolean r() {
        return this.v;
    }

    public n s() {
        return this.f6388a;
    }

    public List<x> t() {
        return this.f6390c;
    }

    public List<k> u() {
        return this.f6391d;
    }

    public List<t> v() {
        return this.f6392e;
    }

    public List<t> w() {
        return this.f6393f;
    }

    public a x() {
        return new a(this);
    }
}
