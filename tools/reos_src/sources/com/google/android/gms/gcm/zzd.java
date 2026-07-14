package com.google.android.gms.gcm;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class zzd {
    public static final zzd zzaJo = new zzd(0, 30, 3600);
    public static final zzd zzaJp = new zzd(1, 30, 3600);
    private final int zzaJq;
    private final int zzaJr;
    private final int zzaJs;

    private zzd(int i, int i2, int i3) {
        this.zzaJq = i;
        this.zzaJr = i2;
        this.zzaJs = i3;
    }

    public Bundle zzE(Bundle bundle) {
        bundle.putInt("retry_policy", this.zzaJq);
        bundle.putInt("initial_backoff_seconds", this.zzaJr);
        bundle.putInt("maximum_backoff_seconds", this.zzaJs);
        return bundle;
    }

    public int zzxA() {
        return this.zzaJq;
    }

    public int zzxB() {
        return this.zzaJr;
    }

    public int zzxC() {
        return this.zzaJs;
    }
}
