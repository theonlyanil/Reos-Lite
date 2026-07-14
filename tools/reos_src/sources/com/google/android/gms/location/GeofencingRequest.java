package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GeofencingRequest implements SafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int mVersionCode;
    private final List<ParcelableGeofence> zzaKZ;
    private final int zzaLa;

    public static final class Builder {
        private final List<ParcelableGeofence> zzaKZ = new ArrayList();
        private int zzaLa = 5;

        public static int zzhg(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            zzx.zzb(geofence, "geofence can't be null.");
            zzx.zzb(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            this.zzaKZ.add((ParcelableGeofence) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence geofence : list) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            zzx.zzb(!this.zzaKZ.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzaKZ, this.zzaLa);
        }

        public Builder setInitialTrigger(int i) {
            this.zzaLa = zzhg(i);
            return this;
        }
    }

    GeofencingRequest(int i, List<ParcelableGeofence> list, int i2) {
        this.mVersionCode = i;
        this.zzaKZ = list;
        this.zzaLa = i2;
    }

    private GeofencingRequest(List<ParcelableGeofence> list, int i) {
        this(1, list, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzaKZ);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzaLa;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List<ParcelableGeofence> zzxW() {
        return this.zzaKZ;
    }
}
