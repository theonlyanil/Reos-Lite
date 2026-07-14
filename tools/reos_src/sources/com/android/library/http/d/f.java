package com.android.library.http.d;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f2706a = "0123456789abcdef".toCharArray();

    public static final long a(long j) {
        return TimeUnit.MILLISECONDS.toHours(j);
    }

    public static final long a(long j, long j2) {
        return TimeUnit.MILLISECONDS.toHours(j2) - TimeUnit.MILLISECONDS.toHours(j);
    }

    public static String a(Context context) {
        return com.android.library.deviceData.c.d.a(context).size() > 0 ? com.android.library.deviceData.c.d.a(context).get(0) : "-1";
    }

    public static final long b(long j, long j2) {
        return TimeUnit.MILLISECONDS.toMinutes(j2) - TimeUnit.MILLISECONDS.toMinutes(j);
    }

    public static final String b(Context context) {
        return com.android.library.deviceData.c.a.e(context);
    }
}
