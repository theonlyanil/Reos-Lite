package com.flurry.sdk;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class kh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends kj> f4572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4573b;

    public kh(Class<? extends kj> cls, int i) {
        this.f4572a = cls;
        this.f4573b = i;
    }

    public Class<? extends kj> a() {
        return this.f4572a;
    }

    public boolean b() {
        return this.f4572a != null && Build.VERSION.SDK_INT >= this.f4573b;
    }
}
