package com.android.library.deviceData.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.android.apps.config.util.CLog;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2632a = c.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f2633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2635d;

    private static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private c() {
    }

    public static boolean a(Context context) {
        return d.b(context) >= 2;
    }

    private static boolean a(Context context, String str, int i) throws a {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            Object objInvoke = Class.forName(telephonyManager.getClass().getName()).getMethod(str, Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
            return objInvoke != null && Integer.parseInt(objInvoke.toString()) == 5;
        } catch (Exception e2) {
            CLog.c(f2632a, "getSIMStateBySlot# ", e2);
            throw new a(str);
        }
    }

    public static c b(Context context) {
        if (f2633b == null) {
            f2633b = new c();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            f2633b.f2634c = telephonyManager.getSimState() == 5;
            f2633b.f2635d = false;
            try {
                f2633b.f2634c = a(context, "getSimStateGemini", 0);
                f2633b.f2635d = a(context, "getSimStateGemini", 1);
            } catch (a e2) {
                CLog.c(f2632a, "getInstance# getSimStateGemini method not found ", e2);
                try {
                    f2633b.f2634c = a(context, "getSimState", 0);
                    f2633b.f2635d = a(context, "getSimState", 1);
                } catch (a e3) {
                    CLog.c(f2632a, "getInstance# getSimState not found", e3);
                }
            }
        }
        return f2633b;
    }

    public boolean a() {
        return this.f2634c;
    }

    public boolean b() {
        return this.f2635d;
    }
}
