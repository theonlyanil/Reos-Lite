package com.a.a.h;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.a.a.h.b.i;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class e<T, R> implements com.a.a.h.a<R>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f2466a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f2467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f2471f;
    private R g;
    private c h;
    private boolean i;
    private Exception j;
    private boolean k;
    private boolean l;

    static class a {
        a() {
        }

        public void a(Object obj) {
            obj.notifyAll();
        }

        public void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public e(Handler handler, int i, int i2) {
        this(handler, i, i2, true, f2466a);
    }

    e(Handler handler, int i, int i2, boolean z, a aVar) {
        this.f2467b = handler;
        this.f2468c = i;
        this.f2469d = i2;
        this.f2470e = z;
        this.f2471f = aVar;
    }

    private synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        R r;
        if (this.f2470e) {
            com.a.a.j.h.b();
        }
        if (this.i) {
            throw new CancellationException();
        }
        if (this.l) {
            throw new ExecutionException(this.j);
        }
        if (this.k) {
            r = this.g;
        } else {
            if (l == null) {
                this.f2471f.a(this, 0L);
            } else if (l.longValue() > 0) {
                this.f2471f.a(this, l.longValue());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.l) {
                throw new ExecutionException(this.j);
            }
            if (this.i) {
                throw new CancellationException();
            }
            if (!this.k) {
                throw new TimeoutException();
            }
            r = this.g;
        }
        return r;
    }

    @Override // com.a.a.h.b.k
    public c a() {
        return this.h;
    }

    @Override // com.a.a.h.b.k
    public void a(Drawable drawable) {
    }

    @Override // com.a.a.h.b.k
    public void a(i iVar) {
        iVar.a(this.f2468c, this.f2469d);
    }

    @Override // com.a.a.h.b.k
    public void a(c cVar) {
        this.h = cVar;
    }

    @Override // com.a.a.h.b.k
    public synchronized void a(Exception exc, Drawable drawable) {
        this.l = true;
        this.j = exc;
        this.f2471f.a(this);
    }

    @Override // com.a.a.h.b.k
    public synchronized void a(R r, com.a.a.h.a.c<? super R> cVar) {
        this.k = true;
        this.g = r;
        this.f2471f.a(this);
    }

    public void b() {
        this.f2467b.post(this);
    }

    @Override // com.a.a.h.b.k
    public void b(Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (!this.i) {
                z2 = isDone() ? false : true;
                if (z2) {
                    this.i = true;
                    if (z) {
                        b();
                    }
                    this.f2471f.a(this);
                }
            }
        }
        return z2;
    }

    @Override // com.a.a.e.h
    public void d() {
    }

    @Override // com.a.a.e.h
    public void e() {
    }

    @Override // com.a.a.e.h
    public void f() {
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.i;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.i || this.k;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.h != null) {
            this.h.d();
            cancel(false);
        }
    }
}
