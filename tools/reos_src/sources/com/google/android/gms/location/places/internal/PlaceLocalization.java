package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class PlaceLocalization implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    public final String address;
    public final String name;
    public final int versionCode;
    public final String zzaNX;
    public final String zzaNY;
    public final List<String> zzaNZ;

    public PlaceLocalization(int i, String str, String str2, String str3, String str4, List<String> list) {
        this.versionCode = i;
        this.name = str;
        this.address = str2;
        this.zzaNX = str3;
        this.zzaNY = str4;
        this.zzaNZ = list;
    }

    public static PlaceLocalization zza(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzo zzoVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) obj;
        return zzw.equal(this.name, placeLocalization.name) && zzw.equal(this.address, placeLocalization.address) && zzw.equal(this.zzaNX, placeLocalization.zzaNX) && zzw.equal(this.zzaNY, placeLocalization.zzaNY) && zzw.equal(this.zzaNZ, placeLocalization.zzaNZ);
    }

    public int hashCode() {
        return zzw.hashCode(this.name, this.address, this.zzaNX, this.zzaNY);
    }

    public String toString() {
        return zzw.zzx(this).zzg("name", this.name).zzg(Constants.SMS_COLUMN_ADDRESS, this.address).zzg("internationalPhoneNumber", this.zzaNX).zzg("regularOpenHours", this.zzaNY).zzg("attributions", this.zzaNZ).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo zzoVar = CREATOR;
        zzo.zza(this, parcel, i);
    }
}
