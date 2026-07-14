package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.RadarChart;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class r extends o {
    private RadarChart h;

    public r(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.f fVar, RadarChart radarChart) {
        super(gVar, fVar, null);
        this.h = radarChart;
    }

    @Override // com.github.mikephil.charting.h.o
    public void a(Canvas canvas) {
        if (this.f5056f.q() && this.f5056f.g()) {
            float fS = this.f5056f.s();
            PointF pointF = new PointF(0.5f, BitmapDescriptorFactory.HUE_RED);
            this.f5019c.setTypeface(this.f5056f.n());
            this.f5019c.setTextSize(this.f5056f.o());
            this.f5019c.setColor(this.f5056f.p());
            float sliceAngle = this.h.getSliceAngle();
            float factor = this.h.getFactor();
            PointF centerOffsets = this.h.getCenterOffsets();
            int i = this.f5056f.r;
            for (int i2 = 0; i2 < this.f5056f.w().size(); i2 += i) {
                String str = this.f5056f.w().get(i2);
                PointF pointFA = com.github.mikephil.charting.i.f.a(centerOffsets, (this.h.getYRange() * factor) + (this.f5056f.o / 2.0f), ((i2 * sliceAngle) + this.h.getRotationAngle()) % 360.0f);
                a(canvas, str, i2, pointFA.x, pointFA.y - (this.f5056f.p / 2.0f), pointF, fS);
            }
        }
    }

    @Override // com.github.mikephil.charting.h.o
    public void d(Canvas canvas) {
    }
}
