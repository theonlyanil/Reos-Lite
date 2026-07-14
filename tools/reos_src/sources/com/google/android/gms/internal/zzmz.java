package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;

/* JADX INFO: loaded from: classes.dex */
public final class zzmz {
    public static final Api.zzc<zznd> zzTo = new Api.zzc<>();
    private static final Api.zza<zznd, Api.ApiOptions.NoOptions> zzTp = new Api.zza<zznd, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.internal.zzmz.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zznd zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznd(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", zzTp, zzTo);
    public static final zzna zzakJ = new zznb();
}
