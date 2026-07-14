package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static js f4516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4517b = js.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4518c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f4520e;
    private final String g;
    private final ki h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f4519d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HandlerThread f4521f = new HandlerThread("FlurryAgent");

    private js(Context context, String str) {
        this.f4518c = context.getApplicationContext();
        this.f4521f.start();
        this.f4520e = new Handler(this.f4521f.getLooper());
        this.g = str;
        this.h = new ki();
    }

    public static js a() {
        return f4516a;
    }

    private void a(Context context) {
        this.h.a(context);
    }

    public static synchronized void a(Context context, String str) {
        if (f4516a != null) {
            if (!f4516a.d().equals(str)) {
                throw new IllegalStateException("Only one API key per application is supported!");
            }
        } else {
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("API key must be specified");
            }
            f4516a = new js(context, str);
            f4516a.a(context);
        }
    }

    public static synchronized void b() {
        if (f4516a != null) {
            f4516a.h();
            f4516a = null;
        }
    }

    private void h() {
        i();
        this.f4521f.quit();
    }

    private void i() {
        this.h.a();
    }

    public kj a(Class<? extends kj> cls) {
        return this.h.a(cls);
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f4519d.post(runnable);
    }

    public void a(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.f4519d.postDelayed(runnable, j);
    }

    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f4520e.post(runnable);
    }

    public void b(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.f4520e.postDelayed(runnable, j);
    }

    public Context c() {
        return this.f4518c;
    }

    public void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f4520e.removeCallbacks(runnable);
    }

    public String d() {
        return this.g;
    }

    public PackageManager e() {
        return this.f4518c.getPackageManager();
    }

    public Handler f() {
        return this.f4519d;
    }

    public Handler g() {
        return this.f4520e;
    }
}
