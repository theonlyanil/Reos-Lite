package com.journeyapps.barcodescanner.a;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import com.journeyapps.barcodescanner.k;
import com.journeyapps.barcodescanner.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5851a = c.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Camera f5852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Camera.CameraInfo f5853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.journeyapps.barcodescanner.a.a f5854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.b.b.a.a f5855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5856f;
    private String g;
    private f i;
    private k j;
    private k k;
    private Context m;
    private d h = new d();
    private int l = -1;
    private final a n = new a();

    private final class a implements Camera.PreviewCallback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g f5858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private k f5859c;

        public a() {
        }

        public void a(g gVar) {
            this.f5858b = gVar;
        }

        public void a(k kVar) {
            this.f5859c = kVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            k kVar = this.f5859c;
            g gVar = this.f5858b;
            if (kVar == null || gVar == null) {
                Log.d(c.f5851a, "Got preview callback, but no handler or resolution available");
            } else {
                gVar.a(new l(bArr, kVar.f5913a, kVar.f5914b, camera.getParameters().getPreviewFormat(), c.this.g()));
            }
        }
    }

    public c(Context context) {
        this.m = context;
    }

    private static List<k> a(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                arrayList.add(new k(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new k(size.width, size.height));
        }
        return arrayList;
    }

    private void a(int i) {
        this.f5852b.setDisplayOrientation(i);
    }

    private void b(boolean z) {
        Camera.Parameters parametersK = k();
        if (parametersK == null) {
            Log.w(f5851a, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i(f5851a, "Initial camera parameters: " + parametersK.flatten());
        if (z) {
            Log.w(f5851a, "In camera config safe mode -- most settings will not be honored");
        }
        com.google.b.b.a.a.a.a(parametersK, this.h.f(), !this.h.g(), z);
        if (!z) {
            com.google.b.b.a.a.a.a(parametersK, false);
            if (this.h.b()) {
                com.google.b.b.a.a.a.e(parametersK);
            }
            if (this.h.c()) {
                com.google.b.b.a.a.a.d(parametersK);
            }
            if (this.h.e() && Build.VERSION.SDK_INT >= 15) {
                com.google.b.b.a.a.a.c(parametersK);
                com.google.b.b.a.a.a.a(parametersK);
                com.google.b.b.a.a.a.b(parametersK);
            }
        }
        List<k> listA = a(parametersK);
        if (listA.size() == 0) {
            this.j = null;
        } else {
            this.j = this.i.a(listA, f());
            parametersK.setPreviewSize(this.j.f5913a, this.j.f5914b);
        }
        Log.i(f5851a, "Final camera parameters: " + parametersK.flatten());
        this.f5852b.setParameters(parametersK);
    }

    private Camera.Parameters k() {
        Camera.Parameters parameters = this.f5852b.getParameters();
        if (this.g == null) {
            this.g = parameters.flatten();
        } else {
            parameters.unflatten(this.g);
        }
        return parameters;
    }

    private int l() {
        int i = 0;
        switch (this.i.a()) {
            case 1:
                i = 90;
                break;
            case 2:
                i = 180;
                break;
            case 3:
                i = 270;
                break;
        }
        int i2 = this.f5853c.facing == 1 ? (360 - ((i + this.f5853c.orientation) % 360)) % 360 : ((this.f5853c.orientation - i) + 360) % 360;
        Log.i(f5851a, "Camera Display Orientation: " + i2);
        return i2;
    }

    private void m() {
        try {
            this.l = l();
            a(this.l);
        } catch (Exception e2) {
            Log.w(f5851a, "Failed to set rotation.");
        }
        try {
            b(false);
        } catch (Exception e3) {
            try {
                b(false);
            } catch (Exception e4) {
                Log.w(f5851a, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f5852b.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.k = this.j;
        } else {
            this.k = new k(previewSize.width, previewSize.height);
        }
        this.n.a(this.k);
    }

    public void a() {
        this.f5852b = com.google.b.b.a.a.a.a.b(this.h.a());
        if (this.f5852b == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iA = com.google.b.b.a.a.a.a.a(this.h.a());
        this.f5853c = new Camera.CameraInfo();
        Camera.getCameraInfo(iA, this.f5853c);
    }

    public void a(SurfaceHolder surfaceHolder) throws IOException {
        this.f5852b.setPreviewDisplay(surfaceHolder);
    }

    public void a(d dVar) {
        this.h = dVar;
    }

    public void a(f fVar) {
        this.i = fVar;
    }

    public void a(g gVar) {
        Camera camera = this.f5852b;
        if (camera == null || !this.f5856f) {
            return;
        }
        this.n.a(gVar);
        camera.setOneShotPreviewCallback(this.n);
    }

    public void a(boolean z) {
        if (this.f5852b == null || z == i()) {
            return;
        }
        if (this.f5854d != null) {
            this.f5854d.b();
        }
        Camera.Parameters parameters = this.f5852b.getParameters();
        com.google.b.b.a.a.a.a(parameters, z);
        if (this.h.d()) {
            com.google.b.b.a.a.a.b(parameters, z);
        }
        this.f5852b.setParameters(parameters);
        if (this.f5854d != null) {
            this.f5854d.a();
        }
    }

    public void b() {
        m();
    }

    public void c() {
        Camera camera = this.f5852b;
        if (camera == null || this.f5856f) {
            return;
        }
        camera.startPreview();
        this.f5856f = true;
        this.f5854d = new com.journeyapps.barcodescanner.a.a(this.f5852b, this.h);
        this.f5855e = new com.google.b.b.a.a(this.m, this, this.h);
        this.f5855e.a();
    }

    public void d() {
        if (this.f5854d != null) {
            this.f5854d.b();
            this.f5854d = null;
        }
        if (this.f5855e != null) {
            this.f5855e.b();
            this.f5855e = null;
        }
        if (this.f5852b == null || !this.f5856f) {
            return;
        }
        this.f5852b.stopPreview();
        this.n.a((g) null);
        this.f5856f = false;
    }

    public void e() {
        if (this.f5852b != null) {
            this.f5852b.release();
            this.f5852b = null;
        }
    }

    public boolean f() {
        if (this.l == -1) {
            throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
        }
        return this.l % 180 != 0;
    }

    public int g() {
        return this.l;
    }

    public k h() {
        if (this.k == null) {
            return null;
        }
        return f() ? this.k.a() : this.k;
    }

    public boolean i() {
        String flashMode;
        Camera.Parameters parameters = this.f5852b.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }
}
