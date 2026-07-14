package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.k;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class i<T extends k<? extends Entry>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f4969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f4970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f4971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f4972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected float f4973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float f4974f;
    protected int g;
    protected int h;
    protected List<String> i;
    protected List<T> j;
    private float k;
    private int l;
    private float m;

    public i() {
        this.f4969a = BitmapDescriptorFactory.HUE_RED;
        this.f4970b = BitmapDescriptorFactory.HUE_RED;
        this.f4971c = BitmapDescriptorFactory.HUE_RED;
        this.f4972d = BitmapDescriptorFactory.HUE_RED;
        this.f4973e = BitmapDescriptorFactory.HUE_RED;
        this.f4974f = BitmapDescriptorFactory.HUE_RED;
        this.k = BitmapDescriptorFactory.HUE_RED;
        this.l = 0;
        this.g = 0;
        this.h = 0;
        this.m = BitmapDescriptorFactory.HUE_RED;
        this.i = new ArrayList();
        this.j = new ArrayList();
    }

    public i(List<String> list, List<T> list2) {
        this.f4969a = BitmapDescriptorFactory.HUE_RED;
        this.f4970b = BitmapDescriptorFactory.HUE_RED;
        this.f4971c = BitmapDescriptorFactory.HUE_RED;
        this.f4972d = BitmapDescriptorFactory.HUE_RED;
        this.f4973e = BitmapDescriptorFactory.HUE_RED;
        this.f4974f = BitmapDescriptorFactory.HUE_RED;
        this.k = BitmapDescriptorFactory.HUE_RED;
        this.l = 0;
        this.g = 0;
        this.h = 0;
        this.m = BitmapDescriptorFactory.HUE_RED;
        this.i = list;
        this.j = list2;
        c();
    }

    private void a() {
        if (this.i.size() <= 0) {
            this.m = 1.0f;
            return;
        }
        int i = 0;
        float length = 1.0f;
        while (true) {
            int i2 = i;
            if (i2 >= this.i.size()) {
                this.m = length / this.i.size();
                return;
            } else {
                length += this.i.get(i2).length();
                i = i2 + 1;
            }
        }
    }

    private void a(T t, T t2) {
        if (t == null) {
            this.f4971c = this.f4973e;
            this.f4972d = this.f4974f;
        } else if (t2 == null) {
            this.f4973e = this.f4971c;
            this.f4974f = this.f4972d;
        }
    }

    private void b() {
        if (this.j == null || (this instanceof t)) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                return;
            }
            if (this.j.get(i2).k().size() > this.i.size()) {
                throw new IllegalArgumentException("One or more of the DataSet Entry arrays are longer than the x-values array of this ChartData object.");
            }
            i = i2 + 1;
        }
    }

    public float a(com.github.mikephil.charting.c.g.a aVar) {
        return aVar == com.github.mikephil.charting.c.g.a.LEFT ? this.f4972d : this.f4974f;
    }

    public int a(T t) {
        for (int i = 0; i < this.j.size(); i++) {
            if (this.j.get(i) == t) {
                return i;
            }
        }
        return -1;
    }

    public Entry a(com.github.mikephil.charting.e.d dVar) {
        if (dVar.a() >= this.j.size()) {
            return null;
        }
        return this.j.get(dVar.a()).c(dVar.b());
    }

    public T a(int i) {
        if (this.j == null || i < 0 || i >= this.j.size()) {
            return null;
        }
        return this.j.get(i);
    }

    public void a(float f2) {
        Iterator<T> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(f2);
        }
    }

    public void a(int i, int i2) {
        if (this.j == null || this.j.size() < 1) {
            this.f4969a = BitmapDescriptorFactory.HUE_RED;
            this.f4970b = BitmapDescriptorFactory.HUE_RED;
            return;
        }
        this.g = i;
        this.h = i2;
        this.f4970b = Float.MAX_VALUE;
        this.f4969a = -3.4028235E38f;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.j.size()) {
                break;
            }
            this.j.get(i4).a(i, i2);
            if (this.j.get(i4).m() < this.f4970b) {
                this.f4970b = this.j.get(i4).m();
            }
            if (this.j.get(i4).n() > this.f4969a) {
                this.f4969a = this.j.get(i4).n();
            }
            i3 = i4 + 1;
        }
        if (this.f4970b == Float.MAX_VALUE) {
            this.f4970b = BitmapDescriptorFactory.HUE_RED;
            this.f4969a = BitmapDescriptorFactory.HUE_RED;
        }
        k kVarO = o();
        if (kVarO != null) {
            this.f4971c = kVarO.n();
            this.f4972d = kVarO.m();
            for (T t : this.j) {
                if (t.s() == com.github.mikephil.charting.c.g.a.LEFT) {
                    if (t.m() < this.f4972d) {
                        this.f4972d = t.m();
                    }
                    if (t.n() > this.f4971c) {
                        this.f4971c = t.n();
                    }
                }
            }
        }
        k kVarP = p();
        if (kVarP != null) {
            this.f4973e = kVarP.n();
            this.f4974f = kVarP.m();
            for (T t2 : this.j) {
                if (t2.s() == com.github.mikephil.charting.c.g.a.RIGHT) {
                    if (t2.m() < this.f4974f) {
                        this.f4974f = t2.m();
                    }
                    if (t2.n() > this.f4973e) {
                        this.f4973e = t2.n();
                    }
                }
            }
        }
        a(kVarO, kVarP);
    }

    public void a(boolean z) {
        Iterator<T> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    public float b(com.github.mikephil.charting.c.g.a aVar) {
        return aVar == com.github.mikephil.charting.c.g.a.LEFT ? this.f4971c : this.f4973e;
    }

    protected void c() {
        b();
        a(this.g, this.h);
        d();
        e();
        a();
    }

    protected void d() {
        this.k = BitmapDescriptorFactory.HUE_RED;
        if (this.j == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                return;
            }
            this.k = Math.abs(this.j.get(i2).l()) + this.k;
            i = i2 + 1;
        }
    }

    protected void e() {
        this.l = 0;
        if (this.j == null) {
            return;
        }
        int iJ = 0;
        for (int i = 0; i < this.j.size(); i++) {
            iJ += this.j.get(i).j();
        }
        this.l = iJ;
    }

    public int f() {
        if (this.j == null) {
            return 0;
        }
        return this.j.size();
    }

    public float g() {
        return this.f4970b;
    }

    public float h() {
        return this.f4969a;
    }

    public float i() {
        return this.m;
    }

    public float j() {
        return this.k;
    }

    public int k() {
        return this.l;
    }

    public List<String> l() {
        return this.i;
    }

    public List<T> m() {
        return this.j;
    }

    public int n() {
        return this.i.size();
    }

    public T o() {
        for (T t : this.j) {
            if (t.s() == com.github.mikephil.charting.c.g.a.LEFT) {
                return t;
            }
        }
        return null;
    }

    public T p() {
        for (T t : this.j) {
            if (t.s() == com.github.mikephil.charting.c.g.a.RIGHT) {
                return t;
            }
        }
        return null;
    }
}
