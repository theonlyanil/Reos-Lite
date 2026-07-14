package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class LocationRequestCreator implements Parcelable.Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(LocationRequest locationRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, locationRequest.mPriority);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, locationRequest.zzaLk);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, locationRequest.zzaLl);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, locationRequest.zzayX);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, locationRequest.zzaKP);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, locationRequest.zzaLm);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, locationRequest.zzaLn);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, locationRequest.zzaLo);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LocationRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        int iZzg2 = 102;
        long jZzi = 3600000;
        long jZzi2 = 600000;
        boolean zZzc = false;
        long jZzi3 = Long.MAX_VALUE;
        int iZzg3 = Integer.MAX_VALUE;
        float fZzl = BitmapDescriptorFactory.HUE_RED;
        long jZzi4 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 5:
                    jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 6:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 8:
                    jZzi4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
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
        return new LocationRequest(iZzg, iZzg2, jZzi, jZzi2, zZzc, jZzi3, iZzg3, fZzl, jZzi4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
