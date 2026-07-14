package com.a.a.d.c;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class h implements com.a.a.d.b<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.a.d.b<InputStream> f2187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.d.b<ParcelFileDescriptor> f2188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2189c;

    public h(com.a.a.d.b<InputStream> bVar, com.a.a.d.b<ParcelFileDescriptor> bVar2) {
        this.f2187a = bVar;
        this.f2188b = bVar2;
    }

    @Override // com.a.a.d.b
    public String a() {
        if (this.f2189c == null) {
            this.f2189c = this.f2187a.a() + this.f2188b.a();
        }
        return this.f2189c;
    }

    @Override // com.a.a.d.b
    public boolean a(g gVar, OutputStream outputStream) {
        return gVar.a() != null ? this.f2187a.a(gVar.a(), outputStream) : this.f2188b.a(gVar.b(), outputStream);
    }
}
