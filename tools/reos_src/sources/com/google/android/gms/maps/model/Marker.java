package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class Marker {
    private final com.google.android.gms.maps.model.internal.zzf zzaQA;

    public Marker(com.google.android.gms.maps.model.internal.zzf zzfVar) {
        this.zzaQA = (com.google.android.gms.maps.model.internal.zzf) zzx.zzy(zzfVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.zzaQA.zzh(((Marker) obj).zzaQA);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getAlpha() {
        try {
            return this.zzaQA.getAlpha();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getId() {
        try {
            return this.zzaQA.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public LatLng getPosition() {
        try {
            return this.zzaQA.getPosition();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public float getRotation() {
        try {
            return this.zzaQA.getRotation();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getSnippet() {
        try {
            return this.zzaQA.getSnippet();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public String getTitle() {
        try {
            return this.zzaQA.getTitle();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQA.hashCodeRemote();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void hideInfoWindow() {
        try {
            this.zzaQA.hideInfoWindow();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isDraggable() {
        try {
            return this.zzaQA.isDraggable();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isFlat() {
        try {
            return this.zzaQA.isFlat();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            return this.zzaQA.isInfoWindowShown();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isVisible() {
        try {
            return this.zzaQA.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void remove() {
        try {
            this.zzaQA.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setAlpha(float f2) {
        try {
            this.zzaQA.setAlpha(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setAnchor(float f2, float f3) {
        try {
            this.zzaQA.setAnchor(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setDraggable(boolean z) {
        try {
            this.zzaQA.setDraggable(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setFlat(boolean z) {
        try {
            this.zzaQA.setFlat(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        try {
            this.zzaQA.zzx(bitmapDescriptor.zzyS());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setInfoWindowAnchor(float f2, float f3) {
        try {
            this.zzaQA.setInfoWindowAnchor(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.zzaQA.setPosition(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setRotation(float f2) {
        try {
            this.zzaQA.setRotation(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setSnippet(String str) {
        try {
            this.zzaQA.setSnippet(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setTitle(String str) {
        try {
            this.zzaQA.setTitle(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.zzaQA.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void showInfoWindow() {
        try {
            this.zzaQA.showInfoWindow();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
