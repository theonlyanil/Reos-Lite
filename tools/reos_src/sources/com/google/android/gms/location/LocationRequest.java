package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int mVersionCode;
    long zzaKP;
    long zzaLk;
    long zzaLl;
    int zzaLm;
    float zzaLn;
    long zzaLo;
    boolean zzayX;

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = 102;
        this.zzaLk = 3600000L;
        this.zzaLl = 600000L;
        this.zzayX = false;
        this.zzaKP = Long.MAX_VALUE;
        this.zzaLm = Integer.MAX_VALUE;
        this.zzaLn = BitmapDescriptorFactory.HUE_RED;
        this.zzaLo = 0L;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f2, long j4) {
        this.mVersionCode = i;
        this.mPriority = i2;
        this.zzaLk = j;
        this.zzaLl = j2;
        this.zzayX = z;
        this.zzaKP = j3;
        this.zzaLm = i3;
        this.zzaLn = f2;
        this.zzaLo = j4;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzL(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f2) {
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid displacement: " + f2);
        }
    }

    private static void zzhj(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            case 101:
            case 103:
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzhk(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 101:
            case 103:
            default:
                return "???";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.mPriority == locationRequest.mPriority && this.zzaLk == locationRequest.zzaLk && this.zzaLl == locationRequest.zzaLl && this.zzayX == locationRequest.zzayX && this.zzaKP == locationRequest.zzaKP && this.zzaLm == locationRequest.zzaLm && this.zzaLn == locationRequest.zzaLn;
    }

    public long getExpirationTime() {
        return this.zzaKP;
    }

    public long getFastestInterval() {
        return this.zzaLl;
    }

    public long getInterval() {
        return this.zzaLk;
    }

    public long getMaxWaitTime() {
        long j = this.zzaLo;
        return j < this.zzaLk ? this.zzaLk : j;
    }

    public int getNumUpdates() {
        return this.zzaLm;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaLn;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaLk), Long.valueOf(this.zzaLl), Boolean.valueOf(this.zzayX), Long.valueOf(this.zzaKP), Integer.valueOf(this.zzaLm), Float.valueOf(this.zzaLn));
    }

    public LocationRequest setExpirationDuration(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - jElapsedRealtime) {
            this.zzaKP = Long.MAX_VALUE;
        } else {
            this.zzaKP = jElapsedRealtime + j;
        }
        if (this.zzaKP < 0) {
            this.zzaKP = 0L;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long j) {
        this.zzaKP = j;
        if (this.zzaKP < 0) {
            this.zzaKP = 0L;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long j) {
        zzL(j);
        this.zzayX = true;
        this.zzaLl = j;
        return this;
    }

    public LocationRequest setInterval(long j) {
        zzL(j);
        this.zzaLk = j;
        if (!this.zzayX) {
            this.zzaLl = (long) (this.zzaLk / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long j) {
        zzL(j);
        this.zzaLo = j;
        return this;
    }

    public LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.zzaLm = i;
        return this;
    }

    public LocationRequest setPriority(int i) {
        zzhj(i);
        this.mPriority = i;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f2) {
        zzd(f2);
        this.zzaLn = f2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(zzhk(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaLk).append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzaLl).append("ms");
        if (this.zzaLo > this.zzaLk) {
            sb.append(" maxWait=");
            sb.append(this.zzaLo).append("ms");
        }
        if (this.zzaKP != Long.MAX_VALUE) {
            long jElapsedRealtime = this.zzaKP - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(jElapsedRealtime).append("ms");
        }
        if (this.zzaLm != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.zzaLm);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LocationRequestCreator.zza(this, parcel, i);
    }
}
