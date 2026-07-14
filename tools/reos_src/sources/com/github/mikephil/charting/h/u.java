package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.RadarChart;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u extends s {
    private RadarChart g;

    public u(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.g gVar2, RadarChart radarChart) {
        super(gVar, gVar2, null);
        this.g = radarChart;
    }

    @Override // com.github.mikephil.charting.h.s
    public void a(float f2, float f3) {
        b(f2, f3);
    }

    @Override // com.github.mikephil.charting.h.s
    public void a(Canvas canvas) {
        if (this.f5057f.q() && this.f5057f.g()) {
            this.f5019c.setTypeface(this.f5057f.n());
            this.f5019c.setTextSize(this.f5057f.o());
            this.f5019c.setColor(this.f5057f.p());
            PointF centerOffsets = this.g.getCenterOffsets();
            float factor = this.g.getFactor();
            int i = this.f5057f.n;
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 == i - 1 && !this.f5057f.t()) {
                    return;
                }
                PointF pointFA = com.github.mikephil.charting.i.f.a(centerOffsets, (this.f5057f.m[i2] - this.f5057f.y) * factor, this.g.getRotationAngle());
                canvas.drawText(this.f5057f.a(i2), pointFA.x + 10.0f, pointFA.y, this.f5019c);
            }
        }
    }

    @Override // com.github.mikephil.charting.h.s
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
            float f5 = f2;
            for (int i = 0; i < iU; i++) {
                this.f5057f.m[i] = f5;
                f5 += f4;
            }
        } else if (this.f5057f.w()) {
            this.f5057f.n = 2;
            this.f5057f.m = new float[2];
            this.f5057f.m[0] = f2;
            this.f5057f.m[1] = f3;
        } else {
            double d2 = ((double) f2) / dA;
            double dFloor = d2 < 0.0d ? Math.floor(d2) * dA : Math.ceil(d2) * dA;
            if (dFloor < f2 && this.f5057f.y()) {
                dFloor = f2;
            }
            if (dFloor == 0.0d) {
                dFloor = 0.0d;
            }
            int i2 = 0;
            for (double d3 = dFloor; d3 <= com.github.mikephil.charting.i.f.b(Math.floor(((double) f3) / dA) * dA); d3 += dA) {
                i2++;
            }
            if (Float.isNaN(this.f5057f.A())) {
                i2++;
            }
            this.f5057f.n = i2;
            if (this.f5057f.m.length < i2) {
                this.f5057f.m = new float[i2];
            }
            double d4 = dFloor;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f5057f.m[i3] = (float) d4;
                d4 += dA;
            }
        }
        if (dA < 1.0d) {
            this.f5057f.o = (int) Math.ceil(-Math.log10(dA));
        } else {
            this.f5057f.o = 0;
        }
        if (!this.f5057f.y() && this.f5057f.m[0] < f2) {
            this.f5057f.y = this.f5057f.m[0];
        }
        this.f5057f.x = this.f5057f.m[this.f5057f.n - 1];
        this.f5057f.z = Math.abs(this.f5057f.x - this.f5057f.y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.s
    public void d(Canvas canvas) {
        List<com.github.mikephil.charting.c.d> listI = this.f5057f.i();
        if (listI == null) {
            return;
        }
        float sliceAngle = this.g.getSliceAngle();
        float factor = this.g.getFactor();
        PointF centerOffsets = this.g.getCenterOffsets();
        for (int i = 0; i < listI.size(); i++) {
            com.github.mikephil.charting.c.d dVar = listI.get(i);
            if (dVar.q()) {
                this.f5021e.setColor(dVar.c());
                this.f5021e.setPathEffect(dVar.d());
                this.f5021e.setStrokeWidth(dVar.b());
                float fA = (dVar.a() - this.g.getYChartMin()) * factor;
                Path path = new Path();
                for (int i2 = 0; i2 < ((com.github.mikephil.charting.data.r) this.g.getData()).n(); i2++) {
                    PointF pointFA = com.github.mikephil.charting.i.f.a(centerOffsets, fA, (i2 * sliceAngle) + this.g.getRotationAngle());
                    if (i2 == 0) {
                        path.moveTo(pointFA.x, pointFA.y);
                    } else {
                        path.lineTo(pointFA.x, pointFA.y);
                    }
                }
                path.close();
                canvas.drawPath(path, this.f5021e);
            }
        }
    }
}
