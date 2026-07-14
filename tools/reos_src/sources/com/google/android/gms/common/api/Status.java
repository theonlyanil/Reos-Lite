package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class Status implements Result, SafeParcelable {
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzabx;
    private final String zzadS;
    public static final Status zzaeX = new Status(0);
    public static final Status zzaeY = new Status(14);
    public static final Status zzaeZ = new Status(8);
    public static final Status zzafa = new Status(15);
    public static final Status zzafb = new Status(16);
    public static final Parcelable.Creator<Status> CREATOR = new zzd();

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.zzabx = i2;
        this.zzadS = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzoO() {
        return this.zzadS != null ? this.zzadS : CommonStatusCodes.getStatusCodeString(this.zzabx);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.zzabx == status.zzabx && zzw.equal(this.zzadS, status.zzadS) && zzw.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzabx;
    }

    public String getStatusMessage() {
        return this.zzadS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzabx), this.zzadS, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzabx == 16;
    }

    public boolean isInterrupted() {
        return this.zzabx == 14;
    }

    public boolean isSuccess() {
        return this.zzabx <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzx(this).zzg("statusCode", zzoO()).zzg("resolution", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    PendingIntent zzoN() {
        return this.mPendingIntent;
    }
}
