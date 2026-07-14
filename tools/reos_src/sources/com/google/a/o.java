package com.google.a;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class o extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.a.b.g<String, l> f5273a = new com.google.a.b.g<>();

    public void a(String str, l lVar) {
        if (lVar == null) {
            lVar = n.f5272a;
        }
        this.f5273a.put(str, lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f5273a.equals(this.f5273a));
    }

    public int hashCode() {
        return this.f5273a.hashCode();
    }

    public Set<Map.Entry<String, l>> o() {
        return this.f5273a.entrySet();
    }
}
