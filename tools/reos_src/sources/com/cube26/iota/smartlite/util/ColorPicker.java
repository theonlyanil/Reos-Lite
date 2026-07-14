package com.cube26.iota.smartlite.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class ColorPicker extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f3422b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b.a.a.c f3423a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f3424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f3425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f3426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RectF f3427f;
    private RectF g;
    private Path h;
    private Path i;
    private Bitmap j;
    private int k;
    private int l;
    private int m;
    private float[] n;

    public ColorPicker(Context context) {
        super(context);
        this.n = new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
        a();
    }

    public ColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
        a();
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
        a();
    }

    private Bitmap a(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[13];
        float[] fArr = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f};
        for (int i3 = 0; i3 < iArr.length; i3++) {
            fArr[0] = ((i3 * 30) + 180) % 360;
            iArr[i3] = Color.HSVToColor(fArr);
        }
        iArr[12] = iArr[0];
        this.f3424c.setShader(new ComposeShader(new SweepGradient(i / 2, i2 / 2, iArr, (float[]) null), new RadialGradient(i / 2, i2 / 2, this.m, -1, 16777215, Shader.TileMode.CLAMP), PorterDuff.Mode.SRC_OVER));
        new Canvas(bitmapCreateBitmap).drawCircle(i / 2, i2 / 2, this.m, this.f3424c);
        return bitmapCreateBitmap;
    }

    private void a() {
        this.f3423a = b.a.a.c.a();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setARGB(128, 0, 0, 0);
        this.f3426e = new Paint();
        this.f3426e.setStyle(Paint.Style.STROKE);
        this.f3426e.setStrokeWidth(2.0f);
        new Paint();
        this.f3424c = new Paint();
        this.f3424c.setAntiAlias(true);
        this.f3424c.setDither(true);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        this.f3425d = new Paint();
        this.f3425d.setAntiAlias(true);
        this.h = new Path();
        this.i = new Path();
        new Path();
        this.f3427f = new RectF();
        this.g = new RectF();
        new RectF();
    }

    public int getColor() {
        return Color.HSVToColor(this.n);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        canvas.drawBitmap(this.j, width - this.m, height - this.m, (Paint) null);
        this.f3425d.setColor(Color.HSVToColor(this.n));
        canvas.drawPath(this.h, this.f3425d);
        canvas.drawPath(this.i, this.f3425d);
        float radians = (float) Math.toRadians(this.n[0]);
        int i = ((int) ((-Math.cos(radians)) * ((double) this.n[1]) * ((double) this.m))) + width;
        int i2 = ((int) ((-Math.sin(radians)) * ((double) this.n[1]) * ((double) this.m))) + height;
        float f2 = 0.075f * this.m;
        this.f3426e.setColor(Color.HSVToColor(new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f - this.n[2]}));
        double d2 = ((double) (this.n[2] - 0.5f)) * 3.141592653589793d;
        float fCos = (float) Math.cos(d2);
        float fSin = (float) Math.sin(d2);
        canvas.drawLine((this.l * fCos) + width, (this.l * fSin) + height, (this.k * fCos) + width, height + (this.k * fSin), this.f3426e);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        f3422b = iMin;
        setMeasuredDimension(iMin, iMin);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.n = bundle.getFloatArray("color");
        super.onRestoreInstanceState(bundle.getParcelable("super"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putFloatArray("color", this.n);
        bundle.putParcelable("super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = i / 2;
        int i6 = i2 / 2;
        int i7 = (0 * i) / 100;
        int i8 = (0 * i) / 100;
        this.k = (i / 2) - ((0 * i) / 100);
        this.l = this.k - ((0 * i) / 100);
        this.m = this.l;
        this.f3427f.set(i5 - this.k, i6 - this.k, this.k + i5, this.k + i6);
        this.g.set(i5 - this.l, i6 - this.l, i5 + this.l, i6 + this.l);
        this.j = a(this.m * 2, this.m * 2);
        new Matrix().preRotate(270.0f, i / 2, i2 / 2);
        this.h.arcTo(this.f3427f, 270.0f, -180.0f);
        this.h.arcTo(this.g, 90.0f, 180.0f);
        this.i.arcTo(this.f3427f, 270.0f, 180.0f);
        this.i.arcTo(this.g, 90.0f, -180.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = 0;
        try {
            action = motionEvent.getAction();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        switch (action) {
            case 0:
            case 2:
                try {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int width = x - (getWidth() / 2);
                    int height = y - (getHeight() / 2);
                    double dSqrt = Math.sqrt((width * width) + (height * height));
                    if (dSqrt > this.m) {
                        return true;
                    }
                    this.n[0] = (float) (Math.toDegrees(Math.atan2(height, width)) + 180.0d);
                    this.n[1] = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(1.0f, (float) (dSqrt / ((double) this.m))));
                    invalidate();
                    this.f3423a.b(new ColorCodeChangeListener(getColor()));
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return true;
                }
            case 1:
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public void setColor(int i) {
        Color.colorToHSV(i, this.n);
    }
}
