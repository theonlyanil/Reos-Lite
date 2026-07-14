package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double zzaQw = Double.POSITIVE_INFINITY;
        private double zzaQx = Double.NEGATIVE_INFINITY;
        private double zzaQy = Double.NaN;
        private double zzaQz = Double.NaN;

        private boolean zzj(double d2) {
            if (this.zzaQy <= this.zzaQz) {
                return this.zzaQy <= d2 && d2 <= this.zzaQz;
            }
            return this.zzaQy <= d2 || d2 <= this.zzaQz;
        }

        public LatLngBounds build() {
            zzx.zza(!Double.isNaN(this.zzaQy), "no included points");
            return new LatLngBounds(new LatLng(this.zzaQw, this.zzaQy), new LatLng(this.zzaQx, this.zzaQz));
        }

        public Builder include(LatLng latLng) {
            this.zzaQw = Math.min(this.zzaQw, latLng.latitude);
            this.zzaQx = Math.max(this.zzaQx, latLng.latitude);
            double d2 = latLng.longitude;
            if (Double.isNaN(this.zzaQy)) {
                this.zzaQy = d2;
                this.zzaQz = d2;
            } else if (!zzj(d2)) {
                if (LatLngBounds.zzb(this.zzaQy, d2) < LatLngBounds.zzc(this.zzaQz, d2)) {
                    this.zzaQy = d2;
                } else {
                    this.zzaQz = d2;
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        zzx.zzb(latLng, "null southwest");
        zzx.zzb(latLng2, "null northeast");
        zzx.zzb(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.mVersionCode = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double zzb(double d2, double d3) {
        return ((d2 - d3) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double zzc(double d2, double d3) {
        return ((d3 - d2) + 360.0d) % 360.0d;
    }

    private boolean zzi(double d2) {
        return this.southwest.latitude <= d2 && d2 <= this.northeast.latitude;
    }

    private boolean zzj(double d2) {
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d2 && d2 <= this.northeast.longitude;
        }
        return this.southwest.longitude <= d2 || d2 <= this.northeast.longitude;
    }

    public boolean contains(LatLng latLng) {
        return zzi(latLng.latitude) && zzj(latLng.longitude);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d2 = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d3 = this.northeast.longitude;
        double d4 = this.southwest.longitude;
        return new LatLng(d2, d4 <= d3 ? (d3 + d4) / 2.0d : ((d3 + 360.0d) + d4) / 2.0d);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        double d2;
        double dMin = Math.min(this.southwest.latitude, latLng.latitude);
        double dMax = Math.max(this.northeast.latitude, latLng.latitude);
        double d3 = this.northeast.longitude;
        double d4 = this.southwest.longitude;
        double d5 = latLng.longitude;
        if (zzj(d5)) {
            d5 = d4;
            d2 = d3;
        } else if (zzb(d4, d5) < zzc(d3, d5)) {
            d2 = d3;
        } else {
            d2 = d5;
            d5 = d4;
        }
        return new LatLngBounds(new LatLng(dMin, d5), new LatLng(dMax, d2));
    }

    public String toString() {
        return zzw.zzx(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
