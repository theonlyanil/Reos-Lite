package d;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d.a.e f6257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.a.b f6258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6262f;
    private int g;

    private final class a implements d.a.b.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.a.b.a f6265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e.s f6266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e.s f6268e;

        public a(final d.a.b.a aVar) throws IOException {
            this.f6265b = aVar;
            this.f6266c = aVar.a(1);
            this.f6268e = new e.h(this.f6266c) { // from class: d.c.a.1
                @Override // e.h, e.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (c.this) {
                        if (a.this.f6267d) {
                            return;
                        }
                        a.this.f6267d = true;
                        c.b(c.this);
                        super.close();
                        aVar.a();
                    }
                }
            };
        }

        @Override // d.a.b.a
        public void a() {
            synchronized (c.this) {
                if (this.f6267d) {
                    return;
                }
                this.f6267d = true;
                c.c(c.this);
                d.a.j.a(this.f6266c);
                try {
                    this.f6265b.b();
                } catch (IOException e2) {
                }
            }
        }

        @Override // d.a.b.a
        public e.s b() {
            return this.f6268e;
        }
    }

    private static class b extends ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.a.b.c f6272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e.e f6273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f6274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f6275d;

        public b(final d.a.b.c cVar, String str, String str2) {
            this.f6272a = cVar;
            this.f6274c = str;
            this.f6275d = str2;
            this.f6273b = e.n.a(new e.i(cVar.a(1)) { // from class: d.c.b.1
                @Override // e.i, e.t, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    cVar.close();
                    super.close();
                }
            });
        }

        @Override // d.ac
        public u a() {
            if (this.f6274c != null) {
                return u.a(this.f6274c);
            }
            return null;
        }

        @Override // d.ac
        public long b() {
            try {
                if (this.f6275d != null) {
                    return Long.parseLong(this.f6275d);
                }
                return -1L;
            } catch (NumberFormatException e2) {
                return -1L;
            }
        }

        @Override // d.ac
        public e.e c() {
            return this.f6273b;
        }
    }

    /* JADX INFO: renamed from: d.c$c, reason: collision with other inner class name */
    private static final class C0207c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r f6279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f6280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final x f6281d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f6282e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f6283f;
        private final r g;
        private final q h;

        public C0207c(ab abVar) {
            this.f6278a = abVar.a().a().toString();
            this.f6279b = d.a.b.j.c(abVar);
            this.f6280c = abVar.a().b();
            this.f6281d = abVar.b();
            this.f6282e = abVar.c();
            this.f6283f = abVar.e();
            this.g = abVar.g();
            this.h = abVar.f();
        }

        public C0207c(e.t tVar) throws IOException {
            try {
                e.e eVarA = e.n.a(tVar);
                this.f6278a = eVarA.s();
                this.f6280c = eVarA.s();
                r.a aVar = new r.a();
                int iB = c.b(eVarA);
                for (int i = 0; i < iB; i++) {
                    aVar.a(eVarA.s());
                }
                this.f6279b = aVar.a();
                d.a.b.q qVarA = d.a.b.q.a(eVarA.s());
                this.f6281d = qVarA.f6170a;
                this.f6282e = qVarA.f6171b;
                this.f6283f = qVarA.f6172c;
                r.a aVar2 = new r.a();
                int iB2 = c.b(eVarA);
                for (int i2 = 0; i2 < iB2; i2++) {
                    aVar2.a(eVarA.s());
                }
                this.g = aVar2.a();
                if (a()) {
                    String strS = eVarA.s();
                    if (strS.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strS + "\"");
                    }
                    this.h = q.a(eVarA.g() ? null : ae.a(eVarA.s()), h.a(eVarA.s()), a(eVarA), a(eVarA));
                } else {
                    this.h = null;
                }
                tVar.close();
            } catch (Throwable th) {
                tVar.close();
                throw th;
            }
        }

        private List<Certificate> a(e.e eVar) throws IOException {
            int iB = c.b(eVar);
            if (iB == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iB);
                for (int i = 0; i < iB; i++) {
                    String strS = eVar.s();
                    e.c cVar = new e.c();
                    cVar.b(e.f.b(strS));
                    arrayList.add(certificateFactory.generateCertificate(cVar.h()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void a(e.d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.k(list.size());
                dVar.j(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.b(e.f.a(list.get(i).getEncoded()).b());
                    dVar.j(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private boolean a() {
            return this.f6278a.startsWith("https://");
        }

        public ab a(d.a.b.c cVar) {
            String strA = this.g.a("Content-Type");
            String strA2 = this.g.a("Content-Length");
            return new ab.a().a(new z.a().a(this.f6278a).a(this.f6280c, (aa) null).a(this.f6279b).a()).a(this.f6281d).a(this.f6282e).a(this.f6283f).a(this.g).a(new b(cVar, strA, strA2)).a(this.h).a();
        }

        public void a(d.a.b.a aVar) throws IOException {
            e.d dVarA = e.n.a(aVar.a(0));
            dVarA.b(this.f6278a);
            dVarA.j(10);
            dVarA.b(this.f6280c);
            dVarA.j(10);
            dVarA.k(this.f6279b.a());
            dVarA.j(10);
            int iA = this.f6279b.a();
            for (int i = 0; i < iA; i++) {
                dVarA.b(this.f6279b.a(i));
                dVarA.b(": ");
                dVarA.b(this.f6279b.b(i));
                dVarA.j(10);
            }
            dVarA.b(new d.a.b.q(this.f6281d, this.f6282e, this.f6283f).toString());
            dVarA.j(10);
            dVarA.k(this.g.a());
            dVarA.j(10);
            int iA2 = this.g.a();
            for (int i2 = 0; i2 < iA2; i2++) {
                dVarA.b(this.g.a(i2));
                dVarA.b(": ");
                dVarA.b(this.g.b(i2));
                dVarA.j(10);
            }
            if (a()) {
                dVarA.j(10);
                dVarA.b(this.h.b().a());
                dVarA.j(10);
                a(dVarA, this.h.c());
                a(dVarA, this.h.d());
                if (this.h.a() != null) {
                    dVarA.b(this.h.a().a());
                    dVarA.j(10);
                }
            }
            dVarA.close();
        }

        public boolean a(z zVar, ab abVar) {
            return this.f6278a.equals(zVar.a().toString()) && this.f6280c.equals(zVar.b()) && d.a.b.j.a(abVar, this.f6279b, zVar);
        }
    }

    public c(File file, long j) {
        this(file, j, d.a.c.a.f6180a);
    }

    c(File file, long j, d.a.c.a aVar) {
        this.f6257a = new d.a.e() { // from class: d.c.1
            @Override // d.a.e
            public d.a.b.a a(ab abVar) throws IOException {
                return c.this.a(abVar);
            }

            @Override // d.a.e
            public ab a(z zVar) throws IOException {
                return c.this.a(zVar);
            }

            @Override // d.a.e
            public void a() {
                c.this.a();
            }

            @Override // d.a.e
            public void a(d.a.b.b bVar) {
                c.this.a(bVar);
            }

            @Override // d.a.e
            public void a(ab abVar, ab abVar2) throws IOException {
                c.this.a(abVar, abVar2);
            }

            @Override // d.a.e
            public void b(z zVar) throws IOException {
                c.this.c(zVar);
            }
        };
        this.f6258b = d.a.b.a(aVar, file, 201105, 2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.a.b.a a(ab abVar) throws IOException {
        d.a.b.a aVar;
        String strB = abVar.a().b();
        if (d.a.b.h.a(abVar.a().b())) {
            try {
                c(abVar.a());
                return null;
            } catch (IOException e2) {
                return null;
            }
        }
        if (!strB.equals("GET") || d.a.b.j.b(abVar)) {
            return null;
        }
        C0207c c0207c = new C0207c(abVar);
        try {
            d.a.b.a aVarB = this.f6258b.b(b(abVar.a()));
            if (aVarB == null) {
                return null;
            }
            try {
                c0207c.a(aVarB);
                return new a(aVarB);
            } catch (IOException e3) {
                aVar = aVarB;
                a(aVar);
                return null;
            }
        } catch (IOException e4) {
            aVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f6262f++;
    }

    private void a(d.a.b.a aVar) {
        if (aVar != null) {
            try {
                aVar.b();
            } catch (IOException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d.a.b.b bVar) {
        this.g++;
        if (bVar.f6097a != null) {
            this.f6261e++;
        } else if (bVar.f6098b != null) {
            this.f6262f++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ab abVar, ab abVar2) {
        C0207c c0207c = new C0207c(abVar2);
        d.a.b.a aVarA = null;
        try {
            aVarA = ((b) abVar.h()).f6272a.a();
            if (aVarA != null) {
                c0207c.a(aVarA);
                aVarA.a();
            }
        } catch (IOException e2) {
            a(aVarA);
        }
    }

    static /* synthetic */ int b(c cVar) {
        int i = cVar.f6259c;
        cVar.f6259c = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(e.e eVar) throws IOException {
        try {
            long jO = eVar.o();
            String strS = eVar.s();
            if (jO < 0 || jO > 2147483647L || !strS.isEmpty()) {
                throw new IOException("expected an int but was \"" + jO + strS + "\"");
            }
            return (int) jO;
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private static String b(z zVar) {
        return d.a.j.a(zVar.a().toString());
    }

    static /* synthetic */ int c(c cVar) {
        int i = cVar.f6260d;
        cVar.f6260d = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(z zVar) throws IOException {
        this.f6258b.c(b(zVar));
    }

    ab a(z zVar) {
        try {
            d.a.b.c cVarA = this.f6258b.a(b(zVar));
            if (cVarA == null) {
                return null;
            }
            try {
                C0207c c0207c = new C0207c(cVarA.a(0));
                ab abVarA = c0207c.a(cVarA);
                if (c0207c.a(zVar, abVarA)) {
                    return abVarA;
                }
                d.a.j.a(abVarA.h());
                return null;
            } catch (IOException e2) {
                d.a.j.a(cVarA);
                return null;
            }
        } catch (IOException e3) {
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6258b.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f6258b.flush();
    }
}
