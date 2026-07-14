package com.a.a.d.b.a;

import com.a.a.d.b.a.h;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
abstract class b<T extends h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f2055a = com.a.a.j.h.a(20);

    b() {
    }

    public void a(T t) {
        if (this.f2055a.size() < 20) {
            this.f2055a.offer(t);
        }
    }

    protected abstract T b();

    protected T c() {
        T tPoll = this.f2055a.poll();
        return tPoll == null ? (T) b() : tPoll;
    }
}
