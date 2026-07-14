package d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p extends aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final u f6341a = u.a("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f6342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f6343c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f6344a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f6345b = new ArrayList();

        public a a(String str, String str2) {
            this.f6344a.add(s.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f6345b.add(s.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public p a() {
            return new p(this.f6344a, this.f6345b);
        }

        public a b(String str, String str2) {
            this.f6344a.add(s.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f6345b.add(s.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    private p(List<String> list, List<String> list2) {
        this.f6342b = d.a.j.a(list);
        this.f6343c = d.a.j.a(list2);
    }

    private long a(e.d dVar, boolean z) {
        long jB = 0;
        e.c cVar = z ? new e.c() : dVar.c();
        int size = this.f6342b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cVar.j(38);
            }
            cVar.b(this.f6342b.get(i));
            cVar.j(61);
            cVar.b(this.f6343c.get(i));
        }
        if (z) {
            jB = cVar.b();
            cVar.u();
        }
        return jB;
    }

    @Override // d.aa
    public u a() {
        return f6341a;
    }

    @Override // d.aa
    public void a(e.d dVar) throws IOException {
        a(dVar, false);
    }

    @Override // d.aa
    public long b() {
        return a((e.d) null, true);
    }
}
