package com.android.library.http.d;

import android.content.Context;
import android.text.TextUtils;
import com.android.apps.config.Config;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        return String.valueOf(Config.getInstance(context).get("httpLib.batchMode"));
    }

    public static double b(Context context) {
        String str = Config.getInstance(context).get("httpLib.batchPeriodInMin");
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        return Double.parseDouble(str);
    }

    public static double c(Context context) {
        String str = Config.getInstance(context).get("httpLib.retryFrequency");
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        return Double.parseDouble(str);
    }
}
