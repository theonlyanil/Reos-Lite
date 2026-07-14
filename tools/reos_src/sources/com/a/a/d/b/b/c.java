package com.a.a.d.b.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.a.a.d.c, a> f2084a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2085b = new b();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f2086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2087b;

        private a() {
            this.f2086a = new ReentrantLock();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<a> f2088a;

        private b() {
            this.f2088a = new ArrayDeque();
        }

        a a() {
            a aVarPoll;
            synchronized (this.f2088a) {
                aVarPoll = this.f2088a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void a(a aVar) {
            synchronized (this.f2088a) {
                if (this.f2088a.size() < 10) {
                    this.f2088a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    void a(com.a.a.d.c cVar) {
        a aVarA;
        synchronized (this) {
            aVarA = this.f2084a.get(cVar);
            if (aVarA == null) {
                aVarA = this.f2085b.a();
                this.f2084a.put(cVar, aVarA);
            }
            aVarA.f2087b++;
        }
        aVarA.f2086a.lock();
    }

    void b(com.a.a.d.c cVar) {
        a aVar;
        synchronized (this) {
            aVar = this.f2084a.get(cVar);
            if (aVar == null || aVar.f2087b <= 0) {
                throw new IllegalArgumentException("Cannot release a lock that is not held, key: " + cVar + ", interestedThreads: " + (aVar == null ? 0 : aVar.f2087b));
            }
            int i = aVar.f2087b - 1;
            aVar.f2087b = i;
            if (i == 0) {
                a aVarRemove = this.f2084a.remove(cVar);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", key: " + cVar);
                }
                this.f2085b.a(aVarRemove);
            }
        }
        aVar.f2086a.unlock();
    }
}
