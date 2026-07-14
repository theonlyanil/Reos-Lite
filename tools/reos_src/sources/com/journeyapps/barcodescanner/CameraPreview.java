package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CameraPreview extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5802a = CameraPreview.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.journeyapps.barcodescanner.a.b f5803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WindowManager f5804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f5805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SurfaceView f5806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5807f;
    private j g;
    private List<a> h;
    private com.journeyapps.barcodescanner.a.f i;
    private com.journeyapps.barcodescanner.a.d j;
    private k k;
    private k l;
    private Rect m;
    private k n;
    private Rect o;
    private Rect p;
    private final SurfaceHolder.Callback q;
    private final Handler.Callback r;
    private i s;
    private final a t;

    public interface a {
        void a();

        void a(Exception exc);

        void b();

        void c();
    }

    public CameraPreview(Context context) {
        super(context);
        this.f5807f = false;
        this.h = new ArrayList();
        this.j = new com.journeyapps.barcodescanner.a.d();
        this.o = null;
        this.p = null;
        this.q = new SurfaceHolder.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                if (surfaceHolder == null) {
                    Log.e(CameraPreview.f5802a, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.n = new k(i2, i3);
                CameraPreview.this.j();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                CameraPreview.this.n = null;
            }
        };
        this.r = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == com.google.b.b.a.f.b.zxing_prewiew_size_ready) {
                    CameraPreview.this.b((k) message.obj);
                    return true;
                }
                if (message.what == com.google.b.b.a.f.b.zxing_camera_error) {
                    Exception exc = (Exception) message.obj;
                    if (CameraPreview.this.f()) {
                        CameraPreview.this.d();
                        CameraPreview.this.t.a(exc);
                    }
                }
                return false;
            }
        };
        this.s = new i() { // from class: com.journeyapps.barcodescanner.CameraPreview.3
            @Override // com.journeyapps.barcodescanner.i
            public void a(int i) {
                CameraPreview.this.f5805d.post(new Runnable() { // from class: com.journeyapps.barcodescanner.CameraPreview.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraPreview.this.a();
                    }
                });
            }
        };
        this.t = new a() { // from class: com.journeyapps.barcodescanner.CameraPreview.4
            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a(Exception exc) {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(exc);
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void b() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void c() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).c();
                }
            }
        };
        a(context, null, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5807f = false;
        this.h = new ArrayList();
        this.j = new com.journeyapps.barcodescanner.a.d();
        this.o = null;
        this.p = null;
        this.q = new SurfaceHolder.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                if (surfaceHolder == null) {
                    Log.e(CameraPreview.f5802a, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.n = new k(i2, i3);
                CameraPreview.this.j();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                CameraPreview.this.n = null;
            }
        };
        this.r = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == com.google.b.b.a.f.b.zxing_prewiew_size_ready) {
                    CameraPreview.this.b((k) message.obj);
                    return true;
                }
                if (message.what == com.google.b.b.a.f.b.zxing_camera_error) {
                    Exception exc = (Exception) message.obj;
                    if (CameraPreview.this.f()) {
                        CameraPreview.this.d();
                        CameraPreview.this.t.a(exc);
                    }
                }
                return false;
            }
        };
        this.s = new i() { // from class: com.journeyapps.barcodescanner.CameraPreview.3
            @Override // com.journeyapps.barcodescanner.i
            public void a(int i) {
                CameraPreview.this.f5805d.post(new Runnable() { // from class: com.journeyapps.barcodescanner.CameraPreview.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraPreview.this.a();
                    }
                });
            }
        };
        this.t = new a() { // from class: com.journeyapps.barcodescanner.CameraPreview.4
            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a(Exception exc) {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(exc);
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void b() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void c() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).c();
                }
            }
        };
        a(context, attributeSet, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5807f = false;
        this.h = new ArrayList();
        this.j = new com.journeyapps.barcodescanner.a.d();
        this.o = null;
        this.p = null;
        this.q = new SurfaceHolder.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                if (surfaceHolder == null) {
                    Log.e(CameraPreview.f5802a, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.n = new k(i3, i4);
                CameraPreview.this.j();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                CameraPreview.this.n = null;
            }
        };
        this.r = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.CameraPreview.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == com.google.b.b.a.f.b.zxing_prewiew_size_ready) {
                    CameraPreview.this.b((k) message.obj);
                    return true;
                }
                if (message.what == com.google.b.b.a.f.b.zxing_camera_error) {
                    Exception exc = (Exception) message.obj;
                    if (CameraPreview.this.f()) {
                        CameraPreview.this.d();
                        CameraPreview.this.t.a(exc);
                    }
                }
                return false;
            }
        };
        this.s = new i() { // from class: com.journeyapps.barcodescanner.CameraPreview.3
            @Override // com.journeyapps.barcodescanner.i
            public void a(int i2) {
                CameraPreview.this.f5805d.post(new Runnable() { // from class: com.journeyapps.barcodescanner.CameraPreview.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraPreview.this.a();
                    }
                });
            }
        };
        this.t = new a() { // from class: com.journeyapps.barcodescanner.CameraPreview.4
            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void a(Exception exc) {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(exc);
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void b() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b();
                }
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.a
            public void c() {
                Iterator it = CameraPreview.this.h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).c();
                }
            }
        };
        a(context, attributeSet, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        d();
        e();
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        this.f5804c = (WindowManager) context.getSystemService("window");
        this.f5805d = new Handler(this.r);
        b();
        this.g = new j();
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (this.f5807f) {
            return;
        }
        Log.i(f5802a, "Starting preview");
        this.f5803b.a(surfaceHolder);
        this.f5803b.d();
        this.f5807f = true;
        c();
        this.t.b();
    }

    private void a(k kVar) {
        this.k = kVar;
        if (this.f5803b == null || this.f5803b.a() != null) {
            return;
        }
        this.i = new com.journeyapps.barcodescanner.a.f(getDisplayRotation(), kVar);
        this.f5803b.a(this.i);
        this.f5803b.c();
    }

    private void b() {
        this.f5806e = new SurfaceView(getContext());
        if (Build.VERSION.SDK_INT < 11) {
            this.f5806e.getHolder().setType(3);
        }
        this.f5806e.getHolder().addCallback(this.q);
        addView(this.f5806e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(k kVar) {
        this.l = kVar;
        if (this.k != null) {
            i();
            requestLayout();
            j();
        }
    }

    private int getDisplayRotation() {
        return this.f5804c.getDefaultDisplay().getRotation();
    }

    private void i() {
        if (this.k == null || this.l == null || this.i == null) {
            this.p = null;
            this.o = null;
            this.m = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i = this.l.f5913a;
        int i2 = this.l.f5914b;
        int i3 = this.k.f5913a;
        int i4 = this.k.f5914b;
        this.m = this.i.a(this.l);
        this.o = a(new Rect(0, 0, i3, i4), this.m);
        Rect rect = new Rect(this.o);
        rect.offset(-this.m.left, -this.m.top);
        this.p = new Rect((rect.left * i) / this.m.width(), (rect.top * i2) / this.m.height(), (i * rect.right) / this.m.width(), (i2 * rect.bottom) / this.m.height());
        if (this.p.width() > 0 && this.p.height() > 0) {
            this.t.a();
            return;
        }
        this.p = null;
        this.o = null;
        Log.w(f5802a, "Preview frame is too small");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.n == null || this.l == null || this.m == null || !this.n.equals(new k(this.m.width(), this.m.height()))) {
            return;
        }
        a(this.f5806e.getHolder());
    }

    private void k() {
        if (this.f5803b != null) {
            Log.w(f5802a, "initCamera called twice");
            return;
        }
        this.f5803b = new com.journeyapps.barcodescanner.a.b(getContext());
        this.f5803b.a(this.j);
        this.f5803b.a(this.f5805d);
        this.f5803b.b();
    }

    protected Rect a(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        int iMin = Math.min(rect3.width() / 10, rect3.height() / 10);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public void a(a aVar) {
        this.h.add(aVar);
    }

    protected void c() {
    }

    public void d() {
        m.a();
        Log.d(f5802a, "pause()");
        if (this.f5803b != null) {
            this.f5803b.e();
            this.f5803b = null;
            this.f5807f = false;
        }
        if (this.n == null) {
            this.f5806e.getHolder().removeCallback(this.q);
        }
        this.k = null;
        this.l = null;
        this.p = null;
        this.g.a();
        this.t.c();
    }

    public void e() {
        m.a();
        Log.d(f5802a, "resume()");
        k();
        if (this.n != null) {
            j();
        } else {
            this.f5806e.getHolder().addCallback(this.q);
        }
        requestLayout();
        this.g.a(getContext(), this.s);
    }

    protected boolean f() {
        return this.f5803b != null;
    }

    public boolean g() {
        return this.f5807f;
    }

    public com.journeyapps.barcodescanner.a.b getCameraInstance() {
        return this.f5803b;
    }

    public com.journeyapps.barcodescanner.a.d getCameraSettings() {
        return this.j;
    }

    public Rect getFramingRect() {
        return this.o;
    }

    public Rect getPreviewFramingRect() {
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a(new k(i3 - i, i4 - i2));
        if (this.m == null) {
            this.f5806e.layout(0, 0, getWidth(), getHeight());
        } else {
            this.f5806e.layout(this.m.left, this.m.top, this.m.right, this.m.bottom);
        }
    }

    public void setCameraSettings(com.journeyapps.barcodescanner.a.d dVar) {
        this.j = dVar;
    }

    public void setTorch(boolean z) {
        if (this.f5803b != null) {
            this.f5803b.a(z);
        }
    }
}
