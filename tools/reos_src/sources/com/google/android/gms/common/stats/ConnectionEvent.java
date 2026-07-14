package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
    final int mVersionCode;
    private final long zzaln;
    private int zzalo;
    private final String zzalp;
    private final String zzalq;
    private final String zzalr;
    private final String zzals;
    private final String zzalt;
    private final String zzalu;
    private final long zzalv;
    private final long zzalw;
    private long zzalx;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.zzaln = j;
        this.zzalo = i2;
        this.zzalp = str;
        this.zzalq = str2;
        this.zzalr = str3;
        this.zzals = str4;
        this.zzalx = -1L;
        this.zzalt = str5;
        this.zzalu = str6;
        this.zzalv = j2;
        this.zzalw = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public int getEventType() {
        return this.zzalo;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public long getTimeMillis() {
        return this.zzaln;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzrp() {
        return this.zzalp;
    }

    public String zzrq() {
        return this.zzalq;
    }

    public String zzrr() {
        return this.zzalr;
    }

    public String zzrs() {
        return this.zzals;
    }

    public String zzrt() {
        return this.zzalt;
    }

    public String zzru() {
        return this.zzalu;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public long zzrv() {
        return this.zzalx;
    }

    public long zzrw() {
        return this.zzalw;
    }

    public long zzrx() {
        return this.zzalv;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public String zzry() {
        return "\t" + zzrp() + "/" + zzrq() + "\t" + zzrr() + "/" + zzrs() + "\t" + (this.zzalt == null ? "" : this.zzalt) + "\t" + zzrw();
    }
}
