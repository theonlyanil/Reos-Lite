package com.github.clans.fab;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
final class b {
    static int a(Context context, float f2) {
        return Math.round(context.getResources().getDisplayMetrics().density * f2);
    }

    static boolean a() {
        return Build.VERSION.SDK_INT >= 16;
    }

    static boolean b() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
