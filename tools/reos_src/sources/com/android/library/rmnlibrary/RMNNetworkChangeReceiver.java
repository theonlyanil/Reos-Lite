package com.android.library.rmnlibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.apps.config.util.CLog;
import com.android.library.http.d.c;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.g;

/* JADX INFO: loaded from: classes.dex */
public class RMNNetworkChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CLog.b("RMNLibrary", "Came to RMN network change receiver");
        if (!c.a(context) || g.a("sharedprefs.key.gcmregistered", false, context)) {
            return;
        }
        CLog.b("RMNLibrary", "RMN found network available");
        if (System.currentTimeMillis() - g.a("sharedprefs.key.gcm.lastregtime", 0L, context) > 21600000) {
            CLog.b("RMNLibrary", "Re-registering GCM since retry interval was exceeded.");
            context.startService(f.a(context, RMNRegistrationService.a.SIX_HOURS));
        }
    }
}
