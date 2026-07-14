package com.appyvet.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f2834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f2835f;
    private String g;
    private int h;
    private ColorFilter i;
    private float j;
    private float k;
    private Rect l;
    private Resources m;
    private Paint n;
    private float o;

    public c(Context context) {
        super(context);
        this.f2831b = false;
        this.l = new Rect();
    }

    private static void a(Paint paint, String str, float f2, float f3, float f4) {
        paint.setTextSize(10.0f);
        paint.setTextSize(Math.max(Math.min((f4 / paint.measureText(str)) * 10.0f, f3), f2));
    }

    public void a() {
        this.f2831b = true;
    }

    public void a(float f2, float f3) {
        this.j = (int) f3;
        this.h = (int) f2;
        invalidate();
    }

    public void a(Context context, float f2, float f3, int i, int i2, float f4, int i3) {
        this.m = context.getResources();
        this.f2835f = context.getResources().getDrawable(d.a.rotate);
        this.j = (int) TypedValue.applyDimension(1, 15.0f, this.m.getDisplayMetrics());
        this.o = f4;
        this.k = (int) TypedValue.applyDimension(1, 3.5f, this.m.getDisplayMetrics());
        if (f3 == -1.0f) {
            this.h = (int) TypedValue.applyDimension(1, 14.0f, this.m.getDisplayMetrics());
        } else {
            this.h = (int) TypedValue.applyDimension(1, f3, this.m.getDisplayMetrics());
        }
        int iApplyDimension = (int) TypedValue.applyDimension(2, 15.0f, this.m.getDisplayMetrics());
        this.f2834e = new Paint();
        this.f2834e.setColor(i2);
        this.f2834e.setAntiAlias(true);
        this.f2834e.setTextSize(iApplyDimension);
        this.n = new Paint();
        this.n.setColor(i3);
        this.n.setAntiAlias(true);
        this.i = new LightingColorFilter(i, i);
        this.f2830a = TypedValue.applyDimension(1, (int) Math.max(24.0f, this.h), this.m.getDisplayMetrics());
        this.f2832c = f2;
    }

    public void a(String str) {
        this.g = str;
    }

    public void b() {
        this.f2831b = false;
    }

    public boolean b(float f2, float f3) {
        return Math.abs(f2 - this.f2833d) <= this.f2830a && Math.abs((f3 - this.f2832c) + this.j) <= this.f2830a;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.drawCircle(this.f2833d, this.f2832c, this.o, this.n);
        if (this.h > 0) {
            this.l.set(((int) this.f2833d) - this.h, (((int) this.f2832c) - (this.h * 2)) - ((int) this.j), ((int) this.f2833d) + this.h, ((int) this.f2832c) - ((int) this.j));
            this.f2835f.setBounds(this.l);
            String strSubstring = this.g;
            if (this.g.length() > 4) {
                strSubstring = this.g.substring(0, 4);
            }
            a(this.f2834e, strSubstring, 8.0f, 24.0f, this.l.width());
            this.f2834e.getTextBounds(strSubstring, 0, strSubstring.length(), this.l);
            this.f2834e.setTextAlign(Paint.Align.CENTER);
            this.f2835f.setColorFilter(this.i);
            this.f2835f.draw(canvas);
            canvas.drawText(strSubstring, this.f2833d, ((this.f2832c - this.h) - this.j) + this.k, this.f2834e);
        }
    }

    @Override // android.view.View
    public float getX() {
        return this.f2833d;
    }

    @Override // android.view.View
    public boolean isPressed() {
        return this.f2831b;
    }

    @Override // android.view.View
    public void setX(float f2) {
        this.f2833d = f2;
    }
}
