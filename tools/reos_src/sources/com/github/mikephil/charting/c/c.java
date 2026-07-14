package com.github.mikephil.charting.c;

import android.graphics.Paint;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.github.mikephil.charting.c.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f4864e;
    private String[] l;
    private int[] m;
    private String[] n;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private boolean o = false;
    private EnumC0083c p = EnumC0083c.BELOW_CHART_LEFT;
    private a q = a.LEFT_TO_RIGHT;
    private b r = b.SQUARE;
    private float x = 0.95f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4860a = BitmapDescriptorFactory.HUE_RED;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4861b = BitmapDescriptorFactory.HUE_RED;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4862c = BitmapDescriptorFactory.HUE_RED;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4863d = BitmapDescriptorFactory.HUE_RED;
    private boolean y = false;
    private com.github.mikephil.charting.i.a[] z = new com.github.mikephil.charting.i.a[0];
    private Boolean[] A = new Boolean[0];
    private com.github.mikephil.charting.i.a[] B = new com.github.mikephil.charting.i.a[0];

    public enum a {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public enum b {
        SQUARE,
        CIRCLE,
        LINE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            int length = bVarArrValuesCustom.length;
            b[] bVarArr = new b[length];
            System.arraycopy(bVarArrValuesCustom, 0, bVarArr, 0, length);
            return bVarArr;
        }
    }

    /* JADX INFO: renamed from: com.github.mikephil.charting.c.c$c, reason: collision with other inner class name */
    public enum EnumC0083c {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0083c[] valuesCustom() {
            EnumC0083c[] enumC0083cArrValuesCustom = values();
            int length = enumC0083cArrValuesCustom.length;
            EnumC0083c[] enumC0083cArr = new EnumC0083c[length];
            System.arraycopy(enumC0083cArrValuesCustom, 0, enumC0083cArr, 0, length);
            return enumC0083cArr;
        }
    }

    public c() {
        this.s = 8.0f;
        this.t = 6.0f;
        this.u = BitmapDescriptorFactory.HUE_RED;
        this.v = 5.0f;
        this.w = 3.0f;
        this.s = com.github.mikephil.charting.i.f.a(8.0f);
        this.t = com.github.mikephil.charting.i.f.a(6.0f);
        this.u = com.github.mikephil.charting.i.f.a(BitmapDescriptorFactory.HUE_RED);
        this.v = com.github.mikephil.charting.i.f.a(5.0f);
        this.j = com.github.mikephil.charting.i.f.a(10.0f);
        this.w = com.github.mikephil.charting.i.f.a(3.0f);
        this.g = com.github.mikephil.charting.i.f.a(5.0f);
        this.h = com.github.mikephil.charting.i.f.a(7.0f);
    }

    public float a(Paint paint) {
        float f2 = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < this.l.length; i++) {
            if (this.l[i] != null) {
                float fA = com.github.mikephil.charting.i.f.a(paint, this.l[i]);
                if (fA > f2) {
                    f2 = fA;
                }
            }
        }
        return this.s + f2 + this.v;
    }

    public void a(Paint paint, com.github.mikephil.charting.i.g gVar) {
        int i;
        float f2;
        float fMax;
        if (this.p == EnumC0083c.RIGHT_OF_CHART || this.p == EnumC0083c.RIGHT_OF_CHART_CENTER || this.p == EnumC0083c.LEFT_OF_CHART || this.p == EnumC0083c.LEFT_OF_CHART_CENTER || this.p == EnumC0083c.PIECHART_CENTER) {
            this.f4860a = a(paint);
            this.f4861b = d(paint);
            this.f4863d = this.f4860a;
            this.f4862c = b(paint);
            return;
        }
        if (this.p != EnumC0083c.BELOW_CHART_LEFT && this.p != EnumC0083c.BELOW_CHART_RIGHT && this.p != EnumC0083c.BELOW_CHART_CENTER && this.p != EnumC0083c.ABOVE_CHART_LEFT && this.p != EnumC0083c.ABOVE_CHART_RIGHT && this.p != EnumC0083c.ABOVE_CHART_CENTER) {
            this.f4860a = c(paint);
            this.f4861b = b(paint);
            this.f4863d = a(paint);
            this.f4862c = this.f4861b;
            return;
        }
        int length = this.l.length;
        float fA = com.github.mikephil.charting.i.f.a(paint);
        float fB = com.github.mikephil.charting.i.f.b(paint) + this.u;
        float fI = gVar.i();
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = new ArrayList(length);
        ArrayList arrayList3 = new ArrayList();
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float f4 = BitmapDescriptorFactory.HUE_RED;
        float f5 = BitmapDescriptorFactory.HUE_RED;
        int i2 = -1;
        int i3 = 0;
        while (i3 < length) {
            boolean z = this.f4864e[i3] != -2;
            arrayList2.add(false);
            float f6 = i2 == -1 ? BitmapDescriptorFactory.HUE_RED : f5 + this.w;
            if (this.l[i3] != null) {
                arrayList.add(com.github.mikephil.charting.i.f.c(paint, this.l[i3]));
                f5 = ((com.github.mikephil.charting.i.a) arrayList.get(i3)).f5058a + f6 + (z ? this.v + this.s : BitmapDescriptorFactory.HUE_RED);
                i = i2;
            } else {
                arrayList.add(new com.github.mikephil.charting.i.a(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED));
                float f7 = (z ? this.s : BitmapDescriptorFactory.HUE_RED) + f6;
                if (i2 == -1) {
                    f5 = f7;
                    i = i3;
                } else {
                    f5 = f7;
                    i = i2;
                }
            }
            if (this.l[i3] != null || i3 == length - 1) {
                float f8 = f4 == BitmapDescriptorFactory.HUE_RED ? BitmapDescriptorFactory.HUE_RED : this.t;
                if (!this.y || f4 == BitmapDescriptorFactory.HUE_RED || fI - f4 >= f8 + f5) {
                    f2 = f8 + f5 + f4;
                    fMax = f3;
                } else {
                    arrayList3.add(new com.github.mikephil.charting.i.a(f4, fA));
                    fMax = Math.max(f3, f4);
                    arrayList2.set(i > -1 ? i : i3, true);
                    f2 = f5;
                }
                if (i3 == length - 1) {
                    arrayList3.add(new com.github.mikephil.charting.i.a(f2, fA));
                    fMax = Math.max(fMax, f2);
                }
            } else {
                f2 = f4;
                fMax = f3;
            }
            if (this.l[i3] != null) {
                i = -1;
            }
            i3++;
            f3 = fMax;
            f4 = f2;
            i2 = i;
        }
        this.z = (com.github.mikephil.charting.i.a[]) arrayList.toArray(new com.github.mikephil.charting.i.a[arrayList.size()]);
        this.A = (Boolean[]) arrayList2.toArray(new Boolean[arrayList2.size()]);
        this.B = (com.github.mikephil.charting.i.a[]) arrayList3.toArray(new com.github.mikephil.charting.i.a[arrayList3.size()]);
        this.f4863d = a(paint);
        this.f4862c = b(paint);
        this.f4860a = f3;
        this.f4861b = ((this.B.length == 0 ? 0 : this.B.length - 1) * fB) + (fA * this.B.length);
    }

    public void a(List<Integer> list) {
        this.f4864e = com.github.mikephil.charting.i.f.a(list);
    }

    public int[] a() {
        return this.f4864e;
    }

    public float b(Paint paint) {
        float f2 = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < this.l.length; i++) {
            if (this.l[i] != null) {
                float fB = com.github.mikephil.charting.i.f.b(paint, this.l[i]);
                if (fB > f2) {
                    f2 = fB;
                }
            }
        }
        return f2;
    }

    public void b(List<String> list) {
        this.l = com.github.mikephil.charting.i.f.b(list);
    }

    public String[] b() {
        return this.l;
    }

    public float c(Paint paint) {
        float fA = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < this.l.length; i++) {
            if (this.l[i] != null) {
                if (this.f4864e[i] != -2) {
                    fA += this.s + this.v;
                }
                fA += com.github.mikephil.charting.i.f.a(paint, this.l[i]);
                if (i < this.l.length - 1) {
                    fA += this.t;
                }
            } else {
                fA += this.s;
                if (i < this.l.length - 1) {
                    fA += this.w;
                }
            }
        }
        return fA;
    }

    public int[] c() {
        return this.m;
    }

    public float d(Paint paint) {
        float fB = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < this.l.length; i++) {
            if (this.l[i] != null) {
                fB += com.github.mikephil.charting.i.f.b(paint, this.l[i]);
                if (i < this.l.length - 1) {
                    fB += this.u;
                }
            }
        }
        return fB;
    }

    public String[] d() {
        return this.n;
    }

    public boolean e() {
        return this.o;
    }

    public EnumC0083c f() {
        return this.p;
    }

    public a g() {
        return this.q;
    }

    public b h() {
        return this.r;
    }

    public float i() {
        return this.s;
    }

    public float j() {
        return this.t;
    }

    public float k() {
        return this.u;
    }

    public float r() {
        return this.v;
    }

    public float s() {
        return this.w;
    }

    public float t() {
        return this.x;
    }

    public com.github.mikephil.charting.i.a[] u() {
        return this.z;
    }

    public Boolean[] v() {
        return this.A;
    }

    public com.github.mikephil.charting.i.a[] w() {
        return this.B;
    }
}
