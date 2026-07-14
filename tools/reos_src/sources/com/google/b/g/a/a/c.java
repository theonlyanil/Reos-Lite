package com.google.b.g.a.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f5587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5589c;

    c(List<b> list, int i, boolean z) {
        this.f5587a = new ArrayList(list);
        this.f5588b = i;
        this.f5589c = z;
    }

    List<b> a() {
        return this.f5587a;
    }

    boolean a(List<b> list) {
        return this.f5587a.equals(list);
    }

    int b() {
        return this.f5588b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5587a.equals(cVar.a()) && this.f5589c == cVar.f5589c;
    }

    public int hashCode() {
        return this.f5587a.hashCode() ^ Boolean.valueOf(this.f5589c).hashCode();
    }

    public String toString() {
        return "{ " + this.f5587a + " }";
    }
}
