package com.github.mikephil.charting.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f4848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f4849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f4850c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f4851d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f4852e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f4853f = 0;

    public a(int i) {
        this.f4848a = 0;
        this.f4848a = 0;
        this.f4849b = new float[i];
    }

    public void a() {
        this.f4848a = 0;
    }

    public void a(float f2, float f3) {
        this.f4850c = f2;
        this.f4851d = f3;
    }

    public void a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f4852e = i;
    }

    public int b() {
        return this.f4849b.length;
    }

    public void b(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f4853f = i;
    }
}
