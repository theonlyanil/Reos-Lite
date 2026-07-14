package com.android.library.rmnlibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.library.rmnlibrary.b.f;
import com.android.library.rmnlibrary.b.g;

/* JADX INFO: loaded from: classes.dex */
public class AppInstallListener extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2714a = null;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2714a = context;
        if (intent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_ADDED") || intent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_REPLACED")) {
            Uri data = intent.getData();
            if ((data != null ? data.getSchemeSpecificPart() : null).equals("com.google.android.gms")) {
                g.b("sharedprefs.key.SHARED_PREFS_KEY_GPS_UPDATED", true, context);
                context.startService(f.a(context, RMNRegistrationService.a.MONTH));
            }
        }
    }
}
