package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends com.google.android.gms.common.internal.zzj<zzi> {
    private final Auth.AuthCredentialsOptions zzVd;

    public zzf(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzVd = authCredentialsOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzav, reason: merged with bridge method [inline-methods] */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.zzax(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzlU() {
        return this.zzVd == null ? new Bundle() : this.zzVd.zzlU();
    }

    Auth.AuthCredentialsOptions zzmm() {
        return this.zzVd;
    }
}
