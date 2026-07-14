package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzl extends com.google.android.gms.common.internal.zzj<zzg> {
    private final com.google.android.gms.auth.api.signin.zzh zzWg;

    public zzl(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.auth.api.signin.zzh zzhVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzWg = (com.google.android.gms.auth.api.signin.zzh) zzx.zzy(zzhVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public zzg zzW(IBinder iBinder) {
        return zzg.zza.zzaD(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
