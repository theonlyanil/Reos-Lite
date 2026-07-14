package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class PlacePhotoResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzi();
    private final Bitmap mBitmap;
    final int mVersionCode;
    private final Status zzTA;
    final BitmapTeleporter zzaMN;

    PlacePhotoResult(int i, Status status, BitmapTeleporter bitmapTeleporter) {
        this.mVersionCode = i;
        this.zzTA = status;
        this.zzaMN = bitmapTeleporter;
        if (this.zzaMN != null) {
            this.mBitmap = bitmapTeleporter.zzpI();
        } else {
            this.mBitmap = null;
        }
    }

    public PlacePhotoResult(Status status, BitmapTeleporter bitmapTeleporter) {
        this.mVersionCode = 0;
        this.zzTA = status;
        this.zzaMN = bitmapTeleporter;
        if (this.zzaMN != null) {
            this.mBitmap = bitmapTeleporter.zzpI();
        } else {
            this.mBitmap = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    public String toString() {
        return zzw.zzx(this).zzg(Constants.SMS_COLUMN_STATUS, this.zzTA).zzg("bitmap", this.mBitmap).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
