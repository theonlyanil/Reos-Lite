package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class LocationAvailability implements SafeParcelable {
    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
    private final int mVersionCode;
    int zzaLg;
    int zzaLh;
    long zzaLi;
    int zzaLj;

    LocationAvailability(int i, int i2, int i3, int i4, long j) {
        this.mVersionCode = i;
        this.zzaLj = i2;
        this.zzaLg = i3;
        this.zzaLh = i4;
        this.zzaLi = j;
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        if (hasLocationAvailability(intent)) {
            return (LocationAvailability) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        }
        return null;
    }

    public static boolean hasLocationAvailability(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.zzaLj == locationAvailability.zzaLj && this.zzaLg == locationAvailability.zzaLg && this.zzaLh == locationAvailability.zzaLh && this.zzaLi == locationAvailability.zzaLi;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaLj), Integer.valueOf(this.zzaLg), Integer.valueOf(this.zzaLh), Long.valueOf(this.zzaLi));
    }

    public boolean isLocationAvailable() {
        return this.zzaLj < 1000;
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LocationAvailabilityCreator.zza(this, parcel, i);
    }
}
