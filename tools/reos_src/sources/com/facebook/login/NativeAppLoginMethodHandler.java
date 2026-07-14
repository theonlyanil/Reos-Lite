package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.android.library.userprofile.util.Constants;
import com.facebook.b.ab;
import com.facebook.b.ad;
import com.facebook.k;

/* JADX INFO: loaded from: classes.dex */
abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private LoginClient.Result a(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String strA = a(extras);
        String string = extras.getString(Constants.SMS_COLUMN_ERROR_CODE);
        String strB = b(extras);
        String string2 = extras.getString("e2e");
        if (!ad.a(string2)) {
            b(string2);
        }
        if (strA == null && string == null && strB == null) {
            try {
                return LoginClient.Result.a(request, a(request.a(), extras, com.facebook.c.FACEBOOK_APPLICATION_WEB, request.d()));
            } catch (k e2) {
                return LoginClient.Result.a(request, null, e2.getMessage());
            }
        }
        if (ab.f3648a.contains(strA)) {
            return null;
        }
        return ab.f3649b.contains(strA) ? LoginClient.Result.a(request, (String) null) : LoginClient.Result.a(request, strA, strB, string);
    }

    private String a(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString("error_type") : string;
    }

    private LoginClient.Result b(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String strA = a(extras);
        String string = extras.getString(Constants.SMS_COLUMN_ERROR_CODE);
        return "CONNECTION_FAILURE".equals(string) ? LoginClient.Result.a(request, strA, b(extras), string) : LoginClient.Result.a(request, strA);
    }

    private String b(Bundle bundle) {
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString("error_description") : string;
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean a(int i, int i2, Intent intent) {
        LoginClient.Result resultA;
        LoginClient.Request requestC = this.f3917b.c();
        if (intent == null) {
            resultA = LoginClient.Result.a(requestC, "Operation canceled");
        } else if (i2 == 0) {
            resultA = b(requestC, intent);
        } else {
            resultA = i2 != -1 ? LoginClient.Result.a(requestC, "Unexpected resultCode from authorization.", null) : a(requestC, intent);
        }
        if (resultA != null) {
            this.f3917b.a(resultA);
            return true;
        }
        this.f3917b.i();
        return true;
    }

    protected boolean a(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.f3917b.a().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException e2) {
            return false;
        }
    }

    @Override // com.facebook.login.LoginMethodHandler
    abstract boolean a(LoginClient.Request request);
}
