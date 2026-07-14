package com.github.mikephil.charting.c;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.github.mikephil.charting.c.a {
    protected List<String> l = new ArrayList();
    public int m = 1;
    public int n = 1;
    public int o = 1;
    public int p = 1;
    protected float q = BitmapDescriptorFactory.HUE_RED;
    private int u = 4;
    public int r = 1;
    private boolean v = false;
    public int s = 1;
    private boolean w = false;
    protected com.github.mikephil.charting.d.g t = new com.github.mikephil.charting.d.c();
    private a x = a.TOP;

    public enum a {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public f() {
        this.h = com.github.mikephil.charting.i.f.a(4.0f);
    }

    public void a(int i) {
        this.u = i;
    }

    public void a(List<String> list) {
        this.l = list;
    }

    public a r() {
        return this.x;
    }

    public float s() {
        return this.q;
    }

    public boolean t() {
        return this.v;
    }

    public int u() {
        return this.u;
    }

    public boolean v() {
        return this.w;
    }

    public List<String> w() {
        return this.l;
    }

    public com.github.mikephil.charting.d.g x() {
        return this.t;
    }

    public String y() {
        String str = "";
        int i = 0;
        while (i < this.l.size()) {
            String str2 = this.l.get(i);
            if (str.length() >= str2.length()) {
                str2 = str;
            }
            i++;
            str = str2;
        }
        return str;
    }
}
