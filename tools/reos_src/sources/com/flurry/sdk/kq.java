package com.flurry.sdk;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class kq<T> extends WeakReference<T> {
    public kq(T t) {
        super(t);
    }

    public boolean equals(Object obj) {
        Object obj2 = get();
        return obj instanceof Reference ? obj2.equals(((Reference) obj).get()) : obj2.equals(obj);
    }

    public int hashCode() {
        Object obj = get();
        return obj == null ? super.hashCode() : obj.hashCode();
    }
}
