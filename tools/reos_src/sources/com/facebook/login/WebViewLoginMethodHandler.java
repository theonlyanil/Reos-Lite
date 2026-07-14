package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.p;
import com.facebook.b.af;
import com.facebook.k;

/* JADX INFO: loaded from: classes.dex */
class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.WebViewLoginMethodHandler.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebViewLoginMethodHandler[] newArray(int i) {
            return new WebViewLoginMethodHandler[i];
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private af f3919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3920d;

    static class a extends af.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3924b;

        public a(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        @Override // com.facebook.b.af.a
        public af a() {
            Bundle bundleE = e();
            bundleE.putString("redirect_uri", "fbconnect://success");
            bundleE.putString("client_id", b());
            bundleE.putString("e2e", this.f3923a);
            bundleE.putString("response_type", "token,signed_request");
            bundleE.putString("return_scopes", "true");
            bundleE.putString("auth_type", "rerequest");
            return new af(c(), "oauth", bundleE, d(), f());
        }

        public a a(String str) {
            this.f3923a = str;
            return this;
        }

        public a a(boolean z) {
            this.f3924b = z;
            return this;
        }
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f3920d = parcel.readString();
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // com.facebook.login.LoginMethodHandler
    String a() {
        return "web_view";
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean a(final LoginClient.Request request) {
        Bundle bundleB = b(request);
        af.c cVar = new af.c() { // from class: com.facebook.login.WebViewLoginMethodHandler.1
            @Override // com.facebook.b.af.c
            public void a(Bundle bundle, k kVar) {
                WebViewLoginMethodHandler.this.b(request, bundle, kVar);
            }
        };
        this.f3920d = LoginClient.m();
        a("e2e", this.f3920d);
        p pVarB = this.f3917b.b();
        this.f3919c = new a(pVarB, request.d(), bundleB).a(this.f3920d).a(request.f()).a(cVar).a();
        com.facebook.b.k kVar = new com.facebook.b.k();
        kVar.setRetainInstance(true);
        kVar.a(this.f3919c);
        kVar.show(pVarB.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    void b() {
        if (this.f3919c != null) {
            this.f3919c.cancel();
            this.f3919c = null;
        }
    }

    void b(LoginClient.Request request, Bundle bundle, k kVar) {
        super.a(request, bundle, kVar);
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean d() {
        return true;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    com.facebook.c d_() {
        return com.facebook.c.WEB_VIEW;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3920d);
    }
}
