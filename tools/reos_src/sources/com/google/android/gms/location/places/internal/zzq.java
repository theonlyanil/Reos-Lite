package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;

/* JADX INFO: loaded from: classes.dex */
public class zzq implements PlacePhotoMetadata {
    private int mIndex;
    private final int zzCF;
    private final int zzCG;
    private final String zzaOg;
    private final CharSequence zzaOh;

    public zzq(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaOg = str;
        this.zzCF = i;
        this.zzCG = i2;
        this.zzaOh = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzqVar = (zzq) obj;
        return zzqVar.zzCF == this.zzCF && zzqVar.zzCG == this.zzCG && zzw.equal(zzqVar.zzaOg, this.zzaOg) && zzw.equal(zzqVar.zzaOh, this.zzaOh);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public CharSequence getAttributions() {
        return this.zzaOh;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxHeight() {
        return this.zzCG;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxWidth() {
        return this.zzCF;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient googleApiClient, final int i, final int i2) {
        return googleApiClient.zza(new com.google.android.gms.location.places.zzf.zza<zze>(Places.zzaMU, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) throws RemoteException {
                zzeVar.zza(new com.google.android.gms.location.places.zzf(this), zzq.this.zzaOg, i, i2, zzq.this.mIndex);
            }
        });
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzCF), Integer.valueOf(this.zzCG), this.zzaOg, this.zzaOh);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyN, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata freeze() {
        return this;
    }
}
