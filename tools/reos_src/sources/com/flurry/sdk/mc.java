package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class mc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static mc f4742a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Thread.UncaughtExceptionHandler, Void> f4744c = new WeakHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f4743b = Thread.getDefaultUncaughtExceptionHandler();

    final class a implements Thread.UncaughtExceptionHandler {
        private a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            mc.this.a(thread, th);
            mc.this.b(thread, th);
        }
    }

    private mc() {
        Thread.setDefaultUncaughtExceptionHandler(new a());
    }

    public static synchronized mc a() {
        if (f4742a == null) {
            f4742a = new mc();
        }
        return f4742a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Thread thread, Throwable th) {
        Iterator<Thread.UncaughtExceptionHandler> it = c().iterator();
        while (it.hasNext()) {
            it.next().uncaughtException(thread, th);
        }
    }

    public static synchronized void b() {
        if (f4742a != null) {
            f4742a.d();
        }
        f4742a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Thread thread, Throwable th) {
        if (this.f4743b != null) {
            try {
                this.f4743b.uncaughtException(thread, th);
            } catch (Throwable th2) {
            }
        }
    }

    private Set<Thread.UncaughtExceptionHandler> c() {
        Set<Thread.UncaughtExceptionHandler> setKeySet;
        synchronized (this.f4744c) {
            setKeySet = this.f4744c.keySet();
        }
        return setKeySet;
    }

    private void d() {
        Thread.setDefaultUncaughtExceptionHandler(this.f4743b);
    }

    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        synchronized (this.f4744c) {
            this.f4744c.put(uncaughtExceptionHandler, null);
        }
    }
}
