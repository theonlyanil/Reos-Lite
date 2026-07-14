package com.cube26.iota.smartlite.b;

/* JADX INFO: loaded from: classes.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3243b;

    public f(String str, String str2) {
        this.f3242a = str;
        this.f3243b = str2;
    }

    public String a() {
        return this.f3242a;
    }

    public boolean equals(Object obj) {
        g gVar = (g) obj;
        return (gVar instanceof f) && this.f3243b.equals(((f) gVar).f3243b);
    }

    @Override // com.cube26.iota.smartlite.b.g
    public boolean m() {
        return true;
    }
}
