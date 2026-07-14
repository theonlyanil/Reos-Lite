package e;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class l implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f6461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f6462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f6463d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6460a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f6464e = new CRC32();

    public l(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f6462c = new Inflater(true);
        this.f6461b = n.a(tVar);
        this.f6463d = new m(this.f6461b, this.f6462c);
    }

    private void a(c cVar, long j, long j2) {
        q qVar = cVar.f6440a;
        while (j >= qVar.f6484c - qVar.f6483b) {
            j -= (long) (qVar.f6484c - qVar.f6483b);
            qVar = qVar.f6487f;
        }
        while (j2 > 0) {
            int i = (int) (((long) qVar.f6483b) + j);
            int iMin = (int) Math.min(qVar.f6484c - i, j2);
            this.f6464e.update(qVar.f6482a, i, iMin);
            j2 -= (long) iMin;
            qVar = qVar.f6487f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    private void b() throws IOException {
        this.f6461b.a(10L);
        byte b2 = this.f6461b.c().b(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            a(this.f6461b.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f6461b.k());
        this.f6461b.g(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.f6461b.a(2L);
            if (z) {
                a(this.f6461b.c(), 0L, 2L);
            }
            short sM = this.f6461b.c().m();
            this.f6461b.a(sM);
            if (z) {
                a(this.f6461b.c(), 0L, sM);
            }
            this.f6461b.g(sM);
        }
        if (((b2 >> 3) & 1) == 1) {
            long jA = this.f6461b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f6461b.c(), 0L, 1 + jA);
            }
            this.f6461b.g(1 + jA);
        }
        if (((b2 >> 4) & 1) == 1) {
            long jA2 = this.f6461b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f6461b.c(), 0L, 1 + jA2);
            }
            this.f6461b.g(1 + jA2);
        }
        if (z) {
            a("FHCRC", this.f6461b.m(), (short) this.f6464e.getValue());
            this.f6464e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.f6461b.n(), (int) this.f6464e.getValue());
        a("ISIZE", this.f6461b.n(), this.f6462c.getTotalOut());
    }

    @Override // e.t
    public long a(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f6460a == 0) {
            b();
            this.f6460a = 1;
        }
        if (this.f6460a == 1) {
            long j2 = cVar.f6441b;
            long jA = this.f6463d.a(cVar, j);
            if (jA != -1) {
                a(cVar, j2, jA);
                return jA;
            }
            this.f6460a = 2;
        }
        if (this.f6460a == 2) {
            c();
            this.f6460a = 3;
            if (!this.f6461b.g()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // e.t
    public u a() {
        return this.f6461b.a();
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6463d.close();
    }
}
