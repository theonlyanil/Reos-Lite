package com.android.library.deviceData;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.deviceData.c.e;
import com.android.library.deviceData.service.DeviceDataPostService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class b implements Config.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f2609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2610b = b.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Config f2611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f2612d;

    private b(Context context) {
        this.f2612d = context;
        this.f2611c = Config.getInstance(context);
        this.f2611c.registerConfigUpdateCallback(this);
        e.i(context);
        CLog.a(f2610b, "DeviceDataExtractor# initialized");
    }

    private synchronized void a(long j) {
        CLog.a(f2610b, String.format("setupAlarm# %s days ", Integer.valueOf(e.a(this.f2612d))));
        PendingIntent service = PendingIntent.getService(this.f2612d, 0, new Intent(this.f2612d, (Class<?>) DeviceDataPostService.class), 268435456);
        AlarmManager alarmManager = (AlarmManager) this.f2612d.getSystemService("alarm");
        CLog.a(f2610b, "setupAlarm# time to trigger intent " + new SimpleDateFormat("dd-MMM-yyy", Locale.getDefault()).format(new Date(j)));
        alarmManager.setInexactRepeating(0, j, 86400000 * ((long) e.a(this.f2612d)), service);
    }

    public static synchronized void init(Context context) {
        if (f2609a == null) {
            f2609a = new b(context);
        }
        if (!e.b(context)) {
            CLog.a(f2610b, "init# data is not sent once");
            context.startService(new Intent(context, (Class<?>) DeviceDataPostService.class));
            f2609a.a(e.h(context));
            CLog.a(f2610b, "init# done!");
        }
    }

    public static synchronized void onBoot(Context context) {
        if (e.a(context, "android.permission.RECEIVE_BOOT_COMPLETED")) {
            if (f2609a == null) {
                f2609a = new b(context);
            }
            CLog.a(f2610b, "onBoot# time to send device-data " + new SimpleDateFormat("dd-MMM-yyy", Locale.getDefault()).format(new Date(e.h(context))));
            f2609a.a(e.h(context));
        }
    }

    @Override // com.android.apps.config.Config.a
    public void onConfigUpdate() {
        e.a(this.f2612d, (c) null);
        CLog.a(f2610b, "onConfigUpdate# ");
        if (e.b(this.f2612d)) {
            a(e.h(this.f2612d));
        }
    }
}
