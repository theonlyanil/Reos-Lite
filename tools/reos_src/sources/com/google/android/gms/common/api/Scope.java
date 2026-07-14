package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzc();
    final int mVersionCode;
    private final String zzaeW;

    Scope(int i, String str) {
        zzx.zzh(str, "scopeUri must not be null or empty");
        this.mVersionCode = i;
        this.zzaeW = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.zzaeW.equals(((Scope) obj).zzaeW);
        }
        return false;
    }

    public int hashCode() {
        return this.zzaeW.hashCode();
    }

    public String toString() {
        return this.zzaeW;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public String zzoM() {
        return this.zzaeW;
    }
}
