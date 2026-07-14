package com.google.android.gms.location.places.personalized;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlacesStatusCodes;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends com.google.android.gms.common.data.zzd<PlaceUserData> implements Result {
    private final Status zzTA;

    public zzd(DataHolder dataHolder) {
        this(dataHolder, PlacesStatusCodes.zzhJ(dataHolder.getStatusCode()));
    }

    private zzd(DataHolder dataHolder, Status status) {
        super(dataHolder, PlaceUserData.CREATOR);
        zzx.zzab(dataHolder == null || dataHolder.getStatusCode() == status.getStatusCode());
        this.zzTA = status;
    }

    public static zzd zzaW(Status status) {
        return new zzd(null, status);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }
}
