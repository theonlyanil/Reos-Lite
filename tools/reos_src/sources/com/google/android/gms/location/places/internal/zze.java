package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zze extends com.google.android.gms.common.internal.zzj<zzg> {
    private final PlacesParams zzaNx;
    private final Locale zzaNy;

    public static class zza extends Api.zza<zze, PlacesOptions> {
        private final String zzaNz;

        public zza(String str) {
            this.zzaNz = str;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, this.zzaNz != null ? this.zzaNz : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().build() : placesOptions);
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaNy = Locale.getDefault();
        this.zzaNx = new PlacesParams(str, this.zzaNy, zzfVar.getAccount() != null ? zzfVar.getAccount().name : null, placesOptions.zzaNb, placesOptions.zzaNc);
    }

    public void zza(com.google.android.gms.location.places.zzf zzfVar, String str) throws RemoteException {
        zzx.zzb(str, "placeId cannot be null");
        zzqs().zza(str, this.zzaNx, zzfVar);
    }

    public void zza(com.google.android.gms.location.places.zzf zzfVar, String str, int i, int i2, int i3) throws RemoteException {
        zzx.zzb(str, "fifeUrl cannot be null");
        zzx.zzb(i > 0, "width should be > 0");
        zzx.zzb(i > 0, "height should be > 0");
        zzqs().zza(str, i, i2, i3, this.zzaNx, zzfVar);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzx.zzb(addPlaceRequest, "userAddedPlace == null");
        zzqs().zza(addPlaceRequest, this.zzaNx, zzlVar);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzx.zzb(str, "query == null");
        zzx.zzb(zzlVar, "callback == null");
        zzqs().zza(str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create(null) : autocompleteFilter, this.zzaNx, zzlVar);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, List<String> list) throws RemoteException {
        zzqs().zzb(list, this.zzaNx, zzlVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzcl, reason: merged with bridge method [inline-methods] */
    public zzg zzW(IBinder iBinder) {
        return zzg.zza.zzcn(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
