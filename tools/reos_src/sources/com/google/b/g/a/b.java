package com.google.b.g.a;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5597b;

    public b(int i, int i2) {
        this.f5596a = i;
        this.f5597b = i2;
    }

    public final int a() {
        return this.f5596a;
    }

    public final int b() {
        return this.f5597b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5596a == bVar.f5596a && this.f5597b == bVar.f5597b;
    }

    public final int hashCode() {
        return this.f5596a ^ this.f5597b;
    }

    public final String toString() {
        return this.f5596a + "(" + this.f5597b + ')';
    }
}
