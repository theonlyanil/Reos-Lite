package d.a.a;

import d.x;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable {
    static final /* synthetic */ boolean k;
    private static final ExecutorService l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final x f5937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f5938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f5939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f5940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    n f5941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final n f5942f;
    final p g;
    final Socket h;
    final d.a.a.c i;
    final c j;
    private final b m;
    private final Map<Integer, e> n;
    private final String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private final ExecutorService t;
    private Map<Integer, l> u;
    private final m v;
    private int w;
    private boolean x;
    private final Set<Integer> y;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Socket f5969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e.e f5971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private e.d f5972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b f5973e = b.f5975a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private x f5974f = x.SPDY_3;
        private m g = m.f6057a;
        private boolean h;

        public a(boolean z) throws IOException {
            this.h = z;
        }

        public a a(b bVar) {
            this.f5973e = bVar;
            return this;
        }

        public a a(x xVar) {
            this.f5974f = xVar;
            return this;
        }

        public a a(Socket socket, String str, e.e eVar, e.d dVar) {
            this.f5969a = socket;
            this.f5970b = str;
            this.f5971c = eVar;
            this.f5972d = dVar;
            return this;
        }

        public d a() throws IOException {
            return new d(this);
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5975a = new b() { // from class: d.a.a.d.b.1
            @Override // d.a.a.d.b
            public void a(e eVar) throws IOException {
                eVar.a(d.a.a.a.REFUSED_STREAM);
            }
        };

        public void a(d dVar) {
        }

        public abstract void a(e eVar) throws IOException;
    }

    class c extends d.a.f implements d.a.a.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d.a.a.b f5976a;

        private c(d.a.a.b bVar) {
            super("OkHttp %s", d.this.o);
            this.f5976a = bVar;
        }

        private void a(final n nVar) {
            d.l.execute(new d.a.f("OkHttp %s ACK Settings", new Object[]{d.this.o}) { // from class: d.a.a.d.c.3
                @Override // d.a.f
                public void b() {
                    try {
                        d.this.i.a(nVar);
                    } catch (IOException e2) {
                    }
                }
            });
        }

        @Override // d.a.a.b.a
        public void a() {
        }

        @Override // d.a.a.b.a
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // d.a.a.b.a
        public void a(int i, int i2, List<f> list) {
            d.this.a(i2, list);
        }

        @Override // d.a.a.b.a
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (d.this) {
                    d.this.f5940d += j;
                    d.this.notifyAll();
                }
                return;
            }
            e eVarA = d.this.a(i);
            if (eVarA != null) {
                synchronized (eVarA) {
                    eVarA.a(j);
                }
            }
        }

        @Override // d.a.a.b.a
        public void a(int i, d.a.a.a aVar) {
            if (d.this.d(i)) {
                d.this.c(i, aVar);
                return;
            }
            e eVarB = d.this.b(i);
            if (eVarB != null) {
                eVarB.c(aVar);
            }
        }

        @Override // d.a.a.b.a
        public void a(int i, d.a.a.a aVar, e.f fVar) {
            e[] eVarArr;
            if (fVar.f() > 0) {
            }
            synchronized (d.this) {
                eVarArr = (e[]) d.this.n.values().toArray(new e[d.this.n.size()]);
                d.this.r = true;
            }
            for (e eVar : eVarArr) {
                if (eVar.a() > i && eVar.c()) {
                    eVar.c(d.a.a.a.REFUSED_STREAM);
                    d.this.b(eVar.a());
                }
            }
        }

        @Override // d.a.a.b.a
        public void a(boolean z, int i, int i2) {
            if (!z) {
                d.this.a(true, i, i2, (l) null);
                return;
            }
            l lVarC = d.this.c(i);
            if (lVarC != null) {
                lVarC.b();
            }
        }

        @Override // d.a.a.b.a
        public void a(boolean z, int i, e.e eVar, int i2) throws IOException {
            if (d.this.d(i)) {
                d.this.a(i, eVar, i2, z);
                return;
            }
            e eVarA = d.this.a(i);
            if (eVarA == null) {
                d.this.a(i, d.a.a.a.INVALID_STREAM);
                eVar.g(i2);
            } else {
                eVarA.a(eVar, i2);
                if (z) {
                    eVarA.i();
                }
            }
        }

        @Override // d.a.a.b.a
        public void a(boolean z, n nVar) {
            e[] eVarArr;
            long j;
            synchronized (d.this) {
                int iF = d.this.f5942f.f(65536);
                if (z) {
                    d.this.f5942f.a();
                }
                d.this.f5942f.a(nVar);
                if (d.this.a() == x.HTTP_2) {
                    a(nVar);
                }
                int iF2 = d.this.f5942f.f(65536);
                if (iF2 == -1 || iF2 == iF) {
                    eVarArr = null;
                    j = 0;
                } else {
                    long j2 = iF2 - iF;
                    if (!d.this.x) {
                        d.this.a(j2);
                        d.this.x = true;
                    }
                    if (d.this.n.isEmpty()) {
                        j = j2;
                        eVarArr = null;
                    } else {
                        j = j2;
                        eVarArr = (e[]) d.this.n.values().toArray(new e[d.this.n.size()]);
                    }
                }
                d.l.execute(new d.a.f("OkHttp %s settings", d.this.o) { // from class: d.a.a.d.c.2
                    @Override // d.a.f
                    public void b() {
                        d.this.m.a(d.this);
                    }
                });
            }
            if (eVarArr == null || j == 0) {
                return;
            }
            for (e eVar : eVarArr) {
                synchronized (eVar) {
                    eVar.a(j);
                }
            }
        }

        @Override // d.a.a.b.a
        public void a(boolean z, boolean z2, int i, int i2, List<f> list, g gVar) {
            if (d.this.d(i)) {
                d.this.a(i, list, z2);
                return;
            }
            synchronized (d.this) {
                if (!d.this.r) {
                    e eVarA = d.this.a(i);
                    if (eVarA == null) {
                        if (gVar.a()) {
                            d.this.a(i, d.a.a.a.INVALID_STREAM);
                        } else if (i > d.this.p) {
                            if (i % 2 != d.this.q % 2) {
                                final e eVar = new e(i, d.this, z, z2, list);
                                d.this.p = i;
                                d.this.n.put(Integer.valueOf(i), eVar);
                                d.l.execute(new d.a.f("OkHttp %s stream %d", new Object[]{d.this.o, Integer.valueOf(i)}) { // from class: d.a.a.d.c.1
                                    @Override // d.a.f
                                    public void b() {
                                        try {
                                            d.this.m.a(eVar);
                                        } catch (IOException e2) {
                                            d.a.d.f6186a.log(Level.INFO, "FramedConnection.Listener failure for " + d.this.o, (Throwable) e2);
                                            try {
                                                eVar.a(d.a.a.a.PROTOCOL_ERROR);
                                            } catch (IOException e3) {
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    } else if (gVar.b()) {
                        eVarA.b(d.a.a.a.PROTOCOL_ERROR);
                        d.this.b(i);
                    } else {
                        eVarA.a(list, gVar);
                        if (z2) {
                            eVarA.i();
                        }
                    }
                }
            }
        }

        @Override // d.a.f
        protected void b() throws Throwable {
            d.a.a.a aVar;
            Throwable th;
            d.a.a.a aVar2 = d.a.a.a.INTERNAL_ERROR;
            d.a.a.a aVar3 = d.a.a.a.INTERNAL_ERROR;
            try {
                try {
                    if (!d.this.f5938b) {
                        this.f5976a.a();
                    }
                    while (this.f5976a.a(this)) {
                    }
                    aVar2 = d.a.a.a.NO_ERROR;
                    try {
                        d.this.a(aVar2, d.a.a.a.CANCEL);
                    } catch (IOException e2) {
                    }
                    d.a.j.a(this.f5976a);
                } catch (IOException e3) {
                    aVar = d.a.a.a.PROTOCOL_ERROR;
                    try {
                        try {
                            d.this.a(aVar, d.a.a.a.PROTOCOL_ERROR);
                        } catch (IOException e4) {
                        }
                        d.a.j.a(this.f5976a);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            d.this.a(aVar, aVar3);
                        } catch (IOException e5) {
                        }
                        d.a.j.a(this.f5976a);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                aVar = aVar2;
                th = th3;
                d.this.a(aVar, aVar3);
                d.a.j.a(this.f5976a);
                throw th;
            }
        }
    }

    static {
        k = !d.class.desiredAssertionStatus();
        l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.a.j.a("OkHttp FramedConnection", true));
    }

    private d(a aVar) throws IOException {
        this.n = new HashMap();
        this.s = System.nanoTime();
        this.f5939c = 0L;
        this.f5941e = new n();
        this.f5942f = new n();
        this.x = false;
        this.y = new LinkedHashSet();
        this.f5937a = aVar.f5974f;
        this.v = aVar.g;
        this.f5938b = aVar.h;
        this.m = aVar.f5973e;
        this.q = aVar.h ? 1 : 2;
        if (aVar.h && this.f5937a == x.HTTP_2) {
            this.q += 2;
        }
        this.w = aVar.h ? 1 : 2;
        if (aVar.h) {
            this.f5941e.a(7, 0, 16777216);
        }
        this.o = aVar.f5970b;
        if (this.f5937a == x.HTTP_2) {
            this.g = new i();
            this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d.a.j.a(String.format("OkHttp %s Push Observer", this.o), true));
            this.f5942f.a(7, 0, 65535);
            this.f5942f.a(5, 0, 16384);
        } else {
            if (this.f5937a != x.SPDY_3) {
                throw new AssertionError(this.f5937a);
            }
            this.g = new o();
            this.t = null;
        }
        this.f5940d = this.f5942f.f(65536);
        this.h = aVar.f5969a;
        this.i = this.g.a(aVar.f5972d, this.f5938b);
        this.j = new c(this.g.a(aVar.f5971c, this.f5938b));
        new Thread(this.j).start();
    }

    private e a(int i, List<f> list, boolean z, boolean z2) throws IOException {
        int i2;
        e eVar;
        boolean z3 = !z;
        boolean z4 = z2 ? false : true;
        synchronized (this.i) {
            synchronized (this) {
                if (this.r) {
                    throw new IOException("shutdown");
                }
                i2 = this.q;
                this.q += 2;
                eVar = new e(i2, this, z3, z4, list);
                if (eVar.b()) {
                    this.n.put(Integer.valueOf(i2), eVar);
                    a(false);
                }
            }
            if (i == 0) {
                this.i.a(z3, z4, i2, i, list);
            } else {
                if (this.f5938b) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.i.a(i, i2, list);
            }
        }
        if (!z) {
            this.i.b();
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, e.e eVar, final int i2, final boolean z) throws IOException {
        final e.c cVar = new e.c();
        eVar.a(i2);
        eVar.a(cVar, i2);
        if (cVar.b() != i2) {
            throw new IOException(cVar.b() + " != " + i2);
        }
        this.t.execute(new d.a.f("OkHttp %s Push Data[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: d.a.a.d.6
            @Override // d.a.f
            public void b() {
                try {
                    boolean zA = d.this.v.a(i, cVar, i2, z);
                    if (zA) {
                        d.this.i.a(i, d.a.a.a.CANCEL);
                    }
                    if (zA || z) {
                        synchronized (d.this) {
                            try {
                                d.this.y.remove(Integer.valueOf(i));
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (IOException e2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final List<f> list) {
        synchronized (this) {
            if (this.y.contains(Integer.valueOf(i))) {
                a(i, d.a.a.a.PROTOCOL_ERROR);
            } else {
                this.y.add(Integer.valueOf(i));
                this.t.execute(new d.a.f("OkHttp %s Push Request[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: d.a.a.d.4
                    @Override // d.a.f
                    public void b() {
                        if (d.this.v.a(i, list)) {
                            try {
                                d.this.i.a(i, d.a.a.a.CANCEL);
                                synchronized (d.this) {
                                    d.this.y.remove(Integer.valueOf(i));
                                }
                            } catch (IOException e2) {
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final List<f> list, final boolean z) {
        this.t.execute(new d.a.f("OkHttp %s Push Headers[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: d.a.a.d.5
            @Override // d.a.f
            public void b() {
                boolean zA = d.this.v.a(i, list, z);
                if (zA) {
                    try {
                        d.this.i.a(i, d.a.a.a.CANCEL);
                    } catch (IOException e2) {
                        return;
                    }
                }
                if (zA || z) {
                    synchronized (d.this) {
                        d.this.y.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a.a.a aVar, d.a.a.a aVar2) throws IOException {
        IOException iOException;
        e[] eVarArr;
        l[] lVarArr;
        if (!k && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        try {
            a(aVar);
            iOException = null;
        } catch (IOException e2) {
            iOException = e2;
        }
        synchronized (this) {
            if (this.n.isEmpty()) {
                eVarArr = null;
            } else {
                e[] eVarArr2 = (e[]) this.n.values().toArray(new e[this.n.size()]);
                this.n.clear();
                a(false);
                eVarArr = eVarArr2;
            }
            if (this.u != null) {
                l[] lVarArr2 = (l[]) this.u.values().toArray(new l[this.u.size()]);
                this.u = null;
                lVarArr = lVarArr2;
            } else {
                lVarArr = null;
            }
        }
        if (eVarArr != null) {
            IOException iOException2 = iOException;
            for (e eVar : eVarArr) {
                try {
                    eVar.a(aVar2);
                } catch (IOException e3) {
                    if (iOException2 != null) {
                        iOException2 = e3;
                    }
                }
            }
            iOException = iOException2;
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.c();
            }
        }
        try {
            this.i.close();
            e = iOException;
        } catch (IOException e4) {
            e = e4;
            if (iOException != null) {
                e = iOException;
            }
        }
        try {
            this.h.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    private synchronized void a(boolean z) {
        this.s = z ? System.nanoTime() : Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final int i, final int i2, final l lVar) {
        l.execute(new d.a.f("OkHttp %s ping %08x%08x", new Object[]{this.o, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: d.a.a.d.3
            @Override // d.a.f
            public void b() {
                try {
                    d.this.b(z, i, i2, lVar);
                } catch (IOException e2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, int i2, l lVar) throws IOException {
        synchronized (this.i) {
            if (lVar != null) {
                lVar.a();
                this.i.a(z, i, i2);
            } else {
                this.i.a(z, i, i2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized l c(int i) {
        return this.u != null ? this.u.remove(Integer.valueOf(i)) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i, final d.a.a.a aVar) {
        this.t.execute(new d.a.f("OkHttp %s Push Reset[%s]", new Object[]{this.o, Integer.valueOf(i)}) { // from class: d.a.a.d.7
            @Override // d.a.f
            public void b() {
                d.this.v.a(i, aVar);
                synchronized (d.this) {
                    d.this.y.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
        return this.f5937a == x.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    synchronized e a(int i) {
        return this.n.get(Integer.valueOf(i));
    }

    public e a(List<f> list, boolean z, boolean z2) throws IOException {
        return a(0, list, z, z2);
    }

    public x a() {
        return this.f5937a;
    }

    void a(final int i, final long j) {
        l.execute(new d.a.f("OkHttp Window Update %s stream %d", new Object[]{this.o, Integer.valueOf(i)}) { // from class: d.a.a.d.2
            @Override // d.a.f
            public void b() {
                try {
                    d.this.i.a(i, j);
                } catch (IOException e2) {
                }
            }
        });
    }

    void a(final int i, final d.a.a.a aVar) {
        l.submit(new d.a.f("OkHttp %s stream %d", new Object[]{this.o, Integer.valueOf(i)}) { // from class: d.a.a.d.1
            @Override // d.a.f
            public void b() {
                try {
                    d.this.b(i, aVar);
                } catch (IOException e2) {
                }
            }
        });
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0059 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r11, boolean r12, e.c r13, long r14) throws java.io.IOException {
        /*
            r10 = this;
            r1 = 0
            r8 = 0
            int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r0 != 0) goto L33
            d.a.a.c r0 = r10.i
            r0.a(r12, r11, r13, r1)
        Lc:
            return
        Ld:
            long r2 = r10.f5940d     // Catch: java.lang.Throwable -> L59
            long r2 = java.lang.Math.min(r14, r2)     // Catch: java.lang.Throwable -> L59
            int r0 = (int) r2     // Catch: java.lang.Throwable -> L59
            d.a.a.c r2 = r10.i     // Catch: java.lang.Throwable -> L59
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L59
            int r2 = java.lang.Math.min(r0, r2)     // Catch: java.lang.Throwable -> L59
            long r4 = r10.f5940d     // Catch: java.lang.Throwable -> L59
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L59
            long r4 = r4 - r6
            r10.f5940d = r4     // Catch: java.lang.Throwable -> L59
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L59
            long r4 = (long) r2
            long r14 = r14 - r4
            d.a.a.c r3 = r10.i
            if (r12 == 0) goto L60
            int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r0 != 0) goto L60
            r0 = 1
        L30:
            r3.a(r0, r11, r13, r2)
        L33:
            int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r0 <= 0) goto Lc
            monitor-enter(r10)
        L38:
            long r2 = r10.f5940d     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 > 0) goto Ld
            java.util.Map<java.lang.Integer, d.a.a.e> r0 = r10.n     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
            boolean r0 = r0.containsKey(r2)     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
            if (r0 != 0) goto L5c
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
            java.lang.String r1 = "stream closed"
            r0.<init>(r1)     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
            throw r0     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
        L52:
            r0 = move-exception
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L59
            r0.<init>()     // Catch: java.lang.Throwable -> L59
            throw r0     // Catch: java.lang.Throwable -> L59
        L59:
            r0 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L59
            throw r0
        L5c:
            r10.wait()     // Catch: java.lang.InterruptedException -> L52 java.lang.Throwable -> L59
            goto L38
        L60:
            r0 = r1
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.d.a(int, boolean, e.c, long):void");
    }

    void a(long j) {
        this.f5940d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void a(d.a.a.a aVar) throws IOException {
        synchronized (this.i) {
            synchronized (this) {
                if (this.r) {
                    return;
                }
                this.r = true;
                this.i.a(this.p, aVar, d.a.j.f6218a);
            }
        }
    }

    public synchronized int b() {
        return this.f5942f.d(Integer.MAX_VALUE);
    }

    synchronized e b(int i) {
        e eVarRemove;
        eVarRemove = this.n.remove(Integer.valueOf(i));
        if (eVarRemove != null && this.n.isEmpty()) {
            a(true);
        }
        notifyAll();
        return eVarRemove;
    }

    void b(int i, d.a.a.a aVar) throws IOException {
        this.i.a(i, aVar);
    }

    public void c() throws IOException {
        this.i.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(d.a.a.a.NO_ERROR, d.a.a.a.CANCEL);
    }

    public void d() throws IOException {
        this.i.a();
        this.i.b(this.f5941e);
        int iF = this.f5941e.f(65536);
        if (iF != 65536) {
            this.i.a(0, iF - 65536);
        }
    }
}
