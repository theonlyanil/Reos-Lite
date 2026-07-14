package com.google.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i extends l implements Iterable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l> f5271a = new ArrayList();

    @Override // com.google.a.l
    public Number a() {
        if (this.f5271a.size() == 1) {
            return this.f5271a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.f5272a;
        }
        this.f5271a.add(lVar);
    }

    @Override // com.google.a.l
    public String b() {
        if (this.f5271a.size() == 1) {
            return this.f5271a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.a.l
    public double c() {
        if (this.f5271a.size() == 1) {
            return this.f5271a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.a.l
    public long d() {
        if (this.f5271a.size() == 1) {
            return this.f5271a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.a.l
    public int e() {
        if (this.f5271a.size() == 1) {
            return this.f5271a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f5271a.equals(this.f5271a));
    }

    @Override // com.google.a.l
    public boolean f() {
        if (this.f5271a.size() == 1) {
            return this.f5271a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f5271a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f5271a.iterator();
    }
}
