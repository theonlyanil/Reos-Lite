package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.p;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.aa;

/* JADX INFO: loaded from: classes.dex */
public class e extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoginClient f3940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LoginClient.Request f3941c;

    private void a(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return;
        }
        this.f3939a = callingActivity.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoginClient.Result result) {
        this.f3941c = null;
        int i = result.f3905a == LoginClient.Result.a.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    LoginClient a() {
        return this.f3940b;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f3940b.a(i, i2, intent);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f3940b = (LoginClient) bundle.getParcelable("loginClient");
            this.f3940b.a(this);
        } else {
            this.f3940b = new LoginClient(this);
        }
        this.f3940b.a(new LoginClient.b() { // from class: com.facebook.login.e.1
            @Override // com.facebook.login.LoginClient.b
            public void a(LoginClient.Result result) {
                e.this.a(result);
            }
        });
        p activity = getActivity();
        if (activity == null) {
            return;
        }
        a(activity);
        if (activity.getIntent() != null) {
            this.f3941c = (LoginClient.Request) activity.getIntent().getBundleExtra("com.facebook.LoginFragment:Request").getParcelable("request");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View viewInflate = layoutInflater.inflate(aa.e.com_facebook_login_fragment, viewGroup, false);
        this.f3940b.a(new LoginClient.a() { // from class: com.facebook.login.e.2
            @Override // com.facebook.login.LoginClient.a
            public void a() {
                viewInflate.findViewById(aa.d.com_facebook_login_activity_progress_bar).setVisibility(0);
            }

            @Override // com.facebook.login.LoginClient.a
            public void b() {
                viewInflate.findViewById(aa.d.com_facebook_login_activity_progress_bar).setVisibility(8);
            }
        });
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f3940b.f();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().findViewById(aa.d.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f3939a != null) {
            this.f3940b.a(this.f3941c);
        } else {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.f3940b);
    }
}
