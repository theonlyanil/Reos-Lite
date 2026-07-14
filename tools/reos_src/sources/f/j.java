package f;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final j f6560a = c();

    static class a extends j {

        /* JADX INFO: renamed from: f.j$a$a, reason: collision with other inner class name */
        static class ExecutorC0213a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Handler f6561a = new Handler(Looper.getMainLooper());

            ExecutorC0213a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f6561a.post(runnable);
            }
        }

        a() {
        }

        @Override // f.j
        f.c.a a(Executor executor) {
            return new g(executor);
        }

        @Override // f.j
        public Executor b() {
            return new ExecutorC0213a();
        }
    }

    static class b extends j {

        static class a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static Object f6562a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f6563b;

            static {
                try {
                    Class<?> cls = Class.forName("org.robovm.apple.foundation.NSOperationQueue");
                    f6562a = cls.getDeclaredMethod("getMainQueue", new Class[0]).invoke(null, new Object[0]);
                    f6563b = cls.getDeclaredMethod("addOperation", Runnable.class);
                } catch (Exception e2) {
                    throw new AssertionError(e2);
                }
            }

            a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                try {
                    f6563b.invoke(f6562a, runnable);
                } catch (IllegalAccessException e2) {
                    e = e2;
                    throw new AssertionError(e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    throw new AssertionError(e);
                } catch (InvocationTargetException e4) {
                    Throwable cause = e4.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    }
                    if (!(cause instanceof Error)) {
                        throw new RuntimeException(cause);
                    }
                    throw ((Error) cause);
                }
            }
        }

        b() {
        }

        @Override // f.j
        f.c.a a(Executor executor) {
            return new g(executor);
        }

        @Override // f.j
        public Executor b() {
            return new a();
        }
    }

    @IgnoreJRERequirement
    static class c extends j {
        c() {
        }

        @Override // f.j
        Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // f.j
        boolean a(Method method) {
            return method.isDefault();
        }
    }

    j() {
    }

    static j a() {
        return f6560a;
    }

    private static j c() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException e2) {
        }
        try {
            Class.forName("java.util.Optional");
            return new c();
        } catch (ClassNotFoundException e3) {
            try {
                Class.forName("org.robovm.apple.foundation.NSObject");
                return new b();
            } catch (ClassNotFoundException e4) {
                return new j();
            }
        }
    }

    f.c.a a(Executor executor) {
        return executor != null ? new g(executor) : f.f6508a;
    }

    Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    boolean a(Method method) {
        return false;
    }

    Executor b() {
        return null;
    }
}
