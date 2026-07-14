package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends com.google.android.gms.common.internal.zzj<zzi> {
    private final String zzaLE;
    protected final zzp<zzi> zzaLF;

    public zzb(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 23, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaLF = new zzp<zzi>() { // from class: com.google.android.gms.location.internal.zzb.1
            @Override // com.google.android.gms.location.internal.zzp
            public void zzqr() {
                zzb.this.zzqr();
            }

            @Override // com.google.android.gms.location.internal.zzp
            /* JADX INFO: renamed from: zzya, reason: merged with bridge method [inline-methods] */
            public zzi zzqs() throws DeadObjectException {
                return zzb.this.zzqs();
            }
        };
        this.zzaLE = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzcg, reason: merged with bridge method [inline-methods] */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.zzcj(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzlU() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzaLE);
        return bundle;
    }
}
