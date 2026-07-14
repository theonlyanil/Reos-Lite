package com.a.a.d.d.f;

import com.a.a.j.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f2352a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<g, c<?, ?>> f2353b = new HashMap();

    public <Z, R> c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        c<Z, R> cVar;
        if (cls.equals(cls2)) {
            return e.b();
        }
        synchronized (f2352a) {
            f2352a.a(cls, cls2);
            cVar = (c) this.f2353b.get(f2352a);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
        }
        return cVar;
    }

    public <Z, R> void a(Class<Z> cls, Class<R> cls2, c<Z, R> cVar) {
        this.f2353b.put(new g(cls, cls2), cVar);
    }
}
