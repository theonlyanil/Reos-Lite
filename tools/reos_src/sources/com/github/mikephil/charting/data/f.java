package com.github.mikephil.charting.data;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends d<BubbleEntry> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f4960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f4961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f4962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4963e;

    private float a(BubbleEntry bubbleEntry) {
        return bubbleEntry.b();
    }

    private float b(BubbleEntry bubbleEntry) {
        return bubbleEntry.b();
    }

    private float c(BubbleEntry bubbleEntry) {
        return bubbleEntry.f();
    }

    private float d(BubbleEntry bubbleEntry) {
        return bubbleEntry.f();
    }

    private float e(BubbleEntry bubbleEntry) {
        return bubbleEntry.a();
    }

    public float a() {
        return this.f4963e;
    }

    @Override // com.github.mikephil.charting.data.k
    protected void a(int i, int i2) {
        if (this.h.size() == 0) {
            return;
        }
        List<T> listK = k();
        if (i2 == 0) {
            i2 = this.h.size() - 1;
        }
        this.k = i;
        this.l = i2;
        this.j = a((BubbleEntry) listK.get(i));
        this.i = b((BubbleEntry) listK.get(i));
        while (i <= i2) {
            BubbleEntry bubbleEntry = (BubbleEntry) listK.get(i);
            float fA = a(bubbleEntry);
            float fB = b(bubbleEntry);
            if (fA < this.j) {
                this.j = fA;
            }
            if (fB > this.i) {
                this.i = fB;
            }
            float fC = c(bubbleEntry);
            float fD = d(bubbleEntry);
            if (fC < this.f4961c) {
                this.f4961c = fC;
            }
            if (fD > this.f4960b) {
                this.f4960b = fD;
            }
            float fE = e(bubbleEntry);
            if (fE > this.f4962d) {
                this.f4962d = fE;
            }
            i++;
        }
    }

    public float b() {
        return this.f4960b;
    }

    public float c() {
        return this.f4961c;
    }

    public float d() {
        return this.f4962d;
    }
}
