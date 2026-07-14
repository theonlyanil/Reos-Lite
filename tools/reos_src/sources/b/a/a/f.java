package b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f1909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f1911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1912d;

    f(c cVar, Looper looper, int i) {
        super(looper);
        this.f1911c = cVar;
        this.f1910b = i;
        this.f1909a = new i();
    }

    void a(m mVar, Object obj) {
        h hVarA = h.a(mVar, obj);
        synchronized (this) {
            this.f1909a.a(hVarA);
            if (!this.f1912d) {
                this.f1912d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                h hVarA = this.f1909a.a();
                if (hVarA == null) {
                    synchronized (this) {
                        hVarA = this.f1909a.a();
                        if (hVarA == null) {
                            this.f1912d = false;
                            this.f1912d = false;
                            return;
                        }
                    }
                }
                this.f1911c.a(hVarA);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f1910b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f1912d = true;
        } catch (Throwable th) {
            this.f1912d = false;
            throw th;
        }
    }
}
