package com.journeyapps.barcodescanner.a;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.journeyapps.barcodescanner.k;
import com.journeyapps.barcodescanner.m;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5837a = b.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f5838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SurfaceHolder f5839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f5840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f5841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f f5842f;
    private boolean g = false;
    private d h = new d();
    private Runnable i = new Runnable() { // from class: com.journeyapps.barcodescanner.a.b.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f5837a, "Opening camera");
                b.this.f5840d.a();
            } catch (Exception e2) {
                b.this.a(e2);
                Log.e(b.f5837a, "Failed to open camera", e2);
            }
        }
    };
    private Runnable j = new Runnable() { // from class: com.journeyapps.barcodescanner.a.b.4
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f5837a, "Configuring camera");
                b.this.f5840d.b();
                if (b.this.f5841e != null) {
                    b.this.f5841e.obtainMessage(com.google.b.b.a.f.b.zxing_prewiew_size_ready, b.this.h()).sendToTarget();
                }
            } catch (Exception e2) {
                b.this.a(e2);
                Log.e(b.f5837a, "Failed to configure camera", e2);
            }
        }
    };
    private Runnable k = new Runnable() { // from class: com.journeyapps.barcodescanner.a.b.5
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f5837a, "Starting preview");
                b.this.f5840d.a(b.this.f5839c);
                b.this.f5840d.c();
            } catch (Exception e2) {
                b.this.a(e2);
                Log.e(b.f5837a, "Failed to start preview", e2);
            }
        }
    };
    private Runnable l = new Runnable() { // from class: com.journeyapps.barcodescanner.a.b.6
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f5837a, "Closing camera");
                b.this.f5840d.d();
                b.this.f5840d.e();
            } catch (Exception e2) {
                Log.e(b.f5837a, "Failed to close camera", e2);
            }
            b.this.f5838b.b();
        }
    };

    public b(Context context) {
        m.a();
        this.f5838b = e.a();
        this.f5840d = new c(context);
        this.f5840d.a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Exception exc) {
        if (this.f5841e != null) {
            this.f5841e.obtainMessage(com.google.b.b.a.f.b.zxing_camera_error, exc).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k h() {
        return this.f5840d.h();
    }

    private void i() {
        if (!this.g) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public f a() {
        return this.f5842f;
    }

    public void a(Handler handler) {
        this.f5841e = handler;
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.f5839c = surfaceHolder;
    }

    public void a(d dVar) {
        if (this.g) {
            return;
        }
        this.h = dVar;
        this.f5840d.a(dVar);
    }

    public void a(f fVar) {
        this.f5842f = fVar;
        this.f5840d.a(fVar);
    }

    public void a(final g gVar) {
        i();
        this.f5838b.a(new Runnable() { // from class: com.journeyapps.barcodescanner.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.f5840d.a(gVar);
            }
        });
    }

    public void a(final boolean z) {
        m.a();
        if (this.g) {
            this.f5838b.a(new Runnable() { // from class: com.journeyapps.barcodescanner.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f5840d.a(z);
                }
            });
        }
    }

    public void b() {
        m.a();
        this.g = true;
        this.f5838b.b(this.i);
    }

    public void c() {
        m.a();
        i();
        this.f5838b.a(this.j);
    }

    public void d() {
        m.a();
        i();
        this.f5838b.a(this.k);
    }

    public void e() {
        m.a();
        if (this.g) {
            this.f5838b.a(this.l);
        }
        this.g = false;
    }

    public boolean f() {
        return this.g;
    }
}
