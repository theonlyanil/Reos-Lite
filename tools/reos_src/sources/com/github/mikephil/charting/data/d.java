package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d<T extends Entry> extends k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f4959a;

    public d(List<T> list, String str) {
        super(list, str);
        this.f4959a = Color.rgb(255, 187, 115);
    }

    public void a(int i) {
        this.f4959a = i;
    }

    public int g() {
        return this.f4959a;
    }
}
