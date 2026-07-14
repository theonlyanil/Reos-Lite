package e;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes.dex */
public final class k implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deflater f6456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f6457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f6459e = new CRC32();

    public k(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f6456b = new Deflater(-1, true);
        this.f6455a = n.a(sVar);
        this.f6457c = new g(this.f6455a, this.f6456b);
        b();
    }

    private void b() {
        c cVarC = this.f6455a.c();
        cVarC.i(8075);
        cVarC.j(8);
        cVarC.j(0);
        cVarC.h(0);
        cVarC.j(0);
        cVarC.j(0);
    }

    private void b(c cVar, long j) {
        q qVar = cVar.f6440a;
        while (j > 0) {
            int iMin = (int) Math.min(j, qVar.f6484c - qVar.f6483b);
            this.f6459e.update(qVar.f6482a, qVar.f6483b, iMin);
            j -= (long) iMin;
            qVar = qVar.f6487f;
        }
    }

    private void c() throws IOException {
        this.f6455a.g((int) this.f6459e.getValue());
        this.f6455a.g(this.f6456b.getTotalIn());
    }

    @Override // e.s
    public u a() {
        return this.f6455a.a();
    }

    @Override // e.s
    public void a_(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return;
        }
        b(cVar, j);
        this.f6457c.a_(cVar, j);
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f6458d) {
            return;
        }
        Throwable th = null;
        try {
            this.f6457c.b();
            c();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f6456b.end();
            th = th;
        } catch (Throwable th3) {
            th = th3;
            if (th != null) {
                th = th;
            }
        }
        try {
            this.f6455a.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f6458d = true;
        if (th != null) {
            v.a(th);
        }
    }

    @Override // e.s, java.io.Flushable
    public void flush() throws IOException {
        this.f6457c.flush();
    }
}
