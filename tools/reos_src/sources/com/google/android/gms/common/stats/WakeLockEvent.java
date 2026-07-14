package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();
    private final long mTimeout;
    final int mVersionCode;
    private final String zzalZ;
    private final long zzaln;
    private int zzalo;
    private final long zzalv;
    private long zzalx;
    private final int zzama;
    private final List<String> zzamb;
    private final String zzamc;
    private int zzamd;
    private final String zzame;
    private final String zzamf;
    private final float zzamg;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f2, long j3) {
        this.mVersionCode = i;
        this.zzaln = j;
        this.zzalo = i2;
        this.zzalZ = str;
        this.zzame = str3;
        this.zzama = i3;
        this.zzalx = -1L;
        this.zzamb = list;
        this.zzamc = str2;
        this.zzalv = j2;
        this.zzamd = i4;
        this.zzamf = str4;
        this.zzamg = f2;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f2, long j3) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f2, j3);
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
        zzh.zza(this, parcel, i);
    }

    public String zzrB() {
        return this.zzalZ;
    }

    public String zzrC() {
        return this.zzame;
    }

    public int zzrD() {
        return this.zzama;
    }

    public List<String> zzrE() {
        return this.zzamb;
    }

    public int zzrF() {
        return this.zzamd;
    }

    public String zzrG() {
        return this.zzamf;
    }

    public float zzrH() {
        return this.zzamg;
    }

    public long zzrI() {
        return this.mTimeout;
    }

    public String zzru() {
        return this.zzamc;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public long zzrv() {
        return this.zzalx;
    }

    public long zzrx() {
        return this.zzalv;
    }

    @Override // com.google.android.gms.common.stats.zzf
    public String zzry() {
        return "\t" + zzrB() + "\t" + zzrD() + "\t" + (zzrE() == null ? "" : TextUtils.join(",", zzrE())) + "\t" + zzrF() + "\t" + (zzrC() == null ? "" : zzrC()) + "\t" + (zzrG() == null ? "" : zzrG()) + "\t" + zzrH();
    }
}
