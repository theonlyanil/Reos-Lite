package com.android.library.appusage.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.library.appusage.b.d;
import com.android.library.appusage.usagetrack.DCService;

/* JADX INFO: loaded from: classes.dex */
public class UsageTrackReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("com.android.appusage.intentextra.usage").equals("com.android.appusage.usagetrack.start")) {
            d.c(context);
        }
        if (intent.getStringExtra("com.android.appusage.intentextra.usage").equals("com.android.appusage.usagetrack.stop") && d.a((Class<?>) DCService.class, context)) {
            DCService.a();
        }
    }
}
