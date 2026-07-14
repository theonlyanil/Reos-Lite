package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.BarChart;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class p extends o {
    protected BarChart h;

    public p(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.f fVar, com.github.mikephil.charting.i.d dVar, BarChart barChart) {
        super(gVar, fVar, dVar);
        this.h = barChart;
    }

    @Override // com.github.mikephil.charting.h.o
    protected void a(Canvas canvas, float f2, PointF pointF) {
        float fS = this.f5056f.s();
        float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        com.github.mikephil.charting.data.a aVar = (com.github.mikephil.charting.data.a) this.h.getData();
        int iF = aVar.f();
        int i = this.o;
        while (i <= this.p) {
            fArr[0] = (i * iF) + (i * aVar.a()) + (aVar.a() / 2.0f);
            if (iF > 1) {
                fArr[0] = fArr[0] + ((iF - 1.0f) / 2.0f);
            }
            this.f5017a.a(fArr);
            if (this.n.c(fArr[0]) && i >= 0 && i < this.f5056f.w().size()) {
                String str = this.f5056f.w().get(i);
                if (this.f5056f.v()) {
                    if (i == this.f5056f.w().size() - 1) {
                        float fA = com.github.mikephil.charting.i.f.a(this.f5019c, str);
                        if (fArr[0] + (fA / 2.0f) > this.n.g()) {
                            fArr[0] = this.n.g() - (fA / 2.0f);
                        }
                    } else if (i == 0) {
                        float fA2 = com.github.mikephil.charting.i.f.a(this.f5019c, str);
                        if (fArr[0] - (fA2 / 2.0f) < this.n.f()) {
                            fArr[0] = (fA2 / 2.0f) + this.n.f();
                        }
                    }
                }
                a(canvas, str, i, fArr[0], f2, pointF, fS);
            }
            i += this.f5056f.r;
        }
    }

    @Override // com.github.mikephil.charting.h.o
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
            if (i2 >= this.p) {
                return;
            }
            fArr[0] = ((i2 * iF) + (i2 * aVar.a())) - 0.5f;
            this.f5017a.a(fArr);
            if (this.n.c(fArr[0])) {
                canvas.drawLine(fArr[0], this.n.c(), fArr[0], this.n.h(), this.f5018b);
            }
            i = this.f5056f.r + i2;
        }
    }
}
