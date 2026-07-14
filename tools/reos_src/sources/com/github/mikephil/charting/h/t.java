package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t extends s {
    public t(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.g gVar2, com.github.mikephil.charting.i.d dVar) {
        super(gVar, gVar2, dVar);
        this.f5021e.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.h.s
    public void a(float f2, float f3) {
        if (this.n.j() > 10.0f && !this.n.t()) {
            com.github.mikephil.charting.i.b bVarA = this.f5017a.a(this.n.f(), this.n.e());
            com.github.mikephil.charting.i.b bVarA2 = this.f5017a.a(this.n.g(), this.n.e());
            if (this.f5057f.x()) {
                f2 = (float) bVarA2.f5060a;
                f3 = (float) bVarA.f5060a;
            } else {
                f2 = (float) bVarA.f5060a;
                f3 = (float) bVarA2.f5060a;
            }
        }
        b(f2, f3);
    }

    @Override // com.github.mikephil.charting.h.s
    public void a(Canvas canvas) {
        if (this.f5057f.q() && this.f5057f.g()) {
            float[] fArr = new float[this.f5057f.n * 2];
            for (int i = 0; i < fArr.length; i += 2) {
                fArr[i] = this.f5057f.m[i / 2];
            }
            this.f5017a.a(fArr);
            this.f5019c.setTypeface(this.f5057f.n());
            this.f5019c.setTextSize(this.f5057f.o());
            this.f5019c.setColor(this.f5057f.p());
            this.f5019c.setTextAlign(Paint.Align.CENTER);
            float fA = com.github.mikephil.charting.i.f.a(2.5f);
            float fB = com.github.mikephil.charting.i.f.b(this.f5019c, "Q");
            com.github.mikephil.charting.c.g.a aVarR = this.f5057f.r();
            com.github.mikephil.charting.c.g.b bVarS = this.f5057f.s();
            a(canvas, aVarR == com.github.mikephil.charting.c.g.a.LEFT ? bVarS == com.github.mikephil.charting.c.g.b.OUTSIDE_CHART ? this.n.e() - fA : this.n.e() - fA : bVarS == com.github.mikephil.charting.c.g.b.OUTSIDE_CHART ? fA + fB + this.n.h() : fA + fB + this.n.h(), fArr, this.f5057f.m());
        }
    }

    @Override // com.github.mikephil.charting.h.s
    protected void a(Canvas canvas, float f2, float[] fArr, float f3) {
        this.f5019c.setTypeface(this.f5057f.n());
        this.f5019c.setTextSize(this.f5057f.o());
        this.f5019c.setColor(this.f5057f.p());
        for (int i = 0; i < this.f5057f.n; i++) {
            String strA = this.f5057f.a(i);
            if (!this.f5057f.t() && i >= this.f5057f.n - 1) {
                return;
            }
            canvas.drawText(strA, fArr[i * 2], f2 - f3, this.f5019c);
        }
    }

    @Override // com.github.mikephil.charting.h.s
    public void b(Canvas canvas) {
        if (this.f5057f.q() && this.f5057f.b()) {
            this.f5020d.setColor(this.f5057f.f());
            this.f5020d.setStrokeWidth(this.f5057f.d());
            if (this.f5057f.r() == com.github.mikephil.charting.c.g.a.LEFT) {
                canvas.drawLine(this.n.f(), this.n.e(), this.n.g(), this.n.e(), this.f5020d);
            } else {
                canvas.drawLine(this.n.f(), this.n.h(), this.n.g(), this.n.h(), this.f5020d);
            }
        }
    }

    @Override // com.github.mikephil.charting.h.s
    public void c(Canvas canvas) {
        if (this.f5057f.a() && this.f5057f.q()) {
            float[] fArr = new float[2];
            this.f5018b.setColor(this.f5057f.c());
            this.f5018b.setStrokeWidth(this.f5057f.e());
            for (int i = 0; i < this.f5057f.n; i++) {
                fArr[0] = this.f5057f.m[i];
                this.f5017a.a(fArr);
                canvas.drawLine(fArr[0], this.n.e(), fArr[0], this.n.h(), this.f5018b);
            }
        }
    }

    @Override // com.github.mikephil.charting.h.s
    public void d(Canvas canvas) {
        List<com.github.mikephil.charting.c.d> listI = this.f5057f.i();
        if (listI == null || listI.size() <= 0) {
            return;
        }
        float[] fArr = new float[4];
        Path path = new Path();
        for (int i = 0; i < listI.size(); i++) {
            com.github.mikephil.charting.c.d dVar = listI.get(i);
            if (dVar.q()) {
                fArr[0] = dVar.a();
                fArr[2] = dVar.a();
                this.f5017a.a(fArr);
                fArr[1] = this.n.e();
                fArr[3] = this.n.h();
                path.moveTo(fArr[0], fArr[1]);
                path.lineTo(fArr[2], fArr[3]);
                this.f5021e.setStyle(Paint.Style.STROKE);
                this.f5021e.setColor(dVar.c());
                this.f5021e.setPathEffect(dVar.d());
                this.f5021e.setStrokeWidth(dVar.b());
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
                    float fB = dVar.b() + dVar.l();
                    float fA = com.github.mikephil.charting.i.f.a(2.0f) + dVar.m();
                    com.github.mikephil.charting.c.d.a aVarF = dVar.f();
                    if (aVarF == com.github.mikephil.charting.c.d.a.RIGHT_TOP) {
                        float fB2 = com.github.mikephil.charting.i.f.b(this.f5021e, strG);
                        this.f5021e.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strG, fB + fArr[0], fB2 + fA + this.n.e(), this.f5021e);
                    } else if (aVarF == com.github.mikephil.charting.c.d.a.RIGHT_BOTTOM) {
                        this.f5021e.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strG, fArr[0] + fB, this.n.h() - fA, this.f5021e);
                    } else if (aVarF == com.github.mikephil.charting.c.d.a.LEFT_TOP) {
                        this.f5021e.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strG, fArr[0] - fB, com.github.mikephil.charting.i.f.b(this.f5021e, strG) + fA + this.n.e(), this.f5021e);
                    } else {
                        this.f5021e.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strG, fArr[0] - fB, this.n.h() - fA, this.f5021e);
                    }
                }
            }
        }
    }
}
