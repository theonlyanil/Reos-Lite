package com.android.library.appusage.usagetrack;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.android.apps.config.util.CLog;
import com.android.library.appusage.b.d;

/* JADX INFO: loaded from: classes.dex */
public class DCService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2599b;

    public static void a() {
        if (f2599b <= 0) {
            f2599b = 0;
            return;
        }
        f2599b--;
        if (f2599b == 0) {
            f2598a = false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        CLog.b(com.android.library.appusage.b.a.f2572b, "Service started");
        if (intent != null) {
            if (intent.hasExtra("com.android.appusage.intentextra.startingservice")) {
                f2598a = true;
                f2599b++;
            }
            if (f2598a) {
                try {
                    String packageName = ((ActivityManager) getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
                    CLog.b(com.android.library.appusage.b.a.f2572b, "Current package name is : " + packageName);
                    new a(getApplicationContext()).a(getApplicationContext(), packageName);
                } catch (IndexOutOfBoundsException e2) {
                    CLog.d(com.android.library.appusage.b.a.f2572b, "Error fetching current running app");
                }
                new Handler().postDelayed(new Runnable() { // from class: com.android.library.appusage.usagetrack.DCService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DCService.this.startService(new Intent(DCService.this.getApplicationContext(), (Class<?>) DCService.class));
                    }
                }, d.e(getApplicationContext()) * 1000);
            }
        }
        return 1;
    }
}
