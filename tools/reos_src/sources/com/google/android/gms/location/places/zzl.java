package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zznz;

/* JADX INFO: loaded from: classes.dex */
public class zzl extends com.google.android.gms.location.places.internal.zzi.zza {
    private static final String TAG = zzl.class.getSimpleName();
    private final Context mContext;
    private final zzd zzaMW;
    private final zza zzaMX;
    private final zze zzaMY;
    private final zzf zzaMZ;
    private final zzc zzaNa;

    public static abstract class zza<A extends Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzaS, reason: merged with bridge method [inline-methods] */
        public AutocompletePredictionBuffer zzc(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbJ(status.getStatusCode()));
        }
    }

    public static abstract class zzb<R extends Result, A extends Api.zzb> extends zzlx.zza<R, A> {
        public zzb(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }
    }

    public static abstract class zzc<A extends Api.zzb> extends zzb<PlaceBuffer, A> {
        public zzc(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzaT, reason: merged with bridge method [inline-methods] */
        public PlaceBuffer zzc(Status status) {
            return new PlaceBuffer(DataHolder.zzbJ(status.getStatusCode()), null);
        }
    }

    public static abstract class zzd<A extends Api.zzb> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzaU, reason: merged with bridge method [inline-methods] */
        public PlaceLikelihoodBuffer zzc(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbJ(status.getStatusCode()), 100, null);
        }
    }

    public static abstract class zze<A extends Api.zzb> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzaV, reason: merged with bridge method [inline-methods] */
        public com.google.android.gms.location.places.personalized.zzd zzc(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaW(status);
        }
    }

    public static abstract class zzf<A extends Api.zzb> extends zzb<Status, A> {
        public zzf(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzl(zza zzaVar) {
        this.zzaMW = null;
        this.zzaMX = zzaVar;
        this.zzaMY = null;
        this.zzaMZ = null;
        this.zzaNa = null;
        this.mContext = null;
    }

    public zzl(zzc zzcVar, Context context) {
        this.zzaMW = null;
        this.zzaMX = null;
        this.zzaMY = null;
        this.zzaMZ = null;
        this.zzaNa = zzcVar;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzd zzdVar, Context context) {
        this.zzaMW = zzdVar;
        this.zzaMX = null;
        this.zzaMY = null;
        this.zzaMZ = null;
        this.zzaNa = null;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzf zzfVar) {
        this.zzaMW = null;
        this.zzaMX = null;
        this.zzaMY = null;
        this.zzaMZ = zzfVar;
        this.zzaNa = null;
        this.mContext = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzaR(Status status) throws RemoteException {
        this.zzaMZ.zzb(status);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzac(DataHolder dataHolder) throws RemoteException {
        zzx.zza(this.zzaMW != null, "placeEstimator cannot be null");
        if (dataHolder != null) {
            this.zzaMW.zzb(new PlaceLikelihoodBuffer(dataHolder, 100, this.mContext));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zznz.zzrY());
        }
        this.zzaMW.zzx(Status.zzaeZ);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzad(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.zzaMX.zzb(new AutocompletePredictionBuffer(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zznz.zzrY());
        }
        this.zzaMX.zzx(Status.zzaeZ);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzae(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.zzaMY.zzb(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zznz.zzrY());
        }
        this.zzaMY.zzx(Status.zzaeZ);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzaf(DataHolder dataHolder) throws RemoteException {
        this.zzaNa.zzb(new PlaceBuffer(dataHolder, this.mContext));
    }
}
