package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.github.mikephil.charting.c.f f5056f;
    float[] g;
    private Path h;

    public o(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.f fVar, com.github.mikephil.charting.i.d dVar) {
        super(gVar, dVar);
        this.g = new float[4];
        this.h = new Path();
        this.f5056f = fVar;
        this.f5019c.setColor(-16777216);
        this.f5019c.setTextAlign(Paint.Align.CENTER);
        this.f5019c.setTextSize(com.github.mikephil.charting.i.f.a(10.0f));
    }

    public void a(float f2, List<String> list) {
        this.f5019c.setTypeface(this.f5056f.n());
        this.f5019c.setTextSize(this.f5056f.o());
        StringBuilder sb = new StringBuilder();
        int iRound = Math.round(this.f5056f.u() + f2);
        for (int i = 0; i < iRound; i++) {
            sb.append('h');
        }
        float f3 = com.github.mikephil.charting.i.f.c(this.f5019c, sb.toString()).f5058a;
        float fB = com.github.mikephil.charting.i.f.b(this.f5019c, "Q");
        com.github.mikephil.charting.i.a aVarA = com.github.mikephil.charting.i.f.a(f3, fB, this.f5056f.s());
        this.f5056f.m = Math.round(f3);
        this.f5056f.n = Math.round(fB);
        this.f5056f.o = Math.round(aVarA.f5058a);
        this.f5056f.p = Math.round(aVarA.f5059b);
        this.f5056f.a(list);
    }

    public void a(Canvas canvas) {
        if (this.f5056f.q() && this.f5056f.g()) {
            float fM = this.f5056f.m();
            this.f5019c.setTypeface(this.f5056f.n());
            this.f5019c.setTextSize(this.f5056f.o());
            this.f5019c.setColor(this.f5056f.p());
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP) {
                a(canvas, this.n.e() - fM, new PointF(0.5f, 1.0f));
                return;
            }
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP_INSIDE) {
                a(canvas, fM + this.n.e() + this.f5056f.p, new PointF(0.5f, 1.0f));
                return;
            }
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM) {
                a(canvas, fM + this.n.h(), new PointF(0.5f, BitmapDescriptorFactory.HUE_RED));
            } else if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM_INSIDE) {
                a(canvas, (this.n.h() - fM) - this.f5056f.p, new PointF(0.5f, BitmapDescriptorFactory.HUE_RED));
            } else {
                a(canvas, this.n.e() - fM, new PointF(0.5f, 1.0f));
                a(canvas, fM + this.n.h(), new PointF(0.5f, BitmapDescriptorFactory.HUE_RED));
            }
        }
    }

    protected void a(Canvas canvas, float f2, PointF pointF) {
        float fS = this.f5056f.s();
        float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        int i = this.o;
        while (i <= this.p) {
            fArr[0] = i;
            this.f5017a.a(fArr);
            if (this.n.c(fArr[0])) {
                String str = this.f5056f.w().get(i);
                if (this.f5056f.v()) {
                    if (i == this.f5056f.w().size() - 1 && this.f5056f.w().size() > 1) {
                        float fA = com.github.mikephil.charting.i.f.a(this.f5019c, str);
                        if (fA > this.n.b() * 2.0f && fArr[0] + fA > this.n.n()) {
                            fArr[0] = fArr[0] - (fA / 2.0f);
                        }
                    } else if (i == 0) {
                        fArr[0] = (com.github.mikephil.charting.i.f.a(this.f5019c, str) / 2.0f) + fArr[0];
                    }
                }
                a(canvas, str, i, fArr[0], f2, pointF, fS);
            }
            i += this.f5056f.r;
        }
    }

    public void a(Canvas canvas, com.github.mikephil.charting.c.d dVar, float[] fArr) {
        this.g[0] = fArr[0];
        this.g[1] = this.n.e();
        this.g[2] = fArr[0];
        this.g[3] = this.n.h();
        this.h.reset();
        this.h.moveTo(this.g[0], this.g[1]);
        this.h.lineTo(this.g[2], this.g[3]);
        this.f5021e.setStyle(Paint.Style.STROKE);
        this.f5021e.setColor(dVar.c());
        this.f5021e.setStrokeWidth(dVar.b());
        this.f5021e.setPathEffect(dVar.d());
        canvas.drawPath(this.h, this.f5021e);
    }

    public void a(Canvas canvas, com.github.mikephil.charting.c.d dVar, float[] fArr, float f2) {
        String strG = dVar.g();
        if (strG == null || strG.equals("")) {
            return;
        }
        this.f5021e.setStyle(dVar.e());
        this.f5021e.setPathEffect(null);
        this.f5021e.setColor(dVar.p());
        this.f5021e.setStrokeWidth(0.5f);
        this.f5021e.setTextSize(dVar.o());
        float fB = dVar.b() + dVar.l();
        com.github.mikephil.charting.c.d.a aVarF = dVar.f();
        if (aVarF == com.github.mikephil.charting.c.d.a.RIGHT_TOP) {
            float fB2 = com.github.mikephil.charting.i.f.b(this.f5021e, strG);
            this.f5021e.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strG, fB + fArr[0], fB2 + this.n.e() + f2, this.f5021e);
        } else if (aVarF == com.github.mikephil.charting.c.d.a.RIGHT_BOTTOM) {
            this.f5021e.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strG, fB + fArr[0], this.n.h() - f2, this.f5021e);
        } else if (aVarF != com.github.mikephil.charting.c.d.a.LEFT_TOP) {
            this.f5021e.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strG, fArr[0] - fB, this.n.h() - f2, this.f5021e);
        } else {
            this.f5021e.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strG, fArr[0] - fB, com.github.mikephil.charting.i.f.b(this.f5021e, strG) + this.n.e() + f2, this.f5021e);
        }
    }

    protected void a(Canvas canvas, String str, int i, float f2, float f3, PointF pointF, float f4) {
        com.github.mikephil.charting.i.f.a(canvas, this.f5056f.x().a(str, i, this.n), f2, f3, this.f5019c, pointF, f4);
    }

    public void b(Canvas canvas) {
        if (this.f5056f.b() && this.f5056f.q()) {
            this.f5020d.setColor(this.f5056f.f());
            this.f5020d.setStrokeWidth(this.f5056f.d());
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP || this.f5056f.r() == com.github.mikephil.charting.c.f.a.TOP_INSIDE || this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTH_SIDED) {
                canvas.drawLine(this.n.f(), this.n.e(), this.n.g(), this.n.e(), this.f5020d);
            }
            if (this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM || this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTTOM_INSIDE || this.f5056f.r() == com.github.mikephil.charting.c.f.a.BOTH_SIDED) {
                canvas.drawLine(this.n.f(), this.n.h(), this.n.g(), this.n.h(), this.f5020d);
            }
        }
    }

    public void c(Canvas canvas) {
        if (this.f5056f.a() && this.f5056f.q()) {
            float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
            this.f5018b.setColor(this.f5056f.c());
            this.f5018b.setStrokeWidth(this.f5056f.e());
            this.f5018b.setPathEffect(this.f5056f.k());
            Path path = new Path();
            int i = this.o;
            while (i <= this.p) {
                fArr[0] = i;
                this.f5017a.a(fArr);
                if (fArr[0] >= this.n.a() && fArr[0] <= this.n.n()) {
                    path.moveTo(fArr[0], this.n.h());
                    path.lineTo(fArr[0], this.n.e());
                    canvas.drawPath(path, this.f5018b);
                }
                path.reset();
                i += this.f5056f.r;
            }
        }
    }

    public void d(Canvas canvas) {
        List<com.github.mikephil.charting.c.d> listI = this.f5056f.i();
        if (listI == null || listI.size() <= 0) {
            return;
        }
        float[] fArr = new float[2];
        for (int i = 0; i < listI.size(); i++) {
            com.github.mikephil.charting.c.d dVar = listI.get(i);
            if (dVar.q()) {
                fArr[0] = dVar.a();
                fArr[1] = 0.0f;
                this.f5017a.a(fArr);
                a(canvas, dVar, fArr);
                a(canvas, dVar, fArr, 2.0f + dVar.m());
            }
        }
    }
}
