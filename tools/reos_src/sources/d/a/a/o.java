package d.a.a;

import e.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes.dex */
public final class o implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f6062a;

    static final class a implements d.a.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.e f6063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final k f6065c;

        a(e.e eVar, boolean z) {
            this.f6063a = eVar;
            this.f6065c = new k(this.f6063a);
            this.f6064b = z;
        }

        private static IOException a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        private void a(d.a.a.b.a aVar, int i, int i2) throws IOException {
            int iL = this.f6063a.l() & Integer.MAX_VALUE;
            int iL2 = this.f6063a.l() & Integer.MAX_VALUE;
            this.f6063a.k();
            aVar.a((i & 2) != 0, (i & 1) != 0, iL, iL2, this.f6065c.a(i2 - 10), g.SPDY_SYN_STREAM);
        }

        private void b(d.a.a.b.a aVar, int i, int i2) throws IOException {
            aVar.a(false, (i & 1) != 0, this.f6063a.l() & Integer.MAX_VALUE, -1, this.f6065c.a(i2 - 4), g.SPDY_REPLY);
        }

        private void c(d.a.a.b.a aVar, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int iL = this.f6063a.l() & Integer.MAX_VALUE;
            int iL2 = this.f6063a.l();
            d.a.a.a aVarA = d.a.a.a.a(iL2);
            if (aVarA == null) {
                throw a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iL2));
            }
            aVar.a(iL, aVarA);
        }

        private void d(d.a.a.b.a aVar, int i, int i2) throws IOException {
            aVar.a(false, false, this.f6063a.l() & Integer.MAX_VALUE, -1, this.f6065c.a(i2 - 4), g.SPDY_HEADERS);
        }

        private void e(d.a.a.b.a aVar, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int iL = this.f6063a.l() & Integer.MAX_VALUE;
            long jL = this.f6063a.l() & Integer.MAX_VALUE;
            if (jL == 0) {
                throw a("windowSizeIncrement was 0", Long.valueOf(jL));
            }
            aVar.a(iL, jL);
        }

        private void f(d.a.a.b.a aVar, int i, int i2) throws IOException {
            if (i2 != 4) {
                throw a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            int iL = this.f6063a.l();
            aVar.a(this.f6064b == ((iL & 1) == 1), iL, 0);
        }

        private void g(d.a.a.b.a aVar, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int iL = this.f6063a.l() & Integer.MAX_VALUE;
            int iL2 = this.f6063a.l();
            d.a.a.a aVarC = d.a.a.a.c(iL2);
            if (aVarC == null) {
                throw a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iL2));
            }
            aVar.a(iL, aVarC, e.f.f6445b);
        }

        private void h(d.a.a.b.a aVar, int i, int i2) throws IOException {
            int iL = this.f6063a.l();
            if (i2 != (iL * 8) + 4) {
                throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(iL));
            }
            n nVar = new n();
            for (int i3 = 0; i3 < iL; i3++) {
                int iL2 = this.f6063a.l();
                nVar.a(iL2 & 16777215, ((-16777216) & iL2) >>> 24, this.f6063a.l());
            }
            aVar.a((i & 1) != 0, nVar);
        }

        @Override // d.a.a.b
        public void a() {
        }

        @Override // d.a.a.b
        public boolean a(d.a.a.b.a aVar) throws IOException {
            try {
                int iL = this.f6063a.l();
                int iL2 = this.f6063a.l();
                int i = ((-16777216) & iL2) >>> 24;
                int i2 = iL2 & 16777215;
                if (!((Integer.MIN_VALUE & iL) != 0)) {
                    aVar.a((i & 1) != 0, Integer.MAX_VALUE & iL, this.f6063a, i2);
                    return true;
                }
                int i3 = (2147418112 & iL) >>> 16;
                int i4 = 65535 & iL;
                if (i3 != 3) {
                    throw new ProtocolException("version != 3: " + i3);
                }
                switch (i4) {
                    case 1:
                        a(aVar, i, i2);
                        return true;
                    case 2:
                        b(aVar, i, i2);
                        return true;
                    case 3:
                        c(aVar, i, i2);
                        return true;
                    case 4:
                        h(aVar, i, i2);
                        return true;
                    case 5:
                    default:
                        this.f6063a.g(i2);
                        return true;
                    case 6:
                        f(aVar, i, i2);
                        return true;
                    case 7:
                        g(aVar, i, i2);
                        return true;
                    case 8:
                        d(aVar, i, i2);
                        return true;
                    case 9:
                        e(aVar, i, i2);
                        return true;
                }
            } catch (IOException e2) {
                return false;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f6065c.a();
        }
    }

    static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.d f6066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e.c f6067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e.d f6068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f6069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f6070e;

        b(e.d dVar, boolean z) {
            this.f6066a = dVar;
            this.f6069d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(o.f6062a);
            this.f6067b = new e.c();
            this.f6068c = e.n.a(new e.g((s) this.f6067b, deflater));
        }

        private void a(List<f> list) throws IOException {
            this.f6068c.h(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                e.f fVar = list.get(i).h;
                this.f6068c.h(fVar.f());
                this.f6068c.b(fVar);
                e.f fVar2 = list.get(i).i;
                this.f6068c.h(fVar2.f());
                this.f6068c.b(fVar2);
            }
            this.f6068c.flush();
        }

        @Override // d.a.a.c
        public synchronized void a() {
        }

        void a(int i, int i2, e.c cVar, int i3) throws IOException {
            if (this.f6070e) {
                throw new IOException("closed");
            }
            if (i3 > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            }
            this.f6066a.h(Integer.MAX_VALUE & i);
            this.f6066a.h(((i2 & 255) << 24) | (16777215 & i3));
            if (i3 > 0) {
                this.f6066a.a_(cVar, i3);
            }
        }

        @Override // d.a.a.c
        public void a(int i, int i2, List<f> list) throws IOException {
        }

        @Override // d.a.a.c
        public synchronized void a(int i, long j) throws IOException {
            if (this.f6070e) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            }
            this.f6066a.h(-2147287031);
            this.f6066a.h(8);
            this.f6066a.h(i);
            this.f6066a.h((int) j);
            this.f6066a.flush();
        }

        @Override // d.a.a.c
        public synchronized void a(int i, d.a.a.a aVar) throws IOException {
            if (this.f6070e) {
                throw new IOException("closed");
            }
            if (aVar.t == -1) {
                throw new IllegalArgumentException();
            }
            this.f6066a.h(-2147287037);
            this.f6066a.h(8);
            this.f6066a.h(Integer.MAX_VALUE & i);
            this.f6066a.h(aVar.t);
            this.f6066a.flush();
        }

        @Override // d.a.a.c
        public synchronized void a(int i, d.a.a.a aVar, byte[] bArr) throws IOException {
            if (this.f6070e) {
                throw new IOException("closed");
            }
            if (aVar.u == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            this.f6066a.h(-2147287033);
            this.f6066a.h(8);
            this.f6066a.h(i);
            this.f6066a.h(aVar.u);
            this.f6066a.flush();
        }

        @Override // d.a.a.c
        public void a(n nVar) {
        }

        @Override // d.a.a.c
        public synchronized void a(boolean z, int i, int i2) throws IOException {
            synchronized (this) {
                if (this.f6070e) {
                    throw new IOException("closed");
                }
                if (z != (this.f6069d != ((i & 1) == 1))) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.f6066a.h(-2147287034);
                this.f6066a.h(4);
                this.f6066a.h(i);
                this.f6066a.flush();
            }
        }

        @Override // d.a.a.c
        public synchronized void a(boolean z, int i, e.c cVar, int i2) throws IOException {
            a(i, z ? 1 : 0, cVar, i2);
        }

        @Override // d.a.a.c
        public synchronized void a(boolean z, boolean z2, int i, int i2, List<f> list) throws IOException {
            synchronized (this) {
                if (this.f6070e) {
                    throw new IOException("closed");
                }
                a(list);
                int iB = (int) (10 + this.f6067b.b());
                int i3 = (z2 ? 2 : 0) | (z ? 1 : 0);
                this.f6066a.h(-2147287039);
                this.f6066a.h(((i3 & 255) << 24) | (iB & 16777215));
                this.f6066a.h(i & Integer.MAX_VALUE);
                this.f6066a.h(i2 & Integer.MAX_VALUE);
                this.f6066a.i(0);
                this.f6066a.a(this.f6067b);
                this.f6066a.flush();
            }
        }

        @Override // d.a.a.c
        public synchronized void b() throws IOException {
            if (this.f6070e) {
                throw new IOException("closed");
            }
            this.f6066a.flush();
        }

        @Override // d.a.a.c
        public synchronized void b(n nVar) throws IOException {
            if (this.f6070e) {
                throw new IOException("closed");
            }
            int iB = nVar.b();
            this.f6066a.h(-2147287036);
            this.f6066a.h((((iB * 8) + 4) & 16777215) | 0);
            this.f6066a.h(iB);
            for (int i = 0; i <= 10; i++) {
                if (nVar.a(i)) {
                    this.f6066a.h(((nVar.c(i) & 255) << 24) | (i & 16777215));
                    this.f6066a.h(nVar.b(i));
                }
            }
            this.f6066a.flush();
        }

        @Override // d.a.a.c
        public int c() {
            return 16383;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f6070e = true;
            d.a.j.a((Closeable) this.f6066a, (Closeable) this.f6068c);
        }
    }

    static {
        try {
            f6062a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(d.a.j.f6220c.name());
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError();
        }
    }

    @Override // d.a.a.p
    public d.a.a.b a(e.e eVar, boolean z) {
        return new a(eVar, z);
    }

    @Override // d.a.a.p
    public c a(e.d dVar, boolean z) {
        return new b(dVar, z);
    }
}
