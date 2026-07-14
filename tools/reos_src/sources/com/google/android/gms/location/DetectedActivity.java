package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class DetectedActivity implements SafeParcelable {
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    private final int mVersionCode;
    int zzaKM;
    int zzaKN;
    public static final Comparator<DetectedActivity> zzaKL = new Comparator<DetectedActivity>() { // from class: com.google.android.gms.location.DetectedActivity.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int iCompareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return iCompareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : iCompareTo;
        }
    };
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();

    public DetectedActivity(int i, int i2) {
        this.mVersionCode = 1;
        this.zzaKM = i;
        this.zzaKN = i2;
    }

    public DetectedActivity(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaKM = i2;
        this.zzaKN = i3;
    }

    private int zzhe(int i) {
        if (i > 15) {
            return 4;
        }
        return i;
    }

    public static String zzhf(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 6:
            default:
                return Integer.toString(i);
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.zzaKM == detectedActivity.zzaKM && this.zzaKN == detectedActivity.zzaKN;
    }

    public int getConfidence() {
        return this.zzaKN;
    }

    public int getType() {
        return zzhe(this.zzaKM);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaKM), Integer.valueOf(this.zzaKN));
    }

    public String toString() {
        return "DetectedActivity [type=" + zzhf(getType()) + ", confidence=" + this.zzaKN + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        DetectedActivityCreator.zza(this, parcel, i);
    }
}
