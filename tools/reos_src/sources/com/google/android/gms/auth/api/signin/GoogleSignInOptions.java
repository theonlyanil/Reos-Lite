package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptions implements Api.ApiOptions.Optional, SafeParcelable {
    final int versionCode;
    private Account zzSo;
    private boolean zzVD;
    private final boolean zzVE;
    private final boolean zzVF;
    private String zzVG;
    private final ArrayList<Scope> zzVr;
    public static final Scope zzVA = new Scope(Scopes.PROFILE);
    public static final Scope zzVB = new Scope(Scopes.EMAIL);
    public static final Scope zzVC = new Scope("openid");
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzd();

    public static final class Builder {
        private Account zzSo;
        private boolean zzVD;
        private boolean zzVE;
        private boolean zzVF;
        private String zzVG;
        private Set<Scope> zzVH;

        public Builder() {
            this.zzVH = new HashSet();
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.zzVH = new HashSet();
            zzx.zzy(googleSignInOptions);
            this.zzVH = new HashSet(googleSignInOptions.zzVr);
            this.zzVE = googleSignInOptions.zzVE;
            this.zzVF = googleSignInOptions.zzVF;
            this.zzVD = googleSignInOptions.zzVD;
            this.zzVG = googleSignInOptions.zzVG;
            this.zzSo = googleSignInOptions.zzSo;
        }

        private String zzbH(String str) {
            zzx.zzcG(str);
            zzx.zzb(this.zzVG == null || this.zzVG.equals(str), "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            return new GoogleSignInOptions(this.zzVH, this.zzSo, this.zzVD, this.zzVE, this.zzVF, this.zzVG);
        }

        public Builder requestEmail() {
            this.zzVH.add(GoogleSignInOptions.zzVB);
            return this;
        }

        public Builder requestId() {
            this.zzVH.add(GoogleSignInOptions.zzVC);
            return this;
        }

        public Builder requestIdToken(String str) {
            requestId();
            this.zzVD = true;
            this.zzVG = zzbH(str);
            return this;
        }

        public Builder requestProfile() {
            this.zzVH.add(GoogleSignInOptions.zzVA);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.zzVH.add(scope);
            this.zzVH.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.zzVE = true;
            this.zzVG = zzbH(str);
            this.zzVF = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.zzSo = new Account(zzx.zzcG(str), GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str) {
        this.versionCode = i;
        this.zzVr = arrayList;
        this.zzSo = account;
        this.zzVD = z;
        this.zzVE = z2;
        this.zzVF = z3;
        this.zzVG = str;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str) {
        this(1, (ArrayList<Scope>) new ArrayList(set), account, z, z2, z3, str);
    }

    public static GoogleSignInOptions zzbG(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(strOptString) ? new Account(strOptString, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE) : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null));
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Scope> it = this.zzVr.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzoM());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzSo != null) {
                jSONObject.put("accountName", this.zzSo.name);
            }
            jSONObject.put("idTokenRequested", this.zzVD);
            jSONObject.put("forceCodeForRefreshToken", this.zzVF);
            jSONObject.put("serverAuthRequested", this.zzVE);
            if (!TextUtils.isEmpty(this.zzVG)) {
                jSONObject.put("serverClientId", this.zzVG);
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
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzVr.size() != googleSignInOptions.zzmu().size() || !this.zzVr.containsAll(googleSignInOptions.zzmu())) {
                return false;
            }
            if (this.zzSo == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.zzSo.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzVG)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzmB())) {
                    return false;
                }
            } else if (!this.zzVG.equals(googleSignInOptions.zzmB())) {
                return false;
            }
            return this.zzVF == googleSignInOptions.zzmA() && this.zzVD == googleSignInOptions.zzmy() && this.zzVE == googleSignInOptions.zzmz();
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Account getAccount() {
        return this.zzSo;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.zzVr.toArray(new Scope[this.zzVr.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.zzVr.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzoM());
        }
        Collections.sort(arrayList);
        return new com.google.android.gms.auth.api.signin.internal.zze().zzo(arrayList).zzo(this.zzSo).zzo(this.zzVG).zzP(this.zzVF).zzP(this.zzVD).zzP(this.zzVE).zzmM();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public boolean zzmA() {
        return this.zzVF;
    }

    public String zzmB() {
        return this.zzVG;
    }

    public String zzmr() {
        return zzms().toString();
    }

    public ArrayList<Scope> zzmu() {
        return new ArrayList<>(this.zzVr);
    }

    public boolean zzmy() {
        return this.zzVD;
    }

    public boolean zzmz() {
        return this.zzVE;
    }
}
