package com.google.a.b;

import com.google.a.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.a.h<?>> f5159a;

    public c(Map<Type, com.google.a.h<?>> map) {
        this.f5159a = map;
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new h<T>() { // from class: com.google.a.b.c.8
                @Override // com.google.a.b.h
                public T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    } catch (InstantiationException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3);
                    } catch (InvocationTargetException e4) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e4.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    private <T> h<T> a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new h<T>() { // from class: com.google.a.b.c.9
                    @Override // com.google.a.b.h
                    public T a() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new h<T>() { // from class: com.google.a.b.c.10
                    @Override // com.google.a.b.h
                    public T a() {
                        if (!(type instanceof ParameterizedType)) {
                            throw new m("Invalid EnumSet type: " + type.toString());
                        }
                        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type2 instanceof Class) {
                            return (T) EnumSet.noneOf((Class) type2);
                        }
                        throw new m("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new h<T>() { // from class: com.google.a.b.c.11
                    @Override // com.google.a.b.h
                    public T a() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            return Queue.class.isAssignableFrom(cls) ? new h<T>() { // from class: com.google.a.b.c.12
                @Override // com.google.a.b.h
                public T a() {
                    return (T) new LinkedList();
                }
            } : new h<T>() { // from class: com.google.a.b.c.13
                @Override // com.google.a.b.h
                public T a() {
                    return (T) new ArrayList();
                }
            };
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new h<T>() { // from class: com.google.a.b.c.14
                @Override // com.google.a.b.h
                public T a() {
                    return (T) new ConcurrentSkipListMap();
                }
            };
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new h<T>() { // from class: com.google.a.b.c.2
                @Override // com.google.a.b.h
                public T a() {
                    return (T) new ConcurrentHashMap();
                }
            };
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new h<T>() { // from class: com.google.a.b.c.3
                @Override // com.google.a.b.h
                public T a() {
                    return (T) new TreeMap();
                }
            };
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.a.c.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new h<T>() { // from class: com.google.a.b.c.5
            @Override // com.google.a.b.h
            public T a() {
                return (T) new g();
            }
        } : new h<T>() { // from class: com.google.a.b.c.4
            @Override // com.google.a.b.h
            public T a() {
                return (T) new LinkedHashMap();
            }
        };
    }

    private <T> h<T> b(final Type type, final Class<? super T> cls) {
        return new h<T>() { // from class: com.google.a.b.c.6

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final k f5176d = k.a();

            @Override // com.google.a.b.h
            public T a() {
                try {
                    return (T) this.f5176d.a(cls);
                } catch (Exception e2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e2);
                }
            }
        };
    }

    public <T> h<T> a(com.google.a.c.a<T> aVar) {
        final Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        final com.google.a.h<?> hVar = this.f5159a.get(type);
        if (hVar != null) {
            return new h<T>() { // from class: com.google.a.b.c.1
                @Override // com.google.a.b.h
                public T a() {
                    return (T) hVar.a(type);
                }
            };
        }
        final com.google.a.h<?> hVar2 = this.f5159a.get(rawType);
        if (hVar2 != null) {
            return new h<T>() { // from class: com.google.a.b.c.7
                @Override // com.google.a.b.h
                public T a() {
                    return (T) hVar2.a(type);
                }
            };
        }
        h<T> hVarA = a(rawType);
        if (hVarA != null) {
            return hVarA;
        }
        h<T> hVarA2 = a(type, rawType);
        return hVarA2 == null ? b(type, rawType) : hVarA2;
    }

    public String toString() {
        return this.f5159a.toString();
    }
}
