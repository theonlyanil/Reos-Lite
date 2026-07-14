package com.google.b.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p[] f5632a;

    public j(Map<com.google.b.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(com.google.b.e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(com.google.b.a.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(com.google.b.a.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(com.google.b.a.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(com.google.b.a.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.f5632a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // com.google.b.g.k
    public com.google.b.m a(int i, com.google.b.c.a aVar, Map<com.google.b.e, ?> map) throws com.google.b.i {
        int[] iArrA = p.a(aVar);
        for (p pVar : this.f5632a) {
            try {
                com.google.b.m mVarA = pVar.a(i, aVar, iArrA, map);
                boolean z = mVarA.d() == com.google.b.a.EAN_13 && mVarA.a().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(com.google.b.e.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(com.google.b.a.UPC_A);
                if (!z || !z2) {
                    return mVarA;
                }
                com.google.b.m mVar = new com.google.b.m(mVarA.a().substring(1), mVarA.b(), mVarA.c(), com.google.b.a.UPC_A);
                mVar.a(mVarA.e());
                return mVar;
            } catch (com.google.b.l e2) {
            }
        }
        throw com.google.b.i.a();
    }

    @Override // com.google.b.g.k, com.google.b.k
    public void a() {
        for (p pVar : this.f5632a) {
            pVar.a();
        }
    }
}
