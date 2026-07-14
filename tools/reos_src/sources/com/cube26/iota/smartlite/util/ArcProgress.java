package com.cube26.iota.smartlite.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.cube26.iota.smartlite.R;

/* JADX INFO: loaded from: classes.dex */
public class ArcProgress extends View {
    private final int A;
    private final float B;
    private float C;
    private final int D;
    private String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Paint f3415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f3416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RectF f3417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3420f;
    private String g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;
    private String o;
    private float p;
    private int q;
    private float r;
    private final int s;
    private final int t;
    private final int u;
    private final float v;
    private final float w;
    private final float x;
    private final float y;
    private String z;

    public ArcProgress(Context context) {
        this(context, null);
    }

    public ArcProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3417c = new RectF();
        this.j = 0;
        this.o = "";
        this.s = R.color.colorPrimary;
        this.t = R.color.navtabselectedcolor;
        this.u = Color.rgb(66, 145, 241);
        this.A = 100;
        this.B = 360.0f;
        this.E = "";
        this.C = i.b(getResources(), 18.0f);
        this.D = (int) i.a(getResources(), 100.0f);
        this.C = i.b(getResources(), 40.0f);
        this.v = i.b(getResources(), 15.0f);
        this.w = i.a(getResources(), 4.0f);
        this.z = "";
        this.x = i.b(getResources(), 10.0f);
        this.y = i.a(getResources(), 4.0f);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.cube26.iota.smartlite.a.C0063a.ArcProgress, i, 0);
        a(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    private Bitmap a(int i) {
        return BitmapFactory.decodeResource(getResources(), i);
    }

    protected void a() {
        this.f3415a = new TextPaint();
        this.f3415a.setColor(this.i);
        this.f3415a.setTextSize(this.h);
        this.f3415a.setAntiAlias(true);
        this.f3416b = new Paint();
        this.f3416b.setColor(getResources().getColor(R.color.colorPrimary));
        this.f3416b.setAntiAlias(true);
        this.f3416b.setStrokeWidth(this.f3418d);
        this.f3416b.setStyle(Paint.Style.STROKE);
        this.f3416b.setStrokeCap(Paint.Cap.ROUND);
    }

    protected void a(TypedArray typedArray) {
        this.l = typedArray.getColor(5, getResources().getColor(R.color.colorPrimary));
        this.m = typedArray.getColor(4, getResources().getColor(R.color.navtabselectedcolor));
        this.i = typedArray.getColor(7, this.u);
        this.h = typedArray.getDimension(6, this.C);
        this.n = typedArray.getDimension(1, 360.0f);
        setMax(typedArray.getInt(3, 100));
        setProgress(typedArray.getInt(0, 0));
        this.f3418d = typedArray.getDimension(2, this.y);
        this.f3419e = typedArray.getDimension(9, this.v);
        this.o = TextUtils.isEmpty(typedArray.getString(8)) ? this.z : typedArray.getString(8);
        this.p = typedArray.getDimension(10, this.w);
        this.f3420f = typedArray.getDimension(12, this.x);
        this.g = typedArray.getString(11);
        this.q = typedArray.getResourceId(13, R.drawable.anyone_dummy);
    }

    public float getArcAngle() {
        return this.n;
    }

    public String getBottomText() {
        return this.g;
    }

    public float getBottomTextSize() {
        return this.f3420f;
    }

    public int getFinishedStrokeColor() {
        return this.l;
    }

    public int getMax() {
        return this.k;
    }

    public int getProgress() {
        return this.j;
    }

    public String getProgressText() {
        return this.E;
    }

    public float getStrokeWidth() {
        return this.f3418d;
    }

    public String getSuffixText() {
        return this.o;
    }

    public float getSuffixTextPadding() {
        return this.p;
    }

    public float getSuffixTextSize() {
        return this.f3419e;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return this.D;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return this.D;
    }

    public int getTextColor() {
        return this.i;
    }

    public float getTextSize() {
        return this.h;
    }

    public int getUnfinishedStrokeColor() {
        return this.m;
    }

    @Override // android.view.View
    public void invalidate() {
        a();
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = 90.0f - (this.n / 2.0f);
        float max = (this.j / getMax()) * this.n;
        this.f3416b.setColor(this.m);
        canvas.drawArc(this.f3417c, f2, this.n, false, this.f3416b);
        this.f3416b.setColor(this.l);
        canvas.drawArc(this.f3417c, f2, max, false, this.f3416b);
        String.valueOf(getProgress());
        if (!TextUtils.isEmpty(this.E)) {
            this.f3415a.setColor(this.i);
            this.f3415a.setTextSize(this.h);
            a(this.q).getWidth();
            float fDescent = this.f3415a.descent() + this.f3415a.ascent();
            float height = (getHeight() - fDescent) / 2.0f;
            canvas.drawText(this.E, (getWidth() - this.f3415a.measureText(this.E)) / 2.0f, (getHeight() - fDescent) / 2.0f, this.f3415a);
            this.f3415a.setTextSize(this.f3419e);
            float fMeasureText = this.f3415a.measureText(this.E);
            float fDescent2 = this.f3415a.descent() + this.f3415a.ascent();
            canvas.drawText(this.o, (fMeasureText / 2.0f) + (getWidth() / 2.0f) + this.p, height + (getHeight() / 10), this.f3415a);
        }
        if (TextUtils.isEmpty(getBottomText())) {
            return;
        }
        this.f3415a.setTextSize(this.f3420f);
        canvas.drawText(getBottomText(), (getWidth() - this.f3415a.measureText(getBottomText())) / 2.0f, (getHeight() - this.r) - ((this.f3415a.descent() + this.f3415a.ascent()) / 2.0f), this.f3415a);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.f3417c.set(this.f3418d / 2.0f, this.f3418d / 2.0f, View.MeasureSpec.getSize(i) - (this.f3418d / 2.0f), View.MeasureSpec.getSize(i2) - (this.f3418d / 2.0f));
        this.r = (getWidth() / 2.0f) * ((float) (1.0d - Math.cos(((double) (((360.0f - this.n) / 2.0f) / 180.0f)) * 3.141592653589793d)));
        setMeasuredDimension(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f3418d = bundle.getFloat("stroke_width");
        this.f3419e = bundle.getFloat("suffix_text_size");
        this.p = bundle.getFloat("suffix_text_padding");
        this.f3420f = bundle.getFloat("bottom_text_size");
        this.g = bundle.getString("bottom_text");
        this.h = bundle.getFloat("text_size");
        this.i = bundle.getInt("text_color");
        setMax(bundle.getInt("max"));
        setProgress(bundle.getInt("progress"));
        this.l = bundle.getInt("finished_stroke_color");
        this.m = bundle.getInt("unfinished_stroke_color");
        this.o = bundle.getString("suffix");
        a();
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putFloat("stroke_width", getStrokeWidth());
        bundle.putFloat("suffix_text_size", getSuffixTextSize());
        bundle.putFloat("suffix_text_padding", getSuffixTextPadding());
        bundle.putFloat("bottom_text_size", getBottomTextSize());
        bundle.putString("bottom_text", getBottomText());
        bundle.putFloat("text_size", getTextSize());
        bundle.putInt("text_color", getTextColor());
        bundle.putInt("progress", getProgress());
        bundle.putInt("max", getMax());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt("unfinished_stroke_color", getUnfinishedStrokeColor());
        bundle.putFloat("arc_angle", getArcAngle());
        bundle.putString("suffix", getSuffixText());
        return bundle;
    }

    public void setArcAngle(float f2) {
        this.n = f2;
        invalidate();
    }

    public void setArcIconResId(int i) {
        this.q = i;
        invalidate();
    }

    public void setBottomText(String str) {
        this.g = str;
        invalidate();
    }

    public void setBottomTextSize(float f2) {
        this.f3420f = f2;
        invalidate();
    }

    public void setFinishedStrokeColor(int i) {
        this.l = i;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.k = i;
            invalidate();
        }
    }

    public void setProgress(int i) {
        this.j = i;
        if (this.j > getMax()) {
            this.j %= getMax();
        }
        invalidate();
    }

    public void setProgressText(String str) {
        this.E = str;
        invalidate();
    }

    public void setStrokeWidth(float f2) {
        this.f3418d = f2;
        invalidate();
    }

    public void setSuffixText(String str) {
        this.z = str;
        invalidate();
    }

    public void setSuffixTextPadding(float f2) {
        this.p = f2;
        invalidate();
    }

    public void setSuffixTextSize(float f2) {
        this.f3419e = f2;
        invalidate();
    }

    public void setTextColor(int i) {
        this.i = i;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.h = f2;
        invalidate();
    }

    public void setUnfinishedStrokeColor(int i) {
        this.m = i;
        invalidate();
    }
}
