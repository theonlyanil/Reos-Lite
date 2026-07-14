package com.flurry.sdk;

import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class jm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static jm f4491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4492b = jm.class.getSimpleName();

    private jm() {
    }

    public static synchronized jm a() {
        if (f4491a == null) {
            f4491a = new jm();
        }
        return f4491a;
    }

    public static void b() {
        f4491a = null;
    }

    public String c() {
        TelephonyManager telephonyManager = (TelephonyManager) js.a().c().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public String d() {
        TelephonyManager telephonyManager = (TelephonyManager) js.a().c().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperator();
    }
}
