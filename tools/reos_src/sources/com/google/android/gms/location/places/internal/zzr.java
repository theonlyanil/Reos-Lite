package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

/* JADX INFO: loaded from: classes.dex */
public class zzr extends zzu implements PlacePhotoMetadata {
    private final String zzaOg;

    public zzr(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzaOg = getString("photo_fife_url");
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public CharSequence getAttributions() {
        return zzI("photo_attributions", null);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxHeight() {
        return zzz("photo_max_height", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxWidth() {
        return zzz("photo_max_width", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient googleApiClient, int i, int i2) {
        return freeze().getScaledPhoto(googleApiClient, i, i2);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyN, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata freeze() {
        return new zzq(this.zzaOg, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzahw);
    }
}
