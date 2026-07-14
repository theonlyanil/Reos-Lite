package com.cube26.iota.smartlite.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static void a(Context context, String str, int i) {
        android.support.v4.app.a.a((Activity) context, new String[]{str}, i);
    }

    public static boolean a(Context context, String str) {
        return Build.VERSION.SDK_INT <= 22 || android.support.v4.b.b.a(context, str) == 0;
    }
}
