package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzf;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.auth.api.signin.internal.zzl;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.auth.api.signin.zzh;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzlb;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Auth {
    public static final Api.zzc<zzkx> zzTW = new Api.zzc<>();
    public static final Api.zzc<zzf> zzTX = new Api.zzc<>();
    public static final Api.zzc<zzkq> zzTY = new Api.zzc<>();
    public static final Api.zzc<zzl> zzTZ = new Api.zzc<>();
    public static final Api.zzc<zzd> zzUa = new Api.zzc<>();
    public static final Api.zzc<zzku> zzUb = new Api.zzc<>();
    private static final Api.zza<zzkx, zza> zzUc = new Api.zza<zzkx, zza>() { // from class: com.google.android.gms.auth.api.Auth.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zzkx zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkx(context, looper, zzfVar, zzaVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzf, AuthCredentialsOptions> zzUd = new Api.zza<zzf, AuthCredentialsOptions>() { // from class: com.google.android.gms.auth.api.Auth.2
        @Override // com.google.android.gms.common.api.Api.zza
        public zzf zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzf(context, looper, zzfVar, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzkq, Api.ApiOptions.NoOptions> zzUe = new Api.zza<zzkq, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.auth.api.Auth.3
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zzkq zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkq(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzku, Api.ApiOptions.NoOptions> zzUf = new Api.zza<zzku, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.auth.api.Auth.4
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public zzku zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzku(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzl, zzh> zzUg = new Api.zza<zzl, zzh>() { // from class: com.google.android.gms.auth.api.Auth.5
        @Override // com.google.android.gms.common.api.Api.zza
        public zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, zzh zzhVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, zzfVar, zzhVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzd, GoogleSignInOptions> zzUh = new Api.zza<zzd, GoogleSignInOptions>() { // from class: com.google.android.gms.auth.api.Auth.6
        @Override // com.google.android.gms.common.api.Api.zza
        public zzd zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, zzfVar, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public List<Scope> zzn(GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzmu();
        }
    };
    public static final Api<zza> PROXY_API = new Api<>("Auth.PROXY_API", zzUc, zzTW);
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zzUd, zzTX);
    public static final Api<zzh> zzUi = new Api<>("Auth.SIGN_IN_API", zzUg, zzTZ);
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zzUh, zzUa);
    public static final Api<Api.ApiOptions.NoOptions> zzUj = new Api<>("Auth.ACCOUNT_STATUS_API", zzUe, zzTY);
    public static final Api<Api.ApiOptions.NoOptions> zzUk = new Api<>("Auth.CONSENT_API", zzUf, zzUb);
    public static final ProxyApi ProxyApi = new zzlb();
    public static final CredentialsApi CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzd();
    public static final zzko zzUl = new zzkp();
    public static final zzg zzUm = new zzk();
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    public static final com.google.android.gms.auth.api.consent.zza zzUn = new zzkt();

    public static final class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        private final String zzUo;
        private final PasswordSpecification zzUp;

        public static class Builder {
            private PasswordSpecification zzUp = PasswordSpecification.zzUO;
        }

        public Bundle zzlU() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzUo);
            bundle.putParcelable("password_specification", this.zzUp);
            return bundle;
        }

        public PasswordSpecification zzma() {
            return this.zzUp;
        }
    }

    public static final class zza implements Api.ApiOptions.Optional {
        private final Bundle zzUq;

        public Bundle zzmb() {
            return new Bundle(this.zzUq);
        }
    }

    private Auth() {
    }
}
