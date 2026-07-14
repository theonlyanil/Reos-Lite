package com.a.a.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.a f2368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f2371e = new BroadcastReceiver() { // from class: com.a.a.e.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = e.this.f2369c;
            e.this.f2369c = e.this.a(context);
            if (z != e.this.f2369c) {
                e.this.f2368b.a(e.this.f2369c);
            }
        }
    };

    public e(Context context, c.a aVar) {
        this.f2367a = context.getApplicationContext();
        this.f2368b = aVar;
    }

    private void a() {
        if (this.f2370d) {
            return;
        }
        this.f2369c = a(this.f2367a);
        this.f2367a.registerReceiver(this.f2371e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f2370d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void b() {
        if (this.f2370d) {
            this.f2367a.unregisterReceiver(this.f2371e);
            this.f2370d = false;
        }
    }

    @Override // com.a.a.e.h
    public void d() {
        a();
    }

    @Override // com.a.a.e.h
    public void e() {
        b();
    }

    @Override // com.a.a.e.h
    public void f() {
    }
}
