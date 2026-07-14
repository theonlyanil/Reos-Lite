package com.google.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.a.b.d f5265a = com.google.a.b.d.f5183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f5266b = v.DEFAULT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f5267c = d.IDENTITY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Type, h<?>> f5268d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<y> f5269e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<y> f5270f = new ArrayList();
    private boolean g = false;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    private void a(String str, int i, int i2, List<y> list) {
        a aVar;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(str);
        } else if (i == 2 || i2 == 2) {
            return;
        } else {
            aVar = new a(i, i2);
        }
        list.add(w.a((com.google.a.c.a<?>) com.google.a.c.a.get(Date.class), aVar));
        list.add(w.a((com.google.a.c.a<?>) com.google.a.c.a.get(Timestamp.class), aVar));
        list.add(w.a((com.google.a.c.a<?>) com.google.a.c.a.get(java.sql.Date.class), aVar));
    }

    public g a() {
        this.g = true;
        return this;
    }

    public g b() {
        this.n = true;
        return this;
    }

    public f c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5269e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f5270f);
        a(this.h, this.i, this.j, arrayList);
        return new f(this.f5265a, this.f5267c, this.f5268d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.f5266b, arrayList);
    }
}
