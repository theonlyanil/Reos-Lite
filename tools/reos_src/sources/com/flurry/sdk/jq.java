package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class jq extends kf<kp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static jq f4505a = null;

    protected jq() {
        super(jq.class.getName(), 0, 5, 5000L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new kd()));
    }

    public static synchronized jq a() {
        if (f4505a == null) {
            f4505a = new jq();
        }
        return f4505a;
    }

    public static synchronized void b() {
        if (f4505a != null) {
            f4505a.c();
        }
        f4505a = null;
    }
}
