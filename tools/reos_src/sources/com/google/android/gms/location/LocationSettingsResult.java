package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzTA;
    private final LocationSettingsStates zzaLu;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.mVersionCode = i;
        this.zzTA = status;
        this.zzaLu = locationSettingsStates;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzaLu;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
