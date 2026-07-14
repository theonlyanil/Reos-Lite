package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SignInButtonConfig implements SafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zzaa();
    final int mVersionCode;
    private final Scope[] zzaem;
    private final int zzakD;
    private final int zzakE;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.mVersionCode = i;
        this.zzakD = i2;
        this.zzakE = i3;
        this.zzaem = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaa.zza(this, parcel, i);
    }

    public int zzqL() {
        return this.zzakD;
    }

    public int zzqM() {
        return this.zzakE;
    }

    public Scope[] zzqN() {
        return this.zzaem;
    }
}
