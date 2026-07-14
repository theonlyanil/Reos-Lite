package com.cube26.iota.smartlite.e;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PowerManager.WakeLock f3374a;

    public static void a() {
        if (f3374a != null) {
            f3374a.release();
        }
        f3374a = null;
    }

    public static void a(Context context) {
        if (f3374a != null) {
            f3374a.release();
        }
        f3374a = ((PowerManager) context.getSystemService("power")).newWakeLock(805306394, "WakeLock");
        f3374a.acquire();
    }
}
