package com.android.library.http.c;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f2698a = new Handler(Looper.getMainLooper());

    c() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f2698a.post(runnable);
    }
}
