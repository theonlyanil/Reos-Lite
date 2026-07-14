package com.google.b.b.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class a implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.journeyapps.barcodescanner.a.c f5395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.journeyapps.barcodescanner.a.d f5396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Sensor f5397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f5398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f5399e = new Handler();

    public a(Context context, com.journeyapps.barcodescanner.a.c cVar, com.journeyapps.barcodescanner.a.d dVar) {
        this.f5398d = context;
        this.f5395a = cVar;
        this.f5396b = dVar;
    }

    private void a(final boolean z) {
        this.f5399e.post(new Runnable() { // from class: com.google.b.b.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f5395a.a(z);
            }
        });
    }

    public void a() {
        if (this.f5396b.h()) {
            SensorManager sensorManager = (SensorManager) this.f5398d.getSystemService("sensor");
            this.f5397c = sensorManager.getDefaultSensor(5);
            if (this.f5397c != null) {
                sensorManager.registerListener(this, this.f5397c, 3);
            }
        }
    }

    public void b() {
        if (this.f5397c != null) {
            ((SensorManager) this.f5398d.getSystemService("sensor")).unregisterListener(this);
            this.f5397c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        if (this.f5395a != null) {
            if (f2 <= 45.0f) {
                a(true);
            } else if (f2 >= 450.0f) {
                a(false);
            }
        }
    }
}
