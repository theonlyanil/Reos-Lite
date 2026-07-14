package com.google.android.gms.common.stats;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        return getTimeMillis() + "\t" + getEventType() + "\t" + zzrv() + zzry();
    }

    public abstract long zzrv();

    public abstract String zzry();
}
