package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class FACLConfig implements SafeParcelable {
    public static final zza CREATOR = new zza();
    final int version;
    boolean zzWH;
    String zzWI;
    boolean zzWJ;
    boolean zzWK;
    boolean zzWL;
    boolean zzWM;

    FACLConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.version = i;
        this.zzWH = z;
        this.zzWI = str;
        this.zzWJ = z2;
        this.zzWK = z3;
        this.zzWL = z4;
        this.zzWM = z5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FACLConfig)) {
            return false;
        }
        FACLConfig fACLConfig = (FACLConfig) obj;
        return this.zzWH == fACLConfig.zzWH && TextUtils.equals(this.zzWI, fACLConfig.zzWI) && this.zzWJ == fACLConfig.zzWJ && this.zzWK == fACLConfig.zzWK && this.zzWL == fACLConfig.zzWL && this.zzWM == fACLConfig.zzWM;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzWH), this.zzWI, Boolean.valueOf(this.zzWJ), Boolean.valueOf(this.zzWK), Boolean.valueOf(this.zzWL), Boolean.valueOf(this.zzWM));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
