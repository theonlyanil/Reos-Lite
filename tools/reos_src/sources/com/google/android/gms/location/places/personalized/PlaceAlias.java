package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class PlaceAlias implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public static final PlaceAlias zzaOr = new PlaceAlias(0, "Home");
    public static final PlaceAlias zzaOs = new PlaceAlias(0, "Work");
    final int mVersionCode;
    private final String zzaOt;

    PlaceAlias(int i, String str) {
        this.mVersionCode = i;
        this.zzaOt = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlaceAlias) {
            return zzw.equal(this.zzaOt, ((PlaceAlias) obj).zzaOt);
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaOt);
    }

    public String toString() {
        return zzw.zzx(this).zzg("alias", this.zzaOt).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public String zzyO() {
        return this.zzaOt;
    }
}
