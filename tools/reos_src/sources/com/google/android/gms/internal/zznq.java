package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zznq {
    private static long zzamm;
    private static IntentFilter zzaml = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static float zzamn = Float.NaN;

    public static int zzaw(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, zzaml);
        return ((zznx.zzrV() ? ((PowerManager) context.getSystemService("power")).isInteractive() : ((PowerManager) context.getSystemService("power")).isScreenOn() ? 1 : 0) << 1) | (((intentRegisterReceiver == null ? 0 : intentRegisterReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0);
    }

    public static synchronized float zzax(Context context) {
        float f2;
        if (SystemClock.elapsedRealtime() - zzamm >= 60000 || zzamn == Float.NaN) {
            Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, zzaml);
            if (intentRegisterReceiver != null) {
                zzamn = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
            }
            zzamm = SystemClock.elapsedRealtime();
            f2 = zzamn;
        } else {
            f2 = zzamn;
        }
        return f2;
    }
}
