package com.a.a.d.b.c;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f2121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f2122b;

    /* JADX INFO: renamed from: com.a.a.d.b.c.a$a, reason: collision with other inner class name */
    public static class ThreadFactoryC0042a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2123a = 0;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "fifo-pool-thread-" + this.f2123a) { // from class: com.a.a.d.b.c.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            this.f2123a++;
            return thread;
        }
    }

    static class b<T> extends FutureTask<T> implements Comparable<b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2126b;

        public b(Runnable runnable, T t, int i) {
            super(runnable, t);
            if (!(runnable instanceof com.a.a.d.b.c.b)) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.f2125a = ((com.a.a.d.b.c.b) runnable).b();
            this.f2126b = i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b<?> bVar) {
            int i = this.f2125a - bVar.f2125a;
            return i == 0 ? this.f2126b - bVar.f2126b : i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f2126b == bVar.f2126b && this.f2125a == bVar.f2125a;
        }

        public int hashCode() {
            return (this.f2125a * 31) + this.f2126b;
        }
    }

    public enum c {
        IGNORE,
        LOG { // from class: com.a.a.d.b.c.a.c.1
            @Override // com.a.a.d.b.c.a.c
            protected void a(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        },
        THROW { // from class: com.a.a.d.b.c.a.c.2
            @Override // com.a.a.d.b.c.a.c
            protected void a(Throwable th) {
                super.a(th);
                throw new RuntimeException(th);
            }
        };

        protected void a(Throwable th) {
        }
    }

    public a(int i) {
        this(i, c.LOG);
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, c cVar) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f2121a = new AtomicInteger();
        this.f2122b = cVar;
    }

    public a(int i, c cVar) {
        this(i, i, 0L, TimeUnit.MILLISECONDS, new ThreadFactoryC0042a(), cVar);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (InterruptedException e2) {
                this.f2122b.a(e2);
            } catch (ExecutionException e3) {
                this.f2122b.a(e3);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new b(runnable, t, this.f2121a.getAndIncrement());
    }
}
