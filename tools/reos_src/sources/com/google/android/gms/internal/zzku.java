package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: loaded from: classes.dex */
public class zzku extends zzj<zzkv> {
    public zzku(Context context, Looper looper, zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 92, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzat, reason: merged with bridge method [inline-methods] */
    public zzkv zzW(IBinder iBinder) {
        return zzkv.zza.zzau(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.auth.api.consent.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.auth.api.consent.internal.IConsentService";
    }
}
