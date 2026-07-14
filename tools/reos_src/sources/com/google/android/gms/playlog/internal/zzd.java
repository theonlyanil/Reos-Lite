package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzrj;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final zzrj.zza zzaYw;
    private zzf zzaYl = null;
    private boolean zzaYx = true;

    public zzd(zzrj.zza zzaVar) {
        this.zzaYw = zzaVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        this.zzaYl.zzas(false);
        if (this.zzaYx && this.zzaYw != null) {
            this.zzaYw.zzCX();
        }
        this.zzaYx = false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzaYl.zzas(true);
        if (this.zzaYx && this.zzaYw != null) {
            if (connectionResult.hasResolution()) {
                this.zzaYw.zze(connectionResult.getResolution());
            } else {
                this.zzaYw.zzCY();
            }
        }
        this.zzaYx = false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        this.zzaYl.zzas(true);
    }

    public void zza(zzf zzfVar) {
        this.zzaYl = zzfVar;
    }

    public void zzar(boolean z) {
        this.zzaYx = z;
    }
}
