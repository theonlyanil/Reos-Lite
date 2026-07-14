package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.b.ae;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BroadcastReceiver f3853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.support.v4.b.j f3854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3855c = false;

    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
                d.this.a((AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN"), (AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN"));
            }
        }
    }

    public d() {
        ae.a();
        this.f3853a = new a();
        this.f3854b = android.support.v4.b.j.a(m.f());
        a();
    }

    private void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.f3854b.a(this.f3853a, intentFilter);
    }

    public void a() {
        if (this.f3855c) {
            return;
        }
        d();
        this.f3855c = true;
    }

    protected abstract void a(AccessToken accessToken, AccessToken accessToken2);

    public void b() {
        if (this.f3855c) {
            this.f3854b.a(this.f3853a);
            this.f3855c = false;
        }
    }

    public boolean c() {
        return this.f3855c;
    }
}
