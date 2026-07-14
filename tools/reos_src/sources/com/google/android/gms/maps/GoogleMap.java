package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.internal.zzj;
import com.google.android.gms.maps.internal.zzk;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzh;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaOy;
    private UiSettings zzaOz;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback zzaOQ;

        zza(CancelableCallback cancelableCallback) {
            this.zzaOQ = cancelableCallback;
        }

        @Override // com.google.android.gms.maps.internal.zzb
        public void onCancel() {
            this.zzaOQ.onCancel();
        }

        @Override // com.google.android.gms.maps.internal.zzb
        public void onFinish() {
            this.zzaOQ.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.zzaOy = (IGoogleMapDelegate) zzx.zzy(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.zzaOy.addCircle(circleOptions));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            zzc zzcVarAddGroundOverlay = this.zzaOy.addGroundOverlay(groundOverlayOptions);
            if (zzcVarAddGroundOverlay != null) {
                return new GroundOverlay(zzcVarAddGroundOverlay);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            zzf zzfVarAddMarker = this.zzaOy.addMarker(markerOptions);
            if (zzfVarAddMarker != null) {
                return new Marker(zzfVarAddMarker);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.zzaOy.addPolygon(polygonOptions));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.zzaOy.addPolyline(polylineOptions));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            zzh zzhVarAddTileOverlay = this.zzaOy.addTileOverlay(tileOverlayOptions);
            if (zzhVarAddTileOverlay != null) {
                return new TileOverlay(zzhVarAddTileOverlay);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.zzaOy.animateCamera(cameraUpdate.zzyS());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.zzaOy.animateCameraWithDurationAndCallback(cameraUpdate.zzyS(), i, cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.zzaOy.animateCameraWithCallback(cameraUpdate.zzyS(), cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void clear() {
        try {
            this.zzaOy.clear();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzaOy.getCameraPosition();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.zzaOy.getFocusedBuilding();
            if (focusedBuilding != null) {
                return new IndoorBuilding(focusedBuilding);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int getMapType() {
        try {
            return this.zzaOy.getMapType();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzaOy.getMaxZoomLevel();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzaOy.getMinZoomLevel();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzaOy.getMyLocation();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzaOy.getProjection());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzaOz == null) {
                this.zzaOz = new UiSettings(this.zzaOy.getUiSettings());
            }
            return this.zzaOz;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzaOy.isBuildingsEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzaOy.isIndoorEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzaOy.isMyLocationEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzaOy.isTrafficEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.zzaOy.moveCamera(cameraUpdate.zzyS());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.zzaOy.setBuildingsEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.zzaOy.setContentDescription(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.zzaOy.setIndoorEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter infoWindowAdapter) {
        try {
            if (infoWindowAdapter == null) {
                this.zzaOy.setInfoWindowAdapter(null);
            } else {
                this.zzaOy.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza() { // from class: com.google.android.gms.maps.GoogleMap.13
                    @Override // com.google.android.gms.maps.internal.zzd
                    public com.google.android.gms.dynamic.zzd zzf(zzf zzfVar) {
                        return zze.zzB(infoWindowAdapter.getInfoWindow(new Marker(zzfVar)));
                    }

                    @Override // com.google.android.gms.maps.internal.zzd
                    public com.google.android.gms.dynamic.zzd zzg(zzf zzfVar) {
                        return zze.zzB(infoWindowAdapter.getInfoContents(new Marker(zzfVar)));
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setLocationSource(final LocationSource locationSource) {
        try {
            if (locationSource == null) {
                this.zzaOy.setLocationSource(null);
            } else {
                this.zzaOy.setLocationSource(new ILocationSourceDelegate.zza() { // from class: com.google.android.gms.maps.GoogleMap.6
                    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
                    public void activate(final com.google.android.gms.maps.internal.zzh zzhVar) {
                        locationSource.activate(new LocationSource.OnLocationChangedListener() { // from class: com.google.android.gms.maps.GoogleMap.6.1
                            @Override // com.google.android.gms.maps.LocationSource.OnLocationChangedListener
                            public void onLocationChanged(Location location) {
                                try {
                                    zzhVar.zzd(location);
                                } catch (RemoteException e2) {
                                    throw new RuntimeRemoteException(e2);
                                }
                            }
                        });
                    }

                    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
                    public void deactivate() {
                        locationSource.deactivate();
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setMapType(int i) {
        try {
            this.zzaOy.setMapType(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.zzaOy.setMyLocationEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener onCameraChangeListener) {
        try {
            if (onCameraChangeListener == null) {
                this.zzaOy.setOnCameraChangeListener(null);
            } else {
                this.zzaOy.setOnCameraChangeListener(new com.google.android.gms.maps.internal.zze.zza() { // from class: com.google.android.gms.maps.GoogleMap.7
                    @Override // com.google.android.gms.maps.internal.zze
                    public void onCameraChange(CameraPosition cameraPosition) {
                        onCameraChangeListener.onCameraChange(cameraPosition);
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener onIndoorStateChangeListener) {
        try {
            if (onIndoorStateChangeListener == null) {
                this.zzaOy.setOnIndoorStateChangeListener(null);
            } else {
                this.zzaOy.setOnIndoorStateChangeListener(new com.google.android.gms.maps.internal.zzf.zza() { // from class: com.google.android.gms.maps.GoogleMap.1
                    @Override // com.google.android.gms.maps.internal.zzf
                    public void onIndoorBuildingFocused() {
                        onIndoorStateChangeListener.onIndoorBuildingFocused();
                    }

                    @Override // com.google.android.gms.maps.internal.zzf
                    public void zza(zzd zzdVar) {
                        onIndoorStateChangeListener.onIndoorLevelActivated(new IndoorBuilding(zzdVar));
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            if (onInfoWindowClickListener == null) {
                this.zzaOy.setOnInfoWindowClickListener(null);
            } else {
                this.zzaOy.setOnInfoWindowClickListener(new zzg.zza() { // from class: com.google.android.gms.maps.GoogleMap.12
                    @Override // com.google.android.gms.maps.internal.zzg
                    public void zze(zzf zzfVar) {
                        onInfoWindowClickListener.onInfoWindowClick(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnMapClickListener(final OnMapClickListener onMapClickListener) {
        try {
            if (onMapClickListener == null) {
                this.zzaOy.setOnMapClickListener(null);
            } else {
                this.zzaOy.setOnMapClickListener(new zzi.zza() { // from class: com.google.android.gms.maps.GoogleMap.8
                    @Override // com.google.android.gms.maps.internal.zzi
                    public void onMapClick(LatLng latLng) {
                        onMapClickListener.onMapClick(latLng);
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback onMapLoadedCallback) {
        try {
            if (onMapLoadedCallback == null) {
                this.zzaOy.setOnMapLoadedCallback(null);
            } else {
                this.zzaOy.setOnMapLoadedCallback(new zzj.zza() { // from class: com.google.android.gms.maps.GoogleMap.4
                    @Override // com.google.android.gms.maps.internal.zzj
                    public void onMapLoaded() throws RemoteException {
                        onMapLoadedCallback.onMapLoaded();
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener onMapLongClickListener) {
        try {
            if (onMapLongClickListener == null) {
                this.zzaOy.setOnMapLongClickListener(null);
            } else {
                this.zzaOy.setOnMapLongClickListener(new zzk.zza() { // from class: com.google.android.gms.maps.GoogleMap.9
                    @Override // com.google.android.gms.maps.internal.zzk
                    public void onMapLongClick(LatLng latLng) {
                        onMapLongClickListener.onMapLongClick(latLng);
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener onMarkerClickListener) {
        try {
            if (onMarkerClickListener == null) {
                this.zzaOy.setOnMarkerClickListener(null);
            } else {
                this.zzaOy.setOnMarkerClickListener(new zzm.zza() { // from class: com.google.android.gms.maps.GoogleMap.10
                    @Override // com.google.android.gms.maps.internal.zzm
                    public boolean zza(zzf zzfVar) {
                        return onMarkerClickListener.onMarkerClick(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener onMarkerDragListener) {
        try {
            if (onMarkerDragListener == null) {
                this.zzaOy.setOnMarkerDragListener(null);
            } else {
                this.zzaOy.setOnMarkerDragListener(new zzn.zza() { // from class: com.google.android.gms.maps.GoogleMap.11
                    @Override // com.google.android.gms.maps.internal.zzn
                    public void zzb(zzf zzfVar) {
                        onMarkerDragListener.onMarkerDragStart(new Marker(zzfVar));
                    }

                    @Override // com.google.android.gms.maps.internal.zzn
                    public void zzc(zzf zzfVar) {
                        onMarkerDragListener.onMarkerDragEnd(new Marker(zzfVar));
                    }

                    @Override // com.google.android.gms.maps.internal.zzn
                    public void zzd(zzf zzfVar) {
                        onMarkerDragListener.onMarkerDrag(new Marker(zzfVar));
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        try {
            if (onMyLocationButtonClickListener == null) {
                this.zzaOy.setOnMyLocationButtonClickListener(null);
            } else {
                this.zzaOy.setOnMyLocationButtonClickListener(new zzo.zza() { // from class: com.google.android.gms.maps.GoogleMap.3
                    @Override // com.google.android.gms.maps.internal.zzo
                    public boolean onMyLocationButtonClick() throws RemoteException {
                        return onMyLocationButtonClickListener.onMyLocationButtonClick();
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            if (onMyLocationChangeListener == null) {
                this.zzaOy.setOnMyLocationChangeListener(null);
            } else {
                this.zzaOy.setOnMyLocationChangeListener(new zzp.zza() { // from class: com.google.android.gms.maps.GoogleMap.2
                    @Override // com.google.android.gms.maps.internal.zzp
                    public void zzq(com.google.android.gms.dynamic.zzd zzdVar) {
                        onMyLocationChangeListener.onMyLocationChange((Location) zze.zzp(zzdVar));
                    }
                });
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.zzaOy.setPadding(i, i2, i3, i4);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.zzaOy.setTrafficEnabled(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(final SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.zzaOy.snapshot(new zzw.zza() { // from class: com.google.android.gms.maps.GoogleMap.5
                @Override // com.google.android.gms.maps.internal.zzw
                public void onSnapshotReady(Bitmap bitmap2) throws RemoteException {
                    snapshotReadyCallback.onSnapshotReady(bitmap2);
                }

                @Override // com.google.android.gms.maps.internal.zzw
                public void zzr(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                    snapshotReadyCallback.onSnapshotReady((Bitmap) zze.zzp(zzdVar));
                }
            }, (zze) (bitmap != null ? zze.zzB(bitmap) : null));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzaOy.stopAnimation();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    IGoogleMapDelegate zzyU() {
        return this.zzaOy;
    }
}
