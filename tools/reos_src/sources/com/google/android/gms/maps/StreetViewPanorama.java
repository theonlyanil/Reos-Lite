package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.internal.zzt;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* JADX INFO: loaded from: classes.dex */
public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate zzaPt;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.zzaPt = (IStreetViewPanoramaDelegate) zzx.zzy(iStreetViewPanoramaDelegate);
    }

    public void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) {
        try {
            this.zzaPt.animateTo(streetViewPanoramaCamera, j);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.zzaPt.getStreetViewPanoramaLocation();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.zzaPt.getPanoramaCamera();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.zzaPt.isPanningGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.zzaPt.isStreetNamesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.zzaPt.isUserNavigationEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zzaPt.isZoomGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            zzd zzdVarOrientationToPoint = this.zzaPt.orientationToPoint(streetViewPanoramaOrientation);
            if (zzdVarOrientationToPoint == null) {
                return null;
            }
            return (Point) zze.zzp(zzdVarOrientationToPoint);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.zzaPt.pointToOrientation(zze.zzB(point));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        try {
            if (onStreetViewPanoramaCameraChangeListener == null) {
                this.zzaPt.setOnStreetViewPanoramaCameraChangeListener(null);
            } else {
                this.zzaPt.setOnStreetViewPanoramaCameraChangeListener(new zzr.zza() { // from class: com.google.android.gms.maps.StreetViewPanorama.2
                    @Override // com.google.android.gms.maps.internal.zzr
                    public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera) {
                        onStreetViewPanoramaCameraChangeListener.onStreetViewPanoramaCameraChange(streetViewPanoramaCamera);
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        try {
            if (onStreetViewPanoramaChangeListener == null) {
                this.zzaPt.setOnStreetViewPanoramaChangeListener(null);
            } else {
                this.zzaPt.setOnStreetViewPanoramaChangeListener(new zzs.zza() { // from class: com.google.android.gms.maps.StreetViewPanorama.1
                    @Override // com.google.android.gms.maps.internal.zzs
                    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {
                        onStreetViewPanoramaChangeListener.onStreetViewPanoramaChange(streetViewPanoramaLocation);
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        try {
            if (onStreetViewPanoramaClickListener == null) {
                this.zzaPt.setOnStreetViewPanoramaClickListener(null);
            } else {
                this.zzaPt.setOnStreetViewPanoramaClickListener(new zzt.zza() { // from class: com.google.android.gms.maps.StreetViewPanorama.3
                    @Override // com.google.android.gms.maps.internal.zzt
                    public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
                        onStreetViewPanoramaClickListener.onStreetViewPanoramaClick(streetViewPanoramaOrientation);
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaLongClickListener(final OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        try {
            if (onStreetViewPanoramaLongClickListener == null) {
                this.zzaPt.setOnStreetViewPanoramaLongClickListener(null);
            } else {
                this.zzaPt.setOnStreetViewPanoramaLongClickListener(new zzu.zza() { // from class: com.google.android.gms.maps.StreetViewPanorama.4
                    @Override // com.google.android.gms.maps.internal.zzu
                    public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
                        onStreetViewPanoramaLongClickListener.onStreetViewPanoramaLongClick(streetViewPanoramaOrientation);
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPanningGesturesEnabled(boolean z) {
        try {
            this.zzaPt.enablePanning(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.zzaPt.setPosition(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng, int i) {
        try {
            this.zzaPt.setPositionWithRadius(latLng, i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(String str) {
        try {
            this.zzaPt.setPositionWithID(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setStreetNamesEnabled(boolean z) {
        try {
            this.zzaPt.enableStreetNames(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setUserNavigationEnabled(boolean z) {
        try {
            this.zzaPt.enableUserNavigation(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.zzaPt.enableZoom(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    IStreetViewPanoramaDelegate zzzj() {
        return this.zzaPt;
    }
}
