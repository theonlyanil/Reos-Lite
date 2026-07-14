package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class FACLData implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int version;
    FACLConfig zzWN;
    String zzWO;
    boolean zzWP;
    String zzWQ;

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.version = i;
        this.zzWN = fACLConfig;
        this.zzWO = str;
        this.zzWP = z;
        this.zzWQ = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
