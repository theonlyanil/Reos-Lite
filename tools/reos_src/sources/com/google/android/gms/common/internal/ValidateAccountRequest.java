package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ValidateAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzae();
    final int mVersionCode;
    private final String zzUr;
    private final Scope[] zzaem;
    final IBinder zzaiS;
    private final int zzakH;
    private final Bundle zzakI;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.zzakH = i2;
        this.zzaiS = iBinder;
        this.zzaem = scopeArr;
        this.zzakI = bundle;
        this.zzUr = str;
    }

    public ValidateAccountRequest(zzp zzpVar, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, zzpVar == null ? null : zzpVar.asBinder(), scopeArr, bundle, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCallingPackage() {
        return this.zzUr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public Scope[] zzqN() {
        return this.zzaem;
    }

    public int zzqO() {
        return this.zzakH;
    }

    public Bundle zzqP() {
        return this.zzakI;
    }
}
