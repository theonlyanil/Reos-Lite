package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class FusedLocationProviderResult implements Result, SafeParcelable {
    private final int mVersionCode;
    private final Status zzTA;
    public static final FusedLocationProviderResult zzaLO = new FusedLocationProviderResult(Status.zzaeX);
    public static final Parcelable.Creator<FusedLocationProviderResult> CREATOR = new zze();

    FusedLocationProviderResult(int i, Status status) {
        this.mVersionCode = i;
        this.zzTA = status;
    }

    public FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
