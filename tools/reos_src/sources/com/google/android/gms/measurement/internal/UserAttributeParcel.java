package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class UserAttributeParcel implements SafeParcelable {
    public static final zzad CREATOR = new zzad();
    public final String name;
    public final int versionCode;
    public final String zzaSM;
    public final long zzaVg;
    public final Long zzaVh;
    public final Float zzaVi;
    public final String zzakS;

    UserAttributeParcel(int i, String str, long j, Long l, Float f2, String str2, String str3) {
        this.versionCode = i;
        this.name = str;
        this.zzaVg = j;
        this.zzaVh = l;
        this.zzaVi = f2;
        this.zzakS = str2;
        this.zzaSM = str3;
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        com.google.android.gms.common.internal.zzx.zzcG(str);
        this.versionCode = 1;
        this.name = str;
        this.zzaVg = j;
        this.zzaSM = str2;
        if (obj == null) {
            this.zzaVh = null;
            this.zzaVi = null;
            this.zzakS = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzaVh = (Long) obj;
            this.zzaVi = null;
            this.zzakS = null;
        } else if (obj instanceof Float) {
            this.zzaVh = null;
            this.zzaVi = (Float) obj;
            this.zzakS = null;
        } else {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.zzaVh = null;
            this.zzaVi = null;
            this.zzakS = (String) obj;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getValue() {
        if (this.zzaVh != null) {
            return this.zzaVh;
        }
        if (this.zzaVi != null) {
            return this.zzaVi;
        }
        if (this.zzakS != null) {
            return this.zzakS;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }
}
