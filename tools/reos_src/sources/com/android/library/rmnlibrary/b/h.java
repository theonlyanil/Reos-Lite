package com.android.library.rmnlibrary.b;

import android.content.Intent;
import android.text.TextUtils;
import com.android.apps.config.util.CLog;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static boolean a(Intent intent, String str) {
        CLog.b("RMNLibrary", "key value " + str);
        if (TextUtils.isEmpty(intent.getAction())) {
            return false;
        }
        return intent.getAction().equalsIgnoreCase(str);
    }

    public static boolean a(String[] strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static String[] a(String str) {
        if (str.contains("|")) {
            return str.split(Pattern.quote("|"));
        }
        return null;
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str);
    }
}
