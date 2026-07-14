package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FacebookSignInOptions implements SafeParcelable {
    public static final Parcelable.Creator<FacebookSignInOptions> CREATOR = new zzb();
    private Intent mIntent;
    final int versionCode;
    private final ArrayList<String> zzVr;

    public FacebookSignInOptions() {
        this(1, null, new ArrayList());
    }

    FacebookSignInOptions(int i, Intent intent, ArrayList<String> arrayList) {
        this.versionCode = i;
        this.mIntent = intent;
        this.zzVr = arrayList;
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.zzVr.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("scopes", jSONArray);
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
        if (obj == null) {
            return false;
        }
        try {
            FacebookSignInOptions facebookSignInOptions = (FacebookSignInOptions) obj;
            return this.zzVr.size() == facebookSignInOptions.zzmu().size() && this.zzVr.containsAll(facebookSignInOptions.zzmu());
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public int hashCode() {
        Collections.sort(this.zzVr);
        return this.zzVr.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzmr() {
        return zzms().toString();
    }

    public Intent zzmt() {
        return this.mIntent;
    }

    public ArrayList<String> zzmu() {
        return new ArrayList<>(this.zzVr);
    }
}
