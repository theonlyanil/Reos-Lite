package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j extends c<d<?>> {
    private l k;
    private a l;
    private t m;
    private g n;
    private e o;

    public e a() {
        return this.o;
    }

    public l b() {
        return this.k;
    }

    public a q() {
        return this.l;
    }

    public t r() {
        return this.m;
    }

    public g s() {
        return this.n;
    }

    public List<i> t() {
        ArrayList arrayList = new ArrayList();
        if (this.k != null) {
            arrayList.add(this.k);
        }
        if (this.l != null) {
            arrayList.add(this.l);
        }
        if (this.m != null) {
            arrayList.add(this.m);
        }
        if (this.n != null) {
            arrayList.add(this.n);
        }
        if (this.o != null) {
            arrayList.add(this.o);
        }
        return arrayList;
    }
}
