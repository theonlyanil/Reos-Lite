package com.android.library.deviceData.c;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.android.apps.config.util.CLog;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static b k;
    private static final String l = b.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2626a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f2627b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f2628c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f2629d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f2630e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f2631f = "";
    public static String g = "";
    public static String h = "";
    public static String i = "";
    public static String j = "";

    private b(Context context) {
        b(context);
        if (c.a(context)) {
            CLog.a(l, "Dual Sim");
            e(context);
            f(context);
            i(context);
            return;
        }
        CLog.d(l, "Single Sim");
        d(context);
        h(context);
        g(context);
        e(context);
        f(context);
    }

    public static b a(Context context) {
        if (k == null) {
            k = new b(context);
        }
        return k;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    private void b(Context context) {
        List<String> listA = d.a(context);
        if (listA == null || listA.isEmpty()) {
            return;
        }
        i = listA.get(0);
        if (listA.size() >= 2) {
            j = listA.get(1);
        }
    }

    private static boolean c(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() != 1;
    }

    private static void d(Context context) {
        String networkOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (c(context) && (networkOperator = telephonyManager.getNetworkOperator()) != null) {
            try {
                f2626a = String.valueOf(Integer.parseInt(networkOperator.substring(0, 3)));
            } catch (Exception e2) {
                CLog.b(l, "Exception in mcc", e2);
            }
        }
        if (f2626a == null || f2626a.isEmpty()) {
            f2626a = context.getResources().getConfiguration().mcc + "";
        }
    }

    private void e(Context context) {
        GsmCellLocation gsmCellLocation;
        if (!e.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !e.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            f2629d = "-1";
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!c(context) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
            return;
        }
        f2629d = String.valueOf(gsmCellLocation.getCid());
    }

    private void f(Context context) {
        GsmCellLocation gsmCellLocation;
        if (!e.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !e.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            f2628c = "-1";
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!c(context) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
            return;
        }
        f2628c = String.valueOf(gsmCellLocation.getLac());
    }

    private static void g(Context context) {
        String networkOperatorName;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!c(context) || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null) {
            return;
        }
        CLog.a(l, networkOperatorName);
        g = networkOperatorName;
    }

    private static void h(Context context) {
        String networkOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (c(context) && (networkOperator = telephonyManager.getNetworkOperator()) != null) {
            try {
                f2630e = String.valueOf(Integer.parseInt(networkOperator.substring(3)));
            } catch (Exception e2) {
                CLog.a(l, "Exception to get mnc", e2);
            }
        }
        if (f2630e == null || f2630e.isEmpty()) {
            f2630e = context.getResources().getConfiguration().mnc + "";
        }
    }

    private void i(Context context) {
        CLog.d(l, " in getSimInfo");
        if (Build.VERSION.SDK_INT > 21) {
            CLog.d(l, " build > 21");
            try {
                List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList != null) {
                    for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                        if (subscriptionInfo.getSimSlotIndex() == 0) {
                            g = subscriptionInfo.getCarrierName().toString();
                            f2626a = String.valueOf(subscriptionInfo.getMcc());
                            f2630e = String.valueOf(subscriptionInfo.getMnc());
                            CLog.d(l, " sim 1 operator :: " + g + "mcc1: " + f2626a + "mnc: " + f2630e);
                        } else if (subscriptionInfo.getSimSlotIndex() == 1) {
                            h = subscriptionInfo.getCarrierName().toString();
                            f2627b = String.valueOf(subscriptionInfo.getMcc());
                            f2631f = String.valueOf(subscriptionInfo.getMnc());
                            CLog.d(l, " sim 2 operator :: " + h + "mcc2: " + f2627b + "mnc2: " + f2631f);
                        }
                    }
                }
            } catch (Exception e2) {
                CLog.c(l, "setSimInfo# ", e2);
            }
        } else {
            CLog.d(l, " build < 21");
            f2626a = l(context);
            f2627b = m(context);
            f2630e = j(context);
            f2631f = k(context);
            CLog.d(l, " mcc1:  " + f2626a + "mcc2: " + f2627b + "mnc1: " + f2630e + "mnc2: " + f2631f);
        }
        if (f2626a == null || f2626a.isEmpty() || f2626a.equals("-2")) {
            f2626a = context.getResources().getConfiguration().mcc + "";
        }
        if (f2630e == null || f2630e.isEmpty() || f2630e.equals("-2")) {
            f2630e = context.getResources().getConfiguration().mnc + "";
        }
    }

    private static String j(Context context) {
        if (c.b(context).a()) {
            return d.b(context, 0);
        }
        return null;
    }

    private static String k(Context context) {
        if (c.b(context).b()) {
            return d.b(context, 1);
        }
        return null;
    }

    private static String l(Context context) {
        if (c.b(context).a()) {
            return d.a(context, 0);
        }
        return null;
    }

    private static String m(Context context) {
        if (c.b(context).b()) {
            return d.a(context, 1);
        }
        return null;
    }

    public String a() {
        return a(i);
    }

    public String b() {
        return a(j);
    }

    public String c() {
        return a(f2627b);
    }

    public String d() {
        return a(f2626a);
    }

    public String e() {
        return a(f2630e);
    }

    public String f() {
        return a(f2631f);
    }

    public String g() {
        return a(g);
    }

    public String h() {
        return a(h);
    }
}
