package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsRequest implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzf();
    private final int mVersionCode;
    private final boolean zzaLr;
    private final boolean zzaLs;
    private final List<LocationRequest> zzayS;

    public static final class Builder {
        private final ArrayList<LocationRequest> zzaLt = new ArrayList<>();
        private boolean zzaLr = false;
        private boolean zzaLs = false;

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.zzaLt.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.zzaLt.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzaLt, this.zzaLr, this.zzaLs);
        }

        public Builder setAlwaysShow(boolean z) {
            this.zzaLr = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.zzaLs = z;
            return this;
        }
    }

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzayS = list;
        this.zzaLr = z;
        this.zzaLs = z2;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2) {
        this(3, list, z, z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public List<LocationRequest> zzux() {
        return Collections.unmodifiableList(this.zzayS);
    }

    public boolean zzxY() {
        return this.zzaLr;
    }

    public boolean zzxZ() {
        return this.zzaLs;
    }
}
