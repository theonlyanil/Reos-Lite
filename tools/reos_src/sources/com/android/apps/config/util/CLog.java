package com.android.apps.config.util;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2534b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f2535c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f2538f;

    public static int a(String str, String str2) {
        if (!f2534b) {
            return 0;
        }
        a(new Throwable().getStackTrace());
        return Log.d(str, b(str2));
    }

    public static int a(String str, String str2, Throwable th) {
        if (!f2534b) {
            return 0;
        }
        a(new Throwable().getStackTrace());
        return Log.d(str, b(str2), th);
    }

    public static void a(String str) {
        if (f2533a) {
            return;
        }
        try {
            f2535c = str;
            File file = new File(Environment.getExternalStorageDirectory() + "/" + str, "testConfig.json");
            if (file.exists()) {
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                }
                bufferedReader.close();
                JSONObject jSONObject = new JSONObject(String.valueOf(sb));
                if (jSONObject.has("configLib") && jSONObject.getJSONObject("configLib").getJSONObject("log").getBoolean("value")) {
                    f2534b = true;
                }
                f2533a = true;
            }
        } catch (Exception e2) {
            f2533a = false;
            if (e2 instanceof FileNotFoundException) {
                return;
            }
            e2.printStackTrace();
        }
    }

    private static void a(StackTraceElement[] stackTraceElementArr) {
        f2536d = stackTraceElementArr[1].getFileName();
        f2537e = stackTraceElementArr[1].getMethodName();
        f2538f = stackTraceElementArr[1].getLineNumber();
    }

    public static int b(String str, String str2) {
        if (f2534b) {
            return Log.i(str, b(str2));
        }
        return 0;
    }

    public static int b(String str, String str2, Throwable th) {
        if (!f2534b) {
            return 0;
        }
        a(new Throwable().getStackTrace());
        return Log.i(str, b(str2), th);
    }

    private static String b(String str) {
        return "[" + f2537e + ":" + f2538f + "]" + str;
    }

    public static int c(String str, String str2) {
        if (!f2534b) {
            return 0;
        }
        a(new Throwable().getStackTrace());
        return Log.w(str, b(str2));
    }

    public static int c(String str, String str2, Throwable th) {
        if (!f2534b) {
            return 0;
        }
        a(new Throwable().getStackTrace());
        return Log.e(str, b(str2), th);
    }

    public static int d(String str, String str2) {
        if (!f2534b) {
            return 0;
        }
        a(new Throwable().getStackTrace());
        return Log.e(str, b(str2));
    }

    public static int e(String str, String str2) {
        if (!f2534b) {
            return 0;
        }
        a(new Throwable().getStackTrace());
        return Log.wtf(str, b(str2));
    }
}
