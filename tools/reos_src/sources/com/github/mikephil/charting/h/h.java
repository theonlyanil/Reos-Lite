package com.github.mikephil.charting.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static /* synthetic */ int[] f5037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static /* synthetic */ int[] f5038e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Paint f5039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint f5040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.github.mikephil.charting.c.c f5041c;

    public h(com.github.mikephil.charting.i.g gVar, com.github.mikephil.charting.c.c cVar) {
        super(gVar);
        this.f5041c = cVar;
        this.f5039a = new Paint(1);
        this.f5039a.setTextSize(com.github.mikephil.charting.i.f.a(9.0f));
        this.f5039a.setTextAlign(Paint.Align.LEFT);
        this.f5040b = new Paint(1);
        this.f5040b.setStyle(Paint.Style.FILL);
        this.f5040b.setStrokeWidth(3.0f);
    }

    static /* synthetic */ int[] b() {
        int[] iArr = f5037d;
        if (iArr == null) {
            iArr = new int[com.github.mikephil.charting.c.c.EnumC0083c.valuesCustom().length];
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_CENTER.ordinal()] = 12;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART_INSIDE.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.PIECHART_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
            f5037d = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] c() {
        int[] iArr = f5038e;
        if (iArr == null) {
            iArr = new int[com.github.mikephil.charting.c.c.b.valuesCustom().length];
            try {
                iArr[com.github.mikephil.charting.c.c.b.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.b.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[com.github.mikephil.charting.c.c.b.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            f5038e = iArr;
        }
        return iArr;
    }

    public Paint a() {
        return this.f5039a;
    }

    /* JADX WARN: Code duplicated, block: B:169:0x03b0 A[PHI: r2
      0x03b0: PHI (r2v25 float) = (r2v23 float), (r2v74 float) binds: [B:52:0x019d, B:114:0x0293] A[DONT_GENERATE, DONT_INLINE]] */
    public void a(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int i;
        float f5;
        float f6;
        float f7;
        float f8;
        float fE;
        float fA;
        float f9;
        boolean z;
        float f10;
        if (this.f5041c.q()) {
            Typeface typefaceN = this.f5041c.n();
            if (typefaceN != null) {
                this.f5039a.setTypeface(typefaceN);
            }
            this.f5039a.setTextSize(this.f5041c.o());
            this.f5039a.setColor(this.f5041c.p());
            float fA2 = com.github.mikephil.charting.i.f.a(this.f5039a);
            float fB = com.github.mikephil.charting.i.f.b(this.f5039a) + this.f5041c.k();
            float fB2 = fA2 - (com.github.mikephil.charting.i.f.b(this.f5039a, "ABC") / 2.0f);
            String[] strArrB = this.f5041c.b();
            int[] iArrA = this.f5041c.a();
            float fR = this.f5041c.r();
            float fJ = this.f5041c.j();
            com.github.mikephil.charting.c.c.a aVarG = this.f5041c.g();
            float fI = this.f5041c.i();
            float fS = this.f5041c.s();
            float fM = this.f5041c.m();
            float fL = this.f5041c.l();
            com.github.mikephil.charting.c.c.EnumC0083c enumC0083cF = this.f5041c.f();
            switch (b()[enumC0083cF.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 13:
                    if (enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.PIECHART_CENTER) {
                        float fN = (this.n.n() / 2.0f) + (aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT ? (-this.f5041c.f4863d) / 2.0f : this.f5041c.f4863d / 2.0f);
                        fE = ((this.n.m() / 2.0f) - (this.f5041c.f4861b / 2.0f)) + this.f5041c.m();
                        f8 = fN;
                    } else {
                        if (enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART_CENTER || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART_INSIDE) {
                            fL = this.n.n() - fL;
                            if (aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT) {
                                fL -= this.f5041c.f4863d;
                            }
                        } else if (aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT) {
                            fL += this.f5041c.f4863d;
                        }
                        if (enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART) {
                            f8 = fL;
                            fE = this.n.e() + fM;
                        } else if (enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.RIGHT_OF_CHART_CENTER || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.LEFT_OF_CHART_CENTER) {
                            f8 = fL;
                            fE = (this.n.m() / 2.0f) - (this.f5041c.f4861b / 2.0f);
                        } else {
                            f8 = fL;
                            fE = this.n.e() + fM;
                        }
                    }
                    int i2 = 0;
                    boolean z2 = false;
                    float f11 = 0.0f;
                    float f12 = fE;
                    while (i2 < strArrB.length) {
                        Boolean boolValueOf = Boolean.valueOf(iArrA[i2] != -2);
                        if (boolValueOf.booleanValue()) {
                            fA = aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT ? f8 + f11 : f8 - (fI - f11);
                            a(canvas, fA, f12 + fB2, i2, this.f5041c);
                            if (aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT) {
                                fA += fI;
                            }
                        } else {
                            fA = f8;
                        }
                        if (strArrB[i2] != null) {
                            if (boolValueOf.booleanValue() && !z2) {
                                fA += aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT ? fR : -fR;
                            } else if (z2) {
                                fA = f8;
                            }
                            if (aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT) {
                                fA -= com.github.mikephil.charting.i.f.a(this.f5039a, strArrB[i2]);
                            }
                            if (z2) {
                                f12 += fA2 + fB;
                                a(canvas, fA, f12 + fA2, strArrB[i2]);
                            } else {
                                a(canvas, fA, f12 + fA2, strArrB[i2]);
                            }
                            f10 = f12 + fA2 + fB;
                            f9 = BitmapDescriptorFactory.HUE_RED;
                            z = z2;
                        } else {
                            f9 = f11 + fI + fS;
                            z = true;
                            f10 = f12;
                        }
                        i2++;
                        z2 = z;
                        f11 = f9;
                        f12 = f10;
                    }
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    float fI2 = this.n.i();
                    if (enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_LEFT || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_LEFT) {
                        f2 = fL + this.n.f();
                        if (aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT) {
                            f3 = f2 + this.f5041c.f4860a;
                        } else {
                            f3 = f2;
                        }
                    } else if (enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_RIGHT || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_RIGHT) {
                        f2 = this.n.g() - fL;
                        if (aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT) {
                            f3 = f2 - this.f5041c.f4860a;
                        } else {
                            f3 = f2;
                        }
                    } else {
                        f3 = this.n.f() + (fI2 / 2.0f);
                    }
                    com.github.mikephil.charting.i.a[] aVarArrW = this.f5041c.w();
                    com.github.mikephil.charting.i.a[] aVarArrU = this.f5041c.u();
                    Boolean[] boolArrV = this.f5041c.v();
                    float fM2 = (enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_LEFT || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_RIGHT || enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.ABOVE_CHART_CENTER) ? BitmapDescriptorFactory.HUE_RED : (this.n.m() - fM) - this.f5041c.f4861b;
                    int i3 = 0;
                    int i4 = 0;
                    int length = strArrB.length;
                    float f13 = f3;
                    while (i4 < length) {
                        if (i4 >= boolArrV.length || !boolArrV[i4].booleanValue()) {
                            f4 = fM2;
                        } else {
                            f4 = fM2 + fA2 + fB;
                            f13 = f3;
                        }
                        if (f13 == f3 && enumC0083cF == com.github.mikephil.charting.c.c.EnumC0083c.BELOW_CHART_CENTER && i3 < aVarArrW.length) {
                            i = i3 + 1;
                            f5 = f13 + ((aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT ? aVarArrW[i3].f5058a : -aVarArrW[i3].f5058a) / 2.0f);
                        } else {
                            i = i3;
                            f5 = f13;
                        }
                        boolean z3 = iArrA[i4] != -2;
                        boolean z4 = strArrB[i4] == null;
                        if (z3) {
                            float f14 = aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT ? f5 - fI : f5;
                            a(canvas, f14, f4 + fB2, i4, this.f5041c);
                            f6 = aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT ? f14 + fI : f14;
                        } else {
                            f6 = f5;
                        }
                        if (z4) {
                            f7 = aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT ? -fS : fS;
                        } else {
                            if (z3) {
                                f7 = (aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT ? -fR : fR) + f6;
                            } else {
                                f7 = f6;
                            }
                            if (aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT) {
                                f7 -= aVarArrU[i4].f5058a;
                            }
                            a(canvas, f7, f4 + fA2, strArrB[i4]);
                            if (aVarG == com.github.mikephil.charting.c.c.a.LEFT_TO_RIGHT) {
                                f7 += aVarArrU[i4].f5058a;
                            }
                            f6 = aVarG == com.github.mikephil.charting.c.c.a.RIGHT_TO_LEFT ? -fJ : fJ;
                        }
                        float f15 = f7 + f6;
                        i4++;
                        i3 = i;
                        f13 = f15;
                        fM2 = f4;
                    }
                    break;
            }
        }
    }

    protected void a(Canvas canvas, float f2, float f3, int i, com.github.mikephil.charting.c.c cVar) {
        if (cVar.a()[i] == -2) {
        }
        this.f5040b.setColor(cVar.a()[i]);
        float fI = cVar.i();
        float f4 = fI / 2.0f;
        switch (c()[cVar.h().ordinal()]) {
            case 1:
                canvas.drawRect(f2, f3 - f4, f2 + fI, f3 + f4, this.f5040b);
                break;
            case 2:
                canvas.drawCircle(f2 + f4, f3, f4, this.f5040b);
                break;
            case 3:
                canvas.drawLine(f2, f3, f2 + fI, f3, this.f5040b);
                break;
        }
    }

    protected void a(Canvas canvas, float f2, float f3, String str) {
        canvas.drawText(str, f2, f3, this.f5039a);
    }

    public void a(com.github.mikephil.charting.data.i<?> iVar) {
        if (!this.f5041c.e()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < iVar.f(); i++) {
                com.github.mikephil.charting.data.k kVarA = iVar.a(i);
                List<Integer> listU = kVarA.u();
                int iJ = kVarA.j();
                if ((kVarA instanceof com.github.mikephil.charting.data.b) && ((com.github.mikephil.charting.data.b) kVarA).b()) {
                    com.github.mikephil.charting.data.b bVar = (com.github.mikephil.charting.data.b) kVarA;
                    String[] strArrF = bVar.f();
                    for (int i2 = 0; i2 < listU.size() && i2 < bVar.a(); i2++) {
                        arrayList.add(strArrF[i2 % strArrF.length]);
                        arrayList2.add(listU.get(i2));
                    }
                    if (bVar.q() != null) {
                        arrayList2.add(-2);
                        arrayList.add(bVar.q());
                    }
                } else if (kVarA instanceof com.github.mikephil.charting.data.q) {
                    List<String> listL = iVar.l();
                    com.github.mikephil.charting.data.q qVar = (com.github.mikephil.charting.data.q) kVarA;
                    for (int i3 = 0; i3 < listU.size() && i3 < iJ && i3 < listL.size(); i3++) {
                        arrayList.add(listL.get(i3));
                        arrayList2.add(listU.get(i3));
                    }
                    if (qVar.q() != null) {
                        arrayList2.add(-2);
                        arrayList.add(qVar.q());
                    }
                } else {
                    for (int i4 = 0; i4 < listU.size() && i4 < iJ; i4++) {
                        if (i4 >= listU.size() - 1 || i4 >= iJ - 1) {
                            arrayList.add(iVar.a(i).q());
                        } else {
                            arrayList.add(null);
                        }
                        arrayList2.add(listU.get(i4));
                    }
                }
            }
            if (this.f5041c.c() != null && this.f5041c.d() != null) {
                for (int i5 : this.f5041c.c()) {
                    arrayList2.add(Integer.valueOf(i5));
                }
                Collections.addAll(arrayList, this.f5041c.d());
            }
            this.f5041c.a(arrayList2);
            this.f5041c.b(arrayList);
        }
        Typeface typefaceN = this.f5041c.n();
        if (typefaceN != null) {
            this.f5039a.setTypeface(typefaceN);
        }
        this.f5039a.setTextSize(this.f5041c.o());
        this.f5039a.setColor(this.f5041c.p());
        this.f5041c.a(this.f5039a, this.n);
    }
}
