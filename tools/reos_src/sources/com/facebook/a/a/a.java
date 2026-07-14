package com.facebook.a.a;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile c f3552d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3549a = a.class.getCanonicalName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ScheduledExecutorService f3550b = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicInteger f3551c = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AtomicBoolean f3553e = new AtomicBoolean(false);

    public static UUID a() {
        if (f3552d != null) {
            return f3552d.a();
        }
        return null;
    }
}
