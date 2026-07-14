package com.github.mikephil.charting.i;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected g f5067c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Matrix f5065a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Matrix f5066b = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Matrix f5068d = new Matrix();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Matrix f5069e = new Matrix();

    public d(g gVar) {
        this.f5067c = gVar;
    }

    public Matrix a() {
        this.f5068d.set(this.f5065a);
        this.f5068d.postConcat(this.f5067c.f5075a);
        this.f5068d.postConcat(this.f5066b);
        return this.f5068d;
    }

    public b a(float f2, float f3) {
        float[] fArr = {f2, f3};
        b(fArr);
        return new b(fArr[0], fArr[1]);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float fI = this.f5067c.i() / f3;
        float fJ = this.f5067c.j() / f4;
        this.f5065a.reset();
        this.f5065a.postTranslate(-f2, -f5);
        this.f5065a.postScale(fI, -fJ);
    }

    public void a(Path path) {
        path.transform(this.f5065a);
        path.transform(this.f5067c.o());
        path.transform(this.f5066b);
    }

    public void a(RectF rectF, float f2) {
        rectF.top *= f2;
        rectF.bottom *= f2;
        this.f5065a.mapRect(rectF);
        this.f5067c.o().mapRect(rectF);
        this.f5066b.mapRect(rectF);
    }

    public void a(boolean z) {
        this.f5066b.reset();
        if (!z) {
            this.f5066b.postTranslate(this.f5067c.a(), this.f5067c.m() - this.f5067c.d());
        } else {
            this.f5066b.setTranslate(this.f5067c.a(), -this.f5067c.c());
            this.f5066b.postScale(1.0f, -1.0f);
        }
    }

    public void a(float[] fArr) {
        this.f5065a.mapPoints(fArr);
        this.f5067c.o().mapPoints(fArr);
        this.f5066b.mapPoints(fArr);
    }

    public float[] a(List<? extends Entry> list, float f2) {
        float[] fArr = new float[list.size() * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                a().mapPoints(fArr);
                return fArr;
            }
            Entry entry = list.get(i2 / 2);
            if (entry != null) {
                fArr[i2] = entry.f();
                fArr[i2 + 1] = entry.b() * f2;
            }
            i = i2 + 2;
        }
    }

    public float[] a(List<? extends Entry> list, float f2, float f3, int i, int i2) {
        int iCeil = ((int) Math.ceil(i2 - i)) * 2;
        float[] fArr = new float[iCeil];
        for (int i3 = 0; i3 < iCeil; i3 += 2) {
            Entry entry = list.get((i3 / 2) + i);
            if (entry != null) {
                fArr[i3] = ((entry.f() - i) * f2) + i;
                fArr[i3 + 1] = entry.b() * f3;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }

    public float[] a(List<? extends Entry> list, int i, com.github.mikephil.charting.data.a aVar, float f2) {
        float[] fArr = new float[list.size() * 2];
        int iF = aVar.f();
        float fA = aVar.a();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fArr.length) {
                a().mapPoints(fArr);
                return fArr;
            }
            Entry entry = list.get(i3 / 2);
            int iF2 = entry.f();
            float f3 = entry.f() + ((iF - 1) * iF2) + i;
            float fB = entry.b();
            fArr[i3] = (iF2 * fA) + f3 + (fA / 2.0f);
            fArr[i3 + 1] = fB * f2;
            i2 = i3 + 2;
        }
    }

    public Matrix b() {
        a().invert(this.f5069e);
        return this.f5069e;
    }

    public void b(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.right *= f2;
        this.f5065a.mapRect(rectF);
        this.f5067c.o().mapRect(rectF);
        this.f5066b.mapRect(rectF);
    }

    public void b(float[] fArr) {
        Matrix matrix = new Matrix();
        this.f5066b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f5067c.o().invert(matrix);
        matrix.mapPoints(fArr);
        this.f5065a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public float[] b(List<? extends Entry> list, float f2, float f3, int i, int i2) {
        int iCeil = ((int) Math.ceil((i2 - i) * f2)) * 2;
        float[] fArr = new float[iCeil];
        for (int i3 = 0; i3 < iCeil; i3 += 2) {
            Entry entry = list.get((i3 / 2) + i);
            if (entry != null) {
                fArr[i3] = entry.f();
                fArr[i3 + 1] = entry.b() * f3;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }

    public float[] b(List<? extends Entry> list, int i, com.github.mikephil.charting.data.a aVar, float f2) {
        float[] fArr = new float[list.size() * 2];
        int iF = aVar.f();
        float fA = aVar.a();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fArr.length) {
                a().mapPoints(fArr);
                return fArr;
            }
            Entry entry = list.get(i3 / 2);
            int iF2 = entry.f();
            fArr[i3] = entry.b() * f2;
            fArr[i3 + 1] = (iF2 * fA) + ((iF - 1) * iF2) + iF2 + i + (fA / 2.0f);
            i2 = i3 + 2;
        }
    }

    public float[] c(List<CandleEntry> list, float f2, float f3, int i, int i2) {
        int iCeil = ((int) Math.ceil((i2 - i) * f2)) * 2;
        float[] fArr = new float[iCeil];
        for (int i3 = 0; i3 < iCeil; i3 += 2) {
            CandleEntry candleEntry = list.get((i3 / 2) + i);
            if (candleEntry != null) {
                fArr[i3] = candleEntry.f();
                fArr[i3 + 1] = candleEntry.a() * f3;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }
}
