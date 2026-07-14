package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class PlacePhotoMetadataResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
    final int mVersionCode;
    private final Status zzTA;
    final DataHolder zzaML;
    private final PlacePhotoMetadataBuffer zzaMM;

    PlacePhotoMetadataResult(int i, Status status, DataHolder dataHolder) {
        this.mVersionCode = i;
        this.zzTA = status;
        this.zzaML = dataHolder;
        if (dataHolder == null) {
            this.zzaMM = null;
        } else {
            this.zzaMM = new PlacePhotoMetadataBuffer(this.zzaML);
        }
    }

    public PlacePhotoMetadataResult(Status status, DataHolder dataHolder) {
        this(0, status, dataHolder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata() {
        return this.zzaMM;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
