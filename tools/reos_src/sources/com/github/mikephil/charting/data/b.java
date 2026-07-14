package com.github.mikephil.charting.data;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes.dex */
public class b extends d<BarEntry> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f4958f;

    public int a() {
        return this.f4955c;
    }

    @Override // com.github.mikephil.charting.data.k
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
            BarEntry barEntry = (BarEntry) this.h.get(i);
            if (barEntry != null && !Float.isNaN(barEntry.b())) {
                if (barEntry.a() == null) {
                    if (barEntry.b() < this.j) {
                        this.j = barEntry.b();
                    }
                    if (barEntry.b() > this.i) {
                        this.i = barEntry.b();
                    }
                } else {
                    if ((-barEntry.d()) < this.j) {
                        this.j = -barEntry.d();
                    }
                    if (barEntry.c() > this.i) {
                        this.i = barEntry.c();
                    }
                }
            }
            i++;
        }
        if (this.j == Float.MAX_VALUE) {
            this.j = BitmapDescriptorFactory.HUE_RED;
            this.i = BitmapDescriptorFactory.HUE_RED;
        }
    }

    public boolean b() {
        return this.f4955c > 1;
    }

    public float c() {
        return this.f4954b;
    }

    public int d() {
        return this.f4956d;
    }

    public int e() {
        return this.f4957e;
    }

    public String[] f() {
        return this.f4958f;
    }
}
