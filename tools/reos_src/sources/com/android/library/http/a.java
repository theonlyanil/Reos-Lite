package com.android.library.http;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.android.apps.config.util.CLog;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AlarmManager f2680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PendingIntent f2681b;

    public void a(Context context, com.android.library.http.a.a.EnumC0048a enumC0048a) {
        this.f2680a = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, (Class<?>) HTTPLibraryAlarmSchedulingService.class);
        CLog.b("HTTPLibrary", "$$$ ALARM RECEIVER MODE " + enumC0048a.toString());
        intent.putExtra("com.android.library.httplibrary.SEND_MODE", enumC0048a);
        this.f2681b = PendingIntent.getService(context, 0, intent, 0);
        if (enumC0048a == com.android.library.http.a.a.EnumC0048a.NORMAL) {
            long millis = TimeUnit.HOURS.toMillis(1L);
            this.f2680a.setInexactRepeating(0, (long) (com.android.library.http.d.a.c(context) * millis), (long) (millis * com.android.library.http.d.a.c(context)), this.f2681b);
            return;
        }
        long millis2 = TimeUnit.MINUTES.toMillis(1L);
        if (Build.VERSION.SDK_INT > 19) {
            this.f2680a.setExact(0, (long) (millis2 * com.android.library.http.d.a.b(context)), this.f2681b);
        } else {
            this.f2680a.set(0, (long) (millis2 * com.android.library.http.d.a.b(context)), this.f2681b);
        }
    }
}
