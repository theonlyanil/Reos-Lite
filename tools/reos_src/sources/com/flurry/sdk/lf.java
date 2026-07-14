package com.flurry.sdk;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class lf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Class<?>> f4677b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4678a = lf.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Object> f4679c = new LinkedHashMap();

    public lf() {
        ArrayList<Class<?>> arrayList;
        synchronized (f4677b) {
            arrayList = new ArrayList(f4677b);
        }
        for (Class<?> cls : arrayList) {
            try {
                Object objNewInstance = cls.newInstance();
                synchronized (this.f4679c) {
                    try {
                        this.f4679c.put(cls, objNewInstance);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                kg.a(5, this.f4678a, "Module data " + cls + " is not available:", e2);
            }
        }
    }

    public static void a(Class<?> cls) {
        if (cls == null) {
            return;
        }
        synchronized (f4677b) {
            f4677b.add(cls);
        }
    }

    public static void b(Class<?> cls) {
        if (cls == null) {
            return;
        }
        synchronized (f4677b) {
            f4677b.remove(cls);
        }
    }

    public Object c(Class<?> cls) {
        Object obj;
        if (cls == null) {
            return null;
        }
        synchronized (this.f4679c) {
            obj = this.f4679c.get(cls);
        }
        return obj;
    }
}
