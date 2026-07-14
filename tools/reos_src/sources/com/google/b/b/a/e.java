package com.google.b.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5418a = e.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5419b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f5423f;
    private boolean g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5421d = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BroadcastReceiver f5420c = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f5422e = new Handler();

    private final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z = intent.getIntExtra("plugged", -1) <= 0;
                e.this.f5422e.post(new Runnable() { // from class: com.google.b.b.a.e.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.a(z);
                    }
                });
            }
        }
    }

    public e(Context context, Runnable runnable) {
        this.f5419b = context;
        this.f5423f = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.g = z;
        if (this.f5421d) {
            a();
        }
    }

    private void d() {
        if (this.f5421d) {
            this.f5419b.unregisterReceiver(this.f5420c);
            this.f5421d = false;
        }
    }

    private void e() {
        if (this.f5421d) {
            return;
        }
        this.f5419b.registerReceiver(this.f5420c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f5421d = true;
    }

    private void f() {
        this.f5422e.removeCallbacksAndMessages(null);
    }

    public void a() {
        f();
        if (this.g) {
            this.f5422e.postDelayed(this.f5423f, 300000L);
        }
    }

    public void b() {
        e();
        a();
    }

    public void c() {
        f();
        d();
    }
}
