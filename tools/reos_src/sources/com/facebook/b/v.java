package com.facebook.b;

import android.util.Log;
import com.android.library.userprofile.util.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f3817a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.facebook.u f3818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private StringBuilder f3820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3821e = 3;

    public v(com.facebook.u uVar, String str) {
        ae.a(str, Constants.SMS_COLUMN_TAG);
        this.f3818b = uVar;
        this.f3819c = "FacebookSDK." + str;
        this.f3820d = new StringBuilder();
    }

    public static void a(com.facebook.u uVar, int i, String str, String str2) {
        if (com.facebook.m.a(uVar)) {
            String strD = d(str2);
            if (!str.startsWith("FacebookSDK.")) {
                str = "FacebookSDK." + str;
            }
            Log.println(i, str, strD);
            if (uVar == com.facebook.u.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    public static void a(com.facebook.u uVar, int i, String str, String str2, Object... objArr) {
        if (com.facebook.m.a(uVar)) {
            a(uVar, i, str, String.format(str2, objArr));
        }
    }

    public static void a(com.facebook.u uVar, String str, String str2) {
        a(uVar, 3, str, str2);
    }

    public static void a(com.facebook.u uVar, String str, String str2, Object... objArr) {
        if (com.facebook.m.a(uVar)) {
            a(uVar, 3, str, String.format(str2, objArr));
        }
    }

    public static synchronized void a(String str) {
        if (!com.facebook.m.a(com.facebook.u.INCLUDE_ACCESS_TOKENS)) {
            a(str, "ACCESS_TOKEN_REMOVED");
        }
    }

    public static synchronized void a(String str, String str2) {
        f3817a.put(str, str2);
    }

    private boolean b() {
        return com.facebook.m.a(this.f3818b);
    }

    private static synchronized String d(String str) {
        for (Map.Entry<String, String> entry : f3817a.entrySet()) {
            str = str.replace(entry.getKey(), entry.getValue());
        }
        return str;
    }

    public void a() {
        b(this.f3820d.toString());
        this.f3820d = new StringBuilder();
    }

    public void a(String str, Object obj) {
        a("  %s:\t%s\n", str, obj);
    }

    public void a(String str, Object... objArr) {
        if (b()) {
            this.f3820d.append(String.format(str, objArr));
        }
    }

    public void b(String str) {
        a(this.f3818b, this.f3821e, this.f3819c, str);
    }

    public void c(String str) {
        if (b()) {
            this.f3820d.append(str);
        }
    }
}
