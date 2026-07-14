package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class n<T extends Entry> extends o<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4989e;

    public n(List<T> list, String str) {
        super(list, str);
        this.f4986b = Color.rgb(140, 234, 255);
        this.f4987c = 85;
        this.f4988d = 2.5f;
        this.f4989e = false;
    }

    public int F() {
        return this.f4986b;
    }

    public int G() {
        return this.f4987c;
    }

    public float H() {
        return this.f4988d;
    }

    public boolean I() {
        return this.f4989e;
    }

    public void d(float f2) {
        float f3 = f2 >= 0.2f ? f2 : 0.2f;
        this.f4988d = com.github.mikephil.charting.i.f.a(f3 <= 10.0f ? f3 : 10.0f);
    }

    public void i(int i) {
        this.f4986b = i;
    }

    public void j(int i) {
        this.f4987c = i;
    }
}
