package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.library.userprofile.util.Constants;
import com.facebook.b.ad;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class FacebookRequestError implements Parcelable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3508f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final JSONObject k;
    private final JSONObject l;
    private final Object m;
    private final HttpURLConnection n;
    private final k o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f3503a = new b(200, 299);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() { // from class: com.facebook.FacebookRequestError.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    };

    public enum a {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3514b;

        private b(int i, int i2) {
            this.f3513a = i;
            this.f3514b = i2;
        }

        boolean a(int i) {
            return this.f3513a <= i && i <= this.f3514b;
        }
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, k kVar) {
        this.f3505c = i;
        this.f3506d = i2;
        this.f3507e = i3;
        this.f3508f = str;
        this.g = str2;
        this.l = jSONObject;
        this.k = jSONObject2;
        this.m = obj;
        this.n = httpURLConnection;
        this.h = str3;
        this.i = str4;
        boolean z2 = false;
        if (kVar != null) {
            this.o = kVar;
            z2 = true;
        } else {
            this.o = new o(this, str2);
        }
        com.facebook.b.l lVarG = g();
        this.f3504b = z2 ? a.OTHER : lVarG.a(i2, i3, z);
        this.j = lVarG.a(this.f3504b);
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, exc instanceof k ? (k) exc : new k(exc));
    }

    static FacebookRequestError a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        try {
            if (jSONObject.has("code")) {
                int i = jSONObject.getInt("code");
                Object objA = ad.a(jSONObject, Constants.SMS_COLUMN_BODY, "FACEBOOK_NON_JSON_RESULT");
                if (objA != null && (objA instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) objA;
                    String strOptString = null;
                    String strOptString2 = null;
                    String strOptString3 = null;
                    String strOptString4 = null;
                    boolean zOptBoolean = false;
                    int iOptInt = -1;
                    int iOptInt2 = -1;
                    boolean z = false;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) ad.a(jSONObject2, "error", (String) null);
                        strOptString = jSONObject3.optString(Constants.SMS_COLUMN_TYPE, null);
                        strOptString2 = jSONObject3.optString("message", null);
                        iOptInt = jSONObject3.optInt("code", -1);
                        iOptInt2 = jSONObject3.optInt("error_subcode", -1);
                        strOptString3 = jSONObject3.optString("error_user_msg", null);
                        strOptString4 = jSONObject3.optString("error_user_title", null);
                        zOptBoolean = jSONObject3.optBoolean("is_transient", false);
                        z = true;
                    } else if (jSONObject2.has(Constants.SMS_COLUMN_ERROR_CODE) || jSONObject2.has("error_msg") || jSONObject2.has("error_reason")) {
                        strOptString = jSONObject2.optString("error_reason", null);
                        strOptString2 = jSONObject2.optString("error_msg", null);
                        iOptInt = jSONObject2.optInt(Constants.SMS_COLUMN_ERROR_CODE, -1);
                        iOptInt2 = jSONObject2.optInt("error_subcode", -1);
                        z = true;
                    }
                    if (z) {
                        return new FacebookRequestError(i, iOptInt, iOptInt2, strOptString, strOptString2, strOptString4, strOptString3, zOptBoolean, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    }
                }
                if (!f3503a.a(i)) {
                    return new FacebookRequestError(i, -1, -1, null, null, null, null, false, jSONObject.has(Constants.SMS_COLUMN_BODY) ? (JSONObject) ad.a(jSONObject, Constants.SMS_COLUMN_BODY, "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException e2) {
        }
        return null;
    }

    static synchronized com.facebook.b.l g() {
        ad.b bVarD;
        bVarD = ad.d(m.i());
        return bVarD == null ? com.facebook.b.l.a() : bVarD.f();
    }

    public int a() {
        return this.f3505c;
    }

    public int b() {
        return this.f3506d;
    }

    public int c() {
        return this.f3507e;
    }

    public String d() {
        return this.f3508f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.g != null ? this.g : this.o.getLocalizedMessage();
    }

    public k f() {
        return this.o;
    }

    public String toString() {
        return "{HttpStatus: " + this.f3505c + ", errorCode: " + this.f3506d + ", errorType: " + this.f3508f + ", errorMessage: " + e() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3505c);
        parcel.writeInt(this.f3506d);
        parcel.writeInt(this.f3507e);
        parcel.writeString(this.f3508f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
    }
}
