package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

/* JADX INFO: loaded from: classes.dex */
public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
    final int mVersionCode;
    final PlaceImpl zzaNV;
    final float zzaNW;

    PlaceLikelihoodEntity(int i, PlaceImpl placeImpl, float f2) {
        this.mVersionCode = i;
        this.zzaNV = placeImpl;
        this.zzaNW = f2;
    }

    public static PlaceLikelihoodEntity zza(PlaceImpl placeImpl, float f2) {
        return new PlaceLikelihoodEntity(0, (PlaceImpl) zzx.zzy(placeImpl), f2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) obj;
        return this.zzaNV.equals(placeLikelihoodEntity.zzaNV) && this.zzaNW == placeLikelihoodEntity.zzaNW;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public float getLikelihood() {
        return this.zzaNW;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public Place getPlace() {
        return this.zzaNV;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaNV, Float.valueOf(this.zzaNW));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzx(this).zzg("place", this.zzaNV).zzg("likelihood", Float.valueOf(this.zzaNW)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyM, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihood freeze() {
        return this;
    }
}
