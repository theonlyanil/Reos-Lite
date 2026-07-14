package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.BarChart;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q extends p {
    public q(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.f fVar, com.github.mikephil.charting.i.d dVar, BarChart barChart) {
        super(gVar, fVar, dVar, barChart);
    }

    @Override // com.github.mikephil.charting.h.o
    public void a(float f2, List<String> list) {
        this.f5019c.setTypeface(this.f5056f.n());
        this.f5019c.setTextSize(this.f5056f.o());
        this.f5056f.a(list);
        com.github.mikephil.charting.i.a aVarC = com.github.mikephil.charting.i.f.c(this.f5019c, this.f5056f.y());
        float fL = (int) (aVarC.f5058a + (this.f5056f.l() * 3.5f));
        float f3 = aVarC.f5059b;
        com.github.mikephil.charting.i.a aVarA = com.github.mikephil.charting.i.f.a(aVarC.f5058a, f3, this.f5056f.s());
        this.f5056f.m = Math.round(fL);
        this.f5056f.n = Math.round(f3);
        this.f5056f.o = (int) (aVarA.f5058a + (this.f5056f.l() * 3.5f));
        this.f5056f.p = Math.round(aVarA.f5059b);
    }

    @Override // com.github.mikephil.charting.h.o
    public void a(Canvas canvas) {
        if (this.f5056f.q() && this.f5056f.g()) {
            float fL = this.f5056f.l();
            this.f5019c.setTypeface(this.f5056f.n());
            this.f5019c.setTextSize(this.f5056f.o());
            this.f5019c.setColor(this.f5056f.p());
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP) {
                a(canvas, fL + this.n.g(), new PointF(BitmapDescriptorFactory.HUE_RED, 0.5f));
                return;
            }
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP_INSIDE) {
                a(canvas, this.n.g() - fL, new PointF(1.0f, 0.5f));
                return;
            }
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM) {
                a(canvas, this.n.f() - fL, new PointF(1.0f, 0.5f));
            } else if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM_INSIDE) {
                a(canvas, fL + this.n.f(), new PointF(BitmapDescriptorFactory.HUE_RED, 0.5f));
            } else {
                a(canvas, this.n.g() + fL, new PointF(BitmapDescriptorFactory.HUE_RED, 0.5f));
                a(canvas, this.n.f() - fL, new PointF(1.0f, 0.5f));
            }
        }
    }

    @Override // com.github.mikephil.charting.h.p, com.github.mikephil.charting.h.o
    protected void a(Canvas canvas, float f2, PointF pointF) {
        float fS = this.f5056f.s();
        float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        com.github.mikephil.charting.data.a aVar = (com.github.mikephil.charting.data.a) this.h.getData();
        int iF = aVar.f();
        int i = this.o;
        while (i <= this.p) {
            fArr[1] = (i * iF) + (i * aVar.a()) + (aVar.a() / 2.0f);
            if (iF > 1) {
                fArr[1] = fArr[1] + ((iF - 1.0f) / 2.0f);
            }
            this.f5017a.a(fArr);
            if (this.n.d(fArr[1])) {
                a(canvas, this.f5056f.w().get(i), i, f2, fArr[1], pointF, fS);
            }
            i += this.f5056f.r;
        }
    }

    @Override // com.github.mikephil.charting.h.o
    public void b(Canvas canvas) {
        if (this.f5056f.b() && this.f5056f.q()) {
            this.f5020d.setColor(this.f5056f.f());
            this.f5020d.setStrokeWidth(this.f5056f.d());
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP || this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP_INSIDE || this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTH_SIDED) {
                canvas.drawLine(this.n.g(), this.n.e(), this.n.g(), this.n.h(), this.f5020d);
            }
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM || this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM_INSIDE || this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTH_SIDED) {
                canvas.drawLine(this.n.f(), this.n.e(), this.n.f(), this.n.h(), this.f5020d);
            }
        }
    }

    @Override // com.github.mikephil.charting.h.p, com.github.mikephil.charting.h.o
    public void c(Canvas canvas) {
        if (!this.f5056f.a() || !this.f5056f.q()) {
            return;
        }
        float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        this.f5018b.setColor(this.f5056f.c());
        this.f5018b.setStrokeWidth(this.f5056f.e());
        com.github.mikephil.charting.data.a aVar = (com.github.mikephil.charting.data.a) this.h.getData();
        int iF = aVar.f();
        int i = this.o;
        while (true) {
            int i2 = i;
            if (i2 > this.p) {
                return;
            }
            fArr[1] = ((i2 * iF) + (i2 * aVar.a())) - 0.5f;
            this.f5017a.a(fArr);
            if (this.n.d(fArr[1])) {
                canvas.drawLine(this.n.f(), fArr[1], this.n.g(), fArr[1], this.f5018b);
            }
            i = this.f5056f.r + i2;
        }
    }

    @Override // com.github.mikephil.charting.h.o
    public void d(Canvas canvas) {
        List<com.github.mikephil.charting.c.d> listI = this.f5056f.i();
        if (listI == null || listI.size() <= 0) {
            return;
        }
        float[] fArr = new float[2];
        Path path = new Path();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listI.size()) {
                return;
            }
            com.github.mikephil.charting.c.d dVar = listI.get(i2);
            if (dVar.q()) {
                this.f5021e.setStyle(Paint.Style.STROKE);
                this.f5021e.setColor(dVar.c());
                this.f5021e.setStrokeWidth(dVar.b());
                this.f5021e.setPathEffect(dVar.d());
                fArr[1] = dVar.a();
                this.f5017a.a(fArr);
                path.moveTo(this.n.f(), fArr[1]);
                path.lineTo(this.n.g(), fArr[1]);
                canvas.drawPath(path, this.f5021e);
                path.reset();
                String strG = dVar.g();
                if (strG != null && !strG.equals("")) {
                    this.f5021e.setStyle(dVar.e());
                    this.f5021e.setPathEffect(null);
                    this.f5021e.setColor(dVar.p());
                    this.f5021e.setStrokeWidth(0.5f);
                    this.f5021e.setTextSize(dVar.o());
                    float fB = com.github.mikephil.charting.i.f.b(this.f5021e, strG);
                    float fA = com.github.mikephil.charting.i.f.a(4.0f) + dVar.l();
                    float fB2 = dVar.b() + fB + dVar.m();
                    com.github.mikephil.charting.c.d.a aVarF = dVar.f();
                    if (aVarF == com.github.mikephil.charting.c.d.a.RIGHT_TOP) {
                        this.f5021e.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strG, this.n.g() - fA, fB + (fArr[1] - fB2), this.f5021e);
                    } else if (aVarF == com.github.mikephil.charting.c.d.a.RIGHT_BOTTOM) {
                        this.f5021e.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strG, this.n.g() - fA, fArr[1] + fB2, this.f5021e);
                    } else if (aVarF == com.github.mikephil.charting.c.d.a.LEFT_TOP) {
                        this.f5021e.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strG, this.n.f() + fA, fB + (fArr[1] - fB2), this.f5021e);
                    } else {
                        this.f5021e.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strG, this.n.a() + fA, fArr[1] + fB2, this.f5021e);
                    }
                }
            }
            i = i2 + 1;
        }
    }
}
