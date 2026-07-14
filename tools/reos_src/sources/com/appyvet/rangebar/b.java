package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f2828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f2829b;

    public b(Context context, float f2, float f3, int i) {
        float fApplyDimension = TypedValue.applyDimension(1, f3, context.getResources().getDisplayMetrics());
        this.f2828a = new Paint();
        this.f2828a.setColor(i);
        this.f2828a.setStrokeWidth(fApplyDimension);
        this.f2828a.setStrokeCap(Paint.Cap.ROUND);
        this.f2828a.setAntiAlias(true);
        this.f2829b = f2;
    }

    public void a(Canvas canvas, float f2, c cVar) {
        canvas.drawLine(f2, this.f2829b, cVar.getX(), this.f2829b, this.f2828a);
    }

    public void a(Canvas canvas, c cVar, c cVar2) {
        canvas.drawLine(cVar.getX(), this.f2829b, cVar2.getX(), this.f2829b, this.f2828a);
    }
}
