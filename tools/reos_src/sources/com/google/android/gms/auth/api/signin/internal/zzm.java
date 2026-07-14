package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public class zzm implements Parcelable.Creator<SignInConfiguration> {
    static void zza(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, signInConfiguration.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, signInConfiguration.zzmP(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, signInConfiguration.zzmB(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) signInConfiguration.zzmQ(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) signInConfiguration.zzmR(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) signInConfiguration.zzmS(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, signInConfiguration.zzmT(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
    public SignInConfiguration createFromParcel(Parcel parcel) {
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        FacebookSignInOptions facebookSignInOptions = null;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
        String strZzp2 = null;
        String strZzp3 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    emailSignInOptions = (EmailSignInOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, EmailSignInOptions.CREATOR);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, GoogleSignInOptions.CREATOR);
                    break;
                case 6:
                    facebookSignInOptions = (FacebookSignInOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, FacebookSignInOptions.CREATOR);
                    break;
                case 7:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0094zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SignInConfiguration(iZzg, strZzp3, strZzp2, emailSignInOptions, googleSignInOptions, facebookSignInOptions, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaQ, reason: merged with bridge method [inline-methods] */
    public SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
