package com.facebook.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m extends af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3750a = m.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3751b;

    public m(Context context, String str, String str2) {
        super(context, str);
        b(str2);
    }

    @Override // com.facebook.b.af
    protected Bundle a(String str) {
        Bundle bundleC = ad.c(Uri.parse(str).getQuery());
        String string = bundleC.getString("bridge_args");
        bundleC.remove("bridge_args");
        if (!ad.a(string)) {
            try {
                bundleC.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", e.a(new JSONObject(string)));
            } catch (JSONException e2) {
                ad.a(f3750a, "Unable to parse bridge_args JSON", e2);
            }
        }
        String string2 = bundleC.getString("method_results");
        bundleC.remove("method_results");
        if (!ad.a(string2)) {
            if (ad.a(string2)) {
                string2 = "{}";
            }
            try {
                bundleC.putBundle("com.facebook.platform.protocol.RESULT_ARGS", e.a(new JSONObject(string2)));
            } catch (JSONException e3) {
                ad.a(f3750a, "Unable to parse bridge_args JSON", e3);
            }
        }
        bundleC.remove("version");
        bundleC.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", y.a());
        return bundleC;
    }

    @Override // com.facebook.b.af, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        WebView webViewC = c();
        if (!b() || a() || webViewC == null || !webViewC.isShown()) {
            super.cancel();
        } else {
            if (this.f3751b) {
                return;
            }
            this.f3751b = true;
            webViewC.loadUrl("javascript:(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.b.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.super.cancel();
                }
            }, 1500L);
        }
    }
}
