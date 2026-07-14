package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class GroundOverlay {
    private final com.google.android.gms.maps.model.internal.zzc zzaQl;

    public GroundOverlay(com.google.android.gms.maps.model.internal.zzc zzcVar) {
        this.zzaQl = (com.google.android.gms.maps.model.internal.zzc) zzx.zzy(zzcVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.zzaQl.zza(((GroundOverlay) obj).zzaQl);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getBearing() {
        try {
            return this.zzaQl.getBearing();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public LatLngBounds getBounds() {
        try {
            return this.zzaQl.getBounds();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getHeight() {
        try {
            return this.zzaQl.getHeight();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getId() {
        try {
            return this.zzaQl.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public LatLng getPosition() {
        try {
            return this.zzaQl.getPosition();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getTransparency() {
        try {
            return this.zzaQl.getTransparency();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getWidth() {
        try {
            return this.zzaQl.getWidth();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getZIndex() {
        try {
            return this.zzaQl.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQl.hashCodeRemote();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQl.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void remove() {
        try {
            this.zzaQl.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setBearing(float f2) {
        try {
            this.zzaQl.setBearing(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setDimensions(float f2) {
        try {
            this.zzaQl.setDimensions(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setDimensions(float f2, float f3) {
        try {
            this.zzaQl.zza(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            this.zzaQl.zzw(bitmapDescriptor.zzyS());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.zzaQl.setPosition(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.zzaQl.setPositionFromBounds(latLngBounds);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setTransparency(float f2) {
        try {
            this.zzaQl.setTransparency(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.zzaQl.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZIndex(float f2) {
        try {
            this.zzaQl.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
