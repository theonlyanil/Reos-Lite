package e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class o implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f6475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f6476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6477c;

    public o(s sVar) {
        this(sVar, new c());
    }

    public o(s sVar, c cVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f6475a = cVar;
        this.f6476b = sVar;
    }

    @Override // e.d
    public long a(t tVar) throws IOException {
        if (tVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = tVar.a(this.f6475a, 2048L);
            if (jA == -1) {
                return j;
            }
            j += jA;
            w();
        }
    }

    @Override // e.s
    public u a() {
        return this.f6476b.a();
    }

    @Override // e.s
    public void a_(c cVar, long j) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.a_(cVar, j);
        w();
    }

    @Override // e.d
    public d b(f fVar) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.b(fVar);
        return w();
    }

    @Override // e.d
    public d b(String str) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.b(str);
        return w();
    }

    @Override // e.d, e.e
    public c c() {
        return this.f6475a;
    }

    @Override // e.d
    public d c(byte[] bArr) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.c(bArr);
        return w();
    }

    @Override // e.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.c(bArr, i, i2);
        return w();
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f6477c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f6475a.f6441b > 0) {
                this.f6476b.a_(this.f6475a, this.f6475a.f6441b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f6476b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f6477c = true;
        if (th != null) {
            v.a(th);
        }
    }

    @Override // e.d
    public d f() throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        long jB = this.f6475a.b();
        if (jB > 0) {
            this.f6476b.a_(this.f6475a, jB);
        }
        return this;
    }

    @Override // e.s, java.io.Flushable
    public void flush() throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        if (this.f6475a.f6441b > 0) {
            this.f6476b.a_(this.f6475a, this.f6475a.f6441b);
        }
        this.f6476b.flush();
    }

    @Override // e.d
    public d g(int i) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.g(i);
        return w();
    }

    @Override // e.d
    public d h(int i) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.h(i);
        return w();
    }

    @Override // e.d
    public d i(int i) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.i(i);
        return w();
    }

    @Override // e.d
    public d j(int i) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.j(i);
        return w();
    }

    @Override // e.d
    public d j(long j) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.j(j);
        return w();
    }

    @Override // e.d
    public d k(long j) throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        this.f6475a.k(j);
        return w();
    }

    public String toString() {
        return "buffer(" + this.f6476b + ")";
    }

    @Override // e.d
    public d w() throws IOException {
        if (this.f6477c) {
            throw new IllegalStateException("closed");
        }
        long jI = this.f6475a.i();
        if (jI > 0) {
            this.f6476b.a_(this.f6475a, jI);
        }
        return this;
    }
}
