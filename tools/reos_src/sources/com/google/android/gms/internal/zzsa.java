package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzh;
import com.google.android.gms.signin.internal.zzi;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class zzsa {
    public static final Api.zzc<zzi> zzTo = new Api.zzc<>();
    public static final Api.zzc<zzi> zzatI = new Api.zzc<>();
    public static final Api.zza<zzi, zzsd> zzTp = new Api.zza<zzi, zzsd>() { // from class: com.google.android.gms.internal.zzsa.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zzi zza(Context context, Looper looper, zzf zzfVar, zzsd zzsdVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, true, zzfVar, zzsdVar == null ? zzsd.zzbbH : zzsdVar, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    };
    static final Api.zza<zzi, zza> zzbbE = new Api.zza<zzi, zza>() { // from class: com.google.android.gms.internal.zzsa.2
        @Override // com.google.android.gms.common.api.Api.zza
        public zzi zza(Context context, Looper looper, zzf zzfVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, false, zzfVar, zzaVar.zzDK(), connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Scope zzVA = new Scope(Scopes.PROFILE);
    public static final Scope zzVB = new Scope(Scopes.EMAIL);
    public static final Api<zzsd> API = new Api<>("SignIn.API", zzTp, zzTo);
    public static final Api<zza> zzamM = new Api<>("SignIn.INTERNAL_API", zzbbE, zzatI);
    public static final zzsb zzbbF = new zzh();

    public static class zza implements Api.ApiOptions.HasOptions {
        private final Bundle zzbbG;

        public Bundle zzDK() {
            return this.zzbbG;
        }
    }
}
