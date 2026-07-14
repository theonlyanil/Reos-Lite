package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final boolean zzaMs;
    final List<Integer> zzaMt;
    private final Set<Integer> zzaMu;

    AutocompleteFilter(int i, boolean z, Collection<Integer> collection) {
        this.mVersionCode = i;
        this.zzaMs = z;
        this.zzaMt = collection == null ? Collections.emptyList() : new ArrayList<>(collection);
        if (this.zzaMt.isEmpty()) {
            this.zzaMu = Collections.emptySet();
        } else {
            this.zzaMu = Collections.unmodifiableSet(new HashSet(this.zzaMt));
        }
    }

    public static AutocompleteFilter create(Collection<Integer> collection) {
        return zza(true, collection);
    }

    public static AutocompleteFilter zza(boolean z, Collection<Integer> collection) {
        return new AutocompleteFilter(0, z, collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.zzaMu.equals(autocompleteFilter.zzaMu) && this.zzaMs == autocompleteFilter.zzaMs;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaMu;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzaMs), this.zzaMu);
    }

    public String toString() {
        zzw.zza zzaVarZzx = zzw.zzx(this);
        if (!this.zzaMs) {
            zzaVarZzx.zzg("restrictedToPlaces", Boolean.valueOf(this.zzaMs));
        }
        zzaVarZzx.zzg("placeTypes", this.zzaMu);
        return zzaVarZzx.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public boolean zzyl() {
        return this.zzaMs;
    }
}
