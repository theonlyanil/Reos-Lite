package com.android.library.userprofile.util;

import android.content.Context;
import android.util.Log;
import com.android.apps.config.Config;
import com.android.apps.config.util.CLog;
import com.android.library.http.HTTPLibrary;
import f.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UpdateServerWithAnalytics implements HTTPLibrary.b {
    private static final String MODE_BATCH = "BATCH";
    private static final String MODE_REAL = "REAL";
    private static int reqCode = 5678;
    private static int MAX_TRIES = 3;
    private static int TIME_OUT = 30;
    private static String KEY_BASE_URL = "httpLib.postBaseUrl";

    public UpdateServerWithAnalytics(Context context, JSONObject jSONObject) {
        sendJsonToNetworkLibrary(context, jSONObject);
    }

    private void sendJsonToNetworkLibrary(Context context, JSONObject jSONObject) {
        String str = Config.getInstance(context).get(KEY_BASE_URL);
        String modeValueFromConfig = UtilFunctions.getModeValueFromConfig(context);
        if (modeValueFromConfig.equalsIgnoreCase(MODE_REAL)) {
            Log.i("UserProfileTag", "Sending Json in real mode");
            HTTPLibrary.postAnalyticsEvents(context, str, jSONObject, MAX_TRIES, TIME_OUT);
        } else if (!modeValueFromConfig.equalsIgnoreCase(MODE_BATCH)) {
            Log.i("UserProfileTag", "Skipping sending data as mode is neither real nor batch");
        } else {
            Log.i("UserProfileTag", "Sending Json in batch mode");
            HTTPLibrary.postAnalyticsEventsOnBatch(context, str, jSONObject, MAX_TRIES, TIME_OUT);
        }
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onError(int i, l<com.google.a.l> lVar) {
        CLog.b("UserProfileTag", "ERROR in posting to server");
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onFailure(Throwable th) {
        CLog.b("UserProfileTag", "FAILURE posting to server");
    }

    @Override // com.android.library.http.HTTPLibrary.b
    public void onSuccess(int i, l<com.google.a.l> lVar) {
        CLog.b("UserProfileTag", "SUCCESSFULLY posted to server");
    }
}
