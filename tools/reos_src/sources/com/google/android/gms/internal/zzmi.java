package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class zzmi implements zzmm {
    private final Context mContext;
    private final GoogleApiAvailability zzaeL;
    final Api.zza<? extends zzsc, zzsd> zzaeM;
    final zzf zzafT;
    final Map<Api<?>, Integer> zzafU;
    final zzmg zzafp;
    private final Lock zzafz;
    private final Condition zzagH;
    private final zzb zzagI;
    private volatile zzmh zzagK;
    int zzagM;
    final zzmm.zza zzagN;
    final Map<Api.zzc<?>, Api.zzb> zzagp;
    final Map<Api.zzc<?>, ConnectionResult> zzagJ = new HashMap();
    private ConnectionResult zzagL = null;

    static abstract class zza {
        private final zzmh zzagO;

        protected zza(zzmh zzmhVar) {
            this.zzagO = zzmhVar;
        }

        public final void zzd(zzmi zzmiVar) {
            zzmiVar.zzafz.lock();
            try {
                if (zzmiVar.zzagK != this.zzagO) {
                    return;
                }
                zzpc();
            } finally {
                zzmiVar.zzafz.unlock();
            }
        }

        protected abstract void zzpc();
    }

    final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((zza) message.obj).zzd(zzmi.this);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public zzmi(Context context, zzmg zzmgVar, Lock lock, Looper looper, GoogleApiAvailability googleApiAvailability, Map<Api.zzc<?>, Api.zzb> map, zzf zzfVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzsc, zzsd> zzaVar, ArrayList<zzlz> arrayList, zzmm.zza zzaVar2) {
        this.mContext = context;
        this.zzafz = lock;
        this.zzaeL = googleApiAvailability;
        this.zzagp = map;
        this.zzafT = zzfVar;
        this.zzafU = map2;
        this.zzaeM = zzaVar;
        this.zzafp = zzmgVar;
        this.zzagN = zzaVar2;
        Iterator<zzlz> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.zzagI = new zzb(looper);
        this.zzagH = lock.newCondition();
        this.zzagK = new zzmf(this);
    }

    @Override // com.google.android.gms.internal.zzmm
    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzagH.await();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.zzadR;
        }
        return this.zzagL != null ? this.zzagL : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.internal.zzmm
    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.zzagH.awaitNanos(nanos);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (isConnected()) {
            return ConnectionResult.zzadR;
        }
        return this.zzagL != null ? this.zzagL : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.internal.zzmm
    public void connect() {
        this.zzagK.connect();
    }

    @Override // com.google.android.gms.internal.zzmm
    public void disconnect() {
        this.zzagJ.clear();
        this.zzagK.disconnect();
    }

    @Override // com.google.android.gms.internal.zzmm
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        for (Api<?> api : this.zzafU.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.zzagp.get(api.zzoA()).dump(str2, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.internal.zzmm
    public ConnectionResult getConnectionResult(Api<?> api) {
        Api.zzc<?> zzcVarZzoA = api.zzoA();
        if (this.zzagp.containsKey(zzcVarZzoA)) {
            if (this.zzagp.get(zzcVarZzoA).isConnected()) {
                return ConnectionResult.zzadR;
            }
            if (this.zzagJ.containsKey(zzcVarZzoA)) {
                return this.zzagJ.get(zzcVarZzoA);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzmm
    public boolean isConnected() {
        return this.zzagK instanceof zzmd;
    }

    @Override // com.google.android.gms.internal.zzmm
    public boolean isConnecting() {
        return this.zzagK instanceof zzme;
    }

    public void onConnected(Bundle bundle) {
        this.zzafz.lock();
        try {
            this.zzagK.onConnected(bundle);
        } finally {
            this.zzafz.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.zzafz.lock();
        try {
            this.zzagK.onConnectionSuspended(i);
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzmm
    public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T t) {
        return (T) this.zzagK.zza(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        this.zzafz.lock();
        try {
            this.zzagK.zza(connectionResult, api, i);
        } finally {
            this.zzafz.unlock();
        }
    }

    void zza(zza zzaVar) {
        this.zzagI.sendMessage(this.zzagI.obtainMessage(1, zzaVar));
    }

    void zza(RuntimeException runtimeException) {
        this.zzagI.sendMessage(this.zzagI.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.internal.zzmm
    public boolean zza(zzmp zzmpVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.zzmm
    public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T t) {
        return (T) this.zzagK.zzb(t);
    }

    void zzj(ConnectionResult connectionResult) {
        this.zzafz.lock();
        try {
            this.zzagL = connectionResult;
            this.zzagK = new zzmf(this);
            this.zzagK.begin();
            this.zzagH.signalAll();
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzmm
    public void zzoF() {
    }

    void zzpw() {
        this.zzafz.lock();
        try {
            this.zzagK = new zzme(this, this.zzafT, this.zzafU, this.zzaeL, this.zzaeM, this.zzafz, this.mContext);
            this.zzagK.begin();
            this.zzagH.signalAll();
        } finally {
            this.zzafz.unlock();
        }
    }

    void zzpx() {
        this.zzafz.lock();
        try {
            this.zzafp.zzps();
            this.zzagK = new zzmd(this);
            this.zzagK.begin();
            this.zzagH.signalAll();
        } finally {
            this.zzafz.unlock();
        }
    }

    void zzpy() {
        Iterator<Api.zzb> it = this.zzagp.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
    }
}
