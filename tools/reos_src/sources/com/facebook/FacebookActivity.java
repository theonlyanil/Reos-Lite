package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

/* JADX INFO: loaded from: classes.dex */
public class FacebookActivity extends android.support.v4.app.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3499a = "PassThrough";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3500b = "SingleFragment";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3501c = FacebookActivity.class.getName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Fragment f3502d;

    private void b() {
        setResult(0, com.facebook.b.y.a(getIntent(), (Bundle) null, com.facebook.b.y.a(com.facebook.b.y.d(getIntent()))));
        finish();
    }

    public Fragment a() {
        return this.f3502d;
    }

    @Override // android.support.v4.app.p, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3502d != null) {
            this.f3502d.onConfigurationChanged(configuration);
        }
    }

    @Override // android.support.v4.app.p, android.support.v4.app.i, android.app.Activity
    public void onCreate(Bundle bundle) {
        Fragment fragment;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!m.a()) {
            Log.d(f3501c, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            m.a(getApplicationContext());
        }
        setContentView(aa.e.com_facebook_activity_layout);
        if (f3499a.equals(intent.getAction())) {
            b();
            return;
        }
        android.support.v4.app.t supportFragmentManager = getSupportFragmentManager();
        Fragment fragmentA = supportFragmentManager.a(f3500b);
        if (fragmentA == null) {
            if ("FacebookDialogFragment".equals(intent.getAction())) {
                fragment = fragmentA;
                com.facebook.b.k kVar = new com.facebook.b.k();
                kVar.setRetainInstance(true);
                kVar.show(supportFragmentManager, f3500b);
                fragment = kVar;
            } else if ("DeviceShareDialogFragment".equals(intent.getAction())) {
                fragment = fragmentA;
                DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
                deviceShareDialogFragment.setRetainInstance(true);
                deviceShareDialogFragment.a((ShareContent) intent.getParcelableExtra("content"));
                deviceShareDialogFragment.show(supportFragmentManager, f3500b);
                fragment = deviceShareDialogFragment;
            } else {
                fragment = fragmentA;
                com.facebook.login.e eVar = new com.facebook.login.e();
                eVar.setRetainInstance(true);
                supportFragmentManager.a().a(aa.d.com_facebook_fragment_container, eVar, f3500b).a();
                fragment = eVar;
            }
        }
        fragment = fragmentA;
        this.f3502d = fragment;
    }
}
