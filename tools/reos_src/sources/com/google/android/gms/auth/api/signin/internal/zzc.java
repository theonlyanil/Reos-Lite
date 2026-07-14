package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzmo;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends zzlx.zza<R, zzd> {
        public zza(GoogleApiClient googleApiClient) {
            super(Auth.zzUa, googleApiClient);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GoogleSignInOptions zza(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzUa)).zzmL();
    }

    private OptionalPendingResult<GoogleSignInResult> zza(final GoogleApiClient googleApiClient, final GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzmo(googleApiClient.zza(new zza<GoogleSignInResult>(googleApiClient) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zzqs().zza(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.1.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzf
                    public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                        if (googleSignInAccount != null) {
                            zzn.zzae(googleApiClient.getContext()).zzb(googleSignInAccount, googleSignInOptions);
                        }
                        zzb(new GoogleSignInResult(googleSignInAccount, status));
                    }
                }, googleSignInOptions);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzly
            /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
            public GoogleSignInResult zzc(Status status) {
                return new GoogleSignInResult(null, status);
            }
        }));
    }

    private boolean zza(Account account, Account account2) {
        if (account == null) {
            return account2 == null;
        }
        return account.equals(account2);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public Intent getSignInIntent(GoogleApiClient googleApiClient) {
        zzx.zzy(googleApiClient);
        return ((zzd) googleApiClient.zza(Auth.zzUa)).zzmK();
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent == null || !(intent.hasExtra("googleSignInStatus") || intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzaeX;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public PendingResult<Status> revokeAccess(final GoogleApiClient googleApiClient) {
        zzn.zzae(googleApiClient.getContext()).zzmZ();
        Iterator<GoogleApiClient> it = GoogleApiClient.zzoE().iterator();
        while (it.hasNext()) {
            it.next().zzoF();
        }
        return googleApiClient.zzb(new zza<Status>(googleApiClient) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zzqs().zzc(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.3.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzf
                    public void zzm(Status status) throws RemoteException {
                        zzb(status);
                    }
                }, zzc.this.zza(googleApiClient));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzly
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public PendingResult<Status> signOut(final GoogleApiClient googleApiClient) {
        zzn.zzae(googleApiClient.getContext()).zzmZ();
        Iterator<GoogleApiClient> it = GoogleApiClient.zzoE().iterator();
        while (it.hasNext()) {
            it.next().zzoF();
        }
        return googleApiClient.zzb(new zza<Status>(googleApiClient) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zzqs().zzb(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.2.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzf
                    public void zzl(Status status) throws RemoteException {
                        zzb(status);
                    }
                }, zzc.this.zza(googleApiClient));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzly
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        GoogleSignInOptions googleSignInOptionsZza = zza(googleApiClient);
        GoogleSignInResult googleSignInResultZza = zza(googleApiClient.getContext(), googleSignInOptionsZza);
        return googleSignInResultZza != null ? PendingResults.zzb(googleSignInResultZza, googleApiClient) : zza(googleApiClient, googleSignInOptionsZza);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        GoogleSignInAccount googleSignInAccountZzmW;
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzy(googleSignInOptions);
        zzn zznVarZzae = zzn.zzae(context);
        GoogleSignInOptions googleSignInOptionsZzmX = zznVarZzae.zzmX();
        if (googleSignInOptionsZzmX == null || !zza(googleSignInOptionsZzmX.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmz()) {
            return null;
        }
        if ((!googleSignInOptions.zzmy() || (googleSignInOptionsZzmX.zzmy() && googleSignInOptions.zzmB().equals(googleSignInOptionsZzmX.zzmB()))) && new HashSet(googleSignInOptionsZzmX.zzmu()).containsAll(new HashSet(googleSignInOptions.zzmu())) && (googleSignInAccountZzmW = zznVarZzae.zzmW()) != null && !googleSignInAccountZzmW.zzb()) {
            return new GoogleSignInResult(googleSignInAccountZzmW, Status.zzaeX);
        }
        return null;
    }
}
