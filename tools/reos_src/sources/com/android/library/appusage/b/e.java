package com.android.library.appusage.b;

import android.content.Context;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import f.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements HTTPLibrary.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2591a = 5678;

    public e(Context context, JSONObject jSONObject) {
        a(context, jSONObject);
    }

    public e(Context context, JSONObject jSONObject, int i) {
        a(context, jSONObject, i);
    }

    private void a(Context context, JSONObject jSONObject) {
        HTTPLibrary.postAnalyticsEvents(context, Config.getInstance(context).get("httpLib.postBaseUrl"), jSONObject, 3, 10);
    }

    private void a(Context context, JSONObject jSONObject, int i) {
        Config config = Config.getInstance(context);
        switch (i) {
            case 101:
                CLog.d(a.f2572b, "Library mode off");
                break;
            case 102:
                HTTPLibrary.postAnalyticsEvents(context, config.get("httpLib.postBaseUrl"), jSONObject, 3, 10);
                break;
            case 103:
                HTTPLibrary.postAnalyticsEventsOnBatch(context, config.get("httpLib.postBaseUrl"), jSONObject, 3, 10);
                break;
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onError(int i, l<com.google.a.l> lVar) {
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onFailure(Throwable th) {
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onSuccess(int i, l<com.google.a.l> lVar) {
    }
}
