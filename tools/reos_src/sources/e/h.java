package e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f6452a;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f6452a = sVar;
    }

    @Override // e.s
    public u a() {
        return this.f6452a.a();
    }

    @Override // e.s
    public void a_(c cVar, long j) throws IOException {
        this.f6452a.a_(cVar, j);
    }

    @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6452a.close();
    }

    @Override // e.s, java.io.Flushable
    public void flush() throws IOException {
        this.f6452a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f6452a.toString() + ")";
    }
}
