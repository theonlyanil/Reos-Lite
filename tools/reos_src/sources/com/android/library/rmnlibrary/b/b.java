package com.android.library.rmnlibrary.b;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a() {
        return com.android.library.deviceData.c.a.h();
    }

    public static String a(Context context) {
        return com.android.library.deviceData.c.b.a(context).a();
    }

    public static String b(Context context) {
        return com.android.library.deviceData.c.b.a(context).b();
    }

    public static final String c(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static final String d(Context context) {
        return com.android.library.deviceData.c.b.a(context).d();
    }

    public static final String e(Context context) {
        return com.android.library.deviceData.c.b.a(context).e();
    }

    public static String f(Context context) {
        return com.android.library.deviceData.c.d.f(context);
    }

    public static final String g(Context context) {
        return com.android.library.deviceData.c.a.f(context);
    }
}
