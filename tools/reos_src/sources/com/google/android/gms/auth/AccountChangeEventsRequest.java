package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    final int mVersion;
    Account zzSo;

    @Deprecated
    String zzTD;
    int zzTF;

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.mVersion = i;
        this.zzTF = i2;
        this.zzTD = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzSo = account;
        } else {
            this.zzSo = new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSo;
    }

    public String getAccountName() {
        return this.zzTD;
    }

    public int getEventIndex() {
        return this.zzTF;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzSo = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzTD = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzTF = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
