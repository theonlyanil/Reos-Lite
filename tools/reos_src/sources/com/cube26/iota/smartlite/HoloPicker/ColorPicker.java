package com.cube26.iota.smartlite.HoloPicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.cube26.iota.smartlite.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class ColorPicker extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f3039a = {-65536, -1555849, -65281, -16776961, -16711681, -16711936, -16711936, -256, -65536};
    private float[] A;
    private boolean B;
    private a C;
    private b D;
    private int E;
    private int F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f3040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f3041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f3042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3044f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final RectF n;
    private final RectF o;
    private boolean p;
    private int q;
    private boolean r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private Paint x;
    private Paint y;
    private Paint z;

    public interface a {
        void a(int i);
    }

    public interface b {
        void a(int i);
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new RectF();
        this.o = new RectF();
        this.p = false;
        this.A = new float[3];
        this.B = true;
        a(attributeSet, i);
    }

    private float a(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return (float) Math.toRadians(-fArr[0]);
    }

    private int a(float f2) {
        float f3 = (float) (((double) f2) / 6.283185307179586d);
        if (f3 < BitmapDescriptorFactory.HUE_RED) {
            f3 += 1.0f;
        }
        if (f3 <= BitmapDescriptorFactory.HUE_RED) {
            return f3039a[0];
        }
        if (f3 >= 1.0f) {
            return f3039a[f3039a.length - 1];
        }
        float length = f3 * (f3039a.length - 1);
        int i = (int) length;
        float f4 = length - i;
        int i2 = f3039a[i];
        int i3 = f3039a[i + 1];
        int iA = a(Color.alpha(i2), Color.alpha(i3), f4);
        int iA2 = a(Color.red(i2), Color.red(i3), f4);
        int iA3 = a(Color.green(i2), Color.green(i3), f4);
        int iA4 = a(Color.blue(i2), Color.blue(i3), f4);
        Color.argb(iA, iA2, iA3, iA4);
        return Color.argb(iA, iA2, iA3, iA4);
    }

    private int a(int i, int i2, float f2) {
        return Math.round((i2 - i) * f2) + i;
    }

    private void a(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.cube26.iota.smartlite.a.C0063a.ColorPicker, i, 0);
        Resources resources = getContext().getResources();
        this.f3043e = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(R.dimen.color_wheel_thickness));
        this.f3044f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(R.dimen.color_wheel_radius));
        this.g = this.f3044f;
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(R.dimen.color_center_radius));
        this.i = this.h;
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.color_center_halo_radius));
        this.k = this.j;
        this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(R.dimen.color_pointer_radius));
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.color_pointer_halo_radius));
        typedArrayObtainStyledAttributes.recycle();
        this.w = -1.5707964f;
        SweepGradient sweepGradient = new SweepGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f3039a, (float[]) null);
        this.f3040b = new Paint(1);
        this.f3040b.setShader(sweepGradient);
        this.f3040b.setStyle(Paint.Style.STROKE);
        this.f3040b.setStrokeWidth(this.f3043e);
        this.f3041c = new Paint(1);
        this.f3041c.setColor(-16777216);
        this.f3041c.setAlpha(80);
        this.f3042d = new Paint(1);
        this.f3042d.setColor(a(this.w));
        this.y = new Paint(1);
        this.y.setColor(a(this.w));
        this.y.setStyle(Paint.Style.FILL);
        this.x = new Paint(1);
        this.x.setColor(a(this.w));
        this.x.setStyle(Paint.Style.FILL);
        this.z = new Paint(1);
        this.z.setColor(-16777216);
        this.z.setAlpha(0);
        this.s = a(this.w);
        this.q = a(this.w);
        this.r = true;
    }

    private float[] b(float f2) {
        return new float[]{(float) (((double) this.f3044f) * Math.cos(f2)), (float) (((double) this.f3044f) * Math.sin(f2))};
    }

    public int getColor() {
        return this.s;
    }

    public int getOldCenterColor() {
        return this.q;
    }

    public a getOnColorChangedListener() {
        return this.C;
    }

    public b getOnColorSelectedListener() {
        return this.D;
    }

    public boolean getShowOldCenterColor() {
        return this.r;
    }

    public boolean getTouchAnywhereOnColorWheel() {
        return this.B;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.translate(this.t, this.t);
        canvas.drawOval(this.n, this.f3040b);
        float[] fArrB = b(this.w);
        canvas.drawCircle(fArrB[0], fArrB[1], this.m, this.f3041c);
        canvas.drawCircle(fArrB[0], fArrB[1], this.l, this.f3042d);
        canvas.drawCircle(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.j, this.z);
        if (!this.r) {
            canvas.drawArc(this.o, BitmapDescriptorFactory.HUE_RED, 360.0f, true, this.y);
        } else {
            canvas.drawArc(this.o, 90.0f, 180.0f, true, this.x);
            canvas.drawArc(this.o, 270.0f, 180.0f, true, this.y);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = (this.g + this.m) * 2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(i3, size) : i3;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(i3, size2) : i3;
        }
        int iMin = Math.min(size, size2);
        setMeasuredDimension(iMin, iMin);
        this.t = iMin * 0.5f;
        this.f3044f = ((iMin / 2) - this.f3043e) - this.m;
        this.n.set(-this.f3044f, -this.f3044f, this.f3044f, this.f3044f);
        this.h = (int) (this.i * (this.f3044f / this.g));
        this.j = (int) (this.k * (this.f3044f / this.g));
        this.o.set(-this.h, -this.h, this.h, this.h);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("parent"));
        this.w = bundle.getFloat("angle");
        setOldCenterColor(bundle.getInt("color"));
        this.r = bundle.getBoolean("showColor");
        int iA = a(this.w);
        this.f3042d.setColor(iA);
        setNewCenterColor(iA);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("parent", parcelableOnSaveInstanceState);
        bundle.putFloat("angle", this.w);
        bundle.putInt("color", this.q);
        bundle.putBoolean("showColor", this.r);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x = motionEvent.getX() - this.t;
        float y = motionEvent.getY() - this.t;
        switch (motionEvent.getAction()) {
            case 0:
                float[] fArrB = b(this.w);
                if (x >= fArrB[0] - this.m && x <= fArrB[0] + this.m && y >= fArrB[1] - this.m && y <= fArrB[1] + this.m) {
                    this.u = x - fArrB[0];
                    this.v = y - fArrB[1];
                    this.p = true;
                    invalidate();
                } else if (x >= (-this.h) && x <= this.h && y >= (-this.h) && y <= this.h && this.r) {
                    this.z.setAlpha(80);
                    setColor(getOldCenterColor());
                    invalidate();
                } else {
                    if (Math.sqrt((x * x) + (y * y)) > this.f3044f + this.m || Math.sqrt((x * x) + (y * y)) < this.f3044f - this.m || !this.B) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                    this.p = true;
                    invalidate();
                }
                break;
            case 1:
                this.p = false;
                this.z.setAlpha(0);
                if (this.D != null && this.s != this.F) {
                    this.D.a(this.s);
                    this.F = this.s;
                }
                invalidate();
                break;
            case 2:
                if (!this.p) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                this.w = (float) Math.atan2(y - this.v, x - this.u);
                this.f3042d.setColor(a(this.w));
                int iA = a(this.w);
                this.s = iA;
                setNewCenterColor(iA);
                invalidate();
                break;
                break;
            case 3:
                if (this.D != null && this.s != this.F) {
                    this.D.a(this.s);
                    this.F = this.s;
                }
                break;
        }
        return true;
    }

    public void setColor(int i) {
        this.w = a(i);
        this.f3042d.setColor(a(this.w));
        setNewCenterColor(i);
    }

    public void setNewCenterColor(int i) {
        this.s = i;
        this.y.setColor(i);
        if (this.q == 0) {
            this.q = i;
            this.x.setColor(i);
        }
        if (this.C != null && i != this.E) {
            this.C.a(i);
            this.E = i;
        }
        invalidate();
    }

    public void setOldCenterColor(int i) {
        this.q = i;
        this.x.setColor(i);
        invalidate();
    }

    public void setOnColorChangedListener(a aVar) {
        this.C = aVar;
    }

    public void setOnColorSelectedListener(b bVar) {
        this.D = bVar;
    }

    public void setShowOldCenterColor(boolean z) {
        this.r = z;
        invalidate();
    }

    public void setTouchAnywhereOnColorWheelEnabled(boolean z) {
        this.B = z;
    }
}
