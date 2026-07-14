package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private final List<LatLng> zzaQL;
    private final List<List<LatLng>> zzaQM;
    private boolean zzaQN;
    private float zzaQg;
    private int zzaQh;
    private int zzaQi;
    private float zzaQj;
    private boolean zzaQk;

    public PolygonOptions() {
        this.zzaQg = 10.0f;
        this.zzaQh = -16777216;
        this.zzaQi = 0;
        this.zzaQj = BitmapDescriptorFactory.HUE_RED;
        this.zzaQk = true;
        this.zzaQN = false;
        this.mVersionCode = 1;
        this.zzaQL = new ArrayList();
        this.zzaQM = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f2, int i2, int i3, float f3, boolean z, boolean z2) {
        this.zzaQg = 10.0f;
        this.zzaQh = -16777216;
        this.zzaQi = 0;
        this.zzaQj = BitmapDescriptorFactory.HUE_RED;
        this.zzaQk = true;
        this.zzaQN = false;
        this.mVersionCode = i;
        this.zzaQL = list;
        this.zzaQM = list2;
        this.zzaQg = f2;
        this.zzaQh = i2;
        this.zzaQi = i3;
        this.zzaQj = f3;
        this.zzaQk = z;
        this.zzaQN = z2;
    }

    public PolygonOptions add(LatLng latLng) {
        this.zzaQL.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.zzaQL.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.zzaQL.add(it.next());
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.zzaQM.add(arrayList);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.zzaQi = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.zzaQN = z;
        return this;
    }

    public int getFillColor() {
        return this.zzaQi;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzaQM;
    }

    public List<LatLng> getPoints() {
        return this.zzaQL;
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

    public boolean isGeodesic() {
        return this.zzaQN;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public PolygonOptions strokeColor(int i) {
        this.zzaQh = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f2) {
        this.zzaQg = f2;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.zzaQk = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public PolygonOptions zIndex(float f2) {
        this.zzaQj = f2;
        return this;
    }

    List zzzw() {
        return this.zzaQM;
    }
}
