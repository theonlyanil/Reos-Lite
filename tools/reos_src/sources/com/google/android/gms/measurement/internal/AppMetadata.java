package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class AppMetadata implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final String packageName;
    public final int versionCode;
    public final String zzaKi;
    public final String zzaSn;
    public final String zzaSo;
    public final long zzaSp;
    public final long zzaSq;
    public final String zzaSr;
    public final boolean zzaSs;

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z) {
        this.versionCode = i;
        this.packageName = str;
        this.zzaSn = str2;
        this.zzaKi = str3;
        this.zzaSo = str4;
        this.zzaSp = j;
        this.zzaSq = j2;
        this.zzaSr = str5;
        if (i >= 3) {
            this.zzaSs = z;
        } else {
            this.zzaSs = true;
        }
    }

    AppMetadata(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        this.versionCode = 3;
        this.packageName = str;
        this.zzaSn = TextUtils.isEmpty(str2) ? null : str2;
        this.zzaKi = str3;
        this.zzaSo = str4;
        this.zzaSp = j;
        this.zzaSq = j2;
        this.zzaSr = str5;
        this.zzaSs = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
