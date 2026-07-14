package e;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes.dex */
public final class g implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deflater f6450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6451c;

    g(d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f6449a = dVar;
        this.f6450b = deflater;
    }

    public g(s sVar, Deflater deflater) {
        this(n.a(sVar), deflater);
    }

    @IgnoreJRERequirement
    private void a(boolean z) throws IOException {
        q qVarF;
        c cVarC = this.f6449a.c();
        while (true) {
            qVarF = cVarC.f(1);
            int iDeflate = z ? this.f6450b.deflate(qVarF.f6482a, qVarF.f6484c, 2048 - qVarF.f6484c, 2) : this.f6450b.deflate(qVarF.f6482a, qVarF.f6484c, 2048 - qVarF.f6484c);
            if (iDeflate > 0) {
                qVarF.f6484c += iDeflate;
                cVarC.f6441b += (long) iDeflate;
                this.f6449a.w();
            } else if (this.f6450b.needsInput()) {
                break;
            }
        }
        if (qVarF.f6483b == qVarF.f6484c) {
            cVarC.f6440a = qVarF.a();
            r.a(qVarF);
        }
    }

    @Override // e.s
    public u a() {
        return this.f6449a.a();
    }

    @Override // e.s
    public void a_(c cVar, long j) throws IOException {
        v.a(cVar.f6441b, 0L, j);
        while (j > 0) {
            q qVar = cVar.f6440a;
            int iMin = (int) Math.min(j, qVar.f6484c - qVar.f6483b);
            this.f6450b.setInput(qVar.f6482a, qVar.f6483b, iMin);
            a(false);
            cVar.f6441b -= (long) iMin;
            qVar.f6483b += iMin;
            if (qVar.f6483b == qVar.f6484c) {
                cVar.f6440a = qVar.a();
                r.a(qVar);
            }
            j -= (long) iMin;
        }
    }

    void b() throws IOException {
        this.f6450b.finish();
        a(false);
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f6451c) {
            return;
        }
        Throwable th = null;
        try {
            b();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f6450b.end();
            th = th;
        } catch (Throwable th3) {
            th = th3;
            if (th != null) {
                th = th;
            }
        }
        try {
            this.f6449a.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f6451c = true;
        if (th != null) {
            v.a(th);
        }
    }

    @Override // e.s, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f6449a.flush();
    }

    public String toString() {
        return "DeflaterSink(" + this.f6449a + ")";
    }
}
