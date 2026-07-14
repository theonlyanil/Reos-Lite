package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PolylineOptions implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    private int mColor;
    private final int mVersionCode;
    private final List<LatLng> zzaQL;
    private boolean zzaQN;
    private float zzaQj;
    private boolean zzaQk;
    private float zzaQo;

    public PolylineOptions() {
        this.zzaQo = 10.0f;
        this.mColor = -16777216;
        this.zzaQj = BitmapDescriptorFactory.HUE_RED;
        this.zzaQk = true;
        this.zzaQN = false;
        this.mVersionCode = 1;
        this.zzaQL = new ArrayList();
    }

    PolylineOptions(int i, List list, float f2, int i2, float f3, boolean z, boolean z2) {
        this.zzaQo = 10.0f;
        this.mColor = -16777216;
        this.zzaQj = BitmapDescriptorFactory.HUE_RED;
        this.zzaQk = true;
        this.zzaQN = false;
        this.mVersionCode = i;
        this.zzaQL = list;
        this.zzaQo = f2;
        this.mColor = i2;
        this.zzaQj = f3;
        this.zzaQk = z;
        this.zzaQN = z2;
    }

    public PolylineOptions add(LatLng latLng) {
        this.zzaQL.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.zzaQL.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.zzaQL.add(it.next());
        }
        return this;
    }

    public PolylineOptions color(int i) {
        this.mColor = i;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z) {
        this.zzaQN = z;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.zzaQL;
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

    public boolean isGeodesic() {
        return this.zzaQN;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public PolylineOptions visible(boolean z) {
        this.zzaQk = z;
        return this;
    }

    public PolylineOptions width(float f2) {
        this.zzaQo = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public PolylineOptions zIndex(float f2) {
        this.zzaQj = f2;
        return this;
    }
}
