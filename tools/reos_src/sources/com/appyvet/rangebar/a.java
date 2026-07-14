package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f2822a = new Paint();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f2823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f2824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f2825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f2826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2827f;
    private float g;
    private final float h;

    public a(Context context, float f2, float f3, float f4, int i, float f5, int i2, float f6, int i3) {
        this.f2824c = f2;
        this.f2825d = f2 + f4;
        this.f2826e = f3;
        this.f2827f = i - 1;
        this.g = f4 / this.f2827f;
        this.h = TypedValue.applyDimension(1, f5, context.getResources().getDisplayMetrics());
        this.f2822a.setColor(i3);
        this.f2822a.setStrokeWidth(f6);
        this.f2822a.setAntiAlias(true);
        this.f2823b = new Paint();
        this.f2823b.setColor(i2);
        this.f2823b.setStrokeWidth(f6);
        this.f2823b.setAntiAlias(true);
    }

    public float a() {
        return this.f2824c;
    }

    public float a(c cVar) {
        return (b(cVar) * this.g) + this.f2824c;
    }

    public void a(Canvas canvas) {
        canvas.drawLine(this.f2824c, this.f2826e, this.f2825d, this.f2826e, this.f2822a);
    }

    public float b() {
        return this.f2825d;
    }

    public int b(c cVar) {
        return (int) (((cVar.getX() - this.f2824c) + (this.g / 2.0f)) / this.g);
    }

    public void b(Canvas canvas) {
        for (int i = 0; i < this.f2827f; i++) {
            canvas.drawCircle((i * this.g) + this.f2824c, this.f2826e, this.h, this.f2823b);
        }
        canvas.drawCircle(this.f2825d, this.f2826e, this.h, this.f2823b);
    }
}
