package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PlaceUserData implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int mVersionCode;
    private final String zzTD;
    private final String zzaMO;
    private final List<PlaceAlias> zzaOv;

    PlaceUserData(int i, String str, String str2, List<PlaceAlias> list) {
        this.mVersionCode = i;
        this.zzTD = str;
        this.zzaMO = str2;
        this.zzaOv = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceUserData)) {
            return false;
        }
        PlaceUserData placeUserData = (PlaceUserData) obj;
        return this.zzTD.equals(placeUserData.zzTD) && this.zzaMO.equals(placeUserData.zzaMO) && this.zzaOv.equals(placeUserData.zzaOv);
    }

    public String getPlaceId() {
        return this.zzaMO;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTD, this.zzaMO, this.zzaOv);
    }

    public String toString() {
        return zzw.zzx(this).zzg("accountName", this.zzTD).zzg("placeId", this.zzaMO).zzg("placeAliases", this.zzaOv).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }

    public String zzyQ() {
        return this.zzTD;
    }

    public List<PlaceAlias> zzyR() {
        return this.zzaOv;
    }
}
