package com.appyvet.rangebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class RangeBar extends View {
    private int A;
    private boolean B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private float K;
    private float L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2817f;
    private int g;
    private int h;
    private float i;
    private int j;
    private float k;
    private int l;
    private float m;
    private int n;
    private float o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private c t;
    private c u;
    private com.appyvet.rangebar.a v;
    private b w;
    private a x;
    private HashMap<Float, String> y;
    private int z;

    public interface a {
        void a(RangeBar rangeBar, int i, int i2, String str, String str2);
    }

    public RangeBar(Context context) {
        super(context);
        this.f2812a = 1.0f;
        this.f2813b = BitmapDescriptorFactory.HUE_RED;
        this.f2814c = 5.0f;
        this.f2815d = 1.0f;
        this.f2816e = 2.0f;
        this.f2817f = -3355444;
        this.g = -12627531;
        this.h = -1;
        this.i = 4.0f;
        this.j = -12627531;
        this.k = 14.0f;
        this.l = -16777216;
        this.m = 14.0f;
        this.n = -12627531;
        this.o = 5.0f;
        this.p = true;
        this.q = 500;
        this.r = 150;
        this.s = ((int) ((this.f2814c - this.f2813b) / this.f2815d)) + 1;
        this.B = true;
        this.C = 16.0f;
        this.D = 24.0f;
    }

    public RangeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2812a = 1.0f;
        this.f2813b = BitmapDescriptorFactory.HUE_RED;
        this.f2814c = 5.0f;
        this.f2815d = 1.0f;
        this.f2816e = 2.0f;
        this.f2817f = -3355444;
        this.g = -12627531;
        this.h = -1;
        this.i = 4.0f;
        this.j = -12627531;
        this.k = 14.0f;
        this.l = -16777216;
        this.m = 14.0f;
        this.n = -12627531;
        this.o = 5.0f;
        this.p = true;
        this.q = 500;
        this.r = 150;
        this.s = ((int) ((this.f2814c - this.f2813b) / this.f2815d)) + 1;
        this.B = true;
        this.C = 16.0f;
        this.D = 24.0f;
        a(context, attributeSet);
    }

    public RangeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2812a = 1.0f;
        this.f2813b = BitmapDescriptorFactory.HUE_RED;
        this.f2814c = 5.0f;
        this.f2815d = 1.0f;
        this.f2816e = 2.0f;
        this.f2817f = -3355444;
        this.g = -12627531;
        this.h = -1;
        this.i = 4.0f;
        this.j = -12627531;
        this.k = 14.0f;
        this.l = -16777216;
        this.m = 14.0f;
        this.n = -12627531;
        this.o = 5.0f;
        this.p = true;
        this.q = 500;
        this.r = 150;
        this.s = ((int) ((this.f2814c - this.f2813b) / this.f2815d)) + 1;
        this.B = true;
        this.C = 16.0f;
        this.D = 24.0f;
        a(context, attributeSet);
    }

    private void a() {
        this.v = new com.appyvet.rangebar.a(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.s, this.f2812a, this.l, this.f2816e, this.f2817f);
        invalidate();
    }

    private void a(float f2) {
        if (this.B && this.t.isPressed()) {
            a(this.t, f2);
        } else if (this.u.isPressed()) {
            a(this.u, f2);
        }
        if (this.B && this.t.getX() > this.u.getX()) {
            c cVar = this.t;
            this.t = this.u;
            this.u = cVar;
        }
        int iB = this.B ? this.v.b(this.t) : 0;
        int iB2 = this.v.b(this.u);
        if (iB == this.z && iB2 == this.A) {
            return;
        }
        this.z = iB;
        this.A = iB2;
        if (this.B) {
            this.t.a(b(this.z));
        }
        this.u.a(b(this.A));
        if (this.x != null) {
            this.x.a(this, this.z, this.A, b(this.z), b(this.A));
        }
    }

    private void a(float f2, float f3) {
        if (!this.B) {
            if (this.u.b(f2, f3)) {
                a(this.u);
            }
        } else if (!this.u.isPressed() && this.t.b(f2, f3)) {
            a(this.t);
        } else {
            if (this.t.isPressed() || !this.u.b(f2, f3)) {
                return;
            }
            a(this.u);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (this.y == null) {
            this.y = new HashMap<>();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.b.RangeBar, 0, 0);
        try {
            float f2 = typedArrayObtainStyledAttributes.getFloat(d.b.RangeBar_tickStart, BitmapDescriptorFactory.HUE_RED);
            float f3 = typedArrayObtainStyledAttributes.getFloat(d.b.RangeBar_tickEnd, 5.0f);
            float f4 = typedArrayObtainStyledAttributes.getFloat(d.b.RangeBar_tickInterval, 1.0f);
            int i = ((int) ((f3 - f2) / f4)) + 1;
            if (a(i)) {
                this.s = i;
                this.f2813b = f2;
                this.f2814c = f3;
                this.f2815d = f4;
                this.z = 0;
                this.A = this.s - 1;
                if (this.x != null) {
                    this.x.a(this, this.z, this.A, b(this.z), b(this.A));
                }
            } else {
                Log.e("RangeBar", "tickCount less than 2; invalid tickCount. XML input ignored.");
            }
            this.f2812a = typedArrayObtainStyledAttributes.getDimension(d.b.RangeBar_tickHeight, 1.0f);
            this.f2816e = typedArrayObtainStyledAttributes.getDimension(d.b.RangeBar_barWeight, 2.0f);
            this.f2817f = typedArrayObtainStyledAttributes.getColor(d.b.RangeBar_barColor, -3355444);
            this.h = typedArrayObtainStyledAttributes.getColor(d.b.RangeBar_textColor, -1);
            this.g = typedArrayObtainStyledAttributes.getColor(d.b.RangeBar_pinColor, -12627531);
            this.F = this.f2817f;
            this.o = TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(d.b.RangeBar_selectorSize, 5.0f), getResources().getDisplayMetrics());
            this.n = typedArrayObtainStyledAttributes.getColor(d.b.RangeBar_selectorColor, -12627531);
            this.H = this.n;
            this.l = typedArrayObtainStyledAttributes.getColor(d.b.RangeBar_tickColor, -16777216);
            this.G = this.l;
            this.i = typedArrayObtainStyledAttributes.getDimension(d.b.RangeBar_connectingLineWeight, 4.0f);
            this.j = typedArrayObtainStyledAttributes.getColor(d.b.RangeBar_connectingLineColor, -12627531);
            this.E = this.j;
            this.m = TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(d.b.RangeBar_pinRadius, 14.0f), getResources().getDisplayMetrics());
            this.C = TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(d.b.RangeBar_pinPadding, 16.0f), getResources().getDisplayMetrics());
            this.D = TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(d.b.RangeBar_barPaddingBottom, 24.0f), getResources().getDisplayMetrics());
            this.B = typedArrayObtainStyledAttributes.getBoolean(d.b.RangeBar_rangeBar, true);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void a(final c cVar) {
        if (this.p) {
            this.p = false;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, this.m);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.appyvet.rangebar.RangeBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RangeBar.this.k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cVar.a(RangeBar.this.k, RangeBar.this.C * valueAnimator.getAnimatedFraction());
                RangeBar.this.invalidate();
            }
        });
        valueAnimatorOfFloat.start();
        cVar.a();
    }

    private void a(c cVar, float f2) {
        if (f2 < this.v.a() || f2 > this.v.b()) {
            return;
        }
        cVar.setX(f2);
        invalidate();
    }

    private boolean a(int i) {
        return i > 1;
    }

    private String b(int i) {
        float f2 = i == this.s + (-1) ? this.f2814c : (i * this.f2815d) + this.f2813b;
        String str = this.y.get(Float.valueOf(f2));
        if (str == null) {
            return ((double) f2) == Math.ceil((double) f2) ? String.valueOf((int) f2) : String.valueOf(f2);
        }
        return str;
    }

    private void b() {
        this.w = new b(getContext(), getYPos(), this.i, this.j);
        invalidate();
    }

    private void b(float f2, float f3) {
        if (this.B && this.t.isPressed()) {
            b(this.t);
            return;
        }
        if (this.u.isPressed()) {
            b(this.u);
            return;
        }
        if ((this.B ? Math.abs(this.t.getX() - f2) : BitmapDescriptorFactory.HUE_RED) >= Math.abs(this.u.getX() - f2)) {
            this.u.setX(f2);
            b(this.u);
        } else if (this.B) {
            this.t.setX(f2);
            b(this.t);
        }
        int iB = this.B ? this.v.b(this.t) : 0;
        int iB2 = this.v.b(this.u);
        if (iB == this.z && iB2 == this.A) {
            return;
        }
        this.z = iB;
        this.A = iB2;
        if (this.x != null) {
            this.x.a(this, this.z, this.A, b(this.z), b(this.A));
        }
    }

    private void b(final c cVar) {
        cVar.setX(this.v.a(cVar));
        cVar.a(b(this.v.b(cVar)));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.m, BitmapDescriptorFactory.HUE_RED);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.appyvet.rangebar.RangeBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RangeBar.this.k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cVar.a(RangeBar.this.k, RangeBar.this.C - (RangeBar.this.C * valueAnimator.getAnimatedFraction()));
                RangeBar.this.invalidate();
            }
        });
        valueAnimatorOfFloat.start();
        cVar.b();
    }

    private boolean b(int i, int i2) {
        return i < 0 || i >= this.s || i2 < 0 || i2 >= this.s;
    }

    private void c() {
        Context context = getContext();
        float yPos = getYPos();
        if (this.B) {
            this.t = new c(context);
            this.t.a(context, yPos, BitmapDescriptorFactory.HUE_RED, this.g, this.h, this.o, this.n);
        }
        this.u = new c(context);
        this.u.a(context, yPos, BitmapDescriptorFactory.HUE_RED, this.g, this.h, this.o, this.n);
        float marginLeft = getMarginLeft();
        float barLength = getBarLength();
        if (this.B) {
            this.t.setX(((this.z / (this.s - 1)) * barLength) + marginLeft);
            this.t.a(b(this.z));
        }
        this.u.setX(marginLeft + (barLength * (this.A / (this.s - 1))));
        this.u.a(b(this.A));
        invalidate();
    }

    private float getBarLength() {
        return getWidth() - (2.0f * getMarginLeft());
    }

    private float getMarginLeft() {
        return this.m;
    }

    private float getYPos() {
        return getHeight() - this.D;
    }

    public void a(int i, int i2) {
        if (b(i, i2)) {
            Log.e("RangeBar", "Pin index left " + i + ", or right " + i2 + " is out of bounds. Check that it is greater than the minimum (" + this.f2813b + ") and less than the maximum value (" + this.f2814c + ")");
            throw new IllegalArgumentException("Pin index left " + i + ", or right " + i2 + " is out of bounds. Check that it is greater than the minimum (" + this.f2813b + ") and less than the maximum value (" + this.f2814c + ")");
        }
        if (this.p) {
            this.p = false;
        }
        this.z = i;
        this.A = i2;
        c();
        if (this.x != null) {
            this.x.a(this, this.z, this.A, b(this.z), b(this.A));
        }
        invalidate();
        requestLayout();
    }

    public int getLeftIndex() {
        return this.z;
    }

    public int getRightIndex() {
        return this.A;
    }

    public int getTickCount() {
        return this.s;
    }

    public float getTickEnd() {
        return this.f2814c;
    }

    public double getTickInterval() {
        return this.f2815d;
    }

    public float getTickStart() {
        return this.f2813b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.v.a(canvas);
        if (this.B) {
            this.w.a(canvas, this.t, this.u);
            this.v.b(canvas);
            this.t.draw(canvas);
        } else {
            this.w.a(canvas, getMarginLeft(), this.u);
            this.v.b(canvas);
        }
        this.u.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            size = this.q;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.r, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.r;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.s = bundle.getInt("TICK_COUNT");
        this.f2813b = bundle.getFloat("TICK_START");
        this.f2814c = bundle.getFloat("TICK_END");
        this.f2815d = bundle.getFloat("TICK_INTERVAL");
        this.l = bundle.getInt("TICK_COLOR");
        this.f2812a = bundle.getFloat("TICK_HEIGHT_DP");
        this.f2816e = bundle.getFloat("BAR_WEIGHT");
        this.f2817f = bundle.getInt("BAR_COLOR");
        this.o = bundle.getFloat("CIRCLE_SIZE");
        this.n = bundle.getInt("CIRCLE_COLOR");
        this.i = bundle.getFloat("CONNECTING_LINE_WEIGHT");
        this.j = bundle.getInt("CONNECTING_LINE_COLOR");
        this.k = bundle.getFloat("THUMB_RADIUS_DP");
        this.m = bundle.getFloat("EXPANDED_PIN_RADIUS_DP");
        this.C = bundle.getFloat("PIN_PADDING");
        this.D = bundle.getFloat("BAR_PADDING_BOTTOM");
        this.B = bundle.getBoolean("IS_RANGE_BAR");
        this.z = bundle.getInt("LEFT_INDEX");
        this.A = bundle.getInt("RIGHT_INDEX");
        this.p = bundle.getBoolean("FIRST_SET_TICK_COUNT");
        a(this.z, this.A);
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("TICK_COUNT", this.s);
        bundle.putFloat("TICK_START", this.f2813b);
        bundle.putFloat("TICK_END", this.f2814c);
        bundle.putFloat("TICK_INTERVAL", this.f2815d);
        bundle.putInt("TICK_COLOR", this.l);
        bundle.putFloat("TICK_HEIGHT_DP", this.f2812a);
        bundle.putFloat("BAR_WEIGHT", this.f2816e);
        bundle.putInt("BAR_COLOR", this.f2817f);
        bundle.putFloat("CONNECTING_LINE_WEIGHT", this.i);
        bundle.putInt("CONNECTING_LINE_COLOR", this.j);
        bundle.putFloat("CIRCLE_SIZE", this.o);
        bundle.putInt("CIRCLE_COLOR", this.n);
        bundle.putFloat("THUMB_RADIUS_DP", this.k);
        bundle.putFloat("EXPANDED_PIN_RADIUS_DP", this.m);
        bundle.putFloat("PIN_PADDING", this.C);
        bundle.putFloat("BAR_PADDING_BOTTOM", this.D);
        bundle.putBoolean("IS_RANGE_BAR", this.B);
        bundle.putInt("LEFT_INDEX", this.z);
        bundle.putInt("RIGHT_INDEX", this.A);
        bundle.putBoolean("FIRST_SET_TICK_COUNT", this.p);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Context context = getContext();
        float f2 = i2 - this.D;
        if (this.B) {
            this.t = new c(context);
            this.t.a(context, f2, BitmapDescriptorFactory.HUE_RED, this.g, this.h, this.o, this.n);
        }
        this.u = new c(context);
        this.u.a(context, f2, BitmapDescriptorFactory.HUE_RED, this.g, this.h, this.o, this.n);
        float f3 = this.m;
        float f4 = i - (2.0f * f3);
        this.v = new com.appyvet.rangebar.a(context, f3, f2, f4, this.s, this.f2812a, this.l, this.f2816e, this.f2817f);
        if (this.B) {
            this.t.setX(((this.z / (this.s - 1)) * f4) + f3);
            this.t.a(b(this.z));
        }
        this.u.setX(((this.A / (this.s - 1)) * f4) + f3);
        this.u.a(b(this.A));
        int iB = this.B ? this.v.b(this.t) : 0;
        int iB2 = this.v.b(this.u);
        if ((iB != this.z || iB2 != this.A) && this.x != null) {
            this.x.a(this, this.z, this.A, b(this.z), b(this.A));
        }
        this.w = new b(context, f2, this.i, this.j);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.I = 0;
                this.J = 0;
                this.K = motionEvent.getX();
                this.L = motionEvent.getY();
                a(motionEvent.getX(), motionEvent.getY());
                return true;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                b(motionEvent.getX(), motionEvent.getY());
                return true;
            case 2:
                a(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(true);
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.I = (int) (this.I + Math.abs(x - this.K));
                this.J = (int) (this.J + Math.abs(y - this.L));
                this.K = x;
                this.L = y;
                if (this.I >= this.J) {
                    return true;
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            default:
                return false;
        }
    }

    public void setBarColor(int i) {
        this.f2817f = i;
        a();
    }

    public void setBarWeight(float f2) {
        this.f2816e = f2;
        a();
    }

    public void setConnectingLineColor(int i) {
        this.j = i;
        b();
    }

    public void setConnectingLineWeight(float f2) {
        this.i = f2;
        b();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z) {
            this.f2817f = this.F;
            this.j = this.E;
            this.n = this.H;
            this.l = this.G;
        } else {
            this.f2817f = -3355444;
            this.j = -3355444;
            this.n = -3355444;
            this.l = -3355444;
        }
        a();
        c();
        b();
        super.setEnabled(z);
    }

    public void setOnRangeBarChangeListener(a aVar) {
        this.x = aVar;
    }

    public void setPinColor(int i) {
        this.g = i;
        c();
    }

    public void setPinRadius(float f2) {
        this.m = f2;
        c();
    }

    public void setPinTextColor(int i) {
        this.h = i;
        c();
    }

    public void setRangeBarEnabled(boolean z) {
        this.B = z;
        invalidate();
    }

    public void setSeekPinByIndex(int i) {
        if (i < 0 || i > this.s) {
            Log.e("RangeBar", "Pin index " + i + " is out of bounds. Check that it is greater than the minimum (0) and less than the maximum value (" + this.s + ")");
            throw new IllegalArgumentException("Pin index " + i + " is out of bounds. Check that it is greater than the minimum (0) and less than the maximum value (" + this.s + ")");
        }
        if (this.p) {
            this.p = false;
        }
        this.A = i;
        c();
        if (this.x != null) {
            this.x.a(this, this.z, this.A, b(this.z), b(this.A));
        }
        invalidate();
        requestLayout();
    }

    public void setSeekPinByValue(float f2) {
        if (f2 > this.f2814c || f2 < this.f2813b) {
            Log.e("RangeBar", "Pin value " + f2 + " is out of bounds. Check that it is greater than the minimum (" + this.f2813b + ") and less than the maximum value (" + this.f2814c + ")");
            throw new IllegalArgumentException("Pin value " + f2 + " is out of bounds. Check that it is greater than the minimum (" + this.f2813b + ") and less than the maximum value (" + this.f2814c + ")");
        }
        if (this.p) {
            this.p = false;
        }
        this.A = (int) ((f2 - this.f2813b) / this.f2815d);
        c();
        if (this.x != null) {
            this.x.a(this, this.z, this.A, b(this.z), b(this.A));
        }
        invalidate();
        requestLayout();
    }

    public void setSelectorColor(int i) {
        this.n = i;
        c();
    }

    public void setTickColor(int i) {
        this.l = i;
        a();
    }

    public void setTickEnd(float f2) {
        int i = ((int) ((f2 - this.f2813b) / this.f2815d)) + 1;
        if (!a(i)) {
            Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
            throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
        }
        this.s = i;
        this.f2814c = f2;
        if (this.p) {
            this.z = 0;
            this.A = this.s - 1;
            if (this.x != null) {
                this.x.a(this, this.z, this.A, b(this.z), b(this.A));
            }
        }
        if (b(this.z, this.A)) {
            this.z = 0;
            this.A = this.s - 1;
            if (this.x != null) {
                this.x.a(this, this.z, this.A, b(this.z), b(this.A));
            }
        }
        a();
        c();
    }

    public void setTickHeight(float f2) {
        this.f2812a = f2;
        a();
    }

    public void setTickInterval(float f2) {
        int i = ((int) ((this.f2814c - this.f2813b) / f2)) + 1;
        if (!a(i)) {
            Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
            throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
        }
        this.s = i;
        this.f2815d = f2;
        if (this.p) {
            this.z = 0;
            this.A = this.s - 1;
            if (this.x != null) {
                this.x.a(this, this.z, this.A, b(this.z), b(this.A));
            }
        }
        if (b(this.z, this.A)) {
            this.z = 0;
            this.A = this.s - 1;
            if (this.x != null) {
                this.x.a(this, this.z, this.A, b(this.z), b(this.A));
            }
        }
        a();
        c();
    }

    public void setTickStart(float f2) {
        int i = ((int) ((this.f2814c - f2) / this.f2815d)) + 1;
        if (!a(i)) {
            Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
            throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
        }
        this.s = i;
        this.f2813b = f2;
        if (this.p) {
            this.z = 0;
            this.A = this.s - 1;
            if (this.x != null) {
                this.x.a(this, this.z, this.A, b(this.z), b(this.A));
            }
        }
        if (b(this.z, this.A)) {
            this.z = 0;
            this.A = this.s - 1;
            if (this.x != null) {
                this.x.a(this, this.z, this.A, b(this.z), b(this.A));
            }
        }
        a();
        c();
    }
}
