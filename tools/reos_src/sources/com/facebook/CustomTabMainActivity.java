package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabMainActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3492a = CustomTabMainActivity.class.getSimpleName() + ".extra_params";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3493b = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3494c = CustomTabMainActivity.class.getSimpleName() + ".extra_url";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3495d = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3496e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f3497f;

    public static final String a() {
        return "fb" + m.i() + "://authorize";
    }

    private void a(int i, Intent intent) {
        android.support.v4.b.j.a(this).a(this.f3497f);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CustomTabActivity.f3488a.equals(getIntent().getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(f3492a);
            new com.facebook.b.g("oauth", bundleExtra).a(this, getIntent().getStringExtra(f3493b));
            this.f3496e = false;
            this.f3497f = new BroadcastReceiver() { // from class: com.facebook.CustomTabMainActivity.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Intent intent2 = new Intent(CustomTabMainActivity.this, (Class<?>) CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.f3495d);
                    intent2.putExtra(CustomTabMainActivity.f3494c, intent.getStringExtra(CustomTabMainActivity.f3494c));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity.this.startActivity(intent2);
                }
            };
            android.support.v4.b.j.a(this).a(this.f3497f, new IntentFilter(CustomTabActivity.f3488a));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (f3495d.equals(intent.getAction())) {
            android.support.v4.b.j.a(this).a(new Intent(CustomTabActivity.f3489b));
            a(-1, intent);
        } else if (CustomTabActivity.f3488a.equals(intent.getAction())) {
            a(-1, intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f3496e) {
            a(0, null);
        }
        this.f3496e = true;
    }
}
