package d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class v extends aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f6377a = u.a("multipart/mixed");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f6378b = u.a("multipart/alternative");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f6379c = u.a("multipart/digest");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f6380d = u.a("multipart/parallel");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f6381e = u.a("multipart/form-data");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f6382f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final e.f i;
    private final u j;
    private final u k;
    private final List<b> l;
    private long m = -1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.f f6383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private u f6384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<b> f6385c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f6384b = v.f6377a;
            this.f6385c = new ArrayList();
            this.f6383a = e.f.a(str);
        }

        public a a(r rVar, aa aaVar) {
            return a(b.a(rVar, aaVar));
        }

        public a a(u uVar) {
            if (uVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!uVar.a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + uVar);
            }
            this.f6384b = uVar;
            return this;
        }

        public a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.f6385c.add(bVar);
            return this;
        }

        public v a() {
            if (this.f6385c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new v(this.f6383a, this.f6384b, this.f6385c);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f6386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final aa f6387b;

        private b(r rVar, aa aaVar) {
            this.f6386a = rVar;
            this.f6387b = aaVar;
        }

        public static b a(r rVar, aa aaVar) {
            if (aaVar == null) {
                throw new NullPointerException("body == null");
            }
            if (rVar != null && rVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (rVar == null || rVar.a("Content-Length") == null) {
                return new b(rVar, aaVar);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    v(e.f fVar, u uVar, List<b> list) {
        this.i = fVar;
        this.j = uVar;
        this.k = u.a(uVar + "; boundary=" + fVar.a());
        this.l = d.a.j.a(list);
    }

    private long a(e.d dVar, boolean z) throws IOException {
        e.c cVar;
        long j = 0;
        if (z) {
            e.c cVar2 = new e.c();
            cVar = cVar2;
            dVar = cVar2;
        } else {
            cVar = null;
        }
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.l.get(i);
            r rVar = bVar.f6386a;
            aa aaVar = bVar.f6387b;
            dVar.c(h);
            dVar.b(this.i);
            dVar.c(g);
            if (rVar != null) {
                int iA = rVar.a();
                for (int i2 = 0; i2 < iA; i2++) {
                    dVar.b(rVar.a(i2)).c(f6382f).b(rVar.b(i2)).c(g);
                }
            }
            u uVarA = aaVar.a();
            if (uVarA != null) {
                dVar.b("Content-Type: ").b(uVarA.toString()).c(g);
            }
            long jB = aaVar.b();
            if (jB != -1) {
                dVar.b("Content-Length: ").k(jB).c(g);
            } else if (z) {
                cVar.u();
                return -1L;
            }
            dVar.c(g);
            if (z) {
                j += jB;
            } else {
                aaVar.a(dVar);
            }
            dVar.c(g);
        }
        dVar.c(h);
        dVar.b(this.i);
        dVar.c(h);
        dVar.c(g);
        if (!z) {
            return j;
        }
        long jB2 = j + cVar.b();
        cVar.u();
        return jB2;
    }

    @Override // d.aa
    public u a() {
        return this.k;
    }

    @Override // d.aa
    public void a(e.d dVar) throws IOException {
        a(dVar, false);
    }

    @Override // d.aa
    public long b() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long jA = a((e.d) null, true);
        this.m = jA;
        return jA;
    }
}
