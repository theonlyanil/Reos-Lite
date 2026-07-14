package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznm;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class UserDataType implements SafeParcelable {
    final int mVersionCode;
    final String zzIx;
    final int zzaNi;
    public static final UserDataType zzaNe = zzy("test_type", 1);
    public static final UserDataType zzaNf = zzy("labeled_place", 6);
    public static final UserDataType zzaNg = zzy("here_content", 7);
    public static final Set<UserDataType> zzaNh = zznm.zza(zzaNe, zzaNf, zzaNg);
    public static final zzm CREATOR = new zzm();

    UserDataType(int i, String str, int i2) {
        zzx.zzcG(str);
        this.mVersionCode = i;
        this.zzIx = str;
        this.zzaNi = i2;
    }

    private static UserDataType zzy(String str, int i) {
        return new UserDataType(0, str, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzm zzmVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) obj;
        return this.zzIx.equals(userDataType.zzIx) && this.zzaNi == userDataType.zzaNi;
    }

    public int hashCode() {
        return this.zzIx.hashCode();
    }

    public String toString() {
        return this.zzIx;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm zzmVar = CREATOR;
        zzm.zza(this, parcel, i);
    }
}
