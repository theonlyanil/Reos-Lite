package com.github.mikephil.charting.data;

import android.graphics.Paint;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends o<CandleEntry> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint.Style f4964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint.Style f4965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f4966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f4967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f4968f;
    private float u;
    private float v;
    private boolean w;

    public float a() {
        return this.v;
    }

    @Override // com.github.mikephil.charting.data.k
    protected void a(int i, int i2) {
        if (this.h.size() == 0) {
            return;
        }
        List<T> list = this.h;
        if (i2 == 0 || i2 >= this.h.size()) {
            i2 = this.h.size() - 1;
        }
        this.k = i;
        this.l = i2;
        this.j = Float.MAX_VALUE;
        this.i = -3.4028235E38f;
        while (i <= i2) {
            CandleEntry candleEntry = (CandleEntry) list.get(i);
            if (candleEntry.c() < this.j) {
                this.j = candleEntry.c();
            }
            if (candleEntry.a() > this.i) {
                this.i = candleEntry.a();
            }
            i++;
        }
    }

    public float b() {
        return this.u;
    }

    public int c() {
        return this.f4967e;
    }

    public int d() {
        return this.f4966d;
    }

    public Paint.Style e() {
        return this.f4965c;
    }

    public Paint.Style f() {
        return this.f4964b;
    }

    public int h() {
        return this.f4968f;
    }

    public boolean i() {
        return this.w;
    }
}
