package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements FusedLocationProviderApi {

    private static abstract class zza extends LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzly
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static class zzb extends zzg.zza {
        private final zzlx.zzb<Status> zzakL;

        public zzb(zzlx.zzb<Status> zzbVar) {
            this.zzakL = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzg
        public void zza(FusedLocationProviderResult fusedLocationProviderResult) {
            this.zzakL.zzr(fusedLocationProviderResult.getStatus());
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzg(googleApiClient).getLastLocation();
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzg(googleApiClient).zzyc();
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(pendingIntent, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, final LocationCallback locationCallback) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(locationCallback, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, final LocationListener locationListener) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(locationListener, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, final LocationRequest locationRequest, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(locationRequest, pendingIntent, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, final LocationRequest locationRequest, final LocationCallback locationCallback, final Looper looper) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(LocationRequestInternal.zzb(locationRequest), locationCallback, looper, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, final LocationRequest locationRequest, final LocationListener locationListener) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(locationRequest, locationListener, (Looper) null, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, final LocationRequest locationRequest, final LocationListener locationListener, final Looper looper) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(locationRequest, locationListener, looper, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, final Location location) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zzc(location);
                zzb(Status.zzaeX);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zzd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlx.zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zzai(z);
                zzb(Status.zzaeX);
            }
        });
    }
}
