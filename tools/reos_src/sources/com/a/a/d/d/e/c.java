package com.a.a.d.d.e;

import android.graphics.Bitmap;
import com.a.a.d.b.k;
import com.a.a.d.d.a.l;
import com.a.a.d.d.a.o;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.a.a.d.e<com.a.a.d.c.g, com.a.a.d.d.e.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f2333a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f2334b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.e<com.a.a.d.c.g, Bitmap> f2335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.a.a.d.e<InputStream, com.a.a.d.d.d.b> f2336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f2338f;
    private final a g;
    private String h;

    static class a {
        a() {
        }

        public InputStream a(InputStream inputStream, byte[] bArr) {
            return new o(inputStream, bArr);
        }
    }

    static class b {
        b() {
        }

        public l.a a(InputStream inputStream) throws IOException {
            return new l(inputStream).b();
        }
    }

    public c(com.a.a.d.e<com.a.a.d.c.g, Bitmap> eVar, com.a.a.d.e<InputStream, com.a.a.d.d.d.b> eVar2, com.a.a.d.b.a.c cVar) {
        this(eVar, eVar2, cVar, f2333a, f2334b);
    }

    c(com.a.a.d.e<com.a.a.d.c.g, Bitmap> eVar, com.a.a.d.e<InputStream, com.a.a.d.d.d.b> eVar2, com.a.a.d.b.a.c cVar, b bVar, a aVar) {
        this.f2335c = eVar;
        this.f2336d = eVar2;
        this.f2337e = cVar;
        this.f2338f = bVar;
        this.g = aVar;
    }

    private com.a.a.d.d.e.a a(com.a.a.d.c.g gVar, int i, int i2, byte[] bArr) throws IOException {
        return gVar.a() != null ? b(gVar, i, i2, bArr) : b(gVar, i, i2);
    }

    private com.a.a.d.d.e.a a(InputStream inputStream, int i, int i2) throws IOException {
        k<com.a.a.d.d.d.b> kVarA = this.f2336d.a(inputStream, i, i2);
        if (kVarA == null) {
            return null;
        }
        com.a.a.d.d.d.b bVarB = kVarA.b();
        return bVarB.e() > 1 ? new com.a.a.d.d.e.a(null, kVarA) : new com.a.a.d.d.e.a(new com.a.a.d.d.a.c(bVarB.b(), this.f2337e), null);
    }

    private com.a.a.d.d.e.a b(com.a.a.d.c.g gVar, int i, int i2) throws IOException {
        k<Bitmap> kVarA = this.f2335c.a(gVar, i, i2);
        if (kVarA != null) {
            return new com.a.a.d.d.e.a(kVarA, null);
        }
        return null;
    }

    private com.a.a.d.d.e.a b(com.a.a.d.c.g gVar, int i, int i2, byte[] bArr) throws IOException {
        InputStream inputStreamA = this.g.a(gVar.a(), bArr);
        inputStreamA.mark(2048);
        l.a aVarA = this.f2338f.a(inputStreamA);
        inputStreamA.reset();
        com.a.a.d.d.e.a aVarA2 = aVarA == l.a.GIF ? a(inputStreamA, i, i2) : null;
        return aVarA2 == null ? b(new com.a.a.d.c.g(inputStreamA, gVar.b()), i, i2) : aVarA2;
    }

    @Override // com.a.a.d.e
    public k<com.a.a.d.d.e.a> a(com.a.a.d.c.g gVar, int i, int i2) throws IOException {
        com.a.a.j.a aVarA = com.a.a.j.a.a();
        byte[] bArrB = aVarA.b();
        try {
            com.a.a.d.d.e.a aVarA2 = a(gVar, i, i2, bArrB);
            aVarA.a(bArrB);
            if (aVarA2 != null) {
                return new com.a.a.d.d.e.b(aVarA2);
            }
            return null;
        } catch (Throwable th) {
            aVarA.a(bArrB);
            throw th;
        }
    }

    @Override // com.a.a.d.e
    public String a() {
        if (this.h == null) {
            this.h = this.f2336d.a() + this.f2335c.a();
        }
        return this.h;
    }
}
