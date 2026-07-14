package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationRequestInternal implements SafeParcelable {
    String mTag;
    private final int mVersionCode;
    boolean zzaMb;
    boolean zzaMc;
    boolean zzaMd;
    List<ClientIdentity> zzaMe;
    boolean zzaMf;
    LocationRequest zzayV;
    static final List<ClientIdentity> zzaMa = Collections.emptyList();
    public static final zzm CREATOR = new zzm();

    LocationRequestInternal(int i, LocationRequest locationRequest, boolean z, boolean z2, boolean z3, List<ClientIdentity> list, String str, boolean z4) {
        this.mVersionCode = i;
        this.zzayV = locationRequest;
        this.zzaMb = z;
        this.zzaMc = z2;
        this.zzaMd = z3;
        this.zzaMe = list;
        this.mTag = str;
        this.zzaMf = z4;
    }

    public static LocationRequestInternal zza(String str, LocationRequest locationRequest) {
        return new LocationRequestInternal(1, locationRequest, false, true, true, zzaMa, str, false);
    }

    @Deprecated
    public static LocationRequestInternal zzb(LocationRequest locationRequest) {
        return zza(null, locationRequest);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) obj;
        return zzw.equal(this.zzayV, locationRequestInternal.zzayV) && this.zzaMb == locationRequestInternal.zzaMb && this.zzaMc == locationRequestInternal.zzaMc && this.zzaMd == locationRequestInternal.zzaMd && this.zzaMf == locationRequestInternal.zzaMf && zzw.equal(this.zzaMe, locationRequestInternal.zzaMe);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzayV.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzayV.toString());
        if (this.mTag != null) {
            sb.append(" tag=").append(this.mTag);
        }
        sb.append(" nlpDebug=").append(this.zzaMb);
        sb.append(" trigger=").append(this.zzaMd);
        sb.append(" restorePIListeners=").append(this.zzaMc);
        sb.append(" hideAppOps=").append(this.zzaMf);
        sb.append(" clients=").append(this.zzaMe);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
