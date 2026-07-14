package e;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class m implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f6465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Inflater f6466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6468d;

    m(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f6465a = eVar;
        this.f6466b = inflater;
    }

    public m(t tVar, Inflater inflater) {
        this(n.a(tVar), inflater);
    }

    private void c() throws IOException {
        if (this.f6467c == 0) {
            return;
        }
        int remaining = this.f6467c - this.f6466b.getRemaining();
        this.f6467c -= remaining;
        this.f6465a.g(remaining);
    }

    @Override // e.t
    public long a(c cVar, long j) throws IOException {
        boolean zB;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f6468d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zB = b();
            try {
                q qVarF = cVar.f(1);
                int iInflate = this.f6466b.inflate(qVarF.f6482a, qVarF.f6484c, 2048 - qVarF.f6484c);
                if (iInflate > 0) {
                    qVarF.f6484c += iInflate;
                    cVar.f6441b += (long) iInflate;
                    return iInflate;
                }
                if (this.f6466b.finished() || this.f6466b.needsDictionary()) {
                    c();
                    if (qVarF.f6483b == qVarF.f6484c) {
                        cVar.f6440a = qVarF.a();
                        r.a(qVarF);
                    }
                    return -1L;
                }
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!zB);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // e.t
    public u a() {
        return this.f6465a.a();
    }

    public boolean b() throws IOException {
        if (!this.f6466b.needsInput()) {
            return false;
        }
        c();
        if (this.f6466b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f6465a.g()) {
            return true;
        }
        q qVar = this.f6465a.c().f6440a;
        this.f6467c = qVar.f6484c - qVar.f6483b;
        this.f6466b.setInput(qVar.f6482a, qVar.f6483b, this.f6467c);
        return false;
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f6468d) {
            return;
        }
        this.f6466b.end();
        this.f6468d = true;
        this.f6465a.close();
    }
}
