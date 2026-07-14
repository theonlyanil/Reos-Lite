package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzk();
    static final long zzaMQ = TimeUnit.HOURS.toMillis(1);
    private final int mPriority;
    final int mVersionCode;
    private final long zzaKP;
    private final long zzaLk;
    private final PlaceFilter zzaMR;

    public PlaceRequest(int i, PlaceFilter placeFilter, long j, int i2, long j2) {
        this.mVersionCode = i;
        this.zzaMR = placeFilter;
        this.zzaLk = j;
        this.mPriority = i2;
        this.zzaKP = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceRequest)) {
            return false;
        }
        PlaceRequest placeRequest = (PlaceRequest) obj;
        return zzw.equal(this.zzaMR, placeRequest.zzaMR) && this.zzaLk == placeRequest.zzaLk && this.mPriority == placeRequest.mPriority && this.zzaKP == placeRequest.zzaKP;
    }

    public long getExpirationTime() {
        return this.zzaKP;
    }

    public long getInterval() {
        return this.zzaLk;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMR, Long.valueOf(this.zzaLk), Integer.valueOf(this.mPriority), Long.valueOf(this.zzaKP));
    }

    public String toString() {
        return zzw.zzx(this).zzg("filter", this.zzaMR).zzg("interval", Long.valueOf(this.zzaLk)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzaKP)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public PlaceFilter zzyn() {
        return this.zzaMR;
    }
}
