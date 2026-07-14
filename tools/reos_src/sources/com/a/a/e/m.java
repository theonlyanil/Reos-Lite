package com.a.a.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.a.a.h.c> f2384a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.a.a.h.c> f2385b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2386c;

    public void a() {
        this.f2386c = true;
        for (com.a.a.h.c cVar : com.a.a.j.h.a(this.f2384a)) {
            if (cVar.f()) {
                cVar.e();
                this.f2385b.add(cVar);
            }
        }
    }

    public void a(com.a.a.h.c cVar) {
        this.f2384a.add(cVar);
        if (this.f2386c) {
            this.f2385b.add(cVar);
        } else {
            cVar.b();
        }
    }

    public void b() {
        this.f2386c = false;
        for (com.a.a.h.c cVar : com.a.a.j.h.a(this.f2384a)) {
            if (!cVar.g() && !cVar.i() && !cVar.f()) {
                cVar.b();
            }
        }
        this.f2385b.clear();
    }

    public void b(com.a.a.h.c cVar) {
        this.f2384a.remove(cVar);
        this.f2385b.remove(cVar);
    }

    public void c() {
        Iterator it = com.a.a.j.h.a(this.f2384a).iterator();
        while (it.hasNext()) {
            ((com.a.a.h.c) it.next()).d();
        }
        this.f2385b.clear();
    }

    public void d() {
        for (com.a.a.h.c cVar : com.a.a.j.h.a(this.f2384a)) {
            if (!cVar.g() && !cVar.i()) {
                cVar.e();
                if (this.f2386c) {
                    this.f2385b.add(cVar);
                } else {
                    cVar.b();
                }
            }
        }
    }
}
