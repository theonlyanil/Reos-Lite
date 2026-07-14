package com.journeyapps.barcodescanner.a;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5866a = e.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e f5867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f5868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HandlerThread f5869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5870e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f5871f = new Object();

    private e() {
    }

    public static e a() {
        if (f5867b == null) {
            f5867b = new e();
        }
        return f5867b;
    }

    private void c() {
        synchronized (this.f5871f) {
            this.f5869d.quit();
            this.f5869d = null;
            this.f5868c = null;
        }
    }

    protected void a(Runnable runnable) {
        synchronized (this.f5871f) {
            if (this.f5868c == null) {
                if (this.f5870e <= 0) {
                    throw new IllegalStateException("CameraThread is not open");
                }
                this.f5869d = new HandlerThread("CameraThread");
                this.f5869d.start();
                this.f5868c = new Handler(this.f5869d.getLooper());
            }
            this.f5868c.post(runnable);
        }
    }

    protected void b() {
        synchronized (this.f5871f) {
            this.f5870e--;
            if (this.f5870e == 0) {
                c();
            }
        }
    }

    protected void b(Runnable runnable) {
        synchronized (this.f5871f) {
            this.f5870e++;
            a(runnable);
        }
    }
}
