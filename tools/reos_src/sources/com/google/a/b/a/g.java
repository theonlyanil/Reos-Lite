package com.google.a.b.a;

import com.google.a.r;
import com.google.a.u;
import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f5102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.a.b.c f5103b;

    private final class a<K, V> extends x<Map<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x<K> f5105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final x<V> f5106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.google.a.b.h<? extends Map<K, V>> f5107d;

        public a(com.google.a.f fVar, Type type, x<K> xVar, Type type2, x<V> xVar2, com.google.a.b.h<? extends Map<K, V>> hVar) {
            this.f5105b = new l(fVar, xVar, type);
            this.f5106c = new l(fVar, xVar2, type2);
            this.f5107d = hVar;
        }

        private String a(com.google.a.l lVar) {
            if (!lVar.i()) {
                if (lVar.j()) {
                    return "null";
                }
                throw new AssertionError();
            }
            r rVarM = lVar.m();
            if (rVarM.p()) {
                return String.valueOf(rVarM.a());
            }
            if (rVarM.o()) {
                return Boolean.toString(rVarM.f());
            }
            if (rVarM.q()) {
                return rVarM.b();
            }
            throw new AssertionError();
        }

        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(com.google.a.d.a aVar) throws IOException {
            com.google.a.d.b bVarF = aVar.f();
            if (bVarF == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> mapA = this.f5107d.a();
            if (bVarF != com.google.a.d.b.BEGIN_ARRAY) {
                aVar.c();
                while (aVar.e()) {
                    com.google.a.b.e.f5195a.a(aVar);
                    K kB = this.f5105b.b(aVar);
                    if (mapA.put(kB, this.f5106c.b(aVar)) != null) {
                        throw new u("duplicate key: " + kB);
                    }
                }
                aVar.d();
                return mapA;
            }
            aVar.a();
            while (aVar.e()) {
                aVar.a();
                K kB2 = this.f5105b.b(aVar);
                if (mapA.put(kB2, this.f5106c.b(aVar)) != null) {
                    throw new u("duplicate key: " + kB2);
                }
                aVar.b();
            }
            aVar.b();
            return mapA;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                cVar.f();
                return;
            }
            if (!g.this.f5102a) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.f5106c.a(cVar, entry.getValue());
                }
                cVar.e();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.a.l lVarA = this.f5105b.a(entry2.getKey());
                arrayList.add(lVarA);
                arrayList2.add(entry2.getValue());
                z = (lVarA.g() || lVarA.h()) | z;
            }
            if (!z) {
                cVar.d();
                while (i < arrayList.size()) {
                    cVar.a(a((com.google.a.l) arrayList.get(i)));
                    this.f5106c.a(cVar, (V) arrayList2.get(i));
                    i++;
                }
                cVar.e();
                return;
            }
            cVar.b();
            while (i < arrayList.size()) {
                cVar.b();
                com.google.a.b.j.a((com.google.a.l) arrayList.get(i), cVar);
                this.f5106c.a(cVar, (V) arrayList2.get(i));
                cVar.c();
                i++;
            }
            cVar.c();
        }
    }

    public g(com.google.a.b.c cVar, boolean z) {
        this.f5103b = cVar;
        this.f5102a = z;
    }

    private x<?> a(com.google.a.f fVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? m.f5134f : fVar.a((com.google.a.c.a) com.google.a.c.a.get(type));
    }

    @Override // com.google.a.y
    public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] typeArrB = com.google.a.b.b.b(type, com.google.a.b.b.e(type));
        return new a(fVar, typeArrB[0], a(fVar, typeArrB[0]), typeArrB[1], fVar.a((com.google.a.c.a) com.google.a.c.a.get(typeArrB[1])), this.f5103b.a(aVar));
    }
}
