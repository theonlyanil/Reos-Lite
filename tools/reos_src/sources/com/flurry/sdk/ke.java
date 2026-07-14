package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class ke<V> extends FutureTask<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Callable<V>> f4551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Runnable> f4552b;

    public ke(Runnable runnable, V v) {
        super(runnable, v);
        this.f4551a = new WeakReference<>(null);
        this.f4552b = new WeakReference<>(runnable);
    }

    public Runnable a() {
        return this.f4552b.get();
    }
}
