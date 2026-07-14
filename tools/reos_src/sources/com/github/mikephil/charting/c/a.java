package com.github.mikephil.charting.c;

import android.graphics.DashPathEffect;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<d> f4857d;
    private int l = -7829368;
    private float m = 1.0f;
    private int n = -7829368;
    private float o = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f4854a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f4855b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f4856c = true;
    private DashPathEffect p = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f4858e = false;

    public a() {
        this.j = com.github.mikephil.charting.i.f.a(10.0f);
        this.g = com.github.mikephil.charting.i.f.a(5.0f);
        this.h = com.github.mikephil.charting.i.f.a(5.0f);
        this.f4857d = new ArrayList();
    }

    public void a(boolean z) {
        this.f4854a = z;
    }

    public boolean a() {
        return this.f4854a;
    }

    public boolean b() {
        return this.f4855b;
    }

    public int c() {
        return this.l;
    }

    public float d() {
        return this.o;
    }

    public float e() {
        return this.m;
    }

    public int f() {
        return this.n;
    }

    public boolean g() {
        return this.f4856c;
    }

    public void h() {
        this.f4857d.clear();
    }

    public List<d> i() {
        return this.f4857d;
    }

    public boolean j() {
        return this.f4858e;
    }

    public DashPathEffect k() {
        return this.p;
    }
}
