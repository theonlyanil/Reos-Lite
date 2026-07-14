package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class ko {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4589a = ko.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f4590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private kp f4592d;

    class a extends TimerTask {
        private a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            kg.a(3, ko.f4589a, "HttpRequest timed out. Cancelling.");
            ko.this.f4592d.k();
        }
    }

    public ko(kp kpVar) {
        this.f4592d = kpVar;
    }

    public synchronized void a() {
        if (this.f4590b != null) {
            this.f4590b.cancel();
            this.f4590b = null;
            kg.a(3, f4589a, "HttpRequestTimeoutTimer stopped.");
        }
        this.f4591c = null;
    }

    public synchronized void a(long j) {
        if (b()) {
            a();
        }
        this.f4590b = new Timer("HttpRequestTimeoutTimer");
        this.f4591c = new a();
        this.f4590b.schedule(this.f4591c, j);
        kg.a(3, f4589a, "HttpRequestTimeoutTimer started: " + j + "MS");
    }

    public boolean b() {
        return this.f4590b != null;
    }
}
