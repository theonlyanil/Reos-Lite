package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;

/* JADX INFO: loaded from: classes.dex */
public class zzj implements PlaceDetectionApi {
    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient googleApiClient, final PlaceFilter placeFilter) {
        return googleApiClient.zza(new com.google.android.gms.location.places.zzl.zzd<zzk>(Places.zzaMV, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzj.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzk zzkVar) throws RemoteException {
                zzkVar.zza(new com.google.android.gms.location.places.zzl(this, zzkVar.getContext()), placeFilter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient googleApiClient, final PlaceReport placeReport) {
        return googleApiClient.zzb(new com.google.android.gms.location.places.zzl.zzf<zzk>(Places.zzaMV, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzj.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzk zzkVar) throws RemoteException {
                zzkVar.zza(new com.google.android.gms.location.places.zzl(this), placeReport);
            }
        });
    }
}
