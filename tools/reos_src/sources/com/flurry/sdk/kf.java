package com.flurry.sdk;

import com.flurry.sdk.lz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class kf<T extends lz> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4553a = kf.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final jx<Object, T> f4554b = new jx<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<T, Object> f4555c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<T, Future<?>> f4556d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ThreadPoolExecutor f4557e;

    public kf(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        this.f4557e = new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue) { // from class: com.flurry.sdk.kf.1
            @Override // java.util.concurrent.ThreadPoolExecutor
            protected void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                final lz lzVarA = kf.this.a(runnable);
                if (lzVarA == null) {
                    return;
                }
                synchronized (kf.this.f4556d) {
                    kf.this.f4556d.remove(lzVarA);
                }
                kf.this.b(lzVarA);
                new ly() { // from class: com.flurry.sdk.kf.1.2
                    @Override // com.flurry.sdk.ly
                    public void a() {
                        lzVarA.p();
                    }
                }.run();
            }

            @Override // java.util.concurrent.ThreadPoolExecutor
            protected void beforeExecute(Thread thread, Runnable runnable) {
                super.beforeExecute(thread, runnable);
                final lz lzVarA = kf.this.a(runnable);
                if (lzVarA == null) {
                    return;
                }
                new ly() { // from class: com.flurry.sdk.kf.1.1
                    @Override // com.flurry.sdk.ly
                    public void a() {
                        lzVarA.o();
                    }
                }.run();
            }

            @Override // java.util.concurrent.AbstractExecutorService
            protected <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
                ke keVar = new ke(runnable, v);
                synchronized (kf.this.f4556d) {
                    kf.this.f4556d.put((lz) runnable, keVar);
                }
                return keVar;
            }

            @Override // java.util.concurrent.AbstractExecutorService
            protected <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
                throw new UnsupportedOperationException("Callable not supported");
            }
        };
        this.f4557e.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy() { // from class: com.flurry.sdk.kf.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                final lz lzVarA = kf.this.a(runnable);
                if (lzVarA == null) {
                    return;
                }
                synchronized (kf.this.f4556d) {
                    kf.this.f4556d.remove(lzVarA);
                }
                kf.this.b(lzVarA);
                new ly() { // from class: com.flurry.sdk.kf.2.1
                    @Override // com.flurry.sdk.ly
                    public void a() {
                        lzVarA.q();
                    }
                }.run();
            }
        });
        this.f4557e.setThreadFactory(new lm(str, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public T a(Runnable runnable) {
        if (runnable instanceof ke) {
            return (T) ((ke) runnable).a();
        }
        if (runnable instanceof lz) {
            return (T) runnable;
        }
        kg.a(6, f4553a, "Unknown runnable class: " + runnable.getClass().getName());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(T t) {
        c(this.f4555c.get(t), t);
    }

    private synchronized void b(Object obj, T t) {
        this.f4554b.a(obj, t);
        this.f4555c.put(t, obj);
    }

    private synchronized void c(Object obj, T t) {
        this.f4554b.b(obj, t);
        this.f4555c.remove(t);
    }

    public synchronized void a(final T t) {
        Future<?> futureRemove;
        if (t != null) {
            synchronized (this.f4556d) {
                futureRemove = this.f4556d.remove(t);
            }
            b((lz) t);
            if (futureRemove != null) {
                futureRemove.cancel(true);
            }
            new ly() { // from class: com.flurry.sdk.kf.3
                @Override // com.flurry.sdk.ly
                public void a() {
                    t.m();
                }
            }.run();
        }
    }

    public synchronized void a(Object obj) {
        if (obj != null) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.f4554b.a(obj));
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                a((lz) it.next());
            }
        }
    }

    public synchronized void a(Object obj, T t) {
        if (obj != null && t != null) {
            b(obj, t);
            this.f4557e.submit(t);
        }
    }

    public synchronized long b(Object obj) {
        return obj == null ? 0L : this.f4554b.a(obj).size();
    }

    public synchronized void c() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f4554b.c());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
