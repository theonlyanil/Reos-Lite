package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1.0f;
    private final int mVersionCode;
    private float zzaQc;
    private float zzaQj;
    private boolean zzaQk;
    private BitmapDescriptor zzaQm;
    private LatLng zzaQn;
    private float zzaQo;
    private float zzaQp;
    private LatLngBounds zzaQq;
    private float zzaQr;
    private float zzaQs;
    private float zzaQt;

    public GroundOverlayOptions() {
        this.zzaQk = true;
        this.zzaQr = BitmapDescriptorFactory.HUE_RED;
        this.zzaQs = 0.5f;
        this.zzaQt = 0.5f;
        this.mVersionCode = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f2, float f3, LatLngBounds latLngBounds, float f4, float f5, boolean z, float f6, float f7, float f8) {
        this.zzaQk = true;
        this.zzaQr = BitmapDescriptorFactory.HUE_RED;
        this.zzaQs = 0.5f;
        this.zzaQt = 0.5f;
        this.mVersionCode = i;
        this.zzaQm = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzbs(iBinder));
        this.zzaQn = latLng;
        this.zzaQo = f2;
        this.zzaQp = f3;
        this.zzaQq = latLngBounds;
        this.zzaQc = f4;
        this.zzaQj = f5;
        this.zzaQk = z;
        this.zzaQr = f6;
        this.zzaQs = f7;
        this.zzaQt = f8;
    }

    private GroundOverlayOptions zza(LatLng latLng, float f2, float f3) {
        this.zzaQn = latLng;
        this.zzaQo = f2;
        this.zzaQp = f3;
        return this;
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        this.zzaQs = f2;
        this.zzaQt = f3;
        return this;
    }

    public GroundOverlayOptions bearing(float f2) {
        this.zzaQc = ((f2 % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.zzaQs;
    }

    public float getAnchorV() {
        return this.zzaQt;
    }

    public float getBearing() {
        return this.zzaQc;
    }

    public LatLngBounds getBounds() {
        return this.zzaQq;
    }

    public float getHeight() {
        return this.zzaQp;
    }

    public BitmapDescriptor getImage() {
        return this.zzaQm;
    }

    public LatLng getLocation() {
        return this.zzaQn;
    }

    public float getTransparency() {
        return this.zzaQr;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getWidth() {
        return this.zzaQo;
    }

    public float getZIndex() {
        return this.zzaQj;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.zzaQm = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public GroundOverlayOptions position(LatLng latLng, float f2) {
        zzx.zza(this.zzaQq == null, "Position has already been set using positionFromBounds");
        zzx.zzb(latLng != null, "Location must be specified");
        zzx.zzb(f2 >= BitmapDescriptorFactory.HUE_RED, "Width must be non-negative");
        return zza(latLng, f2, -1.0f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f2, float f3) {
        zzx.zza(this.zzaQq == null, "Position has already been set using positionFromBounds");
        zzx.zzb(latLng != null, "Location must be specified");
        zzx.zzb(f2 >= BitmapDescriptorFactory.HUE_RED, "Width must be non-negative");
        zzx.zzb(f3 >= BitmapDescriptorFactory.HUE_RED, "Height must be non-negative");
        return zza(latLng, f2, f3);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        zzx.zza(this.zzaQn == null, "Position has already been set using position: " + this.zzaQn);
        this.zzaQq = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f2) {
        zzx.zzb(f2 >= BitmapDescriptorFactory.HUE_RED && f2 <= 1.0f, "Transparency must be in the range [0..1]");
        this.zzaQr = f2;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.zzaQk = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f2) {
        this.zzaQj = f2;
        return this;
    }

    IBinder zzzu() {
        return this.zzaQm.zzyS().asBinder();
    }
}
