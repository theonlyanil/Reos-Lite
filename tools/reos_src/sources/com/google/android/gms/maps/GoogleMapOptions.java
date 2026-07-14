package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private Boolean zzaOR;
    private Boolean zzaOS;
    private int zzaOT;
    private CameraPosition zzaOU;
    private Boolean zzaOV;
    private Boolean zzaOW;
    private Boolean zzaOX;
    private Boolean zzaOY;
    private Boolean zzaOZ;
    private Boolean zzaPa;
    private Boolean zzaPb;
    private Boolean zzaPc;
    private Boolean zzaPd;

    public GoogleMapOptions() {
        this.zzaOT = -1;
        this.mVersionCode = 1;
    }

    GoogleMapOptions(int i, byte b2, byte b3, int i2, CameraPosition cameraPosition, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12) {
        this.zzaOT = -1;
        this.mVersionCode = i;
        this.zzaOR = com.google.android.gms.maps.internal.zza.zza(b2);
        this.zzaOS = com.google.android.gms.maps.internal.zza.zza(b3);
        this.zzaOT = i2;
        this.zzaOU = cameraPosition;
        this.zzaOV = com.google.android.gms.maps.internal.zza.zza(b4);
        this.zzaOW = com.google.android.gms.maps.internal.zza.zza(b5);
        this.zzaOX = com.google.android.gms.maps.internal.zza.zza(b6);
        this.zzaOY = com.google.android.gms.maps.internal.zza.zza(b7);
        this.zzaOZ = com.google.android.gms.maps.internal.zza.zza(b8);
        this.zzaPa = com.google.android.gms.maps.internal.zza.zza(b9);
        this.zzaPb = com.google.android.gms.maps.internal.zza.zza(b10);
        this.zzaPc = com.google.android.gms.maps.internal.zza.zza(b11);
        this.zzaPd = com.google.android.gms.maps.internal.zza.zza(b12);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(typedArrayObtainAttributes.getInt(com.google.android.gms.R.styleable.MapAttrs_mapType, -1));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_liteMode, false));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (typedArrayObtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(typedArrayObtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_ambientEnabled, false));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions ambientEnabled(boolean z) {
        this.zzaPd = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzaOU = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.zzaOW = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Boolean getAmbientEnabled() {
        return this.zzaPd;
    }

    public CameraPosition getCamera() {
        return this.zzaOU;
    }

    public Boolean getCompassEnabled() {
        return this.zzaOW;
    }

    public Boolean getLiteMode() {
        return this.zzaPb;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzaPc;
    }

    public int getMapType() {
        return this.zzaOT;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzaPa;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzaOX;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzaOZ;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaOS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZOrderOnTop() {
        return this.zzaOR;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzaOV;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaOY;
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.zzaPb = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzaPc = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.zzaOT = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzaPa = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzaOX = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzaOZ = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzaOS = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.zzaOR = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zzaOV = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzaOY = Boolean.valueOf(z);
        return this;
    }

    byte zzyV() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOR);
    }

    byte zzyW() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOS);
    }

    byte zzyX() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOV);
    }

    byte zzyY() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOW);
    }

    byte zzyZ() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOX);
    }

    byte zzza() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOY);
    }

    byte zzzb() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOZ);
    }

    byte zzzc() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaPa);
    }

    byte zzzd() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaPb);
    }

    byte zzze() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaPc);
    }

    byte zzzf() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaPd);
    }
}
