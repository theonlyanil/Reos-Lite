package com.android.library.rmnlibrary;

import android.content.Intent;
import com.android.apps.config.util.CLog;
import com.android.library.rmnlibrary.b.g;
import com.google.android.gms.iid.InstanceIDListenerService;

/* JADX INFO: loaded from: classes.dex */
public class GCMInstanceIDListenerService extends InstanceIDListenerService {
    @Override // com.google.android.gms.iid.InstanceIDListenerService
    public void onTokenRefresh() {
        g.d(this);
        CLog.b("RMNLibrary", "GCM TOKEN REFRESHED");
        Intent intent = new Intent(this, (Class<?>) RMNRegistrationService.class);
        intent.putExtra("TokenRefresh", true);
        intent.setAction("com.android.library.rmnlibrary.tokenrefresh");
        startService(intent);
    }
}
