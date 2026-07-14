package com.android.library.http.b;

import d.aa;
import d.ab;
import d.t;
import d.u;
import d.z;
import e.d;
import e.k;
import e.n;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a implements t {
    private aa a(final aa aaVar) {
        return new aa() { // from class: com.android.library.http.b.a.1
            @Override // d.aa
            public u a() {
                return aaVar.a();
            }

            @Override // d.aa
            public void a(d dVar) throws IOException {
                d dVarA = n.a(new k(dVar));
                aaVar.a(dVarA);
                dVarA.close();
            }

            @Override // d.aa
            public long b() {
                return -1L;
            }
        };
    }

    @Override // d.t
    public ab a(t.a aVar) throws IOException {
        z zVarA = aVar.a();
        return (zVarA.d() == null || zVarA.a("Content-Encoding") != null) ? aVar.a(zVarA) : aVar.a(zVarA.e().a("Content-Encoding", "gzip").b("Transfer-Encoding", "chunked").a(zVarA.b(), a(zVarA.d())).a());
    }
}
