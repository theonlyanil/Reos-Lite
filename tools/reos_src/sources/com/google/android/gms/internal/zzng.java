package com.google.android.gms.internal;

import android.support.v4.h.a;
import android.support.v4.h.i;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzng<E> extends AbstractSet<E> {
    private final a<E, E> zzami;

    public zzng() {
        this.zzami = new a<>();
    }

    public zzng(int i) {
        this.zzami = new a<>(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzng(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        if (this.zzami.containsKey(e2)) {
            return false;
        }
        this.zzami.put(e2, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zzng ? zza((zzng) collection) : super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.zzami.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.zzami.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.zzami.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (!this.zzami.containsKey(obj)) {
            return false;
        }
        this.zzami.remove(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.zzami.size();
    }

    public boolean zza(zzng<? extends E> zzngVar) {
        int size = size();
        this.zzami.a((i<? extends E, ? extends E>) zzngVar.zzami);
        return size() > size;
    }
}
