package com.google.a.b.a;

import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a<E> extends x<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f5083a = new y() { // from class: com.google.a.b.a.a.1
        @Override // com.google.a.y
        public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeG = com.google.a.b.b.g(type);
            return new a(fVar, fVar.a((com.google.a.c.a) com.google.a.c.a.get(typeG)), com.google.a.b.b.e(typeG));
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<E> f5084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<E> f5085c;

    public a(com.google.a.f fVar, x<E> xVar, Class<E> cls) {
        this.f5085c = new l(fVar, xVar, cls);
        this.f5084b = cls;
    }

    @Override // com.google.a.x
    public void a(com.google.a.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        cVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f5085c.a(cVar, (E) Array.get(obj, i));
        }
        cVar.c();
    }

    @Override // com.google.a.x
    public Object b(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() == com.google.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.f5085c.b(aVar));
        }
        aVar.b();
        Object objNewInstance = Array.newInstance((Class<?>) this.f5084b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }
}
