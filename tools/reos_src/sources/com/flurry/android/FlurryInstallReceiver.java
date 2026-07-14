package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.flurry.sdk.hm;
import com.flurry.sdk.kg;
import com.flurry.sdk.lt;

/* JADX INFO: loaded from: classes.dex */
public final class FlurryInstallReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f4189a = FlurryInstallReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        kg.a(4, f4189a, "Received an Install nofication of " + intent.getAction());
        String string = intent.getExtras().getString("referrer");
        kg.a(4, f4189a, "Received an Install referrer of " + string);
        if (string == null || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            kg.a(5, f4189a, "referrer is null");
            return;
        }
        if (!string.contains("=")) {
            kg.a(4, f4189a, "referrer is before decoding: " + string);
            string = lt.d(string);
            kg.a(4, f4189a, "referrer is: " + string);
        }
        new hm(context).a(string);
    }
}
