package com.android.library.apptrack.a;

import android.content.Context;
import com.android.apps.config.Config;
import com.android.library.http.HTTPLibrary;
import f.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements HTTPLibrary.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2541a = 5678;

    public c(Context context, JSONObject jSONObject) {
        a(context, jSONObject);
    }

    private void a(Context context, JSONObject jSONObject) {
        String str;
        Config config = Config.getInstance(context);
        String str2 = config.get("httpLib.postBaseUrl");
        if (str2 == null || (str = config.get("appTrackLib.mode")) == null || str.equalsIgnoreCase("off")) {
            return;
        }
        if (str.equalsIgnoreCase("batch")) {
            HTTPLibrary.postAnalyticsEventsOnBatch(context, str2, jSONObject, 3, 10);
        } else {
            HTTPLibrary.postAnalyticsEvents(context, str2, jSONObject, 3, 10);
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
