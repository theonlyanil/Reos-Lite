package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class EventParcel implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final String name;
    public final int versionCode;
    public final EventParams zzaSL;
    public final String zzaSM;
    public final long zzaSN;

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.versionCode = i;
        this.name = str;
        this.zzaSL = eventParams;
        this.zzaSM = str2;
        this.zzaSN = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.versionCode = 1;
        this.name = str;
        this.zzaSL = eventParams;
        this.zzaSM = str2;
        this.zzaSN = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "origin=" + this.zzaSM + ",name=" + this.name + ",params=" + this.zzaSL;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
