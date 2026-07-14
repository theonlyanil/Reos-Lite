package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class BatchResult implements Result {
    private final Status zzTA;
    private final PendingResult<?>[] zzaev;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.zzTA = status;
        this.zzaev = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzx.zzb(batchResultToken.mId < this.zzaev.length, "The result token does not belong to this batch");
        return (R) this.zzaev[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
