package com.github.mikephil.charting.g;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f5002a = a.NONE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f5003b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.github.mikephil.charting.e.d f5004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected GestureDetector f5005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected T f5006e;

    public enum a {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public b(T t) {
        this.f5006e = t;
        this.f5005d = new GestureDetector(t.getContext(), this);
    }

    protected static float a(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    public void a(MotionEvent motionEvent) {
        c onChartGestureListener = this.f5006e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.f5002a);
        }
    }

    public void a(com.github.mikephil.charting.e.d dVar) {
        this.f5004c = dVar;
    }

    protected void a(com.github.mikephil.charting.e.d dVar, MotionEvent motionEvent) {
        if (dVar == null || dVar.a(this.f5004c)) {
            this.f5006e.a(null);
            this.f5004c = null;
        } else {
            this.f5004c = dVar;
            this.f5006e.a(dVar);
        }
    }

    public void b(MotionEvent motionEvent) {
        c onChartGestureListener = this.f5006e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, this.f5002a);
        }
    }
}
