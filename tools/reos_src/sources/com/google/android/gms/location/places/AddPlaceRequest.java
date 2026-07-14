package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AddPlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaMo;
    private final List<Integer> zzaMp;
    private final String zzaMq;
    private final Uri zzaMr;
    private final String zzatX;

    AddPlaceRequest(int i, String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this.mVersionCode = i;
        this.mName = zzx.zzcG(str);
        this.zzaMo = (LatLng) zzx.zzy(latLng);
        this.zzatX = zzx.zzcG(str2);
        this.zzaMp = new ArrayList((Collection) zzx.zzy(list));
        zzx.zzb(!this.zzaMp.isEmpty(), "At least one place type should be provided.");
        zzx.zzb((TextUtils.isEmpty(str3) && uri == null) ? false : true, "One of phone number or URI should be provided.");
        this.zzaMq = str3;
        this.zzaMr = uri;
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, Uri uri) {
        this(str, latLng, str2, list, null, (Uri) zzx.zzy(uri));
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3) {
        this(str, latLng, str2, list, zzx.zzcG(str3), null);
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this(0, str, latLng, str2, list, str3, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzatX;
    }

    public LatLng getLatLng() {
        return this.zzaMo;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzaMq;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaMp;
    }

    public Uri getWebsiteUri() {
        return this.zzaMr;
    }

    public String toString() {
        return zzw.zzx(this).zzg("name", this.mName).zzg("latLng", this.zzaMo).zzg(Constants.SMS_COLUMN_ADDRESS, this.zzatX).zzg("placeTypes", this.zzaMp).zzg("phoneNumer", this.zzaMq).zzg("websiteUri", this.zzaMr).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
