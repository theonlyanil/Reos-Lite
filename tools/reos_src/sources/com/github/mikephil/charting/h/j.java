package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f5046a;

    public j(com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(aVar, gVar);
        this.f5046a = new Path();
    }

    protected void a(Canvas canvas, float[] fArr, com.github.mikephil.charting.data.o oVar) {
        this.g.setColor(oVar.g());
        this.g.setStrokeWidth(oVar.L());
        this.g.setPathEffect(oVar.M());
        if (oVar.J()) {
            this.f5046a.reset();
            this.f5046a.moveTo(fArr[0], this.n.e());
            this.f5046a.lineTo(fArr[0], this.n.h());
            canvas.drawPath(this.f5046a, this.g);
        }
        if (oVar.K()) {
            this.f5046a.reset();
            this.f5046a.moveTo(this.n.f(), fArr[1]);
            this.f5046a.lineTo(this.n.g(), fArr[1]);
            canvas.drawPath(this.f5046a, this.g);
        }
    }
}
