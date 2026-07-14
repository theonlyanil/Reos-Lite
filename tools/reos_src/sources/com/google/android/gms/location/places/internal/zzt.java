package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzt implements Parcelable.Creator<PlacesParams> {
    static void zza(PlacesParams placesParams, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, placesParams.zzaOm, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placesParams.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, placesParams.zzaOn, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, placesParams.zzaOo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, placesParams.zzaNb, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, placesParams.zzaOp);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, placesParams.zzaOq);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzff, reason: merged with bridge method [inline-methods] */
    public PlacesParams createFromParcel(Parcel parcel) {
        int iZzg = 0;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg2 = 0;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(iZzat)) {
                case 1:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 1000:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0094zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PlacesParams(iZzg3, strZzp4, strZzp3, strZzp2, strZzp, iZzg2, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhQ, reason: merged with bridge method [inline-methods] */
    public PlacesParams[] newArray(int i) {
        return new PlacesParams[i];
    }
}
