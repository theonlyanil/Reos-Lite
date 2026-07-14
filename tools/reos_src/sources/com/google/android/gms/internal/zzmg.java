package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.p;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zzmg extends GoogleApiClient implements zzmm.zza {
    private final Context mContext;
    private final int zzaeI;
    private final Looper zzaeK;
    private final GoogleApiAvailability zzaeL;
    final Api.zza<? extends zzsc, zzsd> zzaeM;
    final zzf zzafT;
    final Map<Api<?>, Integer> zzafU;
    private final Lock zzafz;
    private final zzk zzagh;
    private volatile boolean zzagk;
    private final zza zzagn;
    zzc zzago;
    final Map<Api.zzc<?>, Api.zzb> zzagp;
    private com.google.android.gms.common.api.zza zzagt;
    private final ArrayList<zzlz> zzagu;
    private Integer zzagv;
    private zzmm zzagi = null;
    final Queue<zzlx.zza<?, ?>> zzagj = new LinkedList();
    private long zzagl = 120000;
    private long zzagm = 5000;
    Set<Scope> zzagq = new HashSet();
    private final Set<zzmn<?>> zzagr = Collections.newSetFromMap(new WeakHashMap());
    final Set<zze<?>> zzags = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final zzd zzagw = new zzd() { // from class: com.google.android.gms.internal.zzmg.1
        @Override // com.google.android.gms.internal.zzmg.zzd
        public void zzc(zze<?> zzeVar) {
            zzmg.this.zzags.remove(zzeVar);
            if (zzeVar.zzoL() == null || zzmg.this.zzagt == null) {
                return;
            }
            zzmg.this.zzagt.remove(zzeVar.zzoL().intValue());
        }
    };
    private final zzk.zza zzagx = new zzk.zza() { // from class: com.google.android.gms.internal.zzmg.2
        @Override // com.google.android.gms.common.internal.zzk.zza
        public boolean isConnected() {
            return zzmg.this.isConnected();
        }

        @Override // com.google.android.gms.common.internal.zzk.zza
        public Bundle zznQ() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzmg.this.zzpq();
                    break;
                case 2:
                    zzmg.this.resume();
                    break;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    break;
            }
        }
    }

    private static class zzb implements IBinder.DeathRecipient, zzd {
        private final WeakReference<zze<?>> zzagD;
        private final WeakReference<com.google.android.gms.common.api.zza> zzagE;
        private final WeakReference<IBinder> zzagF;

        private zzb(zze zzeVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) {
            this.zzagE = new WeakReference<>(zzaVar);
            this.zzagD = new WeakReference<>(zzeVar);
            this.zzagF = new WeakReference<>(iBinder);
        }

        private void zzpu() {
            zze<?> zzeVar = this.zzagD.get();
            com.google.android.gms.common.api.zza zzaVar = this.zzagE.get();
            if (zzaVar != null && zzeVar != null) {
                zzaVar.remove(zzeVar.zzoL().intValue());
            }
            IBinder iBinder = this.zzagF.get();
            if (this.zzagF != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            zzpu();
        }

        @Override // com.google.android.gms.internal.zzmg.zzd
        public void zzc(zze<?> zzeVar) {
            zzpu();
        }
    }

    static class zzc extends zzmk {
        private WeakReference<zzmg> zzagG;

        zzc(zzmg zzmgVar) {
            this.zzagG = new WeakReference<>(zzmgVar);
        }

        @Override // com.google.android.gms.internal.zzmk
        public void zzpv() {
            zzmg zzmgVar = this.zzagG.get();
            if (zzmgVar == null) {
                return;
            }
            zzmgVar.resume();
        }
    }

    interface zzd {
        void zzc(zze<?> zzeVar);
    }

    interface zze<A extends Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(zzd zzdVar);

        void zzb(A a2) throws DeadObjectException;

        Api.zzc<A> zzoA();

        Integer zzoL();

        void zzoP();

        int zzoQ();

        void zzx(Status status);

        void zzy(Status status);
    }

    public zzmg(Context context, Lock lock, Looper looper, zzf zzfVar, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzsc, zzsd> zzaVar, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zzb> map2, int i, int i2, ArrayList<zzlz> arrayList) {
        this.zzagv = null;
        this.mContext = context;
        this.zzafz = lock;
        this.zzagh = new zzk(looper, this.zzagx);
        this.zzaeK = looper;
        this.zzagn = new zza(looper);
        this.zzaeL = googleApiAvailability;
        this.zzaeI = i;
        if (this.zzaeI >= 0) {
            this.zzagv = Integer.valueOf(i2);
        }
        this.zzafU = map;
        this.zzagp = map2;
        this.zzagu = arrayList;
        Iterator<GoogleApiClient.ConnectionCallbacks> it = list.iterator();
        while (it.hasNext()) {
            this.zzagh.registerConnectionCallbacks(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zzagh.registerConnectionFailedListener(it2.next());
        }
        this.zzafT = zzfVar;
        this.zzaeM = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.zzafz.lock();
        try {
            if (zzpo()) {
                zzpp();
            }
        } finally {
            this.zzafz.unlock();
        }
    }

    public static int zza(Iterable<Api.zzb> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zzb zzbVar : iterable) {
            if (zzbVar.zzmn()) {
                z3 = true;
            }
            z2 = zzbVar.zzmJ() ? true : z2;
        }
        if (z3) {
            return (z2 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzmq zzmqVar, final boolean z) {
        zzmz.zzakJ.zze(googleApiClient).setResultCallback(new ResultCallback<Status>() { // from class: com.google.android.gms.internal.zzmg.5
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                zzn.zzae(zzmg.this.mContext).zzmZ();
                if (status.isSuccess() && zzmg.this.isConnected()) {
                    zzmg.this.reconnect();
                }
                zzmqVar.zzb(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private static void zza(zze<?> zzeVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) {
        if (zzeVar.isReady()) {
            zzeVar.zza(new zzb(zzeVar, zzaVar, iBinder));
            return;
        }
        if (iBinder == null || !iBinder.isBinderAlive()) {
            zzeVar.zza(null);
            zzeVar.cancel();
            zzaVar.remove(zzeVar.zzoL().intValue());
        } else {
            zzb zzbVar = new zzb(zzeVar, zzaVar, iBinder);
            zzeVar.zza(zzbVar);
            try {
                iBinder.linkToDeath(zzbVar, 0);
            } catch (RemoteException e2) {
                zzeVar.cancel();
                zzaVar.remove(zzeVar.zzoL().intValue());
            }
        }
    }

    private void zzbC(int i) {
        if (this.zzagv == null) {
            this.zzagv = Integer.valueOf(i);
        } else if (this.zzagv.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + zzbD(i) + ". Mode was already set to " + zzbD(this.zzagv.intValue()));
        }
        if (this.zzagi != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.zzb zzbVar : this.zzagp.values()) {
            if (zzbVar.zzmn()) {
                z2 = true;
            }
            z = zzbVar.zzmJ() ? true : z;
        }
        switch (this.zzagv.intValue()) {
            case 1:
                if (!z2) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (z) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                break;
            case 2:
                if (z2) {
                    this.zzagi = new zzma(this.mContext, this, this.zzafz, this.zzaeK, this.zzaeL, this.zzagp, this.zzafT, this.zzafU, this.zzaeM, this.zzagu);
                    return;
                }
                break;
        }
        this.zzagi = new zzmi(this.mContext, this, this.zzafz, this.zzaeK, this.zzaeL, this.zzagp, this.zzafT, this.zzafU, this.zzaeM, this.zzagu, this);
    }

    static String zzbD(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzpp() {
        this.zzagh.zzqB();
        this.zzagi.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzpq() {
        this.zzafz.lock();
        try {
            if (zzps()) {
                zzpp();
            }
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzafz.lock();
        try {
            if (this.zzaeI >= 0) {
                zzx.zza(this.zzagv != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzagv == null) {
                this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
            } else if (this.zzagv.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbC(this.zzagv.intValue());
            this.zzagh.zzqB();
            ConnectionResult connectionResultBlockingConnect = this.zzagi.blockingConnect();
            this.zzafz.unlock();
            return connectionResultBlockingConnect;
        } catch (Throwable th) {
            this.zzafz.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        zzx.zzb(timeUnit, "TimeUnit must not be null");
        this.zzafz.lock();
        try {
            if (this.zzagv == null) {
                this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
            } else if (this.zzagv.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbC(this.zzagv.intValue());
            this.zzagh.zzqB();
            ConnectionResult connectionResultBlockingConnect = this.zzagi.blockingConnect(j, timeUnit);
            this.zzafz.unlock();
            return connectionResultBlockingConnect;
        } catch (Throwable th) {
            this.zzafz.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), "GoogleApiClient is not connected yet.");
        zzx.zza(this.zzagv.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzmq zzmqVar = new zzmq(this);
        if (this.zzagp.containsKey(zzmz.zzTo)) {
            zza((GoogleApiClient) this, zzmqVar, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(this.mContext).addApi(zzmz.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() { // from class: com.google.android.gms.internal.zzmg.3
                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnected(Bundle bundle) {
                    zzmg.this.zza((GoogleApiClient) atomicReference.get(), zzmqVar, true);
                }

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.internal.zzmg.4
                @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
                public void onConnectionFailed(ConnectionResult connectionResult) {
                    zzmqVar.zzb(new Status(8));
                }
            }).setHandler(this.zzagn).build();
            atomicReference.set(googleApiClientBuild);
            googleApiClientBuild.connect();
        }
        return zzmqVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        this.zzafz.lock();
        try {
            if (this.zzaeI >= 0) {
                zzx.zza(this.zzagv != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzagv == null) {
                this.zzagv = Integer.valueOf(zza(this.zzagp.values(), false));
            } else if (this.zzagv.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzagv.intValue());
            this.zzafz.unlock();
        } catch (Throwable th) {
            this.zzafz.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect(int i) {
        boolean z = true;
        this.zzafz.lock();
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            zzx.zzb(z, "Illegal sign-in mode: " + i);
            zzbC(i);
            zzpp();
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        this.zzafz.lock();
        try {
            zzpm();
            if (this.zzagi == null) {
                zzpn();
                return;
            }
            zzps();
            this.zzagi.disconnect();
            this.zzagh.zzqA();
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.mContext);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zzagk);
        printWriter.append(" mWorkQueue.size()=").print(this.zzagj.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.zzags.size());
        if (this.zzagi != null) {
            this.zzagi.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        this.zzafz.lock();
        try {
            if (!isConnected() && !zzpo()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.zzagp.containsKey(api.zzoA())) {
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
            ConnectionResult connectionResult = this.zzagi.getConnectionResult(api);
            if (connectionResult != null) {
                this.zzafz.unlock();
            } else if (zzpo()) {
                connectionResult = ConnectionResult.zzadR;
                this.zzafz.unlock();
            } else {
                Log.i("GoogleApiClientImpl", zzpt());
                Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                connectionResult = new ConnectionResult(8, null);
                this.zzafz.unlock();
            }
            return connectionResult;
        } catch (Throwable th) {
            this.zzafz.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.zzaeK;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(Api<?> api) {
        Api.zzb zzbVar = this.zzagp.get(api.zzoA());
        return zzbVar != null && zzbVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        return this.zzagi != null && this.zzagi.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        return this.zzagi != null && this.zzagi.isConnecting();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zzagh.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzagh.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzagh.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzagh.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(final p pVar) {
        if (this.zzaeI < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zzmr zzmrVarZza = zzmr.zza(pVar);
        if (zzmrVarZza == null) {
            new Handler(this.mContext.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.zzmg.6
                @Override // java.lang.Runnable
                public void run() {
                    if (pVar.isFinishing() || pVar.getSupportFragmentManager().e()) {
                        return;
                    }
                    zzmr.zzb(pVar).zzbE(zzmg.this.zzaeI);
                }
            });
        } else {
            zzmrVarZza.zzbE(this.zzaeI);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzagh.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzagh.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <C extends Api.zzb> C zza(Api.zzc<C> zzcVar) {
        C c2 = (C) this.zzagp.get(zzcVar);
        zzx.zzb(c2, "Appropriate Api was not requested.");
        return c2;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T t) {
        zzx.zzb(t.zzoA() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzagp.containsKey(t.zzoA()), "GoogleApiClient is not configured to use the API required for this call.");
        this.zzafz.lock();
        try {
            if (this.zzagi == null) {
                this.zzagj.add(t);
            } else {
                t = (T) this.zzagi.zza(t);
            }
            return t;
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(Api<?> api) {
        return this.zzagp.containsKey(api.zzoA());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(zzmp zzmpVar) {
        return this.zzagi != null && this.zzagi.zza(zzmpVar);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T t) {
        zzx.zzb(t.zzoA() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.zzafz.lock();
        try {
            if (this.zzagi == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (zzpo()) {
                this.zzagj.add(t);
                while (!this.zzagj.isEmpty()) {
                    zzlx.zza<?, ?> zzaVarRemove = this.zzagj.remove();
                    zzb((zze) zzaVarRemove);
                    zzaVarRemove.zzx(Status.zzaeZ);
                }
                this.zzafz.unlock();
            } else {
                t = (T) this.zzagi.zzb(t);
                this.zzafz.unlock();
            }
            return t;
        } catch (Throwable th) {
            this.zzafz.unlock();
            throw th;
        }
    }

    <A extends Api.zzb> void zzb(zze<A> zzeVar) {
        this.zzags.add(zzeVar);
        zzeVar.zza(this.zzagw);
    }

    @Override // com.google.android.gms.internal.zzmm.zza
    public void zzbz(int i) {
        if (i == 1) {
            zzpr();
        }
        Iterator<zze<?>> it = this.zzags.iterator();
        while (it.hasNext()) {
            it.next().zzy(new Status(8, "The connection to Google Play services was lost"));
        }
        this.zzagh.zzbV(i);
        this.zzagh.zzqA();
        if (i == 2) {
            zzpp();
        }
    }

    @Override // com.google.android.gms.internal.zzmm.zza
    public void zze(ConnectionResult connectionResult) {
        if (!this.zzaeL.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzps();
        }
        if (zzpo()) {
            return;
        }
        this.zzagh.zzl(connectionResult);
        this.zzagh.zzqA();
    }

    @Override // com.google.android.gms.internal.zzmm.zza
    public void zzi(Bundle bundle) {
        while (!this.zzagj.isEmpty()) {
            zzb(this.zzagj.remove());
        }
        this.zzagh.zzk(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzoF() {
        if (this.zzagi != null) {
            this.zzagi.zzoF();
        }
    }

    void zzpm() {
        for (zze<?> zzeVar : this.zzags) {
            zzeVar.zza(null);
            if (zzeVar.zzoL() == null) {
                zzeVar.cancel();
            } else {
                zzeVar.zzoP();
                zza(zzeVar, this.zzagt, zza((Api.zzc) zzeVar.zzoA()).zzoC());
            }
        }
        this.zzags.clear();
        Iterator<zzmn<?>> it = this.zzagr.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.zzagr.clear();
    }

    void zzpn() {
        for (zzlx.zza<?, ?> zzaVar : this.zzagj) {
            zzaVar.zza((zzd) null);
            zzaVar.cancel();
        }
        this.zzagj.clear();
    }

    boolean zzpo() {
        return this.zzagk;
    }

    void zzpr() {
        if (zzpo()) {
            return;
        }
        this.zzagk = true;
        if (this.zzago == null) {
            this.zzago = (zzc) zzmk.zza(this.mContext.getApplicationContext(), new zzc(this), this.zzaeL);
        }
        this.zzagn.sendMessageDelayed(this.zzagn.obtainMessage(1), this.zzagl);
        this.zzagn.sendMessageDelayed(this.zzagn.obtainMessage(2), this.zzagm);
    }

    boolean zzps() {
        if (!zzpo()) {
            return false;
        }
        this.zzagk = false;
        this.zzagn.removeMessages(2);
        this.zzagn.removeMessages(1);
        if (this.zzago != null) {
            this.zzago.unregister();
            this.zzago = null;
        }
        return true;
    }

    String zzpt() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <L> zzmn<L> zzq(L l) {
        zzx.zzb(l, "Listener must not be null");
        this.zzafz.lock();
        try {
            zzmn<L> zzmnVar = new zzmn<>(this.zzaeK, l);
            this.zzagr.add(zzmnVar);
            return zzmnVar;
        } finally {
            this.zzafz.unlock();
        }
    }
}
