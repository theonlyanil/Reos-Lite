package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class GetConsentIntentRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetConsentIntentRequest> CREATOR = new zzb();
    private final int mVersionCode;
    private final Account zzSo;
    private final String zzUr;
    private final int zzUs;
    private final String zzUt;
    final ScopeDetail[] zzUu;
    private final boolean zzUv;
    private final int zzUw;
    private final String zzUx;

    GetConsentIntentRequest(int i, String str, int i2, String str2, Account account, ScopeDetail[] scopeDetailArr, boolean z, int i3, String str3) {
        this.mVersionCode = i;
        this.zzUr = str;
        this.zzUs = i2;
        this.zzUt = str2;
        this.zzSo = (Account) zzx.zzy(account);
        this.zzUu = scopeDetailArr;
        this.zzUv = z;
        this.zzUw = i3;
        this.zzUx = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSo;
    }

    public String getCallingPackage() {
        return this.zzUr;
    }

    public int getCallingUid() {
        return this.zzUs;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzmc() {
        return this.zzUt;
    }

    public boolean zzmd() {
        return this.zzUv;
    }

    public int zzme() {
        return this.zzUw;
    }

    public String zzmf() {
        return this.zzUx;
    }
}
