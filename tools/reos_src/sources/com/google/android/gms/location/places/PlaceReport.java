package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class PlaceReport implements SafeParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();
    private final String mTag;
    final int mVersionCode;
    private final String zzaMO;
    private final String zzaMP;

    PlaceReport(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzaMO = str;
        this.mTag = str2;
        this.zzaMP = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzi(str, str2, "unknown");
    }

    private static boolean zzdV(String str) {
        switch (str) {
            case "unknown":
            case "userReported":
            case "inferredGeofencing":
            case "inferredRadioSignals":
            case "inferredReverseGeocoding":
            case "inferredSnappedToRoad":
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzi(String str, String str2, String str3) {
        zzx.zzy(str);
        zzx.zzcG(str2);
        zzx.zzcG(str3);
        zzx.zzb(zzdV(str3), "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzw.equal(this.zzaMO, placeReport.zzaMO) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaMP, placeReport.zzaMP);
    }

    public String getPlaceId() {
        return this.zzaMO;
    }

    public String getSource() {
        return this.zzaMP;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMO, this.mTag, this.zzaMP);
    }

    public String toString() {
        zzw.zza zzaVarZzx = zzw.zzx(this);
        zzaVarZzx.zzg("placeId", this.zzaMO);
        zzaVarZzx.zzg(Constants.SMS_COLUMN_TAG, this.mTag);
        if (!"unknown".equals(this.zzaMP)) {
            zzaVarZzx.zzg("source", this.zzaMP);
        }
        return zzaVarZzx.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
