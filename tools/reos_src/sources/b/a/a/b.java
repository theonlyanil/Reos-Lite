package b.a.a;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f1886a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f1887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f1888c;

    b(c cVar) {
        this.f1887b = cVar;
    }

    public void a(m mVar, Object obj) {
        h hVarA = h.a(mVar, obj);
        synchronized (this) {
            this.f1886a.a(hVarA);
            if (!this.f1888c) {
                this.f1888c = true;
                this.f1887b.b().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    h hVarA = this.f1886a.a(1000);
                    if (hVarA == null) {
                        synchronized (this) {
                            try {
                                hVarA = this.f1886a.a();
                                if (hVarA == null) {
                                    this.f1888c = false;
                                    this.f1888c = false;
                                    return;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    this.f1887b.a(hVarA);
                } catch (InterruptedException e2) {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e2);
                    this.f1888c = false;
                    return;
                }
            } catch (Throwable th2) {
                this.f1888c = false;
                throw th2;
            }
        }
    }
}
