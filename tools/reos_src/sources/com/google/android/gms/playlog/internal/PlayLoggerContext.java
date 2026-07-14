package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final String packageName;
    public final int versionCode;
    public final String zzaYA;
    public final String zzaYB;
    public final boolean zzaYC;
    public final String zzaYD;
    public final boolean zzaYE;
    public final int zzaYF;
    public final int zzaYy;
    public final int zzaYz;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.zzaYy = i2;
        this.zzaYz = i3;
        this.zzaYA = str2;
        this.zzaYB = str3;
        this.zzaYC = z;
        this.zzaYD = str4;
        this.zzaYE = z2;
        this.zzaYF = i4;
    }

    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzy(str);
        this.zzaYy = i;
        this.zzaYz = i2;
        this.zzaYD = str2;
        this.zzaYA = str3;
        this.zzaYB = str4;
        this.zzaYC = !z;
        this.zzaYE = z;
        this.zzaYF = i3;
    }

    @Deprecated
    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, boolean z) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzy(str);
        this.zzaYy = i;
        this.zzaYz = i2;
        this.zzaYD = null;
        this.zzaYA = str2;
        this.zzaYB = str3;
        this.zzaYC = z;
        this.zzaYE = false;
        this.zzaYF = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.zzaYy == playLoggerContext.zzaYy && this.zzaYz == playLoggerContext.zzaYz && zzw.equal(this.zzaYD, playLoggerContext.zzaYD) && zzw.equal(this.zzaYA, playLoggerContext.zzaYA) && zzw.equal(this.zzaYB, playLoggerContext.zzaYB) && this.zzaYC == playLoggerContext.zzaYC && this.zzaYE == playLoggerContext.zzaYE && this.zzaYF == playLoggerContext.zzaYF;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzaYy), Integer.valueOf(this.zzaYz), this.zzaYD, this.zzaYA, this.zzaYB, Boolean.valueOf(this.zzaYC), Boolean.valueOf(this.zzaYE), Integer.valueOf(this.zzaYF));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayLoggerContext[");
        sb.append("versionCode=").append(this.versionCode).append(',');
        sb.append("package=").append(this.packageName).append(',');
        sb.append("packageVersionCode=").append(this.zzaYy).append(',');
        sb.append("logSource=").append(this.zzaYz).append(',');
        sb.append("logSourceName=").append(this.zzaYD).append(',');
        sb.append("uploadAccount=").append(this.zzaYA).append(',');
        sb.append("loggingId=").append(this.zzaYB).append(',');
        sb.append("logAndroidId=").append(this.zzaYC).append(',');
        sb.append("isAnonymous=").append(this.zzaYE).append(',');
        sb.append("qosTier=").append(this.zzaYF);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
