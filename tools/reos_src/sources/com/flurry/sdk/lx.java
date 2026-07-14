package com.flurry.sdk;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class lx {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f4731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f4733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<Class<?>> f4734d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<Object> f4735e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4736f;
        private boolean g;

        public a(Object obj, String str) {
            this.f4731a = obj;
            this.f4732b = str;
            this.f4733c = obj != null ? obj.getClass() : null;
        }

        public a a(Class<?> cls) {
            this.g = true;
            this.f4733c = cls;
            return this;
        }

        public <T> a a(Class<T> cls, T t) {
            this.f4734d.add(cls);
            this.f4735e.add(t);
            return this;
        }

        public Object a() throws Exception {
            Method methodA = lx.a(this.f4733c, this.f4732b, (Class[]) this.f4734d.toArray(new Class[this.f4734d.size()]));
            if (this.f4736f) {
                methodA.setAccessible(true);
            }
            Object[] array = this.f4735e.toArray();
            return this.g ? methodA.invoke(null, array) : methodA.invoke(this.f4731a, array);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }
}
