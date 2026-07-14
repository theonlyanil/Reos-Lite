package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    Bundle extras;
    private final int mVersionCode;
    List<DetectedActivity> zzaKH;
    long zzaKI;
    long zzaKJ;
    int zzaKK;

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2, int i2, Bundle bundle) {
        this.mVersionCode = i;
        this.zzaKH = list;
        this.zzaKI = j;
        this.zzaKJ = j2;
        this.zzaKK = i2;
        this.extras = bundle;
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2) {
        this(detectedActivity, j, j2, 0, (Bundle) null);
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2, int i, Bundle bundle) {
        this((List<DetectedActivity>) Collections.singletonList(detectedActivity), j, j2, i, bundle);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2) {
        this(list, j, j2, 0, (Bundle) null);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i, Bundle bundle) {
        zzx.zzb(list != null && list.size() > 0, "Must have at least 1 detected activity");
        zzx.zzb(j > 0 && j2 > 0, "Must set times");
        this.mVersionCode = 2;
        this.zzaKH = list;
        this.zzaKI = j;
        this.zzaKJ = j2;
        this.zzaKK = i;
        this.extras = bundle;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        if (!(obj instanceof byte[])) {
            if (obj instanceof ActivityRecognitionResult) {
                return (ActivityRecognitionResult) obj;
            }
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
        parcelObtain.setDataPosition(0);
        return CREATOR.createFromParcel(parcelObtain);
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }

    private static boolean zzc(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!zzc(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
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
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.zzaKI == activityRecognitionResult.zzaKI && this.zzaKJ == activityRecognitionResult.zzaKJ && this.zzaKK == activityRecognitionResult.zzaKK && zzw.equal(this.zzaKH, activityRecognitionResult.zzaKH) && zzc(this.extras, activityRecognitionResult.extras);
    }

    public int getActivityConfidence(int i) {
        for (DetectedActivity detectedActivity : this.zzaKH) {
            if (detectedActivity.getType() == i) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzaKJ;
    }

    public DetectedActivity getMostProbableActivity() {
        return this.zzaKH.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzaKH;
    }

    public long getTime() {
        return this.zzaKI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaKI), Long.valueOf(this.zzaKJ), Integer.valueOf(this.zzaKK), this.zzaKH, this.extras);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzaKH + ", timeMillis=" + this.zzaKI + ", elapsedRealtimeMillis=" + this.zzaKJ + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ActivityRecognitionResultCreator.zza(this, parcel, i);
    }
}
