package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzaMg;
    LocationRequestInternal zzaMh;
    com.google.android.gms.location.zzd zzaMi;
    com.google.android.gms.location.zzc zzaMj;
    zzg zzaMk;

    LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.mVersionCode = i;
        this.zzaMg = i2;
        this.zzaMh = locationRequestInternal;
        this.zzaMi = iBinder == null ? null : com.google.android.gms.location.zzd.zza.zzcf(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaMj = iBinder2 == null ? null : com.google.android.gms.location.zzc.zza.zzce(iBinder2);
        this.zzaMk = iBinder3 != null ? zzg.zza.zzch(iBinder3) : null;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzc zzcVar, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, zzcVar.asBinder(), zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzd zzdVar, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzdVar.asBinder(), null, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(com.google.android.gms.location.zzc zzcVar, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, null, null, zzcVar.asBinder(), zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(com.google.android.gms.location.zzd zzdVar, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, zzdVar.asBinder(), null, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zzb(PendingIntent pendingIntent, zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    IBinder zzye() {
        if (this.zzaMi == null) {
            return null;
        }
        return this.zzaMi.asBinder();
    }

    IBinder zzyf() {
        if (this.zzaMj == null) {
            return null;
        }
        return this.zzaMj.asBinder();
    }

    IBinder zzyg() {
        if (this.zzaMk == null) {
            return null;
        }
        return this.zzaMk.asBinder();
    }
}
