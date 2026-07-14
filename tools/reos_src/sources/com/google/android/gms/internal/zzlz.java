package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzlz implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zzafm;
    private final int zzafn;
    private zzmi zzafo;

    public zzlz(Api<?> api, int i) {
        this.zzafm = api;
        this.zzafn = i;
    }

    private void zzoT() {
        zzx.zzb(this.zzafo, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        zzoT();
        this.zzafo.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzoT();
        this.zzafo.zza(connectionResult, this.zzafm, this.zzafn);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzoT();
        this.zzafo.onConnectionSuspended(i);
    }

    public void zza(zzmi zzmiVar) {
        this.zzafo = zzmiVar;
    }
}
