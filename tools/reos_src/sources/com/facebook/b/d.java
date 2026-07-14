package com.facebook.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f3722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f3723b;

    private d(Context context) {
        this.f3723b = context.getApplicationContext();
    }

    public static d a(Context context) {
        if (f3722a != null) {
            return f3722a;
        }
        f3722a = new d(context);
        f3722a.a();
        return f3722a;
    }

    private void a() {
        android.support.v4.b.j.a(this.f3723b).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    private void b() {
        android.support.v4.b.j.a(this.f3723b).a(this);
    }

    protected void finalize() throws Throwable {
        try {
            b();
        } finally {
            super.finalize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.facebook.a.f fVarA = com.facebook.a.f.a(context);
        String str = "bf_" + intent.getStringExtra("event_name");
        Bundle bundleExtra = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        for (String str2 : bundleExtra.keySet()) {
            bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
        }
        fVarA.a(str, bundle);
    }
}
