package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Polygon {
    private final com.google.android.gms.maps.model.internal.zzg zzaQK;

    public Polygon(com.google.android.gms.maps.model.internal.zzg zzgVar) {
        this.zzaQK = (com.google.android.gms.maps.model.internal.zzg) zzx.zzy(zzgVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.zzaQK.zza(((Polygon) obj).zzaQK);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int getFillColor() {
        try {
            return this.zzaQK.getFillColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public List<List<LatLng>> getHoles() {
        try {
            return this.zzaQK.getHoles();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getId() {
        try {
            return this.zzaQK.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.zzaQK.getPoints();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zzaQK.getStrokeColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zzaQK.getStrokeWidth();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQK.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQK.hashCodeRemote();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.zzaQK.isGeodesic();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQK.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void remove() {
        try {
            this.zzaQK.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setFillColor(int i) {
        try {
            this.zzaQK.setFillColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setGeodesic(boolean z) {
        try {
            this.zzaQK.setGeodesic(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setHoles(List<? extends List<LatLng>> list) {
        try {
            this.zzaQK.setHoles(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.zzaQK.setPoints(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setStrokeColor(int i) {
        try {
            this.zzaQK.setStrokeColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setStrokeWidth(float f2) {
        try {
            this.zzaQK.setStrokeWidth(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.zzaQK.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.zzaQK.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
