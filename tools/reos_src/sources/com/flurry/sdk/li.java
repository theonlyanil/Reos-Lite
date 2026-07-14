package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
class li {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timer f4702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4703b;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            li.this.a();
            new lj().b();
        }
    }

    li() {
    }

    public synchronized void a() {
        if (this.f4702a != null) {
            this.f4702a.cancel();
            this.f4702a = null;
        }
        this.f4703b = null;
    }

    public synchronized void a(long j) {
        if (b()) {
            a();
        }
        this.f4702a = new Timer("FlurrySessionTimer");
        this.f4703b = new a();
        this.f4702a.schedule(this.f4703b, j);
    }

    public boolean b() {
        return this.f4702a != null;
    }
}
