package com.android.library.appusage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.android.apps.config.Config;
import com.android.library.appusage.b.f;
import com.android.library.appusage.usagetrack.DCService;

/* JADX INFO: loaded from: classes.dex */
public class AppUsage {
    static Context mContext;

    public static void init(Context context) {
        mContext = context;
        f.a(context);
        f.c(context);
        if (Build.VERSION.SDK_INT < 21) {
            f.b(context);
            f.l(context);
        }
        Config.getInstance(context).registerConfigUpdateCallback(new Config.a() { // from class: com.android.library.appusage.AppUsage.1
            @Override // com.android.apps.config.Config.a
            public void onConfigUpdate() {
                AppUsage.onConfigUpdate();
            }
        });
    }

    public static void onBoot(Context context) {
        mContext = context;
        f.d(context);
        f.e(context);
        if (Build.VERSION.SDK_INT < 21) {
            f.b(context);
            f.l(context);
        }
    }

    public static void onConfigUpdate() {
        f.d(mContext);
        f.e(mContext);
        if (Build.VERSION.SDK_INT < 21) {
            f.b(mContext);
            f.l(mContext);
        }
    }

    private static void startServiceToTrackApps(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            context.startService(new Intent(context, (Class<?>) DCService.class));
        }
    }
}
