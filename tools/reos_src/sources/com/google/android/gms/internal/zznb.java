package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zznb implements zzna {

    private static class zza extends zzmy {
        private final zzlx.zzb<Status> zzakL;

        public zza(zzlx.zzb<Status> zzbVar) {
            this.zzakL = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzmy, com.google.android.gms.internal.zzne
        public void zzcd(int i) throws RemoteException {
            this.zzakL.zzr(new Status(i));
        }
    }

    @Override // com.google.android.gms.internal.zzna
    public PendingResult<Status> zze(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zznc.zza(googleApiClient) { // from class: com.google.android.gms.internal.zznb.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zznd zzndVar) throws RemoteException {
                zzndVar.zzqs().zza(new zza(this));
            }
        });
    }
}
