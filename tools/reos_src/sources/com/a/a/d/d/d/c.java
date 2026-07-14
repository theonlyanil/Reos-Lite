package com.a.a.d.d.d;

import android.content.Context;
import com.a.a.d.c.o;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.a.a.g.b<InputStream, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f2298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f2299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f2300c = new o();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.d.c.c<b> f2301d;

    public c(Context context, com.a.a.d.b.a.c cVar) {
        this.f2298a = new i(context, cVar);
        this.f2301d = new com.a.a.d.d.c.c<>(this.f2298a);
        this.f2299b = new j(cVar);
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<File, b> a() {
        return this.f2301d;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.e<InputStream, b> b() {
        return this.f2298a;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.b<InputStream> c() {
        return this.f2300c;
    }

    @Override // com.a.a.g.b
    public com.a.a.d.f<b> d() {
        return this.f2299b;
    }
}
