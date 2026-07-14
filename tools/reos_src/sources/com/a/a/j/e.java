package com.a.a.j;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e<T, Y> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2511c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<T, Y> f2509a = new LinkedHashMap<>(100, 0.75f, true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2512d = 0;

    public e(int i) {
        this.f2511c = i;
        this.f2510b = i;
    }

    private void c() {
        b(this.f2510b);
    }

    protected int a(Y y) {
        return 1;
    }

    public void a() {
        b(0);
    }

    protected void a(T t, Y y) {
    }

    public int b() {
        return this.f2512d;
    }

    public Y b(T t) {
        return this.f2509a.get(t);
    }

    public Y b(T t, Y y) {
        if (a(y) >= this.f2510b) {
            a(t, y);
            return null;
        }
        Y yPut = this.f2509a.put(t, y);
        if (y != null) {
            this.f2512d += a(y);
        }
        if (yPut != null) {
            this.f2512d -= a(yPut);
        }
        c();
        return yPut;
    }

    protected void b(int i) {
        while (this.f2512d > i) {
            Map.Entry<T, Y> next = this.f2509a.entrySet().iterator().next();
            Y value = next.getValue();
            this.f2512d -= a(value);
            T key = next.getKey();
            this.f2509a.remove(key);
            a(key, value);
        }
    }

    public Y c(T t) {
        Y yRemove = this.f2509a.remove(t);
        if (yRemove != null) {
            this.f2512d -= a(yRemove);
        }
        return yRemove;
    }
}
