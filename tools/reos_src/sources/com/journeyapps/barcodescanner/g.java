package com.journeyapps.barcodescanner;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5897a = g.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.journeyapps.barcodescanner.a.b f5898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerThread f5899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f5900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f5901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f5902f;
    private Rect g;
    private boolean h = false;
    private final Object i = new Object();
    private final Handler.Callback j = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.g.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != com.google.b.b.a.f.b.zxing_decode) {
                return true;
            }
            g.this.b((l) message.obj);
            return true;
        }
    };
    private final com.journeyapps.barcodescanner.a.g k = new com.journeyapps.barcodescanner.a.g() { // from class: com.journeyapps.barcodescanner.g.2
        @Override // com.journeyapps.barcodescanner.a.g
        public void a(l lVar) {
            synchronized (g.this.i) {
                if (g.this.h) {
                    g.this.f5900d.obtainMessage(com.google.b.b.a.f.b.zxing_decode, lVar).sendToTarget();
                }
            }
        }
    };

    public g(com.journeyapps.barcodescanner.a.b bVar, d dVar, Handler handler) {
        m.a();
        this.f5898b = bVar;
        this.f5901e = dVar;
        this.f5902f = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        lVar.a(this.g);
        com.google.b.g gVarA = a(lVar);
        com.google.b.m mVarA = gVarA != null ? this.f5901e.a(gVarA) : null;
        if (mVarA != null) {
            Log.d(f5897a, "Found barcode in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            if (this.f5902f != null) {
                Message messageObtain = Message.obtain(this.f5902f, com.google.b.b.a.f.b.zxing_decode_succeeded, new b(mVarA, lVar));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else if (this.f5902f != null) {
            Message.obtain(this.f5902f, com.google.b.b.a.f.b.zxing_decode_failed).sendToTarget();
        }
        if (this.f5902f != null) {
            Message.obtain(this.f5902f, com.google.b.b.a.f.b.zxing_possible_result_points, this.f5901e.a()).sendToTarget();
        }
        c();
    }

    private void c() {
        if (this.f5898b.f()) {
            this.f5898b.a(this.k);
        }
    }

    protected com.google.b.g a(l lVar) {
        if (this.g == null) {
            return null;
        }
        return lVar.b();
    }

    public void a() {
        m.a();
        this.f5899c = new HandlerThread(f5897a);
        this.f5899c.start();
        this.f5900d = new Handler(this.f5899c.getLooper(), this.j);
        this.h = true;
        c();
    }

    public void a(Rect rect) {
        this.g = rect;
    }

    public void a(d dVar) {
        this.f5901e = dVar;
    }

    public void b() {
        m.a();
        synchronized (this.i) {
            this.h = false;
            this.f5900d.removeCallbacksAndMessages(null);
            this.f5899c.quit();
        }
    }
}
