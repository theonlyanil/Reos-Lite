package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<NearbyAlertFilter> {
    static void zza(NearbyAlertFilter nearbyAlertFilter, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 1, nearbyAlertFilter.zzaMv, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, nearbyAlertFilter.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, nearbyAlertFilter.zzaMt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, nearbyAlertFilter.zzaMw, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeT, reason: merged with bridge method [inline-methods] */
    public NearbyAlertFilter createFromParcel(Parcel parcel) {
        ArrayList arrayListZzc = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        ArrayList<Integer> arrayListZzC = null;
        ArrayList<String> arrayListZzD = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(iZzat)) {
                case 1:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    break;
                case 2:
                    arrayListZzC = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, iZzat);
                    break;
                case 3:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, UserDataType.CREATOR);
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
        return new NearbyAlertFilter(iZzg, arrayListZzD, arrayListZzC, arrayListZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhB, reason: merged with bridge method [inline-methods] */
    public NearbyAlertFilter[] newArray(int i) {
        return new NearbyAlertFilter[i];
    }
}
