package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class PointOfInterest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    private final int mVersionCode;
    public final String name;
    public final LatLng zzaQI;
    public final String zzaQJ;

    PointOfInterest(int i, LatLng latLng, String str, String str2) {
        this.mVersionCode = i;
        this.zzaQI = latLng;
        this.zzaQJ = str;
        this.name = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
