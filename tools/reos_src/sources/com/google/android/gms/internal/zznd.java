package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: loaded from: classes.dex */
public class zznd extends zzj<zznf> {
    public zznd(Context context, Looper looper, zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaW, reason: merged with bridge method [inline-methods] */
    public zznf zzW(IBinder iBinder) {
        return zznf.zza.zzaY(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    public String zzgh() {
        return "com.google.android.gms.common.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
