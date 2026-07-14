package f;

import com.flurry.android.Constants;
import d.aa;
import d.p;
import d.r;
import d.s;
import d.u;
import d.v;
import d.z;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f6564a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f6566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s.a f6568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final z.a f6569f = new z.a();
    private u g;
    private final boolean h;
    private v.a i;
    private p.a j;
    private aa k;

    private static class a extends aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final aa f6570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final u f6571b;

        a(aa aaVar, u uVar) {
            this.f6570a = aaVar;
            this.f6571b = uVar;
        }

        @Override // d.aa
        public u a() {
            return this.f6571b;
        }

        @Override // d.aa
        public void a(e.d dVar) throws IOException {
            this.f6570a.a(dVar);
        }

        @Override // d.aa
        public long b() throws IOException {
            return this.f6570a.b();
        }
    }

    k(String str, s sVar, String str2, r rVar, u uVar, boolean z, boolean z2, boolean z3) {
        this.f6565b = str;
        this.f6566c = sVar;
        this.f6567d = str2;
        this.g = uVar;
        this.h = z;
        if (rVar != null) {
            this.f6569f.a(rVar);
        }
        if (z2) {
            this.j = new p.a();
        } else if (z3) {
            this.i = new v.a();
            this.i.a(v.f6381e);
        }
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                e.c cVar = new e.c();
                cVar.a(str, 0, iCharCount);
                a(cVar, str, iCharCount, length, z);
                return cVar.r();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    private static void a(e.c cVar, String str, int i, int i2, boolean z) {
        e.c cVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new e.c();
                    }
                    cVar2.a(iCodePointAt);
                    while (!cVar2.g()) {
                        int iJ = cVar2.j() & Constants.UNKNOWN;
                        cVar.j(37);
                        cVar.j((int) f6564a[(iJ >> 4) & 15]);
                        cVar.j((int) f6564a[iJ & 15]);
                    }
                } else {
                    cVar.a(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    z a() {
        s sVarC;
        s.a aVar = this.f6568e;
        if (aVar != null) {
            sVarC = aVar.c();
        } else {
            sVarC = this.f6566c.c(this.f6567d);
            if (sVarC == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f6566c + ", Relative: " + this.f6567d);
            }
        }
        aa aVar2 = this.k;
        if (aVar2 == null) {
            if (this.j != null) {
                aVar2 = this.j.a();
            } else if (this.i != null) {
                aVar2 = this.i.a();
            } else if (this.h) {
                aVar2 = aa.a((u) null, new byte[0]);
            }
        }
        u uVar = this.g;
        if (uVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, uVar);
            } else {
                this.f6569f.b("Content-Type", uVar.toString());
            }
        }
        return this.f6569f.a(sVarC).a(this.f6565b, aVar2).a();
    }

    void a(aa aaVar) {
        this.k = aaVar;
    }

    void a(r rVar, aa aaVar) {
        this.i.a(rVar, aaVar);
    }

    void a(v.b bVar) {
        this.i.a(bVar);
    }

    void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("@Url parameter is null.");
        }
        this.f6567d = obj.toString();
    }

    void a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            this.g = u.a(str2);
        } else {
            this.f6569f.b(str, str2);
        }
    }

    void a(String str, String str2, boolean z) {
        if (this.f6567d == null) {
            throw new AssertionError();
        }
        this.f6567d = this.f6567d.replace("{" + str + "}", a(str2, z));
    }

    void b(String str, String str2, boolean z) {
        if (this.f6567d != null) {
            this.f6568e = this.f6566c.d(this.f6567d);
            if (this.f6568e == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f6566c + ", Relative: " + this.f6567d);
            }
            this.f6567d = null;
        }
        if (z) {
            this.f6568e.b(str, str2);
        } else {
            this.f6568e.a(str, str2);
        }
    }

    void c(String str, String str2, boolean z) {
        if (z) {
            this.j.b(str, str2);
        } else {
            this.j.a(str, str2);
        }
    }
}
