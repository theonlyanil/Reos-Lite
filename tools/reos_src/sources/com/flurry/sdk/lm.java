package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class lm implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadGroup f4713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4714b;

    public lm(String str, int i) {
        this.f4713a = new ThreadGroup(str);
        this.f4714b = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f4713a, runnable);
        thread.setName(this.f4713a.getName() + ":" + thread.getId());
        thread.setPriority(this.f4714b);
        return thread;
    }
}
