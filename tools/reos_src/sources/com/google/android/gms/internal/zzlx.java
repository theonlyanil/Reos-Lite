package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class zzlx {

    public static abstract class zza<R extends Result, A extends Api.zzb> extends zzly<R> implements zzb<R>, zzmg.zze<A> {
        private final Api.zzc<A> zzacX;
        private AtomicReference<zzmg.zzd> zzafc;

        protected zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(((GoogleApiClient) zzx.zzb(googleApiClient, "GoogleApiClient must not be null")).getLooper());
            this.zzafc = new AtomicReference<>();
            this.zzacX = (Api.zzc) zzx.zzy(zzcVar);
        }

        private void zza(RemoteException remoteException) {
            zzx(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void zza(A a2) throws RemoteException;

        @Override // com.google.android.gms.internal.zzmg.zze
        public void zza(zzmg.zzd zzdVar) {
            this.zzafc.set(zzdVar);
        }

        @Override // com.google.android.gms.internal.zzmg.zze
        public final void zzb(A a2) throws DeadObjectException {
            try {
                zza(a2);
            } catch (DeadObjectException e2) {
                zza(e2);
                throw e2;
            } catch (RemoteException e3) {
                zza(e3);
            }
        }

        @Override // com.google.android.gms.internal.zzmg.zze
        public final Api.zzc<A> zzoA() {
            return this.zzacX;
        }

        @Override // com.google.android.gms.internal.zzmg.zze
        public void zzoP() {
            setResultCallback(null);
        }

        @Override // com.google.android.gms.internal.zzmg.zze
        public int zzoQ() {
            return 0;
        }

        @Override // com.google.android.gms.internal.zzly
        protected void zzoR() {
            zzmg.zzd andSet = this.zzafc.getAndSet(null);
            if (andSet != null) {
                andSet.zzc(this);
            }
        }

        @Override // com.google.android.gms.internal.zzlx.zzb
        public /* synthetic */ void zzr(Object obj) {
            super.zzb((Result) obj);
        }

        @Override // com.google.android.gms.internal.zzlx.zzb, com.google.android.gms.internal.zzmg.zze
        public final void zzx(Status status) {
            zzx.zzb(!status.isSuccess(), "Failed result must not be success");
            zzb(zzc(status));
        }
    }

    public interface zzb<R> {
        void zzr(R r);

        void zzx(Status status);
    }
}
