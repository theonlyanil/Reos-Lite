package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient googleApiClient, final AddPlaceRequest addPlaceRequest) {
        return googleApiClient.zzb(new com.google.android.gms.location.places.zzl.zzc<zze>(Places.zzaMU, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) throws RemoteException {
                zzeVar.zza(new com.google.android.gms.location.places.zzl(this, zzeVar.getContext()), addPlaceRequest);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient googleApiClient, final String str, final LatLngBounds latLngBounds, final AutocompleteFilter autocompleteFilter) {
        return googleApiClient.zza(new com.google.android.gms.location.places.zzl.zza<zze>(Places.zzaMU, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) throws RemoteException {
                zzeVar.zza(new com.google.android.gms.location.places.zzl(this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient googleApiClient, final String... strArr) {
        zzx.zzab(strArr != null && strArr.length >= 1);
        return googleApiClient.zza(new com.google.android.gms.location.places.zzl.zzc<zze>(Places.zzaMU, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) throws RemoteException {
                zzeVar.zza(new com.google.android.gms.location.places.zzl(this, zzeVar.getContext()), Arrays.asList(strArr));
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlacePhotoMetadataResult> getPlacePhotos(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new com.google.android.gms.location.places.zzf.zzb<zze>(Places.zzaMU, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zze zzeVar) throws RemoteException {
                zzeVar.zza(new com.google.android.gms.location.places.zzf(this), str);
            }
        });
    }
}
