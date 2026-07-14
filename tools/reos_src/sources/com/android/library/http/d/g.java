package com.android.library.http.d;

import android.text.TextUtils;
import android.webkit.URLUtil;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(String str) {
        return str.endsWith("/") ? str : str + "/";
    }

    public static String b(String str) {
        return !str.startsWith("/") ? str : str.substring(1);
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean d(String str) {
        return str != null;
    }

    public static boolean e(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public static boolean f(String str) {
        return URLUtil.isHttpsUrl(str);
    }
}
