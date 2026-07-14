package com.android.library.http.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static long a(String str, long j, Context context) {
        return a(context).getLong(str, j);
    }

    public static SharedPreferences a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferences.Editor b(Context context) {
        return a(context).edit();
    }

    public static void b(String str, long j, Context context) {
        b(context).putLong(str, j).apply();
    }

    public static long c(Context context) {
        return a("com.android.library.httplibrary.events.LAST_EVENT_BATCH_DATA_POSTED", 0L, context);
    }

    public static long d(Context context) {
        return a("com.android.library.httplibrary.events.LAST_EVENT_DATA_POSTED", 0L, context);
    }
}
