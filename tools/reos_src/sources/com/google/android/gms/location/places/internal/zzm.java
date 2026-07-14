package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class zzm implements Parcelable.Creator<PlaceLikelihoodEntity> {
    static void zza(PlaceLikelihoodEntity placeLikelihoodEntity, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) placeLikelihoodEntity.zzaNV, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeLikelihoodEntity.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, placeLikelihoodEntity.zzaNW);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfd, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihoodEntity createFromParcel(Parcel parcel) {
        float fZzl;
        PlaceImpl placeImpl;
        int iZzg;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        PlaceImpl placeImpl2 = null;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(iZzat)) {
                case 1:
                    PlaceImpl placeImpl3 = (PlaceImpl) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PlaceImpl.CREATOR);
                    iZzg = i;
                    fZzl = f2;
                    placeImpl = placeImpl3;
                    break;
                case 2:
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    placeImpl = placeImpl2;
                    iZzg = i;
                    break;
                case 1000:
                    float f3 = f2;
                    placeImpl = placeImpl2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    fZzl = f3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    fZzl = f2;
                    placeImpl = placeImpl2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            placeImpl2 = placeImpl;
            f2 = fZzl;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0094zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PlaceLikelihoodEntity(i, placeImpl2, f2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhO, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihoodEntity[] newArray(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}
