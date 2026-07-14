package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private float mAlpha;
    private final int mVersionCode;
    private LatLng zzaPH;
    private String zzaQB;
    private BitmapDescriptor zzaQC;
    private boolean zzaQD;
    private boolean zzaQE;
    private float zzaQF;
    private float zzaQG;
    private float zzaQH;
    private boolean zzaQk;
    private float zzaQs;
    private float zzaQt;
    private String zzank;

    public MarkerOptions() {
        this.zzaQs = 0.5f;
        this.zzaQt = 1.0f;
        this.zzaQk = true;
        this.zzaQE = false;
        this.zzaQF = BitmapDescriptorFactory.HUE_RED;
        this.zzaQG = 0.5f;
        this.zzaQH = BitmapDescriptorFactory.HUE_RED;
        this.mAlpha = 1.0f;
        this.mVersionCode = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f2, float f3, boolean z, boolean z2, boolean z3, float f4, float f5, float f6, float f7) {
        this.zzaQs = 0.5f;
        this.zzaQt = 1.0f;
        this.zzaQk = true;
        this.zzaQE = false;
        this.zzaQF = BitmapDescriptorFactory.HUE_RED;
        this.zzaQG = 0.5f;
        this.zzaQH = BitmapDescriptorFactory.HUE_RED;
        this.mAlpha = 1.0f;
        this.mVersionCode = i;
        this.zzaPH = latLng;
        this.zzank = str;
        this.zzaQB = str2;
        this.zzaQC = iBinder == null ? null : new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzbs(iBinder));
        this.zzaQs = f2;
        this.zzaQt = f3;
        this.zzaQD = z;
        this.zzaQk = z2;
        this.zzaQE = z3;
        this.zzaQF = f4;
        this.zzaQG = f5;
        this.zzaQH = f6;
        this.mAlpha = f7;
    }

    public MarkerOptions alpha(float f2) {
        this.mAlpha = f2;
        return this;
    }

    public MarkerOptions anchor(float f2, float f3) {
        this.zzaQs = f2;
        this.zzaQt = f3;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z) {
        this.zzaQD = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.zzaQE = z;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.zzaQs;
    }

    public float getAnchorV() {
        return this.zzaQt;
    }

    public BitmapDescriptor getIcon() {
        return this.zzaQC;
    }

    public float getInfoWindowAnchorU() {
        return this.zzaQG;
    }

    public float getInfoWindowAnchorV() {
        return this.zzaQH;
    }

    public LatLng getPosition() {
        return this.zzaPH;
    }

    public float getRotation() {
        return this.zzaQF;
    }

    public String getSnippet() {
        return this.zzaQB;
    }

    public String getTitle() {
        return this.zzank;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.zzaQC = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f2, float f3) {
        this.zzaQG = f2;
        this.zzaQH = f3;
        return this;
    }

    public boolean isDraggable() {
        return this.zzaQD;
    }

    public boolean isFlat() {
        return this.zzaQE;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public MarkerOptions position(LatLng latLng) {
        this.zzaPH = latLng;
        return this;
    }

    public MarkerOptions rotation(float f2) {
        this.zzaQF = f2;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.zzaQB = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.zzank = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.zzaQk = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    IBinder zzzv() {
        if (this.zzaQC == null) {
            return null;
        }
        return this.zzaQC.zzyS().asBinder();
    }
}
