package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.b.ad;
import com.facebook.k;
import com.facebook.l;
import com.facebook.m;
import com.facebook.o;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
abstract class WebLoginMethodHandler extends LoginMethodHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3918c;

    WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private void c(String str) {
        this.f3917b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }

    private static final String e() {
        return "fb" + m.i() + "://authorize";
    }

    private String f() {
        return this.f3917b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    protected Bundle a(Bundle bundle, LoginClient.Request request) {
        bundle.putString("redirect_uri", e());
        bundle.putString("client_id", request.d());
        LoginClient loginClient = this.f3917b;
        bundle.putString("e2e", LoginClient.m());
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", "rerequest");
        if (c() != null) {
            bundle.putString("sso", c());
        }
        return bundle;
    }

    protected void a(LoginClient.Request request, Bundle bundle, k kVar) {
        String str;
        LoginClient.Result resultA;
        this.f3918c = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f3918c = bundle.getString("e2e");
            }
            try {
                AccessToken accessTokenA = a(request.a(), bundle, d_(), request.d());
                resultA = LoginClient.Result.a(this.f3917b.c(), accessTokenA);
                CookieSyncManager.createInstance(this.f3917b.b()).sync();
                c(accessTokenA.b());
            } catch (k e2) {
                resultA = LoginClient.Result.a(this.f3917b.c(), null, e2.getMessage());
            }
        } else if (kVar instanceof l) {
            resultA = LoginClient.Result.a(this.f3917b.c(), "User canceled log in.");
        } else {
            this.f3918c = null;
            String message = kVar.getMessage();
            if (kVar instanceof o) {
                FacebookRequestError facebookRequestErrorA = ((o) kVar).a();
                str = String.format(Locale.ROOT, "%d", Integer.valueOf(facebookRequestErrorA.b()));
                message = facebookRequestErrorA.toString();
            } else {
                str = null;
            }
            resultA = LoginClient.Result.a(this.f3917b.c(), null, message, str);
        }
        if (!ad.a(this.f3918c)) {
            b(this.f3918c);
        }
        this.f3917b.a(resultA);
    }

    protected Bundle b(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!ad.a(request.a())) {
            String strJoin = TextUtils.join(",", request.a());
            bundle.putString("scope", strJoin);
            a("scope", strJoin);
        }
        bundle.putString("default_audience", request.c().a());
        bundle.putString("state", a(request.e()));
        AccessToken accessTokenA = AccessToken.a();
        String strB = accessTokenA != null ? accessTokenA.b() : null;
        if (strB == null || !strB.equals(f())) {
            ad.b(this.f3917b.b());
            a("access_token", "0");
        } else {
            bundle.putString("access_token", strB);
            a("access_token", "1");
        }
        return bundle;
    }

    protected String c() {
        return null;
    }

    abstract com.facebook.c d_();
}
