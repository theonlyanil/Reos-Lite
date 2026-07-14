package com.android.library.rmnlibrary.b;

import android.content.Context;
import com.android.apps.config.Config;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static double a(Context context) {
        return Double.parseDouble(Config.getInstance(context).get("httpLib.resendInDays"));
    }
}
