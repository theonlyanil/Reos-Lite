package e;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f6490b = new u() { // from class: e.u.1
        @Override // e.u
        public u a(long j) {
            return this;
        }

        @Override // e.u
        public u a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // e.u
        public void g() throws IOException {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6491a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f6493d;

    public u a(long j) {
        this.f6491a = true;
        this.f6492c = j;
        return this;
    }

    public u a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.f6493d = timeUnit.toNanos(j);
        return this;
    }

    public long d() {
        if (this.f6491a) {
            return this.f6492c;
        }
        throw new IllegalStateException("No deadline");
    }

    public u f() {
        this.f6491a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f6491a && this.f6492c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long g_() {
        return this.f6493d;
    }

    public boolean h_() {
        return this.f6491a;
    }

    public u i_() {
        this.f6493d = 0L;
        return this;
    }
}
