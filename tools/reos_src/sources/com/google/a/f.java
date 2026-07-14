package com.google.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final j f5252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s f5253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadLocal<Map<com.google.a.c.a<?>, a<?>>> f5254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<com.google.a.c.a<?>, x<?>> f5255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<y> f5256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.a.b.c f5257f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    static class a<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private x<T> f5264a;

        a() {
        }

        @Override // com.google.a.x
        public void a(com.google.a.d.c cVar, T t) throws IOException {
            if (this.f5264a == null) {
                throw new IllegalStateException();
            }
            this.f5264a.a(cVar, t);
        }

        public void a(x<T> xVar) {
            if (this.f5264a != null) {
                throw new AssertionError();
            }
            this.f5264a = xVar;
        }

        @Override // com.google.a.x
        public T b(com.google.a.d.a aVar) throws IOException {
            if (this.f5264a == null) {
                throw new IllegalStateException();
            }
            return this.f5264a.b(aVar);
        }
    }

    public f() {
        this(com.google.a.b.d.f5183a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, v.DEFAULT, Collections.emptyList());
    }

    f(com.google.a.b.d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, v vVar, List<y> list) {
        this.f5254c = new ThreadLocal<>();
        this.f5255d = Collections.synchronizedMap(new HashMap());
        this.f5252a = new j() { // from class: com.google.a.f.1
        };
        this.f5253b = new s() { // from class: com.google.a.f.2
        };
        this.f5257f = new com.google.a.b.c(map);
        this.g = z;
        this.i = z3;
        this.h = z4;
        this.j = z5;
        this.k = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.a.b.a.m.Y);
        arrayList.add(com.google.a.b.a.h.f5108a);
        arrayList.add(dVar);
        arrayList.addAll(list);
        arrayList.add(com.google.a.b.a.m.D);
        arrayList.add(com.google.a.b.a.m.m);
        arrayList.add(com.google.a.b.a.m.g);
        arrayList.add(com.google.a.b.a.m.i);
        arrayList.add(com.google.a.b.a.m.k);
        x<Number> xVarA = a(vVar);
        arrayList.add(com.google.a.b.a.m.a(Long.TYPE, Long.class, xVarA));
        arrayList.add(com.google.a.b.a.m.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(com.google.a.b.a.m.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(com.google.a.b.a.m.x);
        arrayList.add(com.google.a.b.a.m.o);
        arrayList.add(com.google.a.b.a.m.q);
        arrayList.add(com.google.a.b.a.m.a(AtomicLong.class, a(xVarA)));
        arrayList.add(com.google.a.b.a.m.a(AtomicLongArray.class, b(xVarA)));
        arrayList.add(com.google.a.b.a.m.s);
        arrayList.add(com.google.a.b.a.m.z);
        arrayList.add(com.google.a.b.a.m.F);
        arrayList.add(com.google.a.b.a.m.H);
        arrayList.add(com.google.a.b.a.m.a(BigDecimal.class, com.google.a.b.a.m.B));
        arrayList.add(com.google.a.b.a.m.a(BigInteger.class, com.google.a.b.a.m.C));
        arrayList.add(com.google.a.b.a.m.J);
        arrayList.add(com.google.a.b.a.m.L);
        arrayList.add(com.google.a.b.a.m.P);
        arrayList.add(com.google.a.b.a.m.R);
        arrayList.add(com.google.a.b.a.m.W);
        arrayList.add(com.google.a.b.a.m.N);
        arrayList.add(com.google.a.b.a.m.f5132d);
        arrayList.add(com.google.a.b.a.c.f5090a);
        arrayList.add(com.google.a.b.a.m.U);
        arrayList.add(com.google.a.b.a.k.f5124a);
        arrayList.add(com.google.a.b.a.j.f5122a);
        arrayList.add(com.google.a.b.a.m.S);
        arrayList.add(com.google.a.b.a.a.f5083a);
        arrayList.add(com.google.a.b.a.m.f5130b);
        arrayList.add(new com.google.a.b.a.b(this.f5257f));
        arrayList.add(new com.google.a.b.a.g(this.f5257f, z2));
        arrayList.add(new com.google.a.b.a.d(this.f5257f));
        arrayList.add(com.google.a.b.a.m.Z);
        arrayList.add(new com.google.a.b.a.i(this.f5257f, eVar, dVar));
        this.f5256e = Collections.unmodifiableList(arrayList);
    }

    private static x<Number> a(v vVar) {
        return vVar == v.DEFAULT ? com.google.a.b.a.m.t : new x<Number>() { // from class: com.google.a.f.5
            @Override // com.google.a.x
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.a.d.a aVar) throws IOException {
                if (aVar.f() != com.google.a.d.b.NULL) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            @Override // com.google.a.x
            public void a(com.google.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
    }

    private static x<AtomicLong> a(final x<Number> xVar) {
        return new x<AtomicLong>() { // from class: com.google.a.f.6
            @Override // com.google.a.x
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLong b(com.google.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) xVar.b(aVar)).longValue());
            }

            @Override // com.google.a.x
            public void a(com.google.a.d.c cVar, AtomicLong atomicLong) throws IOException {
                xVar.a(cVar, Long.valueOf(atomicLong.get()));
            }
        }.a();
    }

    private x<Number> a(boolean z) {
        return z ? com.google.a.b.a.m.v : new x<Number>() { // from class: com.google.a.f.3
            @Override // com.google.a.x
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Double b(com.google.a.d.a aVar) throws IOException {
                if (aVar.f() != com.google.a.d.b.NULL) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // com.google.a.x
            public void a(com.google.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    f.a(number.doubleValue());
                    cVar.a(number);
                }
            }
        };
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void a(Object obj, com.google.a.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != com.google.a.d.b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (com.google.a.d.d e2) {
                throw new u(e2);
            } catch (IOException e3) {
                throw new m(e3);
            }
        }
    }

    private static x<AtomicLongArray> b(final x<Number> xVar) {
        return new x<AtomicLongArray>() { // from class: com.google.a.f.7
            @Override // com.google.a.x
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray b(com.google.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) xVar.b(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.a.x
            public void a(com.google.a.d.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    xVar.a(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.c();
            }
        }.a();
    }

    private x<Number> b(boolean z) {
        return z ? com.google.a.b.a.m.u : new x<Number>() { // from class: com.google.a.f.4
            @Override // com.google.a.x
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float b(com.google.a.d.a aVar) throws IOException {
                if (aVar.f() != com.google.a.d.b.NULL) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // com.google.a.x
            public void a(com.google.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    f.a(number.floatValue());
                    cVar.a(number);
                }
            }
        };
    }

    public com.google.a.d.a a(Reader reader) {
        com.google.a.d.a aVar = new com.google.a.d.a(reader);
        aVar.a(this.k);
        return aVar;
    }

    public com.google.a.d.c a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        com.google.a.d.c cVar = new com.google.a.d.c(writer);
        if (this.j) {
            cVar.c("  ");
        }
        cVar.d(this.g);
        return cVar;
    }

    public <T> x<T> a(com.google.a.c.a<T> aVar) {
        Map map;
        x<T> xVarA = (x) this.f5255d.get(aVar);
        if (xVarA == null) {
            Map<com.google.a.c.a<?>, a<?>> map2 = this.f5254c.get();
            boolean z = false;
            if (map2 == null) {
                HashMap map3 = new HashMap();
                this.f5254c.set(map3);
                map = map3;
                z = true;
            } else {
                map = map2;
            }
            xVarA = (a) map.get(aVar);
            if (xVarA == null) {
                try {
                    a aVar2 = new a();
                    map.put(aVar, aVar2);
                    Iterator<y> it = this.f5256e.iterator();
                    while (it.hasNext()) {
                        xVarA = it.next().a(this, aVar);
                        if (xVarA != null) {
                            aVar2.a((x) xVarA);
                            this.f5255d.put(aVar, xVarA);
                            map.remove(aVar);
                            if (z) {
                                this.f5254c.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    map.remove(aVar);
                    if (z) {
                        this.f5254c.remove();
                    }
                    throw th;
                }
            }
        }
        return xVarA;
    }

    public <T> x<T> a(y yVar, com.google.a.c.a<T> aVar) {
        boolean z = this.f5256e.contains(yVar) ? false : true;
        boolean z2 = z;
        for (y yVar2 : this.f5256e) {
            if (z2) {
                x<T> xVarA = yVar2.a(this, aVar);
                if (xVarA != null) {
                    return xVarA;
                }
            } else if (yVar2 == yVar) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> x<T> a(Class<T> cls) {
        return a((com.google.a.c.a) com.google.a.c.a.get((Class) cls));
    }

    public <T> T a(com.google.a.d.a aVar, Type type) throws m, u {
        boolean z = true;
        boolean zP = aVar.p();
        aVar.a(true);
        try {
            try {
                aVar.f();
                z = false;
                T tB = a((com.google.a.c.a) com.google.a.c.a.get(type)).b(aVar);
                aVar.a(zP);
                return tB;
            } catch (EOFException e2) {
                if (!z) {
                    throw new u(e2);
                }
                aVar.a(zP);
                return null;
            } catch (IOException e3) {
                throw new u(e3);
            } catch (IllegalStateException e4) {
                throw new u(e4);
            }
        } catch (Throwable th) {
            aVar.a(zP);
            throw th;
        }
    }

    public <T> T a(Reader reader, Type type) throws m, u {
        com.google.a.d.a aVarA = a(reader);
        T t = (T) a(aVarA, type);
        a(t, aVarA);
        return t;
    }

    public <T> T a(String str, Class<T> cls) throws u {
        return (T) com.google.a.b.i.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) throws u {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, stringWriter);
        return stringWriter.toString();
    }

    public String a(Object obj) {
        return obj == null ? a((l) n.f5272a) : a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, com.google.a.d.c cVar) throws m {
        boolean zG = cVar.g();
        cVar.b(true);
        boolean zH = cVar.h();
        cVar.c(this.h);
        boolean zI = cVar.i();
        cVar.d(this.g);
        try {
            try {
                com.google.a.b.j.a(lVar, cVar);
                cVar.b(zG);
                cVar.c(zH);
                cVar.d(zI);
            } catch (IOException e2) {
                throw new m(e2);
            }
        } catch (Throwable th) {
            cVar.b(zG);
            cVar.c(zH);
            cVar.d(zI);
            throw th;
        }
    }

    public void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(com.google.a.b.j.a(appendable)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void a(Object obj, Type type, com.google.a.d.c cVar) throws m {
        x xVarA = a((com.google.a.c.a) com.google.a.c.a.get(type));
        boolean zG = cVar.g();
        cVar.b(true);
        boolean zH = cVar.h();
        cVar.c(this.h);
        boolean zI = cVar.i();
        cVar.d(this.g);
        try {
            try {
                xVarA.a(cVar, obj);
                cVar.b(zG);
                cVar.c(zH);
                cVar.d(zI);
            } catch (IOException e2) {
                throw new m(e2);
            }
        } catch (Throwable th) {
            cVar.b(zG);
            cVar.c(zH);
            cVar.d(zI);
            throw th;
        }
    }

    public void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(com.google.a.b.j.a(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.f5256e + ",instanceCreators:" + this.f5257f + "}";
    }
}
