package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ResolveAccountResponse implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzz();
    final int mVersionCode;
    private boolean zzafR;
    IBinder zzaiS;
    private ConnectionResult zzakB;
    private boolean zzakC;

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzaiS = iBinder;
        this.zzakB = connectionResult;
        this.zzafR = z;
        this.zzakC = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.zzakB.equals(resolveAccountResponse.zzakB) && zzqH().equals(resolveAccountResponse.zzqH());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }

    public zzp zzqH() {
        return zzp.zza.zzaP(this.zzaiS);
    }

    public ConnectionResult zzqI() {
        return this.zzakB;
    }

    public boolean zzqJ() {
        return this.zzafR;
    }

    public boolean zzqK() {
        return this.zzakC;
    }
}
