package com.google.a.b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f5197f;
    private static final Comparator<Comparable> g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Comparator<? super K> f5198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d<K, V> f5199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final d<K, V> f5202e;
    private g<K, V>.a h;
    private g<K, V>.b i;

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new g<K, V>.c<Map.Entry<K, V>>() { // from class: com.google.a.b.g.a.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> next() {
                    return b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            d<K, V> dVarA;
            if (!(obj instanceof Map.Entry) || (dVarA = g.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            g.this.a((d) dVarA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.f5200c;
        }
    }

    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new g<K, V>.c<K>() { // from class: com.google.a.b.g.b.1
                {
                    g gVar = g.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return b().f5216f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return g.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.f5200c;
        }
    }

    private abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d<K, V> f5207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        d<K, V> f5208c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5209d;

        c() {
            this.f5207b = g.this.f5202e.f5214d;
            this.f5209d = g.this.f5201d;
        }

        final d<K, V> b() {
            d<K, V> dVar = this.f5207b;
            if (dVar == g.this.f5202e) {
                throw new NoSuchElementException();
            }
            if (g.this.f5201d != this.f5209d) {
                throw new ConcurrentModificationException();
            }
            this.f5207b = dVar.f5214d;
            this.f5208c = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5207b != g.this.f5202e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f5208c == null) {
                throw new IllegalStateException();
            }
            g.this.a((d) this.f5208c, true);
            this.f5208c = null;
            this.f5209d = g.this.f5201d;
        }
    }

    static final class d<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d<K, V> f5211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d<K, V> f5212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        d<K, V> f5213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d<K, V> f5214d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        d<K, V> f5215e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f5216f;
        V g;
        int h;

        d() {
            this.f5216f = null;
            this.f5215e = this;
            this.f5214d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f5211a = dVar;
            this.f5216f = k;
            this.h = 1;
            this.f5214d = dVar2;
            this.f5215e = dVar3;
            dVar3.f5214d = this;
            dVar2.f5215e = this;
        }

        public d<K, V> a() {
            for (d<K, V> dVar = this.f5212b; dVar != null; dVar = dVar.f5212b) {
                this = dVar;
            }
            return this;
        }

        public d<K, V> b() {
            for (d<K, V> dVar = this.f5213c; dVar != null; dVar = dVar.f5213c) {
                this = dVar;
            }
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f5216f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f5216f.equals(entry.getKey())) {
                return false;
            }
            if (this.g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5216f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.f5216f == null ? 0 : this.f5216f.hashCode()) ^ (this.g != null ? this.g.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return this.f5216f + "=" + this.g;
        }
    }

    static {
        f5197f = !g.class.desiredAssertionStatus();
        g = new Comparator<Comparable>() { // from class: com.google.a.b.g.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
    }

    public g() {
        this(g);
    }

    public g(Comparator<? super K> comparator) {
        this.f5200c = 0;
        this.f5201d = 0;
        this.f5202e = new d<>();
        this.f5198a = comparator == null ? g : comparator;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f5212b;
        d<K, V> dVar3 = dVar.f5213c;
        d<K, V> dVar4 = dVar3.f5212b;
        d<K, V> dVar5 = dVar3.f5213c;
        dVar.f5213c = dVar4;
        if (dVar4 != null) {
            dVar4.f5211a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f5212b = dVar;
        dVar.f5211a = dVar3;
        dVar.h = Math.max(dVar2 != null ? dVar2.h : 0, dVar4 != null ? dVar4.h : 0) + 1;
        dVar3.h = Math.max(dVar.h, dVar5 != null ? dVar5.h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f5211a;
        dVar.f5211a = null;
        if (dVar2 != null) {
            dVar2.f5211a = dVar3;
        }
        if (dVar3 == null) {
            this.f5199b = dVar2;
            return;
        }
        if (dVar3.f5212b == dVar) {
            dVar3.f5212b = dVar2;
        } else {
            if (!f5197f && dVar3.f5213c != dVar) {
                throw new AssertionError();
            }
            dVar3.f5213c = dVar2;
        }
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f5212b;
        d<K, V> dVar3 = dVar.f5213c;
        d<K, V> dVar4 = dVar2.f5212b;
        d<K, V> dVar5 = dVar2.f5213c;
        dVar.f5212b = dVar5;
        if (dVar5 != null) {
            dVar5.f5211a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f5213c = dVar;
        dVar.f5211a = dVar2;
        dVar.h = Math.max(dVar3 != null ? dVar3.h : 0, dVar5 != null ? dVar5.h : 0) + 1;
        dVar2.h = Math.max(dVar.h, dVar4 != null ? dVar4.h : 0) + 1;
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f5212b;
            d<K, V> dVar3 = dVar.f5213c;
            int i = dVar2 != null ? dVar2.h : 0;
            int i2 = dVar3 != null ? dVar3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.f5212b;
                d<K, V> dVar5 = dVar3.f5213c;
                int i4 = (dVar4 != null ? dVar4.h : 0) - (dVar5 != null ? dVar5.h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    a((d) dVar);
                } else {
                    if (!f5197f && i4 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar3);
                    a((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                d<K, V> dVar6 = dVar2.f5212b;
                d<K, V> dVar7 = dVar2.f5213c;
                int i5 = (dVar6 != null ? dVar6.h : 0) - (dVar7 != null ? dVar7.h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    b((d) dVar);
                } else {
                    if (!f5197f && i5 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar2);
                    b((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                dVar.h = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!f5197f && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                dVar.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f5211a;
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    d<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException e2) {
            return null;
        }
    }

    d<K, V> a(K k, boolean z) {
        d<K, V> dVar;
        int i;
        d<K, V> dVar2;
        Comparator<? super K> comparator = this.f5198a;
        d<K, V> dVar3 = this.f5199b;
        if (dVar3 != null) {
            Comparable comparable = comparator == g ? (Comparable) k : null;
            while (true) {
                int iCompareTo = comparable != null ? comparable.compareTo(dVar3.f5216f) : comparator.compare(k, dVar3.f5216f);
                if (iCompareTo == 0) {
                    return dVar3;
                }
                d<K, V> dVar4 = iCompareTo < 0 ? dVar3.f5212b : dVar3.f5213c;
                if (dVar4 == null) {
                    int i2 = iCompareTo;
                    dVar = dVar3;
                    i = i2;
                    break;
                }
                dVar3 = dVar4;
            }
        } else {
            dVar = dVar3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar5 = this.f5202e;
        if (dVar != null) {
            dVar2 = new d<>(dVar, k, dVar5, dVar5.f5215e);
            if (i < 0) {
                dVar.f5212b = dVar2;
            } else {
                dVar.f5213c = dVar2;
            }
            b(dVar, true);
        } else {
            if (comparator == g && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            dVar2 = new d<>(dVar, k, dVar5, dVar5.f5215e);
            this.f5199b = dVar2;
        }
        this.f5200c++;
        this.f5201d++;
        return dVar2;
    }

    d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> dVarA = a(entry.getKey());
        if (dVarA != null && a(dVarA.g, entry.getValue())) {
            return dVarA;
        }
        return null;
    }

    void a(d<K, V> dVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            dVar.f5215e.f5214d = dVar.f5214d;
            dVar.f5214d.f5215e = dVar.f5215e;
        }
        d<K, V> dVar2 = dVar.f5212b;
        d<K, V> dVar3 = dVar.f5213c;
        d<K, V> dVar4 = dVar.f5211a;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                a((d) dVar, (d) dVar2);
                dVar.f5212b = null;
            } else if (dVar3 != null) {
                a((d) dVar, (d) dVar3);
                dVar.f5213c = null;
            } else {
                a((d) dVar, (d) null);
            }
            b(dVar4, false);
            this.f5200c--;
            this.f5201d++;
            return;
        }
        d<K, V> dVarB = dVar2.h > dVar3.h ? dVar2.b() : dVar3.a();
        a((d) dVarB, false);
        d<K, V> dVar5 = dVar.f5212b;
        if (dVar5 != null) {
            i = dVar5.h;
            dVarB.f5212b = dVar5;
            dVar5.f5211a = dVarB;
            dVar.f5212b = null;
        } else {
            i = 0;
        }
        d<K, V> dVar6 = dVar.f5213c;
        if (dVar6 != null) {
            i2 = dVar6.h;
            dVarB.f5213c = dVar6;
            dVar6.f5211a = dVarB;
            dVar.f5213c = null;
        }
        dVarB.h = Math.max(i, i2) + 1;
        a((d) dVar, (d) dVarB);
    }

    d<K, V> b(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            a((d) dVarA, true);
        }
        return dVarA;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f5199b = null;
        this.f5200c = 0;
        this.f5201d++;
        d<K, V> dVar = this.f5202e;
        dVar.f5215e = dVar;
        dVar.f5214d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.a aVar = this.h;
        if (aVar != null) {
            return aVar;
        }
        g<K, V>.a aVar2 = new a();
        this.h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            return dVarA.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g<K, V>.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> dVarA = a((Object) k, true);
        V v2 = dVarA.g;
        dVarA.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> dVarB = b(obj);
        if (dVarB != null) {
            return dVarB.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f5200c;
    }
}
