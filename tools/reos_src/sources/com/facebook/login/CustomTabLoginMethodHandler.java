package com.facebook.login;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.p;
import com.android.library.userprofile.util.Constants;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookRequestError;
import com.facebook.b.ad;
import com.facebook.b.ae;
import com.facebook.k;
import com.facebook.l;
import com.facebook.m;
import com.facebook.o;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3869e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f3867c = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.CustomTabLoginMethodHandler.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomTabLoginMethodHandler[] newArray(int i) {
            return new CustomTabLoginMethodHandler[i];
        }
    };

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f3869e = parcel.readString();
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.f3869e = ad.a(20);
    }

    private void a(String str, LoginClient.Request request) {
        int i;
        if (str == null || !str.startsWith(CustomTabMainActivity.a())) {
            return;
        }
        Uri uri = Uri.parse(str);
        Bundle bundleC = ad.c(uri.getQuery());
        bundleC.putAll(ad.c(uri.getFragment()));
        if (!a(bundleC)) {
            super.a(request, (Bundle) null, new k("Invalid state parameter"));
            return;
        }
        String string = bundleC.getString("error");
        if (string == null) {
            string = bundleC.getString("error_type");
        }
        String string2 = bundleC.getString("error_msg");
        if (string2 == null) {
            string2 = bundleC.getString("error_message");
        }
        if (string2 == null) {
            string2 = bundleC.getString("error_description");
        }
        String string3 = bundleC.getString(Constants.SMS_COLUMN_ERROR_CODE);
        if (ad.a(string3)) {
            i = -1;
        } else {
            try {
                i = Integer.parseInt(string3);
            } catch (NumberFormatException e2) {
                i = -1;
            }
        }
        if (ad.a(string) && ad.a(string2) && i == -1) {
            super.a(request, bundleC, (k) null);
            return;
        }
        if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
            super.a(request, (Bundle) null, new l());
        } else if (i == 4201) {
            super.a(request, (Bundle) null, new l());
        } else {
            super.a(request, (Bundle) null, new o(new FacebookRequestError(i, string, string2), string2));
        }
    }

    private boolean a(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return new JSONObject(string).getString("7_challenge").equals(this.f3869e);
        } catch (JSONException e2) {
            return false;
        }
    }

    private boolean e() {
        return f() && g() != null && ae.c(m.f());
    }

    private boolean f() {
        ad.b bVarD = ad.d(ad.a(this.f3917b.b()));
        return bVarD != null && bVarD.d();
    }

    private String g() {
        if (this.f3868d != null) {
            return this.f3868d;
        }
        p pVarB = this.f3917b.b();
        List<ResolveInfo> listQueryIntentServices = pVarB.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (listQueryIntentServices != null) {
            HashSet hashSet = new HashSet(Arrays.asList(f3867c));
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo = it.next().serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    this.f3868d = serviceInfo.packageName;
                    return this.f3868d;
                }
            }
        }
        return null;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String a() {
        return "custom_tab";
    }

    @Override // com.facebook.login.LoginMethodHandler
    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("7_challenge", this.f3869e);
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean a(int i, int i2, Intent intent) {
        if (i != 1) {
            return super.a(i, i2, intent);
        }
        LoginClient.Request requestC = this.f3917b.c();
        if (i2 == -1) {
            a(intent.getStringExtra(CustomTabMainActivity.f3494c), requestC);
            return true;
        }
        super.a(requestC, (Bundle) null, new l());
        return false;
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean a(LoginClient.Request request) {
        if (!e()) {
            return false;
        }
        Bundle bundleA = a(b(request), request);
        Intent intent = new Intent(this.f3917b.b(), (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.f3492a, bundleA);
        intent.putExtra(CustomTabMainActivity.f3493b, g());
        this.f3917b.a().startActivityForResult(intent, 1);
        return true;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    protected String c() {
        return "chrome_custom_tab";
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    com.facebook.c d_() {
        return com.facebook.c.CHROME_CUSTOM_TAB;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3869e);
    }
}
