package com.a.a.d.d.d;

import android.graphics.Bitmap;
import android.util.Log;
import com.a.a.d.b.k;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class j implements com.a.a.d.f<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f2326a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.a.b.a.InterfaceC0037a f2327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.a.d.b.a.c f2328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f2329d;

    static class a {
        a() {
        }

        public com.a.a.b.a a(com.a.a.b.a.InterfaceC0037a interfaceC0037a) {
            return new com.a.a.b.a(interfaceC0037a);
        }

        public com.a.a.b.d a() {
            return new com.a.a.b.d();
        }

        public k<Bitmap> a(Bitmap bitmap, com.a.a.d.b.a.c cVar) {
            return new com.a.a.d.d.a.c(bitmap, cVar);
        }

        public com.a.a.c.a b() {
            return new com.a.a.c.a();
        }
    }

    public j(com.a.a.d.b.a.c cVar) {
        this(cVar, f2326a);
    }

    j(com.a.a.d.b.a.c cVar, a aVar) {
        this.f2328c = cVar;
        this.f2327b = new com.a.a.d.d.d.a(cVar);
        this.f2329d = aVar;
    }

    private com.a.a.b.a a(byte[] bArr) {
        com.a.a.b.d dVarA = this.f2329d.a();
        dVarA.a(bArr);
        com.a.a.b.c cVarB = dVarA.b();
        com.a.a.b.a aVarA = this.f2329d.a(this.f2327b);
        aVarA.a(cVarB, bArr);
        aVarA.a();
        return aVarA;
    }

    private k<Bitmap> a(Bitmap bitmap, com.a.a.d.g<Bitmap> gVar, b bVar) {
        k<Bitmap> kVarA = this.f2329d.a(bitmap, this.f2328c);
        k<Bitmap> kVarA2 = gVar.a(kVarA, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!kVarA.equals(kVarA2)) {
            kVarA.d();
        }
        return kVarA2;
    }

    private boolean a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e2);
            }
            return false;
        }
    }

    @Override // com.a.a.d.b
    public String a() {
        return "";
    }

    @Override // com.a.a.d.b
    public boolean a(k<b> kVar, OutputStream outputStream) {
        long jA = com.a.a.j.d.a();
        b bVarB = kVar.b();
        com.a.a.d.g<Bitmap> gVarC = bVarB.c();
        if (gVarC instanceof com.a.a.d.d.d) {
            return a(bVarB.d(), outputStream);
        }
        com.a.a.b.a aVarA = a(bVarB.d());
        com.a.a.c.a aVarB = this.f2329d.b();
        if (!aVarB.a(outputStream)) {
            return false;
        }
        for (int i = 0; i < aVarA.c(); i++) {
            k<Bitmap> kVarA = a(aVarA.f(), gVarC, bVarB);
            try {
                if (!aVarB.a(kVarA.b())) {
                    kVarA.d();
                    return false;
                }
                aVarB.a(aVarA.a(aVarA.d()));
                aVarA.a();
                kVarA.d();
            } catch (Throwable th) {
                kVarA.d();
                throw th;
            }
        }
        boolean zA = aVarB.a();
        if (!Log.isLoggable("GifEncoder", 2)) {
            return zA;
        }
        Log.v("GifEncoder", "Encoded gif with " + aVarA.c() + " frames and " + bVarB.d().length + " bytes in " + com.a.a.j.d.a(jA) + " ms");
        return zA;
    }
}
