package d.a.b;

import d.ab;
import d.ac;
import d.x;
import d.z;
import e.s;
import e.t;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e.f f6127a = e.f.a("connection");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e.f f6128b = e.f.a("host");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final e.f f6129c = e.f.a("keep-alive");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e.f f6130d = e.f.a("proxy-connection");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final e.f f6131e = e.f.a("transfer-encoding");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e.f f6132f = e.f.a("te");
    private static final e.f g = e.f.a("encoding");
    private static final e.f h = e.f.a("upgrade");
    private static final List<e.f> i = d.a.j.a(f6127a, f6128b, f6129c, f6130d, f6131e, d.a.a.f.f6002b, d.a.a.f.f6003c, d.a.a.f.f6004d, d.a.a.f.f6005e, d.a.a.f.f6006f, d.a.a.f.g);
    private static final List<e.f> j = d.a.j.a(f6127a, f6128b, f6129c, f6130d, f6131e);
    private static final List<e.f> k = d.a.j.a(f6127a, f6128b, f6129c, f6130d, f6132f, f6131e, g, h, d.a.a.f.f6002b, d.a.a.f.f6003c, d.a.a.f.f6004d, d.a.a.f.f6005e, d.a.a.f.f6006f, d.a.a.f.g);
    private static final List<e.f> l = d.a.j.a(f6127a, f6128b, f6129c, f6130d, f6132f, f6131e, g, h);
    private final r m;
    private final d.a.a.d n;
    private g o;
    private d.a.a.e p;

    class a extends e.i {
        public a(t tVar) {
            super(tVar);
        }

        @Override // e.i, e.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            e.this.m.a(false, (i) e.this);
            super.close();
        }
    }

    public e(r rVar, d.a.a.d dVar) {
        this.m = rVar;
        this.n = dVar;
    }

    public static ab.a a(List<d.a.a.f> list) throws IOException {
        String str = null;
        String str2 = "HTTP/1.1";
        d.r.a aVar = new d.r.a();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            e.f fVar = list.get(i2).h;
            String strA = list.get(i2).i.a();
            String str3 = str2;
            int i3 = 0;
            while (i3 < strA.length()) {
                int iIndexOf = strA.indexOf(0, i3);
                if (iIndexOf == -1) {
                    iIndexOf = strA.length();
                }
                String strSubstring = strA.substring(i3, iIndexOf);
                if (!fVar.equals(d.a.a.f.f6001a)) {
                    if (fVar.equals(d.a.a.f.g)) {
                        str3 = strSubstring;
                        strSubstring = str;
                    } else {
                        if (!j.contains(fVar)) {
                            aVar.a(fVar.a(), strSubstring);
                        }
                        strSubstring = str;
                    }
                }
                str = strSubstring;
                i3 = iIndexOf + 1;
            }
            i2++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        q qVarA = q.a(str2 + " " + str);
        return new ab.a().a(x.SPDY_3).a(qVarA.f6171b).a(qVarA.f6172c).a(aVar.a());
    }

    private static String a(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static ab.a b(List<d.a.a.f> list) throws IOException {
        String str = null;
        d.r.a aVar = new d.r.a();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            e.f fVar = list.get(i2).h;
            String strA = list.get(i2).i.a();
            if (!fVar.equals(d.a.a.f.f6001a)) {
                if (!l.contains(fVar)) {
                    aVar.a(fVar.a(), strA);
                }
                strA = str;
            }
            i2++;
            str = strA;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        q qVarA = q.a("HTTP/1.1 " + str);
        return new ab.a().a(x.HTTP_2).a(qVarA.f6171b).a(qVarA.f6172c).a(aVar.a());
    }

    public static List<d.a.a.f> b(z zVar) {
        d.r rVarC = zVar.c();
        ArrayList arrayList = new ArrayList(rVarC.a() + 5);
        arrayList.add(new d.a.a.f(d.a.a.f.f6002b, zVar.b()));
        arrayList.add(new d.a.a.f(d.a.a.f.f6003c, m.a(zVar.a())));
        arrayList.add(new d.a.a.f(d.a.a.f.g, "HTTP/1.1"));
        arrayList.add(new d.a.a.f(d.a.a.f.f6006f, d.a.j.a(zVar.a(), false)));
        arrayList.add(new d.a.a.f(d.a.a.f.f6004d, zVar.a().b()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int iA = rVarC.a();
        for (int i2 = 0; i2 < iA; i2++) {
            e.f fVarA = e.f.a(rVarC.a(i2).toLowerCase(Locale.US));
            if (!i.contains(fVarA)) {
                String strB = rVarC.b(i2);
                if (linkedHashSet.add(fVarA)) {
                    arrayList.add(new d.a.a.f(fVarA, strB));
                } else {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (((d.a.a.f) arrayList.get(i3)).h.equals(fVarA)) {
                            arrayList.set(i3, new d.a.a.f(fVarA, a(((d.a.a.f) arrayList.get(i3)).i.a(), strB)));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<d.a.a.f> c(z zVar) {
        d.r rVarC = zVar.c();
        ArrayList arrayList = new ArrayList(rVarC.a() + 4);
        arrayList.add(new d.a.a.f(d.a.a.f.f6002b, zVar.b()));
        arrayList.add(new d.a.a.f(d.a.a.f.f6003c, m.a(zVar.a())));
        arrayList.add(new d.a.a.f(d.a.a.f.f6005e, d.a.j.a(zVar.a(), false)));
        arrayList.add(new d.a.a.f(d.a.a.f.f6004d, zVar.a().b()));
        int iA = rVarC.a();
        for (int i2 = 0; i2 < iA; i2++) {
            e.f fVarA = e.f.a(rVarC.a(i2).toLowerCase(Locale.US));
            if (!k.contains(fVarA)) {
                arrayList.add(new d.a.a.f(fVarA, rVarC.b(i2)));
            }
        }
        return arrayList;
    }

    @Override // d.a.b.i
    public ac a(ab abVar) throws IOException {
        return new k(abVar.g(), e.n.a(new a(this.p.g())));
    }

    @Override // d.a.b.i
    public s a(z zVar, long j2) throws IOException {
        return this.p.h();
    }

    @Override // d.a.b.i
    public void a() {
        if (this.p != null) {
            this.p.b(d.a.a.a.CANCEL);
        }
    }

    @Override // d.a.b.i
    public void a(g gVar) {
        this.o = gVar;
    }

    @Override // d.a.b.i
    public void a(n nVar) throws IOException {
        nVar.a(this.p.h());
    }

    @Override // d.a.b.i
    public void a(z zVar) throws IOException {
        if (this.p != null) {
            return;
        }
        this.o.b();
        this.p = this.n.a(this.n.a() == x.HTTP_2 ? c(zVar) : b(zVar), this.o.a(zVar), true);
        this.p.e().a(this.o.f6138a.b(), TimeUnit.MILLISECONDS);
        this.p.f().a(this.o.f6138a.c(), TimeUnit.MILLISECONDS);
    }

    @Override // d.a.b.i
    public ab.a b() throws IOException {
        return this.n.a() == x.HTTP_2 ? b(this.p.d()) : a(this.p.d());
    }

    @Override // d.a.b.i
    public void c() throws IOException {
        this.p.h().close();
    }
}
