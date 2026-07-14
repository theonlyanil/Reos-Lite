package d;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s f5921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o f5922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SocketFactory f5923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final b f5924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<x> f5925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<k> f5926f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final g k;

    public a(String str, int i, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<x> list, List<k> list2, ProxySelector proxySelector) {
        this.f5921a = new s.a().a(sSLSocketFactory != null ? "https" : "http").b(str).a(i).c();
        if (oVar == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.f5922b = oVar;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.f5923c = socketFactory;
        if (bVar == null) {
            throw new IllegalArgumentException("proxyAuthenticator == null");
        }
        this.f5924d = bVar;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.f5925e = d.a.j.a(list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.f5926f = d.a.j.a(list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = gVar;
    }

    public s a() {
        return this.f5921a;
    }

    public o b() {
        return this.f5922b;
    }

    public SocketFactory c() {
        return this.f5923c;
    }

    public b d() {
        return this.f5924d;
    }

    public List<x> e() {
        return this.f5925e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5921a.equals(aVar.f5921a) && this.f5922b.equals(aVar.f5922b) && this.f5924d.equals(aVar.f5924d) && this.f5925e.equals(aVar.f5925e) && this.f5926f.equals(aVar.f5926f) && this.g.equals(aVar.g) && d.a.j.a(this.h, aVar.h) && d.a.j.a(this.i, aVar.i) && d.a.j.a(this.j, aVar.j) && d.a.j.a(this.k, aVar.k);
    }

    public List<k> f() {
        return this.f5926f;
    }

    public ProxySelector g() {
        return this.g;
    }

    public Proxy h() {
        return this.h;
    }

    public int hashCode() {
        return (((this.j != null ? this.j.hashCode() : 0) + (((this.i != null ? this.i.hashCode() : 0) + (((this.h != null ? this.h.hashCode() : 0) + ((((((((((((this.f5921a.hashCode() + 527) * 31) + this.f5922b.hashCode()) * 31) + this.f5924d.hashCode()) * 31) + this.f5925e.hashCode()) * 31) + this.f5926f.hashCode()) * 31) + this.g.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.k != null ? this.k.hashCode() : 0);
    }

    public SSLSocketFactory i() {
        return this.i;
    }

    public HostnameVerifier j() {
        return this.j;
    }

    public g k() {
        return this.k;
    }
}
