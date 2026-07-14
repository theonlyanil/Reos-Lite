package android.support.v4.h;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class g<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    g<K, V>.b f799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    g<K, V>.c f800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    g<K, V>.e f801d;

    final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f805d = false;

        a(int i) {
            this.f802a = i;
            this.f803b = g.this.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f804c < this.f803b;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) g.this.a(this.f804c, this.f802a);
            this.f804c++;
            this.f805d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f805d) {
                throw new IllegalStateException();
            }
            this.f804c--;
            this.f803b--;
            this.f805d = false;
            g.this.a(this.f804c);
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iA = g.this.a();
            for (Map.Entry<K, V> entry : collection) {
                g.this.a(entry.getKey(), entry.getValue());
            }
            return iA != g.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            g.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iA = g.this.a(entry.getKey());
            if (iA >= 0) {
                return android.support.v4.h.b.a(g.this.a(iA, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iA = g.this.a() - 1;
            int iHashCode = 0;
            while (iA >= 0) {
                Object objA = g.this.a(iA, 0);
                Object objA2 = g.this.a(iA, 1);
                iA--;
                iHashCode += (objA2 == null ? 0 : objA2.hashCode()) ^ (objA == null ? 0 : objA.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return g.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return g.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            g.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return g.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return g.a((Map) g.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iA = g.this.a() - 1; iA >= 0; iA--) {
                Object objA = g.this.a(iA, 0);
                iHashCode += objA == null ? 0 : objA.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return g.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iA = g.this.a(obj);
            if (iA < 0) {
                return false;
            }
            g.this.a(iA);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return g.b(g.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return g.c(g.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return g.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return g.this.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.a(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f809a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f811c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f810b = -1;

        d() {
            this.f809a = g.this.a() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f810b++;
            this.f811c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.f811c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return android.support.v4.h.b.a(entry.getKey(), g.this.a(this.f810b, 0)) && android.support.v4.h.b.a(entry.getValue(), g.this.a(this.f810b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f811c) {
                return (K) g.this.a(this.f810b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f811c) {
                return (V) g.this.a(this.f810b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f810b < this.f809a;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.f811c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objA = g.this.a(this.f810b, 0);
            Object objA2 = g.this.a(this.f810b, 1);
            return (objA2 != null ? objA2.hashCode() : 0) ^ (objA == null ? 0 : objA.hashCode());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f811c) {
                throw new IllegalStateException();
            }
            g.this.a(this.f810b);
            this.f810b--;
            this.f809a--;
            this.f811c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f811c) {
                return (V) g.this.a(this.f810b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            g.this.c();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return g.this.b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return g.this.a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iB = g.this.b(obj);
            if (iB < 0) {
                return false;
            }
            g.this.a(iB);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int iA = g.this.a();
            boolean z = false;
            while (i < iA) {
                if (collection.contains(g.this.a(i, 1))) {
                    g.this.a(i);
                    i--;
                    iA--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int iA = g.this.a();
            boolean z = false;
            while (i < iA) {
                if (!collection.contains(g.this.a(i, 1))) {
                    g.this.a(i);
                    i--;
                    iA--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return g.this.a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return g.this.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.a(tArr, 1);
        }
    }

    g() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (ClassCastException e2) {
            return false;
        } catch (NullPointerException e3) {
            return false;
        }
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    public <T> T[] a(T[] tArr, int i) {
        int iA = a();
        Object[] objArr = tArr.length < iA ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iA)) : tArr;
        for (int i2 = 0; i2 < iA; i2++) {
            objArr[i2] = a(i2, i);
        }
        if (objArr.length > iA) {
            objArr[iA] = null;
        }
        return (T[]) objArr;
    }

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    public Object[] b(int i) {
        int iA = a();
        Object[] objArr = new Object[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    protected abstract void c();

    public Set<Map.Entry<K, V>> d() {
        if (this.f799b == null) {
            this.f799b = new b();
        }
        return this.f799b;
    }

    public Set<K> e() {
        if (this.f800c == null) {
            this.f800c = new c();
        }
        return this.f800c;
    }

    public Collection<V> f() {
        if (this.f801d == null) {
            this.f801d = new e();
        }
        return this.f801d;
    }
}
