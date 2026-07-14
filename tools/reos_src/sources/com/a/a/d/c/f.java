package com.a.a.d.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class f<A> implements l<A, g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<A, InputStream> f2181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<A, ParcelFileDescriptor> f2182b;

    static class a implements com.a.a.d.a.c<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.a.a.d.a.c<InputStream> f2183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.a.a.d.a.c<ParcelFileDescriptor> f2184b;

        public a(com.a.a.d.a.c<InputStream> cVar, com.a.a.d.a.c<ParcelFileDescriptor> cVar2) {
            this.f2183a = cVar;
            this.f2184b = cVar2;
        }

        @Override // com.a.a.d.a.c
        public void a() {
            if (this.f2183a != null) {
                this.f2183a.a();
            }
            if (this.f2184b != null) {
                this.f2184b.a();
            }
        }

        @Override // com.a.a.d.a.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(com.a.a.i iVar) throws Exception {
            InputStream inputStreamA;
            ParcelFileDescriptor parcelFileDescriptorA = null;
            if (this.f2183a != null) {
                try {
                    inputStreamA = this.f2183a.a(iVar);
                } catch (Exception e2) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e2);
                    }
                    if (this.f2184b == null) {
                        throw e2;
                    }
                    inputStreamA = null;
                }
            } else {
                inputStreamA = null;
            }
            if (this.f2184b != null) {
                try {
                    parcelFileDescriptorA = this.f2184b.a(iVar);
                } catch (Exception e3) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching ParcelFileDescriptor", e3);
                    }
                    if (inputStreamA == null) {
                        throw e3;
                    }
                }
            }
            return new g(inputStreamA, parcelFileDescriptorA);
        }

        @Override // com.a.a.d.a.c
        public String b() {
            return this.f2183a != null ? this.f2183a.b() : this.f2184b.b();
        }

        @Override // com.a.a.d.a.c
        public void c() {
            if (this.f2183a != null) {
                this.f2183a.c();
            }
            if (this.f2184b != null) {
                this.f2184b.c();
            }
        }
    }

    public f(l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2) {
        if (lVar == null && lVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f2181a = lVar;
        this.f2182b = lVar2;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<g> a(A a2, int i, int i2) {
        com.a.a.d.a.c<InputStream> cVarA = this.f2181a != null ? this.f2181a.a(a2, i, i2) : null;
        com.a.a.d.a.c<ParcelFileDescriptor> cVarA2 = this.f2182b != null ? this.f2182b.a(a2, i, i2) : null;
        if (cVarA == null && cVarA2 == null) {
            return null;
        }
        return new a(cVarA, cVarA2);
    }
}
