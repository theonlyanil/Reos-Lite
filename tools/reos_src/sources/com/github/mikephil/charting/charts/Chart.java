package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.a.a;
import com.github.mikephil.charting.c.c;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.i;
import com.github.mikephil.charting.data.k;
import com.github.mikephil.charting.f.e;
import com.github.mikephil.charting.g.b;
import com.github.mikephil.charting.g.d;
import com.github.mikephil.charting.h.f;
import com.github.mikephil.charting.h.h;
import com.github.mikephil.charting.i.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public abstract class Chart<T extends i<? extends k<? extends Entry>>> extends ViewGroup implements e {
    protected boolean A;
    protected float B;
    protected float C;
    protected float D;
    protected boolean E;
    protected c F;
    protected d G;
    protected b H;
    protected h I;
    protected f J;
    protected com.github.mikephil.charting.e.b K;
    protected g L;
    protected a M;
    protected Paint N;
    protected com.github.mikephil.charting.e.d[] O;
    protected boolean P;
    protected com.github.mikephil.charting.c.e Q;
    protected ArrayList<Runnable> R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.github.mikephil.charting.g.c f4914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4916f;
    private float g;
    private float h;
    private float i;
    private boolean j;
    private PointF k;
    protected boolean t;
    protected T u;
    protected boolean v;
    protected com.github.mikephil.charting.d.f w;
    protected Paint x;
    protected Paint y;
    protected String z;

    public Chart(Context context) {
        super(context);
        this.t = false;
        this.u = null;
        this.v = true;
        this.f4911a = true;
        this.f4912b = 0.9f;
        this.z = "Description";
        this.A = true;
        this.B = 1.0f;
        this.C = BitmapDescriptorFactory.HUE_RED;
        this.D = BitmapDescriptorFactory.HUE_RED;
        this.E = true;
        this.f4913c = "No chart data available.";
        this.f4916f = BitmapDescriptorFactory.HUE_RED;
        this.g = BitmapDescriptorFactory.HUE_RED;
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.i = BitmapDescriptorFactory.HUE_RED;
        this.j = false;
        this.P = true;
        this.R = new ArrayList<>();
        a();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = false;
        this.u = null;
        this.v = true;
        this.f4911a = true;
        this.f4912b = 0.9f;
        this.z = "Description";
        this.A = true;
        this.B = 1.0f;
        this.C = BitmapDescriptorFactory.HUE_RED;
        this.D = BitmapDescriptorFactory.HUE_RED;
        this.E = true;
        this.f4913c = "No chart data available.";
        this.f4916f = BitmapDescriptorFactory.HUE_RED;
        this.g = BitmapDescriptorFactory.HUE_RED;
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.i = BitmapDescriptorFactory.HUE_RED;
        this.j = false;
        this.P = true;
        this.R = new ArrayList<>();
        a();
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = false;
        this.u = null;
        this.v = true;
        this.f4911a = true;
        this.f4912b = 0.9f;
        this.z = "Description";
        this.A = true;
        this.B = 1.0f;
        this.C = BitmapDescriptorFactory.HUE_RED;
        this.D = BitmapDescriptorFactory.HUE_RED;
        this.E = true;
        this.f4913c = "No chart data available.";
        this.f4916f = BitmapDescriptorFactory.HUE_RED;
        this.g = BitmapDescriptorFactory.HUE_RED;
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.i = BitmapDescriptorFactory.HUE_RED;
        this.j = false;
        this.P = true;
        this.R = new ArrayList<>();
        a();
    }

    protected void a() {
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT < 11) {
            this.M = new a();
        } else {
            this.M = new a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.Chart.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Chart.this.postInvalidate();
                }
            });
        }
        com.github.mikephil.charting.i.f.a(getContext());
        this.w = new com.github.mikephil.charting.d.b(1);
        this.L = new g();
        this.F = new c();
        this.I = new h(this.L, this.F);
        this.x = new Paint(1);
        this.x.setColor(-16777216);
        this.x.setTextAlign(Paint.Align.RIGHT);
        this.x.setTextSize(com.github.mikephil.charting.i.f.a(9.0f));
        this.y = new Paint(1);
        this.y.setColor(Color.rgb(247, 189, 51));
        this.y.setTextAlign(Paint.Align.CENTER);
        this.y.setTextSize(com.github.mikephil.charting.i.f.a(12.0f));
        this.N = new Paint(4);
        if (this.t) {
            Log.i("", "Chart.init()");
        }
    }

    @Deprecated
    public void a(com.github.mikephil.charting.e.d dVar) {
        a(dVar, true);
    }

    public void a(com.github.mikephil.charting.e.d dVar, boolean z) {
        Entry entry = null;
        if (dVar == null) {
            this.O = null;
        } else {
            if (this.t) {
                Log.i("MPAndroidChart", "Highlighted: " + dVar.toString());
            }
            Entry entryA = this.u.a(dVar);
            if (entryA == null || entryA.f() != dVar.b()) {
                this.O = null;
                dVar = null;
                entry = entryA;
            } else {
                this.O = new com.github.mikephil.charting.e.d[]{dVar};
                entry = entryA;
            }
        }
        if (z && this.G != null) {
            if (u()) {
                this.G.a(entry, dVar.a(), dVar);
            } else {
                this.G.a();
            }
        }
        invalidate();
    }

    public void a(com.github.mikephil.charting.e.d[] dVarArr) {
        this.O = dVarArr;
        if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null) {
            this.H.a((com.github.mikephil.charting.e.d) null);
        } else {
            this.H.a(dVarArr[0]);
        }
        invalidate();
    }

    protected abstract float[] a(Entry entry, com.github.mikephil.charting.e.d dVar);

    protected abstract void b();

    protected void b(Canvas canvas) {
        if (this.z.equals("")) {
            return;
        }
        if (this.k == null) {
            canvas.drawText(this.z, (getWidth() - this.L.b()) - 10.0f, (getHeight() - this.L.d()) - 10.0f, this.x);
        } else {
            canvas.drawText(this.z, this.k.x, this.k.y, this.x);
        }
    }

    protected void c(float f2, float f3) {
        this.w = new com.github.mikephil.charting.d.b(com.github.mikephil.charting.i.f.b((this.u == null || this.u.n() < 2) ? Math.max(Math.abs(f2), Math.abs(f3)) : Math.abs(f3 - f2)));
    }

    protected void c(Canvas canvas) {
        Entry entryA;
        if (this.Q != null && this.P && u()) {
            for (int i = 0; i < this.O.length; i++) {
                com.github.mikephil.charting.e.d dVar = this.O[i];
                int iB = dVar.b();
                dVar.a();
                if (iB <= this.B && iB <= this.B * this.M.b() && (entryA = this.u.a(this.O[i])) != null && entryA.f() == this.O[i].b()) {
                    float[] fArrA = a(entryA, dVar);
                    if (this.L.b(fArrA[0], fArrA[1])) {
                        this.Q.a(entryA, dVar);
                        this.Q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        this.Q.layout(0, 0, this.Q.getMeasuredWidth(), this.Q.getMeasuredHeight());
                        if (fArrA[1] - this.Q.getHeight() <= BitmapDescriptorFactory.HUE_RED) {
                            this.Q.a(canvas, fArrA[0], (this.Q.getHeight() - fArrA[1]) + fArrA[1]);
                        } else {
                            this.Q.a(canvas, fArrA[0], fArrA[1]);
                        }
                    }
                }
            }
        }
    }

    public a getAnimator() {
        return this.M;
    }

    public PointF getCenter() {
        return new PointF(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public PointF getCenterOfView() {
        return getCenter();
    }

    public PointF getCenterOffsets() {
        return this.L.l();
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    public RectF getContentRect() {
        return this.L.k();
    }

    public T getData() {
        return this.u;
    }

    public com.github.mikephil.charting.d.f getDefaultValueFormatter() {
        return this.w;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f4912b;
    }

    public float getExtraBottomOffset() {
        return this.h;
    }

    public float getExtraLeftOffset() {
        return this.i;
    }

    public float getExtraRightOffset() {
        return this.g;
    }

    public float getExtraTopOffset() {
        return this.f4916f;
    }

    public com.github.mikephil.charting.e.d[] getHighlighted() {
        return this.O;
    }

    public ArrayList<Runnable> getJobs() {
        return this.R;
    }

    public c getLegend() {
        return this.F;
    }

    public h getLegendRenderer() {
        return this.I;
    }

    public com.github.mikephil.charting.c.e getMarkerView() {
        return this.Q;
    }

    public com.github.mikephil.charting.g.c getOnChartGestureListener() {
        return this.f4914d;
    }

    public f getRenderer() {
        return this.J;
    }

    public int getValueCount() {
        return this.u.k();
    }

    public g getViewPortHandler() {
        return this.L;
    }

    @Override // com.github.mikephil.charting.f.e
    public float getXChartMax() {
        return this.D;
    }

    public float getXChartMin() {
        return this.C;
    }

    public int getXValCount() {
        return this.u.n();
    }

    public float getYMax() {
        return this.u.h();
    }

    public float getYMin() {
        return this.u.g();
    }

    public abstract void h();

    protected abstract void i();

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.A && this.u != null && this.u.k() > 0) {
            if (this.j) {
                return;
            }
            i();
            this.j = true;
            return;
        }
        canvas.drawText(this.f4913c, getWidth() / 2, getHeight() / 2, this.y);
        if (TextUtils.isEmpty(this.f4915e)) {
            return;
        }
        canvas.drawText(this.f4915e, getWidth() / 2, (-this.y.ascent()) + this.y.descent() + (getHeight() / 2), this.y);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iA = (int) com.github.mikephil.charting.i.f.a(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), resolveSize(iA, i)), Math.max(getSuggestedMinimumHeight(), resolveSize(iA, i2)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.t) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            this.L.a(i, i2);
            if (this.t) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            Iterator<Runnable> it = this.R.iterator();
            while (it.hasNext()) {
                post(it.next());
            }
            this.R.clear();
        }
        h();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setData(T t) {
        if (t == null) {
            Log.e("MPAndroidChart", "Cannot set data for chart. Provided data object is null.");
            return;
        }
        this.A = false;
        this.j = false;
        this.u = t;
        c(t.g(), t.h());
        for (k kVar : this.u.m()) {
            if (kVar.z()) {
                kVar.a(this.w);
            }
        }
        h();
        if (this.t) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(String str) {
        if (str == null) {
            str = "";
        }
        this.z = str;
    }

    public void setDescriptionColor(int i) {
        this.x.setColor(i);
    }

    public void setDescriptionTextSize(float f2) {
        float f3 = f2 <= 16.0f ? f2 : 16.0f;
        this.x.setTextSize(com.github.mikephil.charting.i.f.a(f3 >= 6.0f ? f3 : 6.0f));
    }

    public void setDescriptionTypeface(Typeface typeface) {
        this.x.setTypeface(typeface);
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.f4911a = z;
    }

    public void setDragDecelerationFrictionCoef(float f2) {
        float f3 = BitmapDescriptorFactory.HUE_RED;
        if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            f3 = f2;
        }
        if (f3 >= 1.0f) {
            f3 = 0.999f;
        }
        this.f4912b = f3;
    }

    public void setDrawMarkerViews(boolean z) {
        this.P = z;
    }

    public void setExtraBottomOffset(float f2) {
        this.h = com.github.mikephil.charting.i.f.a(f2);
    }

    public void setExtraLeftOffset(float f2) {
        this.i = com.github.mikephil.charting.i.f.a(f2);
    }

    public void setExtraRightOffset(float f2) {
        this.g = com.github.mikephil.charting.i.f.a(f2);
    }

    public void setExtraTopOffset(float f2) {
        this.f4916f = com.github.mikephil.charting.i.f.a(f2);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (Build.VERSION.SDK_INT < 11) {
            Log.e("MPAndroidChart", "Cannot enable/disable hardware acceleration for devices below API level 11.");
        } else if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.v = z;
    }

    public void setLogEnabled(boolean z) {
        this.t = z;
    }

    public void setMarkerView(com.github.mikephil.charting.c.e eVar) {
        this.Q = eVar;
    }

    public void setNoDataText(String str) {
        this.f4913c = str;
    }

    public void setNoDataTextDescription(String str) {
        this.f4915e = str;
    }

    public void setOnChartGestureListener(com.github.mikephil.charting.g.c cVar) {
        this.f4914d = cVar;
    }

    public void setOnChartValueSelectedListener(d dVar) {
        this.G = dVar;
    }

    public void setOnTouchListener(b bVar) {
        this.H = bVar;
    }

    public void setRenderer(f fVar) {
        if (fVar != null) {
            this.J = fVar;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.E = z;
    }

    public boolean t() {
        return this.v;
    }

    public boolean u() {
        return (this.O == null || this.O.length <= 0 || this.O[0] == null) ? false : true;
    }

    public boolean v() {
        return this.f4911a;
    }

    public boolean w() {
        return this.t;
    }

    public void x() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void y() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }
}
