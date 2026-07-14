package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class GetServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();
    final int version;
    final int zzajA;
    int zzajB;
    String zzajC;
    IBinder zzajD;
    Scope[] zzajE;
    Bundle zzajF;
    Account zzajG;

    public GetServiceRequest(int i) {
        this.version = 2;
        this.zzajB = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzajA = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.version = i;
        this.zzajA = i2;
        this.zzajB = i3;
        this.zzajC = str;
        if (i < 2) {
            this.zzajG = zzaO(iBinder);
        } else {
            this.zzajD = iBinder;
            this.zzajG = account;
        }
        this.zzajE = scopeArr;
        this.zzajF = bundle;
    }

    private Account zzaO(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zzb(zzp.zza.zzaP(iBinder));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public GetServiceRequest zzc(Account account) {
        this.zzajG = account;
        return this;
    }

    public GetServiceRequest zzc(zzp zzpVar) {
        if (zzpVar != null) {
            this.zzajD = zzpVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzcA(String str) {
        this.zzajC = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.zzajE = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzj(Bundle bundle) {
        this.zzajF = bundle;
        return this;
    }
}
