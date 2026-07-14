package com.github.mikephil.charting.c;

import android.graphics.Paint;
import com.github.mikephil.charting.d.h;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.github.mikephil.charting.c.a {
    private int A;
    private boolean B;
    private b C;
    private a D;
    protected h l;
    public float[] m;
    public int n;
    public int o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    protected float t;
    protected float u;
    protected float v;
    protected float w;
    public float x;
    public float y;
    public float z;

    public enum a {
        LEFT,
        RIGHT;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public enum b {
        OUTSIDE_CHART,
        INSIDE_CHART;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            int length = bVarArrValuesCustom.length;
            b[] bVarArr = new b[length];
            System.arraycopy(bVarArrValuesCustom, 0, bVarArr, 0, length);
            return bVarArr;
        }
    }

    public g() {
        this.m = new float[0];
        this.A = 6;
        this.B = true;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = 10.0f;
        this.w = 10.0f;
        this.x = BitmapDescriptorFactory.HUE_RED;
        this.y = BitmapDescriptorFactory.HUE_RED;
        this.z = BitmapDescriptorFactory.HUE_RED;
        this.C = b.OUTSIDE_CHART;
        this.D = a.LEFT;
        this.h = BitmapDescriptorFactory.HUE_RED;
    }

    public g(a aVar) {
        this.m = new float[0];
        this.A = 6;
        this.B = true;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = 10.0f;
        this.w = 10.0f;
        this.x = BitmapDescriptorFactory.HUE_RED;
        this.y = BitmapDescriptorFactory.HUE_RED;
        this.z = BitmapDescriptorFactory.HUE_RED;
        this.C = b.OUTSIDE_CHART;
        this.D = aVar;
        this.h = BitmapDescriptorFactory.HUE_RED;
    }

    public float A() {
        return this.u;
    }

    public float B() {
        return this.v;
    }

    public float C() {
        return this.w;
    }

    public String D() {
        String str = "";
        int i = 0;
        while (i < this.m.length) {
            String strA = a(i);
            if (str.length() >= strA.length()) {
                strA = str;
            }
            i++;
            str = strA;
        }
        return str;
    }

    public h E() {
        if (this.l == null) {
            this.l = new com.github.mikephil.charting.d.d(this.o);
        }
        return this.l;
    }

    public boolean F() {
        return q() && g() && s() == b.OUTSIDE_CHART;
    }

    public float a(Paint paint) {
        paint.setTextSize(this.j);
        return com.github.mikephil.charting.i.f.a(paint, D()) + (l() * 2.0f);
    }

    public String a(int i) {
        return (i < 0 || i >= this.m.length) ? "" : E().a(this.m[i], this);
    }

    public float b(Paint paint) {
        paint.setTextSize(this.j);
        return com.github.mikephil.charting.i.f.b(paint, D()) + (com.github.mikephil.charting.i.f.a(2.5f) * 2.0f) + m();
    }

    public a r() {
        return this.D;
    }

    public b s() {
        return this.C;
    }

    public boolean t() {
        return this.B;
    }

    public int u() {
        return this.A;
    }

    public boolean v() {
        return this.s;
    }

    public boolean w() {
        return this.p;
    }

    public boolean x() {
        return this.q;
    }

    public boolean y() {
        return this.r;
    }

    public float z() {
        return this.t;
    }
}
