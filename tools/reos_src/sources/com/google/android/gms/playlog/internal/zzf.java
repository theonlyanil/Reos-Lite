package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztk;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzf extends zzj<zza> {
    private final String zzSp;
    private final zzd zzaYG;
    private final zzb zzaYH;
    private boolean zzaYI;
    private final Object zzpK;

    public zzf(Context context, Looper looper, zzd zzdVar, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 24, zzfVar, zzdVar, zzdVar);
        this.zzSp = context.getPackageName();
        this.zzaYG = (zzd) zzx.zzy(zzdVar);
        this.zzaYG.zza(this);
        this.zzaYH = new zzb();
        this.zzpK = new Object();
        this.zzaYI = true;
    }

    private void zzDb() {
        PlayLoggerContext playLoggerContext;
        com.google.android.gms.common.internal.zzb.zzaa(!this.zzaYI);
        if (this.zzaYH.isEmpty()) {
            return;
        }
        PlayLoggerContext playLoggerContext2 = null;
        try {
            ArrayList arrayList = new ArrayList();
            for (zzb.zza zzaVar : this.zzaYH.zzCZ()) {
                if (zzaVar.zzaYv != null) {
                    zzqs().zza(this.zzSp, zzaVar.zzaYt, zztk.toByteArray(zzaVar.zzaYv));
                } else {
                    if (zzaVar.zzaYt.equals(playLoggerContext2)) {
                        arrayList.add(zzaVar.zzaYu);
                        playLoggerContext = playLoggerContext2;
                    } else {
                        if (!arrayList.isEmpty()) {
                            zzqs().zza(this.zzSp, playLoggerContext2, arrayList);
                            arrayList.clear();
                        }
                        PlayLoggerContext playLoggerContext3 = zzaVar.zzaYt;
                        arrayList.add(zzaVar.zzaYu);
                        playLoggerContext = playLoggerContext3;
                    }
                    playLoggerContext2 = playLoggerContext;
                }
            }
            if (!arrayList.isEmpty()) {
                zzqs().zza(this.zzSp, playLoggerContext2, arrayList);
            }
            this.zzaYH.clear();
        } catch (RemoteException e2) {
            Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
        }
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaYH.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            zzDb();
            zzqs().zza(this.zzSp, playLoggerContext, logEvent);
        } catch (RemoteException e2) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e3) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        }
    }

    public void start() {
        synchronized (this.zzpK) {
            if (isConnecting() || isConnected()) {
                return;
            }
            this.zzaYG.zzar(true);
            zzqp();
        }
    }

    public void stop() {
        synchronized (this.zzpK) {
            this.zzaYG.zzar(false);
            disconnect();
        }
    }

    void zzas(boolean z) {
        synchronized (this.zzpK) {
            boolean z2 = this.zzaYI;
            this.zzaYI = z;
            if (z2 && !this.zzaYI) {
                zzDb();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzpK) {
            if (this.zzaYI) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzdJ, reason: merged with bridge method [inline-methods] */
    public zza zzW(IBinder iBinder) {
        return zza.AbstractBinderC0180zza.zzdI(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgh() {
        return "com.google.android.gms.playlog.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgi() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
