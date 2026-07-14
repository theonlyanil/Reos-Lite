package com.github.mikephil.charting.i;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Matrix f5075a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected RectF f5076b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f5077c = BitmapDescriptorFactory.HUE_RED;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f5078d = BitmapDescriptorFactory.HUE_RED;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f5079e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f5080f = Float.MAX_VALUE;
    private float g = 1.0f;
    private float h = Float.MAX_VALUE;
    private float i = 1.0f;
    private float j = 1.0f;
    private float k = BitmapDescriptorFactory.HUE_RED;
    private float l = BitmapDescriptorFactory.HUE_RED;
    private float m = BitmapDescriptorFactory.HUE_RED;
    private float n = BitmapDescriptorFactory.HUE_RED;

    public float a() {
        return this.f5076b.left;
    }

    public Matrix a(Matrix matrix, View view, boolean z) {
        this.f5075a.set(matrix);
        a(this.f5075a, this.f5076b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.f5075a);
        return matrix;
    }

    public void a(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        this.g = f2;
        a(this.f5075a, this.f5076b);
    }

    public void a(float f2, float f3) {
        float fA = a();
        float fC = c();
        float fB = b();
        float fD = d();
        this.f5078d = f3;
        this.f5077c = f2;
        a(fA, fC, fB, fD);
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f5076b.set(f2, f3, this.f5077c - f4, this.f5078d - f5);
    }

    public void a(Matrix matrix, RectF rectF) {
        float fWidth;
        float fHeight = BitmapDescriptorFactory.HUE_RED;
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[0];
        float f4 = fArr[5];
        float f5 = fArr[4];
        this.i = Math.min(Math.max(this.g, f3), this.h);
        this.j = Math.min(Math.max(this.f5079e, f5), this.f5080f);
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fWidth = 0.0f;
        }
        this.k = Math.min(Math.max(f2, ((-fWidth) * (this.i - 1.0f)) - this.m), this.m);
        this.l = Math.max(Math.min(f4, (fHeight * (this.j - 1.0f)) + this.n), -this.n);
        fArr[2] = this.k;
        fArr[0] = this.i;
        fArr[5] = this.l;
        fArr[4] = this.j;
        matrix.setValues(fArr);
    }

    public float b() {
        return this.f5077c - this.f5076b.right;
    }

    public Matrix b(float f2, float f3, float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.set(this.f5075a);
        matrix.postScale(f2, f3, f4, f5);
        return matrix;
    }

    public void b(float f2) {
        this.h = f2;
        a(this.f5075a, this.f5076b);
    }

    public boolean b(float f2, float f3) {
        return c(f2) && d(f3);
    }

    public float c() {
        return this.f5076b.top;
    }

    public boolean c(float f2) {
        return e(f2) && f(f2);
    }

    public float d() {
        return this.f5078d - this.f5076b.bottom;
    }

    public boolean d(float f2) {
        return g(f2) && h(f2);
    }

    public float e() {
        return this.f5076b.top;
    }

    public boolean e(float f2) {
        return this.f5076b.left <= f2;
    }

    public float f() {
        return this.f5076b.left;
    }

    public boolean f(float f2) {
        return this.f5076b.right >= ((float) ((int) (f2 * 100.0f))) / 100.0f;
    }

    public float g() {
        return this.f5076b.right;
    }

    public boolean g(float f2) {
        return this.f5076b.top <= f2;
    }

    public float h() {
        return this.f5076b.bottom;
    }

    public boolean h(float f2) {
        return this.f5076b.bottom >= ((float) ((int) (f2 * 100.0f))) / 100.0f;
    }

    public float i() {
        return this.f5076b.width();
    }

    public void i(float f2) {
        this.m = f.a(f2);
    }

    public float j() {
        return this.f5076b.height();
    }

    public void j(float f2) {
        this.n = f.a(f2);
    }

    public RectF k() {
        return this.f5076b;
    }

    public PointF l() {
        return new PointF(this.f5076b.centerX(), this.f5076b.centerY());
    }

    public float m() {
        return this.f5078d;
    }

    public float n() {
        return this.f5077c;
    }

    public Matrix o() {
        return this.f5075a;
    }

    public float p() {
        return this.i;
    }

    public float q() {
        return this.j;
    }

    public boolean r() {
        return t() && s();
    }

    public boolean s() {
        return this.j <= this.f5079e && this.f5079e <= 1.0f;
    }

    public boolean t() {
        return this.i <= this.g && this.g <= 1.0f;
    }

    public boolean u() {
        return this.m <= BitmapDescriptorFactory.HUE_RED && this.n <= BitmapDescriptorFactory.HUE_RED;
    }

    public boolean v() {
        return this.i > this.g;
    }

    public boolean w() {
        return this.i < this.h;
    }
}
