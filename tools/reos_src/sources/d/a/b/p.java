package d.a.b;

import d.ad;
import d.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.a f6164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.a.i f6165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Proxy f6166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InetSocketAddress f6167d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6169f;
    private int h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Proxy> f6168e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ad> i = new ArrayList();

    public p(d.a aVar, d.a.i iVar) {
        this.f6164a = aVar;
        this.f6165b = iVar;
        a(aVar.a(), aVar.h());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(s sVar, Proxy proxy) {
        if (proxy != null) {
            this.f6168e = Collections.singletonList(proxy);
        } else {
            this.f6168e = new ArrayList();
            List<Proxy> listSelect = this.f6164a.g().select(sVar.a());
            if (listSelect != null) {
                this.f6168e.addAll(listSelect);
            }
            this.f6168e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f6168e.add(Proxy.NO_PROXY);
        }
        this.f6169f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        int iG;
        String str;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            String strF = this.f6164a.a().f();
            iG = this.f6164a.a().g();
            str = strF;
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            String strA = a(inetSocketAddress);
            iG = inetSocketAddress.getPort();
            str = strA;
        }
        if (iG < 1 || iG > 65535) {
            throw new SocketException("No route to " + str + ":" + iG + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(str, iG));
        } else {
            List<InetAddress> listA = this.f6164a.b().a(str);
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                this.g.add(new InetSocketAddress(listA.get(i), iG));
            }
        }
        this.h = 0;
    }

    private boolean c() {
        return this.f6169f < this.f6168e.size();
    }

    private Proxy d() throws IOException {
        if (!c()) {
            throw new SocketException("No route to " + this.f6164a.a().f() + "; exhausted proxy configurations: " + this.f6168e);
        }
        List<Proxy> list = this.f6168e;
        int i = this.f6169f;
        this.f6169f = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    private boolean e() {
        return this.h < this.g.size();
    }

    private InetSocketAddress f() throws IOException {
        if (!e()) {
            throw new SocketException("No route to " + this.f6164a.a().f() + "; exhausted inet socket addresses: " + this.g);
        }
        List<InetSocketAddress> list = this.g;
        int i = this.h;
        this.h = i + 1;
        return list.get(i);
    }

    private boolean g() {
        return !this.i.isEmpty();
    }

    private ad h() {
        return this.i.remove(0);
    }

    public void a(ad adVar, IOException iOException) {
        if (adVar.b().type() != Proxy.Type.DIRECT && this.f6164a.g() != null) {
            this.f6164a.g().connectFailed(this.f6164a.a().a(), adVar.b().address(), iOException);
        }
        this.f6165b.a(adVar);
    }

    public boolean a() {
        return e() || c() || g();
    }

    public ad b() throws IOException {
        if (!e()) {
            if (!c()) {
                if (g()) {
                    return h();
                }
                throw new NoSuchElementException();
            }
            this.f6166c = d();
        }
        this.f6167d = f();
        ad adVar = new ad(this.f6164a, this.f6166c, this.f6167d);
        if (!this.f6165b.c(adVar)) {
            return adVar;
        }
        this.i.add(adVar);
        return b();
    }
}
