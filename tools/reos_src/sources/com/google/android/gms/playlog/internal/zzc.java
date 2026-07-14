package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<LogEvent> {
    static void zza(LogEvent logEvent, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, logEvent.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, logEvent.zzaYn);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, logEvent.tag, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, logEvent.zzaYp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, logEvent.zzaYq, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, logEvent.zzaYo);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgn, reason: merged with bridge method [inline-methods] */
    public LogEvent createFromParcel(Parcel parcel) {
        long jZzi = 0;
        Bundle bundleZzr = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        byte[] bArrZzs = null;
        String strZzp = null;
        long jZzi2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    break;
                case 5:
                    bundleZzr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, iZzat);
                    break;
                case 6:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0094zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new LogEvent(iZzg, jZzi2, jZzi, strZzp, bArrZzs, bundleZzr);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjp, reason: merged with bridge method [inline-methods] */
    public LogEvent[] newArray(int i) {
        return new LogEvent[i];
    }
}
