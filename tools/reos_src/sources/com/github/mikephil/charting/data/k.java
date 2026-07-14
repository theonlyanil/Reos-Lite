package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.Typeface;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class k<T extends Entry> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4976b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Typeface f4980f;
    protected List<Integer> g;
    protected List<T> h;
    protected transient com.github.mikephil.charting.d.f n;
    protected float i = BitmapDescriptorFactory.HUE_RED;
    protected float j = BitmapDescriptorFactory.HUE_RED;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4975a = BitmapDescriptorFactory.HUE_RED;
    protected int k = 0;
    protected int l = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4977c = true;
    protected boolean m = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4978d = -16777216;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4979e = 17.0f;
    protected com.github.mikephil.charting.c.g.a o = com.github.mikephil.charting.c.g.a.LEFT;
    protected boolean p = true;

    public k(List<T> list, String str) {
        this.g = null;
        this.h = null;
        this.f4976b = "DataSet";
        this.f4976b = str;
        this.h = list;
        if (this.h == null) {
            this.h = new ArrayList();
        }
        this.g = new ArrayList();
        this.g.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        a(this.k, this.l);
        a();
    }

    private void a() {
        this.f4975a = BitmapDescriptorFactory.HUE_RED;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                return;
            }
            T t = this.h.get(i2);
            if (t != null) {
                this.f4975a = Math.abs(t.b()) + this.f4975a;
            }
            i = i2 + 1;
        }
    }

    public int A() {
        return this.f4978d;
    }

    public Typeface B() {
        return this.f4980f;
    }

    public float C() {
        return this.f4979e;
    }

    public int a(Entry entry) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                return -1;
            }
            if (entry.a(this.h.get(i2))) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public void a(float f2) {
        this.f4979e = com.github.mikephil.charting.i.f.a(f2);
    }

    protected void a(int i, int i2) {
        int size = this.h.size();
        if (size == 0) {
            return;
        }
        if (i2 == 0 || i2 >= size) {
            i2 = size - 1;
        }
        this.k = i;
        this.l = i2;
        this.j = Float.MAX_VALUE;
        this.i = -3.4028235E38f;
        while (i <= i2) {
            T t = this.h.get(i);
            if (t != null && !Float.isNaN(t.b())) {
                if (t.b() < this.j) {
                    this.j = t.b();
                }
                if (t.b() > this.i) {
                    this.i = t.b();
                }
            }
            i++;
        }
        if (this.j == Float.MAX_VALUE) {
            this.j = BitmapDescriptorFactory.HUE_RED;
            this.i = BitmapDescriptorFactory.HUE_RED;
        }
    }

    public void a(com.github.mikephil.charting.d.f fVar) {
        if (fVar == null) {
            return;
        }
        this.n = fVar;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public float b(int i) {
        Entry entryC = c(i);
        if (entryC == null || entryC.f() != i) {
            return Float.NaN;
        }
        return entryC.b();
    }

    public T c(int i) {
        int iD = d(i);
        if (iD > -1) {
            return this.h.get(iD);
        }
        return null;
    }

    public int d(int i) {
        int i2;
        int i3;
        int i4 = 0;
        int size = this.h.size() - 1;
        int i5 = -1;
        while (i4 <= size) {
            int i6 = (size + i4) / 2;
            if (i == this.h.get(i6).f()) {
                int i7 = i6;
                while (i7 > 0 && this.h.get(i7 - 1).f() == i) {
                    i7--;
                }
                return i7;
            }
            if (i > this.h.get(i6).f()) {
                int i8 = size;
                i3 = i6 + 1;
                i2 = i8;
            } else {
                i2 = i6 - 1;
                i3 = i4;
            }
            i4 = i3;
            size = i2;
            i5 = i6;
        }
        return i5;
    }

    public void e(int i) {
        w();
        this.g.add(Integer.valueOf(i));
    }

    public int f(int i) {
        return this.g.get(i % this.g.size()).intValue();
    }

    public int j() {
        return this.h.size();
    }

    public List<T> k() {
        return this.h;
    }

    public float l() {
        return this.f4975a;
    }

    public float m() {
        return this.j;
    }

    public float n() {
        return this.i;
    }

    public int o() {
        return this.h.size();
    }

    public String p() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DataSet, label: " + (this.f4976b == null ? "" : this.f4976b) + ", entries: " + this.h.size() + "\n");
        return stringBuffer.toString();
    }

    public String q() {
        return this.f4976b;
    }

    public boolean r() {
        return this.f4977c;
    }

    public com.github.mikephil.charting.c.g.a s() {
        return this.o;
    }

    public boolean t() {
        return this.m;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(p());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                return stringBuffer.toString();
            }
            stringBuffer.append(String.valueOf(this.h.get(i2).toString()) + " ");
            i = i2 + 1;
        }
    }

    public List<Integer> u() {
        return this.g;
    }

    public int v() {
        return this.g.get(0).intValue();
    }

    public void w() {
        this.g = new ArrayList();
    }

    public boolean x() {
        return this.p;
    }

    public com.github.mikephil.charting.d.f y() {
        return this.n == null ? new com.github.mikephil.charting.d.b(1) : this.n;
    }

    public boolean z() {
        return this.n == null || (this.n instanceof com.github.mikephil.charting.d.b);
    }
}
