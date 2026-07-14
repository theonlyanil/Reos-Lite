package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzmq;

/* JADX INFO: loaded from: classes.dex */
public final class PendingResults {

    private static final class zza<R extends Result> extends zzly<R> {
        private final R zzaeS;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzaeS = r;
        }

        @Override // com.google.android.gms.internal.zzly
        protected R zzc(Status status) {
            if (status.getStatusCode() != this.zzaeS.getStatus().getStatusCode()) {
                throw new UnsupportedOperationException("Creating failed results is not supported");
            }
            return this.zzaeS;
        }
    }

    private static final class zzb<R extends Result> extends zzly<R> {
        private final R zzaeT;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzaeT = r;
        }

        @Override // com.google.android.gms.internal.zzly
        protected R zzc(Status status) {
            return this.zzaeT;
        }
    }

    private static final class zzc<R extends Result> extends zzly<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzly
        protected R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzmq zzmqVar = new zzmq(Looper.getMainLooper());
        zzmqVar.cancel();
        return zzmqVar;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzx.zzb(r, "Result must not be null");
        zzx.zzb(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zzaVar = new zza(r);
        zzaVar.cancel();
        return zzaVar;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzx.zzb(r, "Result must not be null");
        zzc zzcVar = new zzc(null);
        zzcVar.zzb(r);
        return new zzmo(zzcVar);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzx.zzb(status, "Result must not be null");
        zzmq zzmqVar = new zzmq(Looper.getMainLooper());
        zzmqVar.zzb(status);
        return zzmqVar;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzx.zzb(r, "Result must not be null");
        zzx.zzb(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzbVar = new zzb(googleApiClient, r);
        zzbVar.zzb(r);
        return zzbVar;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzx.zzb(status, "Result must not be null");
        zzmq zzmqVar = new zzmq(googleApiClient);
        zzmqVar.zzb(status);
        return zzmqVar;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzx.zzb(r, "Result must not be null");
        zzc zzcVar = new zzc(googleApiClient);
        zzcVar.zzb(r);
        return new zzmo(zzcVar);
    }
}
