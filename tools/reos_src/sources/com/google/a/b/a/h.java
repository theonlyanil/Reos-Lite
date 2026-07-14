package com.google.a.b.a;

import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h extends x<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f5108a = new y() { // from class: com.google.a.b.a.h.1
        @Override // com.google.a.y
        public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.a.f f5109b;

    h(com.google.a.f fVar) {
        this.f5109b = fVar;
    }

    @Override // com.google.a.x
    public void a(com.google.a.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        x xVarA = this.f5109b.a((Class) obj.getClass());
        if (!(xVarA instanceof h)) {
            xVarA.a(cVar, obj);
        } else {
            cVar.d();
            cVar.e();
        }
    }

    @Override // com.google.a.x
    public Object b(com.google.a.d.a aVar) throws IOException {
        switch (aVar.f()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(b(aVar));
                }
                aVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                com.google.a.b.g gVar = new com.google.a.b.g();
                aVar.c();
                while (aVar.e()) {
                    gVar.put(aVar.g(), b(aVar));
                }
                aVar.d();
                return gVar;
            case STRING:
                return aVar.h();
            case NUMBER:
                return Double.valueOf(aVar.k());
            case BOOLEAN:
                return Boolean.valueOf(aVar.i());
            case NULL:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
