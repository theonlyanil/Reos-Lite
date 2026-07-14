package com.google.b.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k[] f5631a;

    public i(Map<com.google.b.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(com.google.b.e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(com.google.b.e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(com.google.b.a.EAN_13) || collection.contains(com.google.b.a.UPC_A) || collection.contains(com.google.b.a.EAN_8) || collection.contains(com.google.b.a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(com.google.b.a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(com.google.b.a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(com.google.b.a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(com.google.b.a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(com.google.b.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(com.google.b.a.RSS_14)) {
                arrayList.add(new com.google.b.g.a.e());
            }
            if (collection.contains(com.google.b.a.RSS_EXPANDED)) {
                arrayList.add(new com.google.b.g.a.a.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new com.google.b.g.a.e());
            arrayList.add(new com.google.b.g.a.a.d());
        }
        this.f5631a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i {
        for (k kVar : this.f5631a) {
            try {
                return kVar.a(i, aVar, map);
            } catch (com.google.b.l e2) {
            }
        }
        throw com.google.b.i.a();
    }

    @Override // com.google.b.g.k, com.google.b.k
    public void a() {
        for (k kVar : this.f5631a) {
            kVar.a();
        }
    }
}
