package com.a.a.g;

import com.a.a.j.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f2406a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<g, b<?, ?>> f2407b = new HashMap();

    public <T, Z> b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        b<T, Z> bVar;
        synchronized (f2406a) {
            f2406a.a(cls, cls2);
            bVar = (b) this.f2407b.get(f2406a);
        }
        return bVar == null ? d.e() : bVar;
    }

    public <T, Z> void a(Class<T> cls, Class<Z> cls2, b<T, Z> bVar) {
        this.f2407b.put(new g(cls, cls2), bVar);
    }
}
