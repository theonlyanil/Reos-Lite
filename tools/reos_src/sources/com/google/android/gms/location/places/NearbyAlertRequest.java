package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class NearbyAlertRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final int mVersionCode;
    private final int zzaKO;

    @Deprecated
    private final PlaceFilter zzaMA;
    private final NearbyAlertFilter zzaMB;
    private final boolean zzaMC;
    private final int zzaMD;
    private final int zzaMz;

    NearbyAlertRequest(int i, int i2, int i3, PlaceFilter placeFilter, NearbyAlertFilter nearbyAlertFilter, boolean z, int i4) {
        this.mVersionCode = i;
        this.zzaKO = i2;
        this.zzaMz = i3;
        this.zzaMC = z;
        if (nearbyAlertFilter != null) {
            this.zzaMB = nearbyAlertFilter;
        } else if (placeFilter == null) {
            this.zzaMB = null;
        } else if (placeFilter.getPlaceIds() != null && !placeFilter.getPlaceIds().isEmpty()) {
            this.zzaMB = NearbyAlertFilter.zzg(placeFilter.getPlaceIds());
        } else if (placeFilter.getPlaceTypes() == null || placeFilter.getPlaceTypes().isEmpty()) {
            this.zzaMB = null;
        } else {
            this.zzaMB = NearbyAlertFilter.zzh(placeFilter.getPlaceTypes());
        }
        this.zzaMA = null;
        this.zzaMD = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertRequest)) {
            return false;
        }
        NearbyAlertRequest nearbyAlertRequest = (NearbyAlertRequest) obj;
        return this.zzaKO == nearbyAlertRequest.zzaKO && this.zzaMz == nearbyAlertRequest.zzaMz && zzw.equal(this.zzaMA, nearbyAlertRequest.zzaMA) && zzw.equal(this.zzaMB, nearbyAlertRequest.zzaMB);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaKO), Integer.valueOf(this.zzaMz));
    }

    public String toString() {
        return zzw.zzx(this).zzg("transitionTypes", Integer.valueOf(this.zzaKO)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzaMz)).zzg("nearbyAlertFilter", this.zzaMB).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }

    public int zzyj() {
        return this.zzaKO;
    }

    public int zzym() {
        return this.zzaMz;
    }

    @Deprecated
    public PlaceFilter zzyn() {
        return null;
    }

    public NearbyAlertFilter zzyo() {
        return this.zzaMB;
    }

    public boolean zzyp() {
        return this.zzaMC;
    }

    public int zzyq() {
        return this.zzaMD;
    }
}
