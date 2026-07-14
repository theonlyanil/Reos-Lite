package d;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f6247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Proxy f6248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InetSocketAddress f6249c;

    public ad(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f6247a = aVar;
        this.f6248b = proxy;
        this.f6249c = inetSocketAddress;
    }

    public a a() {
        return this.f6247a;
    }

    public Proxy b() {
        return this.f6248b;
    }

    public InetSocketAddress c() {
        return this.f6249c;
    }

    public boolean d() {
        return this.f6247a.i != null && this.f6248b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.f6247a.equals(adVar.f6247a) && this.f6248b.equals(adVar.f6248b) && this.f6249c.equals(adVar.f6249c);
    }

    public int hashCode() {
        return ((((this.f6247a.hashCode() + 527) * 31) + this.f6248b.hashCode()) * 31) + this.f6249c.hashCode();
    }
}
