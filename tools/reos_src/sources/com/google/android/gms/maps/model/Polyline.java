package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Polyline {
    private final IPolylineDelegate zzaQO;

    public Polyline(IPolylineDelegate iPolylineDelegate) {
        this.zzaQO = (IPolylineDelegate) zzx.zzy(iPolylineDelegate);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.zzaQO.equalsRemote(((Polyline) obj).zzaQO);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int getColor() {
        try {
            return this.zzaQO.getColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getId() {
        try {
            return this.zzaQO.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.zzaQO.getPoints();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getWidth() {
        try {
            return this.zzaQO.getWidth();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQO.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQO.hashCodeRemote();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.zzaQO.isGeodesic();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQO.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void remove() {
        try {
            this.zzaQO.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setColor(int i) {
        try {
            this.zzaQO.setColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setGeodesic(boolean z) {
        try {
            this.zzaQO.setGeodesic(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.zzaQO.setPoints(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.zzaQO.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setWidth(float f2) {
        try {
            this.zzaQO.setWidth(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.zzaQO.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
