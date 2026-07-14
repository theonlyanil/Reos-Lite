package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Plus {
    public static final Api.zzc<zze> zzTo = new Api.zzc<>();
    static final Api.zza<zze, PlusOptions> zzTp = new Api.zza<zze, PlusOptions>() { // from class: com.google.android.gms.plus.Plus.1
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return 2;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public zze zza(Context context, Looper looper, zzf zzfVar, PlusOptions plusOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new zze(context, looper, zzfVar, new PlusSession(zzfVar.zzpY().name, zzoa.zzc(zzfVar.zzqb()), (String[]) plusOptions.zzaYM.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<PlusOptions> API = new Api<>("Plus.API", zzTp, zzTo);
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final Moments MomentsApi = new zzrn();
    public static final People PeopleApi = new zzro();

    @Deprecated
    public static final Account AccountApi = new zzrk();
    public static final zzb zzaYJ = new zzrm();
    public static final com.google.android.gms.plus.zza zzaYK = new zzrl();

    public static final class PlusOptions implements Api.ApiOptions.Optional {
        final String zzaYL;
        final Set<String> zzaYM;

        public static final class Builder {
            String zzaYL;
            final Set<String> zzaYM = new HashSet();

            public Builder addActivityTypes(String... strArr) {
                zzx.zzb(strArr, "activityTypes may not be null.");
                for (String str : strArr) {
                    this.zzaYM.add(str);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions(this);
            }

            public Builder setServerClientId(String str) {
                this.zzaYL = str;
                return this;
            }
        }

        private PlusOptions() {
            this.zzaYL = null;
            this.zzaYM = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzaYL = builder.zzaYL;
            this.zzaYM = builder.zzaYM;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class zza<R extends Result> extends zzlx.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzTo, googleApiClient);
        }
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zHasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !zHasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
        if (zHasConnectedApi) {
            return (zze) googleApiClient.zza(zzTo);
        }
        return null;
    }
}
