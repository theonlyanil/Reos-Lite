package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EmailSignInOptions implements SafeParcelable {
    public static final Parcelable.Creator<EmailSignInOptions> CREATOR = new zza();
    final int versionCode;
    private final Uri zzVo;
    private String zzVp;
    private Uri zzVq;

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        zzx.zzb(uri, "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.versionCode = i;
        this.zzVo = uri;
        this.zzVp = str;
        this.zzVq = uri2;
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.zzVo.toString());
            if (!TextUtils.isEmpty(this.zzVp)) {
                jSONObject.put("modeQueryName", this.zzVp);
            }
            if (this.zzVq != null) {
                jSONObject.put("tosUrl", this.zzVq.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
                if (this.zzVo.equals(emailSignInOptions.zzmo())) {
                    if (this.zzVq == null) {
                        if (emailSignInOptions.zzmp() == null) {
                            if (TextUtils.isEmpty(this.zzVp) ? this.zzVp.equals(emailSignInOptions.zzmq()) : TextUtils.isEmpty(emailSignInOptions.zzmq())) {
                            }
                        }
                    } else if (this.zzVq.equals(emailSignInOptions.zzmp())) {
                        z = TextUtils.isEmpty(this.zzVp) ? true : true;
                    }
                }
            } catch (ClassCastException e2) {
            }
        }
        return z;
    }

    public int hashCode() {
        return new com.google.android.gms.auth.api.signin.internal.zze().zzo(this.zzVo).zzo(this.zzVq).zzo(this.zzVp).zzmM();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zzmo() {
        return this.zzVo;
    }

    public Uri zzmp() {
        return this.zzVq;
    }

    public String zzmq() {
        return this.zzVp;
    }

    public String zzmr() {
        return zzms().toString();
    }
}
