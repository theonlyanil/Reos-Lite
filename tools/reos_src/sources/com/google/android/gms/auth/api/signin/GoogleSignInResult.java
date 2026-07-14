package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInResult implements Result {
    private Status zzTA;
    private GoogleSignInAccount zzVI;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.zzVI = googleSignInAccount;
        this.zzTA = status;
    }

    public GoogleSignInAccount getSignInAccount() {
        return this.zzVI;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    public boolean isSuccess() {
        return this.zzTA.isSuccess();
    }
}
