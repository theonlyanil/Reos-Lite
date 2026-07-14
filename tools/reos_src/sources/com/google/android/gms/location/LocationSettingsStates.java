package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsStates implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzh();
    private final int mVersionCode;
    private final boolean zzaLA;
    private final boolean zzaLv;
    private final boolean zzaLw;
    private final boolean zzaLx;
    private final boolean zzaLy;
    private final boolean zzaLz;

    LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mVersionCode = i;
        this.zzaLv = z;
        this.zzaLw = z2;
        this.zzaLx = z3;
        this.zzaLy = z4;
        this.zzaLz = z5;
        this.zzaLA = z6;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) com.google.android.gms.common.internal.safeparcel.zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isBlePresent() {
        return this.zzaLA;
    }

    public boolean isBleUsable() {
        return this.zzaLx;
    }

    public boolean isGpsPresent() {
        return this.zzaLy;
    }

    public boolean isGpsUsable() {
        return this.zzaLv;
    }

    public boolean isLocationPresent() {
        return this.zzaLy || this.zzaLz;
    }

    public boolean isLocationUsable() {
        return this.zzaLv || this.zzaLw;
    }

    public boolean isNetworkLocationPresent() {
        return this.zzaLz;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzaLw;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
