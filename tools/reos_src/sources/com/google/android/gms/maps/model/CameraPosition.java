package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPosition implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final float bearing;
    private final int mVersionCode;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private LatLng zzaPZ;
        private float zzaQa;
        private float zzaQb;
        private float zzaQc;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.zzaPZ = cameraPosition.target;
            this.zzaQa = cameraPosition.zoom;
            this.zzaQb = cameraPosition.tilt;
            this.zzaQc = cameraPosition.bearing;
        }

        public Builder bearing(float f2) {
            this.zzaQc = f2;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.zzaPZ, this.zzaQa, this.zzaQb, this.zzaQc);
        }

        public Builder target(LatLng latLng) {
            this.zzaPZ = latLng;
            return this;
        }

        public Builder tilt(float f2) {
            this.zzaQb = f2;
            return this;
        }

        public Builder zoom(float f2) {
            this.zzaQa = f2;
            return this;
        }
    }

    CameraPosition(int i, LatLng latLng, float f2, float f3, float f4) {
        zzx.zzb(latLng, "null camera target");
        zzx.zzb(BitmapDescriptorFactory.HUE_RED <= f3 && f3 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f3));
        this.mVersionCode = i;
        this.target = latLng;
        this.zoom = f2;
        this.tilt = f3 + BitmapDescriptorFactory.HUE_RED;
        this.bearing = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        this(1, latLng, f2, f3, f4);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        LatLng latLng = new LatLng(typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLat, BitmapDescriptorFactory.HUE_RED) : 0.0f, typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLng, BitmapDescriptorFactory.HUE_RED) : 0.0f);
        Builder builder = builder();
        builder.target(latLng);
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraZoom, BitmapDescriptorFactory.HUE_RED));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraBearing, BitmapDescriptorFactory.HUE_RED));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTilt, BitmapDescriptorFactory.HUE_RED));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f2) {
        return new CameraPosition(latLng, f2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return zzw.zzx(this).zzg("target", this.target).zzg("zoom", Float.valueOf(this.zoom)).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
