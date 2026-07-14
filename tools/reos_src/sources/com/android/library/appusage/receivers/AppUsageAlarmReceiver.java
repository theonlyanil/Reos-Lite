package com.android.library.appusage.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.apps.config.util.CLog;
import com.android.library.appusage.a.c;
import com.android.library.appusage.b.a;
import com.android.library.appusage.b.b;
import com.android.library.appusage.b.d;
import com.android.library.appusage.b.e;
import com.android.library.appusage.b.f;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppUsageAlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CLog.a(a.f2571a, "Alarm received for " + intent.getStringExtra("AlarmType"));
        if (intent.getStringExtra("AlarmType").equals("AlarmTypeInstalledApps")) {
            if (!f.n(context)) {
                return;
            }
            new ArrayList();
            ArrayList<String> arrayListC = b.c(context);
            if (arrayListC.size() > 0) {
                JSONObject jSONObjectA = b.a(arrayListC, context);
                for (int i = 0; i <= jSONObjectA.toString().length() / 1000; i++) {
                    int i2 = i * 1000;
                    int length = (i + 1) * 1000;
                    if (length > jSONObjectA.toString().length()) {
                        length = jSONObjectA.toString().length();
                    }
                    CLog.a(a.f2571a, jSONObjectA.toString().substring(i2, length));
                }
                new e(context, jSONObjectA, f.o(context));
            } else {
                CLog.a(a.f2571a, "app list size is zero, so not sending any data.");
            }
        }
        if (intent.getStringExtra("AlarmType").equals("AlarmTypeSessionLength")) {
            if (!f.n(context)) {
                return;
            }
            new ArrayList();
            ArrayList<c> arrayListB = com.android.library.appusage.b.c.b(context);
            if (arrayListB.size() > 0) {
                JSONObject jSONObjectA2 = com.android.library.appusage.b.c.a(arrayListB, context);
                for (int i3 = 0; i3 <= jSONObjectA2.toString().length() / 1000; i3++) {
                    int i4 = i3 * 1000;
                    int length2 = (i3 + 1) * 1000;
                    if (length2 > jSONObjectA2.toString().length()) {
                        length2 = jSONObjectA2.toString().length();
                    }
                    CLog.a(a.f2571a, jSONObjectA2.toString().substring(i4, length2));
                }
                new e(context, jSONObjectA2, f.o(context));
            } else {
                CLog.a(a.f2571a, "session length list is zero, may be due to permissions, so not sending any data.");
            }
        }
        if (intent.getStringExtra("AlarmType").equals("AlarmTypeTrackApps")) {
            com.android.library.appusage.usagetrack.a aVar = new com.android.library.appusage.usagetrack.a(context);
            JSONObject jSONObjectA3 = d.a(d.b(aVar.a(context), context), context);
            CLog.b(a.f2572b, "JSON being posted to server : " + jSONObjectA3.toString());
            new e(context, jSONObjectA3);
            if (d.a(context)) {
                CLog.b(a.f2572b, "Cleared DB of track events");
                aVar.b(context);
            }
        }
    }
}
