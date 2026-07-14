package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class Circle {
    private final com.google.android.gms.maps.model.internal.zzb zzaQd;

    public Circle(com.google.android.gms.maps.model.internal.zzb zzbVar) {
        this.zzaQd = (com.google.android.gms.maps.model.internal.zzb) zzx.zzy(zzbVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.zzaQd.zza(((Circle) obj).zzaQd);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public LatLng getCenter() {
        try {
            return this.zzaQd.getCenter();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int getFillColor() {
        try {
            return this.zzaQd.getFillColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getId() {
        try {
            return this.zzaQd.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public double getRadius() {
        try {
            return this.zzaQd.getRadius();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zzaQd.getStrokeColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zzaQd.getStrokeWidth();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQd.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQd.hashCodeRemote();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQd.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void remove() {
        try {
            this.zzaQd.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setCenter(LatLng latLng) {
        try {
            this.zzaQd.setCenter(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setFillColor(int i) {
        try {
            this.zzaQd.setFillColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setRadius(double d2) {
        try {
            this.zzaQd.setRadius(d2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setStrokeColor(int i) {
        try {
            this.zzaQd.setStrokeColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setStrokeWidth(float f2) {
        try {
            this.zzaQd.setStrokeWidth(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.zzaQd.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.zzaQd.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
