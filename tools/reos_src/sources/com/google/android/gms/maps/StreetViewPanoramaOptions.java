package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* JADX INFO: loaded from: classes.dex */
public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private Boolean zzaOS;
    private Boolean zzaOY;
    private StreetViewPanoramaCamera zzaPF;
    private String zzaPG;
    private LatLng zzaPH;
    private Integer zzaPI;
    private Boolean zzaPJ;
    private Boolean zzaPK;
    private Boolean zzaPL;

    public StreetViewPanoramaOptions() {
        this.zzaPJ = true;
        this.zzaOY = true;
        this.zzaPK = true;
        this.zzaPL = true;
        this.mVersionCode = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b2, byte b3, byte b4, byte b5, byte b6) {
        this.zzaPJ = true;
        this.zzaOY = true;
        this.zzaPK = true;
        this.zzaPL = true;
        this.mVersionCode = i;
        this.zzaPF = streetViewPanoramaCamera;
        this.zzaPH = latLng;
        this.zzaPI = num;
        this.zzaPG = str;
        this.zzaPJ = com.google.android.gms.maps.internal.zza.zza(b2);
        this.zzaOY = com.google.android.gms.maps.internal.zza.zza(b3);
        this.zzaPK = com.google.android.gms.maps.internal.zza.zza(b4);
        this.zzaPL = com.google.android.gms.maps.internal.zza.zza(b5);
        this.zzaOS = com.google.android.gms.maps.internal.zza.zza(b6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzaPK;
    }

    public String getPanoramaId() {
        return this.zzaPG;
    }

    public LatLng getPosition() {
        return this.zzaPH;
    }

    public Integer getRadius() {
        return this.zzaPI;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzaPL;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaPF;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaOS;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zzaPJ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaOY;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.zzaPK = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zzaPF = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.zzaPG = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.zzaPH = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.zzaPH = latLng;
        this.zzaPI = num;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.zzaPL = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.zzaOS = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.zzaPJ = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.zzaOY = Boolean.valueOf(z);
        return this;
    }

    byte zzyW() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOS);
    }

    byte zzza() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaOY);
    }

    byte zzzl() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaPJ);
    }

    byte zzzm() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaPK);
    }

    byte zzzn() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaPL);
    }
}
