package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.c.f;
import com.github.mikephil.charting.c.g;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.c;
import com.github.mikephil.charting.data.d;
import com.github.mikephil.charting.f.b;
import com.github.mikephil.charting.g.a;
import com.github.mikephil.charting.g.e;
import com.github.mikephil.charting.h.o;
import com.github.mikephil.charting.h.s;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends c<? extends d<? extends Entry>>> extends Chart<T> implements b {
    private boolean S;
    private Integer T;
    private Integer U;
    private boolean V;
    private boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f4900a;
    private boolean aa;
    private long ab;
    private long ac;
    private boolean ad;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f4901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f4902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f4903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f4904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Paint f4905f;
    protected Paint g;
    protected boolean h;
    protected boolean i;
    protected float j;
    protected e k;
    protected g l;
    protected g m;
    protected f n;
    protected s o;
    protected s p;
    protected com.github.mikephil.charting.i.d q;
    protected com.github.mikephil.charting.i.d r;
    protected o s;

    public BarLineChartBase(Context context) {
        super(context);
        this.f4900a = 100;
        this.S = false;
        this.T = null;
        this.U = null;
        this.f4901b = false;
        this.f4902c = true;
        this.f4903d = true;
        this.V = true;
        this.W = true;
        this.aa = true;
        this.f4904e = false;
        this.h = true;
        this.i = false;
        this.j = 10.0f;
        this.ab = 0L;
        this.ac = 0L;
        this.ad = false;
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4900a = 100;
        this.S = false;
        this.T = null;
        this.U = null;
        this.f4901b = false;
        this.f4902c = true;
        this.f4903d = true;
        this.V = true;
        this.W = true;
        this.aa = true;
        this.f4904e = false;
        this.h = true;
        this.i = false;
        this.j = 10.0f;
        this.ab = 0L;
        this.ac = 0L;
        this.ad = false;
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4900a = 100;
        this.S = false;
        this.T = null;
        this.U = null;
        this.f4901b = false;
        this.f4902c = true;
        this.f4903d = true;
        this.V = true;
        this.W = true;
        this.aa = true;
        this.f4904e = false;
        this.h = true;
        this.i = false;
        this.j = 10.0f;
        this.ab = 0L;
        this.ac = 0L;
        this.ad = false;
    }

    public com.github.mikephil.charting.e.d a(float f2, float f3) {
        if (!this.A && this.u != 0) {
            return this.K.a(f2, f3);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.f.b
    public com.github.mikephil.charting.i.d a(g.a aVar) {
        return aVar == g.a.LEFT ? this.q : this.r;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void a() {
        super.a();
        this.l = new g(g.a.LEFT);
        this.m = new g(g.a.RIGHT);
        this.n = new f();
        this.q = new com.github.mikephil.charting.i.d(this.L);
        this.r = new com.github.mikephil.charting.i.d(this.L);
        this.o = new s(this.L, this.l, this.q);
        this.p = new s(this.L, this.m, this.r);
        this.s = new o(this.L, this.n, this.q);
        this.K = new com.github.mikephil.charting.e.b(this);
        this.H = new a(this, this.L.o());
        this.f4905f = new Paint();
        this.f4905f.setStyle(Paint.Style.FILL);
        this.f4905f.setColor(Color.rgb(240, 240, 240));
        this.g = new Paint();
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setColor(-16777216);
        this.g.setStrokeWidth(com.github.mikephil.charting.i.f.a(1.0f));
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.L.a(this.L.b(f2, f3, f4, -f5), this, true);
        i();
        postInvalidate();
    }

    protected void a(Canvas canvas) {
        if (this.h) {
            canvas.drawRect(this.L.k(), this.f4905f);
        }
        if (this.i) {
            canvas.drawRect(this.L.k(), this.g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] a(Entry entry, com.github.mikephil.charting.e.d dVar) {
        float fA;
        int iA = dVar.a();
        float f2 = entry.f();
        float fB = entry.b();
        if (this instanceof BarChart) {
            float fA2 = ((com.github.mikephil.charting.data.a) this.u).a();
            int iF = ((c) this.u).f();
            int iF2 = entry.f();
            if (this instanceof HorizontalBarChart) {
                float f3 = (fA2 / 2.0f) + ((iF - 1) * iF2) + iF2 + iA + (iF2 * fA2);
                f2 = (((BarEntry) entry).a() != null ? dVar.d().f5000b : entry.b()) * this.M.a();
                fA = f3;
            } else {
                f2 = (fA2 / 2.0f) + ((iF - 1) * iF2) + iF2 + iA + (iF2 * fA2);
                fA = (((BarEntry) entry).a() != null ? dVar.d().f5000b : entry.b()) * this.M.a();
            }
        } else {
            fA = fB * this.M.a();
        }
        float[] fArr = {f2, fA};
        a(((d) ((c) this.u).a(iA)).s()).a(fArr);
        return fArr;
    }

    public g b(g.a aVar) {
        return aVar == g.a.LEFT ? this.l : this.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d<? extends Entry> b(float f2, float f3) {
        com.github.mikephil.charting.e.d dVarA = a(f2, f3);
        if (dVarA != null) {
            return (d) ((c) this.u).a(dVarA.a());
        }
        return null;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void b() {
        float f2;
        float f3;
        if (this.S) {
            ((c) this.u).a(getLowestVisibleXIndex(), getHighestVisibleXIndex());
        }
        float fA = ((c) this.u).a(g.a.LEFT);
        float fB = ((c) this.u).b(g.a.LEFT);
        float fA2 = ((c) this.u).a(g.a.RIGHT);
        float fB2 = ((c) this.u).b(g.a.RIGHT);
        float fAbs = Math.abs(fB - (this.l.y() ? 0.0f : fA));
        float fAbs2 = Math.abs(fB2 - (this.m.y() ? 0.0f : fA2));
        if (fAbs == BitmapDescriptorFactory.HUE_RED) {
            float f4 = fB + 1.0f;
            if (this.l.y()) {
                fB = f4;
                f2 = fA;
            } else {
                fB = f4;
                f2 = fA - 1.0f;
            }
        } else {
            f2 = fA;
        }
        if (fAbs2 == BitmapDescriptorFactory.HUE_RED) {
            float f5 = fB2 + 1.0f;
            if (this.m.y()) {
                f3 = f5;
            } else {
                fA2 -= 1.0f;
                f3 = f5;
            }
        } else {
            f3 = fB2;
        }
        float fB3 = this.l.B() * (fAbs / 100.0f);
        float fB4 = this.m.B() * (fAbs2 / 100.0f);
        float fC = this.l.C() * (fAbs / 100.0f);
        float fC2 = this.m.C() * (fAbs2 / 100.0f);
        this.D = ((c) this.u).l().size() - 1;
        this.B = Math.abs(this.D - this.C);
        if (!this.l.y()) {
            this.l.y = !Float.isNaN(this.l.z()) ? this.l.z() : f2 - fC;
            this.l.x = !Float.isNaN(this.l.A()) ? this.l.A() : fB + fB3;
        } else if (f2 < BitmapDescriptorFactory.HUE_RED && fB < BitmapDescriptorFactory.HUE_RED) {
            this.l.y = Math.min(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.z()) ? this.l.z() : f2 - fC);
            this.l.x = BitmapDescriptorFactory.HUE_RED;
        } else if (f2 >= 0.0d) {
            this.l.y = BitmapDescriptorFactory.HUE_RED;
            this.l.x = Math.max(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.A()) ? this.l.A() : fB + fB3);
        } else {
            this.l.y = Math.min(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.z()) ? this.l.z() : f2 - fC);
            this.l.x = Math.max(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.l.A()) ? this.l.A() : fB + fB3);
        }
        if (!this.m.y()) {
            this.m.y = !Float.isNaN(this.m.z()) ? this.m.z() : fA2 - fC2;
            this.m.x = !Float.isNaN(this.m.A()) ? this.m.A() : f3 + fB4;
        } else if (fA2 < BitmapDescriptorFactory.HUE_RED && f3 < BitmapDescriptorFactory.HUE_RED) {
            this.m.y = Math.min(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.m.z()) ? this.m.z() : fA2 - fC2);
            this.m.x = BitmapDescriptorFactory.HUE_RED;
        } else if (fA2 >= BitmapDescriptorFactory.HUE_RED) {
            this.m.y = BitmapDescriptorFactory.HUE_RED;
            this.m.x = Math.max(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.m.A()) ? this.m.A() : f3 + fB4);
        } else {
            this.m.y = Math.min(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.m.z()) ? this.m.z() : fA2 - fC2);
            this.m.x = Math.max(BitmapDescriptorFactory.HUE_RED, !Float.isNaN(this.m.A()) ? this.m.A() : f3 + fB4);
        }
        this.l.z = Math.abs(this.l.x - this.l.y);
        this.m.z = Math.abs(this.m.x - this.m.y);
    }

    public void b(final float f2, final float f3, final float f4, final float f5) {
        this.ad = true;
        post(new Runnable() { // from class: com.github.mikephil.charting.charts.BarLineChartBase.1
            @Override // java.lang.Runnable
            public void run() {
                BarLineChartBase.this.L.a(f2, f3, f4, f5);
                BarLineChartBase.this.g();
                BarLineChartBase.this.f();
            }
        });
    }

    @Override // com.github.mikephil.charting.f.b
    public boolean c(g.a aVar) {
        return b(aVar).x();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.H instanceof a) {
            ((a) this.H).b();
        }
    }

    protected void f() {
        if (this.t) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.C + ", xmax: " + this.D + ", xdelta: " + this.B);
        }
        this.r.a(this.C, this.B, this.m.z, this.m.y);
        this.q.a(this.C, this.B, this.l.z, this.l.y);
    }

    protected void g() {
        this.r.a(this.m.x());
        this.q.a(this.l.x());
    }

    public g getAxisLeft() {
        return this.l;
    }

    public g getAxisRight() {
        return this.m;
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.f.b
    public /* bridge */ /* synthetic */ c getData() {
        return (c) getData();
    }

    public e getDrawListener() {
        return this.k;
    }

    public int getHighestVisibleXIndex() {
        float[] fArr = {this.L.g(), this.L.h()};
        a(g.a.LEFT).b(fArr);
        return fArr[0] >= ((float) ((c) this.u).n()) ? ((c) this.u).n() - 1 : (int) fArr[0];
    }

    public int getLowestVisibleXIndex() {
        float[] fArr = {this.L.f(), this.L.h()};
        a(g.a.LEFT).b(fArr);
        if (fArr[0] <= BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        return (int) (fArr[0] + 1.0f);
    }

    @Override // com.github.mikephil.charting.f.b
    public int getMaxVisibleCount() {
        return this.f4900a;
    }

    public float getMinOffset() {
        return this.j;
    }

    public s getRendererLeftYAxis() {
        return this.o;
    }

    public s getRendererRightYAxis() {
        return this.p;
    }

    public o getRendererXAxis() {
        return this.s;
    }

    @Override // android.view.View
    public float getScaleX() {
        if (this.L == null) {
            return 1.0f;
        }
        return this.L.p();
    }

    @Override // android.view.View
    public float getScaleY() {
        if (this.L == null) {
            return 1.0f;
        }
        return this.L.q();
    }

    public f getXAxis() {
        return this.n;
    }

    @Override // com.github.mikephil.charting.f.e
    public float getYChartMax() {
        return Math.max(this.l.x, this.m.x);
    }

    @Override // com.github.mikephil.charting.f.e
    public float getYChartMin() {
        return Math.min(this.l.y, this.m.y);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void h() {
        if (this.A) {
            if (this.t) {
                Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.t) {
            Log.i("MPAndroidChart", "Preparing...");
        }
        if (this.J != null) {
            this.J.a();
        }
        b();
        this.o.a(this.l.y, this.l.x);
        this.p.a(this.m.y, this.m.x);
        this.s.a(((c) this.u).i(), ((c) this.u).l());
        if (this.F != null) {
            this.I.a(this.u);
        }
        i();
    }

    /* JADX WARN: Code duplicated, block: B:56:0x01f2  */
    @Override // com.github.mikephil.charting.charts.Chart
    public void i() {
        float fMin;
        float fA;
        float fA2;
        float fMin2 = BitmapDescriptorFactory.HUE_RED;
        if (!this.ad) {
            if (this.F == null || !this.F.q()) {
                fMin = 0.0f;
                fA = 0.0f;
                fA2 = 0.0f;
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART_CENTER) {
                fA = Math.min(this.F.f4860a, this.L.n() * this.F.t()) + (this.F.l() * 2.0f) + BitmapDescriptorFactory.HUE_RED;
                fA2 = 0.0f;
                fMin = 0.0f;
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART_CENTER) {
                fA = 0.0f;
                fA2 = Math.min(this.F.f4860a, this.L.n() * this.F.t()) + (this.F.l() * 2.0f) + BitmapDescriptorFactory.HUE_RED;
                fMin = 0.0f;
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_LEFT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_RIGHT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_CENTER) {
                fA = 0.0f;
                fA2 = 0.0f;
                fMin = 0.0f;
                fMin2 = Math.min(this.F.f4862c + this.F.f4861b, this.L.m() * this.F.t()) + BitmapDescriptorFactory.HUE_RED;
            } else if (this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_LEFT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_RIGHT || this.F.f() == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_CENTER) {
                fMin = Math.min(this.F.f4862c + this.F.f4861b, this.L.m() * this.F.t()) + BitmapDescriptorFactory.HUE_RED;
                fA = 0.0f;
                fA2 = 0.0f;
            } else {
                fMin = 0.0f;
                fA = 0.0f;
                fA2 = 0.0f;
            }
            if (this.l.F()) {
                fA2 += this.l.a(this.o.a());
            }
            if (this.m.F()) {
                fA += this.m.a(this.p.a());
            }
            if (this.n.q() && this.n.g()) {
                float fM = this.n.p + this.n.m();
                if (this.n.r() == f.a.BOTTOM) {
                    fMin2 += fM;
                } else if (this.n.r() == f.a.TOP) {
                    fMin += fM;
                } else if (this.n.r() == f.a.BOTH_SIDED) {
                    fMin2 += fM;
                    fMin += fM;
                }
            }
            float extraTopOffset = fMin + getExtraTopOffset();
            float extraRightOffset = fA + getExtraRightOffset();
            float extraBottomOffset = fMin2 + getExtraBottomOffset();
            float extraLeftOffset = fA2 + getExtraLeftOffset();
            float fA3 = com.github.mikephil.charting.i.f.a(this.j);
            this.L.a(Math.max(fA3, extraLeftOffset), Math.max(fA3, extraTopOffset), Math.max(fA3, extraRightOffset), Math.max(fA3, extraBottomOffset));
            if (this.t) {
                Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                Log.i("MPAndroidChart", "Content: " + this.L.k().toString());
            }
        }
        g();
        f();
    }

    protected void j() {
        if (this.n == null || !this.n.q()) {
            return;
        }
        if (!this.n.t()) {
            float[] fArr = new float[9];
            this.L.o().getValues(fArr);
            this.n.r = (int) Math.ceil((((c) this.u).n() * this.n.o) / (fArr[0] * this.L.i()));
        }
        if (this.t) {
            Log.i("MPAndroidChart", "X-Axis modulus: " + this.n.r + ", x-axis label width: " + this.n.m + ", x-axis label rotated width: " + this.n.o + ", content width: " + this.L.i());
        }
        if (this.n.r < 1) {
            this.n.r = 1;
        }
    }

    public boolean k() {
        return this.f4903d;
    }

    public boolean l() {
        return this.V;
    }

    public boolean m() {
        return this.W;
    }

    public boolean n() {
        return this.aa;
    }

    public boolean o() {
        return this.f4902c;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        j();
        this.s.a(this, this.n.r);
        this.J.a(this, this.n.r);
        a(canvas);
        if (this.l.q()) {
            this.o.a(this.l.y, this.l.x);
        }
        if (this.m.q()) {
            this.p.a(this.m.y, this.m.x);
        }
        this.s.b(canvas);
        this.o.b(canvas);
        this.p.b(canvas);
        if (this.S) {
            int lowestVisibleXIndex = getLowestVisibleXIndex();
            int highestVisibleXIndex = getHighestVisibleXIndex();
            if (this.T == null || this.T.intValue() != lowestVisibleXIndex || this.U == null || this.U.intValue() != highestVisibleXIndex) {
                b();
                i();
                this.T = Integer.valueOf(lowestVisibleXIndex);
                this.U = Integer.valueOf(highestVisibleXIndex);
            }
        }
        int iSave = canvas.save();
        canvas.clipRect(this.L.k());
        this.s.c(canvas);
        this.o.c(canvas);
        this.p.c(canvas);
        if (this.n.j()) {
            this.s.d(canvas);
        }
        if (this.l.j()) {
            this.o.d(canvas);
        }
        if (this.m.j()) {
            this.p.d(canvas);
        }
        this.J.a(canvas);
        if (!this.n.j()) {
            this.s.d(canvas);
        }
        if (!this.l.j()) {
            this.o.d(canvas);
        }
        if (!this.m.j()) {
            this.p.d(canvas);
        }
        if (u()) {
            this.J.a(canvas, this.O);
        }
        canvas.restoreToCount(iSave);
        this.J.c(canvas);
        this.s.a(canvas);
        this.o.a(canvas);
        this.p.a(canvas);
        this.J.b(canvas);
        this.I.a(canvas);
        c(canvas);
        b(canvas);
        if (this.t) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            this.ab += jCurrentTimeMillis2;
            this.ac++;
            Log.i("MPAndroidChart", "Drawtime: " + jCurrentTimeMillis2 + " ms, average: " + (this.ab / this.ac) + " ms, cycles: " + this.ac);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.H == null || this.A || !this.E) {
            return false;
        }
        return this.H.onTouch(this, motionEvent);
    }

    public boolean p() {
        return this.L.r();
    }

    public boolean q() {
        return this.f4901b;
    }

    public boolean r() {
        return this.L.u();
    }

    public boolean s() {
        return this.l.x() || this.m.x();
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.S = z;
    }

    public void setBorderColor(int i) {
        this.g.setColor(i);
    }

    public void setBorderWidth(float f2) {
        this.g.setStrokeWidth(com.github.mikephil.charting.i.f.a(f2));
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.f4902c = z;
    }

    public void setDragEnabled(boolean z) {
        this.V = z;
    }

    public void setDragOffsetX(float f2) {
        this.L.i(f2);
    }

    public void setDragOffsetY(float f2) {
        this.L.j(f2);
    }

    public void setDrawBorders(boolean z) {
        this.i = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.h = z;
    }

    public void setGridBackgroundColor(int i) {
        this.f4905f.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.f4903d = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.f4900a = i;
    }

    public void setMinOffset(float f2) {
        this.j = f2;
    }

    public void setOnDrawListener(e eVar) {
        this.k = eVar;
    }

    public void setPinchZoom(boolean z) {
        this.f4901b = z;
    }

    public void setRendererLeftYAxis(s sVar) {
        this.o = sVar;
    }

    public void setRendererRightYAxis(s sVar) {
        this.p = sVar;
    }

    public void setScaleEnabled(boolean z) {
        this.W = z;
        this.aa = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.W = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.aa = z;
    }

    public void setVisibleXRangeMaximum(float f2) {
        this.L.a(this.B / f2);
    }

    public void setVisibleXRangeMinimum(float f2) {
        this.L.b(this.B / f2);
    }

    public void setXAxisRenderer(o oVar) {
        this.s = oVar;
    }
}
