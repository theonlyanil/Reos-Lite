package com.android.library.http.c;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Executor f2692a = new c();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2694b;

        private a(int i, String str) {
            this.f2693a = i;
            this.f2694b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2693a == aVar.f2693a && this.f2694b.equals(aVar.f2694b);
        }

        public int hashCode() {
            return (this.f2693a * 31) + this.f2694b.hashCode();
        }
    }

    /* JADX INFO: renamed from: com.android.library.http.c.b$b, reason: collision with other inner class name */
    static class C0049b implements com.android.library.http.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Map<a, Executor> f2695a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2696b = 3;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2697c = "default";

        C0049b() {
        }

        Executor a() {
            Executor executorNewFixedThreadPool;
            a aVar = new a(this.f2696b, this.f2697c);
            synchronized (C0049b.class) {
                executorNewFixedThreadPool = f2695a.get(aVar);
                if (executorNewFixedThreadPool == null) {
                    executorNewFixedThreadPool = Executors.newFixedThreadPool(this.f2696b);
                    f2695a.put(aVar, executorNewFixedThreadPool);
                }
            }
            return executorNewFixedThreadPool;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    public static com.android.library.http.c.a a() {
        return new C0049b();
    }
}
