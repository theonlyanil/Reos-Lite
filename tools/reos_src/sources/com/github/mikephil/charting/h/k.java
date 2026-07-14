package com.github.mikephil.charting.h;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected PieChart f5047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint f5048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f5049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Bitmap f5050d;
    protected Canvas j;
    private TextPaint k;
    private StaticLayout l;
    private SpannableString m;
    private RectF q;
    private RectF[] r;

    public k(PieChart pieChart, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(aVar, gVar);
        this.q = new RectF();
        this.r = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.f5047a = pieChart;
        this.f5048b = new Paint(1);
        this.f5048b.setColor(-1);
        this.f5048b.setStyle(Paint.Style.FILL);
        this.f5049c = new Paint(1);
        this.f5049c.setColor(-1);
        this.f5049c.setStyle(Paint.Style.FILL);
        this.f5049c.setAlpha(105);
        this.k = new TextPaint(1);
        this.k.setColor(-16777216);
        this.k.setTextSize(com.github.mikephil.charting.i.f.a(12.0f));
        this.i.setTextSize(com.github.mikephil.charting.i.f.a(13.0f));
        this.i.setColor(-1);
        this.i.setTextAlign(Paint.Align.CENTER);
    }

    @Override // com.github.mikephil.charting.h.f
    public void a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        int iN = (int) this.n.n();
        int iM = (int) this.n.m();
        if (this.f5050d == null || this.f5050d.getWidth() != iN || this.f5050d.getHeight() != iM) {
            if (iN <= 0 || iM <= 0) {
                return;
            }
            this.f5050d = Bitmap.createBitmap(iN, iM, Bitmap.Config.ARGB_4444);
            this.j = new Canvas(this.f5050d);
        }
        this.f5050d.eraseColor(0);
        for (com.github.mikephil.charting.data.q qVar : ((com.github.mikephil.charting.data.p) this.f5047a.getData()).m()) {
            if (qVar.r() && qVar.j() > 0) {
                a(canvas, qVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void a(Canvas canvas, com.github.mikephil.charting.data.q qVar) {
        float rotationAngle = this.f5047a.getRotationAngle();
        List<Entry> listK = qVar.k();
        float[] drawAngles = this.f5047a.getDrawAngles();
        int i = 0;
        while (true) {
            int i2 = i;
            float f2 = rotationAngle;
            if (i2 >= listK.size()) {
                return;
            }
            float f3 = drawAngles[i2];
            float fA = qVar.a();
            Entry entry = listK.get(i2);
            if (Math.abs(entry.b()) > 1.0E-6d && !this.f5047a.a(entry.f(), ((com.github.mikephil.charting.data.p) this.f5047a.getData()).a(qVar))) {
                this.f5036f.setColor(qVar.f(i2));
                this.j.drawArc(this.f5047a.getCircleBox(), ((fA / 2.0f) + f2) * this.f5035e.a(), (f3 - (fA / 2.0f)) * this.f5035e.a(), true, this.f5036f);
            }
            rotationAngle = f2 + (this.f5035e.b() * f3);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        com.github.mikephil.charting.data.q qVarA;
        float rotationAngle = this.f5047a.getRotationAngle();
        float[] drawAngles = this.f5047a.getDrawAngles();
        float[] absoluteAngles = this.f5047a.getAbsoluteAngles();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dVarArr.length) {
                return;
            }
            int iB = dVarArr[i2].b();
            if (iB < drawAngles.length && (qVarA = ((com.github.mikephil.charting.data.p) this.f5047a.getData()).a(dVarArr[i2].a())) != null && qVarA.x()) {
                float fA = (iB == 0 ? rotationAngle : absoluteAngles[iB - 1] + rotationAngle) * this.f5035e.a();
                float f2 = drawAngles[iB];
                float fB = qVarA.b();
                RectF circleBox = this.f5047a.getCircleBox();
                RectF rectF = new RectF(circleBox.left - fB, circleBox.top - fB, circleBox.right + fB, fB + circleBox.bottom);
                this.f5036f.setColor(qVarA.f(iB));
                this.j.drawArc(rectF, (qVarA.a() / 2.0f) + fA, (this.f5035e.a() * f2) - (qVarA.a() / 2.0f), true, this.f5036f);
            }
            i = i2 + 1;
        }
    }

    public Paint b() {
        return this.f5048b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        PointF centerCircleBox = this.f5047a.getCenterCircleBox();
        float radius = this.f5047a.getRadius();
        float rotationAngle = this.f5047a.getRotationAngle();
        float[] drawAngles = this.f5047a.getDrawAngles();
        float[] absoluteAngles = this.f5047a.getAbsoluteAngles();
        float holeRadius = (radius / 10.0f) * 3.6f;
        if (this.f5047a.d()) {
            holeRadius = (radius - ((radius / 100.0f) * this.f5047a.getHoleRadius())) / 2.0f;
        }
        float f2 = radius - holeRadius;
        com.github.mikephil.charting.data.p pVar = (com.github.mikephil.charting.data.p) this.f5047a.getData();
        List<com.github.mikephil.charting.data.q> listM = pVar.m();
        boolean zF = this.f5047a.f();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= listM.size()) {
                return;
            }
            com.github.mikephil.charting.data.q qVar = listM.get(i3);
            if (qVar.t() || zF) {
                a(qVar);
                float fB = com.github.mikephil.charting.i.f.b(this.i, "Q") + com.github.mikephil.charting.i.f.a(4.0f);
                List<Entry> listK = qVar.k();
                int iMin = Math.min((int) Math.ceil(listK.size() * this.f5035e.b()), listK.size());
                int i4 = i;
                for (int i5 = 0; i5 < iMin; i5++) {
                    Entry entry = listK.get(i5);
                    float f3 = drawAngles[i4] / 2.0f;
                    float fCos = (float) ((((double) f2) * Math.cos(Math.toRadians(((absoluteAngles[i4] + rotationAngle) - f3) * this.f5035e.a()))) + ((double) centerCircleBox.x));
                    float fSin = (float) ((Math.sin(Math.toRadians(((absoluteAngles[i4] + rotationAngle) - f3) * this.f5035e.a())) * ((double) f2)) + ((double) centerCircleBox.y));
                    float fB2 = this.f5047a.g() ? (entry.b() / pVar.j()) * 100.0f : entry.b();
                    com.github.mikephil.charting.d.f fVarY = qVar.y();
                    boolean zT = qVar.t();
                    if (zF && zT) {
                        a(canvas, fVarY, fB2, entry, 0, fCos, fSin);
                        if (i5 < pVar.n()) {
                            canvas.drawText(pVar.l().get(i5), fCos, fSin + fB, this.i);
                        }
                    } else if (!zF || zT) {
                        if (!zF && zT) {
                            a(canvas, fVarY, fB2, entry, 0, fCos, fSin + (fB / 2.0f));
                        }
                    } else if (i5 < pVar.n()) {
                        canvas.drawText(pVar.l().get(i5), fCos, (fB / 2.0f) + fSin, this.i);
                    }
                    i4++;
                }
                i = i4;
            }
            i2 = i3 + 1;
        }
    }

    public Paint c() {
        return this.f5049c;
    }

    @Override // com.github.mikephil.charting.h.f
    public void c(Canvas canvas) {
        d(canvas);
        canvas.drawBitmap(this.f5050d, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.f5036f);
        e(canvas);
    }

    public TextPaint d() {
        return this.k;
    }

    protected void d(Canvas canvas) {
        if (this.f5047a.d()) {
            float transparentCircleRadius = this.f5047a.getTransparentCircleRadius();
            float holeRadius = this.f5047a.getHoleRadius();
            float radius = this.f5047a.getRadius();
            PointF centerCircleBox = this.f5047a.getCenterCircleBox();
            if (transparentCircleRadius > holeRadius) {
                int alpha = this.f5049c.getAlpha();
                this.f5049c.setAlpha((int) (alpha * this.f5035e.b() * this.f5035e.a()));
                this.j.drawCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius * (radius / 100.0f), this.f5049c);
                this.f5049c.setAlpha(alpha);
            }
            this.j.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius * (radius / 100.0f), this.f5048b);
        }
    }

    public void e() {
        if (this.f5050d != null) {
            this.f5050d.recycle();
            this.f5050d = null;
        }
    }

    protected void e(Canvas canvas) {
        SpannableString centerText = this.f5047a.getCenterText();
        if (!this.f5047a.e() || centerText == null) {
            return;
        }
        PointF centerCircleBox = this.f5047a.getCenterCircleBox();
        float radius = (this.f5047a.d() && this.f5047a.c()) ? this.f5047a.getRadius() * (this.f5047a.getHoleRadius() / 100.0f) : this.f5047a.getRadius();
        RectF rectF = this.r[0];
        rectF.left = centerCircleBox.x - radius;
        rectF.top = centerCircleBox.y - radius;
        rectF.right = centerCircleBox.x + radius;
        rectF.bottom = radius + centerCircleBox.y;
        RectF rectF2 = this.r[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.f5047a.getCenterTextRadiusPercent();
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (centerTextRadiusPercent * rectF2.height())) / 2.0f);
        }
        if (!centerText.equals(this.m) || !rectF2.equals(this.q)) {
            this.q.set(rectF2);
            this.m = centerText;
            this.l = new StaticLayout(centerText, 0, centerText.length(), this.k, (int) Math.max(Math.ceil(this.q.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, BitmapDescriptorFactory.HUE_RED, false);
        }
        float height = this.l.getHeight();
        canvas.save();
        canvas.translate(rectF2.left, ((rectF2.height() - height) / 2.0f) + rectF2.top);
        this.l.draw(canvas);
        canvas.restore();
    }
}
