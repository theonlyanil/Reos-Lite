package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private LatLng zzaQe;
    private double zzaQf;
    private float zzaQg;
    private int zzaQh;
    private int zzaQi;
    private float zzaQj;
    private boolean zzaQk;

    public CircleOptions() {
        this.zzaQe = null;
        this.zzaQf = 0.0d;
        this.zzaQg = 10.0f;
        this.zzaQh = -16777216;
        this.zzaQi = 0;
        this.zzaQj = BitmapDescriptorFactory.HUE_RED;
        this.zzaQk = true;
        this.mVersionCode = 1;
    }

    CircleOptions(int i, LatLng latLng, double d2, float f2, int i2, int i3, float f3, boolean z) {
        this.zzaQe = null;
        this.zzaQf = 0.0d;
        this.zzaQg = 10.0f;
        this.zzaQh = -16777216;
        this.zzaQi = 0;
        this.zzaQj = BitmapDescriptorFactory.HUE_RED;
        this.zzaQk = true;
        this.mVersionCode = i;
        this.zzaQe = latLng;
        this.zzaQf = d2;
        this.zzaQg = f2;
        this.zzaQh = i2;
        this.zzaQi = i3;
        this.zzaQj = f3;
        this.zzaQk = z;
    }

    public CircleOptions center(LatLng latLng) {
        this.zzaQe = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.zzaQi = i;
        return this;
    }

    public LatLng getCenter() {
        return this.zzaQe;
    }

    public int getFillColor() {
        return this.zzaQi;
    }

    public double getRadius() {
        return this.zzaQf;
    }

    public int getStrokeColor() {
        return this.zzaQh;
    }

    public float getStrokeWidth() {
        return this.zzaQg;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaQj;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public CircleOptions radius(double d2) {
        this.zzaQf = d2;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.zzaQh = i;
        return this;
    }

    public CircleOptions strokeWidth(float f2) {
        this.zzaQg = f2;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.zzaQk = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public CircleOptions zIndex(float f2) {
        this.zzaQj = f2;
        return this;
    }
}
