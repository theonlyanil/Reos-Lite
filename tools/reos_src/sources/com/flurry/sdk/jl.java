package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
public class jl extends BroadcastReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static jl f4481c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f4482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f4483b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4484d;

    public enum a {
        NONE_OR_UNKNOWN(0),
        NETWORK_AVAILABLE(1),
        WIFI(2),
        CELL(3);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4490e;

        a(int i) {
            this.f4490e = i;
        }

        public int a() {
            return this.f4490e;
        }
    }

    private jl() {
        this.f4484d = false;
        Context contextC = js.a().c();
        this.f4484d = contextC.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        this.f4483b = a(contextC);
        if (this.f4484d) {
            e();
        }
    }

    public static synchronized jl a() {
        if (f4481c == null) {
            f4481c = new jl();
        }
        return f4481c;
    }

    private boolean a(Context context) {
        if (!this.f4484d || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = g().getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static synchronized void b() {
        if (f4481c != null) {
            f4481c.f();
        }
        f4481c = null;
    }

    private synchronized void e() {
        if (!this.f4482a) {
            Context contextC = js.a().c();
            this.f4483b = a(contextC);
            contextC.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4482a = true;
        }
    }

    private synchronized void f() {
        if (this.f4482a) {
            js.a().c().unregisterReceiver(this);
            this.f4482a = false;
        }
    }

    private ConnectivityManager g() {
        return (ConnectivityManager) js.a().c().getSystemService("connectivity");
    }

    public boolean c() {
        return this.f4483b;
    }

    public a d() {
        if (!this.f4484d) {
            return a.NONE_OR_UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = g().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return a.NONE_OR_UNKNOWN;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                return a.CELL;
            case 1:
                return a.WIFI;
            case 6:
            case 7:
            default:
                return activeNetworkInfo.isConnected() ? a.NETWORK_AVAILABLE : a.NONE_OR_UNKNOWN;
            case 8:
                return a.NONE_OR_UNKNOWN;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean zA = a(context);
        if (this.f4483b != zA) {
            this.f4483b = zA;
            jk jkVar = new jk();
            jkVar.f4479a = zA;
            jkVar.f4480b = d();
            jkVar.b();
        }
    }
}
