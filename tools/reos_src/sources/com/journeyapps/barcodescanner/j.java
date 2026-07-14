package com.journeyapps.barcodescanner;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WindowManager f5909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OrientationEventListener f5910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i f5911d;

    public void a() {
        if (this.f5910c != null) {
            this.f5910c.disable();
        }
        this.f5910c = null;
        this.f5909b = null;
        this.f5911d = null;
    }

    public void a(Context context, i iVar) {
        a();
        Context applicationContext = context.getApplicationContext();
        this.f5911d = iVar;
        this.f5909b = (WindowManager) applicationContext.getSystemService("window");
        this.f5910c = new OrientationEventListener(applicationContext, 3) { // from class: com.journeyapps.barcodescanner.j.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                int rotation;
                WindowManager windowManager = j.this.f5909b;
                i iVar2 = j.this.f5911d;
                if (j.this.f5909b == null || iVar2 == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == j.this.f5908a) {
                    return;
                }
                j.this.f5908a = rotation;
                iVar2.a(rotation);
            }
        };
        this.f5910c.enable();
        this.f5908a = this.f5909b.getDefaultDisplay().getRotation();
    }
}
