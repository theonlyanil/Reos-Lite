package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
class zza {
    static AppMeasurement zzaIH;

    private static void zza(Context context, String str, Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.a.campaign");
        if (Log.isLoggable("GcmAnalytics", 3)) {
            Log.d("GcmAnalytics", "Sending event=" + str + " campaign=" + stringExtra);
        }
        Bundle bundle = new Bundle();
        bundle.putString("nc", stringExtra);
        String stringExtra2 = intent.getStringExtra("from");
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (stringExtra2.startsWith("/topics/")) {
                bundle.putString("nt", stringExtra2);
            } else {
                try {
                    Long.parseLong(stringExtra2);
                    bundle.putString("nsid", stringExtra2);
                } catch (NumberFormatException e2) {
                    Log.d("GcmAnalytics", "Unrecognised from address: " + stringExtra2);
                }
            }
        }
        try {
            (zzaIH == null ? AppMeasurement.getInstance(context) : zzaIH).zzd(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE, str, bundle);
        } catch (NoClassDefFoundError e3) {
            Log.e("GcmAnalytics", "Unable to log event, missing GMS measurement library");
        }
    }

    public static void zze(Context context, Intent intent) {
        zza(context, "_nr", intent);
    }

    public static void zzf(Context context, Intent intent) {
        zza(context, "_no", intent);
    }

    public static void zzg(Context context, Intent intent) {
        zza(context, "_nd", intent);
    }

    public static void zzh(Context context, Intent intent) {
        zza(context, "_nf", intent);
    }
}
