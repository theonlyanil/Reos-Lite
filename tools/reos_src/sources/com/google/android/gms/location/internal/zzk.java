package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzk {
    private final Context mContext;
    private final zzp<zzi> zzaLF;
    private ContentProviderClient zzaLS = null;
    private boolean zzaLT = false;
    private Map<LocationListener, zzc> zzauU = new HashMap();
    private Map<LocationCallback, zza> zzaLU = new HashMap();

    private static class zza extends com.google.android.gms.location.zzc.zza {
        private Handler zzaLV;

        zza(final LocationCallback locationCallback, Looper looper) {
            if (looper == null) {
                looper = Looper.myLooper();
                zzx.zza(looper != null, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaLV = new Handler(looper) { // from class: com.google.android.gms.location.internal.zzk.zza.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            locationCallback.onLocationResult((LocationResult) message.obj);
                            break;
                        case 1:
                            locationCallback.onLocationAvailability((LocationAvailability) message.obj);
                            break;
                    }
                }
            };
        }

        private void zzb(int i, Object obj) {
            if (this.zzaLV == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.obj = obj;
            this.zzaLV.sendMessage(messageObtain);
        }

        @Override // com.google.android.gms.location.zzc
        public void onLocationAvailability(LocationAvailability locationAvailability) {
            zzb(1, locationAvailability);
        }

        @Override // com.google.android.gms.location.zzc
        public void onLocationResult(LocationResult locationResult) {
            zzb(0, locationResult);
        }

        public void release() {
            this.zzaLV = null;
        }
    }

    private static class zzb extends Handler {
        private final LocationListener zzaLX;

        public zzb(LocationListener locationListener) {
            this.zzaLX = locationListener;
        }

        public zzb(LocationListener locationListener, Looper looper) {
            super(looper);
            this.zzaLX = locationListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.zzaLX.onLocationChanged(new Location((Location) message.obj));
                    break;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    break;
            }
        }
    }

    private static class zzc extends com.google.android.gms.location.zzd.zza {
        private Handler zzaLV;

        zzc(LocationListener locationListener, Looper looper) {
            if (looper == null) {
                zzx.zza(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaLV = looper == null ? new zzb(locationListener) : new zzb(locationListener, looper);
        }

        @Override // com.google.android.gms.location.zzd
        public void onLocationChanged(Location location) {
            if (this.zzaLV == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = location;
            this.zzaLV.sendMessage(messageObtain);
        }

        public void release() {
            this.zzaLV = null;
        }
    }

    public zzk(Context context, zzp<zzi> zzpVar) {
        this.mContext = context;
        this.zzaLF = zzpVar;
    }

    private zza zza(LocationCallback locationCallback, Looper looper) {
        zza zzaVar;
        synchronized (this.zzaLU) {
            zzaVar = this.zzaLU.get(locationCallback);
            if (zzaVar == null) {
                zzaVar = new zza(locationCallback, looper);
            }
            this.zzaLU.put(locationCallback, zzaVar);
        }
        return zzaVar;
    }

    private zzc zza(LocationListener locationListener, Looper looper) {
        zzc zzcVar;
        synchronized (this.zzauU) {
            zzcVar = this.zzauU.get(locationListener);
            if (zzcVar == null) {
                zzcVar = new zzc(locationListener, looper);
            }
            this.zzauU.put(locationListener, zzcVar);
        }
        return zzcVar;
    }

    public Location getLastLocation() {
        this.zzaLF.zzqr();
        try {
            return ((zzi) this.zzaLF.zzqs()).zzdS(this.mContext.getPackageName());
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.zzauU) {
                for (zzc zzcVar : this.zzauU.values()) {
                    if (zzcVar != null) {
                        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(zzcVar, (zzg) null));
                    }
                }
                this.zzauU.clear();
            }
            synchronized (this.zzaLU) {
                for (zza zzaVar : this.zzaLU.values()) {
                    if (zzaVar != null) {
                        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(zzaVar, (zzg) null));
                    }
                }
                this.zzaLU.clear();
            }
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void zza(PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zzb(pendingIntent, zzgVar));
    }

    public void zza(LocationCallback locationCallback, zzg zzgVar) throws RemoteException {
        this.zzaLF.zzqr();
        zzx.zzb(locationCallback, "Invalid null callback");
        synchronized (this.zzaLU) {
            zza zzaVarRemove = this.zzaLU.remove(locationCallback);
            if (zzaVarRemove != null) {
                zzaVarRemove.release();
                ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(zzaVarRemove, zzgVar));
            }
        }
    }

    public void zza(LocationListener locationListener, zzg zzgVar) throws RemoteException {
        this.zzaLF.zzqr();
        zzx.zzb(locationListener, "Invalid null listener");
        synchronized (this.zzauU) {
            zzc zzcVarRemove = this.zzauU.remove(locationListener);
            if (this.zzaLS != null && this.zzauU.isEmpty()) {
                this.zzaLS.release();
                this.zzaLS = null;
            }
            if (zzcVarRemove != null) {
                zzcVarRemove.release();
                ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(zzcVarRemove, zzgVar));
            }
        }
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), pendingIntent, zzgVar));
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzgVar) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), zza(locationListener, looper), zzgVar));
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzgVar) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(locationRequestInternal, zza(locationCallback, looper), zzgVar));
    }

    public void zza(zzg zzgVar) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(zzgVar);
    }

    public void zzai(boolean z) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zzai(z);
        this.zzaLT = z;
    }

    public void zzc(Location location) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zzc(location);
    }

    public LocationAvailability zzyc() {
        this.zzaLF.zzqr();
        try {
            return ((zzi) this.zzaLF.zzqs()).zzdT(this.mContext.getPackageName());
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void zzyd() {
        if (this.zzaLT) {
            try {
                zzai(false);
            } catch (RemoteException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }
}
