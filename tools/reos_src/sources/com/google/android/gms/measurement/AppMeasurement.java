package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzt;

/* JADX INFO: loaded from: classes.dex */
public class AppMeasurement {
    private final zzt zzaQX;

    public interface zza {
        void zze(String str, String str2, Bundle bundle);
    }

    public AppMeasurement(zzt zztVar) {
        zzx.zzy(zztVar);
        this.zzaQX = zztVar;
    }

    public static AppMeasurement getInstance(Context context) {
        return zzt.zzaU(context).zzBC();
    }

    public void setMeasurementEnabled(boolean z) {
        this.zzaQX.zzBB().setMeasurementEnabled(z);
    }

    public void zzd(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzaQX.zzBB().zze(str, str2, bundle);
    }
}
