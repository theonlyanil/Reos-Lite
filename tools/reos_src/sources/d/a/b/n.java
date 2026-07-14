package d.a.b;

import e.s;
import e.u;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class n implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.c f6161c;

    public n() {
        this(-1);
    }

    public n(int i) {
        this.f6161c = new e.c();
        this.f6160b = i;
    }

    @Override // e.s
    public u a() {
        return u.f6490b;
    }

    public void a(s sVar) throws IOException {
        e.c cVar = new e.c();
        this.f6161c.a(cVar, 0L, this.f6161c.b());
        sVar.a_(cVar, cVar.b());
    }

    @Override // e.s
    public void a_(e.c cVar, long j) throws IOException {
        if (this.f6159a) {
            throw new IllegalStateException("closed");
        }
        d.a.j.a(cVar.b(), 0L, j);
        if (this.f6160b != -1 && this.f6161c.b() > ((long) this.f6160b) - j) {
            throw new ProtocolException("exceeded content-length limit of " + this.f6160b + " bytes");
        }
        this.f6161c.a_(cVar, j);
    }

    public long b() throws IOException {
        return this.f6161c.b();
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f6159a) {
            return;
        }
        this.f6159a = true;
        if (this.f6161c.b() < this.f6160b) {
            throw new ProtocolException("content-length promised " + this.f6160b + " bytes, but received " + this.f6161c.b());
        }
    }

    @Override // e.s, java.io.Flushable
    public void flush() throws IOException {
    }
}
