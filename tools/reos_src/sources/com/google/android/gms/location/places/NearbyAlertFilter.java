package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class NearbyAlertFilter extends zza implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    final List<Integer> zzaMt;
    private final Set<Integer> zzaMu;
    final List<String> zzaMv;
    final List<UserDataType> zzaMw;
    private final Set<String> zzaMx;
    private final Set<UserDataType> zzaMy;

    NearbyAlertFilter(int i, List<String> list, List<Integer> list2, List<UserDataType> list3) {
        this.mVersionCode = i;
        this.zzaMt = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaMw = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzaMv = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzaMu = zzu(this.zzaMt);
        this.zzaMy = zzu(this.zzaMw);
        this.zzaMx = zzu(this.zzaMv);
    }

    public static NearbyAlertFilter zzg(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
        }
        return new NearbyAlertFilter(0, zzf(collection), null, null);
    }

    public static NearbyAlertFilter zzh(Collection<Integer> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
        }
        return new NearbyAlertFilter(0, null, zzf(collection), null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzd zzdVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertFilter)) {
            return false;
        }
        NearbyAlertFilter nearbyAlertFilter = (NearbyAlertFilter) obj;
        return this.zzaMu.equals(nearbyAlertFilter.zzaMu) && this.zzaMy.equals(nearbyAlertFilter.zzaMy) && this.zzaMx.equals(nearbyAlertFilter.zzaMx);
    }

    @Override // com.google.android.gms.location.places.zza
    public Set<String> getPlaceIds() {
        return this.zzaMx;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMu, this.zzaMy, this.zzaMx);
    }

    public String toString() {
        zzw.zza zzaVarZzx = zzw.zzx(this);
        if (!this.zzaMu.isEmpty()) {
            zzaVarZzx.zzg("types", this.zzaMu);
        }
        if (!this.zzaMx.isEmpty()) {
            zzaVarZzx.zzg("placeIds", this.zzaMx);
        }
        if (!this.zzaMy.isEmpty()) {
            zzaVarZzx.zzg("requestedUserDataTypes", this.zzaMy);
        }
        return zzaVarZzx.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd zzdVar = CREATOR;
        zzd.zza(this, parcel, i);
    }
}
