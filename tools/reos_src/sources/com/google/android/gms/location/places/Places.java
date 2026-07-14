package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
public class Places {
    public static final Api.zzc<com.google.android.gms.location.places.internal.zze> zzaMU = new Api.zzc<>();
    public static final Api.zzc<com.google.android.gms.location.places.internal.zzk> zzaMV = new Api.zzc<>();
    public static final Api<PlacesOptions> GEO_DATA_API = new Api<>("Places.GEO_DATA_API", new com.google.android.gms.location.places.internal.zze.zza(null), zzaMU);
    public static final Api<PlacesOptions> PLACE_DETECTION_API = new Api<>("Places.PLACE_DETECTION_API", new com.google.android.gms.location.places.internal.zzk.zza(null), zzaMV);
    public static final GeoDataApi GeoDataApi = new com.google.android.gms.location.places.internal.zzd();
    public static final PlaceDetectionApi PlaceDetectionApi = new com.google.android.gms.location.places.internal.zzj();

    private Places() {
    }
}
