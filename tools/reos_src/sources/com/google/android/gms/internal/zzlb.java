package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzlb implements ProxyApi {
    @Override // com.google.android.gms.auth.api.proxy.ProxyApi
    public PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, final ProxyRequest proxyRequest) {
        zzx.zzy(googleApiClient);
        zzx.zzy(proxyRequest);
        return googleApiClient.zzb(new zzla(googleApiClient) { // from class: com.google.android.gms.internal.zzlb.1
            @Override // com.google.android.gms.internal.zzla
            protected void zza(Context context, zzkz zzkzVar) throws RemoteException {
                zzkzVar.zza(new zzkw() { // from class: com.google.android.gms.internal.zzlb.1.1
                    @Override // com.google.android.gms.internal.zzkw, com.google.android.gms.internal.zzky
                    public void zza(ProxyResponse proxyResponse) {
                        zzb(new zzlc(proxyResponse));
                    }
                }, proxyRequest);
            }
        });
    }
}
