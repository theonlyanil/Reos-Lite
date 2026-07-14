package com.a.a.d.b.b;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.a.a.d.b.b.a.InterfaceC0040a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2090b;

    public interface a {
        File a();
    }

    public d(a aVar, int i) {
        this.f2089a = i;
        this.f2090b = aVar;
    }

    @Override // com.a.a.d.b.b.a.InterfaceC0040a
    public com.a.a.d.b.b.a a() {
        File fileA = this.f2090b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.a(fileA, this.f2089a);
        }
        return null;
    }
}
