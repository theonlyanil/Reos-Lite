package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzmq extends zzly<Status> {
    @Deprecated
    public zzmq(Looper looper) {
        super(looper);
    }

    public zzmq(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzly
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public Status zzc(Status status) {
        return status;
    }
}
