package com.a.a.d.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.a.a.d.b.b.h.a, com.a.a.d.b.e, h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.a.a.d.c, com.a.a.d.b.d> f2105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f2106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.b.b.h f2107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f2108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<com.a.a.d.c, WeakReference<h<?>>> f2109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l f2110f;
    private final b g;
    private ReferenceQueue<h<?>> h;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f2111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ExecutorService f2112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.a.a.d.b.e f2113c;

        public a(ExecutorService executorService, ExecutorService executorService2, com.a.a.d.b.e eVar) {
            this.f2111a = executorService;
            this.f2112b = executorService2;
            this.f2113c = eVar;
        }

        public com.a.a.d.b.d a(com.a.a.d.c cVar, boolean z) {
            return new com.a.a.d.b.d(cVar, this.f2111a, this.f2112b, z, this.f2113c);
        }
    }

    private static class b implements com.a.a.d.b.a.InterfaceC0038a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.a.a.d.b.b.a.InterfaceC0040a f2114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile com.a.a.d.b.b.a f2115b;

        public b(com.a.a.d.b.b.a.InterfaceC0040a interfaceC0040a) {
            this.f2114a = interfaceC0040a;
        }

        @Override // com.a.a.d.b.a.InterfaceC0038a
        public com.a.a.d.b.b.a a() {
            if (this.f2115b == null) {
                synchronized (this) {
                    if (this.f2115b == null) {
                        this.f2115b = this.f2114a.a();
                    }
                    if (this.f2115b == null) {
                        this.f2115b = new com.a.a.d.b.b.b();
                    }
                }
            }
            return this.f2115b;
        }
    }

    /* JADX INFO: renamed from: com.a.a.d.b.c$c, reason: collision with other inner class name */
    public static class C0041c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.a.a.d.b.d f2116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.a.a.h.g f2117b;

        public C0041c(com.a.a.h.g gVar, com.a.a.d.b.d dVar) {
            this.f2117b = gVar;
            this.f2116a = dVar;
        }

        public void a() {
            this.f2116a.b(this.f2117b);
        }
    }

    private static class d implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<com.a.a.d.c, WeakReference<h<?>>> f2118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ReferenceQueue<h<?>> f2119b;

        public d(Map<com.a.a.d.c, WeakReference<h<?>>> map, ReferenceQueue<h<?>> referenceQueue) {
            this.f2118a = map;
            this.f2119b = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e eVar = (e) this.f2119b.poll();
            if (eVar == null) {
                return true;
            }
            this.f2118a.remove(eVar.f2120a);
            return true;
        }
    }

    private static class e extends WeakReference<h<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.a.a.d.c f2120a;

        public e(com.a.a.d.c cVar, h<?> hVar, ReferenceQueue<? super h<?>> referenceQueue) {
            super(hVar, referenceQueue);
            this.f2120a = cVar;
        }
    }

    public c(com.a.a.d.b.b.h hVar, com.a.a.d.b.b.a.InterfaceC0040a interfaceC0040a, ExecutorService executorService, ExecutorService executorService2) {
        this(hVar, interfaceC0040a, executorService, executorService2, null, null, null, null, null);
    }

    c(com.a.a.d.b.b.h hVar, com.a.a.d.b.b.a.InterfaceC0040a interfaceC0040a, ExecutorService executorService, ExecutorService executorService2, Map<com.a.a.d.c, com.a.a.d.b.d> map, g gVar, Map<com.a.a.d.c, WeakReference<h<?>>> map2, a aVar, l lVar) {
        this.f2107c = hVar;
        this.g = new b(interfaceC0040a);
        this.f2109e = map2 == null ? new HashMap<>() : map2;
        this.f2106b = gVar == null ? new g() : gVar;
        this.f2105a = map == null ? new HashMap<>() : map;
        this.f2108d = aVar == null ? new a(executorService, executorService2, this) : aVar;
        this.f2110f = lVar == null ? new l() : lVar;
        hVar.a(this);
    }

    private h<?> a(com.a.a.d.c cVar) {
        k<?> kVarA = this.f2107c.a(cVar);
        if (kVarA == null) {
            return null;
        }
        return kVarA instanceof h ? (h) kVarA : new h<>(kVarA, true);
    }

    private h<?> a(com.a.a.d.c cVar, boolean z) {
        h<?> hVar;
        if (!z) {
            return null;
        }
        WeakReference<h<?>> weakReference = this.f2109e.get(cVar);
        if (weakReference != null) {
            hVar = weakReference.get();
            if (hVar != null) {
                hVar.e();
            } else {
                this.f2109e.remove(cVar);
            }
        } else {
            hVar = null;
        }
        return hVar;
    }

    private ReferenceQueue<h<?>> a() {
        if (this.h == null) {
            this.h = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new d(this.f2109e, this.h));
        }
        return this.h;
    }

    private static void a(String str, long j, com.a.a.d.c cVar) {
        Log.v("Engine", str + " in " + com.a.a.j.d.a(j) + "ms, key: " + cVar);
    }

    private h<?> b(com.a.a.d.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        h<?> hVarA = a(cVar);
        if (hVarA == null) {
            return hVarA;
        }
        hVarA.e();
        this.f2109e.put(cVar, new e(cVar, hVarA, a()));
        return hVarA;
    }

    public <T, Z, R> C0041c a(com.a.a.d.c cVar, int i, int i2, com.a.a.d.a.c<T> cVar2, com.a.a.g.b<T, Z> bVar, com.a.a.d.g<Z> gVar, com.a.a.d.d.f.c<Z, R> cVar3, com.a.a.i iVar, boolean z, com.a.a.d.b.b bVar2, com.a.a.h.g gVar2) {
        com.a.a.j.h.a();
        long jA = com.a.a.j.d.a();
        f fVarA = this.f2106b.a(cVar2.b(), cVar, i, i2, bVar.a(), bVar.b(), gVar, bVar.d(), cVar3, bVar.c());
        h<?> hVarB = b(fVarA, z);
        if (hVarB != null) {
            gVar2.a(hVarB);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from cache", jA, fVarA);
            }
            return null;
        }
        h<?> hVarA = a(fVarA, z);
        if (hVarA != null) {
            gVar2.a(hVarA);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from active resources", jA, fVarA);
            }
            return null;
        }
        com.a.a.d.b.d dVar = this.f2105a.get(fVarA);
        if (dVar != null) {
            dVar.a(gVar2);
            if (Log.isLoggable("Engine", 2)) {
                a("Added to existing load", jA, fVarA);
            }
            return new C0041c(gVar2, dVar);
        }
        com.a.a.d.b.d dVarA = this.f2108d.a(fVarA, z);
        i iVar2 = new i(dVarA, new com.a.a.d.b.a(fVarA, i, i2, cVar2, bVar, gVar, cVar3, this.g, bVar2, iVar), iVar);
        this.f2105a.put(fVarA, dVarA);
        dVarA.a(gVar2);
        dVarA.a(iVar2);
        if (Log.isLoggable("Engine", 2)) {
            a("Started new load", jA, fVarA);
        }
        return new C0041c(gVar2, dVarA);
    }

    @Override // com.a.a.d.b.e
    public void a(com.a.a.d.b.d dVar, com.a.a.d.c cVar) {
        com.a.a.j.h.a();
        if (dVar.equals(this.f2105a.get(cVar))) {
            this.f2105a.remove(cVar);
        }
    }

    public void a(k kVar) {
        com.a.a.j.h.a();
        if (!(kVar instanceof h)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((h) kVar).f();
    }

    @Override // com.a.a.d.b.e
    public void a(com.a.a.d.c cVar, h<?> hVar) {
        com.a.a.j.h.a();
        if (hVar != null) {
            hVar.a(cVar, this);
            if (hVar.a()) {
                this.f2109e.put(cVar, new e(cVar, hVar, a()));
            }
        }
        this.f2105a.remove(cVar);
    }

    @Override // com.a.a.d.b.b.h.a
    public void b(k<?> kVar) {
        com.a.a.j.h.a();
        this.f2110f.a(kVar);
    }

    @Override // com.a.a.d.b.h.a
    public void b(com.a.a.d.c cVar, h hVar) {
        com.a.a.j.h.a();
        this.f2109e.remove(cVar);
        if (hVar.a()) {
            this.f2107c.b(cVar, hVar);
        } else {
            this.f2110f.a(hVar);
        }
    }
}
