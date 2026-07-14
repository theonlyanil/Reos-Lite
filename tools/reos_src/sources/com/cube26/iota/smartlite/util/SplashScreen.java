package com.cube26.iota.smartlite.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.cube26.iota.smartlite.MainActivity;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.onboarding.OnBoardingActivity;
import com.google.android.gms.auth.api.credentials.CredentialsApi;

/* JADX INFO: loaded from: classes.dex */
public class SplashScreen extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f3441a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash);
        if (getSharedPreferences("walkthrough_shared_prefs", 0).getBoolean("is_completed", false)) {
            this.f3441a = MainActivity.class;
        } else {
            this.f3441a = OnBoardingActivity.class;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.cube26.iota.smartlite.util.SplashScreen.1
            @Override // java.lang.Runnable
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, (Class<?>) SplashScreen.this.f3441a));
                SplashScreen.this.finish();
            }
        }, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }
}
