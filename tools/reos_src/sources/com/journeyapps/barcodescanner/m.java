package com.journeyapps.barcodescanner;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static void a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
