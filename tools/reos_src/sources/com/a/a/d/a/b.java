package com.a.a.d.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b implements c<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f2029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2030b;

    public b(byte[] bArr, String str) {
        this.f2029a = bArr;
        this.f2030b = str;
    }

    @Override // com.a.a.d.a.c
    public void a() {
    }

    @Override // com.a.a.d.a.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStream a(com.a.a.i iVar) {
        return new ByteArrayInputStream(this.f2029a);
    }

    @Override // com.a.a.d.a.c
    public String b() {
        return this.f2030b;
    }

    @Override // com.a.a.d.a.c
    public void c() {
    }
}
