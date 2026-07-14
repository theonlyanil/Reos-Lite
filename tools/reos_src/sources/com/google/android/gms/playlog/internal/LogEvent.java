package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzaYn;
    public final long zzaYo;
    public final byte[] zzaYp;
    public final Bundle zzaYq;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.zzaYn = j;
        this.zzaYo = j2;
        this.tag = str;
        this.zzaYp = bArr;
        this.zzaYq = bundle;
    }

    public LogEvent(long j, long j2, String str, byte[] bArr, String... strArr) {
        this.versionCode = 1;
        this.zzaYn = j;
        this.zzaYo = j2;
        this.tag = str;
        this.zzaYp = bArr;
        this.zzaYq = zzd(strArr);
    }

    private static Bundle zzd(String... strArr) {
        Bundle bundle = null;
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }
            int length = strArr.length / 2;
            if (length != 0) {
                bundle = new Bundle(length);
                for (int i = 0; i < length; i++) {
                    bundle.putString(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
        }
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tag=").append(this.tag).append(",");
        sb.append("eventTime=").append(this.zzaYn).append(",");
        sb.append("eventUptime=").append(this.zzaYo).append(",");
        if (this.zzaYq != null && !this.zzaYq.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.zzaYq.keySet()) {
                sb.append("(").append(str).append(",");
                sb.append(this.zzaYq.getString(str)).append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
