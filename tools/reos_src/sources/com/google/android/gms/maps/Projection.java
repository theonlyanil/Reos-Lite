package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

/* JADX INFO: loaded from: classes.dex */
public final class Projection {
    private final IProjectionDelegate zzaPs;

    Projection(IProjectionDelegate iProjectionDelegate) {
        this.zzaPs = iProjectionDelegate;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.zzaPs.fromScreenLocation(zze.zzB(point));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.zzaPs.getVisibleRegion();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return (Point) zze.zzp(this.zzaPs.toScreenLocation(latLng));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
