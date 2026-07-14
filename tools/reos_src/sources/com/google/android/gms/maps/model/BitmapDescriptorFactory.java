package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static com.google.android.gms.maps.model.internal.zza zzaPY;

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(zzzt().zzzy());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor defaultMarker(float f2) {
        try {
            return new BitmapDescriptor(zzzt().zzh(f2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            return new BitmapDescriptor(zzzt().zzeb(str));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        try {
            return new BitmapDescriptor(zzzt().zzb(bitmap));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            return new BitmapDescriptor(zzzt().zzec(str));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return new BitmapDescriptor(zzzt().zzed(str));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        try {
            return new BitmapDescriptor(zzzt().zzin(i));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static void zza(com.google.android.gms.maps.model.internal.zza zzaVar) {
        if (zzaPY != null) {
            return;
        }
        zzaPY = (com.google.android.gms.maps.model.internal.zza) zzx.zzy(zzaVar);
    }

    private static com.google.android.gms.maps.model.internal.zza zzzt() {
        return (com.google.android.gms.maps.model.internal.zza) zzx.zzb(zzaPY, "IBitmapDescriptorFactory is not initialized");
    }
}
