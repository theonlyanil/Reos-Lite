package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.b.a;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzmp;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends a<Void> implements zzmp {
    private Semaphore zzVR;
    private Set<GoogleApiClient> zzVS;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzVR = new Semaphore(0);
        this.zzVS = set;
    }

    @Override // android.support.v4.b.i
    protected void onStartLoading() {
        this.zzVR.drainPermits();
        forceLoad();
    }

    @Override // android.support.v4.b.a
    /* JADX INFO: renamed from: zzmH, reason: merged with bridge method [inline-methods] */
    public Void loadInBackground() {
        int i = 0;
        Iterator<GoogleApiClient> it = this.zzVS.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                try {
                    this.zzVR.tryAcquire(i2, 5L, TimeUnit.SECONDS);
                    return null;
                } catch (InterruptedException e2) {
                    Log.i("GACSignInLoader", "Unexpected InterruptedException", e2);
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            i = it.next().zza(this) ? i2 + 1 : i2;
        }
    }

    @Override // com.google.android.gms.internal.zzmp
    public void zzmI() {
        this.zzVR.release();
    }
}
