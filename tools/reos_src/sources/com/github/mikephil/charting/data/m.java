package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m extends n<Entry> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Integer> f4981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DashPathEffect f4985f;
    private com.github.mikephil.charting.d.e u;
    private boolean v;
    private boolean w;
    private boolean x;

    public m(List<Entry> list, String str) {
        super(list, str);
        this.f4981b = null;
        this.f4982c = -1;
        this.f4983d = 8.0f;
        this.f4984e = 0.2f;
        this.f4985f = null;
        this.u = new com.github.mikephil.charting.d.a();
        this.v = true;
        this.w = false;
        this.x = true;
        this.f4981b = new ArrayList();
        this.f4981b.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public boolean D() {
        return this.x;
    }

    public com.github.mikephil.charting.d.e E() {
        return this.u;
    }

    public float a() {
        return this.f4984e;
    }

    public void a(com.github.mikephil.charting.d.e eVar) {
        if (eVar == null) {
            this.u = new com.github.mikephil.charting.d.a();
        } else {
            this.u = eVar;
        }
    }

    public float b() {
        return this.f4983d;
    }

    public void b(float f2) {
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.f4984e = f3 >= 0.05f ? f3 : 0.05f;
    }

    public void b(boolean z) {
        this.v = z;
    }

    public void c(float f2) {
        this.f4983d = com.github.mikephil.charting.i.f.a(f2);
    }

    public void c(boolean z) {
        this.w = z;
    }

    public boolean c() {
        return this.f4985f != null;
    }

    public DashPathEffect d() {
        return this.f4985f;
    }

    public boolean e() {
        return this.v;
    }

    public boolean f() {
        return this.w;
    }

    public int g(int i) {
        return this.f4981b.get(i % this.f4981b.size()).intValue();
    }

    public void h() {
        this.f4981b = new ArrayList();
    }

    public void h(int i) {
        h();
        this.f4981b.add(Integer.valueOf(i));
    }

    public int i() {
        return this.f4982c;
    }
}
