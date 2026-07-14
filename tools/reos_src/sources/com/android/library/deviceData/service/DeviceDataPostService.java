package com.android.library.deviceData.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.android.apps.config.util.CLog;
import com.android.library.deviceData.c;
import com.android.library.deviceData.c.e;
import com.android.library.http.HTTPLibrary;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceDataPostService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2644a = DeviceDataPostService.class.getName();

    public DeviceDataPostService() {
        super("DeviceDataPostService");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        String strG = e.g(context);
        CLog.a(f2644a, "Device JSON string: " + e.b(strG));
        if (strG == null || strG.equals("") || strG.equals("{}")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strG);
            CLog.a(f2644a, "JSON to send to server @ " + new SimpleDateFormat("dd-MMM-yyy", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + " " + jSONObject);
            if (e.k(context)) {
                CLog.a(f2644a, "Mode is NOW, sending JSON to server: " + jSONObject);
                HTTPLibrary.postAnalyticsEvents(getApplicationContext(), e.e(context), jSONObject, 5, 10);
            } else if (e.l(context)) {
                CLog.a(f2644a, "Mode is BATCH, sending JSON to server: " + jSONObject);
                HTTPLibrary.postAnalyticsEventsOnBatch(getApplicationContext(), e.e(context), jSONObject, 5, 10);
            } else {
                CLog.d(f2644a, "can't reach this statement");
            }
            e.a(context, System.currentTimeMillis());
            if (e.b(context)) {
                return;
            }
            e.c(context);
        } catch (JSONException e2) {
            CLog.c(f2644a, "postAnalytics# Json error!", e2);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        CLog.a(f2644a, "Called intent service");
        final Context applicationContext = getApplicationContext();
        if (e.j(applicationContext)) {
            CLog.a(f2644a, "Mode is OFF, data note sent");
        } else if (e.i(applicationContext).isEmpty()) {
            e.a(applicationContext, new c() { // from class: com.android.library.deviceData.service.DeviceDataPostService.1
                @Override // com.android.library.deviceData.c
                public void a() {
                    DeviceDataPostService.this.a(applicationContext);
                }
            });
        } else {
            a(applicationContext);
        }
    }
}
