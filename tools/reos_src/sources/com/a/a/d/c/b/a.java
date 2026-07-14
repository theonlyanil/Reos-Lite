package com.a.a.d.c.b;

import android.content.Context;
import com.a.a.d.c.k;
import com.a.a.d.c.l;
import com.a.a.d.c.m;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class a implements l<com.a.a.d.c.d, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k<com.a.a.d.c.d, com.a.a.d.c.d> f2167a;

    /* JADX INFO: renamed from: com.a.a.d.c.b.a$a, reason: collision with other inner class name */
    public static class C0044a implements m<com.a.a.d.c.d, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k<com.a.a.d.c.d, com.a.a.d.c.d> f2168a = new k<>(500);

        @Override // com.a.a.d.c.m
        public l<com.a.a.d.c.d, InputStream> a(Context context, com.a.a.d.c.c cVar) {
            return new a(this.f2168a);
        }

        @Override // com.a.a.d.c.m
        public void a() {
        }
    }

    public a() {
        this(null);
    }

    public a(k<com.a.a.d.c.d, com.a.a.d.c.d> kVar) {
        this.f2167a = kVar;
    }

    @Override // com.a.a.d.c.l
    public com.a.a.d.a.c<InputStream> a(com.a.a.d.c.d dVar, int i, int i2) {
        if (this.f2167a != null) {
            com.a.a.d.c.d dVarA = this.f2167a.a(dVar, 0, 0);
            if (dVarA == null) {
                this.f2167a.a(dVar, 0, 0, dVar);
            } else {
                dVar = dVarA;
            }
        }
        return new com.a.a.d.a.f(dVar);
    }
}
