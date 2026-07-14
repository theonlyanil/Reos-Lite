package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceFilter extends com.google.android.gms.location.places.zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    final boolean zzaMH;
    final List<Integer> zzaMt;
    private final Set<Integer> zzaMu;
    final List<String> zzaMv;
    final List<UserDataType> zzaMw;
    private final Set<String> zzaMx;
    private final Set<UserDataType> zzaMy;

    @Deprecated
    public static final class zza {
        private boolean zzaMH;
        private Collection<Integer> zzaMI;
        private Collection<UserDataType> zzaMJ;
        private String[] zzaMK;

        private zza() {
            this.zzaMI = null;
            this.zzaMH = false;
            this.zzaMJ = null;
            this.zzaMK = null;
        }

        public PlaceFilter zzys() {
            return new PlaceFilter(this.zzaMI != null ? new ArrayList(this.zzaMI) : null, this.zzaMH, this.zzaMK != null ? Arrays.asList(this.zzaMK) : null, this.zzaMJ != null ? new ArrayList(this.zzaMJ) : null);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int i, List<Integer> list, boolean z, List<String> list2, List<UserDataType> list3) {
        this.mVersionCode = i;
        this.zzaMt = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzaMH = z;
        this.zzaMw = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzaMv = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaMu = zzu(this.zzaMt);
        this.zzaMy = zzu(this.zzaMw);
        this.zzaMx = zzu(this.zzaMv);
    }

    public PlaceFilter(Collection<Integer> collection, boolean z, Collection<String> collection2, Collection<UserDataType> collection3) {
        this(0, zzf(collection), z, zzf(collection2), zzf(collection3));
    }

    public PlaceFilter(boolean z, Collection<String> collection) {
        this(null, z, collection, null);
    }

    @Deprecated
    public static PlaceFilter zzyr() {
        return new zza().zzys();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzg zzgVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.zzaMu.equals(placeFilter.zzaMu) && this.zzaMH == placeFilter.zzaMH && this.zzaMy.equals(placeFilter.zzaMy) && this.zzaMx.equals(placeFilter.zzaMx);
    }

    @Override // com.google.android.gms.location.places.zza
    public Set<String> getPlaceIds() {
        return this.zzaMx;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaMu;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMu, Boolean.valueOf(this.zzaMH), this.zzaMy, this.zzaMx);
    }

    @Override // com.google.android.gms.location.places.zza
    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzaMH;
    }

    public String toString() {
        zzw.zza zzaVarZzx = zzw.zzx(this);
        if (!this.zzaMu.isEmpty()) {
            zzaVarZzx.zzg("types", this.zzaMu);
        }
        zzaVarZzx.zzg("requireOpenNow", Boolean.valueOf(this.zzaMH));
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
        zzg zzgVar = CREATOR;
        zzg.zza(this, parcel, i);
    }
}
