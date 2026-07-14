package com.google.a.b;

import com.google.a.x;
import com.google.a.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d implements y, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5183a = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5187e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f5184b = -1.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5185c = 136;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5186d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.google.a.b> f5188f = Collections.emptyList();
    private List<com.google.a.b> g = Collections.emptyList();

    private boolean a(com.google.a.a.d dVar) {
        return dVar == null || dVar.a() <= this.f5184b;
    }

    private boolean a(com.google.a.a.d dVar, com.google.a.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.a.a.e eVar) {
        return eVar == null || eVar.a() > this.f5184b;
    }

    private boolean a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean b(Class<?> cls) {
        return cls.isMemberClass() && !c(cls);
    }

    private boolean c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.a.y
    public <T> x<T> a(final com.google.a.f fVar, final com.google.a.c.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        final boolean zA = a((Class<?>) rawType, true);
        final boolean zA2 = a((Class<?>) rawType, false);
        if (zA || zA2) {
            return new x<T>() { // from class: com.google.a.b.d.1

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private x<T> f5194f;

                private x<T> b() {
                    x<T> xVar = this.f5194f;
                    if (xVar != null) {
                        return xVar;
                    }
                    x<T> xVarA = fVar.a(d.this, aVar);
                    this.f5194f = xVarA;
                    return xVarA;
                }

                @Override // com.google.a.x
                public void a(com.google.a.d.c cVar, T t) throws IOException {
                    if (zA) {
                        cVar.f();
                    } else {
                        b().a(cVar, t);
                    }
                }

                @Override // com.google.a.x
                public T b(com.google.a.d.a aVar2) throws IOException {
                    if (!zA2) {
                        return b().b(aVar2);
                    }
                    aVar2.n();
                    return null;
                }
            };
        }
        return null;
    }

    public boolean a(Class<?> cls, boolean z) {
        if (this.f5184b != -1.0d && !a((com.google.a.a.d) cls.getAnnotation(com.google.a.a.d.class), (com.google.a.a.e) cls.getAnnotation(com.google.a.a.e.class))) {
            return true;
        }
        if ((this.f5186d || !b(cls)) && !a(cls)) {
            Iterator<com.google.a.b> it = (z ? this.f5188f : this.g).iterator();
            while (it.hasNext()) {
                if (it.next().a(cls)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean a(Field field, boolean z) {
        com.google.a.a.a aVar;
        if ((this.f5185c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f5184b == -1.0d || a((com.google.a.a.d) field.getAnnotation(com.google.a.a.d.class), (com.google.a.a.e) field.getAnnotation(com.google.a.a.e.class))) && !field.isSynthetic()) {
            if (this.f5187e && ((aVar = (com.google.a.a.a) field.getAnnotation(com.google.a.a.a.class)) == null || (!z ? aVar.b() : aVar.a()))) {
                return true;
            }
            if ((this.f5186d || !b(field.getType())) && !a(field.getType())) {
                List<com.google.a.b> list = z ? this.f5188f : this.g;
                if (!list.isEmpty()) {
                    com.google.a.c cVar = new com.google.a.c(field);
                    Iterator<com.google.a.b> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().a(cVar)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }
}
