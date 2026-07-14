package com.google.a.b.a;

import com.google.a.u;
import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.a.b.c f5111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.a.e f5112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.a.b.d f5113c;

    public static final class a<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.a.b.h<T> f5120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, b> f5121b;

        a(com.google.a.b.h<T> hVar, Map<String, b> map) {
            this.f5120a = hVar;
            this.f5121b = map;
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.f5121b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.g);
                        bVar.a(cVar, t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.a.x
        public T b(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T tA = this.f5120a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f5121b.get(aVar.g());
                    if (bVar == null || !bVar.i) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, tA);
                    }
                }
                aVar.d();
                return tA;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new u(e3);
            }
        }
    }

    static abstract class b {
        final String g;
        final boolean h;
        final boolean i;

        protected b(String str, boolean z, boolean z2) {
            this.g = str;
            this.h = z;
            this.i = z2;
        }

        abstract void a(com.google.a.d.a aVar, Object obj) throws IllegalAccessException, IOException;

        abstract void a(com.google.a.d.c cVar, Object obj) throws IllegalAccessException, IOException;

        abstract boolean a(Object obj) throws IllegalAccessException, IOException;
    }

    public i(com.google.a.b.c cVar, com.google.a.e eVar, com.google.a.b.d dVar) {
        this.f5111a = cVar;
        this.f5112b = eVar;
        this.f5113c = dVar;
    }

    private b a(final com.google.a.f fVar, final Field field, String str, final com.google.a.c.a<?> aVar, boolean z, boolean z2) {
        final boolean zA = com.google.a.b.i.a((Type) aVar.getRawType());
        return new b(str, z, z2) { // from class: com.google.a.b.a.i.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final x<?> f5114a;

            {
                this.f5114a = i.this.a(fVar, field, aVar);
            }

            @Override // com.google.a.b.a.i.b
            void a(com.google.a.d.a aVar2, Object obj) throws IllegalAccessException, IOException {
                Object objB = this.f5114a.b(aVar2);
                if (objB == null && zA) {
                    return;
                }
                field.set(obj, objB);
            }

            @Override // com.google.a.b.a.i.b
            void a(com.google.a.d.c cVar, Object obj) throws IllegalAccessException, IOException {
                new l(fVar, this.f5114a, aVar.getType()).a(cVar, field.get(obj));
            }

            @Override // com.google.a.b.a.i.b
            public boolean a(Object obj) throws IllegalAccessException, IOException {
                return this.h && field.get(obj) != obj;
            }
        };
    }

    static List<String> a(com.google.a.e eVar, Field field) {
        com.google.a.a.c cVar = (com.google.a.a.c) field.getAnnotation(com.google.a.a.c.class);
        LinkedList linkedList = new LinkedList();
        if (cVar == null) {
            linkedList.add(eVar.a(field));
        } else {
            linkedList.add(cVar.a());
            String[] strArrB = cVar.b();
            for (String str : strArrB) {
                linkedList.add(str);
            }
        }
        return linkedList;
    }

    private List<String> a(Field field) {
        return a(this.f5112b, field);
    }

    private Map<String, b> a(com.google.a.f fVar, com.google.a.c.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean zA = a(field, true);
                boolean zA2 = a(field, false);
                if (zA || zA2) {
                    field.setAccessible(true);
                    Type typeA = com.google.a.b.b.a(aVar.getType(), cls, field.getGenericType());
                    List<String> listA = a(field);
                    b bVar = null;
                    int i = 0;
                    while (i < listA.size()) {
                        String str = listA.get(i);
                        if (i != 0) {
                            zA = false;
                        }
                        b bVar2 = (b) linkedHashMap.put(str, a(fVar, field, str, com.google.a.c.a.get(typeA), zA, zA2));
                        if (bVar != null) {
                            bVar2 = bVar;
                        }
                        i++;
                        bVar = bVar2;
                    }
                    if (bVar != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar.g);
                    }
                }
            }
            aVar = com.google.a.c.a.get(com.google.a.b.b.a(aVar.getType(), cls, cls.getGenericSuperclass()));
            cls = aVar.getRawType();
        }
        return linkedHashMap;
    }

    static boolean a(Field field, boolean z, com.google.a.b.d dVar) {
        return (dVar.a(field.getType(), z) || dVar.a(field, z)) ? false : true;
    }

    @Override // com.google.a.y
    public <T> x<T> a(com.google.a.f fVar, com.google.a.c.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new a(this.f5111a.a(aVar), a(fVar, (com.google.a.c.a<?>) aVar, (Class<?>) rawType));
        }
        return null;
    }

    x<?> a(com.google.a.f fVar, Field field, com.google.a.c.a<?> aVar) {
        x<?> xVarA;
        com.google.a.a.b bVar = (com.google.a.a.b) field.getAnnotation(com.google.a.a.b.class);
        return (bVar == null || (xVarA = d.a(this.f5111a, fVar, aVar, bVar)) == null) ? fVar.a((com.google.a.c.a) aVar) : xVarA;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.f5113c);
    }
}
