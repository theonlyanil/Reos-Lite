package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableGeofence implements SafeParcelable, Geofence {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private final String zzDX;
    private final int zzaKO;
    private final short zzaKQ;
    private final double zzaKR;
    private final double zzaKS;
    private final float zzaKT;
    private final int zzaKU;
    private final int zzaKV;
    private final long zzaMl;

    public ParcelableGeofence(int i, String str, int i2, short s, double d2, double d3, float f2, long j, int i3, int i4) {
        zzdU(str);
        zze(f2);
        zza(d2, d3);
        int iZzhw = zzhw(i2);
        this.mVersionCode = i;
        this.zzaKQ = s;
        this.zzDX = str;
        this.zzaKR = d2;
        this.zzaKS = d3;
        this.zzaKT = f2;
        this.zzaMl = j;
        this.zzaKO = iZzhw;
        this.zzaKU = i3;
        this.zzaKV = i4;
    }

    public ParcelableGeofence(String str, int i, short s, double d2, double d3, float f2, long j, int i2, int i3) {
        this(1, str, i, s, d2, d3, f2, j, i2, i3);
    }

    private static void zza(double d2, double d3) {
        if (d2 > 90.0d || d2 < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d2);
        }
        if (d3 > 180.0d || d3 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d3);
        }
    }

    private static void zzdU(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static void zze(float f2) {
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid radius: " + f2);
        }
    }

    private static int zzhw(int i) {
        int i2 = i & 7;
        if (i2 == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + i);
        }
        return i2;
    }

    private static String zzhx(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static ParcelableGeofence zzo(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        ParcelableGeofence parcelableGeofenceCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return parcelableGeofenceCreateFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzo zzoVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ParcelableGeofence)) {
            ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
            return this.zzaKT == parcelableGeofence.zzaKT && this.zzaKR == parcelableGeofence.zzaKR && this.zzaKS == parcelableGeofence.zzaKS && this.zzaKQ == parcelableGeofence.zzaKQ;
        }
        return false;
    }

    public long getExpirationTime() {
        return this.zzaMl;
    }

    public double getLatitude() {
        return this.zzaKR;
    }

    public double getLongitude() {
        return this.zzaKS;
    }

    public int getNotificationResponsiveness() {
        return this.zzaKU;
    }

    @Override // com.google.android.gms.location.Geofence
    public String getRequestId() {
        return this.zzDX;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zzaKR);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zzaKS);
        return (((((((i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaKT)) * 31) + this.zzaKQ) * 31) + this.zzaKO;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", zzhx(this.zzaKQ), this.zzDX, Integer.valueOf(this.zzaKO), Double.valueOf(this.zzaKR), Double.valueOf(this.zzaKS), Float.valueOf(this.zzaKT), Integer.valueOf(this.zzaKU / 1000), Integer.valueOf(this.zzaKV), Long.valueOf(this.zzaMl));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo zzoVar = CREATOR;
        zzo.zza(this, parcel, i);
    }

    public short zzyh() {
        return this.zzaKQ;
    }

    public float zzyi() {
        return this.zzaKT;
    }

    public int zzyj() {
        return this.zzaKO;
    }

    public int zzyk() {
        return this.zzaKV;
    }
}
