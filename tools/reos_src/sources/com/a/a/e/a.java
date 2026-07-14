package com.a.a.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<h> f2364a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2366c;

    a() {
    }

    void a() {
        this.f2365b = true;
        Iterator it = com.a.a.j.h.a(this.f2364a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).d();
        }
    }

    @Override // com.a.a.e.g
    public void a(h hVar) {
        this.f2364a.add(hVar);
        if (this.f2366c) {
            hVar.f();
        } else if (this.f2365b) {
            hVar.d();
        } else {
            hVar.e();
        }
    }

    void b() {
        this.f2365b = false;
        Iterator it = com.a.a.j.h.a(this.f2364a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).e();
        }
    }

    void c() {
        this.f2366c = true;
        Iterator it = com.a.a.j.h.a(this.f2364a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).f();
        }
    }
}
