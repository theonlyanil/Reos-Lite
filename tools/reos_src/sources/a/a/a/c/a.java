package a.a.a.c;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f85a = Executors.newCachedThreadPool(new b(new C0001a()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f86b = 8192;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f87c = 65536;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f88d = 65536;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f89e = 65536;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f90f = b(a());

    /* JADX INFO: renamed from: a.a.a.c.a$a, reason: collision with other inner class name */
    private static class C0001a implements Thread.UncaughtExceptionHandler {
        private C0001a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            th.printStackTrace();
        }
    }

    private static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ThreadFactory f91a = Executors.defaultThreadFactory();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f92b;

        b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f92b = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = f91a.newThread(runnable);
            threadNewThread.setUncaughtExceptionHandler(this.f92b);
            return threadNewThread;
        }
    }

    public static int a() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static int a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("x must be greater or equal 1");
        }
        if (((i - 1) & i) == 0) {
            return i;
        }
        int i2 = (i >>> 1) | i;
        int i3 = i2 | (i2 >>> 2);
        int i4 = i3 | (i3 >>> 4);
        int i5 = i4 | (i4 >>> 8);
        int i6 = i5 | (i5 >>> 16);
        return (i6 | (i6 >>> 32)) + 1;
    }

    public static Future<?> a(Runnable runnable) {
        return f85a.submit(runnable);
    }

    public static void a(Future<?>[] futureArr) {
        for (Future<?> future : futureArr) {
            try {
                future.get();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                return;
            } catch (ExecutionException e3) {
                e3.printStackTrace();
                return;
            }
        }
    }

    public static int b() {
        return f90f;
    }

    public static int b(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("x must be greater or equal 1");
        }
        return (int) Math.pow(2.0d, Math.floor(Math.log(i) / Math.log(2.0d)));
    }

    public static int c() {
        return f86b;
    }

    public static boolean c(int i) {
        return i > 0 && ((i + (-1)) & i) == 0;
    }

    public static int d() {
        return f87c;
    }
}
