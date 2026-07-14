package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzly;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Batch extends zzly<BatchResult> {
    private int zzaes;
    private boolean zzaet;
    private boolean zzaeu;
    private final PendingResult<?>[] zzaev;
    private final Object zzpK;

    public static final class Builder {
        private GoogleApiClient zzYC;
        private List<PendingResult<?>> zzaex = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.zzYC = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zzaex.size());
            this.zzaex.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzaex, this.zzYC);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzpK = new Object();
        this.zzaes = list.size();
        this.zzaev = new PendingResult[this.zzaes];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            PendingResult<?> pendingResult = list.get(i2);
            this.zzaev[i2] = pendingResult;
            pendingResult.zza(new PendingResult.zza() { // from class: com.google.android.gms.common.api.Batch.1
                @Override // com.google.android.gms.common.api.PendingResult.zza
                public void zzu(Status status) {
                    synchronized (Batch.this.zzpK) {
                        if (Batch.this.isCanceled()) {
                            return;
                        }
                        if (status.isCanceled()) {
                            Batch.this.zzaeu = true;
                        } else if (!status.isSuccess()) {
                            Batch.this.zzaet = true;
                        }
                        Batch.zzb(Batch.this);
                        if (Batch.this.zzaes == 0) {
                            if (Batch.this.zzaeu) {
                                Batch.super.cancel();
                            } else {
                                Batch.this.zzb(new BatchResult(Batch.this.zzaet ? new Status(13) : Status.zzaeX, Batch.this.zzaev));
                            }
                        }
                    }
                }
            });
            i = i2 + 1;
        }
    }

    static /* synthetic */ int zzb(Batch batch) {
        int i = batch.zzaes;
        batch.zzaes = i - 1;
        return i;
    }

    @Override // com.google.android.gms.internal.zzly, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        for (PendingResult<?> pendingResult : this.zzaev) {
            pendingResult.cancel();
        }
    }

    @Override // com.google.android.gms.internal.zzly
    /* JADX INFO: renamed from: createFailedResult, reason: merged with bridge method [inline-methods] */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.zzaev);
    }
}
