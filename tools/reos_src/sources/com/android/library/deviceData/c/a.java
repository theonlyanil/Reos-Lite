package com.android.library.deviceData.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.android.apps.config.util.CLog;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2625a = a.class.getName();

    public static float a(Context context) {
        return context.getResources().getDisplayMetrics().xdpi;
    }

    public static String a() {
        String str = Build.BOARD;
        return str != null ? str : "";
    }

    public static float b(Context context) {
        return context.getResources().getDisplayMetrics().ydpi;
    }

    public static String b() {
        String str = Build.MODEL;
        return str != null ? str : "";
    }

    public static float c(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem >> 20;
    }

    public static String c() {
        String str = Build.BRAND;
        return str != null ? str : "";
    }

    public static float d(Context context) {
        return Environment.getDataDirectory().getTotalSpace() >> 30;
    }

    public static String d() {
        String str = Build.MANUFACTURER;
        return str != null ? str : "";
    }

    public static int e() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static String e(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static int f() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            CLog.c(f2625a, "getAppVersion# ", e2);
            return "";
        }
    }

    public static int g(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
    }

    public static String g() {
        String str = Build.VERSION.RELEASE;
        return str != null ? str : "";
    }

    public static String h() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2.toUpperCase() : str.toUpperCase() + " " + str2;
    }

    public static boolean h(Context context) {
        boolean z = true;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                if (Settings.Global.getInt(context.getContentResolver(), "auto_time_zone") != 1) {
                    z = false;
                }
            } else if (Settings.System.getInt(context.getContentResolver(), "auto_time", 0) != 1) {
                z = false;
            }
            return z;
        } catch (Settings.SettingNotFoundException e2) {
            CLog.d(f2625a, "Auto-Time zone settings not found!");
            return false;
        }
    }

    public static String i() {
        return Locale.getDefault().toString();
    }

    public static String i(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode + "";
        } catch (PackageManager.NameNotFoundException e2) {
            CLog.d(f2625a, "error retreiving gms version!");
            str = "";
        }
        return "" + str;
    }

    public static String j() {
        String displayName = TimeZone.getDefault().getDisplayName(true, 1);
        return displayName != null ? displayName : "";
    }
}
