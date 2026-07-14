package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zzk extends com.google.android.gms.common.internal.zzj<zzf> {
    private final PlacesParams zzaNx;
    private final Locale zzaNy;

    public static class zza extends Api.zza<zzk, PlacesOptions> {
        private final String zzaNz;

        public zza(String str) {
            this.zzaNz = str;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public zzk zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzk(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, this.zzaNz != null ? this.zzaNz : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().build() : placesOptions);
        }
    }

    public zzk(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 67, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaNy = Locale.getDefault();
        this.zzaNx = new PlacesParams(str, this.zzaNy, zzfVar.getAccount() != null ? zzfVar.getAccount().name : null, placesOptions.zzaNb, placesOptions.zzaNc);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, PlaceFilter placeFilter) throws RemoteException {
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzyr();
        }
        zzqs().zza(placeFilter, this.zzaNx, zzlVar);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, PlaceReport placeReport) throws RemoteException {
        zzx.zzy(placeReport);
        zzqs().zza(placeReport, this.zzaNx, zzlVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzcq, reason: merged with bridge method [inline-methods] */
    public zzf zzW(IBinder iBinder) {
        return zzf.zza.zzcm(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
