package e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f6453a;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6453a = tVar;
    }

    @Override // e.t
    public long a(c cVar, long j) throws IOException {
        return this.f6453a.a(cVar, j);
    }

    @Override // e.t
    public u a() {
        return this.f6453a.a();
    }

    @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6453a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f6453a.toString() + ")";
    }
}
