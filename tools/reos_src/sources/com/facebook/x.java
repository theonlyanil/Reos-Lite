package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.b.ae;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BroadcastReceiver f4165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.support.v4.b.j f4166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4167c = false;

    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED".equals(intent.getAction())) {
                x.this.a((Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE"), (Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE"));
            }
        }
    }

    public x() {
        ae.a();
        this.f4165a = new a();
        this.f4166b = android.support.v4.b.j.a(m.f());
        a();
    }

    private void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        this.f4166b.a(this.f4165a, intentFilter);
    }

    public void a() {
        if (this.f4167c) {
            return;
        }
        c();
        this.f4167c = true;
    }

    protected abstract void a(Profile profile, Profile profile2);

    public void b() {
        if (this.f4167c) {
            this.f4166b.a(this.f4165a);
            this.f4167c = false;
        }
    }
}
