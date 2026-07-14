package com.flurry.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ki {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4574a = ki.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends kj>, kh> f4575b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<? extends kj>, kj> f4576c = new LinkedHashMap();

    public static void a(Class<? extends kj> cls, int i) {
        if (cls == null) {
            return;
        }
        synchronized (f4575b) {
            f4575b.put(cls, new kh(cls, i));
        }
    }

    private List<kj> b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f4576c) {
            arrayList.addAll(this.f4576c.values());
        }
        return arrayList;
    }

    public kj a(Class<? extends kj> cls) {
        kj kjVar;
        if (cls == null) {
            return null;
        }
        synchronized (this.f4576c) {
            kjVar = this.f4576c.get(cls);
        }
        if (kjVar == null) {
            throw new IllegalStateException("Module was not registered/initialized. " + cls);
        }
        return kjVar;
    }

    public synchronized void a() {
        jw.b();
        lh.b();
        List<kj> listB = b();
        for (int size = listB.size() - 1; size >= 0; size--) {
            try {
                this.f4576c.remove(listB.get(size).getClass()).b();
            } catch (Exception e2) {
                kg.a(5, f4574a, "Error destroying module:", e2);
            }
        }
    }

    public synchronized void a(Context context) {
        ArrayList<kh> arrayList;
        if (context == null) {
            kg.a(5, f4574a, "Null context.");
        } else {
            synchronized (f4575b) {
                arrayList = new ArrayList(f4575b.values());
            }
            for (kh khVar : arrayList) {
                try {
                    if (khVar.b()) {
                        kj kjVarNewInstance = khVar.a().newInstance();
                        kjVarNewInstance.a(context);
                        this.f4576c.put(khVar.a(), kjVarNewInstance);
                    }
                } catch (Exception e2) {
                    kg.a(5, f4574a, "Flurry Module for class " + khVar.a() + " is not available:", e2);
                }
            }
            lh.a().a(context);
            jw.a();
        }
    }
}
