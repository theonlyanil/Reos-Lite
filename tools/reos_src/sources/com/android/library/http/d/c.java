package com.android.library.http.d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.android.apps.config.util.CLog;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2705a = "(?=\\{)|(?<=\\})";

    public static String a(Context context, String str) {
        String str2;
        String[] strArrSplit = str.split(f2705a);
        int length = strArrSplit.length;
        int i = 0;
        String str3 = "";
        while (i < length) {
            String strB = strArrSplit[i];
            System.out.println(strB);
            switch (strB) {
                case "{MCC}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{MNC}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{GAID}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{ANDID}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{MODEL}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{IP}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{OS}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{API}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{OPERATOR}":
                    str2 = str3 + b(context, strB);
                    break;
                case "{RANDOM}":
                    str2 = str3 + b(context, strB);
                    break;
                default:
                    System.out.println("Default case for url: " + strB);
                    if (strB.startsWith("{") && strB.endsWith("}")) {
                        String strSubstring = strB.substring(1);
                        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - 1);
                        if (strSubstring2.contains("|")) {
                            String[] strArrSplit2 = strSubstring2.split(Pattern.quote("|"));
                            System.out.println("Split values before pipe '|' : " + strArrSplit2[0]);
                            strB = b(context, "{" + strArrSplit2[0] + "}");
                            if (TextUtils.isEmpty(strB) || strB.equals("-1")) {
                                strB = strArrSplit2[1];
                            }
                        }
                    }
                    str2 = str3 + strB;
                    break;
            }
            i++;
            str3 = str2;
        }
        CLog.b("HTTPLibrary", "MACROS_URL " + str3);
        return str3;
    }

    public static boolean a(Context context) {
        if (!b(context)) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    public static boolean a(Context context, com.android.library.http.a.a.EnumC0048a enumC0048a) {
        if (enumC0048a != com.android.library.http.a.a.EnumC0048a.BATCH) {
            return true;
        }
        switch (a.a(context)) {
            case "on":
                return true;
            case "3g+":
                return !e(context) && (f(context) || g(context) || h(context));
            case "4g+":
                return (e(context) || f(context) || (!g(context) && !h(context))) ? false : true;
            case "wifi":
                return (e(context) || g(context) || f(context) || !h(context)) ? false : true;
            default:
                return false;
        }
    }

    public static <T> boolean a(Context context, Class<T> cls) {
        return PendingIntent.getService(context, 0, new Intent(context, (Class<?>) cls), 536870912) != null;
    }

    private static String b(Context context, String str) {
        switch (str) {
            case "{MCC}":
                return com.android.library.deviceData.c.b.a(context).d();
            case "{MNC}":
                return com.android.library.deviceData.c.b.a(context).e();
            case "{GAID}":
                return com.android.library.deviceData.c.e.i(context);
            case "{ANDID}":
                return com.android.library.deviceData.c.a.e(context);
            case "{MODEL}":
                return com.android.library.deviceData.c.a.d() + " " + com.android.library.deviceData.c.a.b();
            case "{IP}":
                return "-1";
            case "{OS}":
                return Build.VERSION.RELEASE;
            case "{API}":
                return String.valueOf(Build.VERSION.SDK_INT);
            case "{OPERATOR}":
                return com.android.library.deviceData.c.b.a(context).g();
            case "{RANDOM}":
                return String.valueOf(System.currentTimeMillis()) + com.android.library.deviceData.c.a.e(context);
            default:
                return "-1";
        }
    }

    public static boolean b(Context context) {
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
            return true;
        }
        CLog.b("HTTPLibrary", "****ACCESS NETWORK STATE PERMISSION NOT ENABLED******");
        return false;
    }

    public static String c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "No internet";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() != 0) {
            return "No internet";
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "No internet";
        }
    }

    private static String d(Context context) {
        return c(context);
    }

    private static boolean e(Context context) {
        return d(context).equalsIgnoreCase("2G");
    }

    private static boolean f(Context context) {
        return d(context).equalsIgnoreCase("3G");
    }

    private static boolean g(Context context) {
        return d(context).equalsIgnoreCase("4G");
    }

    private static boolean h(Context context) {
        return d(context).equalsIgnoreCase("wifi");
    }
}
