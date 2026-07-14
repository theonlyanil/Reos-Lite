package com.google.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static k a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            return new k() { // from class: com.google.a.b.k.1
                @Override // com.google.a.b.k
                public <T> T a(Class<T> cls2) throws Exception {
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception e2) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                final int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new k() { // from class: com.google.a.b.k.2
                    @Override // com.google.a.b.k
                    public <T> T a(Class<T> cls2) throws Exception {
                        return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(iIntValue));
                    }
                };
            } catch (Exception e3) {
                try {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new k() { // from class: com.google.a.b.k.3
                        @Override // com.google.a.b.k
                        public <T> T a(Class<T> cls2) throws Exception {
                            return (T) declaredMethod3.invoke(null, cls2, Object.class);
                        }
                    };
                } catch (Exception e4) {
                    return new k() { // from class: com.google.a.b.k.4
                        @Override // com.google.a.b.k
                        public <T> T a(Class<T> cls2) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls2);
                        }
                    };
                }
            }
        }
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}
