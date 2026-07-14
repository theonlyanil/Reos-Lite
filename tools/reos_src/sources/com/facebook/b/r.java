package com.facebook.b;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q f3805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Exception f3806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f3808d;

    r(q qVar, Exception exc, boolean z, Bitmap bitmap) {
        this.f3805a = qVar;
        this.f3806b = exc;
        this.f3808d = bitmap;
        this.f3807c = z;
    }

    public q a() {
        return this.f3805a;
    }

    public Exception b() {
        return this.f3806b;
    }

    public Bitmap c() {
        return this.f3808d;
    }

    public boolean d() {
        return this.f3807c;
    }
}
