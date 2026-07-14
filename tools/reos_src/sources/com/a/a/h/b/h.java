package com.a.a.h.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<Z> extends a<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2451b;

    public h() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public h(int i, int i2) {
        this.f2450a = i;
        this.f2451b = i2;
    }

    @Override // com.a.a.h.b.k
    public final void a(i iVar) {
        if (!com.a.a.j.h.a(this.f2450a, this.f2451b)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f2450a + " and height: " + this.f2451b + ", either provide dimensions in the constructor or call override()");
        }
        iVar.a(this.f2450a, this.f2451b);
    }
}
