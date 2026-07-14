package d.a;

import e.s;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class c extends e.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6179a;

    public c(s sVar) {
        super(sVar);
    }

    protected void a(IOException iOException) {
    }

    @Override // e.h, e.s
    public void a_(e.c cVar, long j) throws IOException {
        if (this.f6179a) {
            cVar.g(j);
            return;
        }
        try {
            super.a_(cVar, j);
        } catch (IOException e2) {
            this.f6179a = true;
            a(e2);
        }
    }

    @Override // e.h, e.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f6179a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.f6179a = true;
            a(e2);
        }
    }

    @Override // e.h, e.s, java.io.Flushable
    public void flush() throws IOException {
        if (this.f6179a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.f6179a = true;
            a(e2);
        }
    }
}
