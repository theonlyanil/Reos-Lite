package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q f476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f477b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f478c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.q.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    q.this.b((b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f480e;

    interface a {
        void a();

        void a(int i);
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f483b;

        b(int i, a aVar) {
            this.f482a = new WeakReference<>(aVar);
            this.f483b = i;
        }

        boolean a(a aVar) {
            return aVar != null && this.f482a.get() == aVar;
        }
    }

    private q() {
    }

    static q a() {
        if (f476a == null) {
            f476a = new q();
        }
        return f476a;
    }

    private void a(b bVar) {
        if (bVar.f483b == -2) {
            return;
        }
        int i = 2750;
        if (bVar.f483b > 0) {
            i = bVar.f483b;
        } else if (bVar.f483b == -1) {
            i = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        }
        this.f478c.removeCallbacksAndMessages(bVar);
        this.f478c.sendMessageDelayed(Message.obtain(this.f478c, 0, bVar), i);
    }

    private boolean a(b bVar, int i) {
        a aVar = (a) bVar.f482a.get();
        if (aVar == null) {
            return false;
        }
        this.f478c.removeCallbacksAndMessages(bVar);
        aVar.a(i);
        return true;
    }

    private void b() {
        if (this.f480e != null) {
            this.f479d = this.f480e;
            this.f480e = null;
            a aVar = (a) this.f479d.f482a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.f479d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        synchronized (this.f477b) {
            if (this.f479d == bVar || this.f480e == bVar) {
                a(bVar, 2);
            }
        }
    }

    private boolean f(a aVar) {
        return this.f479d != null && this.f479d.a(aVar);
    }

    private boolean g(a aVar) {
        return this.f480e != null && this.f480e.a(aVar);
    }

    public void a(int i, a aVar) {
        synchronized (this.f477b) {
            if (f(aVar)) {
                this.f479d.f483b = i;
                this.f478c.removeCallbacksAndMessages(this.f479d);
                a(this.f479d);
                return;
            }
            if (g(aVar)) {
                this.f480e.f483b = i;
            } else {
                this.f480e = new b(i, aVar);
            }
            if (this.f479d == null || !a(this.f479d, 4)) {
                this.f479d = null;
                b();
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f477b) {
            if (f(aVar)) {
                this.f479d = null;
                if (this.f480e != null) {
                    b();
                }
            }
        }
    }

    public void a(a aVar, int i) {
        synchronized (this.f477b) {
            if (f(aVar)) {
                a(this.f479d, i);
            } else if (g(aVar)) {
                a(this.f480e, i);
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.f477b) {
            if (f(aVar)) {
                a(this.f479d);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.f477b) {
            if (f(aVar)) {
                this.f478c.removeCallbacksAndMessages(this.f479d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.f477b) {
            if (f(aVar)) {
                a(this.f479d);
            }
        }
    }

    public boolean e(a aVar) {
        boolean z;
        synchronized (this.f477b) {
            z = f(aVar) || g(aVar);
        }
        return z;
    }
}
