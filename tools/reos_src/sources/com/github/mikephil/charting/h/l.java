package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected RadarChart f5051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint f5052b;

    public l(RadarChart radarChart, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(aVar, gVar);
        this.f5051a = radarChart;
        this.g = new Paint(1);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(2.0f);
        this.g.setColor(Color.rgb(255, 187, 115));
        this.f5052b = new Paint(1);
        this.f5052b.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.h.f
    public void a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        for (com.github.mikephil.charting.data.s sVar : ((com.github.mikephil.charting.data.r) this.f5051a.getData()).m()) {
            if (sVar.r() && sVar.j() > 0) {
                a(canvas, sVar);
            }
        }
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.s sVar) {
        float sliceAngle = this.f5051a.getSliceAngle();
        float factor = this.f5051a.getFactor();
        PointF centerOffsets = this.f5051a.getCenterOffsets();
        List<T> listK = sVar.k();
        Path path = new Path();
        boolean z = false;
        for (int i = 0; i < listK.size(); i++) {
            this.f5036f.setColor(sVar.f(i));
            PointF pointFA = com.github.mikephil.charting.i.f.a(centerOffsets, (((Entry) listK.get(i)).b() - this.f5051a.getYChartMin()) * factor, (i * sliceAngle) + this.f5051a.getRotationAngle());
            if (!Float.isNaN(pointFA.x)) {
                if (z) {
                    path.lineTo(pointFA.x, pointFA.y);
                } else {
                    path.moveTo(pointFA.x, pointFA.y);
                    z = true;
                }
            }
        }
        path.close();
        if (sVar.I()) {
            this.f5036f.setStyle(Paint.Style.FILL);
            this.f5036f.setAlpha(sVar.G());
            canvas.drawPath(path, this.f5036f);
            this.f5036f.setAlpha(255);
        }
        this.f5036f.setStrokeWidth(sVar.H());
        this.f5036f.setStyle(Paint.Style.STROKE);
        if (!sVar.I() || sVar.G() < 255) {
            canvas.drawPath(path, this.f5036f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        int iB;
        Entry entryC;
        float sliceAngle = this.f5051a.getSliceAngle();
        float factor = this.f5051a.getFactor();
        PointF centerOffsets = this.f5051a.getCenterOffsets();
        for (int i = 0; i < dVarArr.length; i++) {
            com.github.mikephil.charting.data.o oVar = (com.github.mikephil.charting.data.s) ((com.github.mikephil.charting.data.r) this.f5051a.getData()).a(dVarArr[i].a());
            if (oVar != null && oVar.x() && (entryC = oVar.c((iB = dVarArr[i].b()))) != null && entryC.f() == iB) {
                int iA = oVar.a(entryC);
                float fB = entryC.b() - this.f5051a.getYChartMin();
                if (!Float.isNaN(fB)) {
                    PointF pointFA = com.github.mikephil.charting.i.f.a(centerOffsets, fB * factor, (iA * sliceAngle) + this.f5051a.getRotationAngle());
                    a(canvas, new float[]{pointFA.x, pointFA.y}, oVar);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        float sliceAngle = this.f5051a.getSliceAngle();
        float factor = this.f5051a.getFactor();
        PointF centerOffsets = this.f5051a.getCenterOffsets();
        float fA = com.github.mikephil.charting.i.f.a(5.0f);
        for (int i = 0; i < ((com.github.mikephil.charting.data.r) this.f5051a.getData()).f(); i++) {
            com.github.mikephil.charting.data.s sVarA = ((com.github.mikephil.charting.data.r) this.f5051a.getData()).a(i);
            if (sVarA.t() && sVarA.j() != 0) {
                a(sVarA);
                List<T> listK = sVarA.k();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < listK.size()) {
                        Entry entry = (Entry) listK.get(i3);
                        PointF pointFA = com.github.mikephil.charting.i.f.a(centerOffsets, (entry.b() - this.f5051a.getYChartMin()) * factor, (i3 * sliceAngle) + this.f5051a.getRotationAngle());
                        a(canvas, sVarA.y(), entry.b(), entry, i, pointFA.x, pointFA.y - fA);
                        i2 = i3 + 1;
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void c(Canvas canvas) {
        d(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void d(Canvas canvas) {
        float sliceAngle = this.f5051a.getSliceAngle();
        float factor = this.f5051a.getFactor();
        float rotationAngle = this.f5051a.getRotationAngle();
        PointF centerOffsets = this.f5051a.getCenterOffsets();
        this.f5052b.setStrokeWidth(this.f5051a.getWebLineWidth());
        this.f5052b.setColor(this.f5051a.getWebColor());
        this.f5052b.setAlpha(this.f5051a.getWebAlpha());
        int skipWebLineCount = this.f5051a.getSkipWebLineCount() + 1;
        for (int i = 0; i < ((com.github.mikephil.charting.data.r) this.f5051a.getData()).n(); i += skipWebLineCount) {
            PointF pointFA = com.github.mikephil.charting.i.f.a(centerOffsets, this.f5051a.getYRange() * factor, (i * sliceAngle) + rotationAngle);
            canvas.drawLine(centerOffsets.x, centerOffsets.y, pointFA.x, pointFA.y, this.f5052b);
        }
        this.f5052b.setStrokeWidth(this.f5051a.getWebLineWidthInner());
        this.f5052b.setColor(this.f5051a.getWebColorInner());
        this.f5052b.setAlpha(this.f5051a.getWebAlpha());
        int i2 = this.f5051a.getYAxis().n;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < ((com.github.mikephil.charting.data.r) this.f5051a.getData()).n(); i4++) {
                float yChartMin = (this.f5051a.getYAxis().m[i3] - this.f5051a.getYChartMin()) * factor;
                PointF pointFA2 = com.github.mikephil.charting.i.f.a(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle);
                PointF pointFA3 = com.github.mikephil.charting.i.f.a(centerOffsets, yChartMin, ((i4 + 1) * sliceAngle) + rotationAngle);
                canvas.drawLine(pointFA2.x, pointFA2.y, pointFA3.x, pointFA3.y, this.f5052b);
            }
        }
    }
}
