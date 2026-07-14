package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
    private static final List<SubstringEntity> zzaNj = Collections.emptyList();
    final int mVersionCode;
    final String zzaMO;
    final List<Integer> zzaMp;
    final String zzaNk;
    final List<SubstringEntity> zzaNl;
    final int zzaNm;
    final String zzaNn;
    final List<SubstringEntity> zzaNo;
    final String zzaNp;
    final List<SubstringEntity> zzaNq;

    public static class SubstringEntity implements SafeParcelable, AutocompletePrediction.Substring {
        public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzv();
        final int mLength;
        final int mOffset;
        final int mVersionCode;

        public SubstringEntity(int i, int i2, int i3) {
            this.mVersionCode = i;
            this.mOffset = i2;
            this.mLength = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) obj;
            return zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(substringEntity.mOffset)) && zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(substringEntity.mLength));
        }

        @Override // com.google.android.gms.location.places.AutocompletePrediction.Substring
        public int getLength() {
            return this.mLength;
        }

        @Override // com.google.android.gms.location.places.AutocompletePrediction.Substring
        public int getOffset() {
            return this.mOffset;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength));
        }

        public String toString() {
            return zzw.zzx(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzv.zza(this, parcel, i);
        }
    }

    AutocompletePredictionEntity(int i, String str, List<Integer> list, int i2, String str2, List<SubstringEntity> list2, String str3, List<SubstringEntity> list3, String str4, List<SubstringEntity> list4) {
        this.mVersionCode = i;
        this.zzaMO = str;
        this.zzaMp = list;
        this.zzaNm = i2;
        this.zzaNk = str2;
        this.zzaNl = list2;
        this.zzaNn = str3;
        this.zzaNo = list3;
        this.zzaNp = str4;
        this.zzaNq = list4;
    }

    public static AutocompletePredictionEntity zza(String str, List<Integer> list, int i, String str2, List<SubstringEntity> list2, String str3, List<SubstringEntity> list3, String str4, List<SubstringEntity> list4) {
        return new AutocompletePredictionEntity(0, str, list, i, (String) zzx.zzy(str2), list2, str3, list3, str4, list4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) obj;
        return zzw.equal(this.zzaMO, autocompletePredictionEntity.zzaMO) && zzw.equal(this.zzaMp, autocompletePredictionEntity.zzaMp) && zzw.equal(Integer.valueOf(this.zzaNm), Integer.valueOf(autocompletePredictionEntity.zzaNm)) && zzw.equal(this.zzaNk, autocompletePredictionEntity.zzaNk) && zzw.equal(this.zzaNl, autocompletePredictionEntity.zzaNl) && zzw.equal(this.zzaNn, autocompletePredictionEntity.zzaNn) && zzw.equal(this.zzaNo, autocompletePredictionEntity.zzaNo) && zzw.equal(this.zzaNp, autocompletePredictionEntity.zzaNp) && zzw.equal(this.zzaNq, autocompletePredictionEntity.zzaNq);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getDescription() {
        return this.zzaNk;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getFullText(CharacterStyle characterStyle) {
        return zzc.zza(this.zzaNk, this.zzaNl, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List<? extends AutocompletePrediction.Substring> getMatchedSubstrings() {
        return this.zzaNl;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getPlaceId() {
        return this.zzaMO;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List<Integer> getPlaceTypes() {
        return this.zzaMp;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getPrimaryText(CharacterStyle characterStyle) {
        return zzc.zza(this.zzaNn, this.zzaNo, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getSecondaryText(CharacterStyle characterStyle) {
        return zzc.zza(this.zzaNp, this.zzaNq, characterStyle);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMO, this.zzaMp, Integer.valueOf(this.zzaNm), this.zzaNk, this.zzaNl, this.zzaNn, this.zzaNo, this.zzaNp, this.zzaNq);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzx(this).zzg("placeId", this.zzaMO).zzg("placeTypes", this.zzaMp).zzg("fullText", this.zzaNk).zzg("fullTextMatchedSubstrings", this.zzaNl).zzg("primaryText", this.zzaNn).zzg("primaryTextMatchedSubstrings", this.zzaNo).zzg("secondaryText", this.zzaNp).zzg("secondaryTextMatchedSubstrings", this.zzaNq).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyt, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction freeze() {
        return this;
    }
}
