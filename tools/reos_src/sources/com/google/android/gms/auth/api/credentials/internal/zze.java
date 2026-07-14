package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlx;

/* JADX INFO: loaded from: classes.dex */
abstract class zze<R extends Result> extends zzlx.zza<R, zzf> {
    zze(GoogleApiClient googleApiClient) {
        super(Auth.zzTX, googleApiClient);
    }

    protected abstract void zza(Context context, zzi zziVar) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlx.zza
    public final void zza(zzf zzfVar) throws RemoteException {
        zza(zzfVar.getContext(), zzfVar.zzqs());
    }
}
