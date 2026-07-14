package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztp;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzb {
    private final ArrayList<zza> zzaYr;
    private int zzaYs;

    public static class zza {
        public final PlayLoggerContext zzaYt;
        public final LogEvent zzaYu;
        public final zztp.zzd zzaYv;

        private zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
            this.zzaYt = (PlayLoggerContext) zzx.zzy(playLoggerContext);
            this.zzaYu = (LogEvent) zzx.zzy(logEvent);
            this.zzaYv = null;
        }
    }

    public zzb() {
        this(100);
    }

    public zzb(int i) {
        this.zzaYr = new ArrayList<>();
        this.zzaYs = i;
    }

    private void zzDa() {
        while (getSize() > getCapacity()) {
            this.zzaYr.remove(0);
        }
    }

    public void clear() {
        this.zzaYr.clear();
    }

    public int getCapacity() {
        return this.zzaYs;
    }

    public int getSize() {
        return this.zzaYr.size();
    }

    public boolean isEmpty() {
        return this.zzaYr.isEmpty();
    }

    public ArrayList<zza> zzCZ() {
        return this.zzaYr;
    }

    public void zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaYr.add(new zza(playLoggerContext, logEvent));
        zzDa();
    }
}
