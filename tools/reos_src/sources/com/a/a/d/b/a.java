package com.a.a.d.b;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class a<A, T, Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f2040a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f2041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.a.a.d.a.c<A> f2044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.a.a.g.b<A, T> f2045f;
    private final com.a.a.d.g<T> g;
    private final com.a.a.d.d.f.c<T, Z> h;
    private final InterfaceC0038a i;
    private final com.a.a.d.b.b j;
    private final com.a.a.i k;
    private final b l;
    private volatile boolean m;

    /* JADX INFO: renamed from: com.a.a.d.b.a$a, reason: collision with other inner class name */
    interface InterfaceC0038a {
        com.a.a.d.b.b.a a();
    }

    static class b {
        b() {
        }

        public OutputStream a(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    class c<DataType> implements com.a.a.d.b.b.a.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.a.a.d.b<DataType> f2047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DataType f2048c;

        public c(com.a.a.d.b<DataType> bVar, DataType datatype) {
            this.f2047b = bVar;
            this.f2048c = datatype;
        }

        @Override // com.a.a.d.b.b.a.b
        public boolean a(File file) {
            boolean zA = false;
            OutputStream outputStreamA = null;
            try {
                outputStreamA = a.this.l.a(file);
                zA = this.f2047b.a(this.f2048c, outputStreamA);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
                }
            } finally {
                if (outputStreamA != null) {
                    try {
                        outputStreamA.close();
                    } catch (IOException e3) {
                    }
                }
            }
            return zA;
        }
    }

    public a(f fVar, int i, int i2, com.a.a.d.a.c<A> cVar, com.a.a.g.b<A, T> bVar, com.a.a.d.g<T> gVar, com.a.a.d.d.f.c<T, Z> cVar2, InterfaceC0038a interfaceC0038a, com.a.a.d.b.b bVar2, com.a.a.i iVar) {
        this(fVar, i, i2, cVar, bVar, gVar, cVar2, interfaceC0038a, bVar2, iVar, f2040a);
    }

    a(f fVar, int i, int i2, com.a.a.d.a.c<A> cVar, com.a.a.g.b<A, T> bVar, com.a.a.d.g<T> gVar, com.a.a.d.d.f.c<T, Z> cVar2, InterfaceC0038a interfaceC0038a, com.a.a.d.b.b bVar2, com.a.a.i iVar, b bVar3) {
        this.f2041b = fVar;
        this.f2042c = i;
        this.f2043d = i2;
        this.f2044e = cVar;
        this.f2045f = bVar;
        this.g = gVar;
        this.h = cVar2;
        this.i = interfaceC0038a;
        this.j = bVar2;
        this.k = iVar;
        this.l = bVar3;
    }

    private k<Z> a(k<T> kVar) {
        long jA = com.a.a.j.d.a();
        k<T> kVarC = c(kVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transformed resource from source", jA);
        }
        b((k) kVarC);
        long jA2 = com.a.a.j.d.a();
        k<Z> kVarD = d(kVarC);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from source", jA2);
        }
        return kVarD;
    }

    private k<T> a(com.a.a.d.c cVar) throws IOException {
        k<T> kVarA = null;
        File fileA = this.i.a().a(cVar);
        if (fileA != null) {
            try {
                kVarA = this.f2045f.a().a(fileA, this.f2042c, this.f2043d);
            } finally {
                if (0 == 0) {
                    this.i.a().b(cVar);
                }
            }
        }
        return kVarA;
    }

    private k<T> a(A a2) throws IOException {
        if (this.j.a()) {
            return b(a2);
        }
        long jA = com.a.a.j.d.a();
        k<T> kVarA = this.f2045f.b().a(a2, this.f2042c, this.f2043d);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return kVarA;
        }
        a("Decoded from source", jA);
        return kVarA;
    }

    private void a(String str, long j) {
        Log.v("DecodeJob", str + " in " + com.a.a.j.d.a(j) + ", key: " + this.f2041b);
    }

    private k<T> b(A a2) throws IOException {
        long jA = com.a.a.j.d.a();
        this.i.a().a(this.f2041b.a(), new c(this.f2045f.c(), a2));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote source to cache", jA);
        }
        long jA2 = com.a.a.j.d.a();
        k<T> kVarA = a(this.f2041b.a());
        if (Log.isLoggable("DecodeJob", 2) && kVarA != null) {
            a("Decoded source from cache", jA2);
        }
        return kVarA;
    }

    private void b(k<T> kVar) {
        if (kVar == null || !this.j.b()) {
            return;
        }
        long jA = com.a.a.j.d.a();
        this.i.a().a(this.f2041b, new c(this.f2045f.d(), kVar));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote transformed from source to cache", jA);
        }
    }

    private k<T> c(k<T> kVar) {
        if (kVar == null) {
            return null;
        }
        k<T> kVarA = this.g.a(kVar, this.f2042c, this.f2043d);
        if (kVar.equals(kVarA)) {
            return kVarA;
        }
        kVar.d();
        return kVarA;
    }

    private k<Z> d(k<T> kVar) {
        if (kVar == null) {
            return null;
        }
        return this.h.a(kVar);
    }

    private k<T> e() throws Exception {
        try {
            long jA = com.a.a.j.d.a();
            A a2 = this.f2044e.a(this.k);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Fetched data", jA);
            }
            if (this.m) {
                return null;
            }
            return a(a2);
        } finally {
            this.f2044e.a();
        }
    }

    public k<Z> a() throws Exception {
        if (!this.j.b()) {
            return null;
        }
        long jA = com.a.a.j.d.a();
        k<T> kVarA = a((com.a.a.d.c) this.f2041b);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded transformed from cache", jA);
        }
        long jA2 = com.a.a.j.d.a();
        k<Z> kVarD = d(kVarA);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return kVarD;
        }
        a("Transcoded transformed from cache", jA2);
        return kVarD;
    }

    public k<Z> b() throws Exception {
        if (!this.j.a()) {
            return null;
        }
        long jA = com.a.a.j.d.a();
        k<T> kVarA = a(this.f2041b.a());
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded source from cache", jA);
        }
        return a((k) kVarA);
    }

    public k<Z> c() throws Exception {
        return a((k) e());
    }

    public void d() {
        this.m = true;
        this.f2044e.c();
    }
}
