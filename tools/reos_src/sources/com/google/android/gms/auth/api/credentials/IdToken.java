package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class IdToken implements SafeParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zze();
    final int mVersionCode;
    private final String zzUB;
    private final String zzUN;

    IdToken(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzUB = str;
        this.zzUN = str2;
    }

    public IdToken(String str, String str2) {
        this(1, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountType() {
        return this.zzUB;
    }

    public String getIdToken() {
        return this.zzUN;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
