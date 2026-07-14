package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzly<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private volatile R zzaeT;
    protected final zza<R> zzafe;
    private ResultCallback<? super R> zzafg;
    private volatile boolean zzafh;
    private boolean zzafi;
    private zzq zzafj;
    private Integer zzafk;
    private volatile zzms<R> zzafl;
    private final Object zzafd = new Object();
    private final CountDownLatch zzpy = new CountDownLatch(1);
    private final ArrayList<PendingResult.zza> zzaff = new ArrayList<>();

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    break;
                case 2:
                    ((zzly) message.obj).zzy(Status.zzafa);
                    break;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    break;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzly<R> zzlyVar, long j) {
            sendMessageDelayed(obtainMessage(2, zzlyVar), j);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e2) {
                zzly.zzd(r);
                throw e2;
            }
        }

        public void zzoS() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzly(Looper looper) {
        this.zzafe = new zza<>(looper);
    }

    protected zzly(GoogleApiClient googleApiClient) {
        this.zzafe = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private R get() {
        R r;
        synchronized (this.zzafd) {
            zzx.zza(this.zzafh ? false : true, "Result has already been consumed.");
            zzx.zza(isReady(), "Result is not ready.");
            r = this.zzaeT;
            this.zzaeT = null;
            this.zzafg = null;
            this.zzafh = true;
        }
        zzoR();
        return r;
    }

    private void zzc(R r) {
        this.zzaeT = r;
        this.zzafj = null;
        this.zzpy.countDown();
        Status status = this.zzaeT.getStatus();
        if (this.zzafg != null) {
            this.zzafe.zzoS();
            if (!this.zzL) {
                this.zzafe.zza(this.zzafg, get());
            }
        }
        Iterator<PendingResult.zza> it = this.zzaff.iterator();
        while (it.hasNext()) {
            it.next().zzu(status);
        }
        this.zzaff.clear();
    }

    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e2) {
                Log.w("BasePendingResult", "Unable to release " + result, e2);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        zzx.zza(!this.zzafh, "Result has already been consumed");
        zzx.zza(this.zzafl == null, "Cannot await if then() has been called.");
        try {
            this.zzpy.await();
        } catch (InterruptedException e2) {
            zzy(Status.zzaeY);
        }
        zzx.zza(isReady(), "Result is not ready.");
        return (R) get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        zzx.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
        zzx.zza(!this.zzafh, "Result has already been consumed.");
        zzx.zza(this.zzafl == null, "Cannot await if then() has been called.");
        try {
            if (!this.zzpy.await(j, timeUnit)) {
                zzy(Status.zzafa);
            }
        } catch (InterruptedException e2) {
            zzy(Status.zzaeY);
        }
        zzx.zza(isReady(), "Result is not ready.");
        return (R) get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zzafd) {
            if (this.zzL || this.zzafh) {
                return;
            }
            if (this.zzafj != null) {
                try {
                    this.zzafj.cancel();
                } catch (RemoteException e2) {
                }
            }
            zzd(this.zzaeT);
            this.zzafg = null;
            this.zzL = true;
            zzc(zzc(Status.zzafb));
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzafd) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzpy.getCount() == 0;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        zzx.zza(!this.zzafh, "Result has already been consumed.");
        synchronized (this.zzafd) {
            zzx.zza(this.zzafl == null, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zzafe.zza(resultCallback, get());
            } else {
                this.zzafg = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        zzx.zza(!this.zzafh, "Result has already been consumed.");
        synchronized (this.zzafd) {
            zzx.zza(this.zzafl == null, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zzafe.zza(resultCallback, get());
            } else {
                this.zzafg = resultCallback;
                this.zzafe.zza(this, timeUnit.toMillis(j));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void zza(PendingResult.zza zzaVar) {
        zzx.zza(!this.zzafh, "Result has already been consumed.");
        zzx.zzb(zzaVar != null, "Callback cannot be null.");
        synchronized (this.zzafd) {
            if (isReady()) {
                zzaVar.zzu(this.zzaeT.getStatus());
            } else {
                this.zzaff.add(zzaVar);
            }
        }
    }

    protected final void zza(zzq zzqVar) {
        synchronized (this.zzafd) {
            this.zzafj = zzqVar;
        }
    }

    public final void zzb(R r) {
        synchronized (this.zzafd) {
            if (this.zzafi || this.zzL) {
                zzd(r);
                return;
            }
            zzx.zza(!isReady(), "Results have already been set");
            zzx.zza(this.zzafh ? false : true, "Result has already been consumed");
            zzc(r);
        }
    }

    protected abstract R zzc(Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    public Integer zzoL() {
        return this.zzafk;
    }

    protected void zzoR() {
    }

    public final void zzy(Status status) {
        synchronized (this.zzafd) {
            if (!isReady()) {
                zzb(zzc(status));
                this.zzafi = true;
            }
        }
    }
}
