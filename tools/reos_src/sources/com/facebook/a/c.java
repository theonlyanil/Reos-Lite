package com.facebook.a;

import android.content.Context;
import com.facebook.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<a, k> f3565a = new HashMap<>();

    private synchronized k b(a aVar) {
        k kVar;
        kVar = this.f3565a.get(aVar);
        if (kVar == null) {
            Context contextF = m.f();
            kVar = new k(com.facebook.b.c.a(contextF), f.b(contextF));
        }
        this.f3565a.put(aVar, kVar);
        return kVar;
    }

    public synchronized k a(a aVar) {
        return this.f3565a.get(aVar);
    }

    public synchronized Set<a> a() {
        return this.f3565a.keySet();
    }

    public synchronized void a(a aVar, b bVar) {
        b(aVar).a(bVar);
    }

    public synchronized void a(j jVar) {
        if (jVar != null) {
            for (a aVar : jVar.a()) {
                k kVarB = b(aVar);
                Iterator<b> it = jVar.a(aVar).iterator();
                while (it.hasNext()) {
                    kVarB.a(it.next());
                }
            }
        }
    }

    public synchronized int b() {
        int i;
        int iA = 0;
        Iterator<k> it = this.f3565a.values().iterator();
        while (true) {
            i = iA;
            if (it.hasNext()) {
                iA = it.next().a() + i;
            }
        }
        return i;
    }
}
