package e;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public class a extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f6429a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f6431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6432e;

    /* JADX INFO: renamed from: e.a$a, reason: collision with other inner class name */
    private static final class C0209a extends Thread {
        public C0209a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX INFO: Infinite loop detected, blocks: 11, insns: 0 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    a aVarH = a.h();
                    if (aVarH != null) {
                        aVarH.a();
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        if (f6429a == null) {
            f6429a = new a();
            new C0209a().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            aVar.f6432e = Math.min(j, aVar.d() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            aVar.f6432e = jNanoTime + j;
        } else {
            if (!z) {
                throw new AssertionError();
            }
            aVar.f6432e = aVar.d();
        }
        long jB = aVar.b(jNanoTime);
        a aVar2 = f6429a;
        while (aVar2.f6431d != null && jB >= aVar2.f6431d.b(jNanoTime)) {
            aVar2 = aVar2.f6431d;
        }
        aVar.f6431d = aVar2.f6431d;
        aVar2.f6431d = aVar;
        if (aVar2 == f6429a) {
            a.class.notify();
        }
    }

    private static synchronized boolean a(a aVar) {
        boolean z;
        for (a aVar2 = f6429a; aVar2 != null; aVar2 = aVar2.f6431d) {
            if (aVar2.f6431d == aVar) {
                aVar2.f6431d = aVar.f6431d;
                aVar.f6431d = null;
                z = false;
            }
        }
        z = true;
        return z;
    }

    private long b(long j) {
        return this.f6432e - j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized a h() throws InterruptedException {
        a aVar = null;
        synchronized (a.class) {
            a aVar2 = f6429a.f6431d;
            if (aVar2 == null) {
                a.class.wait();
            } else {
                long jB = aVar2.b(System.nanoTime());
                if (jB > 0) {
                    long j = jB / 1000000;
                    a.class.wait(j, (int) (jB - (1000000 * j)));
                } else {
                    f6429a.f6431d = aVar2.f6431d;
                    aVar2.f6431d = null;
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public final s a(final s sVar) {
        return new s() { // from class: e.a.1
            @Override // e.s
            public u a() {
                return a.this;
            }

            @Override // e.s
            public void a_(c cVar, long j) throws IOException {
                a.this.c();
                try {
                    try {
                        sVar.a_(cVar, j);
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // e.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.c();
                try {
                    try {
                        sVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // e.s, java.io.Flushable
            public void flush() throws IOException {
                a.this.c();
                try {
                    try {
                        sVar.flush();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sVar + ")";
            }
        };
    }

    public final t a(final t tVar) {
        return new t() { // from class: e.a.2
            @Override // e.t
            public long a(c cVar, long j) throws IOException {
                a.this.c();
                try {
                    try {
                        long jA = tVar.a(cVar, j);
                        a.this.a(true);
                        return jA;
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // e.t
            public u a() {
                return a.this;
            }

            @Override // e.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        tVar.close();
                        a.this.a(true);
                    } catch (IOException e2) {
                        throw a.this.b(e2);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + tVar + ")";
            }
        };
    }

    protected IOException a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    protected void a() {
    }

    final void a(boolean z) throws IOException {
        if (f_() && z) {
            throw a((IOException) null);
        }
    }

    final IOException b(IOException iOException) throws IOException {
        return !f_() ? iOException : a(iOException);
    }

    public final void c() {
        if (this.f6430c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jG_ = g_();
        boolean zH_ = h_();
        if (jG_ != 0 || zH_) {
            this.f6430c = true;
            a(this, jG_, zH_);
        }
    }

    public final boolean f_() {
        if (!this.f6430c) {
            return false;
        }
        this.f6430c = false;
        return a(this);
    }
}
