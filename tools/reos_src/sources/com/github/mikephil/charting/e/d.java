package com.github.mikephil.charting.e;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f4998d;

    public d(int i, int i2) {
        this.f4997c = -1;
        this.f4995a = i;
        this.f4996b = i2;
    }

    public d(int i, int i2, int i3) {
        this(i, i2);
        this.f4997c = i3;
    }

    public d(int i, int i2, int i3, f fVar) {
        this(i, i2, i3);
        this.f4998d = fVar;
    }

    public int a() {
        return this.f4996b;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f4996b == dVar.f4996b && this.f4995a == dVar.f4995a && this.f4997c == dVar.f4997c;
    }

    public int b() {
        return this.f4995a;
    }

    public int c() {
        return this.f4997c;
    }

    public f d() {
        return this.f4998d;
    }

    public String toString() {
        return "Highlight, xIndex: " + this.f4995a + ", dataSetIndex: " + this.f4996b + ", stackIndex (only stacked barentry): " + this.f4997c;
    }
}
