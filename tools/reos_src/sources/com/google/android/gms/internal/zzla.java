package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
abstract class zzla extends zzlx.zza<ProxyApi.ProxyResult, zzkx> {
    public zzla(GoogleApiClient googleApiClient) {
        super(Auth.zzTW, googleApiClient);
    }

    protected abstract void zza(Context context, zzkz zzkzVar) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlx.zza
    public final void zza(zzkx zzkxVar) throws RemoteException {
        zza(zzkxVar.getContext(), zzkxVar.zzqs());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzly
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public ProxyApi.ProxyResult zzc(Status status) {
        return new zzlc(status);
    }
}
