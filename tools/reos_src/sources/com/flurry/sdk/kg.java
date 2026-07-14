package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class kg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f4568a = 4000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4569b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f4570c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4571d = false;

    public static void a() {
        f4569b = true;
    }

    public static void a(int i) {
        f4570c = i;
    }

    public static void a(int i, String str, String str2) {
        c(i, str, str2);
    }

    public static void a(int i, String str, String str2, Throwable th) {
        c(i, str, str2, th);
    }

    public static void a(String str, String str2) {
        b(3, str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        b(6, str, str2, th);
    }

    public static void a(boolean z) {
        f4571d = z;
    }

    public static void b() {
        f4569b = false;
    }

    private static void b(int i, String str, String str2) {
        if (f4569b || f4570c > i) {
            return;
        }
        d(i, str, str2);
    }

    private static void b(int i, String str, String str2, Throwable th) {
        b(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void b(String str, String str2) {
        b(6, str, str2);
    }

    public static int c() {
        return f4570c;
    }

    private static void c(int i, String str, String str2) {
        if (f4571d) {
            d(i, str, str2);
        }
    }

    private static void c(int i, String str, String str2, Throwable th) {
        c(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void c(String str, String str2) {
        b(4, str, str2);
    }

    private static void d(int i, String str, String str2) {
        if (!f4571d) {
            str = "FlurryAgent";
        }
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = f4568a > length - i2 ? length : f4568a + i2;
            if (Log.println(i, str, str2.substring(i2, i3)) <= 0) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static void d(String str, String str2) {
        b(2, str, str2);
    }

    public static boolean d() {
        return f4571d;
    }

    public static void e(String str, String str2) {
        b(5, str, str2);
    }
}
