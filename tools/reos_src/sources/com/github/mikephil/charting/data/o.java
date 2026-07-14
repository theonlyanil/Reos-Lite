package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class o<T extends Entry> extends d<T> {
    protected boolean q;
    protected boolean r;
    protected float s;
    protected DashPathEffect t;

    public o(List<T> list, String str) {
        super(list, str);
        this.q = true;
        this.r = true;
        this.s = 0.5f;
        this.t = null;
        this.s = com.github.mikephil.charting.i.f.a(0.5f);
    }

    public boolean J() {
        return this.q;
    }

    public boolean K() {
        return this.r;
    }

    public float L() {
        return this.s;
    }

    public DashPathEffect M() {
        return this.t;
    }

    public void d(boolean z) {
        this.r = z;
    }
}
