package com.cube26.iota.smartlite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.android.apps.config.util.CLog;
import com.cube26.iota.smartlite.util.h;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f3031a;

    private boolean a(Context context) {
        return Build.VERSION.SDK_INT <= 22 || context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f3031a = new Intent(context, (Class<?>) AutoScanConnectService.class);
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        if (h.g(context) && a(context)) {
            if (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                CLog.a("IOTA", "No devices found");
                return;
            }
            switch (intExtra) {
                case 10:
                    context.stopService(this.f3031a);
                    break;
                case 12:
                    CLog.a("IOTA", " receiver init");
                    context.startService(this.f3031a);
                    break;
            }
        }
    }
}
