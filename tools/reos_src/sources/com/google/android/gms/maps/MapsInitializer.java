package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class MapsInitializer {
    private static boolean zznK = false;

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        int i = 0;
        synchronized (MapsInitializer.class) {
            try {
                zzx.zzb(context, "Context is null");
                if (!zznK) {
                    try {
                        zza(zzy.zzaP(context));
                        zznK = true;
                    } catch (GooglePlayServicesNotAvailableException e2) {
                        i = e2.errorCode;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public static void zza(zzc zzcVar) {
        try {
            CameraUpdateFactory.zza(zzcVar.zzzp());
            BitmapDescriptorFactory.zza(zzcVar.zzzq());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
