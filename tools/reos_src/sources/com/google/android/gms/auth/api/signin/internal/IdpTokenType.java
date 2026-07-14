package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class IdpTokenType implements SafeParcelable {
    final int versionCode;
    private final String zzWe;
    public static final IdpTokenType zzWc = new IdpTokenType("accessToken");
    public static final IdpTokenType zzWd = new IdpTokenType("idToken");
    public static final Parcelable.Creator<IdpTokenType> CREATOR = new zzi();

    IdpTokenType(int i, String str) {
        this.versionCode = i;
        this.zzWe = zzx.zzcG(str);
    }

    private IdpTokenType(String str) {
        this(1, str);
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
            return this.zzWe.equals(((IdpTokenType) obj).zzmN());
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public int hashCode() {
        return this.zzWe.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public String zzmN() {
        return this.zzWe;
    }
}
