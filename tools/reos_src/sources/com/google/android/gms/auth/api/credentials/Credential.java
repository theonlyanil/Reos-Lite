package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Credential implements SafeParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    private final String mName;
    final int mVersionCode;
    private final String zzUA;
    private final String zzUB;
    private final String zzUC;
    private final String zzUD;
    private final Uri zzUy;
    private final List<IdToken> zzUz;
    private final String zzxX;

    public static class Builder {
        private String mName;
        private String zzUA;
        private String zzUB;
        private String zzUC;
        private String zzUD;
        private Uri zzUy;
        private List<IdToken> zzUz;
        private final String zzxX;

        public Builder(Credential credential) {
            this.zzxX = credential.zzxX;
            this.mName = credential.mName;
            this.zzUy = credential.zzUy;
            this.zzUz = credential.zzUz;
            this.zzUA = credential.zzUA;
            this.zzUB = credential.zzUB;
            this.zzUC = credential.zzUC;
            this.zzUD = credential.zzUD;
        }

        public Builder(String str) {
            this.zzxX = str;
        }

        public Credential build() {
            return new Credential(3, this.zzxX, this.mName, this.zzUy, this.zzUz, this.zzUA, this.zzUB, this.zzUC, this.zzUD);
        }

        public Builder setAccountType(String str) {
            this.zzUB = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzUA = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzUy = uri;
            return this;
        }
    }

    Credential(int i, String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6) {
        this.mVersionCode = i;
        String strTrim = ((String) zzx.zzb(str, "credential identifier cannot be null")).trim();
        zzx.zzh(strTrim, "credential identifier cannot be empty");
        this.zzxX = strTrim;
        this.mName = str2;
        this.zzUy = uri;
        this.zzUz = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzUA = str3;
        if (str3 != null && str3.isEmpty()) {
            throw new IllegalArgumentException("password cannot be empty");
        }
        if (!TextUtils.isEmpty(str4)) {
            String scheme = Uri.parse(str4).getScheme();
            zzx.zzab("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme));
        }
        this.zzUB = str4;
        this.zzUC = str5;
        this.zzUD = str6;
        if (!TextUtils.isEmpty(this.zzUA) && !TextUtils.isEmpty(this.zzUB)) {
            throw new IllegalStateException("password and accountType cannot both be set");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zzxX, credential.zzxX) && TextUtils.equals(this.mName, credential.mName) && zzw.equal(this.zzUy, credential.zzUy) && TextUtils.equals(this.zzUA, credential.zzUA) && TextUtils.equals(this.zzUB, credential.zzUB) && TextUtils.equals(this.zzUC, credential.zzUC);
    }

    public String getAccountType() {
        return this.zzUB;
    }

    public String getGeneratedPassword() {
        return this.zzUC;
    }

    public String getId() {
        return this.zzxX;
    }

    public List<IdToken> getIdTokens() {
        return this.zzUz;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzUA;
    }

    public Uri getProfilePictureUri() {
        return this.zzUy;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzxX, this.mName, this.zzUy, this.zzUA, this.zzUB, this.zzUC);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzmg() {
        return this.zzUD;
    }
}
