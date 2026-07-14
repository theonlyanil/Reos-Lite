package com.a.a.d.b.b;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f2091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f2092b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f2093c = new j();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f2094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.a.a.a.a f2096f;

    protected e(File file, int i) {
        this.f2094d = file;
        this.f2095e = i;
    }

    private synchronized com.a.a.a.a a() throws IOException {
        if (this.f2096f == null) {
            this.f2096f = com.a.a.a.a.a(this.f2094d, 1, 1, this.f2095e);
        }
        return this.f2096f;
    }

    public static synchronized a a(File file, int i) {
        if (f2091a == null) {
            f2091a = new e(file, i);
        }
        return f2091a;
    }

    @Override // com.a.a.d.b.b.a
    public File a(com.a.a.d.c cVar) {
        try {
            com.a.a.a.a.c cVarA = a().a(this.f2093c.a(cVar));
            if (cVarA != null) {
                return cVarA.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    @Override // com.a.a.d.b.b.a
    public void a(com.a.a.d.c cVar, a.b bVar) {
        String strA = this.f2093c.a(cVar);
        this.f2092b.a(cVar);
        try {
            try {
                com.a.a.a.a.C0036a c0036aB = a().b(strA);
                if (c0036aB != null) {
                    try {
                        if (bVar.a(c0036aB.a(0))) {
                            c0036aB.a();
                        }
                        c0036aB.c();
                    } catch (Throwable th) {
                        c0036aB.c();
                        throw th;
                    }
                }
                this.f2092b.b(cVar);
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
                this.f2092b.b(cVar);
            }
        } catch (Throwable th2) {
            this.f2092b.b(cVar);
            throw th2;
        }
    }

    @Override // com.a.a.d.b.b.a
    public void b(com.a.a.d.c cVar) {
        try {
            a().c(this.f2093c.a(cVar));
        } catch (IOException e2) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e2);
            }
        }
    }
}
