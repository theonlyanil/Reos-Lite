package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzmc implements Releasable, Result {
    protected final Status zzTA;
    protected final DataHolder zzafC;

    protected zzmc(DataHolder dataHolder, Status status) {
        this.zzTA = status;
        this.zzafC = dataHolder;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.zzafC != null) {
            this.zzafC.close();
        }
    }
}
