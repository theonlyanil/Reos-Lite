package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.android.apps.config.Config;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzd extends com.google.android.gms.common.internal.zzj<zzg> {
    private final GoogleSignInOptions zzVZ;

    public zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzfVar, connectionCallbacks, onConnectionFailedListener);
        googleSignInOptions = googleSignInOptions == null ? new GoogleSignInOptions.Builder().build() : googleSignInOptions;
        if (!zzfVar.zzqb().isEmpty()) {
            GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(googleSignInOptions);
            Iterator<Scope> it = zzfVar.zzqb().iterator();
            while (it.hasNext()) {
                builder.requestScopes(it.next(), new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzVZ = googleSignInOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public zzg zzW(IBinder iBinder) {
        return zzg.zza.zzaD(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmJ() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public Intent zzmK() {
        SignInConfiguration signInConfigurationZzmF = new com.google.android.gms.auth.api.signin.zzh.zza(getContext().getPackageName()).zzh(this.zzVZ).zzmG().zzmF();
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(getContext(), SignInHubActivity.class);
        intent.putExtra(Config.CONFIG, signInConfigurationZzmF);
        return intent;
    }

    public GoogleSignInOptions zzmL() {
        return this.zzVZ;
    }
}
