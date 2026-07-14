package com.cube26.iota.smartlite.util;

import android.app.IntentService;
import android.content.Intent;
import com.android.apps.config.util.CLog;

/* JADX INFO: loaded from: classes.dex */
public class DbHelperService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.cube26.iota.smartlite.a.a f3428a;

    public DbHelperService() {
        super("DbHelperService");
        this.f3428a = new com.cube26.iota.smartlite.a.a(this);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("liteAddress");
        String stringExtra2 = intent.getStringExtra("liteName");
        CLog.a("IOTA", " liteaddress :: " + stringExtra + " :: liteName :: " + stringExtra2);
        this.f3428a.a(stringExtra, stringExtra2, "offline");
    }
}
