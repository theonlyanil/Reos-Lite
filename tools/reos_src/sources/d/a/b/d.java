package d.a.b;

import d.ab;
import d.ac;
import d.z;
import e.s;
import e.t;
import e.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f6105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.e f6106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.d f6107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f6108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6109e = 0;

    private abstract class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final e.j f6110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f6111b;

        private a() {
            this.f6110a = new e.j(d.this.f6106b.a());
        }

        @Override // e.t
        public u a() {
            return this.f6110a;
        }

        protected final void a(boolean z) throws IOException {
            if (d.this.f6109e == 6) {
                return;
            }
            if (d.this.f6109e != 5) {
                throw new IllegalStateException("state: " + d.this.f6109e);
            }
            d.this.a(this.f6110a);
            d.this.f6109e = 6;
            if (d.this.f6105a != null) {
                d.this.f6105a.a(!z, d.this);
            }
        }
    }

    private final class b implements s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e.j f6114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6115c;

        private b() {
            this.f6114b = new e.j(d.this.f6107c.a());
        }

        @Override // e.s
        public u a() {
            return this.f6114b;
        }

        @Override // e.s
        public void a_(e.c cVar, long j) throws IOException {
            if (this.f6115c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            d.this.f6107c.j(j);
            d.this.f6107c.b("\r\n");
            d.this.f6107c.a_(cVar, j);
            d.this.f6107c.b("\r\n");
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (!this.f6115c) {
                this.f6115c = true;
                d.this.f6107c.b("0\r\n\r\n");
                d.this.a(this.f6114b);
                d.this.f6109e = 3;
            }
        }

        @Override // e.s, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (!this.f6115c) {
                d.this.f6107c.flush();
            }
        }
    }

    private class c extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f6117e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f6118f;
        private final g g;

        c(g gVar) throws IOException {
            super();
            this.f6117e = -1L;
            this.f6118f = true;
            this.g = gVar;
        }

        private void b() throws IOException {
            if (this.f6117e != -1) {
                d.this.f6106b.s();
            }
            try {
                this.f6117e = d.this.f6106b.p();
                String strTrim = d.this.f6106b.s().trim();
                if (this.f6117e < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f6117e + strTrim + "\"");
                }
                if (this.f6117e == 0) {
                    this.f6118f = false;
                    this.g.a(d.this.e());
                    a(true);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // e.t
        public long a(e.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f6111b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f6118f) {
                return -1L;
            }
            if (this.f6117e == 0 || this.f6117e == -1) {
                b();
                if (!this.f6118f) {
                    return -1L;
                }
            }
            long jA = d.this.f6106b.a(cVar, Math.min(j, this.f6117e));
            if (jA == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.f6117e -= jA;
            return jA;
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f6111b) {
                return;
            }
            if (this.f6118f && !d.a.j.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.f6111b = true;
        }
    }

    /* JADX INFO: renamed from: d.a.b.d$d, reason: collision with other inner class name */
    private final class C0206d implements s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e.j f6120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f6122d;

        private C0206d(long j) {
            this.f6120b = new e.j(d.this.f6107c.a());
            this.f6122d = j;
        }

        @Override // e.s
        public u a() {
            return this.f6120b;
        }

        @Override // e.s
        public void a_(e.c cVar, long j) throws IOException {
            if (this.f6121c) {
                throw new IllegalStateException("closed");
            }
            d.a.j.a(cVar.b(), 0L, j);
            if (j > this.f6122d) {
                throw new ProtocolException("expected " + this.f6122d + " bytes but received " + j);
            }
            d.this.f6107c.a_(cVar, j);
            this.f6122d -= j;
        }

        @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f6121c) {
                return;
            }
            this.f6121c = true;
            if (this.f6122d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            d.this.a(this.f6120b);
            d.this.f6109e = 3;
        }

        @Override // e.s, java.io.Flushable
        public void flush() throws IOException {
            if (this.f6121c) {
                return;
            }
            d.this.f6107c.flush();
        }
    }

    private class e extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f6124e;

        public e(long j) throws IOException {
            super();
            this.f6124e = j;
            if (this.f6124e == 0) {
                a(true);
            }
        }

        @Override // e.t
        public long a(e.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f6111b) {
                throw new IllegalStateException("closed");
            }
            if (this.f6124e == 0) {
                return -1L;
            }
            long jA = d.this.f6106b.a(cVar, Math.min(this.f6124e, j));
            if (jA == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.f6124e -= jA;
            if (this.f6124e == 0) {
                a(true);
            }
            return jA;
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f6111b) {
                return;
            }
            if (this.f6124e != 0 && !d.a.j.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.f6111b = true;
        }
    }

    private class f extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f6126e;

        private f() {
            super();
        }

        @Override // e.t
        public long a(e.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f6111b) {
                throw new IllegalStateException("closed");
            }
            if (this.f6126e) {
                return -1L;
            }
            long jA = d.this.f6106b.a(cVar, j);
            if (jA != -1) {
                return jA;
            }
            this.f6126e = true;
            a(true);
            return -1L;
        }

        @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f6111b) {
                return;
            }
            if (!this.f6126e) {
                a(false);
            }
            this.f6111b = true;
        }
    }

    public d(r rVar, e.e eVar, e.d dVar) {
        this.f6105a = rVar;
        this.f6106b = eVar;
        this.f6107c = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.j jVar) {
        u uVarA = jVar.a();
        jVar.a(u.f6490b);
        uVarA.f();
        uVarA.i_();
    }

    private t b(ab abVar) throws IOException {
        if (!g.a(abVar)) {
            return b(0L);
        }
        if ("chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) {
            return b(this.f6108d);
        }
        long jA = j.a(abVar);
        return jA != -1 ? b(jA) : g();
    }

    @Override // d.a.b.i
    public ac a(ab abVar) throws IOException {
        return new k(abVar.g(), e.n.a(b(abVar)));
    }

    public s a(long j) {
        if (this.f6109e != 1) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        this.f6109e = 2;
        return new C0206d(j);
    }

    @Override // d.a.b.i
    public s a(z zVar, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(zVar.a("Transfer-Encoding"))) {
            return f();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // d.a.b.i
    public void a() {
        d.a.c.b bVarA = this.f6105a.a();
        if (bVarA != null) {
            bVarA.b();
        }
    }

    @Override // d.a.b.i
    public void a(g gVar) {
        this.f6108d = gVar;
    }

    @Override // d.a.b.i
    public void a(n nVar) throws IOException {
        if (this.f6109e != 1) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        this.f6109e = 3;
        nVar.a(this.f6107c);
    }

    public void a(d.r rVar, String str) throws IOException {
        if (this.f6109e != 0) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        this.f6107c.b(str).b("\r\n");
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            this.f6107c.b(rVar.a(i)).b(": ").b(rVar.b(i)).b("\r\n");
        }
        this.f6107c.b("\r\n");
        this.f6109e = 1;
    }

    @Override // d.a.b.i
    public void a(z zVar) throws IOException {
        this.f6108d.b();
        a(zVar.c(), m.a(zVar, this.f6108d.d().a().b().type()));
    }

    @Override // d.a.b.i
    public ab.a b() throws IOException {
        return d();
    }

    public t b(long j) throws IOException {
        if (this.f6109e != 4) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        this.f6109e = 5;
        return new e(j);
    }

    public t b(g gVar) throws IOException {
        if (this.f6109e != 4) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        this.f6109e = 5;
        return new c(gVar);
    }

    @Override // d.a.b.i
    public void c() throws IOException {
        this.f6107c.flush();
    }

    public ab.a d() throws IOException {
        q qVarA;
        ab.a aVarA;
        if (this.f6109e != 1 && this.f6109e != 3) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        do {
            try {
                qVarA = q.a(this.f6106b.s());
                aVarA = new ab.a().a(qVarA.f6170a).a(qVarA.f6171b).a(qVarA.f6172c).a(e());
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f6105a);
                iOException.initCause(e2);
                throw iOException;
            }
        } while (qVarA.f6171b == 100);
        this.f6109e = 4;
        return aVarA;
    }

    public d.r e() throws IOException {
        d.r.a aVar = new d.r.a();
        while (true) {
            String strS = this.f6106b.s();
            if (strS.length() == 0) {
                return aVar.a();
            }
            d.a.d.f6187b.a(aVar, strS);
        }
    }

    public s f() {
        if (this.f6109e != 1) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        this.f6109e = 2;
        return new b();
    }

    public t g() throws IOException {
        if (this.f6109e != 4) {
            throw new IllegalStateException("state: " + this.f6109e);
        }
        if (this.f6105a == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f6109e = 5;
        this.f6105a.c();
        return new f();
    }
}
