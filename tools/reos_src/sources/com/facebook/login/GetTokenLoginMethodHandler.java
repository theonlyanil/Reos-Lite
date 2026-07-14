package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.b.ad;
import com.facebook.b.z;
import com.facebook.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.GetTokenLoginMethodHandler.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            return new GetTokenLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetTokenLoginMethodHandler[] newArray(int i) {
            return new GetTokenLoginMethodHandler[i];
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f3887c;

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // com.facebook.login.LoginMethodHandler
    String a() {
        return "get_token";
    }

    void a(LoginClient.Request request, Bundle bundle) {
        if (this.f3887c != null) {
            this.f3887c.a((z.a) null);
        }
        this.f3887c = null;
        this.f3917b.l();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Set<String> setA = request.a();
            if (stringArrayList != null && (setA == null || stringArrayList.containsAll(setA))) {
                c(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : setA) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                a("new_permissions", TextUtils.join(",", hashSet));
            }
            request.a(hashSet);
        }
        this.f3917b.i();
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean a(final LoginClient.Request request) {
        this.f3887c = new c(this.f3917b.b(), request.d());
        if (!this.f3887c.a()) {
            return false;
        }
        this.f3917b.k();
        this.f3887c.a(new z.a() { // from class: com.facebook.login.GetTokenLoginMethodHandler.1
            @Override // com.facebook.b.z.a
            public void a(Bundle bundle) {
                GetTokenLoginMethodHandler.this.a(request, bundle);
            }
        });
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    void b() {
        if (this.f3887c != null) {
            this.f3887c.b();
            this.f3887c.a((z.a) null);
            this.f3887c = null;
        }
    }

    void b(LoginClient.Request request, Bundle bundle) {
        this.f3917b.a(LoginClient.Result.a(this.f3917b.c(), a(bundle, com.facebook.c.FACEBOOK_APPLICATION_SERVICE, request.d())));
    }

    void c(final LoginClient.Request request, final Bundle bundle) {
        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (string != null && !string.isEmpty()) {
            b(request, bundle);
        } else {
            this.f3917b.k();
            ad.a(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new ad.c() { // from class: com.facebook.login.GetTokenLoginMethodHandler.2
                @Override // com.facebook.b.ad.c
                public void a(k kVar) {
                    GetTokenLoginMethodHandler.this.f3917b.b(LoginClient.Result.a(GetTokenLoginMethodHandler.this.f3917b.c(), "Caught exception", kVar.getMessage()));
                }

                @Override // com.facebook.b.ad.c
                public void a(JSONObject jSONObject) {
                    try {
                        bundle.putString("com.facebook.platform.extra.USER_ID", jSONObject.getString("id"));
                        GetTokenLoginMethodHandler.this.b(request, bundle);
                    } catch (JSONException e2) {
                        GetTokenLoginMethodHandler.this.f3917b.b(LoginClient.Result.a(GetTokenLoginMethodHandler.this.f3917b.c(), "Caught exception", e2.getMessage()));
                    }
                }
            });
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
