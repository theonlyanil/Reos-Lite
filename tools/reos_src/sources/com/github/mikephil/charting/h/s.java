package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.github.mikephil.charting.c.g f5057f;

    public s(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.g gVar2, com.github.mikephil.charting.i.d dVar) {
        super(gVar, dVar);
        this.f5057f = gVar2;
        this.f5019c.setColor(-16777216);
        this.f5019c.setTextSize(com.github.mikephil.charting.i.f.a(10.0f));
    }

    public void a(float f2, float f3) {
        if (this.n.i() > 10.0f && !this.n.s()) {
            com.github.mikephil.charting.i.b bVarA = this.f5017a.a(this.n.f(), this.n.e());
            com.github.mikephil.charting.i.b bVarA2 = this.f5017a.a(this.n.f(), this.n.h());
            if (this.f5057f.x()) {
                f2 = (float) bVarA.f5061b;
                f3 = (float) bVarA2.f5061b;
            } else {
                f2 = (float) bVarA2.f5061b;
                f3 = (float) bVarA.f5061b;
            }
        }
        b(f2, f3);
    }

    public void a(Canvas canvas) {
        float fG;
        if (this.f5057f.q() && this.f5057f.g()) {
            float[] fArr = new float[this.f5057f.n * 2];
            for (int i = 0; i < fArr.length; i += 2) {
                fArr[i + 1] = this.f5057f.m[i / 2];
            }
            this.f5017a.a(fArr);
            this.f5019c.setTypeface(this.f5057f.n());
            this.f5019c.setTextSize(this.f5057f.o());
            this.f5019c.setColor(this.f5057f.p());
            float fL = this.f5057f.l();
            float fB = (com.github.mikephil.charting.i.f.b(this.f5019c, "A") / 2.5f) + this.f5057f.m();
            com.github.mikephil.charting.c.g.a aVarR = this.f5057f.r();
            com.github.mikephil.charting.c.g.b bVarS = this.f5057f.s();
            if (aVarR == com.github.mikephil.charting.c.g.a.LEFT) {
                if (bVarS == com.github.mikephil.charting.c.g.b.OUTSIDE_CHART) {
                    this.f5019c.setTextAlign(Paint.Align.RIGHT);
                    fG = this.n.a() - fL;
                } else {
                    this.f5019c.setTextAlign(Paint.Align.LEFT);
                    fG = fL + this.n.a();
                }
            } else if (bVarS == com.github.mikephil.charting.c.g.b.OUTSIDE_CHART) {
                this.f5019c.setTextAlign(Paint.Align.LEFT);
                fG = fL + this.n.g();
            } else {
                this.f5019c.setTextAlign(Paint.Align.RIGHT);
                fG = this.n.g() - fL;
            }
            a(canvas, fG, fArr, fB);
        }
    }

    protected void a(Canvas canvas, float f2, float[] fArr, float f3) {
        for (int i = 0; i < this.f5057f.n; i++) {
            String strA = this.f5057f.a(i);
            if (!this.f5057f.t() && i >= this.f5057f.n - 1) {
                return;
            }
            canvas.drawText(strA, f2, fArr[(i * 2) + 1] + f3, this.f5019c);
        }
    }

    protected void b(float f2, float f3) {
        int iU = this.f5057f.u();
        double dAbs = Math.abs(f3 - f2);
        if (iU == 0 || dAbs <= 0.0d) {
            this.f5057f.m = new float[0];
            this.f5057f.n = 0;
            return;
        }
        double dA = com.github.mikephil.charting.i.f.a(dAbs / ((double) iU));
        double dPow = Math.pow(10.0d, (int) Math.log10(dA));
        if (((int) (dA / dPow)) > 5) {
            dA = Math.floor(10.0d * dPow);
        }
        if (this.f5057f.v()) {
            float f4 = ((float) dAbs) / (iU - 1);
            this.f5057f.n = iU;
            if (this.f5057f.m.length < iU) {
                this.f5057f.m = new float[iU];
            }
            for (int i = 0; i < iU; i++) {
                this.f5057f.m[i] = f2;
                f2 += f4;
            }
        } else if (this.f5057f.w()) {
            this.f5057f.n = 2;
            this.f5057f.m = new float[2];
            this.f5057f.m[0] = f2;
            this.f5057f.m[1] = f3;
        } else {
            double dCeil = Math.ceil(((double) f2) / dA) * dA;
            int i2 = 0;
            double d2 = dCeil;
            while (d2 <= com.github.mikephil.charting.i.f.b(Math.floor(((double) f3) / dA) * dA)) {
                d2 += dA;
                i2++;
            }
            this.f5057f.n = i2;
            if (this.f5057f.m.length < i2) {
                this.f5057f.m = new float[i2];
            }
            for (int i3 = 0; i3 < i2; i3++) {
                this.f5057f.m[i3] = (float) dCeil;
                dCeil += dA;
            }
        }
        if (dA >= 1.0d) {
            this.f5057f.o = 0;
        } else {
            this.f5057f.o = (int) Math.ceil(-Math.log10(dA));
        }
    }

    public void b(Canvas canvas) {
        if (this.f5057f.q() && this.f5057f.b()) {
            this.f5020d.setColor(this.f5057f.f());
            this.f5020d.setStrokeWidth(this.f5057f.d());
            if (this.f5057f.r() == com.github.mikephil.charting.c.g.a.LEFT) {
                canvas.drawLine(this.n.f(), this.n.e(), this.n.f(), this.n.h(), this.f5020d);
            } else {
                canvas.drawLine(this.n.g(), this.n.e(), this.n.g(), this.n.h(), this.f5020d);
            }
        }
    }

    public void c(Canvas canvas) {
        if (this.f5057f.a() && this.f5057f.q()) {
            float[] fArr = new float[2];
            this.f5018b.setColor(this.f5057f.c());
            this.f5018b.setStrokeWidth(this.f5057f.e());
            this.f5018b.setPathEffect(this.f5057f.k());
            Path path = new Path();
            for (int i = 0; i < this.f5057f.n; i++) {
                fArr[1] = this.f5057f.m[i];
                this.f5017a.a(fArr);
                path.moveTo(this.n.a(), fArr[1]);
                path.lineTo(this.n.g(), fArr[1]);
                canvas.drawPath(path, this.f5018b);
                path.reset();
            }
        }
    }

    public void d(Canvas canvas) {
        List<com.github.mikephil.charting.c.d> listI = this.f5057f.i();
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
                    this.f5021e.setTypeface(dVar.n());
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
