package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzmb<L> implements zzmn.zzb<L> {
    private final DataHolder zzafC;

    protected zzmb(DataHolder dataHolder) {
        this.zzafC = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    @Override // com.google.android.gms.internal.zzmn.zzb
    public void zzpb() {
        if (this.zzafC != null) {
            this.zzafC.close();
        }
    }

    @Override // com.google.android.gms.internal.zzmn.zzb
    public final void zzs(L l) {
        zza(l, this.zzafC);
    }
}
