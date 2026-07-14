package com.google.android.gms.location.places;

import android.content.Context;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.internal.zzn;

/* JADX INFO: loaded from: classes.dex */
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzTA;
    private final String zzaMG;
    private final int zzuW;

    public static class zza {
        static int zzhE(int i) {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzTA = PlacesStatusCodes.zzhJ(dataHolder.getStatusCode());
        this.zzuW = zza.zzhE(i);
        if (dataHolder == null || dataHolder.zzpH() == null) {
            this.zzaMG = null;
        } else {
            this.zzaMG = dataHolder.zzpH().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlaceLikelihood get(int i) {
        return new zzn(this.zzafC, i, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzaMG;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzTA;
    }

    public String toString() {
        return zzw.zzx(this).zzg(Constants.SMS_COLUMN_STATUS, getStatus()).zzg("attributions", this.zzaMG).toString();
    }
}
