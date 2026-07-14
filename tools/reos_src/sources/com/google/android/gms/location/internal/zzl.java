package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzl extends com.google.android.gms.location.internal.zzb {
    private final zzk zzaLY;

    private static final class zza extends zzh.zza {
        private zzlx.zzb<Status> zzaLZ;

        public zza(zzlx.zzb<Status> zzbVar) {
            this.zzaLZ = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, PendingIntent pendingIntent) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, String[] strArr) {
            if (this.zzaLZ == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            this.zzaLZ.zzr(LocationStatusCodes.zzhq(LocationStatusCodes.zzhp(i)));
            this.zzaLZ = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zzb(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }
    }

    private static final class zzb extends zzh.zza {
        private zzlx.zzb<Status> zzaLZ;

        public zzb(zzlx.zzb<Status> zzbVar) {
            this.zzaLZ = zzbVar;
        }

        private void zzht(int i) {
            if (this.zzaLZ == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            }
            this.zzaLZ.zzr(LocationStatusCodes.zzhq(LocationStatusCodes.zzhp(i)));
            this.zzaLZ = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, PendingIntent pendingIntent) {
            zzht(i);
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zzb(int i, String[] strArr) {
            zzht(i);
        }
    }

    private static final class zzc extends zzj.zza {
        private zzlx.zzb<LocationSettingsResult> zzaLZ;

        public zzc(zzlx.zzb<LocationSettingsResult> zzbVar) {
            zzx.zzb(zzbVar != null, "listener can't be null.");
            this.zzaLZ = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzj
        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.zzaLZ.zzr(locationSettingsResult);
            this.zzaLZ = null;
        }
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, com.google.android.gms.common.internal.zzf.zzas(context));
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzfVar);
        this.zzaLY = new zzk(context, this.zzaLF);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        synchronized (this.zzaLY) {
            if (isConnected()) {
                try {
                    this.zzaLY.removeAllListeners();
                    this.zzaLY.zzyd();
                } catch (Exception e2) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e2);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
            throw th;
        }
    }

    public Location getLastLocation() {
        return this.zzaLY.getLastLocation();
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zzqr();
        zzx.zzy(pendingIntent);
        zzx.zzb(j >= 0, "detectionIntervalMillis must be >= 0");
        zzqs().zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent) throws RemoteException {
        zzqr();
        zzx.zzy(pendingIntent);
        zzqs().zza(pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, zzlx.zzb<Status> zzbVar) throws RemoteException {
        zzqr();
        zzx.zzb(pendingIntent, "PendingIntent must be specified.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        zzqs().zza(pendingIntent, new zzb(zzbVar), getContext().getPackageName());
    }

    public void zza(PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaLY.zza(pendingIntent, zzgVar);
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzlx.zzb<Status> zzbVar) throws RemoteException {
        zzqr();
        zzx.zzb(geofencingRequest, "geofencingRequest can't be null.");
        zzx.zzb(pendingIntent, "PendingIntent must be specified.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        zzqs().zza(geofencingRequest, pendingIntent, new zza(zzbVar));
    }

    public void zza(LocationCallback locationCallback, zzg zzgVar) throws RemoteException {
        this.zzaLY.zza(locationCallback, zzgVar);
    }

    public void zza(LocationListener locationListener, zzg zzgVar) throws RemoteException {
        this.zzaLY.zza(locationListener, zzgVar);
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaLY.zza(locationRequest, pendingIntent, zzgVar);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzgVar) throws RemoteException {
        synchronized (this.zzaLY) {
            this.zzaLY.zza(locationRequest, locationListener, looper, zzgVar);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, zzlx.zzb<LocationSettingsResult> zzbVar, String str) throws RemoteException {
        zzqr();
        zzx.zzb(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        zzx.zzb(zzbVar != null, "listener can't be null.");
        zzqs().zza(locationSettingsRequest, new zzc(zzbVar), str);
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzgVar) throws RemoteException {
        synchronized (this.zzaLY) {
            this.zzaLY.zza(locationRequestInternal, locationCallback, looper, zzgVar);
        }
    }

    public void zza(zzg zzgVar) throws RemoteException {
        this.zzaLY.zza(zzgVar);
    }

    public void zza(List<String> list, zzlx.zzb<Status> zzbVar) throws RemoteException {
        zzqr();
        zzx.zzb(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        zzqs().zza((String[]) list.toArray(new String[0]), new zzb(zzbVar), getContext().getPackageName());
    }

    public void zzai(boolean z) throws RemoteException {
        this.zzaLY.zzai(z);
    }

    public void zzc(Location location) throws RemoteException {
        this.zzaLY.zzc(location);
    }

    public LocationAvailability zzyc() {
        return this.zzaLY.zzyc();
    }
}
