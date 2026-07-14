package com.cube26.iota.smartlite.util;

import com.android.apps.config.Config;
import com.facebook.m;
import com.flurry.android.FlurryAgent;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationController extends android.support.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ApplicationController f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Config f3413b;

    static {
        android.support.v7.a.h.a(true);
    }

    private void a() {
        this.f3413b.registerConfigUpdateCallback(new Config.a() { // from class: com.cube26.iota.smartlite.util.ApplicationController.1
            @Override // com.android.apps.config.Config.a
            public void onConfigUpdate() {
                h.a.f3473a = ApplicationController.this.f3413b.get("authifyLib.authifyUrl");
                h.b.f3478b = ApplicationController.this.f3413b.get("lite.registrationUrl");
            }
        });
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.f3413b = Config.getInstance(this);
        a();
        m.a(getApplicationContext());
        e.a(getApplicationContext());
        f3412a = this;
        b.a("IOTA", " app on create");
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.setLogEvents(true);
        FlurryAgent.setReportLocation(true);
        FlurryAgent.setLogLevel(2);
        FlurryAgent.setCaptureUncaughtExceptions(true);
        FlurryAgent.init(this, "PPGVV5BXGQFCZNX48WNY");
    }
}
