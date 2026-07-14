package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: loaded from: classes.dex */
public final class zzkx extends zzj<zzkz> {
    private final Bundle zzUq;

    public zzkx(Context context, Looper looper, zzf zzfVar, Auth.zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzUq = zzaVar == null ? new Bundle() : zzaVar.zzmb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzay, reason: merged with bridge method [inline-methods] */
    public zzkz zzW(IBinder iBinder) {
        return zzkz.zza.zzaA(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzlU() {
        return this.zzUq;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmn() {
        zzf zzfVarZzqq = zzqq();
        return (TextUtils.isEmpty(zzfVarZzqq.getAccountName()) || zzfVarZzqq.zzb(Auth.PROXY_API).isEmpty()) ? false : true;
    }
}
