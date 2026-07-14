package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class PlacesParams implements SafeParcelable {
    public final int versionCode;
    public final String zzaNb;
    public final String zzaOm;
    public final String zzaOn;
    public final String zzaOo;
    public final int zzaOp;
    public final int zzaOq;
    public static final PlacesParams zzaOl = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public static final zzt CREATOR = new zzt();

    public PlacesParams(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.versionCode = i;
        this.zzaOm = str;
        this.zzaOn = str2;
        this.zzaOo = str3;
        this.zzaNb = str4;
        this.zzaOp = i2;
        this.zzaOq = i3;
    }

    public PlacesParams(String str, Locale locale, String str2) {
        this(3, str, locale.toString(), str2, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
    }

    public PlacesParams(String str, Locale locale, String str2, String str3, int i) {
        this(3, str, locale.toString(), str2, str3, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzt zztVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PlacesParams)) {
            return false;
        }
        PlacesParams placesParams = (PlacesParams) obj;
        return this.zzaOp == placesParams.zzaOp && this.zzaOq == placesParams.zzaOq && this.zzaOn.equals(placesParams.zzaOn) && this.zzaOm.equals(placesParams.zzaOm) && zzw.equal(this.zzaOo, placesParams.zzaOo) && zzw.equal(this.zzaNb, placesParams.zzaNb);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaOm, this.zzaOn, this.zzaOo, this.zzaNb, Integer.valueOf(this.zzaOp), Integer.valueOf(this.zzaOq));
    }

    public String toString() {
        return zzw.zzx(this).zzg("clientPackageName", this.zzaOm).zzg("locale", this.zzaOn).zzg("accountName", this.zzaOo).zzg("gCoreClientName", this.zzaNb).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzt zztVar = CREATOR;
        zzt.zza(this, parcel, i);
    }
}
