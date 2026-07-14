package com.google.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<e, ?> f5650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k[] f5651b;

    private m c(c cVar) throws i {
        if (this.f5651b != null) {
            for (k kVar : this.f5651b) {
                try {
                    return kVar.a(cVar, this.f5650a);
                } catch (l e2) {
                }
            }
        }
        throw i.a();
    }

    @Override // com.google.b.k
    public m a(c cVar) throws i {
        a((Map<e, ?>) null);
        return c(cVar);
    }

    @Override // com.google.b.k
    public m a(c cVar, Map<e, ?> map) throws i {
        a(map);
        return c(cVar);
    }

    @Override // com.google.b.k
    public void a() {
        if (this.f5651b != null) {
            for (k kVar : this.f5651b) {
                kVar.a();
            }
        }
    }

    public void a(Map<e, ?> map) {
        this.f5650a = map;
        boolean z = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z2 = collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODABAR) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED);
            if (z2 && !z) {
                arrayList.add(new com.google.b.g.i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new com.google.b.i.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new com.google.b.d.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new com.google.b.a.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new com.google.b.h.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new com.google.b.f.a());
            }
            if (z2 && z) {
                arrayList.add(new com.google.b.g.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z) {
                arrayList.add(new com.google.b.g.i(map));
            }
            arrayList.add(new com.google.b.i.a());
            arrayList.add(new com.google.b.d.a());
            arrayList.add(new com.google.b.a.b());
            arrayList.add(new com.google.b.h.b());
            arrayList.add(new com.google.b.f.a());
            if (z) {
                arrayList.add(new com.google.b.g.i(map));
            }
        }
        this.f5651b = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    public m b(c cVar) throws i {
        if (this.f5651b == null) {
            a((Map<e, ?>) null);
        }
        return c(cVar);
    }
}
