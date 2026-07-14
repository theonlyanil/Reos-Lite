package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zztp;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class LogEventParcelable implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int versionCode;
    public final zztp.zzd zzadA;
    public final zza.zzb zzadB;
    public final zza.zzb zzadC;
    public PlayLoggerContext zzadx;
    public byte[] zzady;
    public int[] zzadz;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.versionCode = i;
        this.zzadx = playLoggerContext;
        this.zzady = bArr;
        this.zzadz = iArr;
        this.zzadA = null;
        this.zzadB = null;
        this.zzadC = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zztp.zzd zzdVar, zza.zzb zzbVar, zza.zzb zzbVar2, int[] iArr) {
        this.versionCode = 1;
        this.zzadx = playLoggerContext;
        this.zzadA = zzdVar;
        this.zzadB = zzbVar;
        this.zzadC = zzbVar2;
        this.zzadz = iArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.versionCode == logEventParcelable.versionCode && zzw.equal(this.zzadx, logEventParcelable.zzadx) && Arrays.equals(this.zzady, logEventParcelable.zzady) && Arrays.equals(this.zzadz, logEventParcelable.zzadz) && zzw.equal(this.zzadA, logEventParcelable.zzadA) && zzw.equal(this.zzadB, logEventParcelable.zzadB) && zzw.equal(this.zzadC, logEventParcelable.zzadC);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.zzadx, this.zzady, this.zzadz, this.zzadA, this.zzadB, this.zzadC);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.versionCode);
        sb.append(", ");
        sb.append(this.zzadx);
        sb.append(", ");
        sb.append(this.zzady == null ? null : new String(this.zzady));
        sb.append(", ");
        sb.append(this.zzadz == null ? (String) null : zzv.zzcF(", ").zza(Arrays.asList(this.zzadz)));
        sb.append(", ");
        sb.append(this.zzadA);
        sb.append(", ");
        sb.append(this.zzadB);
        sb.append(", ");
        sb.append(this.zzadC);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
