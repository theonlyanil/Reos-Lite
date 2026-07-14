package d.a.a;

import e.s;
import e.t;
import e.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f5983d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f5985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a f5986c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f5988f;
    private final List<f> g;
    private List<f> h;
    private final b i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f5984a = 0;
    private final c j = new c();
    private final c k = new c();
    private d.a.a.a l = null;

    final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f5989a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e.c f5991c = new e.c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5993e;

        static {
            f5989a = !e.class.desiredAssertionStatus();
        }

        a() {
        }

        private void a(boolean z) throws IOException {
            long jMin;
            synchronized (e.this) {
                e.this.k.c();
                while (e.this.f5985b <= 0 && !this.f5993e && !this.f5992d && e.this.l == null) {
                    try {
                        e.this.l();
                    } catch (Throwable th) {
                        e.this.k.b();
                        throw th;
                    }
                }
                e.this.k.b();
                e.this.k();
                jMin = Math.min(e.this.f5985b, this.f5991c.b());
                e.this.f5985b -= jMin;
            }
            e.this.k.c();
            try {
                e.this.f5988f.a(e.this.f5987e, z && jMin == this.f5991c.b(), this.f5991c, jMin);
            } finally {
                e.this.k.b();
            }
        }

        @Override // e.s
        public u a() {
            return e.this.k;
        }

        @Override // e.s
        public void a_(e.c cVar, long j) throws IOException {
            if (!f5989a && Thread.holdsLock(e.this)) {
                throw new AssertionError();
            }
            this.f5991c.a_(cVar, j);
            while (this.f5991c.b() >= 16384) {
                a(false);
            }
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f5989a && Thread.holdsLock(e.this)) {
                throw new AssertionError();
            }
            synchronized (e.this) {
                if (this.f5992d) {
                    return;
                }
                if (!e.this.f5986c.f5993e) {
                    if (this.f5991c.b() > 0) {
                        while (this.f5991c.b() > 0) {
                            a(true);
                        }
                    } else {
                        e.this.f5988f.a(e.this.f5987e, true, (e.c) null, 0L);
                    }
                }
                synchronized (e.this) {
                    this.f5992d = true;
                }
                e.this.f5988f.c();
                e.this.j();
            }
        }

        @Override // e.s, java.io.Flushable
        public void flush() throws IOException {
            if (!f5989a && Thread.holdsLock(e.this)) {
                throw new AssertionError();
            }
            synchronized (e.this) {
                e.this.k();
            }
            while (this.f5991c.b() > 0) {
                a(false);
                e.this.f5988f.c();
            }
        }
    }

    private final class b implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f5994a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e.c f5996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final e.c f5997d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f5998e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5999f;
        private boolean g;

        static {
            f5994a = !e.class.desiredAssertionStatus();
        }

        private b(long j) {
            this.f5996c = new e.c();
            this.f5997d = new e.c();
            this.f5998e = j;
        }

        private void b() throws IOException {
            e.this.j.c();
            while (this.f5997d.b() == 0 && !this.g && !this.f5999f && e.this.l == null) {
                try {
                    e.this.l();
                } catch (Throwable th) {
                    e.this.j.b();
                    throw th;
                }
            }
            e.this.j.b();
        }

        private void c() throws IOException {
            if (this.f5999f) {
                throw new IOException("stream closed");
            }
            if (e.this.l != null) {
                throw new IOException("stream was reset: " + e.this.l);
            }
        }

        @Override // e.t
        public long a(e.c cVar, long j) throws IOException {
            long jA;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (e.this) {
                b();
                c();
                if (this.f5997d.b() == 0) {
                    jA = -1;
                } else {
                    jA = this.f5997d.a(cVar, Math.min(j, this.f5997d.b()));
                    e.this.f5984a += jA;
                    if (e.this.f5984a >= e.this.f5988f.f5941e.f(65536) / 2) {
                        e.this.f5988f.a(e.this.f5987e, e.this.f5984a);
                        e.this.f5984a = 0L;
                    }
                    synchronized (e.this.f5988f) {
                        e.this.f5988f.f5939c += jA;
                        if (e.this.f5988f.f5939c >= e.this.f5988f.f5941e.f(65536) / 2) {
                            e.this.f5988f.a(0, e.this.f5988f.f5939c);
                            e.this.f5988f.f5939c = 0L;
                        }
                    }
                }
            }
            return jA;
        }

        @Override // e.t
        public u a() {
            return e.this.j;
        }

        void a(e.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            if (!f5994a && Thread.holdsLock(e.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (e.this) {
                    z = this.g;
                    z2 = this.f5997d.b() + j > this.f5998e;
                }
                if (z2) {
                    eVar.g(j);
                    e.this.b(d.a.a.a.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.g(j);
                    return;
                }
                long jA = eVar.a(this.f5996c, j);
                if (jA == -1) {
                    throw new EOFException();
                }
                j -= jA;
                synchronized (e.this) {
                    boolean z3 = this.f5997d.b() == 0;
                    this.f5997d.a((t) this.f5996c);
                    if (z3) {
                        e.this.notifyAll();
                    }
                }
            }
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (e.this) {
                this.f5999f = true;
                this.f5997d.u();
                e.this.notifyAll();
            }
            e.this.j();
        }
    }

    class c extends e.a {
        c() {
        }

        @Override // e.a
        protected IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // e.a
        protected void a() {
            e.this.b(d.a.a.a.CANCEL);
        }

        public void b() throws IOException {
            if (f_()) {
                throw a((IOException) null);
            }
        }
    }

    static {
        f5983d = !e.class.desiredAssertionStatus();
    }

    e(int i, d dVar, boolean z, boolean z2, List<f> list) {
        if (dVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f5987e = i;
        this.f5988f = dVar;
        this.f5985b = dVar.f5942f.f(65536);
        this.i = new b(dVar.f5941e.f(65536));
        this.f5986c = new a();
        this.i.g = z2;
        this.f5986c.f5993e = z;
        this.g = list;
    }

    private boolean d(d.a.a.a aVar) {
        if (!f5983d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.l != null) {
                return false;
            }
            if (this.i.g && this.f5986c.f5993e) {
                return false;
            }
            this.l = aVar;
            notifyAll();
            this.f5988f.b(this.f5987e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws IOException {
        boolean z;
        boolean zB;
        if (!f5983d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.i.g && this.i.f5999f && (this.f5986c.f5993e || this.f5986c.f5992d);
            zB = b();
        }
        if (z) {
            a(d.a.a.a.CANCEL);
        } else {
            if (zB) {
                return;
            }
            this.f5988f.b(this.f5987e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws IOException {
        if (this.f5986c.f5992d) {
            throw new IOException("stream closed");
        }
        if (this.f5986c.f5993e) {
            throw new IOException("stream finished");
        }
        if (this.l != null) {
            throw new IOException("stream was reset: " + this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e2) {
            throw new InterruptedIOException();
        }
    }

    public int a() {
        return this.f5987e;
    }

    void a(long j) {
        this.f5985b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void a(d.a.a.a aVar) throws IOException {
        if (d(aVar)) {
            this.f5988f.b(this.f5987e, aVar);
        }
    }

    void a(e.e eVar, int i) throws IOException {
        if (!f5983d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.i.a(eVar, i);
    }

    void a(List<f> list, g gVar) {
        if (!f5983d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        d.a.a.a aVar = null;
        boolean zB = true;
        synchronized (this) {
            if (this.h == null) {
                if (gVar.c()) {
                    aVar = d.a.a.a.PROTOCOL_ERROR;
                } else {
                    this.h = list;
                    zB = b();
                    notifyAll();
                }
            } else if (gVar.d()) {
                aVar = d.a.a.a.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.h);
                arrayList.addAll(list);
                this.h = arrayList;
            }
        }
        if (aVar != null) {
            b(aVar);
        } else {
            if (zB) {
                return;
            }
            this.f5988f.b(this.f5987e);
        }
    }

    public void b(d.a.a.a aVar) {
        if (d(aVar)) {
            this.f5988f.a(this.f5987e, aVar);
        }
    }

    public synchronized boolean b() {
        boolean z = false;
        synchronized (this) {
            if (this.l == null && ((!this.i.g && !this.i.f5999f) || ((!this.f5986c.f5993e && !this.f5986c.f5992d) || this.h == null))) {
                z = true;
            }
        }
        return z;
    }

    synchronized void c(d.a.a.a aVar) {
        if (this.l == null) {
            this.l = aVar;
            notifyAll();
        }
    }

    public boolean c() {
        return this.f5988f.f5938b == ((this.f5987e & 1) == 1);
    }

    public synchronized List<f> d() throws IOException {
        this.j.c();
        while (this.h == null && this.l == null) {
            try {
                l();
            } catch (Throwable th) {
                this.j.b();
                throw th;
            }
        }
        this.j.b();
        if (this.h == null) {
            throw new IOException("stream was reset: " + this.l);
        }
        return this.h;
    }

    public u e() {
        return this.j;
    }

    public u f() {
        return this.k;
    }

    public t g() {
        return this.i;
    }

    public s h() {
        synchronized (this) {
            if (this.h == null && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f5986c;
    }

    void i() {
        boolean zB;
        if (!f5983d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.i.g = true;
            zB = b();
            notifyAll();
        }
        if (zB) {
            return;
        }
        this.f5988f.b(this.f5987e);
    }
}
