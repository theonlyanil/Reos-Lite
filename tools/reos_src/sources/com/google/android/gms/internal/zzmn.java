package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class zzmn<L> {
    private volatile L mListener;
    private final zzmn<L>.zza zzagR;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            zzx.zzab(message.what == 1);
            zzmn.this.zzb((zzb) message.obj);
        }
    }

    public interface zzb<L> {
        void zzpb();

        void zzs(L l);
    }

    zzmn(Looper looper, L l) {
        this.zzagR = new zza(looper);
        this.mListener = (L) zzx.zzb(l, "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzbVar) {
        zzx.zzb(zzbVar, "Notifier must not be null");
        this.zzagR.sendMessage(this.zzagR.obtainMessage(1, zzbVar));
    }

    void zzb(zzb<? super L> zzbVar) {
        L l = this.mListener;
        if (l == null) {
            zzbVar.zzpb();
            return;
        }
        try {
            zzbVar.zzs(l);
        } catch (RuntimeException e2) {
            zzbVar.zzpb();
            throw e2;
        }
    }
}
