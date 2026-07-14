package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final int mVersionCode;
    private String zzaZb;
    private String zzaZc;

    public PlusCommonExtras() {
        this.mVersionCode = 1;
        this.zzaZb = "";
        this.zzaZc = "";
    }

    PlusCommonExtras(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzaZb = str;
        this.zzaZc = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.mVersionCode == plusCommonExtras.mVersionCode && zzw.equal(this.zzaZb, plusCommonExtras.zzaZb) && zzw.equal(this.zzaZc, plusCommonExtras.zzaZc);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzaZb, this.zzaZc);
    }

    public String toString() {
        return zzw.zzx(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzaZb).zzg("ClientCallingPackage", this.zzaZc).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String zzDg() {
        return this.zzaZb;
    }

    public String zzDh() {
        return this.zzaZc;
    }

    public void zzG(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", com.google.android.gms.common.internal.safeparcel.zzc.zza(this));
    }
}
