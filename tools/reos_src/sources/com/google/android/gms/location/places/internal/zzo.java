package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzo implements Parcelable.Creator<PlaceLocalization> {
    static void zza(PlaceLocalization placeLocalization, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, placeLocalization.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeLocalization.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, placeLocalization.address, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, placeLocalization.zzaNX, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, placeLocalization.zzaNY, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 5, placeLocalization.zzaNZ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfe, reason: merged with bridge method [inline-methods] */
    public PlaceLocalization createFromParcel(Parcel parcel) {
        ArrayList<String> arrayListZzD = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
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
                case 5:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0094zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PlaceLocalization(iZzg, strZzp4, strZzp3, strZzp2, strZzp, arrayListZzD);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhP, reason: merged with bridge method [inline-methods] */
    public PlaceLocalization[] newArray(int i) {
        return new PlaceLocalization[i];
    }
}
