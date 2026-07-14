package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.data.Entry;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.github.mikephil.charting.a.a f5035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Paint f5036f;
    protected Paint g;
    protected Paint h;
    protected Paint i;

    public f(com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(gVar);
        this.f5035e = aVar;
        this.f5036f = new Paint(1);
        this.f5036f.setStyle(Paint.Style.FILL);
        this.h = new Paint(4);
        this.i = new Paint(1);
        this.i.setColor(Color.rgb(63, 63, 63));
        this.i.setTextAlign(Paint.Align.CENTER);
        this.i.setTextSize(com.github.mikephil.charting.i.f.a(9.0f));
        this.g = new Paint(1);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(2.0f);
        this.g.setColor(Color.rgb(255, 187, 115));
    }

    public abstract void a();

    public abstract void a(Canvas canvas);

    public void a(Canvas canvas, com.github.mikephil.charting.d.f fVar, float f2, Entry entry, int i, float f3, float f4) {
        canvas.drawText(fVar.a(f2, entry, i, this.n), f3, f4, this.i);
    }

    public abstract void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr);

    protected void a(com.github.mikephil.charting.data.k<?> kVar) {
        this.i.setColor(kVar.A());
        this.i.setTypeface(kVar.B());
        this.i.setTextSize(kVar.C());
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);
}
