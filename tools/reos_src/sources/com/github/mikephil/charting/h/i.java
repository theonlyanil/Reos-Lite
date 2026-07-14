package com.github.mikephil.charting.h;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.github.mikephil.charting.f.f f5042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint f5043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Bitmap f5044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Canvas f5045d;
    protected Path j;
    protected Path k;
    protected com.github.mikephil.charting.b.g[] l;
    protected com.github.mikephil.charting.b.e[] m;

    public i(com.github.mikephil.charting.f.f fVar, com.github.mikephil.charting.a.a aVar, com.github.mikephil.charting.i.g gVar) {
        super(aVar, gVar);
        this.j = new Path();
        this.k = new Path();
        this.f5042a = fVar;
        this.f5043b = new Paint(1);
        this.f5043b.setStyle(Paint.Style.FILL);
        this.f5043b.setColor(-1);
    }

    private Path a(List<Entry> list, float f2, int i, int i2) {
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        Path path = new Path();
        path.moveTo(list.get(i).f(), f2);
        path.lineTo(list.get(i).f(), list.get(i).b() * fA);
        int iCeil = (int) Math.ceil(((i2 - i) * fB) + i);
        for (int i3 = i + 1; i3 < iCeil; i3++) {
            Entry entry = list.get(i3);
            path.lineTo(entry.f(), entry.b() * fA);
        }
        path.lineTo(list.get(Math.max(Math.min(((int) Math.ceil(((i2 - i) * fB) + i)) - 1, list.size() - 1), 0)).f(), f2);
        path.close();
        return path;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a() {
        com.github.mikephil.charting.data.l lineData = this.f5042a.getLineData();
        this.l = new com.github.mikephil.charting.b.g[lineData.f()];
        this.m = new com.github.mikephil.charting.b.e[lineData.f()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l.length) {
                return;
            }
            com.github.mikephil.charting.data.m mVar = (com.github.mikephil.charting.data.m) lineData.a(i2);
            this.l[i2] = new com.github.mikephil.charting.b.g((mVar.j() * 4) - 4);
            this.m[i2] = new com.github.mikephil.charting.b.e(mVar.j() * 2);
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas) {
        int iN = (int) this.n.n();
        int iM = (int) this.n.m();
        if (this.f5044c == null || this.f5044c.getWidth() != iN || this.f5044c.getHeight() != iM) {
            if (iN <= 0 || iM <= 0) {
                return;
            }
            this.f5044c = Bitmap.createBitmap(iN, iM, Bitmap.Config.ARGB_4444);
            this.f5045d = new Canvas(this.f5044c);
        }
        this.f5044c.eraseColor(0);
        for (T t : this.f5042a.getLineData().m()) {
            if (t.r() && t.j() > 0) {
                a(canvas, t);
            }
        }
        canvas.drawBitmap(this.f5044c, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.f5036f);
    }

    protected void a(Canvas canvas, Path path, int i, int i2) {
        canvas.save();
        canvas.clipPath(path);
        canvas.drawColor((i2 << 24) | (16777215 & i));
        canvas.restore();
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.m mVar) {
        List<Entry> listK = mVar.k();
        if (listK.size() < 1) {
            return;
        }
        this.f5036f.setStrokeWidth(mVar.H());
        this.f5036f.setPathEffect(mVar.d());
        if (mVar.f()) {
            a(canvas, mVar, listK);
        } else {
            b(canvas, mVar, listK);
        }
        this.f5036f.setPathEffect(null);
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.m mVar, Path path, com.github.mikephil.charting.i.d dVar, int i, int i2) {
        if (i2 - i <= 1) {
            return;
        }
        float fA = mVar.E().a(mVar, this.f5042a);
        path.lineTo(i2 - 1, fA);
        path.lineTo(i, fA);
        path.close();
        dVar.a(path);
        a(canvas, path, mVar.F(), mVar.G());
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.m mVar, List<Entry> list) {
        com.github.mikephil.charting.i.d dVarA = this.f5042a.a(mVar.s());
        Entry entryC = mVar.c(this.o);
        Entry entryC2 = mVar.c(this.p);
        int iMax = Math.max(mVar.a(entryC) - (entryC == entryC2 ? 1 : 0), 0);
        int iMin = Math.min(Math.max(iMax + 2, mVar.a(entryC2) + 1), list.size());
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        float fA2 = mVar.a();
        this.j.reset();
        int iCeil = (int) Math.ceil(((iMin - iMax) * fB) + iMax);
        if (iCeil - iMax >= 2) {
            list.get(iMax);
            Entry entry = list.get(iMax);
            Entry entry2 = list.get(iMax);
            Entry entry3 = list.get(iMax + 1);
            this.j.moveTo(entry2.f(), entry2.b() * fA);
            this.j.cubicTo(((entry2.f() - entry.f()) * fA2) + entry.f(), (entry.b() + ((entry2.b() - entry.b()) * fA2)) * fA, entry2.f() - ((entry3.f() - entry2.f()) * fA2), (entry2.b() - ((entry3.b() - entry2.b()) * fA2)) * fA, entry2.f(), entry2.b() * fA);
            int iMin2 = Math.min(iCeil, list.size() - 1);
            int i = iMax + 1;
            while (i < iMin2) {
                Entry entry4 = list.get(i == 1 ? 0 : i - 2);
                Entry entry5 = list.get(i - 1);
                Entry entry6 = list.get(i);
                Entry entry7 = list.get(i + 1);
                this.j.cubicTo(entry5.f() + ((entry6.f() - entry4.f()) * fA2), (entry5.b() + ((entry6.b() - entry4.b()) * fA2)) * fA, entry6.f() - ((entry7.f() - entry5.f()) * fA2), (entry6.b() - ((entry7.b() - entry5.b()) * fA2)) * fA, entry6.f(), entry6.b() * fA);
                i++;
            }
            if (iCeil > list.size() - 1) {
                Entry entry8 = list.get(list.size() >= 3 ? list.size() - 3 : list.size() - 2);
                Entry entry9 = list.get(list.size() - 2);
                Entry entry10 = list.get(list.size() - 1);
                this.j.cubicTo(((entry10.f() - entry8.f()) * fA2) + entry9.f(), (entry9.b() + ((entry10.b() - entry8.b()) * fA2)) * fA, entry10.f() - ((entry10.f() - entry9.f()) * fA2), (entry10.b() - ((entry10.b() - entry9.b()) * fA2)) * fA, entry10.f(), entry10.b() * fA);
            }
        }
        if (mVar.I()) {
            this.k.reset();
            this.k.addPath(this.j);
            a(this.f5045d, mVar, this.k, dVarA, entryC.f(), entryC.f() + iCeil);
        }
        this.f5036f.setColor(mVar.v());
        this.f5036f.setStyle(Paint.Style.STROKE);
        dVarA.a(this.j);
        this.f5045d.drawPath(this.j, this.f5036f);
        this.f5036f.setPathEffect(null);
    }

    protected void a(Canvas canvas, com.github.mikephil.charting.data.m mVar, List<Entry> list, int i, int i2, com.github.mikephil.charting.i.d dVar) {
        Path pathA = a(list, mVar.E().a(mVar, this.f5042a), i, i2);
        dVar.a(pathA);
        a(canvas, pathA, mVar.F(), mVar.G());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.h.f
    public void a(Canvas canvas, com.github.mikephil.charting.e.d[] dVarArr) {
        for (int i = 0; i < dVarArr.length; i++) {
            com.github.mikephil.charting.data.m mVar = (com.github.mikephil.charting.data.m) this.f5042a.getLineData().a(dVarArr[i].a());
            if (mVar != null && mVar.x()) {
                int iB = dVarArr[i].b();
                if (iB <= this.f5042a.getXChartMax() * this.f5035e.b()) {
                    float fB = mVar.b(iB);
                    if (fB != Float.NaN) {
                        float[] fArr = {iB, fB * this.f5035e.a()};
                        this.f5042a.a(mVar.s()).a(fArr);
                        a(canvas, fArr, mVar);
                    }
                }
            }
        }
    }

    public void b() {
        if (this.f5044c != null) {
            this.f5044c.recycle();
            this.f5044c = null;
        }
    }

    @Override // com.github.mikephil.charting.h.f
    public void b(Canvas canvas) {
        if (this.f5042a.getLineData().k() < this.f5042a.getMaxVisibleCount() * this.n.p()) {
            List<T> listM = this.f5042a.getLineData().m();
            for (int i = 0; i < listM.size(); i++) {
                com.github.mikephil.charting.data.m mVar = (com.github.mikephil.charting.data.m) listM.get(i);
                if (mVar.t() && mVar.j() != 0) {
                    a(mVar);
                    com.github.mikephil.charting.i.d dVarA = this.f5042a.a(mVar.s());
                    int iB = (int) (mVar.b() * 1.75f);
                    int i2 = !mVar.e() ? iB / 2 : iB;
                    List<? extends Entry> listK = mVar.k();
                    Entry entryC = mVar.c(this.o);
                    Entry entryC2 = mVar.c(this.p);
                    int iMax = Math.max(mVar.a(entryC) - (entryC == entryC2 ? 1 : 0), 0);
                    float[] fArrB = dVarA.b(listK, this.f5035e.b(), this.f5035e.a(), iMax, Math.min(Math.max(iMax + 2, mVar.a(entryC2) + 1), listK.size()));
                    for (int i3 = 0; i3 < fArrB.length; i3 += 2) {
                        float f2 = fArrB[i3];
                        float f3 = fArrB[i3 + 1];
                        if (!this.n.f(f2)) {
                            break;
                        }
                        if (this.n.e(f2) && this.n.d(f3)) {
                            Entry entry = listK.get((i3 / 2) + iMax);
                            a(canvas, mVar.y(), entry.b(), entry, i, f2, f3 - i2);
                        }
                    }
                }
            }
        }
    }

    protected void b(Canvas canvas, com.github.mikephil.charting.data.m mVar, List<Entry> list) {
        int iA = this.f5042a.getLineData().a(mVar);
        com.github.mikephil.charting.i.d dVarA = this.f5042a.a(mVar.s());
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        this.f5036f.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = mVar.c() ? this.f5045d : canvas;
        Entry entryC = mVar.c(this.o);
        Entry entryC2 = mVar.c(this.p);
        int iMax = Math.max(mVar.a(entryC) - (entryC == entryC2 ? 1 : 0), 0);
        int iMin = Math.min(Math.max(iMax + 2, mVar.a(entryC2) + 1), list.size());
        int i = ((iMin - iMax) * 4) - 4;
        com.github.mikephil.charting.b.g gVar = this.l[iA];
        gVar.a(fB, fA);
        gVar.a(iMax);
        gVar.b(iMin);
        gVar.a(list);
        dVarA.a(gVar.f4849b);
        if (mVar.u().size() > 1) {
            for (int i2 = 0; i2 < i && this.n.f(gVar.f4849b[i2]); i2 += 4) {
                if (this.n.e(gVar.f4849b[i2 + 2]) && ((this.n.g(gVar.f4849b[i2 + 1]) || this.n.h(gVar.f4849b[i2 + 3])) && (this.n.g(gVar.f4849b[i2 + 1]) || this.n.h(gVar.f4849b[i2 + 3])))) {
                    this.f5036f.setColor(mVar.f((i2 / 4) + iMax));
                    canvas2.drawLine(gVar.f4849b[i2], gVar.f4849b[i2 + 1], gVar.f4849b[i2 + 2], gVar.f4849b[i2 + 3], this.f5036f);
                }
            }
        } else {
            this.f5036f.setColor(mVar.v());
            canvas2.drawLines(gVar.f4849b, 0, i, this.f5036f);
        }
        this.f5036f.setPathEffect(null);
        if (!mVar.I() || list.size() <= 0) {
            return;
        }
        a(canvas, mVar, list, iMax, iMin, dVarA);
    }

    @Override // com.github.mikephil.charting.h.f
    public void c(Canvas canvas) {
        d(canvas);
    }

    protected void d(Canvas canvas) {
        this.f5036f.setStyle(Paint.Style.FILL);
        float fB = this.f5035e.b();
        float fA = this.f5035e.a();
        List<T> listM = this.f5042a.getLineData().m();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listM.size()) {
                return;
            }
            com.github.mikephil.charting.data.m mVar = (com.github.mikephil.charting.data.m) listM.get(i2);
            if (mVar.r() && mVar.e() && mVar.j() != 0) {
                this.f5043b.setColor(mVar.i());
                com.github.mikephil.charting.i.d dVarA = this.f5042a.a(mVar.s());
                List<Entry> listK = mVar.k();
                Entry entryC = mVar.c(this.o < 0 ? 0 : this.o);
                Entry entryC2 = mVar.c(this.p);
                int iMax = Math.max(mVar.a(entryC) - (entryC == entryC2 ? 1 : 0), 0);
                int iMin = Math.min(Math.max(iMax + 2, mVar.a(entryC2) + 1), listK.size());
                com.github.mikephil.charting.b.e eVar = this.m[i2];
                eVar.a(fB, fA);
                eVar.a(iMax);
                eVar.b(iMin);
                eVar.a(listK);
                dVarA.a(eVar.f4849b);
                float fB2 = mVar.b() / 2.0f;
                int iCeil = ((int) Math.ceil(((iMin - iMax) * fB) + iMax)) * 2;
                for (int i3 = 0; i3 < iCeil; i3 += 2) {
                    float f2 = eVar.f4849b[i3];
                    float f3 = eVar.f4849b[i3 + 1];
                    if (!this.n.f(f2)) {
                        break;
                    }
                    if (this.n.e(f2) && this.n.d(f3)) {
                        int iG = mVar.g((i3 / 2) + iMax);
                        this.f5036f.setColor(iG);
                        canvas.drawCircle(f2, f3, mVar.b(), this.f5036f);
                        if (mVar.D() && iG != this.f5043b.getColor()) {
                            canvas.drawCircle(f2, f3, fB2, this.f5043b);
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }
}
