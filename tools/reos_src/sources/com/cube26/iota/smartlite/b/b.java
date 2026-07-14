package com.cube26.iota.smartlite.b;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3229a;

    public b(int i) {
        this.f3229a = i;
    }

    public int a() {
        return this.f3229a;
    }

    public boolean equals(Object obj) {
        c cVar = (c) obj;
        return (cVar instanceof b) && this.f3229a == ((b) cVar).f3229a;
    }

    @Override // com.cube26.iota.smartlite.b.c
    public boolean g() {
        return true;
    }

    @Override // com.cube26.iota.smartlite.b.c
    public boolean h() {
        return false;
    }
}
