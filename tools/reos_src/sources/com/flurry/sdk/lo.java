package com.flurry.sdk;

/* JADX INFO: loaded from: classes.dex */
public class lo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f4715a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static lo f4716b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final lp f4717c = new lp();

    public lo() {
        this.f4717c.a(f4715a);
        this.f4717c.a(true);
    }

    public static synchronized lo a() {
        if (f4716b == null) {
            f4716b = new lo();
        }
        return f4716b;
    }

    public static synchronized void b() {
        if (f4716b != null) {
            f4716b.c();
            f4716b = null;
        }
    }

    public synchronized void a(kb<ln> kbVar) {
        kc.a().a("com.flurry.android.sdk.TickEvent", kbVar);
        if (kc.a().b("com.flurry.android.sdk.TickEvent") > 0) {
            this.f4717c.a();
        }
    }

    public synchronized void b(kb<ln> kbVar) {
        kc.a().b("com.flurry.android.sdk.TickEvent", kbVar);
        if (kc.a().b("com.flurry.android.sdk.TickEvent") == 0) {
            this.f4717c.b();
        }
    }

    public synchronized void c() {
        kc.a().a("com.flurry.android.sdk.TickEvent");
        this.f4717c.b();
    }
}
