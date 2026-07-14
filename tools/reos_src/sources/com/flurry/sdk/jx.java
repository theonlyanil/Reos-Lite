package com.flurry.sdk;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class jx<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<K, List<V>> f4538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4539b;

    public jx() {
        this.f4538a = new HashMap();
    }

    public jx(Map<K, List<V>> map) {
        this.f4538a = map;
    }

    private List<V> a(K k, boolean z) {
        List<V> arrayList = this.f4538a.get(k);
        if (z && arrayList == null) {
            arrayList = this.f4539b > 0 ? new ArrayList<>(this.f4539b) : new ArrayList<>();
            this.f4538a.put(k, arrayList);
        }
        return arrayList;
    }

    public List<V> a(K k) {
        List<V> listA;
        return (k == null || (listA = a((Object) k, false)) == null) ? Collections.emptyList() : listA;
    }

    public void a() {
        this.f4538a.clear();
    }

    public void a(jx<K, V> jxVar) {
        if (jxVar == null) {
            return;
        }
        for (Map.Entry<K, List<V>> entry : jxVar.f4538a.entrySet()) {
            a((Object) entry.getKey(), true).addAll(entry.getValue());
        }
    }

    public void a(K k, V v) {
        if (k == null) {
            return;
        }
        a((Object) k, true).add(v);
    }

    public Collection<Map.Entry<K, V>> b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, List<V>> entry : this.f4538a.entrySet()) {
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(entry.getKey(), it.next()));
            }
        }
        return arrayList;
    }

    public boolean b(K k) {
        if (k == null) {
            return false;
        }
        return this.f4538a.remove(k) != null;
    }

    public boolean b(K k, V v) {
        List<V> listA;
        boolean zRemove = false;
        if (k != null && (listA = a((Object) k, false)) != null) {
            zRemove = listA.remove(v);
            if (listA.size() == 0) {
                this.f4538a.remove(k);
            }
        }
        return zRemove;
    }

    public Set<K> c() {
        return this.f4538a.keySet();
    }

    public boolean c(K k) {
        if (k == null) {
            return false;
        }
        return this.f4538a.containsKey(k);
    }

    public boolean c(K k, V v) {
        List<V> listA;
        if (k == null || (listA = a((Object) k, false)) == null) {
            return false;
        }
        return listA.contains(v);
    }

    public Collection<V> d() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<K, List<V>>> it = this.f4538a.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getValue());
        }
        return arrayList;
    }
}
