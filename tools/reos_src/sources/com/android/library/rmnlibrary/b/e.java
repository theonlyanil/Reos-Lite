package com.android.library.rmnlibrary.b;

import android.util.LruCache;

/* JADX INFO: loaded from: classes.dex */
public class e extends LruCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f2767a;

    private e(int i) {
        super(i);
    }

    public static e a() {
        if (f2767a == null) {
            f2767a = new e(10);
        }
        return f2767a;
    }

    public void b() {
        evictAll();
    }
}
