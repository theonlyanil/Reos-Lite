package com.google.android.gms.location.places;

import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public AutocompletePrediction get(int i) {
        return new com.google.android.gms.location.places.internal.zzb(this.zzafC, i);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return PlacesStatusCodes.zzhJ(this.zzafC.getStatusCode());
    }

    public String toString() {
        return zzw.zzx(this).zzg(Constants.SMS_COLUMN_STATUS, getStatus()).toString();
    }
}
