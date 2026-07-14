package com.a.a.d.b.a;

import com.a.a.d.b.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class e<K extends h, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f2056a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f2057b = new HashMap();

    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a<K, V> f2058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a<K, V> f2059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final K f2060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<V> f2061d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.f2059b = this;
            this.f2058a = this;
            this.f2060c = k;
        }

        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.f2061d.remove(iB - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f2061d == null) {
                this.f2061d = new ArrayList();
            }
            this.f2061d.add(v);
        }

        public int b() {
            if (this.f2061d != null) {
                return this.f2061d.size();
            }
            return 0;
        }
    }

    e() {
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.f2059b = this.f2056a;
        aVar.f2058a = this.f2056a.f2058a;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.f2059b = this.f2056a.f2059b;
        aVar.f2058a = this.f2056a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f2058a.f2059b = aVar;
        aVar.f2059b.f2058a = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f2059b.f2058a = aVar.f2058a;
        aVar.f2058a.f2059b = aVar.f2059b;
    }

    public V a() {
        a aVar = this.f2056a.f2059b;
        while (true) {
            a aVar2 = aVar;
            if (aVar2.equals(this.f2056a)) {
                return null;
            }
            V v = (V) aVar2.a();
            if (v != null) {
                return v;
            }
            d(aVar2);
            this.f2057b.remove(aVar2.f2060c);
            ((h) aVar2.f2060c).a();
            aVar = aVar2.f2059b;
        }
    }

    public V a(K k) {
        a<K, V> aVar = this.f2057b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f2057b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f2057b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f2057b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f2056a.f2058a; !aVar.equals(this.f2056a); aVar = aVar.f2058a) {
            z = true;
            sb.append('{').append(aVar.f2060c).append(':').append(aVar.b()).append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }
}
