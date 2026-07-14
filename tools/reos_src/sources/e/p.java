package e;

import com.flurry.android.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
final class p implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f6478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f6479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6480c;

    public p(t tVar) {
        this(tVar, new c());
    }

    public p(t tVar, c cVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f6478a = cVar;
        this.f6479b = tVar;
    }

    @Override // e.e
    public long a(byte b2) throws IOException {
        return a(b2, 0L);
    }

    public long a(byte b2, long j) throws IOException {
        if (this.f6480c) {
            throw new IllegalStateException("closed");
        }
        while (j >= this.f6478a.f6441b) {
            if (this.f6479b.a(this.f6478a, 2048L) == -1) {
                return -1L;
            }
        }
        do {
            long jA = this.f6478a.a(b2, j);
            if (jA != -1) {
                return jA;
            }
            j = this.f6478a.f6441b;
        } while (this.f6479b.a(this.f6478a, 2048L) != -1);
        return -1L;
    }

    @Override // e.t
    public long a(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f6480c) {
            throw new IllegalStateException("closed");
        }
        if (this.f6478a.f6441b == 0 && this.f6479b.a(this.f6478a, 2048L) == -1) {
            return -1L;
        }
        return this.f6478a.a(cVar, Math.min(j, this.f6478a.f6441b));
    }

    @Override // e.e
    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f6479b.a(this.f6478a, 2048L) != -1) {
            long jI = this.f6478a.i();
            if (jI > 0) {
                j += jI;
                sVar.a_(this.f6478a, jI);
            }
        }
        if (this.f6478a.b() <= 0) {
            return j;
        }
        long jB = j + this.f6478a.b();
        sVar.a_(this.f6478a, this.f6478a.b());
        return jB;
    }

    @Override // e.t
    public u a() {
        return this.f6479b.a();
    }

    @Override // e.e
    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f6480c) {
            throw new IllegalStateException("closed");
        }
        while (this.f6478a.f6441b < j) {
            if (this.f6479b.a(this.f6478a, 2048L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // e.e
    public c c() {
        return this.f6478a;
    }

    @Override // e.e
    public f c(long j) throws IOException {
        a(j);
        return this.f6478a.c(j);
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f6480c) {
            return;
        }
        this.f6480c = true;
        this.f6479b.close();
        this.f6478a.u();
    }

    @Override // e.e
    public byte[] f(long j) throws IOException {
        a(j);
        return this.f6478a.f(j);
    }

    @Override // e.e
    public void g(long j) throws IOException {
        if (this.f6480c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f6478a.f6441b == 0 && this.f6479b.a(this.f6478a, 2048L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f6478a.b());
            this.f6478a.g(jMin);
            j -= jMin;
        }
    }

    @Override // e.e
    public boolean g() throws IOException {
        if (this.f6480c) {
            throw new IllegalStateException("closed");
        }
        return this.f6478a.g() && this.f6479b.a(this.f6478a, 2048L) == -1;
    }

    @Override // e.e
    public InputStream h() {
        return new InputStream() { // from class: e.p.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (p.this.f6480c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(p.this.f6478a.f6441b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                p.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (p.this.f6480c) {
                    throw new IOException("closed");
                }
                if (p.this.f6478a.f6441b == 0 && p.this.f6479b.a(p.this.f6478a, 2048L) == -1) {
                    return -1;
                }
                return p.this.f6478a.j() & Constants.UNKNOWN;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (p.this.f6480c) {
                    throw new IOException("closed");
                }
                v.a(bArr.length, i, i2);
                if (p.this.f6478a.f6441b == 0 && p.this.f6479b.a(p.this.f6478a, 2048L) == -1) {
                    return -1;
                }
                return p.this.f6478a.a(bArr, i, i2);
            }

            public String toString() {
                return p.this + ".inputStream()";
            }
        };
    }

    @Override // e.e
    public byte j() throws IOException {
        a(1L);
        return this.f6478a.j();
    }

    @Override // e.e
    public short k() throws IOException {
        a(2L);
        return this.f6478a.k();
    }

    @Override // e.e
    public int l() throws IOException {
        a(4L);
        return this.f6478a.l();
    }

    @Override // e.e
    public short m() throws IOException {
        a(2L);
        return this.f6478a.m();
    }

    @Override // e.e
    public int n() throws IOException {
        a(4L);
        return this.f6478a.n();
    }

    @Override // e.e
    public long o() throws IOException {
        a(1L);
        for (int i = 0; b(i + 1); i++) {
            byte b2 = this.f6478a.b(i);
            if ((b2 < 48 || b2 > 57) && !(i == 0 && b2 == 45)) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b2)));
            }
        }
        return this.f6478a.o();
    }

    @Override // e.e
    public long p() throws IOException {
        a(1L);
        for (int i = 0; b(i + 1); i++) {
            byte b2 = this.f6478a.b(i);
            if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b2)));
            }
        }
        return this.f6478a.p();
    }

    @Override // e.e
    public String s() throws IOException {
        long jA = a((byte) 10);
        if (jA != -1) {
            return this.f6478a.e(jA);
        }
        c cVar = new c();
        this.f6478a.a(cVar, 0L, Math.min(32L, this.f6478a.b()));
        throw new EOFException("\\n not found: size=" + this.f6478a.b() + " content=" + cVar.q().d() + "...");
    }

    public String toString() {
        return "buffer(" + this.f6479b + ")";
    }
}
