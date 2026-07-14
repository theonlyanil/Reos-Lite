package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.b.ad;
import com.facebook.k;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
abstract class LoginMethodHandler implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, String> f3916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected LoginClient f3917b;

    LoginMethodHandler(Parcel parcel) {
        this.f3916a = ad.a(parcel);
    }

    LoginMethodHandler(LoginClient loginClient) {
        this.f3917b = loginClient;
    }

    static AccessToken a(Bundle bundle, com.facebook.c cVar, String str) {
        Date dateA = ad.a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        if (ad.a(string)) {
            return null;
        }
        return new AccessToken(string, str, bundle.getString("com.facebook.platform.extra.USER_ID"), stringArrayList, null, cVar, dateA, new Date());
    }

    public static AccessToken a(Collection<String> collection, Bundle bundle, com.facebook.c cVar, String str) throws k {
        Date dateA = ad.a(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("granted_scopes");
        Collection<String> arrayList = !ad.a(string2) ? new ArrayList<>(Arrays.asList(string2.split(","))) : collection;
        String string3 = bundle.getString("denied_scopes");
        ArrayList arrayList2 = !ad.a(string3) ? new ArrayList(Arrays.asList(string3.split(","))) : null;
        if (ad.a(string)) {
            return null;
        }
        return new AccessToken(string, str, c(bundle.getString("signed_request")), arrayList, arrayList2, cVar, dateA, new Date());
    }

    private static String c(String str) throws k {
        if (str == null || str.isEmpty()) {
            throw new k("Authorization response does not contain the signed_request");
        }
        try {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 2) {
                return new JSONObject(new String(Base64.decode(strArrSplit[1], 0), "UTF-8")).getString("user_id");
            }
        } catch (UnsupportedEncodingException e2) {
        } catch (JSONException e3) {
        }
        throw new k("Failed to retrieve user_id from signed_request");
    }

    abstract String a();

    protected String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", a());
            a(jSONObject);
        } catch (JSONException e2) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    void a(LoginClient loginClient) {
        if (this.f3917b != null) {
            throw new k("Can't set LoginClient if it is already set.");
        }
        this.f3917b = loginClient;
    }

    protected void a(String str, Object obj) {
        if (this.f3916a == null) {
            this.f3916a = new HashMap();
        }
        this.f3916a.put(str, obj == null ? null : obj.toString());
    }

    void a(JSONObject jSONObject) throws JSONException {
    }

    boolean a(int i, int i2, Intent intent) {
        return false;
    }

    abstract boolean a(LoginClient.Request request);

    void b() {
    }

    protected void b(String str) {
        String strD = this.f3917b.c().d();
        com.facebook.a.f fVarA = com.facebook.a.f.a(this.f3917b.b(), strD);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", strD);
        fVarA.a("fb_dialogs_web_login_dialog_complete", (Double) null, bundle);
    }

    boolean d() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ad.a(parcel, this.f3916a);
    }
}
