package com.a.a.d.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f2164b = new Handler(Looper.getMainLooper(), new a());

    private static class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((k) message.obj).d();
            return true;
        }
    }

    l() {
    }

    public void a(k<?> kVar) {
        com.a.a.j.h.a();
        if (this.f2163a) {
            this.f2164b.obtainMessage(1, kVar).sendToTarget();
            return;
        }
        this.f2163a = true;
        kVar.d();
        this.f2163a = false;
    }
}
