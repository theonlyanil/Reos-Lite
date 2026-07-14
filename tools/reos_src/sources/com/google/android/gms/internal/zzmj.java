package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzmj {
    private static final ExecutorService zzagQ = Executors.newFixedThreadPool(2, new zzod("GAC_Executor"));

    public static ExecutorService zzpz() {
        return zzagQ;
    }
}
