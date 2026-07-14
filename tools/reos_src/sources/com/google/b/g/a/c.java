package com.google.b.g.a;

import com.google.b.o;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o[] f5600c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f5598a = i;
        this.f5599b = iArr;
        this.f5600c = new o[]{new o(i2, i4), new o(i3, i4)};
    }

    public int a() {
        return this.f5598a;
    }

    public int[] b() {
        return this.f5599b;
    }

    public o[] c() {
        return this.f5600c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f5598a == ((c) obj).f5598a;
    }

    public int hashCode() {
        return this.f5598a;
    }
}
