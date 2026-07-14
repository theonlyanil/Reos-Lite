package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zznq;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzi {
    private static Integer zzalE;
    private static String TAG = "WakeLockTracker";
    private static zzi zzamh = new zzi();

    private static int getLogLevel() {
        try {
            return zznk.zzka() ? zzc.zzb.zzalI.get().intValue() : zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e2) {
            return zzd.LOG_LEVEL_OFF;
        }
    }

    private static boolean zzau(Context context) {
        if (zzalE == null) {
            zzalE = Integer.valueOf(getLogLevel());
        }
        return zzalE.intValue() != zzd.LOG_LEVEL_OFF;
    }

    public static zzi zzrJ() {
        return zzamh;
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        zza(context, str, i, str2, str3, i2, list, 0L);
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list, long j) {
        if (zzau(context)) {
            if (TextUtils.isEmpty(str)) {
                Log.e(TAG, "missing wakeLock key. " + str);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzd.zzalO).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(jCurrentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), zznq.zzaw(context), str3, context.getPackageName(), zznq.zzax(context), j)));
                } catch (Exception e2) {
                    Log.wtf(TAG, e2);
                }
            }
        }
    }
}
