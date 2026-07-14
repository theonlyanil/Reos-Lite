package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class AccountChangeEvent implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
    final int mVersion;
    final long zzTC;
    final String zzTD;
    final int zzTE;
    final int zzTF;
    final String zzTG;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.zzTC = j;
        this.zzTD = (String) zzx.zzy(str);
        this.zzTE = i2;
        this.zzTF = i3;
        this.zzTG = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.zzTC = j;
        this.zzTD = (String) zzx.zzy(str);
        this.zzTE = i;
        this.zzTF = i2;
        this.zzTG = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.mVersion == accountChangeEvent.mVersion && this.zzTC == accountChangeEvent.zzTC && zzw.equal(this.zzTD, accountChangeEvent.zzTD) && this.zzTE == accountChangeEvent.zzTE && this.zzTF == accountChangeEvent.zzTF && zzw.equal(this.zzTG, accountChangeEvent.zzTG);
    }

    public String getAccountName() {
        return this.zzTD;
    }

    public String getChangeData() {
        return this.zzTG;
    }

    public int getChangeType() {
        return this.zzTE;
    }

    public int getEventIndex() {
        return this.zzTF;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.zzTC), this.zzTD, Integer.valueOf(this.zzTE), Integer.valueOf(this.zzTF), this.zzTG);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzTE) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.zzTD + ", changeType = " + str + ", changeData = " + this.zzTG + ", eventIndex = " + this.zzTF + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
