package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzf extends com.google.android.gms.location.places.internal.zzh.zza {
    private final zzb zzaME;
    private final zza zzaMF;

    public static abstract class zza<A extends Api.zzb> extends zzl.zzb<PlacePhotoResult, A> {
        public zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzaP, reason: merged with bridge method [inline-methods] */
        public PlacePhotoResult zzc(Status status) {
            return new PlacePhotoResult(status, null);
        }
    }

    public static abstract class zzb<A extends Api.zzb> extends zzl.zzb<PlacePhotoMetadataResult, A> {
        public zzb(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzaQ, reason: merged with bridge method [inline-methods] */
        public PlacePhotoMetadataResult zzc(Status status) {
            return new PlacePhotoMetadataResult(status, null);
        }
    }

    public zzf(zza zzaVar) {
        this.zzaME = null;
        this.zzaMF = zzaVar;
    }

    public zzf(zzb zzbVar) {
        this.zzaME = zzbVar;
        this.zzaMF = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void zza(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.zzaME.zzb(placePhotoMetadataResult);
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void zza(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.zzaMF.zzb(placePhotoResult);
    }
}
