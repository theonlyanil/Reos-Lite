package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.h.a;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class zzma implements zzmm {
    private final Context mContext;
    private final Looper zzaeK;
    private final zzmg zzafp;
    private final zzmi zzafq;
    private final zzmi zzafr;
    private final Api.zzb zzafu;
    private Bundle zzafv;
    private final Lock zzafz;
    private final Map<Api.zzc<?>, zzmi> zzafs = new a();
    private final Set<zzmp> zzaft = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult zzafw = null;
    private ConnectionResult zzafx = null;
    private final AtomicInteger zzafy = new AtomicInteger(0);
    private int zzafA = 0;

    public zzma(Context context, zzmg zzmgVar, Lock lock, Looper looper, GoogleApiAvailability googleApiAvailability, Map<Api.zzc<?>, Api.zzb> map, zzf zzfVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzsc, zzsd> zzaVar, ArrayList<zzlz> arrayList) {
        this.mContext = context;
        this.zzafp = zzmgVar;
        this.zzafz = lock;
        this.zzaeK = looper;
        Api.zzb zzbVar = null;
        a aVar = new a();
        a aVar2 = new a();
        for (Api.zzc<?> zzcVar : map.keySet()) {
            Api.zzb zzbVar2 = map.get(zzcVar);
            zzbVar = zzbVar2.zzmJ() ? zzbVar2 : zzbVar;
            if (zzbVar2.zzmn()) {
                aVar.put(zzcVar, zzbVar2);
            } else {
                aVar2.put(zzcVar, zzbVar2);
            }
        }
        this.zzafu = zzbVar;
        if (aVar.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        a aVar3 = new a();
        a aVar4 = new a();
        for (Api<?> api : map2.keySet()) {
            Api.zzc<?> zzcVarZzoA = api.zzoA();
            if (aVar.containsKey(zzcVarZzoA)) {
                aVar3.put(api, map2.get(api));
            } else {
                if (!aVar2.containsKey(zzcVarZzoA)) {
                    throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
                }
                aVar4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (zzlz zzlzVar : arrayList) {
            if (aVar3.containsKey(zzlzVar.zzafm)) {
                arrayList2.add(zzlzVar);
            } else {
                if (!aVar4.containsKey(zzlzVar.zzafm)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
                }
                arrayList3.add(zzlzVar);
            }
        }
        this.zzafq = new zzmi(context, this.zzafp, lock, looper, googleApiAvailability, aVar2, null, aVar4, null, arrayList3, new zzmm.zza() { // from class: com.google.android.gms.internal.zzma.1
            @Override // com.google.android.gms.internal.zzmm.zza
            public void zzbz(int i) {
                zzma.this.zzafz.lock();
                try {
                    zzma.this.zza(zzma.this.zzafr, i);
                } finally {
                    zzma.this.zzafz.unlock();
                }
            }

            @Override // com.google.android.gms.internal.zzmm.zza
            public void zze(ConnectionResult connectionResult) {
                zzma.this.zzafz.lock();
                try {
                    zzma.this.zzafw = connectionResult;
                    zzma.this.zzoW();
                } finally {
                    zzma.this.zzafz.unlock();
                }
            }

            @Override // com.google.android.gms.internal.zzmm.zza
            public void zzi(Bundle bundle) {
                zzma.this.zzafz.lock();
                try {
                    zzma.this.zzh(bundle);
                    zzma.this.zzafw = ConnectionResult.zzadR;
                    zzma.this.zzoW();
                } finally {
                    zzma.this.zzafz.unlock();
                }
            }
        });
        this.zzafr = new zzmi(context, this.zzafp, lock, looper, googleApiAvailability, aVar, zzfVar, aVar3, zzaVar, arrayList2, new zzmm.zza() { // from class: com.google.android.gms.internal.zzma.2
            @Override // com.google.android.gms.internal.zzmm.zza
            public void zzbz(int i) {
                zzma.this.zzafz.lock();
                try {
                    zzma.this.zza(zzma.this.zzafq, i);
                } finally {
                    zzma.this.zzafz.unlock();
                }
            }

            @Override // com.google.android.gms.internal.zzmm.zza
            public void zze(ConnectionResult connectionResult) {
                zzma.this.zzafz.lock();
                try {
                    zzma.this.zzafx = connectionResult;
                    zzma.this.zzoW();
                } finally {
                    zzma.this.zzafz.unlock();
                }
            }

            @Override // com.google.android.gms.internal.zzmm.zza
            public void zzi(Bundle bundle) {
                zzma.this.zzafz.lock();
                try {
                    zzma.this.zzafx = ConnectionResult.zzadR;
                    zzma.this.zzoW();
                } finally {
                    zzma.this.zzafz.unlock();
                }
            }
        });
        Iterator it = aVar2.keySet().iterator();
        while (it.hasNext()) {
            this.zzafs.put((Api.zzc) it.next(), this.zzafq);
        }
        Iterator it2 = aVar.keySet().iterator();
        while (it2.hasNext()) {
            this.zzafs.put((Api.zzc) it2.next(), this.zzafr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(zzmi zzmiVar, int i) {
        if (this.zzafy.getAndIncrement() % 2 == 1) {
            this.zzafp.zzbz(i);
        }
        zzmiVar.onConnectionSuspended(i);
        this.zzafx = null;
        this.zzafw = null;
    }

    private void zzc(ConnectionResult connectionResult) {
        switch (this.zzafA) {
            case 2:
                this.zzafp.zze(connectionResult);
            case 1:
                zzoY();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.zzafA = 0;
    }

    private boolean zzc(zzlx.zza<? extends Result, ? extends Api.zzb> zzaVar) {
        Object objZzoA = zzaVar.zzoA();
        zzx.zzb(this.zzafs.containsKey(objZzoA), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzafs.get(objZzoA).equals(this.zzafr);
    }

    private static boolean zzd(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzh(Bundle bundle) {
        if (this.zzafv == null) {
            this.zzafv = bundle;
        } else if (bundle != null) {
            this.zzafv.putAll(bundle);
        }
    }

    private void zzoV() {
        this.zzafx = null;
        this.zzafw = null;
        this.zzafq.connect();
        this.zzafr.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzoW() {
        if (zzd(this.zzafw)) {
            if (zzd(this.zzafx) || zzoZ()) {
                zzoX();
                return;
            }
            if (this.zzafx != null) {
                if (this.zzafA == 1) {
                    zzoY();
                    return;
                } else {
                    zzc(this.zzafx);
                    this.zzafq.disconnect();
                    return;
                }
            }
            return;
        }
        if (this.zzafw != null && zzd(this.zzafx)) {
            this.zzafr.disconnect();
            zzc(this.zzafw);
        } else {
            if (this.zzafw == null || this.zzafx == null) {
                return;
            }
            ConnectionResult connectionResult = this.zzafw;
            if (this.zzafr.zzagM < this.zzafq.zzagM) {
                connectionResult = this.zzafx;
            }
            zzc(connectionResult);
        }
    }

    private void zzoX() {
        switch (this.zzafA) {
            case 2:
                this.zzafp.zzi(this.zzafv);
            case 1:
                zzoY();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.zzafA = 0;
    }

    private void zzoY() {
        Iterator<zzmp> it = this.zzaft.iterator();
        while (it.hasNext()) {
            it.next().zzmI();
        }
        this.zzaft.clear();
    }

    private boolean zzoZ() {
        return this.zzafx != null && this.zzafx.getErrorCode() == 4;
    }

    private PendingIntent zzpa() {
        if (this.zzafu == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.zzafp.getSessionId(), this.zzafu.zzmK(), 134217728);
    }

    @Override // com.google.android.gms.internal.zzmm
    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.zzmm
    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.zzmm
    public void connect() {
        this.zzafA = 2;
        zzoV();
    }

    @Override // com.google.android.gms.internal.zzmm
    public void disconnect() {
        this.zzafx = null;
        this.zzafw = null;
        this.zzafA = 0;
        this.zzafq.disconnect();
        this.zzafr.disconnect();
        zzoY();
    }

    @Override // com.google.android.gms.internal.zzmm
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.zzafr.dump(str + "  ", fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("unauthClient").println(":");
        this.zzafq.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.internal.zzmm
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (this.zzafs.get(api.zzoA()).equals(this.zzafr)) {
            return zzoZ() ? new ConnectionResult(4, zzpa()) : this.zzafr.getConnectionResult(api);
        }
        return this.zzafq.getConnectionResult(api);
    }

    @Override // com.google.android.gms.internal.zzmm
    public boolean isConnected() {
        boolean z = true;
        this.zzafz.lock();
        try {
            if (!this.zzafq.isConnected() || (!zzoU() && !zzoZ() && this.zzafA != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzmm
    public boolean isConnecting() {
        this.zzafz.lock();
        try {
            return this.zzafq.isConnecting() || (this.zzafr.isConnecting() && this.zzafA == 2);
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzmm
    public <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T t) {
        if (t.zzoQ() == 1) {
            throw new IllegalStateException("ReportingServices.getReportingState is not supported with SIGN_IN_MODE_OPTIONAL.");
        }
        if (!zzc((zzlx.zza<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.zzafq.zza(t);
        }
        if (!zzoZ()) {
            return (T) this.zzafr.zza(t);
        }
        t.zzx(new Status(4, null, zzpa()));
        return t;
    }

    @Override // com.google.android.gms.internal.zzmm
    public boolean zza(zzmp zzmpVar) {
        this.zzafz.lock();
        try {
            if ((!isConnecting() && !isConnected()) || zzoU()) {
                return false;
            }
            this.zzaft.add(zzmpVar);
            if (this.zzafA == 0) {
                this.zzafA = 1;
            }
            this.zzafx = null;
            this.zzafr.connect();
            return true;
        } finally {
            this.zzafz.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzmm
    public <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T t) {
        if (!zzc((zzlx.zza<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.zzafq.zzb(t);
        }
        if (!zzoZ()) {
            return (T) this.zzafr.zzb(t);
        }
        t.zzx(new Status(4, null, zzpa()));
        return t;
    }

    @Override // com.google.android.gms.internal.zzmm
    public void zzoF() {
        this.zzafz.lock();
        try {
            boolean zIsConnecting = isConnecting();
            this.zzafr.disconnect();
            this.zzafx = new ConnectionResult(4);
            if (zIsConnecting) {
                new Handler(this.zzaeK).post(new Runnable() { // from class: com.google.android.gms.internal.zzma.3
                    @Override // java.lang.Runnable
                    public void run() {
                        zzma.this.zzafz.lock();
                        try {
                            zzma.this.zzoW();
                        } finally {
                            zzma.this.zzafz.unlock();
                        }
                    }
                });
            } else {
                zzoY();
            }
        } finally {
            this.zzafz.unlock();
        }
    }

    public boolean zzoU() {
        return this.zzafr.isConnected();
    }
}
