package d.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f6200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class[] f6202c;

    public g(Class<?> cls, String str, Class... clsArr) {
        this.f6200a = cls;
        this.f6201b = str;
        this.f6202c = clsArr;
    }

    private Method a(Class<?> cls) {
        if (this.f6201b == null) {
            return null;
        }
        Method methodA = a(cls, this.f6201b, this.f6202c);
        if (methodA == null || this.f6200a == null || this.f6200a.isAssignableFrom(methodA.getReturnType())) {
            return methodA;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException e2) {
                return method;
            }
        } catch (NoSuchMethodException e3) {
            return null;
        }
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        Method methodA = a(t.getClass());
        if (methodA == null) {
            return null;
        }
        try {
            return methodA.invoke(t, objArr);
        } catch (IllegalAccessException e2) {
            return null;
        }
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) throws InvocationTargetException {
        Method methodA = a(t.getClass());
        if (methodA == null) {
            throw new AssertionError("Method " + this.f6201b + " not supported for object " + t);
        }
        try {
            return methodA.invoke(t, objArr);
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodA);
            assertionError.initCause(e2);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
