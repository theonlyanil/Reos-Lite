package com.google.a.b.a;

import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.a.b.c f5087a;

    private static final class a<E> extends x<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x<E> f5088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.a.b.h<? extends Collection<E>> f5089b;

        public a(com.google.a.f fVar, Type type, x<E> xVar, com.google.a.b.h<? extends Collection<E>> hVar) {
            this.f5088a = new l(fVar, xVar, type);
            this.f5089b = hVar;
        }

        @Override // com.google.a.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> collectionA = this.f5089b.a();
            aVar.a();
            while (aVar.e()) {
                collectionA.add(this.f5088a.b(aVar));
            }
            aVar.b();
            return collectionA;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.f();
                return;
            }
            cVar.b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f5088a.a(cVar, it.next());
            }
            cVar.c();
        }
    }

    public b(com.google.a.b.c cVar) {
        this.f5087a = cVar;
    }

    @Override // com.google.a.y
    public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeA = com.google.a.b.b.a(type, (Class<?>) rawType);
        return new a(fVar, typeA, fVar.a((com.google.a.c.a) com.google.a.c.a.get(typeA)), this.f5087a.a(aVar));
    }
}
