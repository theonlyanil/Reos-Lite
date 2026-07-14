package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SignInAccount implements SafeParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzf();
    final int versionCode;
    private String zzJg;
    private String zzUN;
    private String zzVL;
    private GoogleSignInAccount zzVO;
    private String zzVP;
    private String zzVt;
    private String zzVu;
    private Uri zzVv;

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        this.versionCode = i;
        this.zzVt = zzx.zzh(str3, "Email cannot be empty.");
        this.zzVu = str4;
        this.zzVv = uri;
        this.zzVL = str;
        this.zzUN = str2;
        this.zzVO = googleSignInAccount;
        this.zzJg = zzx.zzcG(str5);
        this.zzVP = str6;
    }

    public static SignInAccount zza(zze zzeVar, String str, String str2, String str3, Uri uri, String str4, String str5) {
        return new SignInAccount(2, zzeVar != null ? zzeVar.zzmC() : null, str, str2, str3, uri, null, str4, str5);
    }

    public static SignInAccount zzbJ(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl", null);
        return zza(zze.zzbI(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString(Scopes.EMAIL), jSONObject.optString("displayName", null), !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).zza(GoogleSignInAccount.zzbE(jSONObject.optString("googleSignInAccount")));
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Scopes.EMAIL, getEmail());
            if (!TextUtils.isEmpty(this.zzVu)) {
                jSONObject.put("displayName", this.zzVu);
            }
            if (this.zzVv != null) {
                jSONObject.put("photoUrl", this.zzVv.toString());
            }
            if (!TextUtils.isEmpty(this.zzVL)) {
                jSONObject.put("providerId", this.zzVL);
            }
            if (!TextUtils.isEmpty(this.zzUN)) {
                jSONObject.put("tokenId", this.zzUN);
            }
            if (this.zzVO != null) {
                jSONObject.put("googleSignInAccount", this.zzVO.zzmr());
            }
            if (!TextUtils.isEmpty(this.zzVP)) {
                jSONObject.put("refreshToken", this.zzVP);
            }
            jSONObject.put("localId", getUserId());
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public String getEmail() {
        return this.zzVt;
    }

    public String getIdToken() {
        return this.zzUN;
    }

    public Uri getPhotoUrl() {
        return this.zzVv;
    }

    public String getUserId() {
        return this.zzJg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public SignInAccount zza(GoogleSignInAccount googleSignInAccount) {
        this.zzVO = googleSignInAccount;
        return this;
    }

    String zzmC() {
        return this.zzVL;
    }

    public GoogleSignInAccount zzmD() {
        return this.zzVO;
    }

    public String zzmE() {
        return this.zzVP;
    }

    public String zzmr() {
        return zzms().toString();
    }
}
