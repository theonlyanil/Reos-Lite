package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends zzu implements AutocompletePrediction {
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private List<AutocompletePredictionEntity.SubstringEntity> zzyA() {
        return zza("ap_secondary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private String zzyv() {
        return zzI("ap_description", "");
    }

    private String zzyw() {
        return zzI("ap_primary_text", "");
    }

    private String zzyx() {
        return zzI("ap_secondary_text", "");
    }

    private List<AutocompletePredictionEntity.SubstringEntity> zzyy() {
        return zza("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List<AutocompletePredictionEntity.SubstringEntity> zzyz() {
        return zza("ap_primary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getDescription() {
        return zzyv();
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getFullText(CharacterStyle characterStyle) {
        return zzc.zza(zzyv(), zzyy(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List<AutocompletePredictionEntity.SubstringEntity> getMatchedSubstrings() {
        return zzyy();
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getPlaceId() {
        return zzI("ap_place_id", null);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List<Integer> getPlaceTypes() {
        return zza("ap_place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getPrimaryText(CharacterStyle characterStyle) {
        return zzc.zza(zzyw(), zzyz(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getSecondaryText(CharacterStyle characterStyle) {
        return zzc.zza(zzyx(), zzyA(), characterStyle);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyt, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction freeze() {
        return AutocompletePredictionEntity.zza(getPlaceId(), getPlaceTypes(), zzyu(), zzyv(), zzyy(), zzyw(), zzyz(), zzyx(), zzyA());
    }

    public int zzyu() {
        return zzz("ap_personalization_type", 6);
    }
}
