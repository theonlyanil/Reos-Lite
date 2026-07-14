package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.h.i;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zze {
    private final long zzalW;
    private final int zzalX;
    private final i<String, Long> zzalY;

    public zze() {
        this.zzalW = 60000L;
        this.zzalX = 10;
        this.zzalY = new i<>(10);
    }

    public zze(int i, long j) {
        this.zzalW = j;
        this.zzalX = i;
        this.zzalY = new i<>();
    }

    private void zzb(long j, long j2) {
        for (int size = this.zzalY.size() - 1; size >= 0; size--) {
            if (j2 - this.zzalY.c(size).longValue() > j) {
                this.zzalY.d(size);
            }
        }
    }

    public Long zzcM(String str) {
        Long lPut;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzalW;
        synchronized (this) {
            while (this.zzalY.size() >= this.zzalX) {
                zzb(j, jElapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.zzalX + " is not enough. Current durationThreshold is: " + j);
            }
            lPut = this.zzalY.put(str, Long.valueOf(jElapsedRealtime));
        }
        return lPut;
    }

    public boolean zzcN(String str) {
        boolean z;
        synchronized (this) {
            z = this.zzalY.remove(str) != null;
        }
        return z;
    }
}
