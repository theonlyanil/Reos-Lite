package com.cube26.iota.smartlite.util;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3457a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f3458b;

    public static int a(String str, String str2) {
        a();
        if (f3457a) {
            return Log.d(str, str2);
        }
        return 0;
    }

    public static b a() {
        if (f3458b == null) {
            f3458b = new b();
            b();
        }
        return f3458b;
    }

    public static int b(String str, String str2) {
        a();
        if (f3457a) {
            return Log.i(str, str2);
        }
        return 0;
    }

    public static void b() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "tajson.txt");
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
                JSONObject jSONObject = new JSONObject(sb.toString());
                if (jSONObject.has("log") ? jSONObject.getBoolean("log") : false) {
                    f3457a = true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
