package com.facebook.b;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class u<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f3813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CountDownLatch f3814b = new CountDownLatch(1);

    public u(final Callable<T> callable) {
        com.facebook.m.d().execute(new FutureTask(new Callable<Void>() { // from class: com.facebook.b.u.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                try {
                    u.this.f3813a = callable.call();
                    return null;
                } finally {
                    u.this.f3814b.countDown();
                }
            }
        }));
    }

    private void b() {
        if (this.f3814b == null) {
            return;
        }
        try {
            this.f3814b.await();
        } catch (InterruptedException e2) {
        }
    }

    public T a() {
        b();
        return this.f3813a;
    }
}
