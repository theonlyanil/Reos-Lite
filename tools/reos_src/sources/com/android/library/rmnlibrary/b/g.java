package com.android.library.rmnlibrary.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.android.apps.config.util.CLog;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static int a(String str, int i, Context context) {
        return a(context).getInt(str, i);
    }

    public static long a(String str, long j, Context context) {
        return a(context).getLong(str, j);
    }

    public static SharedPreferences a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String a(String str, String str2, Context context) {
        return a(context).getString(str, str2);
    }

    public static void a(Context context, String str) {
        CLog.b("RMNLibrary", "Shared preference put data for regid " + str);
        b("com.android.library.rmnlibrary.sharedprefs.key.registrationid", str, context);
        b("com.android.library.rmnlibrary.sharedprefs.key.appversion", b.g(context), context);
        b("com.android.library.rmnlibrary.sharedprefs.key.regtime", System.currentTimeMillis(), context);
    }

    public static void a(String str, Context context) {
        b(context).remove(str).apply();
    }

    public static boolean a(String str, boolean z, Context context) {
        return a(context).getBoolean(str, z);
    }

    public static SharedPreferences.Editor b(Context context) {
        return a(context).edit();
    }

    public static void b(String str, int i, Context context) {
        b(context).putInt(str, i).apply();
    }

    public static void b(String str, long j, Context context) {
        b(context).putLong(str, j).apply();
    }

    public static void b(String str, String str2, Context context) {
        b(context).putString(str, str2).apply();
    }

    public static void b(String str, boolean z, Context context) {
        b(context).putBoolean(str, z).apply();
    }

    public static String c(Context context) {
        String strA = a("com.android.library.rmnlibrary.sharedprefs.key.registrationid", "", context);
        String strA2 = a("com.android.library.rmnlibrary.sharedprefs.key.appversion", "", context);
        String strF = com.android.library.deviceData.c.a.f(context);
        CLog.b("RMNLibrary", "getRegistrationId currentVersion " + strF);
        CLog.b("RMNLibrary", "getRegistrationId registeredVersion " + strA2);
        CLog.b("RMNLibrary", "getRegistrationId registrationId " + strA);
        return (h.b(strA) || !strA2.equals(strF)) ? "" : strA;
    }

    public static void d(Context context) {
        CLog.b("RMNLibrary", "Deleting registration id details");
        a("com.android.library.rmnlibrary.sharedprefs.key.registrationid", context);
        a("com.android.library.rmnlibrary.sharedprefs.key.appversion", context);
        a("com.android.library.rmnlibrary.sharedprefs.key.regtime", context);
    }
}
