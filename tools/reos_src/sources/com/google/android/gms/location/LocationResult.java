package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LocationResult implements SafeParcelable {
    private final int mVersionCode;
    private final List<Location> zzaLq;
    static final List<Location> zzaLp = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zze();

    LocationResult(int i, List<Location> list) {
        this.mVersionCode = i;
        this.zzaLq = list;
    }

    public static LocationResult create(List<Location> list) {
        if (list == null) {
            list = zzaLp;
        }
        return new LocationResult(2, list);
    }

    public static LocationResult extractResult(Intent intent) {
        if (hasResult(intent)) {
            return (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
        }
        return null;
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.zzaLq.size() != this.zzaLq.size()) {
            return false;
        }
        Iterator<Location> it = locationResult.zzaLq.iterator();
        Iterator<Location> it2 = this.zzaLq.iterator();
        while (it.hasNext()) {
            if (it2.next().getTime() != it.next().getTime()) {
                return false;
            }
        }
        return true;
    }

    public Location getLastLocation() {
        int size = this.zzaLq.size();
        if (size == 0) {
            return null;
        }
        return this.zzaLq.get(size - 1);
    }

    public List<Location> getLocations() {
        return this.zzaLq;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        int i = 17;
        Iterator<Location> it = this.zzaLq.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long time = it.next().getTime();
            i = ((int) (time ^ (time >>> 32))) + (i2 * 31);
        }
    }

    public String toString() {
        return "LocationResult[locations: " + this.zzaLq + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
