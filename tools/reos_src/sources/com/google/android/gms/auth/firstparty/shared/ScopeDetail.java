package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScopeDetail implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    String description;
    final int version;
    String zzWR;
    String zzWS;
    String zzWT;
    String zzWU;
    List<String> zzWV;
    public FACLData zzWW;

    ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List<String> list, FACLData fACLData) {
        this.version = i;
        this.description = str;
        this.zzWR = str2;
        this.zzWS = str3;
        this.zzWT = str4;
        this.zzWU = str5;
        this.zzWV = list;
        this.zzWW = fACLData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
