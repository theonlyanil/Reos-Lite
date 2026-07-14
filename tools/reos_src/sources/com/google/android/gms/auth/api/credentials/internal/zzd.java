package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements CredentialsApi {

    private static class zza extends com.google.android.gms.auth.api.credentials.internal.zza {
        private zzlx.zzb<Status> zzVc;

        zza(zzlx.zzb<Status> zzbVar) {
            this.zzVc = zzbVar;
        }

        @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.zzh
        public void zzg(Status status) {
            this.zzVc.zzr(status);
        }
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> delete(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzb(new zze<Status>(googleApiClient) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.3
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzi zziVar) throws RemoteException {
                zziVar.zza(new zza(this), new DeleteRequest(credential));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzly
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zze<Status>(googleApiClient) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.4
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzi zziVar) throws RemoteException {
                zziVar.zza(new zza(this));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzly
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        zzx.zzb(googleApiClient, "client must not be null");
        zzx.zzb(hintRequest, "request must not be null");
        zzx.zzb(googleApiClient.zza(Auth.CREDENTIALS_API), "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        Auth.AuthCredentialsOptions authCredentialsOptionsZzmm = ((zzf) googleApiClient.zza(Auth.zzTX)).zzmm();
        return PendingIntent.getActivity(googleApiClient.getContext(), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzb.zza(googleApiClient.getContext(), hintRequest, (authCredentialsOptionsZzmm == null || authCredentialsOptionsZzmm.zzma() == null) ? PasswordSpecification.zzUO : authCredentialsOptionsZzmm.zzma()), 268435456);
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, final CredentialRequest credentialRequest) {
        return googleApiClient.zza(new zze<CredentialRequestResult>(googleApiClient) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.1
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzi zziVar) throws RemoteException {
                zziVar.zza(new com.google.android.gms.auth.api.credentials.internal.zza() { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.1.1
                    @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.zzh
                    public void zza(Status status, Credential credential) {
                        zzb(new zzc(status, credential));
                    }

                    @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.zzh
                    public void zzg(Status status) {
                        zzb(zzc.zzh(status));
                    }
                }, credentialRequest);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzly
            /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
            public CredentialRequestResult zzc(Status status) {
                return zzc.zzh(status);
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> save(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzb(new zze<Status>(googleApiClient) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.2
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzi zziVar) throws RemoteException {
                zziVar.zza(new zza(this), new SaveRequest(credential));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzly
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
