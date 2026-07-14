package com.a.a.d.d.e;

import com.a.a.d.b.k;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.a.a.d.e<InputStream, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.e<com.a.a.d.c.g, a> f2342a;

    public e(com.a.a.d.e<com.a.a.d.c.g, a> eVar) {
        this.f2342a = eVar;
    }

    @Override // com.a.a.d.e
    public k<a> a(InputStream inputStream, int i, int i2) throws IOException {
        return this.f2342a.a(new com.a.a.d.c.g(inputStream, null), i, i2);
    }

    @Override // com.a.a.d.e
    public String a() {
        return this.f2342a.a();
    }
}
