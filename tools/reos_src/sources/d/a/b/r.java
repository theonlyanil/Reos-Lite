package d.a.b;

import d.ad;
import e.s;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.a f6173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ad f6174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.j f6175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p f6176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.a.c.b f6177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6178f;
    private boolean g;
    private i h;

    public r(d.j jVar, d.a aVar) {
        this.f6175c = jVar;
        this.f6173a = aVar;
        this.f6176d = new p(aVar, e());
    }

    private d.a.c.b a(int i, int i2, int i3, boolean z) throws o, IOException {
        ad adVar;
        synchronized (this.f6175c) {
            if (this.f6178f) {
                throw new IllegalStateException("released");
            }
            if (this.h != null) {
                throw new IllegalStateException("stream != null");
            }
            if (this.g) {
                throw new IOException("Canceled");
            }
            d.a.c.b bVarA = this.f6177e;
            if (bVarA == null || bVarA.i) {
                bVarA = d.a.d.f6187b.a(this.f6175c, this.f6173a, this);
                if (bVarA != null) {
                    this.f6177e = bVarA;
                } else {
                    ad adVar2 = this.f6174b;
                    if (adVar2 == null) {
                        ad adVarB = this.f6176d.b();
                        synchronized (this.f6175c) {
                            this.f6174b = adVarB;
                        }
                        adVar = adVarB;
                    } else {
                        adVar = adVar2;
                    }
                    bVarA = new d.a.c.b(adVar);
                    a(bVarA);
                    synchronized (this.f6175c) {
                        d.a.d.f6187b.b(this.f6175c, bVarA);
                        this.f6177e = bVarA;
                        if (this.g) {
                            throw new IOException("Canceled");
                        }
                    }
                    bVarA.a(i, i2, i3, this.f6173a.f(), z);
                    e().b(bVarA.a());
                }
            }
            return bVarA;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0012 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0014 A[Catch: all -> 0x005a, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000b, B:9:0x000e, B:12:0x0014, B:13:0x0019, B:15:0x001d, B:17:0x0021, B:19:0x0027, B:21:0x0036, B:23:0x004a, B:24:0x004c, B:25:0x004f), top: B:32:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[Catch: all -> 0x005a, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000b, B:9:0x000e, B:12:0x0014, B:13:0x0019, B:15:0x001d, B:17:0x0021, B:19:0x0027, B:21:0x0036, B:23:0x004a, B:24:0x004c, B:25:0x004f), top: B:32:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x004a A[Catch: all -> 0x005a, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000b, B:9:0x000e, B:12:0x0014, B:13:0x0019, B:15:0x001d, B:17:0x0021, B:19:0x0027, B:21:0x0036, B:23:0x004a, B:24:0x004c, B:25:0x004f), top: B:32:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x000b A[Catch: all -> 0x005a, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000b, B:9:0x000e, B:12:0x0014, B:13:0x0019, B:15:0x001d, B:17:0x0021, B:19:0x0027, B:21:0x0036, B:23:0x004a, B:24:0x004c, B:25:0x004f), top: B:32:0x0007 }] */
    private void a(boolean z, boolean z2, boolean z3) {
        d.a.c.b bVar = null;
        synchronized (this.f6175c) {
            if (z3) {
                this.h = null;
                if (z2) {
                    this.f6178f = true;
                }
                if (this.f6177e != null) {
                    if (z) {
                        this.f6177e.i = true;
                    }
                    if (this.h == null && (this.f6178f || this.f6177e.i)) {
                        b(this.f6177e);
                        if (this.f6177e.h.isEmpty()) {
                            this.f6177e.j = System.nanoTime();
                            if (d.a.d.f6187b.a(this.f6175c, this.f6177e)) {
                                bVar = this.f6177e;
                            }
                        }
                        this.f6177e = null;
                    }
                }
            } else {
                if (z2) {
                    this.f6178f = true;
                }
                if (this.f6177e != null) {
                    if (z) {
                        this.f6177e.i = true;
                    }
                    if (this.h == null) {
                        b(this.f6177e);
                        if (this.f6177e.h.isEmpty()) {
                            this.f6177e.j = System.nanoTime();
                            if (d.a.d.f6187b.a(this.f6175c, this.f6177e)) {
                                bVar = this.f6177e;
                            }
                        }
                        this.f6177e = null;
                    }
                }
            }
            throw th;
        }
        if (bVar != null) {
            d.a.j.a(bVar.c());
        }
    }

    private d.a.c.b b(int i, int i2, int i3, boolean z, boolean z2) throws o, IOException {
        d.a.c.b bVarA;
        while (true) {
            bVarA = a(i, i2, i3, z);
            synchronized (this.f6175c) {
                if (bVarA.f6183d != 0) {
                    if (bVarA.a(z2)) {
                        break;
                    }
                    a(new IOException());
                } else {
                    break;
                }
            }
        }
        return bVarA;
    }

    private void b(d.a.c.b bVar) {
        int size = bVar.h.size();
        for (int i = 0; i < size; i++) {
            if (bVar.h.get(i).get() == this) {
                bVar.h.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private boolean b(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private d.a.i e() {
        return d.a.d.f6187b.a(this.f6175c);
    }

    public i a(int i, int i2, int i3, boolean z, boolean z2) throws o, IOException {
        i dVar;
        try {
            d.a.c.b bVarB = b(i, i2, i3, z, z2);
            if (bVarB.f6182c != null) {
                dVar = new e(this, bVarB.f6182c);
            } else {
                bVarB.c().setSoTimeout(i2);
                bVarB.f6184e.a().a(i2, TimeUnit.MILLISECONDS);
                bVarB.f6185f.a().a(i3, TimeUnit.MILLISECONDS);
                dVar = new d(this, bVarB.f6184e, bVarB.f6185f);
            }
            synchronized (this.f6175c) {
                this.h = dVar;
            }
            return dVar;
        } catch (IOException e2) {
            throw new o(e2);
        }
    }

    public synchronized d.a.c.b a() {
        return this.f6177e;
    }

    public void a(d.a.c.b bVar) {
        bVar.h.add(new WeakReference(this));
    }

    public void a(IOException iOException) {
        synchronized (this.f6175c) {
            if (this.f6177e != null && this.f6177e.f6183d == 0) {
                if (this.f6174b != null && iOException != null) {
                    this.f6176d.a(this.f6174b, iOException);
                }
                this.f6174b = null;
            }
        }
        a(true, false, true);
    }

    public void a(boolean z, i iVar) {
        synchronized (this.f6175c) {
            if (iVar != null) {
                if (iVar == this.h) {
                    if (!z) {
                        this.f6177e.f6183d++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.h + " but was " + iVar);
        }
        a(z, false, true);
    }

    public boolean a(IOException iOException, s sVar) {
        if (this.f6177e != null) {
            a(iOException);
        }
        return (this.f6176d == null || this.f6176d.a()) && b(iOException) && (sVar == null || (sVar instanceof n));
    }

    public void b() {
        a(false, true, false);
    }

    public void c() {
        a(true, false, false);
    }

    public void d() {
        i iVar;
        d.a.c.b bVar;
        synchronized (this.f6175c) {
            this.g = true;
            iVar = this.h;
            bVar = this.f6177e;
        }
        if (iVar != null) {
            iVar.a();
        } else if (bVar != null) {
            bVar.b();
        }
    }

    public String toString() {
        return this.f6173a.toString();
    }
}
