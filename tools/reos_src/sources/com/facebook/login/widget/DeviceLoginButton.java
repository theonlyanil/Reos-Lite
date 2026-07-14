package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.b;
import com.facebook.login.d;
import com.facebook.login.g;

/* JADX INFO: loaded from: classes.dex */
public class DeviceLoginButton extends LoginButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f3961a;

    private class a extends LoginButton.b {
        private a() {
            super();
        }

        @Override // com.facebook.login.widget.LoginButton.b
        protected g a() {
            b bVarA = b.a();
            bVarA.a(DeviceLoginButton.this.getDefaultAudience());
            bVarA.a(d.DEVICE_AUTH);
            bVarA.a(DeviceLoginButton.this.getDeviceRedirectUri());
            return bVarA;
        }
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Uri getDeviceRedirectUri() {
        return this.f3961a;
    }

    @Override // com.facebook.login.widget.LoginButton
    protected LoginButton.b getNewLoginClickListener() {
        return new a();
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.f3961a = uri;
    }
}
