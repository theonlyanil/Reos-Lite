package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class UiSettings {
    private final IUiSettingsDelegate zzaPV;

    UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.zzaPV = iUiSettingsDelegate;
    }

    public boolean isCompassEnabled() {
        try {
            return this.zzaPV.isCompassEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            return this.zzaPV.isIndoorLevelPickerEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isMapToolbarEnabled() {
        try {
            return this.zzaPV.isMapToolbarEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.zzaPV.isMyLocationButtonEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.zzaPV.isRotateGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.zzaPV.isScrollGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.zzaPV.isTiltGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.zzaPV.isZoomControlsEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zzaPV.isZoomGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.zzaPV.setAllGesturesEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            this.zzaPV.setCompassEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setIndoorLevelPickerEnabled(boolean z) {
        try {
            this.zzaPV.setIndoorLevelPickerEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setMapToolbarEnabled(boolean z) {
        try {
            this.zzaPV.setMapToolbarEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.zzaPV.setMyLocationButtonEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        try {
            this.zzaPV.setRotateGesturesEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            this.zzaPV.setScrollGesturesEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        try {
            this.zzaPV.setTiltGesturesEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            this.zzaPV.setZoomControlsEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.zzaPV.setZoomGesturesEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
