package com.journeyapps.barcodescanner.a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5828a = a.class.getSimpleName();
    private static final Collection<String> h = new ArrayList(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Camera f5832e;
    private int g = 1;
    private final Handler.Callback i = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.a.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.g) {
                return false;
            }
            a.this.d();
            return true;
        }
    };
    private final Camera.AutoFocusCallback j = new Camera.AutoFocusCallback() { // from class: com.journeyapps.barcodescanner.a.a.2
        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            a.this.f5833f.post(new Runnable() { // from class: com.journeyapps.barcodescanner.a.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f5830c = false;
                    a.this.c();
                }
            });
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f5833f = new Handler(this.i);

    static {
        h.add("auto");
        h.add("macro");
    }

    public a(Camera camera, d dVar) {
        this.f5832e = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.f5831d = dVar.f() && h.contains(focusMode);
        Log.i(f5828a, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f5831d);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        if (!this.f5829b && !this.f5833f.hasMessages(this.g)) {
            this.f5833f.sendMessageDelayed(this.f5833f.obtainMessage(this.g), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.f5831d || this.f5829b || this.f5830c) {
            return;
        }
        try {
            this.f5832e.autoFocus(this.j);
            this.f5830c = true;
        } catch (RuntimeException e2) {
            Log.w(f5828a, "Unexpected exception while focusing", e2);
            c();
        }
    }

    private void e() {
        this.f5833f.removeMessages(this.g);
    }

    public void a() {
        this.f5829b = false;
        d();
    }

    public void b() {
        this.f5829b = true;
        this.f5830c = false;
        e();
        if (this.f5831d) {
            try {
                this.f5832e.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w(f5828a, "Unexpected exception while cancelling focusing", e2);
            }
        }
    }
}
