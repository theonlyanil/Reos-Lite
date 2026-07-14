package com.facebook.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class j implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<com.facebook.a.a, List<b>> f3603a = new HashMap<>();

    static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap<com.facebook.a.a, List<b>> f3604a;

        private a(HashMap<com.facebook.a.a, List<b>> map) {
            this.f3604a = map;
        }

        private Object readResolve() {
            return new j(this.f3604a);
        }
    }

    public j() {
    }

    public j(HashMap<com.facebook.a.a, List<b>> map) {
        this.f3603a.putAll(map);
    }

    private Object writeReplace() {
        return new a(this.f3603a);
    }

    public List<b> a(com.facebook.a.a aVar) {
        return this.f3603a.get(aVar);
    }

    public Set<com.facebook.a.a> a() {
        return this.f3603a.keySet();
    }

    public void a(com.facebook.a.a aVar, List<b> list) {
        if (this.f3603a.containsKey(aVar)) {
            this.f3603a.get(aVar).addAll(list);
        } else {
            this.f3603a.put(aVar, list);
        }
    }

    public boolean b(com.facebook.a.a aVar) {
        return this.f3603a.containsKey(aVar);
    }
}
